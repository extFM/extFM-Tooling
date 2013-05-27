package org.js.model.workflow.test;

import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.js.model.rbac.AccessControlModel;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.actions.MyAction;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.js.model.workflow.util.WorkflowUtil;

public class AddApplicationProvider extends MyAction {

	org.js.model.rbac.Role platformProvider = null;
	org.js.model.rbac.Role applicationProvider = null;

	public AddApplicationProvider() {
	}

	@Override
	public void run() {
		initialRes();
		addApplicationProvider();
		save();
		refresh();
	}
	public void addApplicationProvider() {
		if (!hasApplicationProvider(activity)) {
			ForkNode forkNode = getForkNode(activity);
			Action idle = getIdleAction(activity);
			Action platProviderAction = getPlatformProviderAction(activity);
			applicationProvider = WorkflowUtil.getRBACRole(workflowModel, "ApplicationProvider");
			
			if (forkNode != null && platformProvider != null&&platProviderAction!=null) {
				// add an action
				Action action = ChangePrimitive.addAction(workflowModel,
						activity, diagram,
						WorkflowModelUtil.SPECIALIZATION_ACTION, 800, 300);
				
				// add the action with the reference of the role
				Role role = ChangePrimitive.addRole(workflowModel, activity,
						diagram, applicationProvider, "ApplicationProvider1", 800,
						400);
				ChangePrimitive.addRoleActionRef(workflowModel, activity,
						diagram, role, action);
				
				// add a fork node
				ForkNode forkNode1 = ChangePrimitive.addForkNode(activity, diagram, 1000, 300);
				
				// remove the edge 
				ChangePrimitive.removeEdge(activity, platProviderAction, idle);
				// add the edge
				ChangePrimitive.addEdge(activity, platProviderAction, action);
				ChangePrimitive.addEdge(activity, action, forkNode1);
				ChangePrimitive.addEdge(activity,  forkNode1, idle);
			}
		}
	}
	public boolean hasApplicationProvider(Activity activity) {
		applicationProvider = WorkflowUtil.getRBACRole(workflowModel, "ApplicationProvider");
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof Action){
				org.js.model.rbac.Role role = WorkflowUtil.getRBACRole((Action)actNode);
				if(role!=null){
					for(org.js.model.rbac.Role parent :role.getParentRoles()){
						if(parent.getId().equals("ApplicationProvider")){
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public Action getPlatformProviderAction(Activity activity) {
		platformProvider = WorkflowUtil.getRBACRole(workflowModel, "PlatformProvider");
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof Action
					&& WorkflowModelUtil.getActionName((Action) actNode)
							.equals(WorkflowModelUtil.SPECIALIZATION_ACTION)) {
				org.js.model.rbac.Role role = WorkflowUtil
						.getRBACRole((Action) actNode);
				if (role.getParentRoles().contains(platformProvider))
					return (Action) actNode;
			}
		}
		return null;
	}

	public Action getIdleAction(Activity activity) {
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof Action
					&& WorkflowModelUtil.getActionName((Action) actNode)
							.equals(WorkflowModelUtil.IDLE_ACTION)) {
				return (Action) actNode;
			}
		}
		return null;
	}

	public ForkNode getForkNode(Activity activity) {
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof ForkNode) {
				return (ForkNode) actNode;
			}
		}
		return null;
	}
}
