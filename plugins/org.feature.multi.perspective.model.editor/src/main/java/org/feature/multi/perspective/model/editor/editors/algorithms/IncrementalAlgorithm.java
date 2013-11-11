/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.feature.model.utilities.FeatureMappingUtil;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.editor.editors.View;
import org.feature.multi.perspective.model.editor.editors.ViewCreator;
import org.feature.multi.perspective.model.editor.util.Flag;
import org.feature.multi.perspective.model.editor.util.Util;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.model.viewmodel.ViewPointContainer;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * @author Tim Winkelmann
 * 
 */
public class IncrementalAlgorithm {

   private static Logger log = Logger.getLogger(IncrementalAlgorithm.class);
   private HashMap<EObject, View> viewMap;
   private GroupModel groupModel;
   private UsedGroup usedGroupCoreGroup;
   private FeatureModel featureModel;

   private boolean checkRun = false;
   private List<ViewPoint> inConsistentViewpoints = new ArrayList<ViewPoint>();

   // private int i = 0; //used for tests

   /**
    * Constructor that initializes views for the given featuremapping.
    * 
    * @param mapping
    */
   public IncrementalAlgorithm(MappingModel mapping) {
      this.featureModel = mapping.getFeatureModel();
      this.groupModel = mapping.getViewModel();
      ViewCreator viewCreater = new ViewCreator(mapping);
      List<View> views = viewCreater.getViews();
      initViewMap(views);
   }

   public IncrementalAlgorithm(GroupModel groupModel, List<View> views, FeatureModel featureModel) {
      this.featureModel = featureModel;
      this.groupModel = groupModel;
      initViewMap(views);
   }

   /**
    * 
    * @param views
    * @param groupModel
    */
   public IncrementalAlgorithm(List<View> views, MappingModel mapping) {
      this.featureModel = mapping.getFeatureModel();
      this.groupModel = mapping.getViewModel();
      initViewMap(views);
   }

   private void initViewMap(List<View> views) {
      this.viewMap = new HashMap<EObject, View>();
      for (View view : views) {
         viewMap.put(view.getGroup(), view);
      }
   }

   /**
    * Single check of a {@link ViewPoint}.
    * 
    * @param viewPoint the {@link ViewPoint} for the check.
    * @return true if all direct connected groups are consistent.
    */
   public boolean checkViewPoint(ViewPoint viewPoint) {
      List<ViewPoint> vps = new ArrayList<ViewPoint>();
      vps.add(viewPoint);
      Map<AbstractGroup, UsedGroup> groupFeatureModel = buildGroupFeatureModel(vps);
      boolean isCon = true;
      for (AbstractGroup group : viewPoint.getContainedInGroup()) {
         UsedGroup usedGroup = groupFeatureModel.get(group);
         boolean consistent = usedGroup.isConsistent();
         if (isCon && !consistent) {
            isCon = false;
         }
      }
      return isCon;
   }

   /**
    * collect for each group the features and checks if they are consistent.
    * 
    * @return null if no viewpoints where found
    */
   private Map<AbstractGroup, UsedGroup> buildGroupFeatureModel(List<ViewPoint> viewPoints) {
      // log.info("Number of ViewPoints: " + viewPoints.size());
      Set<AbstractGroup> groups = new HashSet<AbstractGroup>();
      // get groups from viewpoints
      for (ViewPoint viewPoint : viewPoints) {
         groups.addAll(viewPoint.getContainedInGroup());
      }
      Map<AbstractGroup, UsedGroup> usedGroups = createMSGM(groups);
      for (Group g : usedGroupCoreGroup.getGroup().getGroups()) {
         if (usedGroups.containsKey(g)) {
            UsedGroup mostSpecificGroup = usedGroups.get(g);
            Flag f = new Flag(); // pre-consistency check
            FeatureModel view = Util.createFeatureModel(featureModel, mostSpecificGroup.getFeatures(), f);
            if (f.isChanged() && f.isFlagged()) {
               mostSpecificGroup.setConsistent(false);
            } else {
               mostSpecificGroup.setConsistent(Util.isConsistent(view));
            }
            // msg.setConsistent(Util.isConsistent(msg.getFeatures()));
            mostSpecificGroup.setDone();
            // i++;//used for tests
            checkGroupModel(g, usedGroups);
         }
      }
      return usedGroups;
   }

