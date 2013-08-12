package org.js.model.feature.csp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.MessageDialog;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.csp.dialog.SatisfiabilityDialog;
import org.js.model.feature.csp.dialog.SatisfiableFile;

public class FeatureModelSatisfiabilityHandler extends
		AbstractFeatureModelCommandHandler {

	String handledCommandId = "org.js.featuremodel.efm.satisfiable";

	private static Logger log = Logger
			.getLogger(FeatureModelSatisfiabilityHandler.class);

	private List<SatisfiableFile> fileList;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<IFile> files = getSelectedWorkbenchFiles(event);
		fileList = new ArrayList<SatisfiableFile>(files.size());
		for (IFile iFile : files) {
			boolean isSatisfiable = CSPAnalyzer.isSatisfiable(iFile);
			String fileName = iFile.getName();
			FeatureModel featureModel = FeatureModelHelper.getFeatureModel(iFile);
			String featureModelName = featureModel != null ? featureModel.getName() : "not a feature model";
			SatisfiableFile satFile = new SatisfiableFile(fileName,
					isSatisfiable,featureModelName);
			fileList.add(satFile);
		}
		showResultDialog();
		return null;
	}

	private void showResultDialog() {
		SatisfiabilityDialog dialog = new SatisfiabilityDialog(null, "Satisfiability Check",
				null, "Result of the Satisfiability Check:",
				MessageDialog.INFORMATION, new String[] { "Ok" }, 0);
		dialog.setFileList(fileList);
		dialog.open();
	}

	@Override
	protected Logger getLog() {
		return log;
	}

}
