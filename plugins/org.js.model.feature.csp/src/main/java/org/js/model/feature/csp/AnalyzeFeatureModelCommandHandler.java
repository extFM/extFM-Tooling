package org.js.model.feature.csp;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * Default command handler that invokes an analysis on a selected featuremodel
 * in the workbench.
 * 
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class AnalyzeFeatureModelCommandHandler extends
		AbstractFeatureModelCommandHandler {

	String handledCommandId = "org.js.featuremodel.efm.analyze";

	private static Logger log = Logger
			.getLogger(AnalyzeFeatureModelCommandHandler.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<IFile> files = getSelectedWorkbenchFiles();
		// ask for a number of variants to be persisted
		// Customized MessageDialog with configured buttons
		int result = dialogPersistVariants(files);
		switch (result) {
		case 0:
			CSPAnalyzer.analyze(files, true);
			break;
		case 1:
			CSPAnalyzer.analyze(files, result);
			break;
		case 2:
			CSPAnalyzer.analyze(files, false);
			break;
		default:
			CSPAnalyzer.analyze(files, false);
			break;
		}
		return null;
	}

	private int dialogPersistVariants(List<IFile> files) {

		MessageDialog dialog = new MessageDialog(null, "Persist Variants",
				null, "Shall variants of the selected feature model files \""
						+ getText(files) + "\" be persisted?",
				MessageDialog.QUESTION, new String[] { "Yes, all",
						"Yes, only one", "No" }, 0);
		int result = dialog.open();
		return result;
	}

	@Override
	protected Logger getLog() {
		return log;
	}

}
