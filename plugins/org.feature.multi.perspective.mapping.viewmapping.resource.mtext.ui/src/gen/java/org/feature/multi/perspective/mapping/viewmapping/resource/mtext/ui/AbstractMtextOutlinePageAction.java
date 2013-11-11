/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

public abstract class AbstractMtextOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewer treeViewer;
	
	public AbstractMtextOutlinePageAction(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override	
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		org.eclipse.swt.custom.BusyIndicator.showWhile(org.eclipse.swt.widgets.Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
