package org.js.model.adaptation.rules.add;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.eclipse.jwt.we.model.view.Reference;
import org.eclipse.jwt.we.model.view.ReferenceEdge;
import org.js.graph.transform.stagemodel.Stage;
import org.js.graph.transform.stagemodel.StageModel;
import org.js.model.adaptation.IRewriteRule;
import org.js.model.adaptation.ui.UserInputAddRole;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.StageModelUtil;
import org.js.model.workflow.util.WorkflowUtil;
import org.js.model.workflow.util.WorkflowViewUtil;

public class AddIngoingTransitionsAnyStage extends AbstractWorkflowAddRewriteRule {

   private StageModel stageModel;

   public AddIngoingTransitionsAnyStage(UserInputAddRole input, Model workflow, StageModel stageModel) {
      super(input, workflow);
      this.stageModel = stageModel;
   }

   @Override
   protected int executeInternal() {
      int returnCode = IRewriteRule.OK;
      if (!isFirstStage() && hasRoleOwner()) {
         returnCode = addTransitions();
      }
      return returnCode;
   }

   private boolean isFirstStage() {
      String parentId = input.getAbstractParentRole().getId();
      Stage stage = StageModelUtil.getStageForId(parentId, stageModel);
      return StageModelUtil.isFirstStage(stage);
   }
   
   private int addTransitions() {
      int returnCode = IRewriteRule.OK;
      // find pattern: owner action node -> fork node
      ForkNode fork = getOwnerForkNode();
      if (fork != null) {
         // add transition between this fork node and the new specialization action
         Action specializationAction = input.getSpecializationAction();
         ChangePrimitive.addEdge(activity, fork, specializationAction);

         // update action state of specialization action
         ChangePrimitive.updateActionState(specializationAction);
      } else {
         returnCode = IRewriteRule.Error;
      }
      return returnCode;
   }

   private ForkNode getOwnerForkNode() {
      ForkNode fork = null;
      Action ownerAction = getOwnerSpecializationAction();
      if (ownerAction != null) {
         fork = getOutgoingFork(ownerAction);
      }
      return fork;
   }

   private ForkNode getOutgoingFork(Action ownerAction) {
      ForkNode fork = null;
      EList<ActivityEdge> out = ownerAction.getOut();
      for (ActivityEdge activityEdge : out) {
         ActivityNode target = activityEdge.getTarget();
         if (target instanceof ForkNode) {
            fork = (ForkNode) target;
            break;
         }
      }
      return fork;
   }

   private Action getOwnerSpecializationAction() {
      Action action = null;
      Role owner = input.getGroupOwner();
      org.eclipse.jwt.meta.model.organisations.Role workflowRole = WorkflowUtil.getWorkflowRole(owner, workflow);
      Reference reference = WorkflowViewUtil.getReferenceEdge(getDiagram(), workflowRole);
      EList<ReferenceEdge> referenceEdges = reference.getReferenceEdges();
      for (ReferenceEdge referenceEdge : referenceEdges) {
         Action referencedAction = referenceEdge.getAction();
         if (referencedAction != null) {
            action = referencedAction;
            break;
         }
      }
      return action;
   }

   private boolean hasRoleOwner() {
      return input.getGroupOwner() != null;
   }

}
