/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

public class MtextOutlinePageTypeSortingAction extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.AbstractMtextOutlinePageAction {
	
	public MtextOutlinePageTypeSortingAction(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
