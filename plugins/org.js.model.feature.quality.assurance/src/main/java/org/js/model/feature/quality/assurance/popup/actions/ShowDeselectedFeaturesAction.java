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
import org.js.model.feature.quality.assurance.QAShowDeselectedFeatures;
import org.js.model.feature.quality.assurance.QAPluginHelper;

public class ShowDeselectedFeaturesAction implements IObjectActionDelegate {

	private Shell shell;
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
		
		// run algorithm
		QAShowDeselectedFeatures analyzer = new QAShowDeselectedFeatures(files);
		Set<Feature> results = analyzer.getAllDeselectedFeatures();
		
		// generate output
		Logger log = Logger.getLogger(ShowDeselectedFeaturesAction.class);
		log.info("===================================================================");
		log.info("Quality Assurance - Plugin - ShowDeselectedFeaturesAction");
		log.info("===================================================================");
		log.info("Number of constantly deselected features found: " + results.size());
		log.info("The following fetures are deselected throughout all configurations:");
		for (Feature feature : results) {
			log.info("  * " + feature.getName() + " (" + feature.getId() + ")");
		}
		log.info("===================================================================");
		
		MessageDialog.openInformation(shell, 
				"Quality Assurance", 
				"There are " + results.size() + " Features that are deselected in all configurations. " +
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
