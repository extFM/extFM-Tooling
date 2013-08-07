/**
 * 
 */
package org.js.model.feature.csp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import choco.Choco;
import choco.cp.model.CPModel;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.integer.IntegerExpressionVariable;
import choco.kernel.model.variables.integer.IntegerVariable;

/**
 * Class to translate an attributed group cardinality based feature model into a
 * constraint satisfaction problem.
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
		IntegerVariable featureVariable = getOrCreateVariable(attribute
				.getFeature());
		IntegerVariable attributeEnablementVariable = getOrCreateVariable(
				attribute, false);

		Constraint attributeEnablementConstraint = Choco.eq(featureVariable,
				attributeEnablementVariable);
		getModel().addConstraint(attributeEnablementConstraint);

		Constraint memberConstraint = getMemberConstraint(attribute);

		// if attribute is enabled, then attribute value must be in bounds
		Constraint attributeEnabled = Choco.eq(attributeEnablementVariable, 1);
		Constraint checkAttribute = Choco.ifOnlyIf(attributeEnabled,
				memberConstraint);
		getModel().addConstraint(checkAttribute);
		getModel().addConstraint(memberConstraint);
	}

	private Constraint getMemberConstraint(Attribute attribute) {
		Constraint memberConstraint = null;

		IntegerVariable attributeValueVariable = getOrCreateVariable(attribute,
				true);

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
				EList<Interval> intervals = numericalDomain.getIntervals();
				List<Constraint> memberConstraints = new ArrayList<Constraint>();
				for (Interval interval : intervals) {
					int lowerBound = interval.getLowerBound();
					int upperBound = interval.getUpperBound();
					Constraint member = Choco.member(attributeValueVariable,
							lowerBound, upperBound);
					memberConstraints.add(member);
				}
				memberConstraint = Choco.or((Constraint[]) memberConstraints
						.toArray(new Constraint[memberConstraints.size()]));
			} else if (domain instanceof DiscreteDomain) {
				DiscreteDomain discreteDomain = (DiscreteDomain) domain;
				int[] domainValues = discreteDomainValues.get(discreteDomain
						.getId());
				memberConstraint = Choco.member(attributeValueVariable,
						domainValues);
			}
		}
		return memberConstraint;
	}

	// private IntegerExpressionVariable createChildAttributeVariable(Attribute
	// a) {
	// int cachedAttributeValue = -1;
	// boolean isAttributeSet = FeatureModelHelper.isAttributeValueSet(a);
	// if (isAttributeSet) {
	// cachedAttributeValue = FeatureModelHelper
	// .getAttributeValueForString(a.getValue(), a);
	// }
	// IntegerExpressionVariable childValuesSum = null;
	// Domain domain = a.getDomain();
	// if (domain instanceof NumericalDomain) {
	// NumericalDomain numericalDomain = (NumericalDomain) domain;
	//
	// // value of attribute must be in one of the intervals.
	// EList<Interval> intervals = numericalDomain.getIntervals();
	// for (Interval interval : intervals) {
	// int lowerBound = interval.getLowerBound();
	// int upperBound = interval.getUpperBound();
	// }
	// } else if (domain instanceof DiscreteDomain) {
	// DiscreteDomain discreteDomain = (DiscreteDomain) domain;
	// int[] domainValues = getOrCreateDomainValues(discreteDomain);
	// String featureId = a.getFeature().getId();
	// String attName = a.getName();
	//
	// List<IntegerVariable> attributeValueVariables = new
	// ArrayList<IntegerVariable>(
	// domainValues.length);
	// for (int i = 0; i < domainValues.length; i++) {
	// int j = domainValues[i];
	// String value = Integer.toString(j);
	// String variableId = concatenate(new String[] { attributeValue,
	// featureId, attName, value }, attributeDelimiter);
	// // representation of attribute as abstract feature
	// IntegerVariable domainvaluevariable = Choco
	// .makeBooleanVar(variableId);
	// getModel().addVariable(domainvaluevariable);
	//
	// if (isAttributeSet) {
	// if (cachedAttributeValue == j) {
	// Constraint domainValueSelected = Choco.eq(
	// domainvaluevariable, 1);
	// getModel().addConstraint(domainValueSelected);
	// }
	// }
	// // set attribute value to variable if already defined
	//
	// attributeValueVariables.add(domainvaluevariable);
	// }
	// IntegerVariable[] attributeVariablesArray = new
	// IntegerVariable[attributeValueVariables
	// .size()];
	// attributeVariablesArray = attributeValueVariables
	// .toArray(attributeVariablesArray);
	//
	// childValuesSum = Choco.sum(attributeVariablesArray);
	// }
	// return childValuesSum;
	// }

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

	private IntegerVariable getOrCreateVariable(Attribute attribute,
			boolean isValue) {
		String attributeName = attribute.getName();
		String featureId = attribute.getFeature().getId();
		String identifier = isValue ? attributeValue : attributeEnablement;

		String[] parts = new String[] { identifier, featureId, attributeName };

		String attributeId = concatenate(parts, attributeDelimiter);

		IntegerVariable integerVariable = nodeVariables.get(attributeId);
		if (integerVariable == null) {
			integerVariable = isValue ? createAttributeValueVariable(attribute,
					attributeId, false)
					: createAttributeEnableVariable(attributeId);
			nodeVariables.put(attributeId, integerVariable);
		}
		return integerVariable;
	}

	private IntegerVariable createAttributeEnableVariable(String attributeId) {
		String attrOptions = "";
		return Choco.makeBooleanVar(attributeId, attrOptions);
	}

	private IntegerVariable createAttributeValueVariable(Attribute attribute,
			String attributeId, boolean addDisableInteger) {
		// String attrOptions = "cp:no_decision";
		String attrOptions = "";

		Domain attributeDomain = attribute.getDomain();
		IntegerVariable attributeVariable = null;

		// (1) if attribute domain is discrete
		if (attributeDomain instanceof DiscreteDomain) {
			DiscreteDomain discreteDomain = (DiscreteDomain) attributeDomain;
			int[] domainValues = getOrCreateDomainValues(discreteDomain);
			if (addDisableInteger) {
				int[] copy = new int[domainValues.length + 1];
				for (int i = 0; i < domainValues.length; i++) {
					copy[i] = domainValues[i];
				}
				copy[domainValues.length] = attributeDisabled;
				domainValues = copy;

			}
			attributeVariable = Choco.makeIntVar(attributeId, domainValues,
					attrOptions);

			// (2) if attribute domain is integer
		} else if (attributeDomain instanceof NumericalDomain) {
			NumericalDomain numericalDomain = (NumericalDomain) attributeDomain;
			int lowestBoundofNumericalDomain = getLowestBoundofNumericalDomain(numericalDomain);
			int highestBoundofNumericalDomain = getHighestBoundofNumericalDomain(numericalDomain);
			if (addDisableInteger
					&& lowestBoundofNumericalDomain > attributeDisabled) {
				lowestBoundofNumericalDomain = attributeDisabled;
			}
			attributeVariable = Choco.makeIntVar(attributeId,
					lowestBoundofNumericalDomain,
					highestBoundofNumericalDomain, attrOptions);
		}
		return attributeVariable;
	}


	private void transformGroup(Group group) {
		createGroupConstraint(group);
		EList<Feature> childFeatures = group.getChildFeatures();
		for (Feature feature : childFeatures) {
			transformFeature(feature);
		}
	}

	private void transformConstraints(FeatureModel model) {
		EList<org.js.model.feature.Constraint> constraints = model
				.getConstraints();
		for (org.js.model.feature.Constraint constraint : constraints) {
			Constraint chocoConstraint = createCrossTreeConstraint(constraint);
			getModel().addConstraint(chocoConstraint);
		}
	}

	private Constraint createCrossTreeConstraint(
			org.js.model.feature.Constraint constraint) {
		Constraint result = null;
		if (constraint instanceof FeatureConstraint) {
			FeatureConstraint featureConstraint = (FeatureConstraint) constraint;
			Feature leftFeature = featureConstraint.getLeftOperand();
			Feature rightFeature = featureConstraint.getRightOperand();
			if (constraint instanceof Imply) {
				result = createRequiresConstraint(leftFeature, rightFeature);
			} else if (constraint instanceof Exclude) {
				result = createExcludesConstraint(leftFeature, rightFeature);
			}
		} else if (constraint instanceof AttributeConstraint) {
			AttributeConstraint attributeConstraint = (AttributeConstraint) constraint;
			AttributeOperand leftOperand = attributeConstraint.getAttribute1();
			IntegerVariable leftOperandVariable = getVariableForAttributeOperand(leftOperand);

			AttributeOperand rightOperand = attributeConstraint.getAttribute2();
			IntegerVariable rightOperandVariable = getVariableForAttributeOperand(rightOperand);

			Relop operator = attributeConstraint.getOperator();
			switch (operator) {
			case EQUAL:
				result = Choco.eq(leftOperandVariable, rightOperandVariable);
				break;
			case GREATER_THAN:
				result = Choco.gt(leftOperandVariable, rightOperandVariable);
				break;
			case GREATER_THAN_OR_EQUAL:
				result = Choco.geq(leftOperandVariable, rightOperandVariable);
				break;
			case LESS_THAN:
				result = Choco.lt(leftOperandVariable, rightOperandVariable);
				break;
			case LESS_THAN_OR_EQUAL:
				result = Choco.leq(leftOperandVariable, rightOperandVariable);
				break;
			case UNEQUAL:
				result = Choco.neq(leftOperandVariable, rightOperandVariable);
				break;
			default:
				break;
			}
		}
		return result;
	}

	private IntegerVariable getVariableForAttributeOperand(
			AttributeOperand operand) {
		IntegerVariable variable = null;
		if (operand instanceof AttributeReference) {
			AttributeReference attRef = (AttributeReference) operand;
			Attribute attribute = attRef.getAttribute();
			variable = getOrCreateVariable(attribute, true);
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
			AttributeOperand attribute1 = attConstraint.getAttribute1();
			AttributeOperand attribute2 = attConstraint.getAttribute2();
			if (EcoreUtil.equals(operand, attribute1)) {
				other = attribute2;
			} else {
				other = attribute1;
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
		Constraint impliesConstraint = Choco.implies(leftConstraint,
				rightConstraint);
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
				Constraint parentSelectedAndChildCardinality = Choco.implies(
						parentSelected, thenConstraint);
				getModel().addConstraint(parentSelectedAndChildCardinality);

				Constraint childSelected = Choco.gt(childVariable, 0);
				Constraint impliesConstraint = Choco.implies(childSelected,
						parentSelected);
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
		IntegerVariable parentFeatureVariable = getOrCreateVariable((Feature) group
				.eContainer());

		IntegerExpressionVariable childFeatureSum = createChildFeatureVariable(group);
		int minCardinality = getMinChocoCardinality(group);
		int maxCardinality = getMaxChocoCardinality(group);

		Constraint ifConstraint = Choco.gt(parentFeatureVariable, 0);

		Constraint greaterThan = Choco.geq(childFeatureSum, minCardinality);
		Constraint smallerThan = Choco.leq(childFeatureSum, maxCardinality);

		Constraint thenConstraint = Choco.and(greaterThan, smallerThan);

		Constraint groupCardinalityConstraint = Choco.implies(ifConstraint,
				thenConstraint);
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
		int minCardinality = (FeatureState.SELECTED.equals(feature
				.getConfigurationState())) ? 1 : 0;
		int maxCardinality = (FeatureState.DESELECTED.equals(feature
				.getConfigurationState())) ? 0 : 1;

		log.debug("Create IntegerVariable for '" + id + "' [" + minCardinality
				+ "," + maxCardinality + "].");
		IntegerVariable intNodeVariable = Choco.makeIntVar(id, minCardinality,
				maxCardinality);
		getModel().addVariable(intNodeVariable);
		nodeVariables.put(id, intNodeVariable);
		return intNodeVariable;
	}

	private IntegerExpressionVariable createChildFeatureVariable(Group group) {
		EList<Feature> childFeatures = group.getChildFeatures();
		List<IntegerVariable> childFeatureVariables = new ArrayList<IntegerVariable>(
				childFeatures.size());
		for (Feature feature : childFeatures) {
			IntegerVariable childFeatureVariable = getOrCreateVariable(feature);
			childFeatureVariables.add(childFeatureVariable);
		}
		IntegerVariable[] childFeatureVariablesArray = new IntegerVariable[childFeatureVariables
				.size()];
		childFeatureVariablesArray = childFeatureVariables
				.toArray(childFeatureVariablesArray);

		IntegerExpressionVariable childFeatureSum = Choco
				.sum(childFeatureVariablesArray);
		log.debug("Create IntegerExpressionVariable for child features of group "
				+ group);
		return childFeatureSum;
	}

}
