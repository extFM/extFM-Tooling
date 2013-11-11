/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

public class MtextOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
