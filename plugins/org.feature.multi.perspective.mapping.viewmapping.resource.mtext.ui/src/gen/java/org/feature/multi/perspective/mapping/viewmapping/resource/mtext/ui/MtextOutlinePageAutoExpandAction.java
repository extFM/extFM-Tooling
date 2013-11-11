/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

public class MtextOutlinePageAutoExpandAction extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.AbstractMtextOutlinePageAction {
	
	public MtextOutlinePageAutoExpandAction(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
