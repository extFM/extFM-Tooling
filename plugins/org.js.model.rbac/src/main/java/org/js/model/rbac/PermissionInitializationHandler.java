/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.rbac;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.emftext.access.EMFTextAccessProxy;
import org.emftext.access.resource.IEditor;
import org.emftext.access.resource.IResource;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class PermissionInitializationHandler extends AbstractHandler {

   private boolean enabled = false;
   EditingDomain domain;

   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      final AccessControlModel model;
      try {
         model = getModel(event);
      } catch (IOException e1) {
         // TODO Auto-generated catch block
        throw new ExecutionException(e1.getMessage(), e1.getCause());
      }

      ChangeCommand changeCommand = new ChangeCommand(model) {

         @Override
         protected void doExecute() {
            executeCommand(model);
         }
      };
      domain.getCommandStack().execute(changeCommand);

      try {
         model.eResource().save(null);
      } catch (IOException e) {
         throw new ExecutionException(e.getMessage(), e.getCause());
      }
      return null;
   }

   private void executeCommand(AccessControlModel model) {
      PermissionInitialization init = new PermissionInitialization(model);
      init.initPermissions();
   }

   /**
    * get the model from the execution context.
    * 
    * @param event
    * @return
    * @throws IOException 
    */
   protected AccessControlModel getModel(ExecutionEvent event) throws IOException{
      AccessControlModel model = null;
      IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
      IEditor iEditor = EMFTextAccessProxy.get(activeEditor, IEditor.class);
      IResource resource = iEditor.getResource();
      
      if (resource.isModified()){
         resource.save(null);
      }
      
      EObject eObject = resource.getContents().get(0);

      EObject rootContainer = EcoreUtil.getRootContainer(eObject);
      if (rootContainer instanceof AccessControlModel) {
         model = (AccessControlModel) rootContainer;
      }
      return model;
   }

   @Override
   public boolean isEnabled() {
      return enabled;
   }

   @Override
   public void setEnabled(Object evaluationContext) {
      enabled = false;
      IWorkbench workbench = PlatformUI.getWorkbench();
      if (workbench != null) {
         IWorkbenchWindow activeWindow = workbench.getActiveWorkbenchWindow();
         ISelectionService selectionService = activeWindow.getSelectionService();
         ISelection selection = selectionService.getSelection();

         if (activeWindow != null) {
            IWorkbenchPage page = activeWindow.getActivePage();
            if (page != null) {
               IEditorPart editor = page.getActiveEditor();
               if (editor instanceof IEditingDomainProvider) {
                  IEditingDomainProvider editDomainProvider = (IEditingDomainProvider) editor;
                  domain = editDomainProvider.getEditingDomain();
                  ISelection editorSelection = editor.getEditorSite().getSelectionProvider().getSelection();
                  enabled = selection.equals(editorSelection);
               }
            }
         }
      }
   }

}
