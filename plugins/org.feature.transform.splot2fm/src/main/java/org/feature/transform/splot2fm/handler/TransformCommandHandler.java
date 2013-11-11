package org.feature.transform.splot2fm.handler;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.feature.transform.splot2fm.SXFM2FMTransformator;
import org.js.model.feature.editor.FeatureModelWizard;

public class TransformCommandHandler extends AbstractGenCommandHandler {

   String handledCommandId = "org.js.transform.splot2fm";

   /*
    * (non-Javadoc)
    * 
    * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
    */
   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      String featureModelExtension = "";
      int result = dialogPersistModel();
      switch (result) {
         case 0:
             // EFeatureText
            featureModelExtension = SXFM2FMTransformator.efm_fileextension;
             break;
         case 1:
             // XMI
            List<String> extensions = FeatureModelWizard.FILE_EXTENSIONS;
            if (!extensions.isEmpty()) {
              featureModelExtension = extensions.get(0);
            }
             break;
         case 2:
             // cancel pressed
             return null;
         default:
             break;
         }
      
      
      List<IFile> files = getFilesFromWorkspace();
      SXFM2FMTransformator.parseFiles(files, featureModelExtension);
      return null;
   }

   
   
   
   
   private int dialogPersistModel() {

      MessageDialog dialog = new MessageDialog(null, "Persist Feature Model",
              null, "How to persist feature models?",
              MessageDialog.QUESTION, new String[] { "Textual Notation",
                      "XMI", "Cancel" }, 0);
      int result = dialog.open();
      return result;
  }
   
}
