package org.js.model.workflow.test;

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
	
	public org.js.model.rbac.Role platformProvider=null;
	
	@Override
	public void run() {
		initialRes();
		addPlatformProvider();
		save();
		refresh();
	}

	public void addPlatformProvider() {
		if (!hasPlatformProvider(activity)) {
			ForkNode forkNode = getForkNode(activity);
			Action idle = getIdleAction(activity);

			// search for the role type of the platform provider
			org.js.model.rbac.Role platformProvider = null;
			ACMConnector acmConnector = (ACMConnector) WorkflowConfUtil
					.getAspectInstance(workflowModel,
							WorkflowConfUtil.ACM_ASPECT);
			AccessControlModel acm = acmConnector.getAcmref();
			for (org.js.model.rbac.Role role : acm.getRoles()) {
				if (role.getId().equals("PlatformProvider")) {
					platformProvider = role;
				}
			}

			if (forkNode != null && platformProvider != null) {
				// add an action
				Action action = ChangePrimitive.addAction(workflowModel,
						activity, diagram,
						WorkflowModelUtil.SPECIALIZATION_ACTION, 600, 300);

				// add the action with the reference of the role
				Role role = ChangePrimitive.addRole(workflowModel, activity,
						diagram, platformProvider, "PlatformProvider1", 600,
						400);
				ChangePrimitive.addRoleActionRef(workflowModel, activity,
						diagram, role, action);

				// add the edge
				ChangePrimitive.addEdge(activity, forkNode, action);
				ChangePrimitive.addEdge(activity, action, idle);
			}
		}
	}

	public boolean hasPlatformProvider(Activity activity) {
		platformProvider=WorkflowUtil.getRBACRole(workflowModel, "PlatformProvider");
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof Action
					&& ((Action) actNode).getPerformedBy() != null) {
				org.js.model.rbac.Role role = WorkflowUtil.getRBACRole((Action)actNode);
				if (role != null&&role.getParentRoles().contains(platformProvider))
						return true;
			}
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