   /**
    * 
    * @return
    */
   public List<ViewPointWrapper> checkViewpoints() {
      List<ViewPointWrapper> viewPointConsistency = new ArrayList<ViewPointWrapper>();
      ViewPointContainer container = groupModel.getViewPointContainer();
      if (container != null) {
         EList<ViewPoint> viewPoints = container.getViewPoints();
         Map<AbstractGroup, UsedGroup> groupFeatureModel = buildGroupFeatureModel(viewPoints);
         for (ViewPoint viewPoint : viewPoints) {

            String logMsg = "Heuristic ";
            logMsg += viewPoint.getName();
            logMsg += " contained in ";
            EList<AbstractGroup> containedInGroup = viewPoint.getContainedInGroup();
            for (AbstractGroup group : containedInGroup) {
               logMsg += group.getName() + ", ";
            }
            log.debug(logMsg);

            boolean isCon = true;
            Set<Feature> combinedFeaturesForViewPoint = new HashSet<Feature>();
            for (AbstractGroup group : viewPoint.getContainedInGroup()) {
               UsedGroup usedGroup = groupFeatureModel.get(group);
               combinedFeaturesForViewPoint.addAll(usedGroup.getFeatures());
               boolean consistent = usedGroup.isConsistent();
               if (isCon && !consistent) {
                  isCon = false;
               }
            }
            if (!isCon) {
               // log.debug("recheck");
               Flag flag = new Flag();
               FeatureModel view = Util.createFeatureModel(featureModel, combinedFeaturesForViewPoint, flag);
               if (!flag.isChanged() && !flag.isFlagged()) {
                  isCon = Util.isConsistent(view);
                  // log.debug(isCon);
               }
            }

            ViewPointWrapper wrapper = new ViewPointWrapper(viewPoint, isCon);
            viewPointConsistency.add(wrapper);
            if (!isCon) {
               inConsistentViewpoints.add(viewPoint);
            }
         }
      } else {
         log.info("There are no viewpoints defined yet.");
      }
      checkRun = true;
      return viewPointConsistency;
   }

   /**
    * return all inconsistent viewpoints.
    * 
    * @return
    */
   public List<ViewPoint> getInConsistentViewpoints() {
      if (!checkRun) {
         checkViewpoints();
      }
      return inConsistentViewpoints;
   }

   /**
    * 
    * @param group
    * @param usedGroups
    */
   private void checkGroupModel(AbstractGroup group, Map<AbstractGroup, UsedGroup> usedGroups) {
      for (Group g : group.getGroups()) {
         if (usedGroups.containsKey(g)) {
            UsedGroup ug = usedGroups.get(g);
            Flag f = new Flag();
            FeatureModel view = Util.createFeatureModel(featureModel, ug.getFeatures(), f);
            if (f.isChanged() && f.isFlagged()) {
               ug.setConsistent(false);
            } else {
               ug.setConsistent(Util.isConsistent(view));
            }
            // ug.setConsistent(Util.isConsistent(ug.getFeatures()));
            ug.setDone();
            // i++;//used for tests
            checkGroupModel(g, usedGroups);
         }
      }
   }

   /**
    * uses the most specific groups to create a new group model
    * 
    * @param groups most specific groups
    * @return
    */
   private Map<AbstractGroup, UsedGroup> createMSGM(Set<AbstractGroup> groups) {
      Map<AbstractGroup, UsedGroup> usedGroups = new HashMap<AbstractGroup, UsedGroup>();
      usedGroupCoreGroup = new UsedGroup(null, groupModel.getCoreGroup(), viewMap.get(groupModel.getCoreGroup()).getFeatures());
      usedGroupCoreGroup.setDone();
      Flag f = new Flag();
      FeatureModel view = Util.createFeatureModel(featureModel, usedGroupCoreGroup.getFeatures(), f);
      if (f.isChanged() && f.isFlagged()) {
         usedGroupCoreGroup.setConsistent(false);
      } else {
         usedGroupCoreGroup.setConsistent(Util.isConsistent(view));
      }
      // ugCG.setConsistent(Util.isConsistent(ugCG.getFeatures()));
      usedGroups.put(groupModel.getCoreGroup(), usedGroupCoreGroup);
      for (AbstractGroup group : groups) {
         if (!usedGroups.containsKey(group)) {
            Set<Feature> features = new HashSet<Feature>();
            features.addAll(viewMap.get(group).getFeatures());

            UsedGroup ugParent = null;
            if (group instanceof Group) {
               Group g = (Group) group;
               if (g.getParentGroup() != null) {
                  if (g.getParentGroup().equals(groupModel.getCoreGroup())) {
                     ugParent = usedGroupCoreGroup;
                  } else {
                     ugParent = createMSG((AbstractGroup) g.getParentGroup(), usedGroups);
                  }
                  features.addAll(ugParent.getFeatures());
               }
               UsedGroup ug = new UsedGroup(ugParent, group, features);
               usedGroups.put(group, ug);
            }
         }
      }
      return usedGroups;
   }

   /**
    * create a {@link UsedGroup} and his parents (except the ugCG) from the {@link Group} and adds it and his parents to
    * the list.
    * 
    * @param group a most specific group.
    * @param ugs a list of most specific group.
    * @return the most specific group.
    */
   private UsedGroup createMSG(AbstractGroup group, Map<AbstractGroup, UsedGroup> ugs) {
      if (ugs.containsKey(group)) {
         return ugs.get(group);
      }
      UsedGroup ugParent;
      if (group instanceof Group) {
         Group g = (Group) group;
         if (g.getParentGroup().equals(groupModel.getCoreGroup())) {
            ugParent = usedGroupCoreGroup;
         } else {
            ugParent = createMSG((Group) g.getParentGroup(), ugs);
         }

         Set<Feature> features = new HashSet<Feature>();
         features.addAll(ugParent.getFeatures());
         features.addAll(viewMap.get(group).getFeatures());

         UsedGroup ug = new UsedGroup(ugParent, group, features);
         ugs.put(group, ug);
         return ug;
      }
      return null;
   }
}
