/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

public class MtextOutlinePageCollapseAllAction extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.AbstractMtextOutlinePageAction {
	
	public MtextOutlinePageCollapseAllAction(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Collapse all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/collapse_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().collapseAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
