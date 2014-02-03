package org.js.model.adaptation.rules.add;

import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.js.model.adaptation.IRewriteRule;
import org.js.model.adaptation.ui.UserInputAddRole;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.js.model.workflow.util.WorkflowViewUtil;

public class AddSpecializationAction extends AbstractWorkflowAddRewriteRule {

   public AddSpecializationAction(UserInputAddRole input, Model workflow) {
      super(input, workflow);
   }

   public int executeInternal() {
      int returnCode = IRewriteRule.OK;
      if (diagram == null || activity == null) {
         returnCode = IRewriteRule.Error;
      } else {
         Role role = addWorkflowRole();
         Action action = addSpecializationAction();
         assignRoleToAction(role, action);
      }
      return returnCode;
   }



   private Role addWorkflowRole() {
      org.js.model.rbac.Role rbacRole = input.getNewRole();
      // create workflow role
      Role jwtRole = WorkflowModelUtil.addRole(workflow, rbacRole.getId());
      setRoleLayout(jwtRole);
      input.setNewWorkflowRole(jwtRole);

      // add role aspect
      RoleConnector roleConnector = (RoleConnector) WorkflowConfUtil.addAspectInstance(jwtRole, WorkflowConfUtil.ROLE_ASPECT);
      WorkflowConfUtil.setRoleRef(roleConnector, rbacRole);
      return jwtRole;
   }

   private void setRoleLayout(Role role) {
      WorkflowViewUtil.setRoleLayout(diagram, activity, role, coordinate, coordinate);
   }

   private Action addSpecializationAction() {
      String actionName = WorkflowModelUtil.SPECIALIZATION_ACTION;

      // add action
      Action action = WorkflowModelUtil.addAction(activity, actionName);
      WorkflowViewUtil.setNodeLayout(diagram, action, coordinate, coordinate);
      input.setSpecializationAction(action);

      addAspects(action);
      setName(action);
      return action;
   }

   private void assignRoleToAction(Role newRole, Action newAction) {
      ChangePrimitive.addRoleActionRef(workflow, activity, diagram, newRole, newAction);
      ChangePrimitive.updateActionState(newAction);
   }

   private void addAspects(ActivityNode actNode) {
      // add aspects for the action
      if (WorkflowConfUtil.containsProfile(workflow, WorkflowConfUtil.WORKFLOW_PROFILE_NAME)) {
         // add log aspect
         WorkflowConfUtil.addAspectInstance(actNode, WorkflowConfUtil.LOG_ASPECT);
         // add the aspect of efm container
         WorkflowConfUtil.addAspectInstance(actNode, WorkflowConfUtil.EFM_ASPECT);
         // add state aspect
         State state = (State) WorkflowConfUtil.addAspectInstance(actNode, WorkflowConfUtil.STATE_ASPECT);
         WorkflowConfUtil.setState(state, StateEnum.INACTIVE);

      }
   }

   private void setName(ActivityNode actNode) {
      State state = (State) WorkflowConfUtil.getAspectInstance(actNode, WorkflowConfUtil.STATE_ASPECT);
      // set the name with the state
      actNode.setName(actNode.getName() + " (" + state.getState().getName() + ") ");
   }

}
