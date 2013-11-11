/**
 * 
 */
package org.feature.multi.perspective.model.editor.zest.model;

import org.feature.multi.perspective.model.viewmodel.ViewPoint;


/**
 * This class represents the {@link ViewPoint} node.
 * @author Tim Winkelmann
 *
 */
public class ViewPointNode extends Node {
	private ViewPoint viewPoint;
	
	/**
	 * creates a {@link ViewPointNode}.
	 * @param viewPoint used to give the {@link Node} its name and the symbol.
	 */
	public ViewPointNode(ViewPoint viewPoint) {
		this.viewPoint = viewPoint;
	}
	
	/* (non-Javadoc)
	 * @see org.feature.multi.perspective.model.editor.zest.model.Node#getName()
	 */
	@Override
	public String getName() {
		return viewPoint.getName();
	}

	/**
	 * @return the {@link ViewPoint}
	 */
	public ViewPoint getViewPoint() {
		return viewPoint;
	}

}
