package org.js.model.feature.quality.assurance.popup.actions;

import java.util.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.js.model.feature.quality.assurance.QAPluginHelper;

public class ShowFeatureDependenciesAction implements IObjectActionDelegate {
	
	private Shell shell;
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
		
		// get feature under test
		//TODO implementation
		
		// run algorithm
		//TODO implementation
		
		// generate output
		//TODO implementation
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		// update current selection
		currentSelection = selection;
	}

}
