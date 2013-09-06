package org.js.model.feature.quality.assurance;

import java.util.*;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.*;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.js.model.feature.*;
import org.js.model.feature.csp.FeatureModelHelper;

/**
 * This class offers static functionalities to interact with Eclipse
 * @author David Gollasch (<a href="mailto:david@gollasch-it.de">david@gollasch-it.de</a>)
 */
public class QAPluginHelper {

	/**
	 * Takes a selection and if it's a folder selection it will return a 
	 * list with all directly sub ordered files of this folder 
	 * @param selection The selection (a folder has to be selected to run correctly)
	 * @return A list of files if <code>selection</code> is a folder selection 
	 * 			and if this folder includes files
	 */
	public static List<IFile> getFiles(ISelection selection) {
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection issl = (IStructuredSelection)selection;
			Object obj = issl.getFirstElement();
			IFolder folder = (IFolder) Platform.getAdapterManager().getAdapter(obj, IFolder.class);
			if(folder == null) {
				if(obj instanceof IAdaptable) {
					folder = (IFolder)((IAdaptable)obj).getAdapter(IFolder.class);
				} else {
					// (state) no folder found
					// return no list
					return null;
				}
			}
			
			// (state) folder grabbed
			
			ArrayList<IResource> includedelements = new ArrayList<IResource>();
			try {
				includedelements.addAll(Arrays.asList(folder.members()));
			} catch (CoreException e) {
				// exception reasons:
				// no resource existing or resource is a closed project
				
				// leave the includedelements list empty
			}
			
			// (state) all sub ordered resources grabbed
			
			List<IFile> includedfiles = new ArrayList<IFile>();
			
			for (IResource ir : includedelements) {
				if(ir.getType() == IResource.FILE) {
					includedfiles.add((IFile)(ir.getAdapter(IFile.class)));
				}
			}
			
			// (state) all sub ordered files grabbed
			
			return includedfiles;
			
		}
		
		return null;
	}
	
	/**
	 * Converts a list of files into a set of feature models
	 * (only valid feature models will be returned and invalid
	 * files will be ignored)
	 * @param files The list of files
	 * @return A set of feature models
	 */
	public static Set<FeatureModel> getFeatureModels(List<IFile> files) {
		Set<FeatureModel> models = new HashSet<FeatureModel>();
		
		for (IFile f : files) {
			FeatureModel fm = FeatureModelHelper.getFeatureModel(f);
			if(fm != null)
				models.add(fm);
		}
		
		return models;
	}

	/**
	 * Opens a selection tool that allows the user to select a feature out of a feature model
	 * @param shell The shell to open the tool
	 * @param model The model to choose the the feature of
	 * @return The chosen feature
	 */
	public static Feature selectFeature(Shell shell, FeatureModel model) {
		if(shell == null || model == null) return null;
		Logger log = Logger.getLogger(QAPluginHelper.class);
		// extract all features
		FeatureModelHelper modelhelper = new FeatureModelHelper(model);
		Set<Feature> modelfeatures = modelhelper.getAllFeatures();
		List<String> modelfeatures_ids = new ArrayList<String>();
		for (Feature f : modelfeatures) {
			modelfeatures_ids.add(f.getId().toString());
		}
		// create and open a selection dialog
		ElementListSelectionDialog selectFeatureDialog = new ElementListSelectionDialog(shell, new LabelProvider());
		selectFeatureDialog.setElements(modelfeatures_ids.toArray());
		selectFeatureDialog.setTitle("Quality Assurance");
		selectFeatureDialog.setMessage("Please select the desired feature (ID) under test.");
		selectFeatureDialog.setMultipleSelection(false);
		if (selectFeatureDialog.open() != Window.OK) {
			log.debug("No feature selected.");
		    return null;
		}
		// return the selection
		String result = (String)(selectFeatureDialog.getResult()[0]);
		log.info("The feature " + result + " will be returned.");
		return modelhelper.getFeature(result);
	}
}
