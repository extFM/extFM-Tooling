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

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class StakeholderConfigUIShell extends Shell {

	ArrayList<Group> configGroups = new ArrayList<Group>();
	HashMap<Button, ConfigurationDecision> decisionMap = new HashMap<Button, ConfigurationDecision>();
	HashMap<Group, Feature> featureMap = new HashMap<Group, Feature>();
	HashMap<Group, Attribute> attributeMap = new HashMap<Group, Attribute>();
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
			featureModel = WorkflowUtil
					.tracePreEFM(workflowModel, role, action);
		} else {
			EFMContainer efmContainer = (EFMContainer) WorkflowConfUtil
					.getAspectInstance(action, WorkflowConfUtil.EFM_ASPECT);
			featureModel = efmContainer.getEfmref();
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
				// feature in the original efm
				Feature oldFeature = ((FeatureDecision) permission)
						.getFeature();
				String featureName = oldFeature.getId();
				String groupName = featureName;
				// feature in the new efm
				Feature configuredFeature = ReferenceResolverUtil.findFeature(
						featureName, featureModel);
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
					featureMap.put(configGroup, configuredFeature);
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
				Feature oldFeature = ((SetAttribute) permission).getFeature();
				String featureName = oldFeature.getId();
				Feature newFeature = ReferenceResolverUtil.findFeature(
						featureName, featureModel);
				Attribute oldAttribute = ((SetAttribute) permission)
						.getAttribute();
				String attributeName = oldAttribute.getName();
				String groupName = featureName + ": " + attributeName;
				// get the attribute
				Attribute configuredAttribute = ReferenceResolverUtil
						.findAttributeForFeature(attributeName, newFeature);
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
					attributeMap.put(configGroup, configuredAttribute);
				}

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
						if (configuredAttribute.getValue() == null
								|| configuredAttribute.getValue().equals("")) {
						} else {
							radioButton.setEnabled(false);
							if (attributeDec instanceof SelectDomainValue
									&& attributeDec.getValue().equals(
											configuredAttribute.getValue())) {
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
				// ((Button) button).addFocusListener(new FocusListener() {
				// @Override
				// public void focusLost(FocusEvent e) {
				// }
				// @Override
				// public void focusGained(FocusEvent e) {
				// handleSelectionLogic((Button) e.getSource(),
				// decisionMap, permissions, featureModel);
				// }
				// });
			}
		}
		// TODO: check the feature in a group (optional group!)
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
				Feature oldFeature = ((FeatureDecision) configDecision)
						.getFeature();
				Feature configuredFeature = ReferenceResolverUtil.findFeature(
						oldFeature.getId(), featureModel);
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
								} else {
									((Button) control).setSelection(false);
								}
							}
						}
						// 4. set the selected status of the other features in
						// the same group
						else if (featureGroup != null
								&& WorkflowUtil.getGroupType(featureGroup) == WorkflowUtil.ALTERNATIVE_GROUP
								&& feature != configuredFeature
								&& groupFeatures.contains(feature)) {
							for (Control control : group.getChildren()) {
								if (decisionMap.get(control) instanceof SelectFeature) {
									((Button) control).setSelection(false);
								} else {
									((Button) control).setSelection(true);
								}
							}
						}
					}
				} else if (configDecision instanceof DeselectFeature) {
					Feature parentFeature = WorkflowUtil.getParentFeature(
							configuredFeature, featureModel.getRoot());
					org.js.model.feature.Group featureGroup = WorkflowUtil
							.getGroup(configuredFeature, featureModel);
					for (Group group : featureMap.keySet()) {
						Feature feature = featureMap.get(group);
						// 1. set all sub features into deselected
						// 2. related attributes are deselected
						if (childFeatures.contains(feature)
								|| constraintLeftOperands.contains(feature)) {
							for (Control control : group.getChildren()) {
								if (decisionMap.get(control) instanceof SelectFeature) {
									((Button) control).setSelection(false);
								} else {
									((Button) control).setSelection(true);
								}
							}
						}
						// 3. if it is mandatory feature and its parent feature
						// can not be deselected
						if (feature == parentFeature
								&& WorkflowUtil.getGroupType(featureGroup) == WorkflowUtil.MANDATORY_GROUP) {
							for (Control control : group.getChildren()) {
								if (decisionMap.get(control) instanceof SelectFeature) {
									((Button) control).setSelection(false);
								}
							}
						}
						// 4. set the selected status of the other features in
						// the same group
						if (WorkflowUtil.getGroupType(featureGroup) == WorkflowUtil.OR_GROUP
								|| WorkflowUtil.getGroupType(featureGroup) == WorkflowUtil.ALTERNATIVE_GROUP) {
							if (feature != configuredFeature
									&& groupFeatures.contains(feature)) {

							}
						}
					}
				}
			} else if (configDecision instanceof SetAttribute) {
				// related feature is selected
				Feature oldFeature = ((SetAttribute) configDecision)
						.getFeature();

			}
		}
	}
}
