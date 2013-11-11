/**
 * 
 */
package org.feature.transform.splot2fm.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.feature.transform.splot2fm.TransformationPlugin;


/**
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 *
 */
public abstract class AbstractGenCommandHandler extends AbstractHandler {

   private static Logger log = Logger.getLogger(AbstractGenCommandHandler.class);
   
   protected List<IFile> getFilesFromWorkspace(){
      IWorkbench workbench = TransformationPlugin.getDefault().getWorkbench();
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
                           files.addAll(getFiles(resource));
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

   private List<IFile> getFiles(IResource resource) throws CoreException {
      List<IFile> files = new ArrayList<IFile>(2);
      if (resource != null) {
         if (resource instanceof IFile) {
            IFile file = (IFile) resource;
            files.add(file);
         } else if (resource instanceof IFolder) {
            IFolder folder = (IFolder) resource;
            IResource[] folderMember = folder.members();
            for (IResource iResource : folderMember) {
               files.addAll(getFiles(iResource));
            }
         } else if (resource instanceof IProject){
            IProject project = (IProject) resource;
            IResource[] members = project.members();
            for (IResource iResource : members) {
               files.addAll(getFiles(iResource));
            }
         }
      }
      return files;
   }
   
   
}
