package org.js.model.workflow.actions;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.eclipse.gef.EditDomain;
import org.eclipse.jwt.meta.model.core.ModelElement;
import org.eclipse.jwt.meta.model.events.Event;
import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.we.parts.core.doubleClick.*;
import org.eclipse.swt.widgets.Display;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.ui.StakeholderConfigUIShell;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;

public class ConfigHandler implements DoubleClickHandler {

	public ConfigHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(ModelElement modelElement) {
		if (modelElement instanceof Action) { // specialization action or idle
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
				handleSpecializationAction((Action)modelElement);
			} else {
				handleIdleAction();
			}
		} else if (modelElement instanceof Event) {
			handleFlowFinal();
		}
	}

	public void handleSpecializationAction(Action modelElement) {
		RoleConnector roleConnector = (RoleConnector) WorkflowConfUtil
				.getAspectInstance(((Action) modelElement).getPerformedBy(),
						WorkflowConfUtil.ROLE_ASPECT);
		org.js.model.rbac.Role role = roleConnector.getRoleref();
		try {
			Display display = Display.getDefault();
			StakeholderConfigUIShell shell = new StakeholderConfigUIShell(
					display, role);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handleIdleAction() {

	}

	public void handleFlowFinal() {

	}
}
