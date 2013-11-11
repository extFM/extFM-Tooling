package org.feature.transform.splot2fm;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.utilities.FeatureModelInit;
import org.feature.transform.splot2fm.utils.SXFMUtil;
import org.js.model.feature.Constraint;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.Group;
import org.js.model.feature.edit.FeatureModelHelper;

import constraints.BooleanVariable;
import constraints.PropositionalFormula;
import fm.FeatureGroup;
import fm.FeatureModelException;
import fm.FeatureTreeNode;
import fm.GroupedFeature;
import fm.SolitaireFeature;

public class SXFM2FMTransformator {

   private static Logger log = Logger.getLogger(SXFM2FMTransformator.class);

   private static String groupIdPrefix = "group_";
   private static String sxfmModelExtension = "xml";
   public static String efm_fileextension = "eft";

   public static void parseFiles(List<IFile> files, String featureModelExtension) {
      for (IFile iFile : files) {
         IPath filePath = iFile.getRawLocation();
         String xmlExtension = filePath.getFileExtension();

         if (filePath != null && StringUtils.equalsIgnoreCase(sxfmModelExtension, xmlExtension)) {
            String sxfmFile = filePath.toOSString();

            IPath fmFilePath = filePath.removeFileExtension();
            fmFilePath = fmFilePath.addFileExtension(featureModelExtension);
            String fmFile = fmFilePath.toOSString();

            transform(sxfmFile, fmFile);
         }
      }
   }

   public static void transform(String sxfmFile, String fmFile) {
      try {
         fm.FeatureModel sxfmModel = SXFMUtil.initSXFMFeatureModel(sxfmFile);
         FeatureModel fmModel = FeatureModelInit.initFeatureModel();
         String modelName = sxfmModel.getName();
         fmModel.setName(modelName);
         log.info("----------------------------------------------------");
         log.info("Start Transformation--------------------------------");
         log.info("----------------------------------------------------");
         log.info("Input: '" + sxfmFile + "'");
         log.info("----------------------------------------------------");
         long start = System.currentTimeMillis();
         transform(sxfmModel, fmModel);
         postprocess(fmModel);
         // persist Model before transforming constraints
         FeatureModelInit.persistFMFeatureModel(fmModel, fmFile);
         transformConstraints(sxfmModel, fmModel);
         FeatureModelInit.persistFMFeatureModel(fmModel, fmFile);
         long end = System.currentTimeMillis();
         log.info("----------------------------------------------------");
         log.info("Output: '" + fmFile + "'");
         log.info("----------------------------------------------------");
         log.info("Stopp Transformation--------------------------------");
         log.info("----------------------------------------------------");
         log.info("Transformation took " + (end - start) + " ms.");
         analyseModel(fmModel, sxfmModel);

      } catch (FeatureModelException e) {
         log.error("The selected file '" + sxfmFile + "' is not a SXFM feature model and cannot be transformed.");
      }
   }

   private static void transformConstraints(fm.FeatureModel sxfmModel, FeatureModel fmModel) {
      transformConstraintsintoExpression(sxfmModel, fmModel);
   }

   private static void postprocess(FeatureModel fmModel) {
      // correct feature names and ids
      FeatureModelHelper helper = new FeatureModelHelper(fmModel);
      Set<Feature> allFeatures = helper.getAllFeatures();
      for (Feature feature : allFeatures) {
         String name = feature.getName();
         feature.setName(normalizeIdentifier(name));
         String id = feature.getId();
         feature.setId(normalizeIdentifier(id));
      }
      Set<Group> allGroups = helper.getAllGroups();
      for (Group group : allGroups) {
         String id = group.getId();
         group.setId(normalizeIdentifier(id));
      }
   }

   private static String normalizeIdentifier(String element) {
      element = StringUtils.replace(element, "/", "-");
      return element;
   }

   private static void analyseModel(FeatureModel fmModel, fm.FeatureModel sxfmModel) {
      FeatureModelHelper featureModelHelper = new FeatureModelHelper(fmModel);
      int newFeatures = featureModelHelper.getAllFeatures().size();
      int oldFeatures = sxfmModel.countFeatures();
      log.debug("Features parsed  : " + oldFeatures);
      log.debug("Features created : " + newFeatures);
      log.debug("----------------------------------------------------");

      int oldConstraints = sxfmModel.countConstraints();
      int newConstraints = fmModel.getConstraints().size();
      log.debug("Constraints parsed  : " + oldConstraints);
      log.debug("Constraints created : " + newConstraints);
      log.debug("----------------------------------------------------");
      log.debug("----------------------------------------------------");
   }


   private static void transform(fm.FeatureModel sxfmModel, FeatureModel fmModel) {
      Assert.isNotNull(sxfmModel);
      Assert.isNotNull(fmModel);
      log.info("Transformation of Featuremodel '" + sxfmModel.getName() + "'.");

      FeatureTreeNode sxfmRoot = sxfmModel.getRoot();
      String rootName = sxfmRoot.getName();
      String id = sxfmRoot.getID();
      Feature fmRootFeature = FeatureModelInit.createRootFeature(fmModel, rootName, id);
      log.info("Root Node '" + rootName + "' created.");
      // transformMetadata(sxfmModel, fmRootFeature);

      for (int i = 0; i < sxfmRoot.getChildCount(); i++) {
         FeatureTreeNode node = (FeatureTreeNode) sxfmRoot.getChildAt(i);
         transformFeatures(node, fmRootFeature);
      }

      Set<Feature> allFeatures = FeatureModelInit.getAllFeatures(fmModel);
      FeatureModelInit.makeFeatureIdsUnique(allFeatures);

   }

