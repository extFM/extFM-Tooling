package org.js.model.adaptation.rules.add;

import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.events.Event;
import org.eclipse.jwt.meta.model.processes.Action;
import org.js.graph.transform.stagemodel.Stage;
import org.js.graph.transform.stagemodel.StageModel;
import org.js.model.adaptation.ui.UserInputAddRole;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.StageModelUtil;


public class AddSuccessorFinalNode extends AbstractWorkflowAddRewriteRule {

   private StageModel stageModel;
   private static String FLOWFINAL = "final";
   
   public AddSuccessorFinalNode(UserInputAddRole input, Model workflow, StageModel stageModel) {
      super(input, workflow);
      this.stageModel = stageModel;
   }

   @Override
   protected int executeInternal() {
      if (isFinalStage()){
         addSuccessorFinalNode();
      }
      return 0;
   }

   private void addSuccessorFinalNode() {
     Action roleAction = input.getSpecializationAction();
     Event finalNode = ChangePrimitive.addFlowFinalNode(activity, diagram, FLOWFINAL, coordinate, coordinate);
     ChangePrimitive.addEdge(activity, roleAction, finalNode); 
   }

   private boolean isFinalStage() {
      boolean result = false;
      String stageId = input.getAbstractParentRole().getId();
      Stage stage = StageModelUtil.getStageForId(stageId, stageModel);
      if (stage != null){
         result = StageModelUtil.isLastStage(stage);
      }
      return result;
   }

}
