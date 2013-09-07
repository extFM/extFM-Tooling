package org.js.model.feature.quality.assurance.popup.actions;

import java.util.*;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureConstraint;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.Imply;
import org.js.model.feature.quality.assurance.QAPluginHelper;
import org.js.model.feature.quality.assurance.analyze.FeatureBasedStructureAnalyzer;

public class ShowFeatureDependenciesAction implements IObjectActionDelegate {
	
	private Shell shell;
	private Logger log = Logger.getLogger(ShowDeselectedFeaturesAction.class);
	private ISelection currentSelection; 
	
	/**
	 * Constructor for ShowModelsContainingAFeatureAction.
	 */
	public ShowFeatureDependenciesAction() {
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
		FeatureBasedStructureAnalyzer analyzer = null;
		try {
			analyzer = new FeatureBasedStructureAnalyzer(models, model, feature);
		} catch (Exception e) {
			MessageDialog.openError(shell, "Quality Assurance", e.getMessage());
			log.error(e.getMessage());
			return;
		}
		
		boolean isMandatory;
		try {
			isMandatory = analyzer.isFeatureMandatory();
		} catch (Exception e) {
			MessageDialog.openError(shell, "Quality Assurance", e.getMessage());
			log.error(e.getMessage());
			return;
		}
		Set<FeatureConstraint> affectedConstraints = analyzer.getFeatureConstraintsAffectingFeature();
		
		// generate output
		log.info("===================================================================");
		log.info("Quality Assurance - Plugin - ShowFeatureDependenciesAction");
		log.info("===================================================================");
		log.info("Name of the feature under test: " + feature.getName());
		log.info("ID of the feature under test:   " + feature.getId());
		log.info("-------------------------------------------------------------------");
		log.info("EXPLICIT PROPERTIES:");
		log.info("  * Mandatory: " + (isMandatory ? "yes" : "no"));
		log.info("-------------------------------------------------------------------");
		log.info("AFFECTING FEATURE CONSTRAINTS:");
		for (FeatureConstraint c : affectedConstraints) {
			log.info("  * <" + c.getId() + "> " + c.getLeftOperand().getId() + ((c instanceof Imply) ? " -> " : " <-> ") + c.getRightOperand().getId());
		}
		log.info("===================================================================");
		
		MessageDialog.openInformation(shell, 
				"Quality Assurance", 
				"There are " + affectedConstraints.size() + " feature constraints that affect the feature " + feature.getName() + ". " +
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
