package org.js.model.workflow.test.action;

import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.*;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.RBACService;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.actions.MyAction;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.js.model.workflow.util.WorkflowUtil;

public class AddPlatformProvider extends MyAction {
	
	@Override
	public void run() {
		initialRes();
		addPlatformProvider();
		save();
		refresh();
	}

	public void addPlatformProvider() {
		if (!hasPlatformProvider(activity)) {
			org.js.model.rbac.Role 	platformProviderType=WorkflowUtil.getRBACRole(workflowModel, "PlatformProvider");
			
			ForkNode forkNode = getForkNode(activity);
			Action idle = getIdleAction(activity);
			
			if (forkNode != null && platformProviderType != null) {
				// add an action
				Action action = ChangePrimitive.addAction(workflowModel,
						activity, diagram,
						WorkflowModelUtil.SPECIALIZATION_ACTION, 300, 300);

				// add the action with the reference of the role
				Role role = ChangePrimitive.addRole(workflowModel, activity,
						diagram, platformProviderType, "PlatformProviderTest", 300,
						400);
				ChangePrimitive.addRoleActionRef(workflowModel, activity,
						diagram, role, action);

				// add the edge
				ChangePrimitive.addEdge(activity, forkNode, action);
				ChangePrimitive.addEdge(activity, action, idle);
			}
		}
	}

	/**
	 * check if the workflow contains a platform provider.
	 * @param activity
	 * @return
	 */
	public boolean hasPlatformProvider(Activity activity) {
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof Action
					&& ((Action) actNode).getPerformedBy() != null) {
				org.js.model.rbac.Role role = WorkflowUtil.getRBACRole((Action)actNode);
				if (role != null){
			for(org.js.model.rbac.Role parent :role.getParentRoles()){
				if(parent.getId().equals("PlatformProvider")){
					return true;
				}}
			}}
		}
		
		return false;
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
