package org.feature.multi.perspective.model.editor.editors;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.feature.model.utilities.FeatureModelInit;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.editor.editors.algorithms.BruteForceAlgorithm;
import org.feature.multi.perspective.model.editor.editors.algorithms.IncrementalAlgorithm;
import org.feature.multi.perspective.model.editor.util.Util;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.utilities.FeatureMappingUtil;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.edit.FeatureModelHelper;

/**
 * create the filtered feature model and validates it. also validates all view points.
 * 
 * @author Tim Winkelmann
 * 
 */
public class FilteredFeatureModel {

   private static Logger log = Logger.getLogger(FilteredFeatureModel.class);
   private ViewmodelMultiPageEditor multiPageEditor;

   /**
    * 
    * @param mappingResource
    * @param viewPoint
    */
   public FilteredFeatureModel(Resource mappingResource, ViewPoint viewPoint, ViewmodelMultiPageEditor multiPageEditor) {
      this.multiPageEditor = multiPageEditor;
      MappingModel featureMappingModel = FeatureMappingUtil.getFeatureMapping(mappingResource);
      FeatureModel featureModel = featureMappingModel.getFeatureModel();
      FeatureModelHelper helper = new FeatureModelHelper(featureModel);
      Set<Feature> allFeatures = helper.getAllFeatures();

      log.info("#allFeatures: " + allFeatures.size());
      // create views
      GroupModel groupModel = featureMappingModel.getViewModel();
      ViewCreator viewCreater = new ViewCreator(featureMappingModel);
      List<View> views = viewCreater.getViews();

      long timeMillis = System.currentTimeMillis();
      IncrementalAlgorithm algorithm = new IncrementalAlgorithm(views, featureMappingModel);
      algorithm.checkViewpoints();
      log.debug("time: " + (System.currentTimeMillis() - timeMillis));
      timeMillis = System.currentTimeMillis();

      BruteForceAlgorithm bruteForce = new BruteForceAlgorithm(groupModel, views, featureMappingModel.getFeatureModel());
      View view = bruteForce.checkViewpoint(viewPoint);

      boolean consistent = view.isConsistent();
      // Find specific ViewPoint
      if (view != null && consistent) {
         log.debug("time: " + (System.currentTimeMillis() - timeMillis));
         createFeatureModel(featureMappingModel, viewPoint, view);
      } else {
         log.error("Could not create ViewPoint");
      }
      showMessage(viewPoint, consistent);
   }

   private void showMessage(ViewPoint viewpoint, boolean consistent) {
      String msg = "";
      if (consistent) {
         msg += "The perspective is created successfully.";
      } else {
         msg += "Could not create perspective ";
      }
      if (!consistent) {
         msg += "because viewpoint " + viewpoint.getName() + " is ";
         msg += "inconsistent.";
      }

      int style = SWT.OK;
      if (consistent) {
         style = SWT.OK | SWT.ICON_INFORMATION;
      } else {
         style = SWT.OK | SWT.ICON_WARNING;
      }

      Shell shell = getShell();
      MessageBox msgBox = new MessageBox(shell, style);
      msgBox.setText("Viewpoint Validation");
      msgBox.setMessage(msg);
      msgBox.open();
   }

   private Shell getShell() {
      Shell shell = multiPageEditor.getSite().getShell();
      return shell;
   }

   /**
    * creates the feature model and persist it in a file.
    * 
    * @param featureMappingModel the mapping
    * @param viewPoint the viewpoint
    * @param view the features to the viewpoint
    */
   private void createFeatureModel(MappingModel featureMappingModel, ViewPoint viewPoint, View view) {
      log.info("#Features for a ViewPoint:  " + view.getFeatures().size());
      Map<String, Feature> featureMap = new HashMap<String, Feature>();
      Set<Feature> features = view.getFeatures();
      for (Feature feature : features) {
         featureMap.put(feature.getId(), feature);
      }
      FeatureModel org = featureMappingModel.getFeatureModel();
      Filter filter = new Filter(org, featureMap);

      log.debug(filter.newFeatureModel);
      String saveFileName =
         Util.save(featureMappingModel.getFeatureModel().getName() + "_" + viewPoint.getName() + ".feature", multiPageEditor.getSite()
            .getShell());
      if (saveFileName != null && !saveFileName.isEmpty()) {
         ResourceSet rst = new ResourceSetImpl();
         Resource resource = rst.createResource(URI.createFileURI(saveFileName));
         resource.getContents().add(filter.newFeatureModel);
         try {
            resource.save(Collections.EMPTY_MAP);
         } catch (IOException e) {
            log.error(e.getMessage());
         }
      }
   }
}
