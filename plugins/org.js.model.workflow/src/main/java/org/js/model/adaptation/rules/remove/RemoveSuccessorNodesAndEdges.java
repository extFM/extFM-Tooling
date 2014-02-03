package org.js.model.adaptation.rules.remove;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.js.graph.transform.stagemodel.Stage;
import org.js.graph.transform.stagemodel.StageModel;
import org.js.model.adaptation.IRewriteRule;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.StageModelUtil;
import org.js.model.workflow.util.WorkflowModelUtil;

public class RemoveSuccessorNodesAndEdges extends AbstractWorkflowRemoveRewriteRule {

   private StageModel stageModel;

   public RemoveSuccessorNodesAndEdges(Role role, Model workflow, StageModel stageModel) {
      super(role, workflow);
      this.stageModel = stageModel;
   }

   @Override
   protected int executeInternal() {
      // if (isFinalStage()) {
      removeSuccessorNodesAndEdges();
      // }
      return IRewriteRule.OK;
   }

   private void removeSuccessorNodesAndEdges() {
      ArrayList<Action> actions = WorkflowModelUtil.getActions(activity, role);
      for (Action action : actions) {
         removeOutgoingEdgesAndNodes(action);
      }
   }

   private void removeOutgoingEdgesAndNodes(ActivityNode node) {
      EList<ActivityEdge> out = node.getOut();
      Set<ActivityEdge> copy = new HashSet<ActivityEdge>(out.size());
      copy.addAll(out);
      for (ActivityEdge activityEdge : copy) {
         ActivityNode target = activityEdge.getTarget();
         ChangePrimitive.removeEdge(activity, node, target);
         removeNodeRecursively(target);
      }
   }

   private void removeNodeRecursively(ActivityNode node) {
      EList<ActivityEdge> out = node.getOut();
      Set<ActivityEdge> copy = new HashSet<ActivityEdge>(out.size());
      copy.addAll(out);
      if (!copy.isEmpty()) {
         for (ActivityEdge edge : copy) {
            ActivityNode target = edge.getTarget();
            ChangePrimitive.removeEdge(activity, node, target);
            removeNodeRecursively(target);
         }
      }
      ChangePrimitive.removeActivityNode(workflow, activity, diagram, node);
   }

   private boolean isFinalStage() {
      boolean isFinal = false;
      Stage parentStage = getParentStage(role);
      if (parentStage != null) {
         isFinal = parentStage.getSuccessor() == null;
      }
      return isFinal;
   }

   protected Stage getParentStage(Role role) {
      EList<Role> parentRoles = role.getParentRoles();
      Stage parentStage = null;
      for (Role parentRole : parentRoles) {
         parentStage = StageModelUtil.getStageForId(parentRole.getId(), stageModel);
         if (parentStage != null) {
            break;
         }
      }
      return parentStage;
   }

}
