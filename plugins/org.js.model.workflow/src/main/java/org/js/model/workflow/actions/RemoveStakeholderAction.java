package org.js.model.workflow.actions;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.js.model.adaptation.AdaptationEngine;
import org.js.model.adaptation.ui.RemoveRoleDialog;
import org.js.model.adaptation.ui.UserInputRemoveRole;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowUtil;

public class RemoveStakeholderAction extends MyAction {

   @Override
   public void run() {

      initialRes();
      removeStakeholder();
      save();
      refresh();
   }

   private void removeStakeholder() {
      if (!isWorkflowInitialized()) {
         String info = "Please import rbac as well as stage model files.";
         MessageDialog.openInformation(getActiveShell(), "Warning", info);
      } else {
         openRemoveStakeholderDialog();
      }
   }

   private void openRemoveStakeholderDialog() {
      UserInputRemoveRole roleInput = new UserInputRemoveRole();
      AccessControlModel accessControlModel = WorkflowUtil.getAccessControlModel(workflowModel);

      RemoveRoleDialog dialog = new RemoveRoleDialog();
      dialog.setInput(roleInput);
      dialog.setAccessControlModel(accessControlModel);
      int returnCode = dialog.open();
      if (returnCode == Window.OK) {
         startRemoveTransformSequence(roleInput);
      }
   }

   private void startRemoveTransformSequence(UserInputRemoveRole roleInput) {
      AdaptationEngine engine = new AdaptationEngine(getWorkflowModel());
      Role role = roleInput.getRole();
      engine.removeStakeholder(role);
   }

   private boolean isWorkflowInitialized() {
      return (WorkflowConfUtil.hasAspectInstance(workflowModel, WorkflowConfUtil.ACM_ASPECT) && WorkflowConfUtil
         .hasAspectInstance(workflowModel, WorkflowConfUtil.STAGEMODEL_ASPECT));
   }

}
