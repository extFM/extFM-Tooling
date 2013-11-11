/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

public class MtextOutlinePageLinkWithEditorAction extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.AbstractMtextOutlinePageAction {
	
	public MtextOutlinePageLinkWithEditorAction(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
