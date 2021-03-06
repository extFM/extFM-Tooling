package org.js.model.workflow.util;

import java.io.IOException;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.events.Event;
import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.FinalNode;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.eclipse.jwt.meta.model.processes.InitialNode;
import org.eclipse.jwt.meta.model.processes.JoinNode;
import org.eclipse.jwt.we.model.view.Diagram;
import org.eclipse.jwt.we.model.view.ReferenceEdge;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.RBACService;
import org.js.model.rbac.impl.RbacFactoryImpl;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.EFMContainer;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;

/**
 * This class is used as the primitive operations of workflow elements.
 * 
 * @author Xi
 * 
 */
public class ChangePrimitive {

   public static RBACService rbacService = new RBACService();

   public static Action addAction(Model workflowModel, Activity activity, Diagram diagram, String actionName, int actionCoorX,
                                  int actionCoorY) {

      // add action
      ActivityNode actNode = WorkflowModelUtil.addAction(activity, actionName);
      WorkflowViewUtil.setNodeLayout(diagram, actNode, actionCoorX, actionCoorY);

      // add aspects for the action
      if (WorkflowConfUtil.containsProfile(workflowModel, WorkflowConfUtil.WORKFLOW_PROFILE_NAME)) {
         if (!WorkflowModelUtil.getActionName((Action) actNode).equals(WorkflowModelUtil.IDLE_ACTION)) {
            // add log aspect
            WorkflowConfUtil.addAspectInstance(actNode, WorkflowConfUtil.LOG_ASPECT);
            // add the aspect of efm container
            EFMContainer efmContainer = (EFMContainer) WorkflowConfUtil.addAspectInstance(actNode, WorkflowConfUtil.EFM_ASPECT);

            // // get uri of efm
            // ACMConnector acmConnector = (ACMConnector) WorkflowConfUtil
            // .getAspectInstance(workflowModel,
            // WorkflowConfUtil.ACM_ASPECT);
            // AccessControlModel acm = acmConnector.getAcmref();
            // FeatureModel oldFM = acm.getFeatureModels().get(0);
            // URI oldFMUri = oldFM.eResource().getURI();
            //
            // // copy efm file for the added action
            // String oldFileName = oldFMUri.lastSegment();
            // URI resolvedFile = CommonPlugin.resolve(oldFMUri);
            // IFile oldFile = ResourcesPlugin.getWorkspace().getRoot()
            // .getFile(new Path(resolvedFile.toFileString()));
            // String oldFilePath = oldFile.getFullPath().toString();
            // String newFileName = roleName + "." +
            // oldFMUri.fileExtension();
            // String newFilePath = oldFilePath.replace(oldFileName,
            // newFileName);
            // File file = WorkflowUtil.copyFile(oldFilePath, newFilePath);
            //
            // // get the uri of the added file
            // URI newFileUri=WorkflowUtil.getURI(file);
            //
            // // add efm reference
            // FeatureModel newFm = WorkflowUtil.getFMMModel(newFileUri);
            // WorkflowConfUtil.setEFM(efmContainer, newFm);
         }
         // add state aspect
         State state = (State) WorkflowConfUtil.addAspectInstance(actNode, WorkflowConfUtil.STATE_ASPECT);
         WorkflowConfUtil.setState(state, StateEnum.INACTIVE);

         // set the name with the state
         actNode.setName(actNode.getName() + " (" + state.getState().getName() + ") ");
      }
      return (Action) actNode;
   }

   public static void updateActionState(Action action) {
      // WorkflowConfUtil.setState(state, StateEnum.INACTIVE);
      WorkflowModelUtil.setActionState(action);
      // State state = (State) WorkflowConfUtil.getAspectInstance(action,
      // WorkflowConfUtil.STATE_ASPECT);
      // // set the name with the state
      // action.setName(WorkflowModelUtil.getActionName(action) + " ("
      // + state.getState().getName() + ") ");
   }

   public static ActivityNode removeActivityNode(Model workflowModel, Activity activity, Diagram diagram, String name) {
      ActivityNode actNode = WorkflowModelUtil.getActivityNode(activity, name);
      removeActivityNode(workflowModel, activity, diagram, actNode);
      return actNode;
   }

   public static ActivityNode removeActivityNode(Model workflowModel, Activity activity, Diagram diagram, ActivityNode node) {

      if (node instanceof Action) {
         Action action = (Action) node;
         removeAction(workflowModel, activity, diagram, action);
      } else {
         activity.getNodes().remove(node);
         WorkflowViewUtil.removeNodeLayout(diagram, node);
      }
      return node;
   }

   public static Action removeAction(Model workflowModel, Activity activity, Diagram diagram, String actionName) {
      ActivityNode actNode = WorkflowModelUtil.getActivityNode(activity, actionName);
      removeAction(workflowModel, activity, diagram, (Action) actNode);
      return (Action) actNode;
   }

