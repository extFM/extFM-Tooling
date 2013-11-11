/**
 * 
 */
package org.feature.model.utilities;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * workspace utility class to access the eclipse workspace.
 * 
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class WorkbenchUtil {

   /**
    * find the currently active editor. May return null, if no editor is active.
    * 
    * @return
    */
   public static IEditorPart getActiveEditor() {
      IEditorPart activeEditor = null;

      IWorkbenchPage page = getActivePage();
      if (page != null) {
         activeEditor = page.getActiveEditor();
      }
      return activeEditor;
   }

   public static IWorkbenchPage getActivePage() {
      IWorkbenchPage page = null;
      IWorkbench workbench = PlatformUI.getWorkbench();
      if (workbench != null) {
         IWorkbenchWindow activeWindow = workbench.getActiveWorkbenchWindow();
         if (activeWindow != null) {
            page = activeWindow.getActivePage();
         }
      }
      return page;
   }

   /**
    * get the current shell from the active editor;
    * 
    * @return
    */
   public static Shell getShell() {
      Shell shell = null;
      IWorkbenchPage activePage = getActivePage();
      if (activePage != null) {
         IEditorPart activeEditor = getActiveEditor();
         if (activeEditor != null) {
            shell = activeEditor.getSite().getShell();
         } else {
            IWorkbenchPart activePart = activePage.getActivePart();
            if (activePart != null) {
               shell = activePart.getSite().getShell();
            }
         }
      }
      return shell;
   }

}
