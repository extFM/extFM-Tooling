package org.js.model.feature.csp;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.AttributeConstraint;
import org.js.model.feature.AttributeOperand;
import org.js.model.feature.AttributeReference;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureConstraint;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.Group;
import org.js.model.feature.edit.FeatureModelHelper;
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

   int numberDerivableVariants = -1;

   Set<Feature> mandatoryFeatures;
   Set<Feature> coreFeatures;
   Set<Feature> variableFeatures;
   Model cspModel;

   private boolean findAll = true;

   private FeatureModelHelper featureModelHelper;

   private FeatureModel model;

   private boolean persistVariants = false;
   private int numberOfVariantsToDerive = -1;

   private boolean keepVariants = false;
   Set<FeatureVariant> variants;

   /**
    * default constructor.
    * 
    * @param model must not be null.
    */
   public FeatureModelAnalyzer(FeatureModel model) {
      this.model = model;
      featureModelHelper = new FeatureModelHelper(model);
      initSets();
   }

   private void initSets() {
      variants = new HashSet<FeatureVariant>();
   }

   public FeatureModelAnalyzer(FeatureModel featureModel, boolean persistAllVariants) {
      this(featureModel);
      this.persistVariants = persistAllVariants;
   }

   public String getFeatureModelName() {
      return (model != null) ? model.getName() : "";
   }

   public int getFeatureConstraintCoverage() {
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

   public void setPersistVariants(boolean persistVariants) {
      this.persistVariants = persistVariants;
   }

   /**
    * get the coverage of attributes in constraints.
    * 
    * @return
    */
   public int getAttributeConstraintCoverage() {
      Set<Attribute> consAttribute = new HashSet<Attribute>();
      Set<AttributeConstraint> allAttributeConstraints = featureModelHelper.getAllAttributeConstraints();
      for (AttributeConstraint attributeCon : allAttributeConstraints) {
         AttributeOperand attOp1 = attributeCon.getAttribute1();
         addAttribute(attOp1, consAttribute);
         AttributeOperand attOp2 = attributeCon.getAttribute2();
         addAttribute(attOp2, consAttribute);

      }
      int constrained = consAttribute.size();
      int attributes = featureModelHelper.getAllAttributes().size();
      int percentage = attributes == 0 ? 0 : (constrained * 100) / attributes;
      return percentage;
   }

   private void addAttribute(AttributeOperand attOperand, Set<Attribute> consAttribute) {
      Attribute attribute = getConstrainedAttribute(attOperand);
      if (attribute != null && !consAttribute.contains(attribute)) {
         consAttribute.add(attribute);
      }
   }

   private Attribute getConstrainedAttribute(AttributeOperand operand) {
      Attribute result = null;
      if (operand instanceof AttributeReference) {
         AttributeReference reference = (AttributeReference) operand;
         result = reference.getAttribute();
      }
      return result;
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
      boolean isSolvable = solver.isFeasible();
      log.debug("Featuremodel is solvable: " + isSolvable);
      return isSolvable;
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

   private void solveModel() {
      long start = System.currentTimeMillis();
      CPSolver solver = new CPSolver();
      Model problemModel = getCSPModel();
      solver.read(problemModel);
      log.debug("------------------------------------------");
      int j = 0;

      if (solver.solve()) {
         do {
            j++;
            if (numberOfVariantsToDerive != -1 && j > numberOfVariantsToDerive) {
               persistVariants = false;
            }
            if (keepVariants || persistVariants) {
               FeatureVariant variant = createVariant(solver);
               if (persistVariants) {
                  save(variant, j);
               }
               if (keepVariants) {
                  variants.add(variant);
               }
               log.debug(j + ". variant found: '" + variant.toString() + "'");
            } else {
               log.debug(j + ". variant found.");
            }
            log.debug("------------------------------------------");
         }
         while (isFindAll() && solver.nextSolution());
         long end = System.currentTimeMillis();
         log.info("Check derivable variants took " + (end - start) + " ms.");
         numberDerivableVariants = j;
         // log.info(numberDerivableVariant + " derivable variants found.");
      }
   }

   private void save(FeatureVariant variant, int number) {
      FeatureModel featureModelVariant = variant.getModel();
      String featureModelProject = FeatureModelUtil.getProjectName(model);
      FeatureModelUtil.persistModel(featureModelVariant, featureModelVariant.getName() + number, "eft", "variants", featureModelProject);
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
      if (numberDerivableVariants == -1) {
         solveModel();
      }
      return numberDerivableVariants;
   }

   public Set<Feature> getAllFeatures() {
      return featureModelHelper.getAllFeatures();
   }

   public int getNumberOfUnboundFeatures() {
      return featureModelHelper.getUnboundFeatures().size();
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

   public void setNumberOfVariantsToDerive(int numberOfVariants) {
      this.numberOfVariantsToDerive = numberOfVariants;
   }

   public boolean isFindAll() {
      return findAll;
   }

   public void setFindAll(boolean findAll) {
      this.findAll = findAll;
   }

   public int getNumberOfSelectedFeatures() {
      return featureModelHelper.getSelectedFeatures().size();
   }

   public int getNumberOfDeselectedFeatures() {
      return featureModelHelper.getDeselectedFeatures().size();
   }

   public int getNumberOfAssignedAttributes() {
      return featureModelHelper.getAssignedAttributes().size();
   }

   public FeatureVariant getOneVariant() {
      numberOfVariantsToDerive = 1;
      keepVariants = true;
      solveModel();
      FeatureVariant aVariant = null;
      for (FeatureVariant variant : variants) {
         aVariant = variant;
         break;
      }
      return aVariant;
   }

}