   public static void removeAction(Model workflowModel, Activity activity, Diagram diagram, Action action) {
      // remove log aspect
      WorkflowConfUtil.removeAspectInstance(action, WorkflowConfUtil.LOG_ASPECT);
      // remove state aspect
      WorkflowConfUtil.removeAspectInstance(action, WorkflowConfUtil.STATE_ASPECT);
      // remove role if assigned
      Role workflowRole = WorkflowUtil.getRole(workflowModel, action);
      if (workflowRole != null) {
         ChangePrimitive.removeRoleActionRef(diagram, workflowRole, action);
         ChangePrimitive.removeWorkflowRole(workflowRole, workflowModel, activity, diagram);
      }
      // remove action
      EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(action);
      if (domain != null) {
         Command command = DeleteCommand.create(domain, action);
         if (command.canExecute()) {
            command.execute();
         }
      }
      WorkflowModelUtil.removeActivityNode(activity, action);
      WorkflowViewUtil.removeNodeLayout(diagram, action);

   }

   public static InitialNode addInitialNode(Activity activity, Diagram diagram, String name, int coorX, int coorY) {
      InitialNode initialNode = WorkflowModelUtil.addInitialNode(activity, name);
      WorkflowViewUtil.setNodeLayout(diagram, initialNode, coorX, coorY);
      return initialNode;
   }

   public static InitialNode removeInitialNode(Activity activity, Diagram diagram, String name) {
      ActivityNode actNode = WorkflowModelUtil.removeActivityNode(activity, name);
      WorkflowViewUtil.removeNodeLayout(diagram, actNode);
      return (InitialNode) actNode;

   }

   public static FinalNode addActivityFinalNode(Activity activity, Diagram diagram, String name, int coorX, int coorY) {
      FinalNode finalNode = WorkflowModelUtil.addFinalNode(activity, name);
      WorkflowViewUtil.setNodeLayout(diagram, finalNode, coorX, coorY);
      return finalNode;
   }

   public static FinalNode removeActivityFinalNode(Activity activity, Diagram diagram, String name) {
      ActivityNode actNode = WorkflowModelUtil.removeActivityNode(activity, name);
      WorkflowViewUtil.removeNodeLayout(diagram, actNode);
      return (FinalNode) actNode;
   }

   public static ForkNode addForkNode(Activity activity, Diagram diagram, int coorX, int coorY) {
      ForkNode forkNode = WorkflowModelUtil.addForkNode(activity);
      WorkflowViewUtil.setNodeLayout(diagram, forkNode, coorX, coorY);
      return (ForkNode) forkNode;
   }

   public static ForkNode removeForkNode(Activity activity, Diagram diagram, ForkNode forkNode) {
      ActivityNode actNode = WorkflowModelUtil.removeActivityNode(activity, forkNode);
      WorkflowViewUtil.removeNodeLayout(diagram, actNode);
      return (ForkNode) actNode;
   }

   public static JoinNode addJoinNode(Activity activity, Diagram diagram, int coorX, int coorY) {
      JoinNode joinNode = WorkflowModelUtil.addJoinNode(activity);
      WorkflowViewUtil.setNodeLayout(diagram, joinNode, coorX, coorY);
      return (JoinNode) joinNode;
   }

   public static JoinNode removeJoinNode(Activity activity, Diagram diagram, JoinNode joinNode) {
      ActivityNode actNode = WorkflowModelUtil.removeActivityNode(activity, joinNode);
      WorkflowViewUtil.removeNodeLayout(diagram, actNode);
      return (JoinNode) actNode;
   }

   public static ActivityEdge addEdge(Activity activity, ActivityNode source, ActivityNode target) {
      return WorkflowModelUtil.addEdge(activity, source, target);
   }

   public static ActivityEdge removeEdge(Activity activity, ActivityNode source, ActivityNode target) {
      return WorkflowModelUtil.removeEdge(activity, source, target);
   }

   public static void removeEdge(Activity activity, ActivityEdge edge) {
      WorkflowModelUtil.removeEdge(activity, edge);
   }

   /**
    * we use event in jwt as final flow node in activity diagram
    * 
    * @param activity
    * @param diagram
    * @param name
    * @param coorX
    * @param coorY
    * @return
    */
   public static Event addFlowFinalNode(Activity activity, Diagram diagram, String name, int coorX, int coorY) {
      Event event = WorkflowModelUtil.addEvent(activity, name);
      WorkflowViewUtil.setNodeLayout(diagram, event, coorX, coorY);
      return event;
   }

   public static Event removeFlowFinalNode(Activity activity, Diagram diagram, String name) {
      ActivityNode actNode = WorkflowModelUtil.removeActivityNode(activity, name);
      WorkflowViewUtil.removeNodeLayout(diagram, actNode);
      return (Event) actNode;
   }

