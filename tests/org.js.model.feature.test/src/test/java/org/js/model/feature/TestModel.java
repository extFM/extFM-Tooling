package org.js.model.feature;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.resource.eft.mopp.EftResourceFactory;

public class TestModel {

   private FeatureModel featureModel;

   private ResourceSet resourceSet = new ResourceSetImpl();
   
   public TestModel() {
      loadTestModels();
   }

   private void loadTestModels() {
      featureModel = (FeatureModel) loadTestModel("smallfm.eft", "eft", new EftResourceFactory());
   }

   private EObject loadTestModel(String filename, String suffix, Factory resourceFactory) {
      resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(suffix, resourceFactory);
      URL fileresource = this.getClass().getClassLoader().getResource(filename);
      String path = fileresource.getPath();
      URI uri = URI.createFileURI(path);
      Resource resource = resourceSet.getResource(uri, true);
      try {
         resource.load(Collections.EMPTY_MAP);
         System.out.println("Loaded " + uri);
         
         EList<EObject> contents = resource.getContents();
         if (contents != null && !contents.isEmpty()) {
            return contents.get(0);
         }
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return null;
   }

  
   FeatureModel getFMTestModel() {
      return featureModel;
   }

}
