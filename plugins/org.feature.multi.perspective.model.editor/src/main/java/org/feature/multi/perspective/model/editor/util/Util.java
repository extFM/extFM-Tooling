/**
 * 
 */
package org.feature.multi.perspective.model.editor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.feature.model.utilities.FeatureModelInit;
import org.feature.model.utilities.ResourceUtil;
import org.js.model.feature.AttributeConstraint;
import org.js.model.feature.Constraint;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.Group;
import org.js.model.feature.Imply;
import org.js.model.feature.csp.FeatureModelAnalyzer;
import org.js.model.feature.edit.FeatureModelHelper;

/**
 * Utility class for the multi-perspective editor.
 * 
 * @author Tim Winkelmann
 * 
 */
public class Util {

   public static final Color attachedGraphNodeBackgroundColor = ColorConstants.green;
   public static final Color unattachedGraphNodeBackgroundColor = new Color(null, 216, 228, 248);
   public static final Color attachedGraphConnectionLineColor = ColorConstants.green;
   public static final Color unattachedGraphConnectionLineColor = new Color(null, 192, 192, 192);
   public static List<GraphNode> attachedGraphNodes = new LinkedList<GraphNode>();
   public static List<GraphConnection> highlightedGraphConnections = new LinkedList<GraphConnection>();
   public static Logger log = Logger.getLogger(Util.class);

   /**
    * creates a view from the {@link FeatureModel}
    * 
    * @param featureModel the original {@link FeatureModel}
    * @param features which are part of the view.
    * @return a view from a {@link FeatureModel}
    */
   public static FeatureModel createFeatureModel(FeatureModel featureModel, Set<Feature> features, Flag canBeConsistent) {
      FeatureModelHelper helper = new FeatureModelHelper(featureModel);
      if (helper.getAllFeatures().size() == features.size()) {
         return featureModel;
      }
      URI uri = featureModel.eResource().getURI().trimFileExtension().trimFragment();
      ResourceSet resourceSet = featureModel.eResource().getResourceSet();
      String uriString = uri.toString() + System.currentTimeMillis() + features.hashCode();
      // log.debug("FeaturemodelURI: " + uriString);
      uri = URI.createURI(uriString);
      uri = uri.appendFileExtension("feature");
      Resource resource = resourceSet.createResource(uri);
      FeatureModel view = EcoreUtil.copy(featureModel);
      traverseFeatureModelAndRemoveFeatures(view.getRoot(), features);
      FeatureModelHelper viewHelper = new FeatureModelHelper(view);
      if (viewHelper.getAllFeatures().size() == features.size()) {
         removeUnusedConstraints(view, featureModel, canBeConsistent);
         resource.getContents().add(view);
      } else {
         view = null;
      }
      return view;
   }

   /**
    * removes condition where the condition is a tautology, due to missing features and simple implications and
    * exclusions.
    * 
    * @param view a subset of the {@link FeatureModel}.
    * @param featureModel the full {@link FeatureModel}.
    * @param canBeConsistent if an implies constraint can never be fulfilled.
    */
   private static void removeUnusedConstraints(FeatureModel view, FeatureModel featureModel, Flag canBeConsistent) {
      // log.debug("view features:\t" + view.getAllFeatures().size());
      // log.debug("featureModel features:\t" +
      // featureModel.getAllFeatures().size());
      
      FeatureModelHelper viewHelper = new FeatureModelHelper(view);
      Set<Feature> allFeatures = viewHelper.getAllFeatures();
      EList<Constraint> constraints = view.getConstraints();
      Set<Constraint> constraintsToRemove = new HashSet<Constraint>();
      boolean isConsistent = false;
      for (Constraint constraint : constraints) {
         Set<Feature> featuresFromTerm = FeatureModelHelper.getConstrainedFeatures(constraint);
         boolean oneFeatureMissing = false;
         for (Feature feature : featuresFromTerm) {
            if (!contains(feature, allFeatures)) {
               oneFeatureMissing = true;
               break;
            } 
         }
         if (oneFeatureMissing){
            if (constraint instanceof Imply){
               Imply implyConstraint = (Imply) constraint;
               Feature rightOperand = implyConstraint.getRightOperand();
               Feature leftOperand = implyConstraint.getLeftOperand();
               boolean isRightContained = contains(rightOperand, viewHelper.getAllFeatures());
               boolean isLeftContained = contains(leftOperand, viewHelper.getAllFeatures());
               // if only the left feature of an imply constrain is contained without the right, the model cannot become consistent
               if (isLeftContained && !isRightContained) {
                  isConsistent = true;
               }
            } 
            constraintsToRemove.add(constraint);
         }
      }  
      canBeConsistent.setFlagged(isConsistent);
        
      view.getConstraints().removeAll(constraintsToRemove);
      // log.debug("Constraints removed: " + constraintsToRemove.size());
   }

   


   

