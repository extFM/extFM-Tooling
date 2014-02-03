package org.js.model.adaptation.rules.remove;

import java.util.ArrayList;

import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.js.model.adaptation.IRewriteRule;
import org.js.model.rbac.Role;
import org.js.model.workflow.StateEnum;
import org.js.model.workflow.util.WorkflowModelUtil;

public class DisableSpecializationAction extends AbstractWorkflowRemoveRewriteRule {

   public DisableSpecializationAction(Role role, Model workflow) {
      super(role, workflow);
   }

   @Override
   protected int executeInternal() {
      int returnCode = disableAction();
      return returnCode;
   }

   private int disableAction() {
      int returnCode = IRewriteRule.OK;
      ArrayList<Action> actions = WorkflowModelUtil.getActions(activity, role);
      if (actions.isEmpty()) {
         returnCode = IRewriteRule.Error;
      }
      for (Action action : actions) {
         WorkflowModelUtil.setActionState(action, StateEnum.INACTIVE);
      }
      return returnCode;
   }

}
