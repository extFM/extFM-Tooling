package org.js.model.rbac.resource.postprocessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.rbac.ConfigurationOperation;
import org.js.model.rbac.DeselectFeature;
import org.js.model.rbac.RbacFactory;
import org.js.model.rbac.RbacModel;
import org.js.model.rbac.SelectFeature;
import org.js.model.rbac.resource.rbactext.IRbactextOptionProvider;
import org.js.model.rbac.resource.rbactext.IRbactextOptions;
import org.js.model.rbac.resource.rbactext.IRbactextResourcePostProcessor;
import org.js.model.rbac.resource.rbactext.IRbactextResourcePostProcessorProvider;
import org.js.model.rbac.resource.rbactext.mopp.RbactextResource;

public class ImplicitElementSetter implements IRbactextOptionProvider, IRbactextResourcePostProcessor,
      IRbactextResourcePostProcessorProvider {

   private RbacModel currentRbacModel;

   @Override
   public IRbactextResourcePostProcessor getResourcePostProcessor() {
      return this;
   }

   @Override
   public void process(RbactextResource resource) {
      // RbactextResource rbacResource = resource;
      // EList<EObject> contents = rbacResource.getContents();
      // for (EObject next : contents) {
      // if (next instanceof RbacModel) {
      // currentRbacModel = (RbacModel) next;
      // EList<ConfigurationOperation> configOps = currentRbacModel.getConfigurationOperations();
      // configOps.clear();
      // checkCurrentRbacModel();
      // }
      // }
   }

//   private void checkCurrentRbacModel() {
//      EList<FeatureModel> featureModels = currentRbacModel.getFeatureModels();
//      for (FeatureModel featureModel : featureModels) {
//         createFeatureConfigurationOperations(featureModel);
//      }
//   }
//
//   private void createFeatureConfigurationOperations(FeatureModel featureModel) {
//      EList<ConfigurationOperation> configOps = currentRbacModel.getConfigurationOperations();
//      TreeIterator<Object> featureModelContent = EcoreUtil.getAllContents(featureModel, true);
//      RbacFactory factory = RbacFactory.eINSTANCE;
//      while (featureModelContent.hasNext()) {
//         Object object = featureModelContent.next();
//         if (object instanceof Feature) {
//            Feature feature = (Feature) object;
//            configOps.addAll(createFeatureConfigurationOperations(feature, factory));
//         }
//      }
//   }
//
//   private List<ConfigurationOperation> createFeatureConfigurationOperations(Feature feature, RbacFactory factory) {
//      List<ConfigurationOperation> result = new ArrayList<ConfigurationOperation>();
//      String featureId = feature.getId();
//
//      SelectFeature selectFeature = factory.createSelectFeature();
//      selectFeature.setFeature(feature);
//      selectFeature.setId("-" + featureId);
//      result.add(selectFeature);
//
//      DeselectFeature deselectFeature = factory.createDeselectFeature();
//      deselectFeature.setFeature(feature);
//      deselectFeature.setId("+" + featureId);
//      result.add(deselectFeature);
//
//      return result;
//   }

   @Override
   public void terminate() {}

   @Override
   public Map< ? , ? > getOptions() {
      return Collections.singletonMap(IRbactextOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
   }

}
