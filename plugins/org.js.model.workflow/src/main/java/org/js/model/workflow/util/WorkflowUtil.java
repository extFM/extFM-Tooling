package org.js.model.workflow.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.PackageElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.core.ModelElement;
import org.eclipse.jwt.meta.model.core.PackageableElement;
import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.we.model.view.Diagram;
import org.js.graph.transformation.*;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;

/**
 * This class is used as help methods.
 * 
 * @author Xi
 * 
 * 
 */
public class WorkflowUtil {

	public static final String WORKFLOW_FILE_EXTENSION = "workflow";
	public static final String WORKFLOW_VIEW_FILE_EXTENSION = "workflow_view";
	public static final String WORKFLOW_CONF_FILE_EXTENSION = "workflow_conf";

	public static StakeholderInput SHTempStore = null;

	/**
	 * get the workflow view resource for the given workflow resource.
	 * 
	 * @param workflowResource
	 * @return workflow view resource
	 */
	public static Resource getWorkflowViewReousrce(Resource workflowResource) {
		URI workflowViewUri = workflowResource.getURI().trimFileExtension()
				.appendFileExtension(WORKFLOW_VIEW_FILE_EXTENSION);
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(workflowViewUri, true);
	}

	/**
	 * get the workflow configuration resource for the given workflow resource.
	 * 
	 * @param workflowResource
	 * @return workflow configration resource
	 */
	public static Resource getWorkflowConfReousrce(Resource workflowResource) {
		URI workflowConfUri = workflowResource.getURI().trimFileExtension()
				.appendFileExtension(WORKFLOW_CONF_FILE_EXTENSION);
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(workflowConfUri, true);
	}

	/**
	 * get the resource for the given uri.
	 * 
	 * @param uri
	 * @return
	 */
	public static Resource getResource(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(uri, true);
	}

	/**
	 * get the resource for the given url.
	 * 
	 * @param fileresource
	 * @return
	 */
	public static Resource getResource(URL fileresource) {
		String path = fileresource.getPath();
		URI uri = URI.createFileURI(path);
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.getResource(uri, true);
	}

	/**
	 * store the stakeholder's inputs temporarily.
	 * 
	 * @param stakeholderName
	 * @param stakeholderTypeName
	 * @param stakeholderGroupName
	 * @param acm
	 * @param shTypes
	 * @return
	 */
	public static StakeholderInput analyzeShInput(String stakeholderName,
			String stakeholderTypeName, String stakeholderGroupName,
			AccessControlModel acm, EList<org.js.model.rbac.Role> shTypes) {
		org.js.model.rbac.Role stakeholderType = null;
		org.js.model.rbac.Role stakeholderGroupLeader = null;
		for (org.js.model.rbac.Role role : shTypes) {
			if (role.getId().equals(stakeholderTypeName)) {
				stakeholderType = role;
				break;
			}
		}
		for (Group group : acm.getGroups()) {
			if (group.getRepresents().getId().equals(stakeholderGroupName)) {
				stakeholderGroupLeader = group.getRepresents();
				break;
			}
		}
		return new StakeholderInput(stakeholderName, stakeholderType,
				stakeholderGroupLeader);
	}

	public static org.js.model.rbac.Role getRBACRole(Model model, String name){
		ACMConnector acmConnector=(ACMConnector) WorkflowConfUtil.getAspectInstance(model, WorkflowConfUtil.ACM_ASPECT);
		AccessControlModel acm = acmConnector.getAcmref();
		return getRBACRole( acm, name);
	}
	/**
	 * get the role in acm with the given name.
	 * 
	 * @param acm
	 * @param name
	 * @return
	 */
	public static org.js.model.rbac.Role getRBACRole(AccessControlModel acm,
			String name) {
		EList<org.js.model.rbac.Role> roles = acm.getRoles();
		for (org.js.model.rbac.Role role : roles) {
			if (role.getId().equals(name)) {
				return role;
			}
		}
		return null;
	}

	/**
	 * get the role referenced by the given action.
	 * @param action
	 * @return
	 */
	public static org.js.model.rbac.Role getRBACRole(Action action) {
		RoleConnector roleConnector = null;
		if( action.getPerformedBy()!=null){
			roleConnector=((RoleConnector) WorkflowConfUtil
				.getAspectInstance(((Action) action).getPerformedBy(),
						WorkflowConfUtil.ROLE_ASPECT));}
		if (roleConnector != null && roleConnector.getRoleref() != null) {
			return roleConnector.getRoleref();
		}
		return null;
	}
	
	/**
	 * get the jwt role with the given name.
	 * @param workflowModel
	 * @param name
	 * @return
	 */
public static  Role getJWTRole(Model workflowModel, String name){
	for(PackageableElement packageEle:workflowModel.getElements()){
		if(packageEle instanceof Role && ((Role)packageEle).getName().equals(name)){
			return (Role)packageEle;
		}
	}
	return null;
}
}
