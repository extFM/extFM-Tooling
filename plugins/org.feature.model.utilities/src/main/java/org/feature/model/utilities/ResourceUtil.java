/**
 * 
 */
package org.feature.model.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public final class ResourceUtil {

   private static Logger log = Logger.getLogger(ResourceUtil.class);

   /**
    * refresh the resource file locally in the workspace.
    * 
    * @param modelResource
    */
   public static void refreshModelResource(Resource modelResource) {
      IFile file = getFile(modelResource);
      try {
         if (file != null) {
            file.refreshLocal(IResource.DEPTH_ZERO, null);
         }
      } catch (CoreException e) {
         log.error("Could not refresh featuremodel at path " + file.getName());
      }
   }

   /**
    * get the according resource for a file.
    * 
    * @param file
    * @return
    */
   public static Resource getModelResource(IFile file, ResourceSet resourceSet) {
      Resource resource = null;
      if (file != null && file.exists()) {
         String locationUri = file.getLocationURI().normalize().getPath();
         URI uri = URI.createFileURI(locationUri);
         resource = resourceSet.createResource(uri);
      }
      return resource;
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

   /**
    * Generic method to load a model from a file.
    * 
    * @param file
    * @return
    */
   public static EObject getModel(IFile file, ResourceSet resourceSet) {
      EObject result = null;
      Resource modelResource = getModelResource(file, resourceSet);
      if (modelResource == null) {
         log.warn("The selected resource is not an EMF model,");
      } else {
         try {
            modelResource.load(Collections.EMPTY_MAP);
         } catch (IOException e) {
            log.debug(e.getMessage());
         }
         if (modelResource.isLoaded()) {
            EList<EObject> contents = modelResource.getContents();
            if (contents != null && !contents.isEmpty()) {
               result = contents.get(0);
            }
         }
      }
      return result;
   }

   /**
    * determine the selected files in the workbench.
    * 
    * @return
    */
   public static List<IFile> getSelectedWorkbenchFiles() {
      IWorkbench workbench = UtilityPlugin.getDefault().getWorkbench();
      log.debug("Selected workbench files are: ");
      List<IFile> files = new ArrayList<IFile>(5);
      if (workbench != null) {
         IWorkbenchWindow wbWindow = workbench.getActiveWorkbenchWindow();
         if (wbWindow != null) {
            ISelectionService selectService = wbWindow.getSelectionService();
            if (selectService != null) {
               ISelection selection = selectService.getSelection();
               if (selection instanceof IStructuredSelection) {
                  IStructuredSelection structSelection = (IStructuredSelection) selection;
                  List< ? > selected = structSelection.toList();
                  for (Iterator< ? > iterator = selected.iterator(); iterator.hasNext();) {
                     Object element = (Object) iterator.next();
                     if (element instanceof IAdaptable) {
                        IAdaptable adaptable = (IAdaptable) element;
                        IResource resource = (IResource) adaptable.getAdapter(IResource.class);
                        try {
                           List<IFile> resourceFiles = ResourceUtil.getFiles(resource);
                           files.addAll(resourceFiles);
                        } catch (CoreException e) {
                           log.error("Could not load members of resource '" + resource + "'.");
                           e.printStackTrace();
                        }
                     }
                  }
               }
            }
         }
      }
      return files;
   }

   /**
    * get all files belonging to an iresource recursively.
    * 
    * @param resource
    * @return
    * @throws CoreException
    */
   public static List<IFile> getFiles(IResource resource) throws CoreException {
      List<IFile> files = new ArrayList<IFile>(2);
      if (resource != null) {
         if (resource instanceof IFile) {
            IFile file = (IFile) resource;
            files.add(file);
            log.debug("File " + file.getName());
         } else if (resource instanceof IFolder) {
            IFolder folder = (IFolder) resource;
            IResource[] folderMember = folder.members();
            for (IResource iResource : folderMember) {
               files.addAll(getFiles(iResource));
            }
         } else if (resource instanceof IProject) {
            IProject project = (IProject) resource;
            IResource[] members = project.members();
            for (IResource iResource : members) {
               files.addAll(getFiles(iResource));
            }
         }
      }
      return files;
   }

   /**
    * save the feature model in the file system.
    * 
    * @param model
    * @param fileName
    */
   public static void persistModel(EObject model, String fileName) {
      ResourceSet set = new ResourceSetImpl();
      URI modelURI = URI.createFileURI(fileName);
      Resource modelResource = set.createResource(modelURI);
      modelResource.getContents().add(model);
      try {
         modelResource.save(null);
         log.info("Model saved to " + fileName);
         ResourceUtil.refreshModelResource(modelResource);
      } catch (IOException e) {
         log.error("Could not save model to path " + fileName);
         log.error(e.getMessage());
      }
   }

   /**
    * get a folder from the workspace that is a member if the given project
    * 
    * @param folderName
    * @return
    */
   public static IFolder getProjectFolder(String folderName, IProject project) {
      IFolder projectFolder = null;
      if (project != null) {
         projectFolder = project.getFolder(folderName);
         if (!projectFolder.exists()) {
            try {
               projectFolder.create(false, true, null);
            } catch (CoreException e) {
               log.error("Could not create Folder " + folderName);
            }
         }
      }
      return projectFolder;
   }

   /**
    * get a project from the workspace. if it does not exist it, create it.
    * 
    * @param projectName
    * @return
    */
   public static IProject getProject(String projectName) {
      IWorkspace workspace = ResourcesPlugin.getWorkspace();
      IProject project = workspace.getRoot().getProject(projectName);
      try {
         if (!project.exists()) {
            project.create(new NullProgressMonitor());
         }
         openProject(project);
      } catch (CoreException e) {
         log.error("Unable to find or create project '" + projectName + "' in workspace.");
      }
      return project;

   }

   /**
    * Open a project in the workspace.
    * 
    * @param project
    */
   public static void openProject(IProject project) {
      try {
         if (!project.isOpen()) {
            project.open(new NullProgressMonitor());
         }
      } catch (CoreException e) {
         log.error("Unable to open project '" + project.getName() + "'.");
      }
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

}
