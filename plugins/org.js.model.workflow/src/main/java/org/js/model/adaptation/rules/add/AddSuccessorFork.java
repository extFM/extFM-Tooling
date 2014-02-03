package org.js.model.adaptation.rules.add;

import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.js.model.adaptation.IRewriteRule;
import org.js.model.adaptation.ui.UserInputAddRole;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.AccessControlModelUtil;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.js.model.workflow.util.WorkflowViewUtil;


public class AddSuccessorFork extends AbstractWorkflowAddRewriteRule {

   private AccessControlModel accessControlModel;
   public AddSuccessorFork(UserInputAddRole input, Model workflow, AccessControlModel accessControlModel) {
      super(input, workflow);
      this.accessControlModel = accessControlModel;
   }

   @Override
   protected int executeInternal() {
      if (isGroupOwner()){
         addSuccessorFork();
      }
      return IRewriteRule.OK;
   }

   private void addSuccessorFork() {
      Action specializationAction = input.getSpecializationAction();
      
      ForkNode fork = WorkflowModelUtil.addForkNode(activity);
      WorkflowViewUtil.setNodeLayout(diagram, fork, coordinate, coordinate);
      
      ChangePrimitive.addEdge(activity, specializationAction, fork);
   }

   private boolean isGroupOwner() {
      Role role = input.getNewRole();
      Group roleGroup = AccessControlModelUtil.getRoleGroupForOwner(role, accessControlModel);
      return roleGroup != null;
   }

}
