package org.js.model.adaptation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jwt.meta.model.core.Model;
import org.feature.model.utilities.ResourceUtil;
import org.js.graph.transform.stagemodel.StageModel;
import org.js.model.adaptation.rules.add.AddConcreteRole;
import org.js.model.adaptation.rules.add.AddIngoingTransitionsAnyStage;
import org.js.model.adaptation.rules.add.AddIngoingTransitionsFirstStage;
import org.js.model.adaptation.rules.add.AddRoleGroupMember;
import org.js.model.adaptation.rules.add.AddRoleGroupOwner;
import org.js.model.adaptation.rules.add.AddSpecializationAction;
import org.js.model.adaptation.rules.add.AddSuccessorFinalNode;
import org.js.model.adaptation.rules.add.AddSuccessorFork;
import org.js.model.adaptation.rules.remove.DisableSpecializationAction;
import org.js.model.adaptation.rules.remove.RemovePredecessorNodesAndEdges;
import org.js.model.adaptation.rules.remove.RemoveRoleAssociationsInAccessControlModel;
import org.js.model.adaptation.rules.remove.RemoveSpecializationAction;
import org.js.model.adaptation.rules.remove.RemoveSuccessorNodesAndEdges;
import org.js.model.adaptation.ui.UserInputAddRole;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.WorkflowUtil;

public class AdaptationEngine {

   private Model workflow;
   private AccessControlModel accessControlModel;
   private StageModel stageModel;

   public AdaptationEngine(Model workflow) {
      Assert.isNotNull(workflow);
      this.workflow = workflow;
      init();
   }

   private void init() {
      accessControlModel = WorkflowUtil.getAccessControlModel(workflow);
      stageModel = WorkflowUtil.getStageModel(workflow);
   }

   private Model getWorkflow() {
      return workflow;
   }

   private AccessControlModel getAccessControlModel() {
      return accessControlModel;
   }

   private StageModel getStageModel() {
      return stageModel;
   }

   /**
    * Integrate a new stakeholder by transforming the instance graphs of access control model and workflow.
    */
   public void integrateStakeholder(UserInputAddRole userInput) {
      LinkedList<IRewriteRule> orderedRules = new LinkedList<IRewriteRule>();

      // 1. create role in access control model and insert parent relation to abstract role
      orderedRules.add(new AddConcreteRole(userInput, getAccessControlModel()));
      // 2. assign member relation to group owner role
      orderedRules.add(new AddRoleGroupMember(userInput, getAccessControlModel()));
      // 3. add specialization action for new rbac role
      orderedRules.add(new AddSpecializationAction(userInput, getWorkflow()));
      // 4. add transition to predecessing fork if role belongs to first stage
      orderedRules.add(new AddIngoingTransitionsFirstStage(userInput, getWorkflow(), getStageModel()));
      // 5. add transition to predecessing fork if role does not belong to the first stage
      orderedRules.add(new AddIngoingTransitionsAnyStage(userInput,  getWorkflow(), getStageModel()));
      // 6. add role group in access control model and add role as owner if role does not belong to last stage
      orderedRules.add(new AddRoleGroupOwner(userInput, getAccessControlModel(), getStageModel()));
      // 7. add successor edge and fork node in workflow model
      orderedRules.add(new AddSuccessorFork(userInput, getWorkflow(), getAccessControlModel()));
      // 8. add successor flow final node if role added to last stage
      orderedRules.add(new AddSuccessorFinalNode(userInput, getWorkflow(), getStageModel()));
      
      executeRules(orderedRules);

      List<EObject> models = new ArrayList<EObject>(3);
      models.add(getAccessControlModel());
      saveModels(models);
   }

   private void saveModels(List<EObject> models) {
      for (EObject eObject : models) {
         ResourceUtil.saveModel(eObject);
      }
   }

   private void executeRules(LinkedList<IRewriteRule> orderedRules) {
      for (Iterator<IRewriteRule> iterator = orderedRules.iterator(); iterator.hasNext();) {
         IRewriteRule rewriteRule = (IRewriteRule) iterator.next();
         int returnCode = rewriteRule.execute();
         if (returnCode == IRewriteRule.Error) {
            System.out.println("Error occured while executing rewrite rule" + rewriteRule.getClass());
            break;
         }
      }
   }

   /**
    * 
    * Remove a new stakeholder by transforming the instance graphs of access control model and workflow. Recursively
    * remove depending stakeholders.
    */
   public void removeStakeholder(Role role) {
      LinkedList<IRewriteRule> orderedRules = new LinkedList<IRewriteRule>();
      // 1. disable role's specialization action
      //orderedRules.add(new DisableSpecializationAction(role, workflow));
      // 2. remove logs related to removable role
      // 3. remove flow final node and outgoing transitions in last stage
      orderedRules.add(new RemoveSuccessorNodesAndEdges(role, workflow, stageModel));
      // 4. remove predecessor nodes and edges and role action
      orderedRules.add(new RemovePredecessorNodesAndEdges(role, workflow, accessControlModel));
      // 5. remove roles and groups in access control model
      orderedRules.add(new RemoveSpecializationAction(role, workflow));
      // 6. remove role and relations in access control model
      orderedRules.add(new RemoveRoleAssociationsInAccessControlModel(role, accessControlModel));
      
      executeRules(orderedRules);

      List<EObject> models = new ArrayList<EObject>(3);
      models.add(getAccessControlModel());
      saveModels(models);
   }

}
