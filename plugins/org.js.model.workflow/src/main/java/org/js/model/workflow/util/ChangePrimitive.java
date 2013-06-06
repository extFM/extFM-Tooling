package org.js.model.workflow.util;

import java.io.File;
import java.io.IOException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
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
import org.js.model.feature.FeatureModel;
import org.js.model.rbac.AccessControlModel;
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

	public static Action addAction(Model workflowModel, Activity activity,
			Diagram diagram, String actionName, String roleName,
			int actionCoorX, int actionCoorY) {

		// add action
		ActivityNode actNode = WorkflowModelUtil
				.addAction(activity, actionName);
		WorkflowViewUtil.setNodeLayout(diagram, actNode, actionCoorX,
				actionCoorY);

		// add aspects for the action
		if (WorkflowConfUtil.containsProfile(workflowModel,
				WorkflowConfUtil.WORKFLOW_PROFILE_NAME)) {
			if (!WorkflowModelUtil.getActionName((Action) actNode).equals(
					WorkflowModelUtil.IDLE_ACTION)) {
				// add log aspect
				WorkflowConfUtil.addAspectInstance(actNode,
						WorkflowConfUtil.LOG_ASPECT);
				// add the aspect of efm container
				EFMContainer efmContainer = (EFMContainer) WorkflowConfUtil
						.addAspectInstance(actNode, WorkflowConfUtil.EFM_ASPECT);

//				// get uri of efm
//				ACMConnector acmConnector = (ACMConnector) WorkflowConfUtil
//						.getAspectInstance(workflowModel,
//								WorkflowConfUtil.ACM_ASPECT);
//				AccessControlModel acm = acmConnector.getAcmref();
//				FeatureModel oldFM = acm.getFeatureModels().get(0);
//				URI oldFMUri = oldFM.eResource().getURI();
//				
//				// copy efm file for the added action
//				String oldFileName = oldFMUri.lastSegment();
//				URI resolvedFile = CommonPlugin.resolve(oldFMUri);
//				IFile oldFile = ResourcesPlugin.getWorkspace().getRoot()
//						.getFile(new Path(resolvedFile.toFileString()));
//				String oldFilePath = oldFile.getFullPath().toString();
//				String newFileName = roleName + "." + oldFMUri.fileExtension();
//				String newFilePath = oldFilePath.replace(oldFileName,
//						newFileName);
//				File file = WorkflowUtil.copyFile(oldFilePath, newFilePath);
//
//				// get the uri of the added file
//				URI newFileUri=WorkflowUtil.getURI(file);
//
//				// add efm reference
//				FeatureModel newFm = WorkflowUtil.getFMMModel(newFileUri);
//				WorkflowConfUtil.setEFM(efmContainer, newFm);
			}
			// add state aspect
			State state = (State) WorkflowConfUtil.addAspectInstance(actNode,
					WorkflowConfUtil.STATE_ASPECT);
			WorkflowConfUtil.setState(state, StateEnum.INACTIVE);

			// set the name with the state
			actNode.setName(actNode.getName() + " ("
					+ state.getState().getName() + ") ");
		}
		return (Action) actNode;
	}

	public static void updateActionState(Action action) {
		// WorkflowConfUtil.setState(state, StateEnum.INACTIVE);
		WorkflowModelUtil.setActionState(action);
		State state = (State) WorkflowConfUtil.getAspectInstance(action,
				WorkflowConfUtil.STATE_ASPECT);
		// set the name with the state
		action.setName(WorkflowModelUtil.getActionName(action) + " ("
				+ state.getState().getName() + ") ");
	}

	public static Action removeAction(Model workflowModel, Activity activity,
			Diagram diagram, String actionName) {
		ActivityNode actNode = WorkflowModelUtil.getActivityNode(activity,
				actionName);

		// remove log aspect
		WorkflowConfUtil.removeAspectInstance(actNode,
				WorkflowConfUtil.LOG_ASPECT);
		// remove state aspect
		WorkflowConfUtil.removeAspectInstance(actNode,
				WorkflowConfUtil.STATE_ASPECT);
		// remove action
		WorkflowModelUtil.removeActivityNode(activity, actionName);
		WorkflowViewUtil.removeNodeLayout(diagram, actNode);
		return (Action) actNode;
	}

	public static InitialNode addInitialNode(Activity activity,
			Diagram diagram, String name, int coorX, int coorY) {
		InitialNode initialNode = WorkflowModelUtil.addInitialNode(activity,
				name);
		WorkflowViewUtil.setNodeLayout(diagram, initialNode, coorX, coorY);
		return initialNode;
	}

	public static InitialNode removeInitialNode(Activity activity,
			Diagram diagram, String name) {
		ActivityNode actNode = WorkflowModelUtil.removeActivityNode(activity,
				name);
		WorkflowViewUtil.removeNodeLayout(diagram, actNode);
		return (InitialNode) actNode;

	}

	public static FinalNode addActivityFinalNode(Activity activity,
			Diagram diagram, String name, int coorX, int coorY) {
		FinalNode finalNode = WorkflowModelUtil.addFinalNode(activity, name);
		WorkflowViewUtil.setNodeLayout(diagram, finalNode, coorX, coorY);
		return finalNode;
	}

	public static FinalNode removeActivityFinalNode(Activity activity,
			Diagram diagram, String name) {
		ActivityNode actNode = WorkflowModelUtil.removeActivityNode(activity,
				name);
		WorkflowViewUtil.removeNodeLayout(diagram, actNode);
		return (FinalNode) actNode;
	}

	public static ForkNode addForkNode(Activity activity, Diagram diagram,
			int coorX, int coorY) {
		ForkNode forkNode = WorkflowModelUtil.addForkNode(activity);
		WorkflowViewUtil.setNodeLayout(diagram, forkNode, coorX, coorY);
		return (ForkNode) forkNode;
	}

	public static ForkNode removeForkNode(Activity activity, Diagram diagram,
			ForkNode forkNode) {
		ActivityNode actNode = WorkflowModelUtil.removeActivityNode(activity,
				forkNode);
		WorkflowViewUtil.removeNodeLayout(diagram, actNode);
		return (ForkNode) actNode;
	}

	public static JoinNode addJoinNode(Activity activity, Diagram diagram,
			int coorX, int coorY) {
		JoinNode joinNode = WorkflowModelUtil.addJoinNode(activity);
		WorkflowViewUtil.setNodeLayout(diagram, joinNode, coorX, coorY);
		return (JoinNode) joinNode;
	}

	public static JoinNode removeJoinNode(Activity activity, Diagram diagram,
			JoinNode joinNode) {
		ActivityNode actNode = WorkflowModelUtil.removeActivityNode(activity,
				joinNode);
		WorkflowViewUtil.removeNodeLayout(diagram, actNode);
		return (JoinNode) actNode;
	}

	public static ActivityEdge addEdge(Activity activity, ActivityNode source,
			ActivityNode target) {
		return WorkflowModelUtil.addEdge(activity, source, target);
	}

	public static ActivityEdge removeEdge(Activity activity,
			ActivityNode source, ActivityNode target) {
		return WorkflowModelUtil.removeEdge(activity, source, target);
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
	public static Event addFlowFinalNode(Activity activity, Diagram diagram,
			String name, int coorX, int coorY) {
		Event event = WorkflowModelUtil.addEvent(activity, name);
		WorkflowViewUtil.setNodeLayout(diagram, event, coorX, coorY);
		return event;
	}

	public static Event removeFlowFinalNode(Activity activity, Diagram diagram,
			String name) {
		ActivityNode actNode = WorkflowModelUtil.removeActivityNode(activity,
				name);
		WorkflowViewUtil.removeNodeLayout(diagram, actNode);
		return (Event) actNode;
	}

	public static Role addRole(Model workflowModel, Activity activity,
			Diagram diagram, org.js.model.rbac.Role roleType, String name,
			int roleCoorX, int roleCoorY) {
		org.js.model.rbac.Role rbacRole = WorkflowUtil.getRBACRole(
				workflowModel, name);
		Role jwtRole = null;
		if (rbacRole == null) {
			// add role
			jwtRole = WorkflowModelUtil.addRole(workflowModel, name);
			WorkflowViewUtil.setRoleLayout(diagram, activity, jwtRole,
					roleCoorX, roleCoorY);

			// add role aspect
			if (WorkflowConfUtil.containsProfile(workflowModel,
					WorkflowConfUtil.WORKFLOW_PROFILE_NAME)) {
				ACMConnector acmconnector = (ACMConnector) WorkflowConfUtil
						.getAspectInstance(workflowModel,
								WorkflowConfUtil.ACM_ASPECT);
				// add rbac role into the rbac model
				AccessControlModel acm = (AccessControlModel) acmconnector
						.getAcmref();
				RoleConnector roleConnector = (RoleConnector) WorkflowConfUtil
						.addAspectInstance(jwtRole,
								WorkflowConfUtil.ROLE_ASPECT);
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

	public static Role removeRole(Model workflowModel, Activity activity,
			Diagram diagram, String roleName) {
		Role role = WorkflowModelUtil.getRole(workflowModel, roleName);
		// remove role aspect
		if (WorkflowConfUtil.containsProfile(workflowModel,
				WorkflowConfUtil.WORKFLOW_PROFILE_NAME)) {
			WorkflowConfUtil.removeAspectInstance(role,
					WorkflowConfUtil.ROLE_ASPECT);
			// remove rbac role from rbac model
			ACMConnector acmconnector = (ACMConnector) WorkflowConfUtil
					.getAspectInstance(workflowModel,
							WorkflowConfUtil.ACM_ASPECT);
			AccessControlModel acm = (AccessControlModel) acmconnector
					.getAcmref();
			acm.getRoles().remove(WorkflowUtil.getRBACRole(acm, roleName));
		}
		// remove role
		WorkflowViewUtil.removeRoleLayout(diagram, role);
		WorkflowModelUtil.removeRole(workflowModel, roleName);
		// remove the related actions
		// removeAction(workflowModel, activity, diagram, roleName);
		return role;
	}

	public static ReferenceEdge addRoleActionRef(Model workflowModel,
			Activity activity, Diagram diagram, Role role, Action action) {
		return WorkflowViewUtil.setReferenceEdge(diagram, activity, role,
				action);
	}

	public static ReferenceEdge removeRoleActionRef(Diagram diagram, Role role,
			Action action) {
		return WorkflowViewUtil.removeReferenceEdge(diagram, role, action);
	}

}
