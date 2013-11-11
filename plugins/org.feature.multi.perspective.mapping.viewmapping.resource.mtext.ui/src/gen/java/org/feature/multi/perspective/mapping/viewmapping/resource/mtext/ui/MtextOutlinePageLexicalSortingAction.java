/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

public class MtextOutlinePageLexicalSortingAction extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.AbstractMtextOutlinePageAction {
	
	public MtextOutlinePageLexicalSortingAction(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
