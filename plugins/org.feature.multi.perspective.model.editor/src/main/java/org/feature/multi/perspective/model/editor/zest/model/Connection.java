package org.feature.multi.perspective.model.editor.zest.model;

/**
 * This class represents a connection between two {@link Node}.
 * @author Tim Winkelmann
 *
 */
public class Connection {
	private Node sourceNode;
	private Node targetNode;
	
	/**
	 * creates a connection between two nodes.
	 * @param src the source {@link Node}.
	 * @param target the target {@link Node}.
	 */
	public Connection(Node src, Node target) {
		this.sourceNode = src;
		this.targetNode = target;
	}
	
	/**
	 * No Label required.
	 * @return an empty string.
	 */
	public String getLabel() {
		return "";
	}

	/**
	 * get the source node.
	 * @return the sourceNode.
	 */
	public Node getSourceNode() {
		return sourceNode;
	}

	/**
	 * get the target node.
	 * @return the targetNode
	 */
	public Node getTargetNode() {
		return targetNode;
	}
}