   public static Role addRole(Model workflowModel, Activity activity, Diagram diagram, org.js.model.rbac.Role roleType, String name,
                              int roleCoorX, int roleCoorY) {
      org.js.model.rbac.Role rbacRole = WorkflowUtil.getRBACRole(workflowModel, name);
      Role jwtRole = null;
      if (rbacRole == null) {
         // add jwt role
         jwtRole = WorkflowModelUtil.addRole(workflowModel, name);
         WorkflowViewUtil.setRoleLayout(diagram, activity, jwtRole, roleCoorX, roleCoorY);

         // add role aspect
         if (WorkflowConfUtil.containsProfile(workflowModel, WorkflowConfUtil.WORKFLOW_PROFILE_NAME)) {
            ACMConnector acmconnector = (ACMConnector) WorkflowConfUtil.getAspectInstance(workflowModel, WorkflowConfUtil.ACM_ASPECT);
            // add rbac role into the rbac model
            AccessControlModel acm = (AccessControlModel) acmconnector.getAcmref();
            RoleConnector roleConnector = (RoleConnector) WorkflowConfUtil.addAspectInstance(jwtRole, WorkflowConfUtil.ROLE_ASPECT);

            rbacRole = RbacFactoryImpl.eINSTANCE.createRole();
            // rbacService.getParentRoles(rbacRole).add(stageRole);
            rbacRole.getParentRoles().add(roleType);
            rbacRole.setName(name);
            rbacRole.setId(name);

            acm.getRoles().add(rbacRole);
            try {
               acm.eResource().save(null);
            } catch (IOException e) {
               e.printStackTrace();
            }
            WorkflowConfUtil.setRoleRef(roleConnector, rbacRole);

         }
      } else {
         jwtRole = WorkflowModelUtil.getRole(workflowModel, name);
      }
      return jwtRole;
   }

   /**
    * add a new group into the rbac model if the group is not included in the model.
    * 
    * @param workflowModel
    * @param groupLeader
    * @param groupMember
    * @return
    */
   public static Group addGroup(Model workflowModel, org.js.model.rbac.Role groupLeader, org.js.model.rbac.Role groupMember) {
      ACMConnector acmconnector = (ACMConnector) WorkflowConfUtil.getAspectInstance(workflowModel, WorkflowConfUtil.ACM_ASPECT);
      // add rbac role into the rbac model
      AccessControlModel acm = (AccessControlModel) acmconnector.getAcmref();
      Group group = null;
      for (Group tempGroup : acm.getGroups()) {
         if (tempGroup.getOwner().getId().equals(groupLeader.getId())) {
            group = tempGroup;
            break;
         }
      }
      if (group == null) {
         group = RbacFactoryImpl.eINSTANCE.createGroup();
         group.setOwner(groupLeader);
         group.setId(groupLeader.getId());
         group.setName(groupLeader.getName());
         acm.getGroups().add(group);
      }
      boolean containsMember = false;
      for (org.js.model.rbac.Role member : group.getMembers()) {
         if (member.getId().equals(groupMember.getId())) {
            containsMember = true;
            break;
         }
      }
      if (!containsMember) {
         group.getMembers().add(groupMember);
      }
      try {
         acm.eResource().save(null);
      } catch (IOException e) {
         e.printStackTrace();
      }
      return group;
   }

   public static void removeWorkflowRole(Role workflowRole, Model workflowModel, Activity activity, Diagram diagram) {
      // remove role aspect
      if (WorkflowConfUtil.containsProfile(workflowModel, WorkflowConfUtil.WORKFLOW_PROFILE_NAME)) {
         WorkflowConfUtil.removeAspectInstance(workflowRole, WorkflowConfUtil.ROLE_ASPECT);
      }
      // remove role
      WorkflowViewUtil.removeRoleLayout(diagram, workflowRole);
      WorkflowModelUtil.removeRole(workflowModel, workflowRole);
   }

   public static Role removeRole(Model workflowModel, Activity activity, Diagram diagram, String roleName) {
      Role role = WorkflowModelUtil.getRole(workflowModel, roleName);
      ChangePrimitive.removeWorkflowRole(role, workflowModel, activity, diagram);
      // remove rbac role from rbac model
      ACMConnector acmconnector = (ACMConnector) WorkflowConfUtil.getAspectInstance(workflowModel, WorkflowConfUtil.ACM_ASPECT);
      AccessControlModel acm = (AccessControlModel) acmconnector.getAcmref();
      acm.getRoles().remove(WorkflowUtil.getRBACRole(acm, roleName));

      // remove the related actions
      // removeAction(workflowModel, activity, diagram, roleName);
      return role;
   }

   public static ReferenceEdge addRoleActionRef(Model workflowModel, Activity activity, Diagram diagram, Role role, Action action) {
      return WorkflowViewUtil.setReferenceEdge(diagram, activity, role, action);
   }

   public static ReferenceEdge removeRoleActionRef(Diagram diagram, Role role, Action action) {
      return WorkflowViewUtil.removeReferenceEdge(diagram, role, action);
   }

}
