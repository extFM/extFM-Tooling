/**
 * 
 */
package org.feature.multi.perspective.measure.performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.feature.model.utilities.FeatureModelInit;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.editor.editors.View;
import org.feature.multi.perspective.model.editor.editors.ViewCreator;
import org.feature.multi.perspective.model.editor.editors.algorithms.BruteForceAlgorithm;
import org.feature.multi.perspective.model.editor.editors.algorithms.IncrementalAlgorithm;
import org.feature.multi.perspective.model.editor.editors.algorithms.ViewPointWrapper;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewPointContainer;
import org.feature.multi.perspective.utilities.FeatureMappingUtil;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.edit.FeatureModelUtil;

/**
 * Handler that triggers both consistency check algorithm to compare their preformance.
 * 
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public class ConsistencyCheckHandler extends AbstractCheckHandler {

   String measure = "Measure Performance of Consistency Check";

   private static Logger log = Logger.getLogger(ConsistencyCheckHandler.class);

   List<Long> bruteforceTimeList = new LinkedList<Long>();
   List<Long> heuristicTimeList = new LinkedList<Long>();
   List<Integer> numberFeatures = new LinkedList<Integer>();
   List<Integer> numberViews = new LinkedList<Integer>();
   List<Integer> numberViewPoints = new LinkedList<Integer>();
   List<Integer> numberConstraints = new LinkedList<Integer>();
   List<String> groupTreeHeight = new LinkedList<String>();
   List<String> groupMaxChildren = new LinkedList<String>();
   List<String> groupsPerVP = new LinkedList<String>();
   List<String> featuresPerGroup = new LinkedList<String>();
   List<Double> bruteForceConsistentVPRatio = new LinkedList<Double>();
   List<Double> heuristicConsistentVPRatio = new LinkedList<Double>();

   public List<Double> getBruteForceConsistentVPRatio() {
      return bruteForceConsistentVPRatio;
   }

   public void clearLists() {
      bruteforceTimeList.clear();
      heuristicTimeList.clear();
      numberFeatures.clear();
      numberViews.clear();
      numberViewPoints.clear();
      numberConstraints.clear();
      groupTreeHeight.clear();
      groupMaxChildren.clear();
      groupsPerVP.clear();
      featuresPerGroup.clear();
      bruteForceConsistentVPRatio.clear();
      heuristicConsistentVPRatio.clear();
   }

   protected void measurePerformance(String projectName) {
      log.debug("-------------------------------");
      String folderName = mappingFolder;
      log.debug("check consistency of " + projectName);
      try {
         checkModelsInProject(projectName, folderName);
      } catch (CoreException e) {
         log.error("Could not determine children of folder " + folderName);
      }
      // }
   }

   protected void check(IFile file) {
      ResourceSet resourceSet = new ResourceSetImpl();
      MappingModel mapping = FeatureMappingUtil.getFeatureMapping(file, resourceSet);
      if (mapping != null) {

         determineInfo(file);
         checkConsistency(mapping);
      }
   }

   private void determineInfo(IFile file) {
      determineInfo(groupTreeHeight, "_height", file);
      determineInfo(groupMaxChildren, "_countChildren", file);
      determineInfo(groupsPerVP, "_groupsVP", file);
      determineInfo(featuresPerGroup, "_FCount", file);
   }

   private void determineInfo(List<String> paramList, String param, IFile file) {
      String fileName = file.getName();
      // example:
      // documentmanagement.feature_balanced_height2_countChildren2_vpCount10_groupsVP1_2012-03-31-082230484.cluster_FCount_2012-03-31-082231424.featuremapping
      String regex = param + "([0-9])*";
      Pattern pattern = Pattern.compile(regex);
      Matcher matcher = pattern.matcher(fileName);
      while (matcher.find()) {
         MatchResult result = matcher.toMatchResult();
         String match = result.group();
         String number = match.substring(param.length());
         paramList.add(number);
      }
   }

   protected void printPerformanceMeasure() {
      // TODO: avg. time algorithm
      printCollection("NumberFeatures    ", numberFeatures);
      printCollection("NumberConstraints ", numberConstraints);
      printCollection("NumberViewpoints  ", numberViewPoints);
      printCollection("NumberViews       ", numberViews);
      printCollection("Time Bruteforce   ", bruteforceTimeList);
      printCollection("Time Heuristic    ", heuristicTimeList);
      printStringCollection("Group TreeHeight   ", groupTreeHeight);
      printStringCollection("Group MaxChildren  ", groupMaxChildren);
      printStringCollection("Groups per VP      ", groupsPerVP);
      printStringCollection("Features per Group ", featuresPerGroup);
      printDoubleCollection("ConsistentRatio Bruteforce ", bruteForceConsistentVPRatio);
      printDoubleCollection("ConsistentRatio Heuristic  ", heuristicConsistentVPRatio);
   }

   private void printVPCollection(String description, List<ViewPointWrapper> list) {
      StringBuffer s = initStringBuffer(description);
      for (ViewPointWrapper l : list) {
         s.append(l);
         s.append(", ");
      }
      finalizeStringBuffer(s);
   }

   private double getRatio(List<ViewPointWrapper> list) {
      List<ViewPointWrapper> consistent = new ArrayList<ViewPointWrapper>(list.size());
      for (ViewPointWrapper viewPointWrapper : list) {
         if (viewPointWrapper.isConsistent()) {
            consistent.add(viewPointWrapper);
         }
      }
      double ratio = consistent.size() * 1.00 / list.size();
      return ratio;
   }

   private void checkConsistency(MappingModel featureMapping) {
      GroupModel groupModel = featureMapping.getViewModel();
      FeatureModel featureModel = featureMapping.getFeatureModel();
      ViewCreator viewCreator = new ViewCreator(featureMapping);
      List<View> views = viewCreator.getViews();
      log.debug("GroupModel " + groupModel.eResource().getURI());

      ViewPointContainer container = groupModel.getViewPointContainer();
      int viewpoints = 0;
      if (container != null) {
         viewpoints = container.getViewPoints().size();
      }
      numberViewPoints.add(viewpoints);
      numberFeatures.add(FeatureModelInit.getAllFeatures(featureModel).size());
      numberConstraints.add(featureModel.getConstraints().size());
      numberViews.add(views.size());

      long startB = System.currentTimeMillis();
      List<ViewPointWrapper> bfViewPoints = runBruteForce(views, groupModel, featureModel);
      long endB = System.currentTimeMillis();
      long timeB = endB - startB;
      bruteforceTimeList.add(timeB);

      printVPCollection("BruteForce VPs", bfViewPoints);
      double bRatio = getRatio(bfViewPoints);
      bruteForceConsistentVPRatio.add(bRatio);

      long startH = System.currentTimeMillis();
      List<ViewPointWrapper> hViewPoints = runHeuristic(featureMapping);
      long endH = System.currentTimeMillis();
      long timeH = endH - startH;
      heuristicTimeList.add(timeH);
      printVPCollection("Heuristic VPs ", hViewPoints);
      double hRatio = getRatio(hViewPoints);
      heuristicConsistentVPRatio.add(hRatio);

      log.debug("Bruteforce [" + bRatio + "] " + timeB + "ms , Heuristic [" + hRatio + "]" + timeH + "ms");
      log.debug("-------------------------------");
   }

   private List<ViewPointWrapper> runHeuristic(MappingModel featureMapping) {
      IncrementalAlgorithm algorithm = new IncrementalAlgorithm(featureMapping);
      List<ViewPointWrapper> viewpoints = algorithm.checkViewpoints();
      return viewpoints;
   }

   private List<ViewPointWrapper> runBruteForce(List<View> views, GroupModel groupModel, FeatureModel featureModel) {
      BruteForceAlgorithm algorithm = new BruteForceAlgorithm(groupModel, views, featureModel);
      List<ViewPointWrapper> viewPoints = algorithm.checkViewPoints();
      return viewPoints;
   }

   @Override
   String getMeasureName() {
      return measure;
   }

   @Override
   Logger getLogger() {
      return log;
   }

}
