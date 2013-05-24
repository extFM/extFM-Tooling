package org.js.model.workflow.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.we.model.view.Diagram;
import org.js.graph.transformation.*;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.Role;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;

/**
 * This class is used as help methods.
 * 
 * @author Xi
 * 
 * 
 */
public class WorkflowUtil {

	public static StakeholderInput SHTempStore = null;

	/**
	 * set the state of given action.
	 * 
	 * @param action
	 */
	public static void setActionState(Action action) {
		Action preAction = getPrecedeAction(action);
		State stateAspect = (State) WorkflowConfUtil.getAspectInstance(action,
				WorkflowConfUtil.STATE_ASPECT);
		if (preAction != null) {
			State preState = (State) WorkflowConfUtil.getAspectInstance(
					preAction, WorkflowConfUtil.STATE_ASPECT);
			if (preState.getState() == StateEnum.COMPLETED) {
				stateAspect.setState(StateEnum.ENABLED);
			} else {
				stateAspect.setState(StateEnum.INACTIVE);
			}
		} else {
			stateAspect.setState(StateEnum.INACTIVE);
		}
	}

	/**
	 * set the state for the given action.
	 * 
	 * @param action
	 * @param state
	 */
	public static void setActionState(Action action, StateEnum state) {
		State stateAspect = (State) WorkflowConfUtil.getAspectInstance(action,
				WorkflowConfUtil.STATE_ASPECT);
		stateAspect.setState(state);
	}

	/**
	 * get the precede action.
	 * 
	 * @param actNode
	 * @return precede action
	 */
	public static Action getPrecedeAction(ActivityNode actNode) {
		Action preAction = null;
		if (actNode.getIn().size() > 0) {
			ActivityEdge actEdge = actNode.getIn().get(0);
			ActivityNode preActNode = actEdge.getSource();
			if (preActNode instanceof Action) {
				preAction = (Action) preActNode;
			} else {
				preAction = getPrecedeAction(preActNode);
			}
		}
		return preAction;
	}

	public static Action getNextAction(ActivityNode actNode) {
		Action preAction = null;
		if (actNode.getIn().size() > 0) {
			ActivityEdge actEdge = actNode.getIn().get(0);
			ActivityNode preActNode = actEdge.getSource();
			if (preActNode instanceof Action) {
				preAction = (Action) preActNode;
			} else {
				preAction = getPrecedeAction(preActNode);
			}
		}
		return preAction;
	}

	/**
	 * get the precede activity node.
	 * 
	 * @param actNode
	 * @return precede activity node
	 */
	public static ActivityNode getPriorActNode(ActivityNode actNode) {
		ActivityEdge actEdge = actNode.getIn().get(0);
		ActivityNode preActNode = actEdge.getSource();
		return preActNode;
	}

	/**
	 * get the next activity nodes.
	 * 
	 * @param actNode
	 * @return
	 */
	public static ArrayList<ActivityNode> getNextActNodes(ActivityNode actNode) {
		EList<ActivityEdge> actEdges = actNode.getOut();
		ArrayList<ActivityNode> preActNodes = new ArrayList<ActivityNode>();
		for (ActivityEdge actEdge : actEdges) {
			preActNodes.add(actEdge.getTarget());
		}
		return preActNodes;
	}

	/**
	 * get the precede activity nodes.
	 * 
	 * @param actNode
	 * @return precede activity nodes
	 */
	public static List<ActivityNode> getPrecedeActNodes(ActivityNode actNode) {
		EList<ActivityEdge> actEdges = actNode.getIn();
		ArrayList<ActivityNode> preActNodes = new ArrayList<ActivityNode>();
		for (ActivityEdge edge : actEdges) {
			preActNodes.add(edge.getSource());
		}
		return preActNodes;
	}

	/**
	 * store the stakeholder's inputs temporarily
	 * 
	 * @param stakeholderName
	 * @param stakeholderTypeName
	 * @param stakeholderGroupName
	 * @param acm
	 * @param shTypes
	 * @return
	 */
	public static StakeholderInput analyzeShInput(String stakeholderName,
			String stakeholderTypeName, String stakeholderGroupName,
			AccessControlModel acm, EList<Role> shTypes) {
		Role stakeholderType = null;
		Role stakeholderGroupLeader = null;
		for (Role role : shTypes) {
			if (role.getId().equals(stakeholderTypeName)) {
				stakeholderType = role;
				break;
			}
		}
		for (Group group : acm.getGroups()) {
			if (group.getRepresents().getId().equals(stakeholderGroupName)) {
				stakeholderGroupLeader = group.getRepresents();
				break;
			}
		}
		return new StakeholderInput(stakeholderName, stakeholderType,
				stakeholderGroupLeader);
	}
}
