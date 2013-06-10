package org.js.model.workflow.actions;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jwt.we.conf.model.AspectInstance;
import org.eclipse.swt.widgets.Display;
import org.js.graph.transformation.GraphTransformation;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Role;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.GraphTransConnector;
import org.js.model.workflow.StakeholderTypes;
import org.js.model.workflow.graphtransformation.GraphTransformationUtil;
import org.js.model.workflow.ui.StakeholderInputUIShell;
import org.js.model.workflow.util.StakeholderInput;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowUtil;

public class AddStakeholderAction extends MyAction {

	public AddStakeholderAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {

		initialRes();
		stakeholderInput();
		save();
		refresh();
	}

	public void stakeholderInput() {
		AspectInstance acmAspect = WorkflowConfUtil.getAspectInstance(
				workflowModel, WorkflowConfUtil.ACM_ASPECT);
		AspectInstance shTypesAspect = WorkflowConfUtil.getAspectInstance(
				workflowModel, WorkflowConfUtil.STAKHOLDERTYPES_ASPECT);
		AspectInstance gtAspect = WorkflowConfUtil.getAspectInstance(
				workflowModel, WorkflowConfUtil.GT_ASPECT);

		if (acmAspect == null || shTypesAspect == null || gtAspect == null) {
			String info = "Please import rbac as well as graph transformation model files and set the stakeholdertypes.";
			MessageDialog.openInformation(getActiveShell(), "Warning", info);
		} else {
			AccessControlModel acm = ((ACMConnector) acmAspect).getAcmref();
			EList<Role> stakeholderTypes = ((StakeholderTypes) shTypesAspect)
					.getStakeholderTypes();
			GraphTransformation gt = ((GraphTransConnector) gtAspect)
					.getGraphTransref();

			if (stakeholderTypes.size() == 0) {
				String info = "Please set the stakeholder types.";

				MessageDialog
						.openInformation(getActiveShell(), "Warning", info);
			} else if (acm == null) {
				String info = "Please refer to acess control model.";

				MessageDialog
						.openInformation(getActiveShell(), "Warning", info);
			} else if (gt == null) {
				String info = "Please refer to graph transformation model.";

				MessageDialog
						.openInformation(getActiveShell(), "Warning", info);
			} else {
				try {
					Display display = Display.getDefault();
					StakeholderInputUIShell shell = new StakeholderInputUIShell(display,
							acm, stakeholderTypes);
					shell.open();
					shell.layout();
					while (!shell.isDisposed()) {
						if (!display.readAndDispatch()) {
							display.sleep();
						}
					}
					if(shell.getOk()){
						StakeholderInput stakeholderInput = shell.getStakeholderInput();
						// search valid rules and apply the change primitives
						GraphTransformationUtil.graphTransformation(stakeholderInput, gt,
								workflowModel, activity, diagram);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		}
	}
}
