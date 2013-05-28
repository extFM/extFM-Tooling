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
import org.js.model.workflow.util.WorkflowViewUtil;

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
			
			ForkNode forkNode = getFirstForkNode(activity);
			Action idleAction = WorkflowModelUtil.getIdleAction(activity);
			FinalNode finalNode = WorkflowModelUtil.getFinalNode(activity);
			
			if (forkNode != null && platformProviderType != null) {
				// add an action
				Action action = ChangePrimitive.addAction(workflowModel,
						activity, diagram,
						WorkflowModelUtil.SPECIALIZATION_ACTION, 200, 200);

				// add the action with the reference of the role
				Role role = ChangePrimitive.addRole(workflowModel, activity,
						diagram, platformProviderType, "PlatformProviderTest", 200,
						250);
				ChangePrimitive.addRoleActionRef(workflowModel, activity,
						diagram, role, action);

				// add the edge
				ChangePrimitive.addEdge(activity, forkNode, action);
				ChangePrimitive.addEdge(activity, action, idleAction);
				
//				WorkflowViewUtil.treeLayout(workflowModel, activity, diagram, idleAction, finalNode, action);
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


	public ForkNode getFirstForkNode(Activity activity) {
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof ForkNode) {
				return (ForkNode) actNode;
			}
		}
		return null;
	}
}
