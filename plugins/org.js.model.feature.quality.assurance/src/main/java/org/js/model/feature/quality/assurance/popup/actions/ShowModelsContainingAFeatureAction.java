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
		// jump out test
		if(currentSelection == null || currentSelection.isEmpty()) {
			MessageDialog.openError(
					shell, 
					"Quality Assurance", 
					"There is no folder selected. Please select a folder and then execute this command.");
			return;
		}
		
		// get files
		List<IFile> files = QAPluginHelper.getFilesFromFolderSelection(currentSelection);
		if(files == null) {
			MessageDialog.openError(shell, "Quality Assurance", "An error occured during selection retrieval.");
			log.debug("An error occured during selection retrieval.");
			return;
		}
		
		// get feature under test
		
		// - take a model
		FeatureModel model = null;
		for (IFile f : files) {
			FeatureModel fm = FeatureModelHelper.getFeatureModel(f);
			if(fm != null) {
				model = fm;
				break;
			}
		}
		if(model == null) {
			MessageDialog.openError(shell, "Quality Assurance", "No model found in this folder.");
			log.debug("No model found in this folder.");
			return;
		}
		// - extract all features
		FeatureModelHelper modelhelper = new FeatureModelHelper(model);
		Set<Feature> modelfeatures = modelhelper.getAllFeatures();
		List<String> modelfeatures_ids = new ArrayList<String>();
		for (Feature f : modelfeatures) {
			modelfeatures_ids.add(f.getId().toString());
		}
		ElementListSelectionDialog selectFeatureDialog = new ElementListSelectionDialog(shell, new LabelProvider());
		selectFeatureDialog.setElements(modelfeatures_ids.toArray());
		selectFeatureDialog.setTitle("Quality Assurance");
		selectFeatureDialog.setMessage("Please select the desired feature (ID) under test.");
		selectFeatureDialog.setMultipleSelection(false);
		if (selectFeatureDialog.open() != Window.OK) {
			log.debug("No feature selected.");
		    return;
		}
		String result = (String)(selectFeatureDialog.getResult()[0]);
		log.info("The feature " + result + " will be tested.");
		Feature featureundertest = modelhelper.getFeature(result);
		
		// run algorithm
		QAShowModelsContainingAFeature analyzer = new QAShowModelsContainingAFeature(files, featureundertest);
		Set<FeatureModel> results = analyzer.getAllModelsContainingTheFeature();
		
		// generate output
		log.info("===================================================================");
		log.info("Quality Assurance - Plugin - ShowModelsContainingAFeatureAction");
		log.info("===================================================================");
		log.info("Number of configurations found: " + results.size());
		log.info("The following models can be indentifyed to contain " + featureundertest.getId() + ":");
		for (FeatureModel resultsmodel : results) {
			log.info("  * " + resultsmodel.getName());
		}
		log.info("===================================================================");
		
		MessageDialog.openInformation(shell, 
				"Quality Assurance", 
				"There are " + results.size() + " configurations that contain the feature " + featureundertest.getId() + ". " +
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
