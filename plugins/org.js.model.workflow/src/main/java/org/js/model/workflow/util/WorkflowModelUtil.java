package org.js.model.workflow.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.core.PackageableElement;
import org.eclipse.jwt.meta.model.events.Event;
import org.eclipse.jwt.meta.model.events.EventsFactory;
import org.eclipse.jwt.meta.model.organisations.OrganisationsFactory;
import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.FinalNode;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.eclipse.jwt.meta.model.processes.InitialNode;
import org.eclipse.jwt.meta.model.processes.JoinNode;
import org.eclipse.jwt.meta.model.processes.ProcessesFactory;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;

/**
 * This class provides methods relating to jwt meta model.
 * 
 * @author Xi
 * 
 */
public class WorkflowModelUtil {

	public static final String SPECIALIZATION_ACTION = "Specialization";
	public static final String IDLE_ACTION = "Idle";
	public static final String INITIAL_NODE = "InitialNode";
	public static final String ACTIVITY_FINAL_NODE = "ActivityFinalNode";

	public static ProcessesFactory processFactory = ProcessesFactory.eINSTANCE;
	public static EventsFactory eventsFactory = EventsFactory.eINSTANCE;
	public static OrganisationsFactory organisatoinFactory = OrganisationsFactory.eINSTANCE;

	public static Action addAction(Activity activity, String name) {
		Action action = processFactory.createAction();
		action.setName(name);
		activity.getNodes().add(action);
		return action;
	}

	public static Event addEvent(Activity activity, String name) {
		Event event = eventsFactory.createEvent();
		if (name == null || name.equals("")) {
			name = "Event" + String.valueOf(getEventList(activity).size());
		}
		event.setName(name);
		activity.getNodes().add(event);
		return event;
	}

	/**
	 * remove activity node (event, action, initial/final node)
	 * 
	 * @param activity
	 * @param name
	 * @return
	 */
	public static ActivityNode removeActivityNode(Activity activity, String name) {
		ActivityNode actNode = (ActivityNode) getActivityNode(activity, name);
		if (actNode != null) {
			activity.getNodes().remove(actNode);
		}
		return actNode;
	}

	public static ActivityNode removeActivityNode(Activity activity,
			ActivityNode actNode) {
		if (activity.getNodes().contains(actNode)) {
			activity.getNodes().remove(actNode);
		}
		return actNode;
	}

	public static Role addRole(Model workflowModel, String name) {
		Role role = organisatoinFactory.createRole();
		if (name == null || name.equals("")) {
			name = "Role" + String.valueOf(getRoleList(workflowModel).size());
		}
		role.setName(name);
		workflowModel.getElements().add(role);
		return role;
	}

	public static Role removeRole(Model workflowModel, String name) {
		Role role = getRole(workflowModel, name);
		if (role != null) {
			workflowModel.getElements().remove(role);
		}
		return role;
	}

	public static InitialNode addInitialNode(Activity activity, String name) {
		// InitialNode initNode = (InitialNode) getActivityNode(activity,
		// name);
		// if (initNode == null) {
		InitialNode initNode = processFactory.createInitialNode();
		initNode.setName(name);
		activity.getNodes().add(initNode);
		// }
		return initNode;
	}

	public static FinalNode addFinalNode(Activity activity, String name) {
		// FinalNode finalNode = (FinalNode) getActivityNode(activity,
		// FINAL_NODE_NAME);
		// if (finalNode == null) {
		FinalNode finalNode = processFactory.createFinalNode();
		finalNode.setName(name);
		activity.getNodes().add(finalNode);
		// }
		return finalNode;
	}

	public static ForkNode addForkNode(Activity activity) {
		ForkNode forkNode = processFactory.createForkNode();
		activity.getNodes().add(forkNode);
		return forkNode;
	}

	public static JoinNode addJoinNode(Activity activity) {
		JoinNode joinNode = processFactory.createJoinNode();
		activity.getNodes().add(joinNode);
		return joinNode;
	}

	public static ActivityEdge addEdge(Activity activity, ActivityNode source,
			ActivityNode target) {
		ActivityEdge actEdge = processFactory.createActivityEdge();
		actEdge.setSource(source);
		actEdge.setTarget(target);
		activity.getEdges().add(actEdge);
		return actEdge;
	}

	public static ActivityEdge getEdge(Activity activity, ActivityNode source,
			ActivityNode target) {
		ActivityEdge result = null;
		for (ActivityEdge actiEdge : activity.getEdges()) {
			if (actiEdge.getSource().equals(source)
					&& actiEdge.getTarget().equals(target)) {
				return actiEdge;
			}
		}
		return result;
	}

	public static ActivityEdge removeEdge(Activity activity,
			ActivityNode source, ActivityNode target) {
		ActivityEdge edgeToRemove = null;
		for (ActivityEdge actiEdge : activity.getEdges()) {
			if (actiEdge.getSource().equals(source)
					&& actiEdge.getTarget().equals(target)) {
				edgeToRemove = actiEdge;
			}
		}
		activity.getEdges().remove(edgeToRemove);
		source.getOut().remove(edgeToRemove);
		target.getIn().remove(edgeToRemove);
		return edgeToRemove;
	}

	public static ArrayList<Action> getActionList(Activity activity) {
		EList<ActivityNode> actNodes = activity.getNodes();
		ArrayList<Action> result = new ArrayList<Action>();
		Iterator<ActivityNode> it = actNodes.iterator();
		while (it.hasNext()) {
			ActivityNode actNode = it.next();
			if (actNode instanceof Action) {
				result.add((Action) actNode);
			}
		}
		return result;
	}

