/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

public class MtextOutlinePageExpandAllAction extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.AbstractMtextOutlinePageAction {
	
	public MtextOutlinePageExpandAllAction(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
