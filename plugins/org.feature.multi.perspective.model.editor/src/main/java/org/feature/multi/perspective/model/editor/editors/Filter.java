/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.utilities.FeatureModelInit;
import org.js.model.feature.Attribute;
import org.js.model.feature.AttributeConstraint;
import org.js.model.feature.AttributeOperand;
import org.js.model.feature.AttributeReference;
import org.js.model.feature.AttributeValue;
import org.js.model.feature.Constraint;
import org.js.model.feature.Exclude;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureConstraint;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.Group;
import org.js.model.feature.Imply;
import org.js.model.feature.Relop;
import org.js.model.feature.edit.FeatureModelHelper;

/**
 * @author winkelti
 * 
 */
public class Filter {

   FeatureModel newFeatureModel;
   private Map<String, Feature> featureMap;
   private FeatureModel orgFeatureModel;

   private static Logger log = Logger.getLogger(Filter.class);

   public Filter(FeatureModel org, Map<String, Feature> featureMap) {
      this.featureMap = featureMap;
      orgFeatureModel = org;
      Feature orgRoot = orgFeatureModel.getRoot();
      if (featureMap.containsKey(orgRoot.getId())) {
         newFeatureModel = EcoreUtil.copy(orgFeatureModel);
         newFeatureModel.setRoot(copyFeature(orgRoot, null));
         FeatureModelHelper helper = new FeatureModelHelper(newFeatureModel);
         assert (helper.getAllFeatures().size() == featureMap.size());
         EList<EAttribute> eAllAttributes = org.eClass().getEAllAttributes();
         for (EAttribute eAttribute : eAllAttributes) {
            newFeatureModel.eSet(eAttribute, org.eGet(eAttribute));
         }
         newFeatureModel.getConstraints().clear();
         // checkConstraints(orgFeatureModel.getConstraints(), fm.getAllFeatures());
         filterConstraints(orgFeatureModel);
      }
      // root feature not selected
   }

   private void filterConstraints(FeatureModel featureModel) {
      FeatureModelHelper helper = new FeatureModelHelper(featureModel);
      EList<Constraint> constraints = featureModel.getConstraints();
      for (Constraint constraint : constraints) {
         if (isRelevant(constraint)) {
            try {
               addConstraintToModel(constraint, helper.getAllFeatures());
            } catch (IOException e) {
               log.error("Error while printing expression." + e.getLocalizedMessage());
            }
         }
      }
   }

   /**
    * removes every constraints which contains features that are not in the new {@link FeatureModel}.
    * 
    * @param constraints
    * @param featureModelFeatures
    */
   private void addConstraintToModel(Constraint constraint, Set<Feature> newFeatures) throws IOException {
      Constraint copiedconstraint = copyConstraint(constraint, newFeatures);
      this.newFeatureModel.getConstraints().add(copiedconstraint);
   }

   private boolean isRelevant(Constraint constraint) {
      boolean relevant = true;
      Set<Feature> constrainedFeatures = FeatureModelHelper.getConstrainedFeatures(constraint);
      for (Feature feature : constrainedFeatures) {
         String id = feature.getId();
         relevant = this.featureMap.containsKey(id);
         if (!relevant) {
            break;
         }
      }
      return relevant;
   }

   private Constraint copyConstraint(Constraint origConstraint, Set<Feature> newFeatures) {
      Constraint copy = null;
      if (origConstraint instanceof FeatureConstraint) {
         FeatureConstraint featureConstraint = (FeatureConstraint) origConstraint;
         copy = copyFeatureConstraint(featureConstraint, newFeatures);
      } else if (origConstraint instanceof AttributeConstraint) {
         AttributeConstraint origAttributeConstraint = (AttributeConstraint) origConstraint;
         copy = copyAttributeConstraint(origAttributeConstraint, newFeatures);
      }
      return copy;
   }

   private Constraint copyAttributeConstraint(AttributeConstraint origAttributeConstraint, Set<Feature> newFeatures) {
      Constraint copy = null;
      AttributeOperand attribute1 = origAttributeConstraint.getAttribute1();
      AttributeOperand attribute2 = origAttributeConstraint.getAttribute2();

      AttributeOperand newLeft = copyAttributeOperand(attribute1);
      AttributeOperand newRight = copyAttributeOperand(attribute2);

      String id = origAttributeConstraint.getId();
      Relop operator = origAttributeConstraint.getOperator();
      copy = FeatureModelInit.createAttributeConstraint(newLeft, newRight, id, operator);

      return copy;
   }

