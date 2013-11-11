/**
 * 
 */
package org.feature.transform.splot2fm.handler;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.feature.model.utilities.FeatureModelInit;
import org.js.model.feature.FeatureModel;

/**
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class MakeNamesUniqueCommandHandler extends AbstractGenCommandHandler {

   private static Logger log = Logger.getLogger(MakeNamesUniqueCommandHandler.class);
   
   @Override
   public Object execute(ExecutionEvent event) throws ExecutionException {
      ResourceSetImpl resourceSet = new ResourceSetImpl();
      List<IFile> files = getFilesFromWorkspace();
      for (IFile iFile : files) {
         FeatureModel featureModel = FeatureModelInit.getFeatureModel(iFile, resourceSet);
         if (featureModel != null) {
            boolean isChanged = FeatureModelInit.makeFeatureIdsUnique(featureModel);
            if (isChanged) {
               FeatureModelInit.persistFMFeatureModel(featureModel, iFile.getRawLocation().toOSString());
            } else {
               log.info("Nothing changed. Feature names are already unique.");
            }
         }
      }
      return null;
   }

}
