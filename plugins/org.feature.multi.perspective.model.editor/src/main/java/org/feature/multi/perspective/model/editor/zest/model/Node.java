/**
 * 
 */
package org.feature.multi.perspective.model.editor.zest.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author winkelti
 *
 */
public abstract class Node {
	private List<Node> connectedTo = new LinkedList<Node>();
	
	public abstract String getName();

	/**
	 * @return the connectedTo
	 */
	public List<Node> getConnectedTo() {
		return connectedTo;
	}


}
