/**
 * 
 */
package org.js.model.feature.csp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.AttributeConstraint;
import org.js.model.feature.AttributeOperand;
import org.js.model.feature.AttributeReference;
import org.js.model.feature.AttributeValue;
import org.js.model.feature.DiscreteDomain;
import org.js.model.feature.Domain;
import org.js.model.feature.DomainValue;
import org.js.model.feature.Exclude;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureConstraint;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.FeatureState;
import org.js.model.feature.Group;
import org.js.model.feature.Imply;
import org.js.model.feature.Interval;
import org.js.model.feature.NumericalDomain;
import org.js.model.feature.Relop;
import org.js.model.feature.edit.FeatureModelHelper;

import choco.Choco;
import choco.cp.model.CPModel;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.integer.IntegerExpressionVariable;
import choco.kernel.model.variables.integer.IntegerVariable;

/**
 * Class to translate an attributed group cardinality based feature model into a constraint satisfaction problem.
 * 
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class TranslateFM2CSP {

   private static Logger log = Logger.getLogger(TranslateFM2CSP.class);
   public static String attributeDelimiter = "~";
   public static String attributeValue = "value";
   public static String attributeEnablement = "enablement";
   public static int attributeDisabled = -1;

   private CPModel cspModel;
   private Map<String, IntegerVariable> nodeVariables = new HashMap<String, IntegerVariable>();

   private Map<String, int[]> discreteDomainValues = new HashMap<String, int[]>();

   public CPModel getModel() {
      if (cspModel == null) {
         cspModel = new CPModel();
      }
      return cspModel;
   }

   /**
    * Transform a cardinality-based feature model into a constraint model.
    * 
    * @param featuremodel
    */
   public Model getCSPModel(FeatureModel featuremodel) {
      Feature rootFeature = featuremodel.getRoot();
      // according to Benavides2005 transform fm into csp model
      transformFeature(rootFeature);

      transformConstraints(featuremodel);
      return cspModel;
   }

   private void transformFeature(Feature feature) {
      createFeatureConstraint(feature);
      EList<Group> groups = feature.getGroups();
      for (Group group : groups) {
         transformGroup(group);
      }

      EList<Attribute> attributes = feature.getAttributes();
      for (Attribute attribute : attributes) {
         transformAttribute(attribute);
         // createAbstractAttributeConstraint(attribute);
      }
   }

   private void transformAttribute(Attribute attribute) {
      // 0: attribute is disabled if feature is disabled
      // 1: attribute is enabled if feature is selected
      IntegerVariable featureVariable = getOrCreateVariable(attribute.getFeature());

      Constraint memberConstraint = getMemberConstraint(attribute);

      // if feature is enabled, then attribute value must be in bounds
      Constraint featureEnabled = Choco.eq(featureVariable, 1);
      Constraint checkAttribute = Choco.implies(featureEnabled, memberConstraint);
      getModel().addConstraint(checkAttribute);

      IntegerVariable attributeVariable = getOrCreateVariable(attribute);

      Constraint featureDisabled = Choco.eq(featureVariable, 0);
      Constraint attrDisabled = Choco.eq(attributeVariable, attributeDisabled);

      Constraint disabledAttr = Choco.ifOnlyIf(featureDisabled, attrDisabled);
      getModel().addConstraint(disabledAttr);
   }

   private Constraint getMemberConstraint(Attribute attribute) {
      Constraint memberConstraint = null;

      IntegerVariable attributeValueVariable = getOrCreateVariable(attribute);

      // if attribute value is set, then the according attribute value must be
      // set
      if (FeatureModelHelper.isAttributeValueSet(attribute)) {
         int value = FeatureModelHelper.getAttributeValue(attribute);
         memberConstraint = Choco.eq(value, attributeValueVariable);
      } else {
         // check domain values
         Domain domain = attribute.getDomain();

         if (domain instanceof NumericalDomain) {
            NumericalDomain numericalDomain = (NumericalDomain) domain;
            // value of attribute must be in one of the intervals.
            int[] values = getNumericalValues(numericalDomain, attribute);
            memberConstraint = Choco.member(attributeValueVariable, values);

         } else if (domain instanceof DiscreteDomain) {
            DiscreteDomain discreteDomain = (DiscreteDomain) domain;
            int[] domainValues = discreteDomainValues.get(discreteDomain.getId());
            memberConstraint = Choco.member(attributeValueVariable, domainValues);
         }
      }
      return memberConstraint;
   }

   private int[] getNumericalValues(NumericalDomain numericalDomain, Attribute attribute) {
      EList<Interval> intervals = numericalDomain.getIntervals();
      Set<Integer> domainValues = new HashSet<Integer>();
      for (Interval interval : intervals) {
         int lowerBound = interval.getLowerBound();
         int upperBound = interval.getUpperBound();

         int diff = upperBound - lowerBound;
         int current = lowerBound;
         for (int i = 0; i <= diff; i++) {
            domainValues.add(Integer.valueOf(current));
            current++;
         }
      }

      // remove deselected domain values
      removeDeselectedDomainValues(attribute, domainValues);

      int[] values = new int[domainValues.size()];
      int i = 0;
      for (Integer v : domainValues) {
         values[i++] = v.intValue();
      }
      return values;
   }

   private String concatenate(String[] strings, String delimiter) {
      StringBuffer buffer = new StringBuffer();
      for (int i = 0; i < strings.length; i++) {
         String string = strings[i];
         if (buffer.length() > 0) {
            buffer.append(delimiter);
         }
         buffer.append(string);
      }
      return buffer.toString();
   }

   private IntegerVariable getOrCreateVariable(Attribute attribute) {
      String attributeName = attribute.getName();
      String featureId = attribute.getFeature().getId();
      String identifier = attributeValue;

      String[] parts = new String[] {
            identifier, featureId, attributeName };

      String attributeId = concatenate(parts, attributeDelimiter);

      IntegerVariable integerVariable = nodeVariables.get(attributeId);
      if (integerVariable == null) {
         integerVariable = createAttributeValueVariable(attribute, attributeId);
         nodeVariables.put(attributeId, integerVariable);
      }
      return integerVariable;
   }

   private IntegerVariable createAttributeValueVariable(Attribute attribute, String attributeId) {
      // String attrOptions = "cp:no_decision";
      String attrOptions = "";
      IntegerVariable attributeVariable = null;

      // (1) if attribute value is set, then attribute can either be this value or the disabled attribute value
      if (FeatureModelHelper.isAttributeValueSet(attribute)) {
         int value = FeatureModelHelper.getAttributeValue(attribute);
         int[] attributeValues = new int[] {
               value, attributeDisabled };
         attributeVariable = Choco.makeIntVar(attributeId, attributeValues, attrOptions);
      } else {

         Domain attributeDomain = attribute.getDomain();

         // (2) if attribute domain is discrete
         if (attributeDomain instanceof DiscreteDomain) {
            DiscreteDomain discreteDomain = (DiscreteDomain) attributeDomain;
            int[] domainValues = getDomainValues(attribute, discreteDomain);
            attributeVariable = Choco.makeIntVar(attributeId, domainValues, attrOptions);

            // todo: check numerical domain and use intervals instead
            // (3) if attribute domain is integer
         } else if (attributeDomain instanceof NumericalDomain) {
            NumericalDomain numericalDomain = (NumericalDomain) attributeDomain;
            int lowestBoundofNumericalDomain = getLowestBoundofNumericalDomain(numericalDomain);
            int highestBoundofNumericalDomain = getHighestBoundofNumericalDomain(numericalDomain);
            if (lowestBoundofNumericalDomain > attributeDisabled) {
               lowestBoundofNumericalDomain = attributeDisabled;
            }
            attributeVariable = Choco.makeIntVar(attributeId, lowestBoundofNumericalDomain, highestBoundofNumericalDomain, attrOptions);
         }
      }
      return attributeVariable;
   }

   private void removeDeselectedDomainValues(Attribute attribute, Set<Integer> values) {
      EList<String> deselectedDomainValues = attribute.getDeselectedDomainValues();
      Domain domain = attribute.getDomain();
      for (String valueString : deselectedDomainValues) {
         int deselectedValue = FeatureModelHelper.getDomainValueForString(valueString, domain);
         Integer deselected = Integer.valueOf(deselectedValue);
         values.remove(deselected);
      }
   }

   private int[] getDomainValues(Attribute attribute, DiscreteDomain discreteDomain) {
      int[] domainValues = getOrCreateDomainValues(discreteDomain);
      Set<Integer> values = new HashSet<Integer>(domainValues.length);
      for (int i = 0; i < domainValues.length; i++) {
         values.add(Integer.valueOf(domainValues[i]));
      }
      // if domain values are deselected, remove them from domain array
      removeDeselectedDomainValues(attribute, values);
      // insert Integer representing disabled attribute
      values.add(attributeDisabled);

      // convert arraylist back to array
      domainValues = new int[values.size()];
      int i = 0;
      for (Integer v : values) {
         domainValues[i++] = v.intValue();
      }
      return domainValues;
   }

   private void transformGroup(Group group) {
      createGroupConstraint(group);
      EList<Feature> childFeatures = group.getChildFeatures();
      for (Feature feature : childFeatures) {
         transformFeature(feature);
      }
   }

   private void transformConstraints(FeatureModel model) {
      EList<org.js.model.feature.Constraint> constraints = model.getConstraints();
      for (org.js.model.feature.Constraint constraint : constraints) {
         Constraint chocoConstraint = createCrossTreeConstraint(constraint);
         if (chocoConstraint != null) {
            getModel().addConstraint(chocoConstraint);
         }
      }
   }

   private Constraint createFeatureConstraint(FeatureConstraint featureConstraint) {
      Constraint result = null;
      Feature leftFeature = featureConstraint.getLeftOperand();
      Feature rightFeature = featureConstraint.getRightOperand();
      if (featureConstraint instanceof Imply) {
         result = createRequiresConstraint(leftFeature, rightFeature);
      } else if (featureConstraint instanceof Exclude) {
         result = createExcludesConstraint(leftFeature, rightFeature);
      }
      return result;
   }

   private Constraint createAttributeConstraint(AttributeConstraint attributeConstraint) {
      Constraint result = null;

      Constraint constraint = null;
      AttributeOperand leftOperand = attributeConstraint.getLeftOperand();
      IntegerVariable leftOperandVariable = getVariableForAttributeOperand(leftOperand);

      AttributeOperand rightOperand = attributeConstraint.getRightOperand();
      IntegerVariable rightOperandVariable = getVariableForAttributeOperand(rightOperand);

      Relop operator = attributeConstraint.getOperator();
      switch (operator) {
         case EQUAL:
            constraint = Choco.eq(leftOperandVariable, rightOperandVariable);
            break;
         case GREATER_THAN:
            constraint = Choco.gt(leftOperandVariable, rightOperandVariable);
            break;
         case GREATER_THAN_OR_EQUAL:
            constraint = Choco.geq(leftOperandVariable, rightOperandVariable);
            break;
         case LESS_THAN:
            constraint = Choco.lt(leftOperandVariable, rightOperandVariable);
            break;
         case LESS_THAN_OR_EQUAL:
            constraint = Choco.leq(leftOperandVariable, rightOperandVariable);
            break;
         case UNEQUAL:
            constraint = Choco.neq(leftOperandVariable, rightOperandVariable);
            break;
         default:
            break;
      }

      IntegerVariable leftFeatureVariable = getFeatureVariableForOperand(leftOperand);
      IntegerVariable rightFeatureVariable = getFeatureVariableForOperand(rightOperand);
      // if both are features and both are selected, then the attribute constraint must be evaluated
      if (leftFeatureVariable != null && rightFeatureVariable != null) {
         Constraint leftFeatureSelected = Choco.eq(leftFeatureVariable, 1);
         Constraint rightFeatureSelected = Choco.eq(rightFeatureVariable, 1);
         Constraint and = Choco.and(leftFeatureSelected, rightFeatureSelected);
         result = Choco.implies(and, constraint);
      } else {
         // if one of the two operand is a constant,the constraint will be evaluated if the host feature is selected
         if (leftFeatureVariable != null){
            result = getFeatureAttributeValueConstraint(leftFeatureVariable, constraint);
         } else if (rightFeatureVariable != null){
            result = getFeatureAttributeValueConstraint(rightFeatureVariable, constraint);
         }
      }

      return result;
   }
   
   private Constraint getFeatureAttributeValueConstraint(IntegerVariable featureVariable, Constraint valueConstraint){
      Constraint result = null;
      Constraint featureSelected = Choco.eq(featureVariable, 1);
      Constraint implies = Choco.implies(featureSelected, valueConstraint);
      result = Choco.implies(featureSelected, implies);
      
      return result;
   }

   private IntegerVariable getFeatureVariableForOperand(AttributeOperand operand) {
      IntegerVariable variable = null;
      Feature feature = FeatureModelHelper.getAttributeOperandFeature(operand);
      if (feature != null) {
         variable = getOrCreateVariable(feature);
      }
      return variable;
   }

   private Constraint createCrossTreeConstraint(org.js.model.feature.Constraint constraint) {
      Constraint result = null;
      if (constraint instanceof FeatureConstraint) {
         FeatureConstraint featureConstraint = (FeatureConstraint) constraint;
         result = createFeatureConstraint(featureConstraint);
      } else if (constraint instanceof AttributeConstraint) {
         AttributeConstraint attributeConstraint = (AttributeConstraint) constraint;
         result = createAttributeConstraint(attributeConstraint);
      }
      return result;
   }

   private IntegerVariable getVariableForAttributeOperand(AttributeOperand operand) {
      IntegerVariable variable = null;
      if (operand instanceof AttributeReference) {
         AttributeReference attRef = (AttributeReference) operand;
         Attribute attribute = attRef.getAttribute();
         variable = getOrCreateVariable(attribute);
      } else if (operand instanceof AttributeValue) {
         AttributeValue value = (AttributeValue) operand;
         int valueInt = value.getInt();
         String valueName = value.getName();
         if (valueName != null && valueName.length() > 0) {
            AttributeOperand other = getOtherOperand(operand);
            if (other instanceof AttributeReference) {
               AttributeReference attRef = (AttributeReference) other;
               Domain domain = attRef.getAttribute().getDomain();
               if (domain instanceof DiscreteDomain) {
                  DiscreteDomain discreteDomain = (DiscreteDomain) domain;
                  EList<DomainValue> values = discreteDomain.getValues();
                  for (DomainValue domainValue : values) {
                     String name = domainValue.getName();
                     if (valueName.equals(name)) {
                        valueInt = domainValue.getInt();
                        break;
                     }
                  }
               } else if (domain instanceof NumericalDomain) {
                  valueInt = Integer.decode(valueName);
               }
            }
         }
         variable = Choco.constant(valueInt);
      }
      return variable;
   }

   private AttributeOperand getOtherOperand(AttributeOperand operand) {
      AttributeOperand other = null;
      EObject container = operand.eContainer();
      if (container instanceof AttributeConstraint) {
         AttributeConstraint attConstraint = (AttributeConstraint) container;
         AttributeOperand leftOperand = attConstraint.getLeftOperand();
         AttributeOperand rightOperand = attConstraint.getRightOperand();
         if (EcoreUtil.equals(operand, leftOperand)) {
            other = rightOperand;
         } else {
            other = leftOperand;
         }
      }
      return other;
   }

   private Constraint createExcludesConstraint(Feature lf, Feature rf) {
      IntegerVariable leftFeature = getOrCreateVariable(lf);
      IntegerVariable rightFeature = getOrCreateVariable(rf);

      Constraint leftSelected = Choco.gt(leftFeature, 0);
      Constraint rightNotSelected = Choco.eq(rightFeature, 0);
      Constraint leftRight = Choco.implies(leftSelected, rightNotSelected);

      Constraint rightSelected = Choco.gt(rightFeature, 0);
      Constraint leftNotSelected = Choco.eq(leftFeature, 0);
      Constraint rightLeft = Choco.implies(rightSelected, leftNotSelected);

      Constraint excludeConstraint = Choco.or(leftRight, rightLeft);
      return excludeConstraint;
   }

   private Constraint createRequiresConstraint(Feature lf, Feature rf) {
      IntegerVariable leftFeature = getOrCreateVariable(lf);
      IntegerVariable rightFeature = getOrCreateVariable(rf);
      Constraint leftConstraint = Choco.gt(leftFeature, 0);
      Constraint rightConstraint = Choco.gt(rightFeature, 0);
      Constraint impliesConstraint = Choco.implies(leftConstraint, rightConstraint);
      return impliesConstraint;
   }

   private void createFeatureConstraint(Feature feature) {
      IntegerVariable childVariable = getOrCreateVariable(feature);

      int minCardinality = 0;
      int maxCardinality = 1;

      Constraint greaterThan = Choco.geq(childVariable, minCardinality);
      Constraint smallerThan = Choco.leq(childVariable, maxCardinality);
      Constraint thenConstraint = Choco.and(greaterThan, smallerThan);

      EObject featureContainer = feature.eContainer();
      if (featureContainer instanceof Group) {
         Group parentGroup = (Group) featureContainer;

         EObject groupContainer = parentGroup.eContainer();
         if (groupContainer instanceof Feature) {
            Feature parentFeature = (Feature) groupContainer;

            IntegerVariable parentVariable = getOrCreateVariable(parentFeature);

            // feature value must be in feature cardinality boundaries
            Constraint parentSelected = Choco.gt(parentVariable, 0);
            Constraint parentSelectedAndChildCardinality = Choco.implies(parentSelected, thenConstraint);
            getModel().addConstraint(parentSelectedAndChildCardinality);

            Constraint childSelected = Choco.gt(childVariable, 0);
            Constraint impliesConstraint = Choco.implies(childSelected, parentSelected);
            getModel().addConstraint(impliesConstraint);
         }

      } else {
         // handle rootgroup
         Constraint greater = Choco.gt(childVariable, minCardinality);
         getModel().addConstraint(greater);
      }

   }

   private void createGroupConstraint(Group group) {
      // group with cardinality {n,m} represented as
      // ifThen(ParentFeature>0;sum(ChildFeature A, ChildFeature
      // B) in {n,m};)
      // if group cardinality is n=m, then
      // ifThen(ParentFeature>0;sum(ChildFeature A, ChildFeature B) = n)
      log.debug("Create constraint for group " + group);
      IntegerVariable parentFeatureVariable = getOrCreateVariable((Feature) group.eContainer());

      IntegerExpressionVariable childFeatureSum = createChildFeatureVariable(group);
      int minCardinality = getMinChocoCardinality(group);
      int maxCardinality = getMaxChocoCardinality(group);

      Constraint ifConstraint = Choco.gt(parentFeatureVariable, 0);

      Constraint greaterThan = Choco.geq(childFeatureSum, minCardinality);
      Constraint smallerThan = Choco.leq(childFeatureSum, maxCardinality);

      Constraint thenConstraint = Choco.and(greaterThan, smallerThan);

      Constraint groupCardinalityConstraint = Choco.implies(ifConstraint, thenConstraint);
      getModel().addConstraint(groupCardinalityConstraint);
   }

   private int getMaxChocoCardinality(Group group) {
      int maxCardinality = group.getMaxCardinality();
      int cardinality = maxCardinality;
      if (maxCardinality == -1) {
         // cardinality = Choco.MAX_UPPER_BOUND;
         cardinality = group.getChildFeatures().size();
      }
      return cardinality;
   }

   private int getMinChocoCardinality(Group group) {
      return group.getMinCardinality();
   }

   private IntegerVariable getOrCreateVariable(Feature feature) {
      String id = EcoreUtil.getID(feature);
      IntegerVariable integerVariable = nodeVariables.get(id);
      if (integerVariable == null) {
         integerVariable = createFeatureVariable(feature);
      }
      return integerVariable;
   }

   private int getLowestBoundofNumericalDomain(NumericalDomain domain) {
      int lowestbound = 0;
      EList<Interval> intervals = domain.getIntervals();
      if (intervals.size() >= 1) {
         lowestbound = intervals.get(0).getLowerBound();
         for (Interval interval : intervals) {
            int lowerBound = interval.getLowerBound();
            if (lowerBound < lowestbound) {
               lowestbound = lowerBound;
            }
         }
      }
      return lowestbound;
   }

   private int getHighestBoundofNumericalDomain(NumericalDomain domain) {
      int highestBound = 0;
      EList<Interval> intervals = domain.getIntervals();
      if (intervals.size() >= 1) {
         highestBound = intervals.get(0).getUpperBound();
         for (Interval interval : intervals) {
            int higherBound = interval.getUpperBound();
            if (higherBound > highestBound) {
               highestBound = higherBound;
            }
         }
      }
      return highestBound;
   }

   private int[] getOrCreateDomainValues(DiscreteDomain domain) {
      String id = domain.getId();
      int[] values = discreteDomainValues.get(id);
      if (values == null) {
         values = initDomainValues(domain);
         discreteDomainValues.put(id, values);
      }
      return values;
   }

   private int[] initDomainValues(DiscreteDomain domain) {
      EList<DomainValue> values = domain.getValues();
      int[] valueArray = new int[values.size()];
      Iterator<DomainValue> iterator = values.iterator();
      for (int i = 0; i < valueArray.length; i++) {
         valueArray[i] = iterator.next().getInt();
      }
      return valueArray;
   }

   private IntegerVariable createFeatureVariable(Feature feature) {
      String id = feature.getId();
      // an unbound feature has cardinality [0..1],
      // a selected feature has cardinality [1..1],
      // a deselected feature has cardinality [0..0]
      int minCardinality = (FeatureState.SELECTED.equals(feature.getConfigurationState())) ? 1 : 0;
      int maxCardinality = (FeatureState.DESELECTED.equals(feature.getConfigurationState())) ? 0 : 1;

      log.debug("Create IntegerVariable for '" + id + "' [" + minCardinality + "," + maxCardinality + "].");
      IntegerVariable intNodeVariable = Choco.makeIntVar(id, minCardinality, maxCardinality);
      getModel().addVariable(intNodeVariable);
      nodeVariables.put(id, intNodeVariable);
      return intNodeVariable;
   }

   private IntegerExpressionVariable createChildFeatureVariable(Group group) {
      EList<Feature> childFeatures = group.getChildFeatures();
      List<IntegerVariable> childFeatureVariables = new ArrayList<IntegerVariable>(childFeatures.size());
      for (Feature feature : childFeatures) {
         IntegerVariable childFeatureVariable = getOrCreateVariable(feature);
         childFeatureVariables.add(childFeatureVariable);
      }
      IntegerVariable[] childFeatureVariablesArray = new IntegerVariable[childFeatureVariables.size()];
      childFeatureVariablesArray = childFeatureVariables.toArray(childFeatureVariablesArray);

      IntegerExpressionVariable childFeatureSum = Choco.sum(childFeatureVariablesArray);
      log.debug("Create IntegerExpressionVariable for child features of group " + group);
      return childFeatureSum;
   }

}
