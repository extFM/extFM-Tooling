package org.js.model.workflow.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.js.model.feature.Attribute;
import org.js.model.feature.Constraint;
import org.js.model.feature.Expression;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.FeatureReference;
import org.js.model.feature.ImpliesExpression;
import org.js.model.feature.ReferenceResolverUtil;
import org.js.model.feature.SelectedState;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.AttributeDecision;
import org.js.model.rbac.ConfigurationDecision;
import org.js.model.rbac.DeselectDomainValue;
import org.js.model.rbac.DeselectFeature;
import org.js.model.rbac.FeatureDecision;
import org.js.model.rbac.Permission;
import org.js.model.rbac.RBACService;
import org.js.model.rbac.Role;
import org.js.model.rbac.SelectDomainValue;
import org.js.model.rbac.SelectFeature;
import org.js.model.rbac.SetAttribute;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.EFMContainer;
import org.js.model.workflow.Log;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.js.model.workflow.util.WorkflowUtil;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.RowData;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class StakeholderConfigUIShell extends Shell {

	ArrayList<Group> configGroups = new ArrayList<Group>();
	HashMap<Button, ConfigurationDecision> decisionMap = new HashMap<Button, ConfigurationDecision>();
	HashMap<Group, Feature> featureMap = new HashMap<Group, Feature>();
	Action selectedAction = null;
	Role selectedRole = null;
	State selectedState = null;
	FeatureModel featureModel = null;
	Log log = null;
	Set<Permission> permissions = null;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	// public static void main(String args[]) {
	// try {
	// Display display = Display.getDefault();
	// StakeholderConfigUIShell shell = new StakeholderConfigUIShell(
	// display);
	// shell.open();
	// shell.layout();
	// while (!shell.isDisposed()) {
	// if (!display.readAndDispatch()) {
	// display.sleep();
	// }
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * Create the shell.
	 * 
	 * @param display
	 */
	public StakeholderConfigUIShell(Model workflowModel, Display display,
			Role role, Action action, State state) {
		super(display, SWT.SHELL_TRIM);
		selectedAction = action;
		selectedRole = role;
		selectedState = state;
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		Composite composite_config = new Composite(composite, SWT.NONE);
		RowLayout rl_composite_config = new RowLayout(SWT.VERTICAL);
		rl_composite_config.fill = true;
		composite_config.setLayout(rl_composite_config);
		composite_config.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));

		Composite composite_buttons = new Composite(composite, SWT.NONE);
		composite_buttons.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		composite_buttons.setLayout(new RowLayout(SWT.HORIZONTAL));

		Button button_ok = new Button(composite_buttons, SWT.NONE);
		button_ok.setText("Ok");

		Button button_cancel = new Button(composite_buttons, SWT.NONE);
		button_cancel.setText("Cancel");

		if (state.getState().getValue() == 1) {
			state.setState(StateEnum.RUNNING);
			WorkflowModelUtil.setActionState(action, StateEnum.RUNNING);
			// trace the previous efm
			featureModel = tracePreEFM(workflowModel, role, action);
		}

		// TODO: check bugs
		// create configuration groups
		// EList<Permission> permissions = role.getPermissions();
		RBACService rbacService = new RBACService();
		permissions = rbacService.getAllRolePermissions(role);
		log = (Log) WorkflowConfUtil.getAspectInstance(action,
				WorkflowConfUtil.LOG_ASPECT);

		for (Permission permission : permissions) {
			// Iterator<Permission> it = permissions.iterator();
			// while (it.hasNext()) {
			// Permission permission = it.next();
			if (permission instanceof FeatureDecision) {
				Feature feature = ((FeatureDecision) permission).getFeature();
				String featureName = feature.getId();
				String groupName = featureName;

				// get the configuration group
				Group configGroup = null;
				for (Group group : configGroups) {
					if (group.getText().equals(groupName)) {
						configGroup = group;
						break;
					}
				}
				if (configGroup == null) {
					configGroup = new Group(composite_config, SWT.NONE);
					configGroup.setText(groupName);
					configGroup.setLayout(new FillLayout(SWT.HORIZONTAL));
					configGroups.add(configGroup);
					featureMap.put(configGroup, feature);
				}
				// add radio button
				Button radioButton = new Button(configGroup, SWT.RADIO);
				if (permission instanceof SelectFeature) {
					radioButton.setText("select feature");
				} else if (permission instanceof DeselectFeature) {
					radioButton.setText("deselect feature");
				}
				// if configuration action is running, check whether the feature
				// is configured by the previous role
				if (selectedState.getState().getValue() == 2) {
					Feature configuredFeature = ReferenceResolverUtil
							.findFeature(featureName, featureModel);

					switch (configuredFeature.getSelected().getValue()) {
					case 0:
						break;
					case 1:
						radioButton.setEnabled(false);
						if (permission instanceof SelectFeature) {
							radioButton.setSelection(true);
						}
						break;
					case 2:
						radioButton.setEnabled(false);
						if (permission instanceof DeselectFeature) {
							radioButton.setSelection(true);
						}
						break;
					}
				}
				// if configuration action is finished, button is inactive
				if (selectedState.getState().getValue() == 3) {
					radioButton.setEnabled(false);
					if (log.getConfigurationDecisions().contains(permission)) {
						radioButton.setSelection(true);
					}
				}
				decisionMap
						.put(radioButton, (ConfigurationDecision) permission);
			} else if (permission instanceof SetAttribute) {
				String featureName = ((SetAttribute) permission).getFeature()
						.getId();
				String attributeName = ((SetAttribute) permission)
						.getAttribute().getName();
				String groupName = featureName + ": " + attributeName;
				// get the configuration group
				Group configGroup = null;
				for (Group group : configGroups) {
					if (group.getText().equals(groupName)) {
						configGroup = group;
						break;
					}
				}
				if (configGroup == null) {
					configGroup = new Group(composite_config, SWT.NONE);
					configGroup.setText(groupName);
					configGroup.setLayout(new FillLayout(SWT.HORIZONTAL));
					configGroups.add(configGroup);
				}

				// get the attribute
				Attribute attribute = ReferenceResolverUtil.resolveAttribute(
						((SetAttribute) permission).getAttribute().getName(),
						featureModel);
				for (AttributeDecision attributeDec : ((SetAttribute) permission)
						.getAttributeDecisions()) {
					Button radioButton = new Button(configGroup, SWT.RADIO);
					if (attributeDec instanceof SelectDomainValue) {
						radioButton
								.setText("select " + attributeDec.getValue());
					} else if (attributeDec instanceof DeselectDomainValue) {
						radioButton.setText("deselect "
								+ attributeDec.getValue());
					}
					// if configuration action is running, check whether the
					// attribute is configured
					if (selectedState.getState().getValue() == 2) {
						if (attribute.getValue() == null
								|| attribute.getValue().equals("")) {
						} else {
							radioButton.setEnabled(false);
							if (attributeDec instanceof SelectDomainValue
									&& attributeDec.getValue().equals(
											attribute.getValue())) {
								radioButton.setSelection(true);
							}
						}
					}
					// configuration action is finished
					if (selectedState.getState().getValue() == 3) {
						radioButton.setEnabled(false);
						if (log.getConfigurationDecisions().contains(
								attributeDec)) {
							radioButton.setSelection(true);
						}
					}
					decisionMap.put(radioButton,
							(ConfigurationDecision) attributeDec);
				}
			}
		}

		// add listeners for buttons
		for (Group group : configGroups) {
			for (Control button : group.getChildren()) {
				((Button) button).addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						handleSelectionLogic((Button) e.getSource(),
								decisionMap, permissions, featureModel);
					}
				});
			}
		}

		// add listeners
		button_ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// check whether all decisions are completed
				String info = "Please finish the selection: ";
				String temp = "";
				boolean allSelected = true;
				for (Group group : configGroups) {
					boolean groupSelected = false;
					// if the group is about attribute
					if (group.getText().contains(":")) {
						for (Control control : group.getChildren()) {
							ConfigurationDecision configDecision = decisionMap
									.get(control);
							if (configDecision instanceof SelectDomainValue) {
								groupSelected = ((Button) control)
										.getSelection() || groupSelected;
							}
						}
					} else {
						for (Control control : group.getChildren()) {
							groupSelected = ((Button) control).getSelection()
									|| groupSelected;
						}

					}
					if (!groupSelected) {
						temp += group.getText();
						if (group.getText().contains(":")) {
							temp += " (should select one value!)";
						}
						temp += ", ";
					}
					allSelected = groupSelected && allSelected;
				}
				if (!allSelected) {
					info += temp;
					MessageDialog.openInformation(getShell(), "Warning", info);
				} else {
					if (selectedState.getState().getValue() == 2) {
						saveConfigLog(configGroups, selectedRole,
								selectedAction);
						WorkflowUtil.handleFM(log, featureModel);
						WorkflowModelUtil.setActionState(selectedAction,
								StateEnum.COMPLETED);
					}
					dispose();
				}
			}
		});

		button_cancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (selectedState.getState().getValue() == 2) {
					selectedState.setState(StateEnum.ENABLED);
				}
				dispose();
			}
		});

		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Configuration");
		int length = configGroups.size() * 40 + 100;
		int width = 0;
		for (Group group : configGroups) {
			int tempLength = group.getChildren().length;
			if (width < tempLength) {
				width = tempLength;
			}
		}
		width = width * 140;
		setSize(width, length);
	}

	public void saveConfigLog(ArrayList<Group> configGroup, Role role,
			Action action) {
		Log log = (Log) WorkflowConfUtil.getAspectInstance(action,
				WorkflowConfUtil.LOG_ASPECT);
		log.getConfigurationDecisions().clear();
		for (Group group : configGroup) {
			for (Control control : group.getChildren()) {
				if (((Button) control).getSelection()) {
					log.getConfigurationDecisions().add(
							decisionMap.get(control));
				}
			}
		}
	}

	/**
	 * trace the configured efm of the previous action
	 * 
	 * @param workflowModel
	 * @param role
	 * @param action
	 * @return feature model
	 */
	public FeatureModel tracePreEFM(Model workflowModel, Role role,
			Action action) {
		Action preAction = WorkflowModelUtil.getPrecedeAction(action);
		FeatureModel oldFM = null;
		if (preAction == null) { // it is the first enabled action
			// get original efm
			ACMConnector acmConnector = (ACMConnector) WorkflowConfUtil
					.getAspectInstance(workflowModel,
							WorkflowConfUtil.ACM_ASPECT);
			AccessControlModel acm = acmConnector.getAcmref();
			oldFM = acm.getFeatureModels().get(0);
		} else {
			// get the efm of previous action
			EFMContainer efmContainer = (EFMContainer) WorkflowConfUtil
					.getAspectInstance(preAction, WorkflowConfUtil.EFM_ASPECT);
			oldFM = efmContainer.getEfmref();
		}
		// copy efm file for the added action
		URI oldFMUri = oldFM.eResource().getURI();
		String oldFileName = oldFMUri.lastSegment();
		URI resolvedFile = CommonPlugin.resolve(oldFMUri);
		IFile oldFile = ResourcesPlugin.getWorkspace().getRoot()
				.getFile(new Path(resolvedFile.toFileString()));
		String oldFilePath = oldFile.getFullPath().toString();
		String newFileName = role.getId() + "." + oldFMUri.fileExtension();
		String newFilePath = oldFilePath.replace(oldFileName, newFileName);
		File newFile = WorkflowUtil.copyFile(oldFilePath, newFilePath);

		// get the uri of the added file
		URI newFileUri = WorkflowUtil.getURI(newFile);

		// add efm reference
		FeatureModel newFM = WorkflowUtil.getFMMModel(newFileUri);
		EFMContainer efmContainer = (EFMContainer) WorkflowConfUtil
				.getAspectInstance(action, WorkflowConfUtil.EFM_ASPECT);
		if (newFM == null) {
			System.out.println("the previuos action has no efm!");
		} else {
			WorkflowConfUtil.setEFM(efmContainer, newFM);
		}

		return newFM;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public State getState() {
		return selectedState;
	}

	public void handleSelectionLogic(Button button,
			HashMap<Button, ConfigurationDecision> decisionMap,
			Set<Permission> permissions, FeatureModel featureModel) {
		if (button.getSelection()) {
			ConfigurationDecision configDecision = decisionMap.get(button);
			if (configDecision instanceof FeatureDecision) {
				Feature configuredFeature = ((FeatureDecision) configDecision)
						.getFeature();
				ArrayList<Feature> mandatoryChildFeatures = WorkflowUtil
						.getMandatoryChildFeatures(configuredFeature);
				ArrayList<Feature> parentFeaures = WorkflowUtil
						.getParentFeatures(configuredFeature, featureModel);
				ArrayList<Feature> groupFeatures = WorkflowUtil
						.getGroupFeatures(configuredFeature, featureModel);
				ArrayList<Feature> constraintRightOperands = WorkflowUtil
						.getImpliesConstraintRightOperands(configuredFeature,
								featureModel);
				ArrayList<Feature> constraintLeftOperands = WorkflowUtil
						.getImpliesConstraintLeftOperands(configuredFeature,
								featureModel);
				ArrayList<Feature> childFeatures = WorkflowUtil
						.getChildFeatures(configuredFeature);
				if (configDecision instanceof SelectFeature) {
					for (Group group : featureMap.keySet()) {
						Feature feature = featureMap.get(group);
						org.js.model.feature.Group featureGroup = WorkflowUtil
								.getGroup(feature, featureModel);
						// 1. set all mandatory sub features into selected
						// 2. set parent feature into selected
						// 3. set features of related constraints into selected
						if (mandatoryChildFeatures.contains(feature)
								|| parentFeaures.contains(feature)
								|| constraintRightOperands.contains(feature)) {
							for (Control control : group.getChildren()) {
								if (decisionMap.get(control) instanceof SelectFeature) {
									((Button) control).setSelection(true);
								}
							}
						}
						// 4. set the selected status of the other features in
						// the same group
						else if (WorkflowUtil.getGroupType(featureGroup) == WorkflowUtil.ALTERNATIVE_GROUP
								&& groupFeatures.contains(feature)) {
							for (Control control : group.getChildren()) {
								if (decisionMap.get(control) instanceof SelectFeature) {
									((Button) control).setSelection(false);
								}
							}
						}
					}
				} else if (configDecision instanceof DeselectFeature) {
					for (Group group : featureMap.keySet()) {
						Feature feature = featureMap.get(group);
						// 1. set all sub features into deselected
						// 2. set the selected status of the other features in
						// the same group
						if (childFeatures.contains(feature)
								|| constraintLeftOperands.contains(feature)) {
							for (Control control : group.getChildren()) {
								if (decisionMap.get(control) instanceof DeselectFeature) {
									((Button) control).setSelection(false);
								}
							}
						} else if (groupFeatures.contains(feature)) {
							// TODO: maybe there is better to check the group
							// conditions
						}
					}
				}
			} else if (configDecision instanceof AttributeDecision) {
				// TODO:
			}
		}
	}
}
