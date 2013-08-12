/**
 * 
 */
package org.js.model.feature.csp;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;

/**
 * @author Julia
 * 
 */
public class GenerateVariantHandler extends AbstractFeatureModelCommandHandler {

	Logger log = Logger.getLogger(GenerateVariantHandler.class);
	String handledCommandId = "org.js.model.feature.csp.generateVariant";

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<IFile> files = getSelectedWorkbenchFiles(event);
			// persist one variant
			int numberOfVariantsToPersist = 1;
			boolean findAll = false;
			CSPAnalyzer.analyze(files, numberOfVariantsToPersist, findAll);
		return null;
	}

	@Override
	protected Logger getLog() {
		return log;
	}

}