   private static void transformFeatures(FeatureTreeNode featureNode, Feature fmParent) {
      // feature is direct child of parent feature -> create single feature
      // group
      if (featureNode instanceof SolitaireFeature) {
         log.debug("SolitaireFeature '" + featureNode.getName() + "' found.");
         SolitaireFeature solitaireFeature = (SolitaireFeature) featureNode;
         Feature fmFeature = transformSolitaireFeature(solitaireFeature, fmParent);
         for (int i = 0; i < featureNode.getChildCount(); i++) {
            FeatureTreeNode node = (FeatureTreeNode) featureNode.getChildAt(i);
            transformFeatures(node, fmFeature);
         }
         // feature is child of feature group -> 1. create group, 2. add
         // further feature to this group
      } else if (featureNode instanceof GroupedFeature) {
         log.debug("GroupedFeature '" + featureNode.getName() + "' found.");
         GroupedFeature groupedFeature = (GroupedFeature) featureNode;
         String groupId = groupedFeature.getGroup().getID();
         Feature newFeature = transformGroupedFeature(groupedFeature, fmParent, groupId);
         for (int i = 0; i < groupedFeature.getChildCount(); i++) {
            FeatureTreeNode node = (FeatureTreeNode) featureNode.getChildAt(i);
            transformFeatures(node, newFeature);
         }
      } else if (featureNode instanceof FeatureGroup) {
         FeatureGroup fGroup = (FeatureGroup) featureNode;
         log.debug("FeatureGroup " + fGroup.getName() + "[" + fGroup.getMin() + "," + fGroup.getMax() + "]" + " found.");
         transformGroupNode(fGroup, fmParent);
      }

   }

   private static void transformGroupNode(FeatureGroup featureGroup, Feature parentFeature) {
      int max = featureGroup.getMax();
      int min = featureGroup.getMin();
      String id = featureGroup.getID();
      FeatureModelInit.createFeatureGroup(parentFeature, min, max, id);
      for (int i = 0; i < featureGroup.getChildCount(); i++) {
         FeatureTreeNode node = (FeatureTreeNode) featureGroup.getChildAt(i);
         transformFeatures(node, parentFeature);
      }
   }

   private static Feature transformSolitaireFeature(SolitaireFeature sxfmNode, Feature fmParent) {
      String name = sxfmNode.getName();
      String id = sxfmNode.getID();
      boolean optional = sxfmNode.isOptional();
      String groupId = groupIdPrefix + id;
      Feature fmSolitairefeature = FeatureModelInit.createSingleFeature(fmParent, name, id, optional, groupId);
      return fmSolitairefeature;
   }

   private static Feature transformGroupedFeature(GroupedFeature sxfmNode, Feature fmParent, String groupId) {
      String name = sxfmNode.getName();
      String id = sxfmNode.getID();
      Feature fmFeature = FeatureModelInit.createGroupFeature(fmParent, name, id, groupId);
      return fmFeature;
   }

   private static void transformConstraintsintoExpression(fm.FeatureModel sxfmModel, FeatureModel fmModel) {
      Assert.isNotNull(sxfmModel);
      Assert.isNotNull(fmModel);
      URI uri = EcoreUtil.getURI(fmModel);
      
      Collection<PropositionalFormula> constraints = sxfmModel.getConstraints();
      EList<Constraint> fmConstraints = fmModel.getConstraints();

      FeatureModelHelper helper = new FeatureModelHelper(fmModel);
      Set<Feature> allFeatures = helper.getAllFeatures();

      for (PropositionalFormula propositionalFormula : constraints) {
         String formula = propositionalFormula.getFormula();
         log.debug("Propositional Formula: " + formula);
         Collection<BooleanVariable> variables = propositionalFormula.getVariables();

         // find ~ and replace
         formula = StringUtils.replace(formula, "~", "not ");
//
//         // find ids and replace by featurename
//         for (BooleanVariable booleanVariable : variables) {
//            String id = booleanVariable.getID();
//            boolean replaced = false;
//
//            for (Feature feature : allFeatures) {
//               String featureId = feature.getId();
//
//               if (StringUtils.equalsIgnoreCase(id, featureId)) {
//                  String featureName = feature.getName();
//                  String regex = "^" + id + "[\\s|)]|[~|\\s|(]" + id + "[\\s|)]|[~|\\s|(]" + id + "$|^id$";
//                  Pattern pattern = Pattern.compile(regex);
//                  Matcher matcher = pattern.matcher(formula);
//                  while (matcher.find()) {
//                     MatchResult result = matcher.toMatchResult();
//                     int start = result.start();
//                     int end = result.end();
//                     formula = replace(formula, id, featureName, start, end);
//                  }
//                  replaced = true;
//                  break;
//               }
//            }
//            if (!replaced) {
//               log.error("Could not replace the feature id '" + id + "' in the model constraints.");
//            }
//         }
         log.debug("Transformed Formula: " + formula);
         Constraint newConstraint = transformConstraint(formula, uri);
         if (newConstraint != null) {
            fmConstraints.add(newConstraint);
         }
      }
   }

   private static Constraint transformConstraint(String formula, URI uri) {
      Constraint constraint = TextExpressionParser.createFeatureConstraint(formula, uri);
      return constraint;
   }

   private static String replace(String input, String searchString, String replacement, int minPosition, int maxPosition) {
      String substring = StringUtils.substring(input, minPosition, maxPosition);
      String replacedSubstring = StringUtils.replace(substring, searchString, replacement);

      String begin = StringUtils.substring(input, 0, minPosition);
      String end = StringUtils.substring(input, maxPosition);
      String result = begin + replacedSubstring + end;
      return result;
   }

}