   /**
    * removes all {@link Feature} from the {@link FeatureModel} which are not in the {@link Set}.
    * 
    * @param parentFeature a parent {@link Feature}. First call with root {@link Feature} .
    * @param features {@link Feature} which are part of the view.
    */
   private static void traverseFeatureModelAndRemoveFeatures(Feature parentFeature, Set<Feature> features) {
      if (contains(parentFeature, features)) {
         EList<Group> groups = parentFeature.getGroups();
         Set<Group> groupsToRemove = new HashSet<Group>();
         for (Group group : groups) {
            EList<Feature> childFeatures = group.getChildFeatures();
            Set<Feature> featuresToRemove = new HashSet<Feature>();
            for (Feature feature : childFeatures) {
               if (contains(feature, features)) {
                  traverseFeatureModelAndRemoveFeatures(feature, features);
               } else {// Remove feature
                  featuresToRemove.add(feature);
               }
            }
            for (Feature feature : featuresToRemove) {
               int numberChildren = group.getChildFeatures().size();
               group.getChildFeatures().remove(feature);
               int max = group.getMaxCardinality();
               int min = group.getMinCardinality();
               //reduce max and min cardinality accordingly
               if (max == numberChildren){
                  group.setMaxCardinality(numberChildren-1);
               }
               if (min == numberChildren){
                  group.setMinCardinality(numberChildren-1);
               }
            }
            if (group.getChildFeatures().isEmpty()) {
               groupsToRemove.add(group);
            }
         }
         for (Group group : groupsToRemove) {
            parentFeature.getGroups().remove(group);
         }
      }
   }

   /**
    * checks if the set contains the {@link Feature}. Check is made by name.
    * 
    * @param feature the {@link Feature}.
    * @param features the set of {@link Feature}.
    * @return true if the name of the {@link Feature} is equal to one in the set.
    */
   private static boolean contains(Feature feature, Collection<Feature> features) {
      if (feature != null && feature.getName() != null) {
         for (Feature feature2 : features) {
            if (feature2 != null && feature2.getId() != null) {
               if (feature.getId().equals(feature2.getId())) {
                  return true;
               }
            }
         }
      }
      return false;
   }

   /**
    * checks if the view is able to create a variant.
    * 
    * @param view the filtered {@link FeatureModel}
    * @return true if there is at least one variant.
    */
   public static boolean isConsistent(FeatureModel view) {
      boolean result = false;
      if (view != null) {
         FeatureModelAnalyzer featureModelAnalyzer = new FeatureModelAnalyzer(view);
         result = featureModelAnalyzer.isSatisfiable();
      }
      return result;
   }

