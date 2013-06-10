package org.js.model.workflow.graphtransformation;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.js.graph.transformation.Edge;
import org.js.graph.transformation.Node;

/**
 * This class is used to store a rule's left side reference in the given
 * workflow.
 * 
 * @author Xi
 * 
 */
public class LeftSideRef {
	// containers used to map elements of rules onto elements of workflow model
	HashMap<Node, ActivityNode> activityNodesMap = new HashMap<Node, ActivityNode>();
	HashMap<Edge, ActivityEdge> activityEdgesMap = new HashMap<Edge, ActivityEdge>();
	ArrayList<ActivityNode> activityNodes = new ArrayList<ActivityNode>();
	ArrayList<ActivityEdge> activityEdges = new ArrayList<ActivityEdge>();

//	public LeftSideRef(HashMap<Node, ActivityNode> activityNodesMap,
//			HashMap<Edge, ActivityEdge> activityEdgesMap,
//			ArrayList<ActivityNode> activityNodes,ArrayList<ActivityEdge> activityEdges) {
//		this.activityNodesMap=activityNodesMap;
//		this.activityEdgesMap=activityEdgesMap;
//		this.activityNodes=activityNodes;
//		this.activityEdges=activityEdges;
//	}
	public static LeftSideRef createLeftSideRef(LeftSideRef leftSideRef){
		LeftSideRef newleftSideRef = new LeftSideRef();
		newleftSideRef.getEdges().addAll(leftSideRef.getEdges());
		newleftSideRef.getNodes().addAll(leftSideRef.getNodes());
		newleftSideRef.getActivityNodesMap().putAll(leftSideRef.getActivityNodesMap());
		newleftSideRef.getActivityEdgesMap().putAll(leftSideRef.getActivityEdgesMap());
		return newleftSideRef;
	}


	public void setActivityNodesMap(HashMap<Node, ActivityNode> activityNodesMap) {
		this.activityNodesMap = activityNodesMap;
	}


	public void setActivityEdgesMap(HashMap<Edge, ActivityEdge> activityEdgesMap) {
		this.activityEdgesMap = activityEdgesMap;
	}


	public void setActivityNodes(ArrayList<ActivityNode> activityNodes) {
		this.activityNodes = activityNodes;
	}


	public void setActivityEdges(ArrayList<ActivityEdge> activityEdges) {
		this.activityEdges = activityEdges;
	}


	public ArrayList<ActivityNode> getNodes() {
		return activityNodes;
	}

	public ArrayList<ActivityEdge> getEdges() {
		return activityEdges;
	}

	public ActivityNode getNodeRef(Node node) {
		return activityNodesMap.get(node);
	}

	public ActivityEdge getEdgeRef(Edge edge) {
		return activityEdgesMap.get(edge);
	}

	public HashMap<Node, ActivityNode> getActivityNodesMap() {
		return activityNodesMap;
	}

	public HashMap<Edge, ActivityEdge> getActivityEdgesMap() {
		return activityEdgesMap;
	}

}