	public static ArrayList<Role> getRoleList(Model workflowModel) {
		EList<PackageableElement> pEleList = workflowModel.getElements();
		ArrayList<Role> result = new ArrayList<Role>();
		Iterator<PackageableElement> it = pEleList.iterator();
		while (it.hasNext()) {
			PackageableElement pEle = it.next();
			if (pEle instanceof Role) {
				result.add((Role) pEle);
			}
		}
		return result;
	}

	public static ArrayList<Event> getEventList(Activity activity) {
		EList<ActivityNode> actNodes = activity.getNodes();
		ArrayList<Event> result = new ArrayList<Event>();
		Iterator<ActivityNode> it = actNodes.iterator();
		while (it.hasNext()) {
			ActivityNode actNode = it.next();
			if (actNode instanceof Event) {
				result.add((Event) actNode);
			}
		}
		return result;
	}

	/**
	 * return role if workflow model contains the role with given name.
	 * 
	 * @param activity
	 * @param name
	 * @return
	 */
	public static Role getRole(Model workflowModel, String name) {
		for (PackageableElement role : workflowModel.getElements()) {
			if (role.getName().equals(name)) {
				return (Role) role;
			}
		}
		return null;
	}

	/**
	 * return node if activity contains the node with given name.
	 * 
	 * @param activity
	 * @param name
	 * @return
	 */
	public static ActivityNode getActivityNode(Activity activity, String name) {
		for (ActivityNode actNode : activity.getNodes()) {
			String tempName = "";
			if (actNode instanceof Action) {
				tempName = getActionName((Action) actNode);
			} else {
				tempName = actNode.getName();
			}
			if (tempName.equals(name))
				return actNode;
		}
		return null;
	}

	/**
	 * action name is sum of role name and action state value, so this method
	 * helps us to get the real name of the action.
	 * 
	 * @param action
	 * @return action name
	 */
	public static String getActionName(Action action) {
		String tempName = action.getName();
		int length = tempName.length();
		int nameLength = length;
		if (tempName.contains(StateEnum.INACTIVE.toString())) {
			nameLength = length - StateEnum.INACTIVE.toString().length() - 4;
		} else if (tempName.contains(StateEnum.ENABLED.toString())) {
			nameLength = length - StateEnum.ENABLED.toString().length() - 4;
		} else if (tempName.contains(StateEnum.RUNNING.toString())) {
			nameLength = length - StateEnum.RUNNING.toString().length() - 4;
		} else if (tempName.contains(StateEnum.COMPLETED.toString())) {
			nameLength = length - StateEnum.COMPLETED.toString().length() - 4;
		}
		return tempName.substring(0, nameLength);
	}
	
	public static void setActionName(Action action){
		State state = (State) WorkflowConfUtil.getAspectInstance(action, WorkflowConfUtil.STATE_ASPECT);
		String stateName=state.getState().toString();
		String actionName = getActionName(action);
		actionName+=" ("+stateName+") ";
		action.setName(actionName);
	}

	public static boolean comparatorForRole(Role role1, Role role2) {
		return role1.getName().equals(role2.getName());
	}

	public static boolean comparatorForActNode(ActivityNode actNode1,
			ActivityNode actNode2) {
		return actNode1.getName().equals(actNode2.getName());
	}

	/**
	 * check if the activity node name is contained
	 * 
	 * @param activity
	 * @param name
	 * @return
	 */
	public static boolean containsActNodeName(Activity activity, String name) {
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode.getName().equals(name)) {
				return true;
			}
		}
		return false;
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

	public static ArrayList<Action> getNextSpecializationActions(Action action) {
		ArrayList<Action> nextActions= new ArrayList<Action>();
		for(ActivityEdge actEdge:action.getOut().get(0).getTarget().getOut()){
			ActivityNode actNode=actEdge.getTarget();
			if(actNode instanceof Action&&(WorkflowModelUtil.getActionName((Action)actNode).equals(WorkflowModelUtil.SPECIALIZATION_ACTION))){
				nextActions.add((Action)actNode);
			}
		}
		return nextActions;
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
			stateAspect.setState(StateEnum.ENABLED);
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
	 * all all actions in the stage of the given action.
	 * 
	 * @param activity
	 * @param action
	 */
	public static ArrayList<Action> getStagedActions(Activity activity,
			Action action) {
		ArrayList<Action> stagedActions = new ArrayList<Action>();
		org.js.model.rbac.Role role = WorkflowUtil.getRBACRole(action);
		if (role != null) {
			for (org.js.model.rbac.Role parent : role.getParentRoles()) {
				for (org.js.model.rbac.Role child : parent.getChildRoles()) {
					if (child != null ) {
						stagedActions.addAll(getActions(activity, child));
					}
				}
			}
		}
		return stagedActions;
	}

	/**
	 * all actions performed by the given role. these actions should be in the
	 * same stage.
	 * 
	 * @param activity
	 * @param role
	 * @return
	 */
	public static ArrayList<Action> getActions(Activity activity,
			org.js.model.rbac.Role role) {
		ArrayList<Action> actions = new ArrayList<Action>();
		for (Action action : getActionList(activity)) {
			org.js.model.rbac.Role tempRole = WorkflowUtil.getRBACRole(action);
			if (tempRole != null && tempRole.getId().equals(role.getId())) {
				actions.add(action);
			}
		}
		return actions;
	}
	public static Action getIdleAction(Activity activity) {
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof Action
					&& WorkflowModelUtil.getActionName((Action) actNode)
							.equals(WorkflowModelUtil.IDLE_ACTION)) {
				return (Action) actNode;
			}
		}
		return null;
	}

	public static FinalNode getFinalNode(Activity activity) {
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof FinalNode) {
				return (FinalNode) actNode;
			}
		}
		return null;
	}
}
