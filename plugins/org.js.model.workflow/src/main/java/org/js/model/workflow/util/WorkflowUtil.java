package org.js.model.workflow.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.js.model.feature.FeatureModel;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.RoleConnector;

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

	public static URI featureModeluri = null;
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
	 * get uri for the given file.
	 * @param file
	 * @return
	 */
	public static URI getURI(File file){
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = Path.fromOSString(file.getAbsolutePath());
		IFile newFile = workspace.getRoot()
				.getFileForLocation(location);
		URI newFileUri = URI.createPlatformResourceURI(newFile
				.getFullPath().toOSString(), true);
		return newFileUri;
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

	public static org.js.model.rbac.Role getRBACRole(Model model, String name) {
		ACMConnector acmConnector = (ACMConnector) WorkflowConfUtil
				.getAspectInstance(model, WorkflowConfUtil.ACM_ASPECT);
		AccessControlModel acm = acmConnector.getAcmref();
		return getRBACRole(acm, name);
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
	 * 
	 * @param action
	 * @return
	 */
	public static org.js.model.rbac.Role getRBACRole(Action action) {
		RoleConnector roleConnector = null;
		if (action.getPerformedBy() != null) {
			roleConnector = ((RoleConnector) WorkflowConfUtil
					.getAspectInstance(((Action) action).getPerformedBy(),
							WorkflowConfUtil.ROLE_ASPECT));
		}
		if (roleConnector != null && roleConnector.getRoleref() != null) {
			return roleConnector.getRoleref();
		}
		return null;
	}

	/**
	 * copy a file.
	 * 
	 * @param oldPath
	 * @param newPath
	 * @return
	 */
	public static File copyFile(String oldPath, String newPath) {
		try {
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				InputStream inStream = new FileInputStream(oldPath);
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				return new File(newPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * get the efm model from the given uri.
	 * 
	 * @param uri
	 * @return
	 */
	public static FeatureModel getFMMModel(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource rbacRes = resourceSet.getResource(uri, true);
		try {
			rbacRes.load(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		TreeIterator<EObject> rbacIt = rbacRes.getAllContents();
		FeatureModel fm = null;

		while (rbacIt.hasNext()) {
			EObject object = rbacIt.next();
			if (object instanceof FeatureModel) {
				fm = (FeatureModel) object;
			}
		}
		return fm;
	}

}
