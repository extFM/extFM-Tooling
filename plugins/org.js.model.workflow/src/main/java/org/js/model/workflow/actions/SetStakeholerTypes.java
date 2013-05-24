package org.js.model.workflow.actions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jwt.we.conf.model.AspectInstance;
import org.eclipse.swt.widgets.Display;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Role;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.StakeholderTypes;
import org.js.model.workflow.ui.StakeholderTypesUIShell;
import org.js.model.workflow.util.WorkflowConfUtil;

public class SetStakeholerTypes extends MyAction {

	public SetStakeholerTypes() {
	}

	@Override
	public void run() {

		initialRes();
		selectTypes();
		save();
		refresh();
	}

	public void selectTypes() {
		AspectInstance acmAspect = WorkflowConfUtil.getAspectInstance(
				workflowModel, WorkflowConfUtil.ACM_ASPECT);
		StakeholderTypes shTypesAspect = (StakeholderTypes) WorkflowConfUtil
				.getAspectInstance(workflowModel,
						WorkflowConfUtil.STAKHOLDERTYPES_ASPECT);
		if (acmAspect == null) {
			String info = "Please import rbac model file.";
			MessageDialog.openInformation(getActiveShell(), "Warning", info);
		} else {
			AccessControlModel acm = ((ACMConnector) acmAspect).getAcmref();
			if (shTypesAspect == null) {
				shTypesAspect = (StakeholderTypes) WorkflowConfUtil
						.addAspectInstance(workflowModel,
								WorkflowConfUtil.STAKHOLDERTYPES_ASPECT);
			}
			EList<Role> stakeholderhTypes = shTypesAspect.getStakeholderTypes();
			try {
				Display display = Display.getDefault();
				StakeholderTypesUIShell shell = new StakeholderTypesUIShell(
						display, acm,stakeholderhTypes);
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
	}
}
