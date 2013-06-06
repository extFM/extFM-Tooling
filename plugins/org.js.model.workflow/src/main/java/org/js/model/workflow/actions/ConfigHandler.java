package org.js.model.workflow.actions;

import org.eclipse.gef.EditDomain;
import org.eclipse.jwt.meta.model.core.ModelElement;
import org.eclipse.jwt.meta.model.events.Event;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.we.parts.core.doubleClick.*;
import org.eclipse.swt.widgets.Display;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.State;
import org.js.model.workflow.ui.StakeholderConfigUIShell;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;

public class ConfigHandler extends MyAction implements DoubleClickHandler {

	public ConfigHandler() {
		initialRes();
	}

	@Override
	public boolean appliesTo(ModelElement modelElement) {
		
		if (modelElement instanceof Action) {// specialization action or idle
												// action
			return true;
		} else if (modelElement instanceof Event) { // flow final node
			return true;
		}
		return false;
	}

	@Override
	public void processDoubleClick(ModelElement modelElement,
			EditDomain editDomain) {
		if (modelElement instanceof Action) {
			if (WorkflowModelUtil.getActionName((Action) modelElement).equals(
					WorkflowModelUtil.SPECIALIZATION_ACTION)) {
				handleSpecializationAction((Action) modelElement);
			} else {
				handleIdleAction((Action) modelElement);
			}
		} else if (modelElement instanceof Event) {
			handleFlowFinal((Event) modelElement);
		}
	}

	public void handleSpecializationAction(Action action) {
		State state = (State) WorkflowConfUtil.getAspectInstance(action,
				WorkflowConfUtil.STATE_ASPECT);
		org.js.model.rbac.Role role = ((RoleConnector) WorkflowConfUtil
				.getAspectInstance(((Action) action).getPerformedBy(),
						WorkflowConfUtil.ROLE_ASPECT)).getRoleref();
		// according to the state value the ui is different
		if (state.getState().getValue() == 1
				|| state.getState().getValue() == 3) {
			try {
				Display display = Display.getDefault();
				StakeholderConfigUIShell shell = new StakeholderConfigUIShell(
						workflowModel, display, role, (Action) action, state);
				shell.open();
				shell.layout();
				while (!shell.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
				WorkflowModelUtil.setActionState(action, shell.getState()
						.getState());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (state.getState().getValue() == 3) {
				for (Action nextAction : WorkflowModelUtil
						.getNextSpecializationActions(action)) {
					WorkflowModelUtil.setActionState(nextAction);
				}
			}
		}
	}

	public void handleIdleAction(Action modelElement) {

	}

	public void handleFlowFinal(Event flowFinal) {
		Action preAction = WorkflowModelUtil.getPrecedeAction(flowFinal);
		State state = (State) WorkflowConfUtil.getAspectInstance(preAction,
				WorkflowConfUtil.STATE_ASPECT);
		if (state.getState().getValue() == 3) {
			// open the config file
		}
	}
}
