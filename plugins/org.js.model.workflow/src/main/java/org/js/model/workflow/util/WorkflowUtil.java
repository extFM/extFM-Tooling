package org.js.model.workflow.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
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
import org.js.model.feature.Attribute;
import org.js.model.feature.Constraint;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.FeatureReference;
import org.js.model.feature.ImpliesExpression;
import org.js.model.feature.ReferenceResolverUtil;
import org.js.model.feature.SelectedState;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.ConfigurationDecision;
import org.js.model.rbac.FeatureDecision;
import org.js.model.rbac.Group;
import org.js.model.rbac.SelectDomainValue;
import org.js.model.rbac.SelectFeature;
import org.js.model.rbac.SetAttribute;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.Log;
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

	public static final int MANDATORY_GROUP = 1;
	public static final int OPTINAL_GROUP = 2;
	public static final int ALTERNATIVE_GROUP = 3;
	public static final int OR_GROUP = 4;

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
	 * 
	 * @param file
	 * @return
	 */
	public static URI getURI(File file) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IPath location = Path.fromOSString(file.getAbsolutePath());
		IFile newFile = workspace.getRoot().getFileForLocation(location);
		URI newFileUri = URI.createPlatformResourceURI(newFile.getFullPath()
				.toOSString(), true);
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

	/**
	 * handle the relation and constraint of the given feature in the efm.
	 * 
	 * @param feauture
	 * @param featureModel
	 */
	public static void handleFeatureLogic(Feature feature,
			FeatureModel featureModel) {
		// if the feature is selected
		if (feature.getSelected().equals(SelectedState.SELECTED)) {
			for (org.js.model.feature.Group group : feature.getGroups()) {
				// if feature is mandatory
				if (group.getMinCardinality() * group.getMaxCardinality() == 1) {
					if (group.getChildFeatures().size() == 1) {
						Feature subFeature = group.getChildFeatures().get(0);
						subFeature.setSelected(SelectedState.SELECTED);
						handleFeatureLogic(subFeature, featureModel);
					}
				}
			}
			for (Constraint constraint : featureModel.getConstraints()) {
				// TODO: here only implies express is handled, we still need to
				// handle the other expresses
				if (constraint.getExpression() instanceof ImpliesExpression) {
					ImpliesExpression expression = (ImpliesExpression) constraint
							.getExpression();
					if (expression.getOperand1() instanceof FeatureReference) {
						Feature operand1 = ((FeatureReference) expression
								.getOperand1()).getFeature();
						if (operand1.getId().equals(feature.getId())) {
							Feature operand2 = ((FeatureReference) expression
									.getOperand2()).getFeature();
							operand2.setSelected(SelectedState.SELECTED);
							handleFeatureLogic(operand2, featureModel);
						}
					}
				}
			}
		} else {
			// if the feature is deselected
			for (org.js.model.feature.Group group : feature.getGroups()) {
				for (Feature subFeature : group.getChildFeatures()) {
					subFeature.setSelected(SelectedState.DESELECTED);
					handleFeatureLogic(subFeature, featureModel);
				}
			}
			for (Constraint contraint : featureModel.getConstraints()) {
				// TODO: here only implies express is handled, we still need to
				// handle the other expresses
				if (contraint.getExpression() instanceof ImpliesExpression) {
					ImpliesExpression expression = (ImpliesExpression) contraint
							.getExpression();
					if (expression.getOperand2() instanceof FeatureReference) {
						Feature operand2 = ((FeatureReference) expression
								.getOperand2()).getFeature();
						if (operand2.getId().equals(feature.getId())) {
							Feature operand1 = ((FeatureReference) expression
									.getOperand1()).getFeature();
							operand1.setSelected(SelectedState.DESELECTED);
							handleFeatureLogic(operand1, featureModel);
						}
					}
				}
			}
		}
	}

	/**
	 * save stakeholder's configuration into the feature model.
	 * 
	 * @param log
	 * @param featureModel
	 */
	public static void handleFM(Log log, FeatureModel featureModel) {
		for (ConfigurationDecision configDecision : log
				.getConfigurationDecisions()) {
			if (configDecision instanceof FeatureDecision) {
				Feature feature = ReferenceResolverUtil
						.findFeature(((FeatureDecision) configDecision)
								.getFeature().getId(), featureModel);
				if (configDecision instanceof SelectFeature) {
					feature.setSelected(SelectedState.SELECTED);
				} else {
					feature.setSelected(SelectedState.DESELECTED);
				}
				handleFeatureLogic(feature, featureModel);
			} else {
				if (configDecision instanceof SelectDomainValue) {
					Attribute attribute = ReferenceResolverUtil
							.resolveAttribute(((SetAttribute) configDecision)
									.getAttribute().getName(), featureModel);
					attribute.setValue(((SelectDomainValue) configDecision)
							.getValue());
				}
			}
			try {
				featureModel.eResource().save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * get the group which contains the given feature.
	 * 
	 * @param feature
	 * @param root
	 * @return
	 */
	public static org.js.model.feature.Group getGroup(Feature feature,
			Feature root) {
		for (org.js.model.feature.Group group : root.getGroups()) {
			if (group.getChildFeatures().contains(feature)) {
				return group;
			} else {
				for (Feature subFeature : group.getChildFeatures()) {
					return getGroup(feature, subFeature);
				}
			}
		}
		return null;
	}

	/**
	 * get the group which contains the given feature.
	 * 
	 * @param feature
	 * @param featureModel
	 * @return
	 */
	public static org.js.model.feature.Group getGroup(Feature feature,
			FeatureModel featureModel) {
		return getGroup(feature, featureModel.getRoot());
	}

	/**
	 * get the group type.
	 * 
	 * @param group
	 * @return
	 */
	public static int getGroupType(org.js.model.feature.Group group) {
		int type = 0;
		int minCard = group.getMinCardinality();
		int maxCard = group.getMaxCardinality();
		int size = group.getChildFeatures().size();

		if (minCard * maxCard == 1) {
			if (size == 1) {
				type = MANDATORY_GROUP;
			} else {
				type = ALTERNATIVE_GROUP;
			}
		} else if (minCard == 0 && maxCard == 1 && size == 1) {
			type = OPTINAL_GROUP;
		} else if (minCard == 1 && maxCard == size && size > 1) {
			type = OR_GROUP;
		}
		return type;
	}

	/**
	 * get the direct parent feature of the given child feature.
	 * 
	 * @param childFeature
	 * @param root
	 * @return
	 */
	public static Feature getParentFeature(Feature childFeature, Feature root) {
		for (org.js.model.feature.Group group : root.getGroups()) {
			for (Feature feature : group.getChildFeatures()) {
				if (feature == childFeature) {
					return root;
				} else {
					return getParentFeature(childFeature, feature);
				}
			}
		}
		return null;
	}

	/**
	 * get all parent features of the given feature.
	 * 
	 * @param childFeature
	 * @param featureModel
	 * @return
	 */
	public static ArrayList<Feature> getParentFeatures(Feature childFeature,
			FeatureModel featureModel) {
		ArrayList<Feature> parentFeatures = new ArrayList<Feature>();
		Feature parentFeature = getParentFeature(childFeature,
				featureModel.getRoot());
		while (parentFeature != null) {
			parentFeatures.add(parentFeature);
			parentFeature = getParentFeature(parentFeature,
					featureModel.getRoot());
		}
		return parentFeatures;
	}

	/**
	 * get all mandatory features of the given feature.
	 * 
	 * @param childFeature
	 * @return
	 */
	public static ArrayList<Feature> getMandatoryChildFeatures(
			Feature childFeature) {
		ArrayList<Feature> mandarotyChildFeatures = new ArrayList<Feature>();
		for (org.js.model.feature.Group group : childFeature.getGroups()) {
			if (WorkflowUtil.getGroupType(group) == WorkflowUtil.MANDATORY_GROUP) {
				for (Feature feature : group.getChildFeatures()) {
					mandarotyChildFeatures.add(feature);
					mandarotyChildFeatures
							.addAll(getMandatoryChildFeatures(feature));
				}
			}
		}
		return mandarotyChildFeatures;
	}

	/**
	 * get all child features of the given feature.
	 * @param childFeature
	 * @return
	 */
	public static ArrayList<Feature> getChildFeatures(Feature childFeature) {
		ArrayList<Feature> childFeatures = new ArrayList<Feature>();
		for (org.js.model.feature.Group group : childFeature.getGroups()) {
			for (Feature feature : group.getChildFeatures()) {
				childFeatures.add(feature);
				childFeatures.addAll(getChildFeatures(feature));
			}
		}
		return childFeatures;
	}

	/**
	 * get all features that are in the same group.
	 * 
	 * @param feature
	 * @param featureModel
	 * @return
	 */
	public static ArrayList<Feature> getGroupFeatures(Feature feature,
			FeatureModel featureModel) {
		ArrayList<Feature> groupFeatures = new ArrayList<Feature>();
		org.js.model.feature.Group group = getGroup(feature,
				featureModel.getRoot());
		groupFeatures.addAll(group.getChildFeatures());
		return groupFeatures;
	}
	
	/**
	 * get all right operands which are included in the implies constraints. 
	 * @param feature
	 * @param featureModel
	 * @return
	 */
	public static ArrayList<Feature> getImpliesConstraintRightOperands(Feature feature,
			FeatureModel featureModel){
		ArrayList<Feature> constraintFeatures = new ArrayList<Feature>();
		EList<Constraint> constraints = featureModel.getConstraints();
		
		for(Constraint constraint:constraints){
			if (constraint.getExpression() instanceof ImpliesExpression) {
				ImpliesExpression expression = (ImpliesExpression) constraint
						.getExpression();
				if (expression.getOperand1() instanceof FeatureReference) {
					Feature operand1 = ((FeatureReference) expression
							.getOperand1()).getFeature();
					if (operand1.getId().equals(feature.getId())) {
						Feature operand2 = ((FeatureReference) expression
								.getOperand2()).getFeature();
						constraintFeatures.add(operand2);
					}
				}
			}
		}
		return constraintFeatures;
	}
	
	/**
	 * get all left operands which are included in the implies constraints. 
	 * @param feature
	 * @param featureModel
	 * @return
	 */
	public static ArrayList<Feature> getImpliesConstraintLeftOperands(Feature feature,
			FeatureModel featureModel){
		ArrayList<Feature> constraintFeatures = new ArrayList<Feature>();
		EList<Constraint> constraints = featureModel.getConstraints();
		
		for(Constraint constraint:constraints){
			if (constraint.getExpression() instanceof ImpliesExpression) {
				ImpliesExpression expression = (ImpliesExpression) constraint
						.getExpression();
				if (expression.getOperand2() instanceof FeatureReference) {
					Feature operand2 = ((FeatureReference) expression
							.getOperand2()).getFeature();
					if (operand2.getId().equals(feature.getId())) {
						Feature operand1 = ((FeatureReference) expression
								.getOperand1()).getFeature();
						constraintFeatures.add(operand1);
					}
				}
			}
		}
		return constraintFeatures;
	}
}
