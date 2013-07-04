package org.js.model.feature.csp;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureConstraint;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.Group;
import org.js.model.feature.edit.FeatureModelUtil;

import choco.cp.solver.CPSolver;
import choco.kernel.common.util.iterators.DisposableIterator;
import choco.kernel.model.Model;
import choco.kernel.solver.variables.integer.IntDomainVar;

/**
 * This class analyzes a given featuremodel and cashes the analyzed values.
 * 
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class FeatureModelAnalyzer {

   private static Logger log = Logger.getLogger(FeatureModelAnalyzer.class);

   Set<FeatureVariant> derivableVariants;

   int numberDerivableVariant;

   Set<Feature> mandatoryFeatures;
   Set<Feature> coreFeatures;
   Set<Feature> variableFeatures;
   Model cspModel;

   private FeatureModelHelper featureModelHelper;

   private FeatureModel model;

   private boolean keepVariantFlag = false;
   private boolean persistVariantFlag = true;

   /**
    * default constructor.
    * 
    * @param model must not be null.
    */
   public FeatureModelAnalyzer(FeatureModel model) {
      this.model = model;
      featureModelHelper = new FeatureModelHelper(model);
   }

   public int getConstraintCoverage() {
      Set<Feature> consFeatures = new HashSet<Feature>();
      for (FeatureConstraint featureCon : featureModelHelper.getAllFeatureConstraints()) {
         consFeatures.add(featureCon.getLeftOperand());
         consFeatures.add(featureCon.getRightOperand());
      }
      int constrained = consFeatures.size();
      int features = featureModelHelper.getAllFeatures().size();
      int percentage = (constrained * 100) / features;
      return percentage;
   }

   /**
    * get the total number of all CSP-constraints.
    * 
    * @return
    */
   public int getNumberOfAllCSPConstraints() {
      int attributeConstraints = featureModelHelper.getAllAttributeConstraints().size();
      int featureConstraints = featureModelHelper.getAllFeatureConstraints().size();
      return attributeConstraints + featureConstraints;
   }

   /**
    * get the total number of all contained features.
    * 
    * @return
    */
   public int getNumberOfAllFeatures() {
      return featureModelHelper.getAllFeatures().size();
   }

   /**
    * get all mandatory features.
    * 
    * @return
    */
   public Set<Feature> getMandatoryFeatures() {
      if (mandatoryFeatures == null) {
         mandatoryFeatures = new HashSet<Feature>(2);
         Set<Feature> features = featureModelHelper.getAllFeatures();
         for (Feature feature : features) {
            EObject container = feature.eContainer();
            if (container != null) {
               Group group = (Group) container;
               EList<Feature> childFeatures = group.getChildFeatures();
               if (childFeatures.size() == group.getMinCardinality()) {
                  mandatoryFeatures.add(feature);
               }
            }
         }
      }
      return mandatoryFeatures;
   }

   /**
    * get the number of all mandatory features.
    * 
    * @return
    */
   public int getNumberOfMandatoryFeatures() {
      return getMandatoryFeatures().size();
   }

   /**
    * Try to find a solution. If one solution was found, return true.
    * 
    * @return
    */
   public boolean isSatisfiable() {
      CPSolver solver = new CPSolver();
      Model problemModel = getCSPModel();
      solver.read(problemModel);
      solver.solve();
      return solver.isFeasible();
   }

   private boolean isFeature(String featureId) {
      return getFeature(featureId) != null;
   }

   private boolean isAttribute(String attributeId) {
      return featureModelHelper.getAttribute(attributeId) != null;
   }

   private Model getCSPModel() {
      if (cspModel == null) {
         TranslateFM2CSP modelBuilder = new TranslateFM2CSP();
         cspModel = modelBuilder.getCSPModel(model);
      }
      return cspModel;
   }

   private void solveModel(boolean findAll, boolean keepVariants, boolean persistVariant) {
      long start = System.currentTimeMillis();
      CPSolver solver = new CPSolver();
      Model problemModel = getCSPModel();
      solver.read(problemModel);
      log.debug("------------------------------------------");
      int j = 0;
      if (solver.solve()) {
         do {
            j++;
            FeatureVariant variant = createVariant(solver);
            if (persistVariant){
               save(variant, j);
            }
            if (keepVariants) {
               derivableVariants.add(variant);
            }
            log.debug(j + ". variant found.");
            log.info(j + ". variant found: '" + variant.toString() + "'");
            log.debug("------------------------------------------");
         }
         while (findAll && solver.nextSolution());
         long end = System.currentTimeMillis();
         log.info("Check derivable variants took " + (end - start) + " ms.");
         numberDerivableVariant = j;
         log.info(numberDerivableVariant + " derivable variants found.");
      }
   }

   private void save(FeatureVariant variant, int number) {
    FeatureModel featureModelVariant = variant.getModel();
    String featureModelProject = FeatureModelUtil.getProjectName(model);
    FeatureModelUtil.persistModel(featureModelVariant, "variant_"+number, "eft", "variants", featureModelProject);
   }

   private FeatureVariant createVariant(CPSolver solver) {
      DisposableIterator<IntDomainVar> variables = solver.getIntVarIterator();
      IntDomainVar variable;
      FeatureVariant variant = new FeatureVariant(EcoreUtil.copy(model));
      while (variables.hasNext()) {
         variable = variables.next();
         // Skip temporary variables
         if (variable.getName().startsWith("TMP_")) continue;
         String id = variable.getName();

         if (isFeature(id)) {
            handleFeatureVariable(variable, variant);
         } else if (isAttribute(id)) {
            handleAttributeVariable(variable, variant);
         }
         log.debug(variable.getName() + ":" + variable.getVal());
      }
      return variant;
   }

   private void handleAttributeVariable(IntDomainVar variable, FeatureVariant variant) {
      int value = variable.getVal();
      String id = variable.getName();
      // attribute enablement
      if (id.startsWith(TranslateFM2CSP.attributeEnablement)) {
         if (value == 0) {
            // attribute is disabled
         } else if (value == 1) {
            // attribute is enabled
         }
      }
      // attribute value
      else if (id.startsWith(TranslateFM2CSP.attributeValue)) {
         variant.setAttributeValue(value, id);
      }
   }

   private void handleFeatureVariable(IntDomainVar variable, FeatureVariant variant) {
      int value = variable.getVal();
      String id = variable.getName();
      // 1 is selected
      if (value == 1) {
         variant.selectFeature(id);
      } else {
         // 0 is not selected
         variant.deselectFeature(id);
      }
   }

   private Feature getFeature(String id) {
      Feature foundFeature = null;
      Set<Feature> features = featureModelHelper.getAllFeatures();
      for (Feature feature : features) {
         String featureId = EcoreUtil.getID(feature);
         if (id.equals(featureId)) {
            foundFeature = feature;
            break;
         }
      }
      return foundFeature;
   }

   public int getNumberOfDerivableVariants() {
      if (derivableVariants == null) {
         derivableVariants = new HashSet<FeatureVariant>();
         solveModel(true, keepVariantFlag, persistVariantFlag);
      }
      return numberDerivableVariant;
   }

   public Set<Feature> getAllFeatures() {
      return featureModelHelper.getAllFeatures();
   }

   public Set<Attribute> getAllAttributes() {
      return featureModelHelper.getAllAttributes();
   }

   /**
    * get the total number of all contained features.
    * 
    * @return
    */
   public int getNumberOfAllAttributes() {
      return getAllAttributes().size();
   }

}