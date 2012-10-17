/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.rbac.resource.rbactext.mopp;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.rbac.resource.rbactext.IRbactextBuilder;

public class RbactextBuilder implements IRbactextBuilder {

   public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
      // change this to return true to enable building of all resources
      return false;
   }

   public org.eclipse.core.runtime.IStatus build(RbactextResource resource, IProgressMonitor monitor) {
      copyContentAndSave(resource, monitor);
      return org.eclipse.core.runtime.Status.OK_STATUS;
   }

   private void copyContentAndSave(RbactextResource resource, IProgressMonitor monitor) {
      // get contents and create copy
      EList<EObject> contents = resource.getContents();
      Collection<EObject> contentsCopy = EcoreUtil.copyAll(contents);

      // create new resource with different name
      URI newUri = URI.createURI("copy.rbac").resolve(resource.getURI());
      Resource newResource = resource.getResourceSet().createResource(newUri);
      // add copy of original content to new resource
      newResource.getContents().addAll(contentsCopy);
      // save new resource
      try {
         resource.save(null);
         newResource.save(null);
      } catch (IOException e) {
         // handle exception
      }
   }

   /**
    * Handles the deletion of the given resource.
    */
   public org.eclipse.core.runtime.IStatus handleDeletion(org.eclipse.emf.common.util.URI uri,
                                                          org.eclipse.core.runtime.IProgressMonitor monitor) {
      URI copiedUri = URI.createURI("copy.rbac").resolve(uri);
      Resource copiedResource = new ResourceSetImpl().getResource(copiedUri, false);
      if (copiedResource != null) {
         try {
            copiedResource.delete(null);
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      return org.eclipse.core.runtime.Status.OK_STATUS;
   }

}