   /**
    * checks the hierarchy of the features, the cardininalities and the constraint.
    * 
    * @return true is it is consistent.
    */
   public static boolean isConsistent(Set<Feature> features) {
      return checkHierarchy(features) & checkCardinalities(features) & checkConstraints(features);
   }

   
   /**
    * Consistency requirements
    * - f1 requires f2   : if f1 included in featureSet, f2 must also be included
    * - f1 requires f2   : if f2 is included, f1 does not care  
    * - f1 excludes f2   : does not care 
    * -f1.a1 RelOp f2.a2 : if f1 included, f2 must also be included 
    * -f1.a1 RelOp f2.a2 : if f2 included, f1 must also be included 
    * 
    * @param feature
    * @return
    */
   public static boolean checkConstraints(Set<Feature> featureSet){
      boolean result = true;
      FeatureModelHelper helper = null;
      
      for (Feature feature : featureSet) {
         if (helper == null){
            FeatureModel fm = (FeatureModel) EcoreUtil.getRootContainer(feature);
            helper = new FeatureModelHelper(fm);
         }
         Set<Constraint> constraints = helper.getConstraintsRelatedToFeature(feature);
         for (Constraint constraint : constraints) {
            // only check Imply Constraints and Attribute Constraints
            if (constraint instanceof Imply) {
               Imply implyConstraint = (Imply) constraint;
               Feature leftOperand = implyConstraint.getLeftOperand();
               if (EcoreUtil.equals(leftOperand, feature)){
                  Feature rightOperand = implyConstraint.getRightOperand();
                  result = (featureSet.contains(rightOperand));
                  if (result == false){
                     break;
                  }
               }
            } else if (constraint instanceof AttributeConstraint) {
               AttributeConstraint attConstraint = (AttributeConstraint) constraint;
               Set<Feature> attributeFeatures = FeatureModelHelper.getConstrainedFeatures(attConstraint);
               result = (featureSet.containsAll(attributeFeatures));
               if (result == false){
                  break;
               }
            }
         }
         if (result == false){
            break;
         }
      }
      
      return result;
   }
   

   /**
    * checks the cardinalities from the features.
    * 
    * @return true if a no cardinality is compromised
    */
   private static boolean checkCardinalities(Set<Feature> features) {
      for (Feature feature : features) {
         EList<Group> groups = feature.getGroups();
         for (Group fGroup : groups) {
            if (fGroup.getMinCardinality() > 0) {
               EList<Feature> childFeatures = fGroup.getChildFeatures();
               int i = 0;
               for (Feature feature2 : childFeatures) {
                  if (features.contains(feature2)) {
                     i++;
                  }
               }
               if (i < fGroup.getMinCardinality()) {
                  // log.debug("Cardinalitycheck: " + feature.getName() +
                  // " l:" + fGroup.getMinCardinality() + " l':" +
                  // i);
                  return false;
               }
            }
         }
      }
      return true;
   }

   /**
    * checks every ancestor from all features
    * 
    * @return true if the hierarchy is complete for all features
    */
   private static boolean checkHierarchy(Set<Feature> features) {
      for (Feature feature : features) {
         if (!checkAncestors(feature, features)) {
            return false;
         }
      }
      return true;
   }

   /**
    * checks the ancestors of a feature.
    * 
    * @param feature the feature to be checked.
    * @return true if the hierarchy is complete
    */
   private static boolean checkAncestors(Feature feature, Set<Feature> features) {
      if (feature.eContainer() == null) {
         return true;// root feature
      }
      Feature parentFeature = FeatureModelHelper.getParentFeature(feature);
      if (features.contains(parentFeature)) {
         return checkAncestors(parentFeature, features);
      } else {
         // log.debug("\t" + feature.getName() + " is missing his parent: " +
         // parentFeature.getName());
         return false;
      }
   }

   /**
    * Opens a save Dialog.
    * 
    * @param defaultFileName a default file name.
    * @param shell the shell is a needed parent for the dialog.
    * @return the filename and path.
    */
   public static String save(String defaultFileName, Shell shell) {
      FileDialog fd = new FileDialog(shell, SWT.SAVE); // find shell
      fd.setFileName(defaultFileName);
      return fd.open();
   }
   
   
   public static IFile openSaveDialog(Shell parent, String defaultFileName) {
      String title = "Save Perspective";
      String message = "Please select a file to store the Perspective";
     
      IPath suggestedPath = Path.fromOSString(defaultFileName);
      suggestedPath.append(defaultFileName);
      IFile file = WorkspaceResourceDialog.openNewFile(parent, title, message, suggestedPath, null);
      return file;
   }



   
   
   
}
