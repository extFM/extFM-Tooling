package org.js.model.workflow.test.action;

import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.FinalNode;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.js.model.rbac.AccessControlModel;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.actions.MyAction;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.js.model.workflow.util.WorkflowUtil;
import org.js.model.workflow.util.WorkflowViewUtil;

public class AddApplicationProvider extends MyAction {

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
			org.js.model.rbac.Role platformProviderType = 	 WorkflowUtil.getRBACRole(workflowModel, "PlatformProvider");
			org.js.model.rbac.Role applicationProviderType =  WorkflowUtil.getRBACRole(workflowModel, "ApplicationProvider");
			ForkNode forkNode = getForkNode(activity);
			Action idleAction = WorkflowModelUtil.getIdleAction(activity);
			FinalNode finalNode = WorkflowModelUtil.getFinalNode(activity);
			Action platProviderAction = getPlatformProviderAction(activity,platformProviderType);
		
			if (forkNode != null && platformProviderType != null&&platformProviderType!=null&&platProviderAction!=null) {
				// add an action
				Action action = ChangePrimitive.addAction(workflowModel,
						activity, diagram,
						WorkflowModelUtil.SPECIALIZATION_ACTION, 400, 200);
				
				// add the action with the reference of the role
				Role role = ChangePrimitive.addRole(workflowModel, activity,
						diagram, applicationProviderType, "ApplicationProviderTest", 400,
						250);
				ChangePrimitive.addRoleActionRef(workflowModel, activity,
						diagram, role, action);
				
				// add a fork node
				ForkNode forkNode1 = ChangePrimitive.addForkNode(activity, diagram, 600, 200);
				
				// remove the edge 
				ChangePrimitive.removeEdge(activity, platProviderAction, idleAction);
				// add the edge
				ChangePrimitive.addEdge(activity, platProviderAction, action);
				ChangePrimitive.addEdge(activity, action, forkNode1);
				ChangePrimitive.addEdge(activity,  forkNode1, idleAction);
				
				WorkflowViewUtil.treeLayout(workflowModel, activity, diagram,
						idleAction, finalNode, action);
			}
		}
	}
	public boolean hasApplicationProvider(Activity activity) {
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

	public Action getPlatformProviderAction(Activity activity,org.js.model.rbac.Role platformProvider) {
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof Action
					&& WorkflowModelUtil.getActionName((Action) actNode)
							.equals(WorkflowModelUtil.SPECIALIZATION_ACTION)) {
				org.js.model.rbac.Role role = WorkflowUtil
						.getRBACRole((Action) actNode);
				for(org.js.model.rbac.Role parent:role.getParentRoles()){
					if(parent.getId().equals("PlatformProvider")){
						return (Action)actNode;
					}
				}
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
