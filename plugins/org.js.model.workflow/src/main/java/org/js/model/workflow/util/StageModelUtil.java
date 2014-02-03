package org.js.model.workflow.util;

import org.eclipse.emf.common.util.EList;
import org.js.graph.transform.stagemodel.Stage;
import org.js.graph.transform.stagemodel.StageModel;

public final class StageModelUtil {

   public static Stage getStageForId(String stageId, StageModel stageModel) {
      Stage result = null;
      EList<Stage> stages = stageModel.getStages();
      for (Stage stage : stages) {
         String modelStageId = stage.getId();
         if (modelStageId.equals(stageId)) {
            result = stage;
            break;
         }
      }
      return result;
   }

   
   public static boolean isFirstStage(Stage stage) {
      boolean isFirst = stage.getPredecessor() == null;
      return isFirst;
   }

   public static boolean isLastStage(Stage stage) {
      boolean isLast = stage.getSuccessor() == null;
      return isLast;
   }
   
}