   private AttributeOperand copyAttributeOperand(AttributeOperand attributeOperand) {
      AttributeOperand copy = null;
      if (attributeOperand instanceof AttributeReference) {
         AttributeReference attrReference = (AttributeReference) attributeOperand;
         Attribute attribute = attrReference.getAttribute();
         copy = FeatureModelInit.createAttibuteOperand(attribute);
      } else if (attributeOperand instanceof AttributeValue) {
         AttributeValue attrValue = (AttributeValue) attributeOperand;
         String value = attrValue.getName();
         int intValue = attrValue.getInt();
         copy = FeatureModelInit.createAttibuteOperand(value, intValue);
      }
      return copy;
   }

   private Constraint copyFeatureConstraint(FeatureConstraint featureConstraint, Set<Feature> newFeatures) {
      Constraint copy = null;
      Feature origLeft = featureConstraint.getLeftOperand();
      String origLeftFeatureId = origLeft.getId();
      Feature newLeft = getFeature(origLeftFeatureId, newFeatures);

      Feature origRight = featureConstraint.getRightOperand();
      String origRightFeatureId = origRight.getId();
      Feature newRight = getFeature(origRightFeatureId, newFeatures);

      String id = featureConstraint.getId();

      if (featureConstraint instanceof Imply) {
         copy = FeatureModelInit.createImplyConstraint(newLeft, newRight, id);
      } else if (featureConstraint instanceof Exclude) {
         copy = FeatureModelInit.createExcludeConstraint(newLeft, newRight, id);
      }
      return copy;
   }

   private Feature getFeature(String featureId, Set<Feature> features) {
      Feature result = null;
      for (Feature feature : features) {
         if (featureId.equals(feature.getId())) {
            result = feature;
            break;
         }
      }
      return result;
   }

   /**
    * 
    * @param orgFeature
    * @param parentGroup
    * @return
    */
   private Feature copyFeature(Feature orgFeature, Group parentGroup) {
      Feature feature = EcoreUtil.copy(orgFeature);
      copyGroups(feature.getGroups(), feature);
      if (parentGroup != null) {
         parentGroup.getChildFeatures().add(feature);
      }
      return feature;
   }

   /**
    * 
    * @param groups
    * @return
    */
   private void copyGroups(EList<Group> groups, Feature parentFeature) {
      List<Feature> features = null;
      boolean removeGroups = false;
      List<Group> removeGroupsList = new LinkedList<Group>();
      for (Group group : groups) {
         features = new LinkedList<Feature>();
         int numberOfOriginalFeatures = group.getChildFeatures().size();
         List<Feature> childFeatures = new LinkedList<Feature>();
         childFeatures.addAll(group.getChildFeatures());
         for (Feature feature : childFeatures) {
            if (featureMap.containsKey(feature.getId())) {
               Feature copyFeature = copyFeature(feature, group);
               features.add(copyFeature);
            }
         }
         group.getChildFeatures().clear();
         group.getChildFeatures().addAll(features);
         parentFeature.getGroups().add(group);
         if (group.getChildFeatures().isEmpty()) {
            removeGroups = true;// memory a group for removal.
            removeGroupsList.add(group);
            continue;
         }
         
         int numberCurrentChildFeatures = group.getChildFeatures().size();
         int min = group.getMinCardinality();
         int max = group.getMaxCardinality();
         
         if (numberOfOriginalFeatures == min){
            group.setMinCardinality(numberCurrentChildFeatures);
         }
         if (numberOfOriginalFeatures == max){
            group.setMaxCardinality(numberCurrentChildFeatures);
         }
//         
//         if (group.getMaxCardinality() >= 0) { // max could be -1
//            group.setMaxCardinality(group.getMaxCardinality() - (numberOfOriginalFeatures - group.getChildFeatures().size()));
//            if (group.getMaxCardinality() < group.getMinCardinality()) {
//               group.setMaxCardinality(group.getMinCardinality());
//            }
//         }
         // System.out.println(group.getMinCardinality() + ":" + group.getMaxCardinality());
      }
      if (removeGroups) {
         groups.removeAll(removeGroupsList);
      }
   }
}
