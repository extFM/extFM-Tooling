package org.js.model.adaptation.rules.remove;

import java.util.ArrayList;

import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.js.model.adaptation.IRewriteRule;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.WorkflowModelUtil;

public class RemoveSpecializationAction extends AbstractWorkflowRemoveRewriteRule {

   public RemoveSpecializationAction(Role role, Model workflow) {
      super(role, workflow);
   }

   @Override
   protected int executeInternal() {
      ArrayList<Action> actions = WorkflowModelUtil.getActions(activity, role);
      for (Action action : actions) {
         ChangePrimitive.removeAction(workflow, activity, diagram, action);
      }
      return IRewriteRule.OK;
   }

}
