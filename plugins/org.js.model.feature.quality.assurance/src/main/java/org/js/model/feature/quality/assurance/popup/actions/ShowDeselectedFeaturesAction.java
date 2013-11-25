package org.js.model.feature.quality.assurance.popup.actions;

import java.util.*;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.*;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.js.model.feature.*;
import org.js.model.feature.edit.FeatureLabelProvider;
import org.js.model.feature.quality.assurance.*;
import org.js.model.feature.quality.assurance.analyze.*;

public class ShowDeselectedFeaturesAction implements IObjectActionDelegate {

	private Shell shell;
	private Logger log = Logger.getLogger(ShowDeselectedFeaturesAction.class);
	private ISelection currentSelection; 
	
	/**
	 * Constructor for ShowDeselectedFeaturesAction.
	 */
	public ShowDeselectedFeaturesAction() {
		super();
		
		currentSelection = null;
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		// information prepare
		if(currentSelection == null || currentSelection.isEmpty()) {
			MessageDialog.openError(
					shell, 
					"Quality Assurance", 
					"There is no folder selected. Please select a folder and then execute this command.");
			return;
		}
		List<IFile> files = QAPluginHelper.getFiles(currentSelection);
		if(files == null) {
			MessageDialog.openError(shell, "Quality Assurance", "An error occured during selection retrieval.");
			log.debug("An error occured during selection retrieval.");
			return;
		}
		Set<FeatureModel> models = QAPluginHelper.getFeatureModels(files);
		if(models == null) {
			MessageDialog.openError(shell, "Quality Assurance", "An error occured during feature model retrieval.");
			log.debug("An error occured during feature model retrieval.");
			return;
		}
		
		// run algorithm		
		ConfigurationSetStructureAnalyzer analyzer = new ConfigurationSetStructureAnalyzer(models);
		Set<Feature> results = analyzer.getDeselectedFeatures();
		
		// generate output
		log.info("===================================================================");
		log.info("Quality Assurance - Plugin - ShowDeselectedFeaturesAction");
		log.info("===================================================================");
		log.info("Number of constantly deselected features found: " + results.size());
		log.info("The following features are deselected throughout all configurations:");
		String deselected = "";
		FeatureLabelProvider featureLabelProvider = new FeatureLabelProvider();
		for (Feature feature : results) {
		   if (deselected.length() > 0){
		      deselected += ", ";
		   }
		   String featureText = featureLabelProvider.getText(feature);
		   deselected += featureText;
		   log.info("  * " + featureText);
		}
		log.info("===================================================================");
		
		MessageDialog.openInformation(shell, 
				"Quality Assurance", 
				results.size() + " features are deselected in all configurations." +
				"\nThe following features are deselected : " + deselected +
				"\nFor further information, please have a look at the logger output.");
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// update current selection
		currentSelection = selection;
	}

}
