/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.term.propositional.expression.Term;
import org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMetaInformation;
import org.feature.model.constraint.FeatureExpression;
import org.feature.model.csp.TextExpressionParser;
import org.feature.model.csp.TextExpressionPrinter;
import org.feature.model.utilities.FeatureModelInit;
import org.featuremapper.models.feature.Constraint;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureFactory;
import org.featuremapper.models.feature.FeatureModel;
import org.featuremapper.models.feature.Group;

/**
 * @author winkelti
 * 
 */
public class Filter {

   FeatureModel fm;
   private Map<String, Feature> featureMap;
   private FeatureModel orgFeatureModel;

   private static Logger log = Logger.getLogger(Filter.class);
   
   public Filter(FeatureModel org, Map<String, Feature> featureMap) {
      this.featureMap = featureMap;
      orgFeatureModel = org;
      Feature orgRoot = orgFeatureModel.getRoot();
      if (featureMap.containsKey(orgRoot.getName())) {
         fm = EcoreUtil.copy(orgFeatureModel);
         fm.setRoot(copyFeature(orgRoot, null));
         assert (fm.getAllFeatures().size() == featureMap.size());
         EList<EAttribute> eAllAttributes = org.eClass().getEAllAttributes();
         for (EAttribute eAttribute : eAllAttributes) {
            fm.eSet(eAttribute, org.eGet(eAttribute));
         }
         fm.getConstraints().clear();
        // checkConstraints(orgFeatureModel.getConstraints(), fm.getAllFeatures());
         filterConstraints(orgFeatureModel);
      }
      // root feature not selected
   }

   private void filterConstraints(FeatureModel featureModel) {
       Map<FeatureExpression, Term> constraints = TextExpressionParser.getTermsMappedToConstraints(featureModel);
      for (FeatureExpression featureExpression : constraints.keySet()) {
         if (isRelevant(featureExpression)) {
            Term term = constraints.get(featureExpression);
            try {
               addConstraintToModel(term);
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
   private void addConstraintToModel(Term term) throws IOException {
      Constraint constraint = FeatureFactory.eINSTANCE.createConstraint();
      constraint.setLanguage(FeatureModelInit.csp_constraintLanguage);
      String printExpression = TextExpressionPrinter.printExpression(term);
      constraint.setExpression(printExpression);
      this.fm.getConstraints().add(constraint);      
   }

   private boolean isRelevant(FeatureExpression expression) {
      boolean relevant = false;
      Feature leftFeature = expression.getLeftFeature();
      Feature rightFeature = expression.getRightFeature();
      boolean isLeft = this.featureMap.containsKey(leftFeature.getName());
      boolean isRight = this.featureMap.containsKey(rightFeature.getName());
      relevant = isLeft && isRight;
      return relevant;
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
      feature.setParentGroup(parentGroup);
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
            if (featureMap.containsKey(feature.getName())) {
               Feature copyFeature = copyFeature(feature, group);
               features.add(copyFeature);
            }
         }
         group.getChildFeatures().clear();
         group.getChildFeatures().addAll(features);
         group.setParentFeature(parentFeature);
         if (group.getChildFeatures().isEmpty()) {
            removeGroups = true;// memory a group for removal.
            removeGroupsList.add(group);
            continue;
         }
         if (group.getMaxCardinality() > 0) { // max could be -1
            group.setMaxCardinality(group.getMaxCardinality() - (numberOfOriginalFeatures - group.getChildFeatures().size()));
            if (group.getMaxCardinality() < group.getMinCardinality()) {
               group.setMaxCardinality(group.getMinCardinality());
            }
         }
         // System.out.println(group.getMinCardinality() + ":" + group.getMaxCardinality());
      }
      if (removeGroups) {
         groups.removeAll(removeGroupsList);
      }
   }
}
