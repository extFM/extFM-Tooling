package org.js.model.adaptation.rules.remove;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.eclipse.jwt.meta.model.processes.InitialNode;
import org.js.model.adaptation.IRewriteRule;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.AccessControlModelUtil;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.WorkflowModelUtil;

public class RemovePredecessorNodesAndEdges extends AbstractWorkflowRemoveRewriteRule {

   AccessControlModel accessControlModel;

   public RemovePredecessorNodesAndEdges(Role role, Model workflow, AccessControlModel accessControlModel) {
      super(role, workflow);
      this.accessControlModel = accessControlModel;
   }

   @Override
   protected int executeInternal() {
      removePredecessingEdges();
      return IRewriteRule.OK;
   }

   private void removePredecessingEdges() {

      Group roleGroup = AccessControlModelUtil.getRoleGroupForMember(role, accessControlModel);
      ArrayList<Action> memberActions = WorkflowModelUtil.getActions(activity, role);
      if (roleGroup != null){
      Role owner = roleGroup.getOwner();

      ArrayList<Action> ownerActions = WorkflowModelUtil.getActions(activity, owner);
      for (Action ownerAction : ownerActions) {
         for (Action memberAction : memberActions) {
            deleteEdges(ownerAction, memberAction);
           // deleteAction(memberAction);
         }
      }
      } else {
         // role belongs to first stage, therefore remove edge between initial fork and member action
         InitialNode initialNode = WorkflowModelUtil.getInitialNode(activity);
         for (Action memberAction : memberActions) {
            deleteEdges(initialNode, memberAction);
         }
      }
   }

   private void deleteAction(Action memberAction) {
      ChangePrimitive.removeAction(workflow, activity, diagram, memberAction);
   }

   private void deleteEdges(ActivityNode ownerAction, Action memberAction) {
      EList<ActivityEdge> out = ownerAction.getOut();
      for (ActivityEdge activityEdge : out) {
         ActivityNode target = activityEdge.getTarget();
         if (target instanceof ForkNode) {
            ForkNode fork = (ForkNode) target;
            Set<EObject> path = WorkflowModelUtil.findPath(fork, memberAction, new HashSet<EObject>());
            for (EObject eObject : path) {
               deleteElement(eObject);
            }
         }
      }
   }

   private void deleteElement(EObject eObject) {
      if (eObject instanceof ForkNode) {
         ForkNode node = (ForkNode) eObject;
         ChangePrimitive.removeForkNode(activity, diagram, node);
      } else if (eObject instanceof ActivityEdge) {
         ActivityEdge edge = (ActivityEdge) eObject;
         ChangePrimitive.removeEdge(activity, edge);
      }
   }

}
