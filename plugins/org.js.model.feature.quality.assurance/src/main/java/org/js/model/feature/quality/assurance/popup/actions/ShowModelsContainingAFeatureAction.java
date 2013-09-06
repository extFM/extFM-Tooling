package org.js.model.feature.quality.assurance.popup.actions;

import java.util.*;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.csp.FeatureModelHelper;
import org.js.model.feature.quality.assurance.QAPluginHelper;
import org.js.model.feature.quality.assurance.QAShowModelsContainingAFeature;
import org.js.model.feature.quality.assurance.analyze.FeatureBasedStructureAnalyzer;

public class ShowModelsContainingAFeatureAction implements IObjectActionDelegate {
	
	private Shell shell;
	private Logger log = Logger.getLogger(ShowDeselectedFeaturesAction.class);
	private ISelection currentSelection; 
	
	/**
	 * Constructor for ShowModelsContainingAFeatureAction.
	 */
	public ShowModelsContainingAFeatureAction() {
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
		if(models == null || models.isEmpty()) {
			MessageDialog.openError(shell, "Quality Assurance", "An error occured during feature model retrieval." + 
					" Propably there is no feature model in this selection.");
			log.debug("An error occured during feature model retrieval.");
			return;
		}
		FeatureModel model = (FeatureModel)(models.toArray()[0]);
		Feature feature = QAPluginHelper.selectFeature(shell, model);
		if(feature == null) {
			MessageDialog.openError(shell, "Quality Assurance", "No feature has been selected.");
			log.debug("No feature has been selected.");
			return;
		}
		
		// run algorithm
		FeatureBasedStructureAnalyzer analyzer;
		try {
			analyzer = new FeatureBasedStructureAnalyzer(models, model, feature);
		} catch (Exception e) {
			MessageDialog.openError(shell, "Quality Assurance", e.getMessage());
			log.error(e.getMessage());
			return;
		}
		Set<FeatureModel> results = analyzer.getFeatureModelsContainingFeature();
		
		// generate output
		log.info("===================================================================");
		log.info("Quality Assurance - Plugin - ShowModelsContainingAFeatureAction");
		log.info("===================================================================");
		log.info("Number of configurations found: " + results.size());
		log.info("The following models can be indentifyed to contain " + feature.getId() + ":");
		for (FeatureModel resultsmodel : results) {
			log.info("  * " + resultsmodel.getName());
		}
		log.info("===================================================================");
		
		MessageDialog.openInformation(shell, 
				"Quality Assurance", 
				"There are " + results.size() + " configurations that contain the feature " + feature.getId() + ". " +
				"For further information, please have a look at the logger output.");
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// update current selection
		currentSelection = selection;
	}

}
