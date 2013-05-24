package org.js.model.workflow.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.js.model.workflow.StateEnum;

/**
 * This class provides methods relating to jwt meta model.
 * 
 * @author Xi
 * 
 */
public class WorkflowModelUtil {

	public static final String WORKFLOW_EXTENSION = "workflow";
	public static final String WORKFLOW_VIEW_EXTENSION = "workflow_view";
	public static final String WORKFLOW_CONF_EXTENSION = "workflow_conf";
	public static final String SPECIALIZATION_ACTION = "Specialization";
	public static final String IDLE_ACTION = "Idle";
	public static final String INITIAL_NODE = "InitialNode";
	public static final String ACTIVITY_FINAL_NODE = "ActivityFinalNode";
	// public static final String INITIAL_NODE_NAME = "InitialNode";
	// public static final String FINAL_NODE_NAME = "FinalNode";

	public static ProcessesFactory processFactory = ProcessesFactory.eINSTANCE;
	public static EventsFactory eventsFactory = EventsFactory.eINSTANCE;
	public static OrganisationsFactory organisatoinFactory = OrganisationsFactory.eINSTANCE;

	/**
	 * get the workflow view resource for the given workflow resource.
	 * 
	 * @param workflowResource
	 * @return workflow view resource
	 */
	public static Resource getWorkflowViewReousrce(Resource workflowResource) {
		URI workflowViewUri = workflowResource.getURI().trimFileExtension()
				.appendFileExtension(WORKFLOW_VIEW_EXTENSION);
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(workflowViewUri, true);
	}

	/**
	 * get the workflow configuration resource for the given workflow resource.
	 * 
	 * @param workflowResource
	 * @return workflow configration resource
	 */
	public static Resource getWorkflowConfReousrce(Resource workflowResource) {
		URI workflowConfUri = workflowResource.getURI().trimFileExtension()
				.appendFileExtension(WORKFLOW_CONF_EXTENSION);
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(workflowConfUri, true);
	}

	/**
	 * we use name as the action state value for visualization
	 * 
	 * @param activity
	 * @param name
	 * @return
	 */
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

	public static Resource getResource(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(uri, true);
	}

	public static Resource getResource(URL fileresource) {
		String path = fileresource.getPath();
		URI uri = URI.createFileURI(path);
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(uri, true);
	}

	/**
	 * return role if workflow model contains the role with given name
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
	 * return node if activity contains the node with given name
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
	 * helps us to get the real name of the action
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

}
