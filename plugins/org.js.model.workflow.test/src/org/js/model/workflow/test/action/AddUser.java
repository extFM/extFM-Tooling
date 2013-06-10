package org.js.model.workflow.test.action;

import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.FinalNode;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.eclipse.swt.widgets.Display;
import org.js.model.rbac.AccessControlModel;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.actions.MyAction;
import org.js.model.workflow.test.ui.GroupSelection;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.js.model.workflow.util.WorkflowUtil;
import org.js.model.workflow.util.WorkflowViewUtil;

public class AddUser extends MyAction {

	public AddUser() {
	}

	@Override
	public void run() {
		initialRes();
		addUser();
		save();
		refresh();
	}

	public void addUser() {
		org.js.model.rbac.Role userType = WorkflowUtil.getRBACRole(
				workflowModel, "User");
		AccessControlModel acm = ((ACMConnector) WorkflowConfUtil
				.getAspectInstance(workflowModel, WorkflowConfUtil.ACM_ASPECT))
				.getAcmref();
		Action idleAction = WorkflowModelUtil.getIdleAction(activity);
		FinalNode finalNode = WorkflowModelUtil.getFinalNode(activity);
		String groupLeaderName = null;
		try {
			Display display = Display.getDefault();
			GroupSelection shell = new GroupSelection(display, acm);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
			groupLeaderName = shell.getGroupLeaderName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (groupLeaderName != null && userType != null) {
			// get the group leader action
			Action groupLeaderAction = getTenantAction(activity,
					groupLeaderName);
			// the vertical position of idle action
			int groupLeaderY = WorkflowViewUtil.getNodeLayout(diagram,
					groupLeaderAction).getY();
			// add the action with the reference of the role
			int size = groupLeaderAction.getOut().get(0).getTarget().getOut()
					.size() - 1;
			int index = userType.getChildRoles().size();
			// add an action
			String roleName = "UserTest" + index;
			Action action = ChangePrimitive.addAction(workflowModel, activity,
					diagram, WorkflowModelUtil.SPECIALIZATION_ACTION,
					900, groupLeaderY + 100 * size);
			Role role = ChangePrimitive.addRole(workflowModel, activity,
					diagram, userType, roleName, 900, groupLeaderY + 100 * size
							+ 50);
			ChangePrimitive.addRoleActionRef(workflowModel, activity, diagram,
					role, action);
			// add a flow final node
			ActivityNode flowFinal = ChangePrimitive.addFlowFinalNode(activity,
					diagram, "", 1100, groupLeaderY + 100 * size);

			// add the edge
			ForkNode forNode1 = (ForkNode) ((ActivityEdge) groupLeaderAction
					.getOut().get(0)).getTarget();
			ChangePrimitive.addEdge(activity, forNode1, action);
			ChangePrimitive.addEdge(activity, action, flowFinal);

			ChangePrimitive.updateActionState(action);
			WorkflowViewUtil.treeLayout(workflowModel, activity, diagram,
					idleAction, finalNode, action);
		}

	}

	public Action getTenantAction(Activity activity, String groupLeaderName) {
		for (ActivityNode actNode : activity.getNodes()) {
			if (actNode instanceof Action
					&& WorkflowModelUtil.getActionName((Action) actNode)
							.equals(WorkflowModelUtil.SPECIALIZATION_ACTION)) {
				org.js.model.rbac.Role role = WorkflowUtil
						.getRBACRole((Action) actNode);
				if (role != null) {
					for (org.js.model.rbac.Role parent : role.getParentRoles()) {
						if (parent.getId().equals("Tenant")
								&& role.getId().equals(groupLeaderName)) {
							return (Action) actNode;
						}
					}
				}
			}
		}
		return null;
	}
}
