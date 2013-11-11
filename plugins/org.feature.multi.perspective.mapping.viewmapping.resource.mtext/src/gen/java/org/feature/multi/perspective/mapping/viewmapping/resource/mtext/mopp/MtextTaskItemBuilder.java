/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * The MtextTaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class MtextTaskItemBuilder {
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTaskItem> taskItems = new java.util.ArrayList<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTaskItem>();
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTaskItemDetector taskItemDetector = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextStreamUtil.getContent(inputStream);
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextScanner lexer = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation().createLexer();
			lexer.setText(content);
			
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextPlugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextPlugin.logError("Exception while searching for task items", e);
		}
		
		for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
		}
	}
	
	public String getBuilderMarkerId() {
		return org.eclipse.core.resources.IMarker.TASK;
	}
	
	public boolean isInBinFolder(org.eclipse.core.resources.IFile resource) {
		org.eclipse.core.resources.IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
