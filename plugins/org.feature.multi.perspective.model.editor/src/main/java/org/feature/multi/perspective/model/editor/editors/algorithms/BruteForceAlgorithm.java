/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.CoreGroup;
import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.model.editor.editors.View;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * This class represent the BruteForceAlgorithm which validates the {@link ViewPoint}
 * 
 * @author Tim Winkelmann
 * 
 */
public class BruteForceAlgorithm {

   private Logger log = Logger.getLogger(BruteForceAlgorithm.class);
   private Map<ViewPoint, View> viewPoints;
   private GroupModel groupModel;
   private List<View> views;
   private FeatureModel featureModel;

   public BruteForceAlgorithm(GroupModel groupModel, List<View> views, FeatureModel featureModel) {
      this.groupModel = groupModel;
      this.views = views;
      this.featureModel = featureModel;
   }

   /**
    * iterate over each view point and there groups. checks then the combined view consistency
    * 
    * @param groupModel contains the view points
    * @param views2 contains all views
    */
   public List<ViewPointWrapper> checkViewPoints() {
      List<ViewPointWrapper> vpWrapper = new ArrayList<ViewPointWrapper>();

      EList<ViewPoint> viewPointsToCheck = groupModel.getViewPointContainer().getViewPoints();
      HashMap<EObject, View> viewMemory = new HashMap<EObject, View>();
      viewPoints = new HashMap<ViewPoint, View>();
      for (ViewPoint viewPoint : viewPointsToCheck) {
         // log.debug("ViewPoint: " + viewPoint.getName());
         View view = checkViewpoint(viewPoint, groupModel.getCoreGroup(), viewMemory);
         viewPoints.put(viewPoint, view);
         boolean isConsistent = view.isConsistent();
         ViewPointWrapper wrapper = new ViewPointWrapper(viewPoint, isConsistent);
         vpWrapper.add(wrapper);
      }
      // log.debug("BF: " + (System.currentTimeMillis()-time));
      return vpWrapper;
   }

   /**
    * determine if the given viewpoint is consistent.
    * @param viewpoint
    * @return
    */
   public boolean isViewpointConsistent(ViewPoint viewpoint) {
      View view = checkViewpoint(viewpoint);
      return view.isConsistent();
   }

   /**
    * check a viewpoint and return the according view.
    * @param viewpoint
    * @return
    */
   public View checkViewpoint(ViewPoint viewpoint) {
      HashMap<EObject, View> viewMemory = new HashMap<EObject, View>();
      CoreGroup coreGroup = groupModel.getCoreGroup();
      View view = checkViewpoint(viewpoint, coreGroup, viewMemory);
      return view;
   }

   /**
    * check the viewpoint
    * 
    * @param viewPoint the view point
    * @param views the views
    * @param coreGroup the coreGroup
    */
   public View checkViewpoint(ViewPoint viewPoint, CoreGroup coreGroup, HashMap<EObject, View> viewMemory) {
      EList<AbstractGroup> containedInGroup = viewPoint.getContainedInGroup();
      Set<Set<View>> setOfPaths = new HashSet<Set<View>>();
      for (AbstractGroup group : containedInGroup) {
         List<EObject> groups = getGroupPath(group, coreGroup);
         // log.debug("check path for: " + group.getName());
         viewMemory.clear(); // performance test without memory
         Set<View> path = new HashSet<View>();
         if (!viewMemory.containsKey(group)) {
            path = checkPath(groups, views, viewMemory);
         } else {
            path = new HashSet<View>();
            path.add(viewMemory.get(group));
         }
         setOfPaths.add(path);
      }
      if (setOfPaths.isEmpty()) {
         // log.debug("check path for: coreGroup");
         // log.debug(views.get(0).group);
         views.get(0).isConsistent();
         // log.debug(views.get(0).isConsistent());
         return views.get(0);
      } else {
         Set<Feature> features = new HashSet<Feature>();

         for (Set<View> path : setOfPaths) {
            for (View view : path) {
               // log.debug(view.isConsistent());
               features.addAll(view.getFeatures());
            }
         }
         View view = new View(viewPoint, features, this.featureModel);
         
         String logMsg = "BruteForceAlg ";
         logMsg += viewPoint.getName();
         logMsg += " contained in ";
         EList<AbstractGroup> conInGroup = viewPoint.getContainedInGroup();
         for (AbstractGroup group : conInGroup) {
            logMsg += group.getName() + ", ";
         }
         log.debug(logMsg);
         return view;
      }
   }

   /**
    * create views for every group. the views extends the previous one.
    * 
    * @param path has to be sorted from root to target!
    * @param views
    * @param viewMemory
    * @return
    */
   private Set<View> checkPath(List<EObject> path, List<View> views, HashMap<EObject, View> viewMemory) {
      Set<View> pathViews = new HashSet<View>();
      for (EObject group : path) {
         View view = viewMemory.get(group);
         if (view != null) {// check if view was already calculated
            pathViews.add(view);
            // log.debug("skipped: " + group);
            continue;
         }
         // find a view
         for (View v : views) {
            if (v.getGroup().equals(group)) {
               view = v;
               break;
            }
         }
         if (view == null) {
            log.error("could not find a view");
            return pathViews;
         }
         Set<Feature> features = new HashSet<Feature>();// combine view
         features.addAll(view.getFeatures());
         for (View v : pathViews) {
            features.addAll(v.getFeatures());
         }
         if (!features.isEmpty()) {// check if there is something to combine
            view = new View(group, features, this.featureModel);
         }
         // log.debug("add: " + group);
         pathViews.add(view);
         viewMemory.put(group, view);
      }
      return pathViews;
   }

   /**
    * get all ancestors from that group
    * 
    * @param group a group from the tree
    * @param coreGroup the core group
    * @return the path from the coreGroup to the group
    */
   private List<EObject> getGroupPath(AbstractGroup group, CoreGroup coreGroup) {
      List<EObject> groups = new LinkedList<EObject>();
      groups.add(coreGroup);
      for (AbstractGroup childGroup : coreGroup.getGroups()) {
         List<AbstractGroup> calcGroupPath = calcGroupPath(group, childGroup);
         if (!calcGroupPath.isEmpty()) {
            groups.addAll(calcGroupPath);
            break;
         }
      }
      return groups;
   }

   /**
    * calculates path to group
    * 
    * @param target the target group
    * @param source the current group
    * @return the path or an empty list
    */
   private List<AbstractGroup> calcGroupPath(AbstractGroup target, AbstractGroup source) {
      if (target.equals(source)) {
         List<AbstractGroup> groups = new LinkedList<AbstractGroup>();
         groups.add(target);
         return groups;
      } else {// check children
         for (AbstractGroup group : source.getGroups()) {
            List<AbstractGroup> calcGroupPath = calcGroupPath(target, group);
            if (!calcGroupPath.isEmpty()) {
               calcGroupPath.add(0, source);// the index used to be sorted!
               return calcGroupPath;
            }
         }
      }
      return new LinkedList<AbstractGroup>();
   }

   /**
    * @return the viewPoints
    */
   public Collection<View> getViewPoints() {
      return viewPoints.values();
   }

}
