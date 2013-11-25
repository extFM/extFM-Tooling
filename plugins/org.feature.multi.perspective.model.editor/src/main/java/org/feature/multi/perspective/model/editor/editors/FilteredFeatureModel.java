package org.feature.multi.perspective.model.editor.editors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.editor.editors.algorithms.BruteForceAlgorithm;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.utilities.FeatureMappingUtil;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.FeatureState;
import org.js.model.feature.edit.FeatureLabelProvider;
import org.js.model.feature.edit.FeatureModelHelper;

/**
 * create the filtered feature model and validates it. also validates all view points.
 * 
 * @author Tim Winkelmann
 * 
 */
public class FilteredFeatureModel {

   private static Logger log = Logger.getLogger(FilteredFeatureModel.class);
   private ViewPoint viewPoint;
   private MappingModel featureMappingModel;
   private View viewpointView;

   /**
    * 
    * @param mappingResource
    * @param viewPoint
    */
   public FilteredFeatureModel(Resource mappingResource, ViewPoint viewPoint) {
      this.viewPoint = viewPoint;
      featureMappingModel = FeatureMappingUtil.getFeatureMapping(mappingResource);
   }

   /**
    * create a view from the viewpoint, validate it, and persist the view as a new feature model refinement.
    */
   public boolean createAndValidateView() {
      long timeMillis = System.currentTimeMillis();
      log.debug("time: " + (System.currentTimeMillis() - timeMillis));
      timeMillis = System.currentTimeMillis();

      View view = createView();

      boolean consistent = false;
      // Find specific ViewPoint
      if (view != null && view.isConsistent()) {
         viewpointView = view;
         consistent = true;
      }
      log.debug("time: " + (System.currentTimeMillis() - timeMillis));
      return consistent;
   }

   public FeatureModel deriveFilteredFeaturemodel() {
      FeatureModel model = null;
      if (viewpointView != null) {
         model = createFilteredFeatureModelCopy(featureMappingModel.getFeatureModel(), viewPoint, viewpointView);
      } else {
         log.error("Could not create ViewPoint");
      }
      return model;
   }

   public FeatureModel deriveDeselectedFeaturemodel() {
      FeatureModel model = null;
      if (viewpointView != null) {
         model = createDeselectedFeatureModelCopy(featureMappingModel.getFeatureModel(), viewPoint, viewpointView);
      } else {
         log.error("Could not create ViewPoint");
      }
      return model;
   }

   public String getViewPointName() {
      String result = "";
      if (viewPoint != null) {
         result = viewPoint.getName();
      }
      return result;
   }

   private View createView() {

      FeatureModel featureModel = featureMappingModel.getFeatureModel();
      FeatureModelHelper helper = new FeatureModelHelper(featureModel);
      Set<Feature> allFeatures = helper.getAllFeatures();
      log.info("#allFeatures: " + allFeatures.size());

      GroupModel groupModel = featureMappingModel.getViewModel();
      // create views
      ViewCreator viewCreater = new ViewCreator(featureMappingModel);
      List<View> views = viewCreater.getViews();

      BruteForceAlgorithm bruteForce = new BruteForceAlgorithm(groupModel, views, featureMappingModel.getFeatureModel());
      View view = bruteForce.checkViewpoint(viewPoint);
      if (view != null) {
         log.info("#viewFeatures: " + view.getFeatures().size());
      }
      return view;
   }

   private FeatureModel createDeselectedFeatureModelCopy(FeatureModel origFeatureModel, ViewPoint viewPoint, View view) {
      FeatureModel newFeatureModel = EcoreUtil.copy(origFeatureModel);
      FeatureModelHelper helper = new FeatureModelHelper(newFeatureModel);
      Set<Feature> allNewFeatures = helper.getAllFeatures();

      FeatureLabelProvider labelProvider = new FeatureLabelProvider();

      Set<Feature> origfeatures = getFeaturesNotContainedInView(view);
      for (Feature origfeature : origfeatures) {
         String origfeatureId = origfeature.getId();
         for (Feature newFeature : allNewFeatures) {
            String newFeatureId = newFeature.getId();
            if (origfeatureId.equals(newFeatureId)) {
               // deselect features not contained in view
               log.info("deselected feature" + labelProvider.getText(newFeature));
               newFeature.setConfigurationState(FeatureState.DESELECTED);
               break;
            }
         }
      }
      return newFeatureModel;
   }

   private Set<Feature> getFeaturesNotContainedInView(View view) {
      Set<Feature> notContained = new HashSet<Feature>();
      FeatureModel featureModel = view.getFeatureModel();
      FeatureModelHelper helper = new FeatureModelHelper(featureModel);
      Set<Feature> allFeatures = helper.getAllFeatures();
      Set<Feature> viewFeatures = view.getFeatures();

      notContained.addAll(allFeatures);
      notContained.removeAll(viewFeatures);

      return notContained;
   }

   /**
    * creates the feature model and persist it in a file.
    * 
    * @param featureMappingModel the mapping
    * @param viewPoint the viewpoint
    * @param view the features to the viewpoint
    */
   private FeatureModel createFilteredFeatureModelCopy(FeatureModel origFeatureModel, ViewPoint viewPoint, View view) {
      log.info("#Features for a ViewPoint:  " + view.getFeatures().size());
      Map<String, Feature> featureMap = new HashMap<String, Feature>();
      Set<Feature> features = view.getFeatures();
      for (Feature feature : features) {
         featureMap.put(feature.getId(), feature);
      }
      Filter filter = new Filter(origFeatureModel, featureMap);
      FeatureModel newModel = filter.newFeatureModel;
      return newModel;
   }
}
