package org.js.model.workflow.util;

import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.we.conf.model.Aspect;
import org.eclipse.jwt.we.conf.model.AspectInstance;
import org.eclipse.jwt.we.conf.model.ConfFactory;
import org.eclipse.jwt.we.conf.model.Profile;
import org.eclipse.jwt.we.conf.model.aspects.AspectManager;
import org.js.graph.transformation.GraphTransformation;
import org.js.model.feature.FeatureModel;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.ConfigurationDecision;
import org.js.model.rbac.Role;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.EFMContainer;
import org.js.model.workflow.GraphTransConnector;
import org.js.model.workflow.Log;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;
import org.js.model.workflow.WorkflowFactory;

/**
 * This class provides methods relating to configuration model.
 * 
 * @author Xi
 * 
 */
public class WorkflowConfUtil {

	public static WorkflowFactory workflowFactory = WorkflowFactory.eINSTANCE;
	public static ConfFactory confFactory = ConfFactory.eINSTANCE;
	public static final String ACM_FILE_EXTENSION_1 = "rbac";
	public static final String ACM_FILE_EXTENSION_2 = "rbactext";
	public static final String GT_FILE_EXTENSION_1 = "transformation";
	public static final String WORKFLOW_PROFILE_NAME = "org.js.model.workflow.profile";

	public static final String ACM_ASPECT = "org.js.model.workflow.acmaspect";
	public static final String GT_ASPECT = "org.js.model.workflow.transaspect";
	public static final String STAKHOLDERTYPES_ASPECT = "org.js.model.workflow.stakeholdertypesaspect";
	public static final String ROLE_ASPECT = "org.js.model.workflow.roleaspect";
	public static final String LOG_ASPECT = "org.js.model.workflow.logaspect";
	public static final String STATE_ASPECT = "org.js.model.workflow.stateaspect";
	public static final String EFM_ASPECT = "org.js.model.workflow.efmaspect";

	/**
	 * add the aspect instance for the given model element.
	 * 
	 * @param modelElement
	 * @param aspectName
	 * @return
	 */
	public static AspectInstance addAspectInstance(EObject modelElement,
			String aspectName) {
		Aspect aspect = AspectManager.INSTANCE.getAspect(modelElement,
				aspectName);
		return AspectManager.INSTANCE.createAndAddAspectInstance(aspect,
				modelElement);
	}

	public static boolean hasAspectInstance(EObject modelElement,
			String aspectName) {
		Aspect aspect = AspectManager.INSTANCE.getAspect(modelElement,
				aspectName);
		return AspectManager.INSTANCE.getAspectInstance(modelElement, aspect) != null;
	}

	public static AspectInstance getAspectInstance(EObject modelElement,
			String aspectName) {
		Aspect aspect = AspectManager.INSTANCE.getAspect(modelElement,
				aspectName);
		return AspectManager.INSTANCE.getAspectInstance(modelElement, aspect);
	}

	public static AspectInstance removeAspectInstance(EObject modelElement,
			String aspectName) {
		AspectInstance aspectInstance = getAspectInstance(modelElement,
				aspectName);
		aspectInstance.setTargetModelElement(null);
		AspectManager.INSTANCE.getConfModel(modelElement).getAspectInstances()
				.remove(aspectInstance);
		return aspectInstance;
	}

	public static void removeAspectInstances(EObject modelElement) {
		AspectManager.INSTANCE.getConfModel(modelElement).getAspectInstances()
				.clear();
	}

	public static void setACMRef(ACMConnector acmconnector,
			AccessControlModel acm) {
		acmconnector.setAcmref(acm);
	}

	public static void setRoleRef(RoleConnector roleconnector, Role role) {
		roleconnector.setRoleref(role);
	}

	public static void addConfigDecisions(Log log,
			List<ConfigurationDecision> decisionList) {
		log.getConfigurationDecisions().addAll(decisionList);
	}

	public static void addConfigPermission(Log log,
			ConfigurationDecision decisionList) {
		log.getConfigurationDecisions().add(decisionList);
	}

	public static void removeConfigPermission(Log log,
			ConfigurationDecision decisionList) {
		log.getConfigurationDecisions().remove(decisionList);
	}

	public static void removeConfigPermissions(Log log,
			List<ConfigurationDecision> decisionList) {
		log.getConfigurationDecisions().removeAll(decisionList);
	}

	public static void setState(State state, StateEnum stateEnum) {
		state.setState(stateEnum);
	}

	public static boolean containsProfile(Model workflowModel,
			String profileName) {
		List<Profile> activeProfiles = AspectManager.INSTANCE
				.getActivatedProfiles(workflowModel);
		for (Profile profile : activeProfiles) {
			if (profile.getName().equals(profileName)) {
				return true;
			}
		}
		return false;
	}

	public static void setGraphTrans(GraphTransConnector gtConnector,
			GraphTransformation graphTransformation) {
		gtConnector.setGraphTransref(graphTransformation);
	}

	public static void setEFM(EFMContainer efmContainer, FeatureModel fm) {
		efmContainer.setEfmref(fm);
	}
}
