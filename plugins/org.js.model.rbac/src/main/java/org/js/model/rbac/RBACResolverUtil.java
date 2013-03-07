/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.rbac;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public final class RBACResolverUtil {

   /**
    * find the feature identified by the given id in any feature model referenced by the given accesscontrol model;
    * 
    * @return
    */
   public static Feature findFeature(AccessControlModel model, String featureId) {
      Assert.isNotNull(featureId);
      Assert.isNotNull(model);

      Feature result = null;
      EList<FeatureModel> featureModels = model.getFeatureModels();
      for (FeatureModel featureModel : featureModels) {
         TreeIterator<Object> allContents = EcoreUtil.getAllContents(featureModel, true);
         while (allContents.hasNext()) {
            Object next = allContents.next();
            if (next instanceof Feature) {
               Feature feature = (Feature) next;
               String refFeatureId = EcoreUtil.getID(feature);
               if (featureId.equals(refFeatureId)) {
                  result = feature;
                  break;
               }
            }
         }
      }
      return result;
   }

   public static Attribute findAttribute(Feature feature, String attributeId) {
      Assert.isNotNull(feature);
      Assert.isNotNull(attributeId);

      Attribute result = null;
      EList<Attribute> attributes = feature.getAttributes();
      for (Attribute attribute : attributes) {
         String attributeName = attribute.getName();
         if (attributeId.equals(attributeName)) {
            result = attribute;
            break;
         }
      }
      return result;
   }

   /**
    * find the relative uri for the given EObjects.
    * 
    * @param objectToConvert
    * @param baseObject
    * @return
    */
   public static String getRelativeURI(EObject objectToConvert, EObject baseObject) {
      String relative = null;

      if (objectToConvert != null && baseObject != null) {
         // return relative uri
         java.net.URI objectToConvertUri = getContainerURI(objectToConvert.eResource());
         java.net.URI baseObjectUri = getContainerURI(baseObject.eResource());
         if (objectToConvertUri != null && baseObjectUri != null) {
            java.net.URI relativeUri = URIUtil.makeRelative(objectToConvertUri, baseObjectUri);
            relative = relativeUri.toString();
            // add filename
            String fileName = getFileName(objectToConvert);
            relative += "/" + fileName;
         }
      }
      return relative;
   }
   
   
   private static String getFileName(EObject eObject) {
      String fileName = null;
      IFile file = getFile(eObject.eResource());
      if (file != null) {
         fileName = file.getName();
      }
      return fileName;
   }

   private static java.net.URI getContainerURI(Resource resource) {
      java.net.URI parent = null;
      IFile file = getFile(resource);
      if (file != null) {
         IContainer container = file.getParent();
         if (container != null) {
            parent = container.getRawLocationURI();
         }
      }
      return parent;
   }

   
   /**
    * get the ifile representation of a resource.
    * 
    * @param modelResource
    * @return
    */
   public static IFile getFile(Resource modelResource) {
      IFile file = WorkspaceSynchronizer.getFile(modelResource);
      return file;
   }
}
