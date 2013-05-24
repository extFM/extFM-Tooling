package org.js.model.workflow.actions;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.eclipse.gef.EditDomain;
import org.eclipse.jwt.meta.model.core.ModelElement;
import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.we.parts.core.doubleClick.*;
import org.eclipse.swt.widgets.Display;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.ui.StakeholderConfigUIShell;
import org.js.model.workflow.util.WorkflowConfUtil;

public class ConfigHandler implements DoubleClickHandler {

	public ConfigHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean appliesTo(ModelElement modelElement) {
		// TODO Auto-generated method stub
		if (modelElement instanceof Action) {
			return true;
		}
		return false;
	}

	@Override
	public void processDoubleClick(ModelElement modelElement,
			EditDomain editDomain) {
		// TODO Auto-generated method stub
		System.out.println("test2");
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
		System.out.println(roleConnector.getRoleref().getId());
	}
}
