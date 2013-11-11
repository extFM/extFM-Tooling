/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors.listeners;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.feature.multi.perspective.model.viewmodel.CoreGroup;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.model.editor.editors.ViewmodelMultiPageEditor;
import org.feature.multi.perspective.model.editor.util.Matrix;

/**
 * Listener for choosing a {@link ViewPoint} for the {@link ViewPoint} view.
 * @author Tim Winkelmann
 *
 */
public class ViewPointComboSelectionListener implements SelectionListener {

	private ViewmodelMultiPageEditor multiPageEditor;
	
	public ViewPointComboSelectionListener(ViewmodelMultiPageEditor multiPageEditor) {
		this.multiPageEditor = multiPageEditor;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() instanceof Combo) {
			Combo viewPointCombo = (Combo) e.getSource();
			String viewPointName = viewPointCombo.getItems()[viewPointCombo.getSelectionIndex()];
			multiPageEditor.setSelectedViewPoint(viewPointName);
			//create matrix
			new Matrix(getCoreGroup(multiPageEditor.getEditingDomain()));
		}
	}
	
	/**
	 * get the default group from the editing domain
	 * @param editingDomain the editing domain
	 * @return the defaultGroup
	 */
	private CoreGroup getCoreGroup(EditingDomain editingDomain){
		TreeIterator<Notifier> allContents = editingDomain.getResourceSet().getAllContents();
		CoreGroup coreGroup = null;
		while (allContents.hasNext()) {
			Notifier notifier = allContents.next();
			if (notifier instanceof CoreGroup) {
				coreGroup = (CoreGroup) notifier;
				break;
			}
		}
		return coreGroup;
	}
	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		System.out.println("wDS");
	}

}
