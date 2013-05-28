package org.js.model.workflow.test.action;

import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.FinalNode;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.js.model.workflow.actions.MyAction;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.js.model.workflow.util.WorkflowUtil;
import org.js.model.workflow.util.WorkflowViewUtil;

public class AddTenant extends MyAction {


	
	public AddTenant() {
	}
	
	@Override
	public void run() {
		initialRes();
		addTenant();
		save();
		refresh();
	}
	public void addTenant(){
		org.js.model.rbac.Role applicationProviderType = WorkflowUtil.getRBACRole(workflowModel, "ApplicationProvider");
		org.js.model.rbac.Role tenantType = WorkflowUtil.getRBACRole(workflowModel, "Tenant");
		Action idleAction = WorkflowModelUtil.getIdleAction(activity);
		FinalNode finalNode = WorkflowModelUtil.getFinalNode(activity);
		Action appProviderAction = getAppProviderAction(activity);
		
		if(applicationProviderType!=null&&tenantType!=null&&idleAction!=null&&appProviderAction!=null){
			int size =tenantType.getChildRoles().size();
			// add an action
			Action action = ChangePrimitive.addAction(workflowModel,
					activity, diagram,
					WorkflowModelUtil.SPECIALIZATION_ACTION, 650, 200+100*size);
							// add the action with the reference of the role
				Role role = ChangePrimitive.addRole(workflowModel, activity,
						diagram, tenantType, "TenantTest"+size, 650,
						250+100*size);
				ChangePrimitive.addRoleActionRef(workflowModel, activity,
						diagram, role, action);
				// add a fork node
			ForkNode forkNode = ChangePrimitive.addForkNode(activity, diagram, 850, 200+100*size);
			// add the edge
			ForkNode forNode1 = (ForkNode) ((ActivityEdge)appProviderAction.getOut().get(0)).getTarget();
			
			ChangePrimitive.addEdge(activity, forNode1, action);
			ChangePrimitive.addEdge(activity, action, forkNode);
			ChangePrimitive.addEdge(activity, forkNode, idleAction);
			
			WorkflowViewUtil.treeLayout(workflowModel, activity, diagram,
					idleAction, finalNode, action);
		}
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
	public Action getAppProviderAction(Activity activity) {
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof Action
					&& WorkflowModelUtil.getActionName((Action) actNode)
							.equals(WorkflowModelUtil.SPECIALIZATION_ACTION)) {
				org.js.model.rbac.Role role = WorkflowUtil
						.getRBACRole((Action) actNode);
				if(role!=null){
					for(org.js.model.rbac.Role parent:role.getParentRoles()){
						if(parent.getId().equals("ApplicationProvider")){
							return (Action) actNode;
						}
					}
				}
			}
		}
		return null;
	}
}
