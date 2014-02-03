package org.js.model.adaptation.rules.add;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.eclipse.jwt.meta.model.processes.InitialNode;
import org.js.graph.transform.stagemodel.Stage;
import org.js.graph.transform.stagemodel.StageModel;
import org.js.model.adaptation.IRewriteRule;
import org.js.model.adaptation.ui.UserInputAddRole;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.StageModelUtil;

public class AddIngoingTransitionsFirstStage extends AbstractWorkflowAddRewriteRule {

   private StageModel stageModel;

   public AddIngoingTransitionsFirstStage(UserInputAddRole input, Model workflow, StageModel stageModel) {
      super(input, workflow);
      this.stageModel = stageModel;
   }

   @Override
   protected int executeInternal() {
      int returnCode = IRewriteRule.OK;
      if (isFirstStage()) {
         returnCode = addTransitions();
      }
      return returnCode;
   }

   private int addTransitions() {
      int returnCode = IRewriteRule.OK;
      // find pattern: initial node -> fork node
      ForkNode fork = getFirstForkNode();
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

   private ForkNode getFirstForkNode() {
      ForkNode fork = null;
      EList<ActivityNode> nodes = activity.getNodes();
      stop:
      while (fork == null) {
         for (ActivityNode activityNode : nodes) {
            if (activityNode instanceof InitialNode) {
               InitialNode initial = (InitialNode) activityNode;
               EList<ActivityEdge> outgoingEdges = initial.getOut();
               for (ActivityEdge activityEdge : outgoingEdges) {
                  ActivityNode target = activityEdge.getTarget();
                  if (target instanceof ForkNode) {
                     fork = (ForkNode) target;
                     break stop;
                  }
               }
            }
         }
      }
      return fork;
   }

   private boolean isFirstStage() {
      String parentId = input.getAbstractParentRole().getId();
      Stage stage = StageModelUtil.getStageForId(parentId, stageModel);
      return StageModelUtil.isFirstStage(stage);
   }

}
