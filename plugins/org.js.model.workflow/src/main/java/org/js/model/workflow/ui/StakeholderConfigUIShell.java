package org.js.model.workflow.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.js.model.feature.Attribute;
import org.js.model.feature.DiscreteDomain;
import org.js.model.feature.Domain;
import org.js.model.feature.DomainValue;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.FeatureState;
import org.js.model.feature.ReferenceResolverUtil;
import org.js.model.feature.csp.FeatureModelAnalyzer;
import org.js.model.feature.edit.FeatureLabelProvider;
import org.js.model.rbac.AttributeOperation;
import org.js.model.rbac.ConfigurationOperation;
import org.js.model.rbac.FeatureOperation;
import org.js.model.rbac.Permission;
import org.js.model.rbac.RBACService;
import org.js.model.rbac.RbacHelper;
import org.js.model.rbac.Role;
import org.js.model.workflow.EFMContainer;
import org.js.model.workflow.Log;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.js.model.workflow.util.WorkflowUtil;

public class StakeholderConfigUIShell extends Shell {

   ArrayList<Group> configGroups = new ArrayList<Group>();
   HashMap<Control, ConfigurationOperation> decisionMap = new HashMap<Control, ConfigurationOperation>();
   HashMap<Group, Feature> featureMap = new HashMap<Group, Feature>();
   HashMap<Group, Attribute> attributeMap = new HashMap<Group, Attribute>();
   Action selectedAction = null;
   Role selectedRole = null;
   State selectedState = null;
   FeatureModel featureModel = null;
   Log log = null;
   Set<Permission> permissions = null;

   Composite composite_config;
   Button button_ok, button_cancel;

   /**
    * Create the shell.
    * 
    * @param display
    */
   public StakeholderConfigUIShell(Model workflowModel, Display display, Role role, Action action, State state) {
      super(display, SWT.SHELL_TRIM);
      selectedAction = action;
      selectedRole = role;
      selectedState = state;
      RBACService rbacService = new RBACService();
      permissions = rbacService.getAllRolePermissions(selectedRole);
      log = (Log) WorkflowConfUtil.getAspectInstance(selectedAction, WorkflowConfUtil.LOG_ASPECT);
      initUI();
      checkSelectionStates(workflowModel);
      createContents();
      setOkButtonEnabled();
   }

   private void handlePermissions() {
      for (Permission permission : permissions) {
         if (permission instanceof FeatureOperation) {
            FeatureOperation operation = (FeatureOperation) permission;
            handleFeatureOperation(operation);
         } else if (permission instanceof AttributeOperation) {
            AttributeOperation operation = (AttributeOperation) permission;
            handleAttributeOperation(operation);

         }
      }
   }

   private void handleFeatureOperation(FeatureOperation operation) {
      // feature in the original efm
      Feature oldFeature = operation.getFeature();
      String featureName = oldFeature.getId();
      String groupName = featureName;
      // feature in the new efm
      Feature configuredFeature = ReferenceResolverUtil.findFeature(featureName, featureModel);
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
      Button radioButton = new Button(configGroup, SWT.CHECK);
      radioButton.setSelection(false);
      if (RbacHelper.isSelectFeatureOperation(operation)) {
         radioButton.setText("select");
      } else if (RbacHelper.isDeselectFeatureOperation(operation)) {
         radioButton.setText("deselect");
      }
      // if configuration action is running, check whether the
      // feature is configured by the previous role
      if (StateEnum.RUNNING.equals(selectedState.getState())) {
         switch (configuredFeature.getConfigurationState().getValue()) {
            case FeatureState.UNBOUND_VALUE:
               break;
            case FeatureState.SELECTED_VALUE:
               radioButton.setEnabled(false);
               if (RbacHelper.isSelectFeatureOperation(operation)) {
                  radioButton.setSelection(true);
               }
               break;
            case FeatureState.DESELECTED_VALUE:
               radioButton.setEnabled(false);
               if (RbacHelper.isDeselectFeatureOperation(operation)) {
                  radioButton.setSelection(true);
               }
               break;
         }

      }
      // if configuration action is finished, button is inactive
      if (StateEnum.COMPLETED.equals(selectedState.getState())) {
         radioButton.setEnabled(false);
         if (log.getConfigurationOperations().contains(operation)) {
            radioButton.setSelection(true);
         }
      }
      decisionMap.put(radioButton, (ConfigurationOperation) operation);
   }

   private void handleAttributeOperation(AttributeOperation operation) {
      Feature oldFeature = operation.getFeature();
      String featureName = oldFeature.getId();
      Feature newFeature = ReferenceResolverUtil.findFeature(featureName, featureModel);
      Attribute oldAttribute = operation.getAttribute();
      String attributeName = oldAttribute.getName();
      String groupName = featureName + ": " + attributeName;
      // get the attribute
      Attribute configuredAttribute = ReferenceResolverUtil.findAttributeForFeature(attributeName, newFeature);
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

      Combo valueCombo = new Combo(configGroup, SWT.READ_ONLY);
      valueCombo.setItems(getAttributeValues(configuredAttribute));
      valueCombo.setBounds(0, 0, 200, 200);

      // for (AttributeValueOperation attributeDec : operation.getValueOperations()) {
      // Button radioButton = new Button(configGroup, SWT.RADIO);
      // if (RbacHelper.isSelectDomainValueOperation(attributeDec)) {
      // radioButton.setText("select " + attributeDec.getValue());
      // } else if (RbacHelper.isDeselectDomainValueOperation(attributeDec)) {
      // radioButton.setText("deselect " + attributeDec.getValue());
      // }
      // // if configuration action is running, check whether the attribute is configured
      // if (StateEnum.RUNNING.equals(selectedState.getState())) {
      // if (configuredAttribute.getValue() == null || configuredAttribute.getValue().equals("")) {} else {
      // radioButton.setEnabled(false);
      // if (RbacHelper.isSelectDomainValueOperation(attributeDec) &&
      // attributeDec.getValue().equals(configuredAttribute.getValue())) {
      // radioButton.setSelection(true);
      // }
      // }
      // }
      // // configuration action is finished
      // if (StateEnum.COMPLETED.equals(selectedState.getState())) {
      // radioButton.setEnabled(false);
      // if (log.getConfigurationOperations().contains(attributeDec)) {
      // radioButton.setSelection(true);
      // }
      // }
      decisionMap.put(valueCombo, operation);
      // }
   }

   private void checkSelectionStates(Model workflowModel) {
      if (StateEnum.ENABLED.equals(selectedState.getState())) {
         selectedState.setState(StateEnum.RUNNING);
         WorkflowModelUtil.setActionState(selectedAction, StateEnum.RUNNING);
         // trace the previous efm
         featureModel = WorkflowUtil.tracePreEFM(workflowModel, selectedRole, selectedAction);
      } else {
         EFMContainer efmContainer = (EFMContainer) WorkflowConfUtil.getAspectInstance(selectedAction, WorkflowConfUtil.EFM_ASPECT);
         featureModel = efmContainer.getEfmref();
      }

      // TODO: check bugs
      // create configuration groups
      // EList<Permission> permissions = role.getPermissions();
      if (featureModel != null) {
         handlePermissions();

         // add listeners for buttons
         for (Group group : configGroups) {
            for (Control control : group.getChildren()) {
               SelectionAdapter adapter = new SelectionAdapter() {

                  @Override
                  public void widgetSelected(SelectionEvent e) {
                     handleConfigurationOperation(e);
                     setOkButtonEnabled();
                     // handleSelectionLogic((Button) e.getSource(), decisionMap, permissions, featureModel);
                  }
               };
               if (control instanceof Button) {
                  Button button = (Button) control;
                  button.addSelectionListener(adapter);
               } else if (control instanceof Combo) {
                  Combo combo = (Combo) control;
                  combo.addSelectionListener(adapter);
               }
            }
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
                     // attribute must only be set if feature is selected
                     groupSelected = isAttributeConfigured(control);
                  }
               } else {
                  for (Control control : group.getChildren()) {
                     groupSelected = ((Button) control).getSelection() || groupSelected;
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
                  saveConfigLog(configGroups, selectedRole, selectedAction);
                  WorkflowUtil.handleFM(log, featureModel);
                  WorkflowModelUtil.setActionState(selectedAction, StateEnum.COMPLETED);
               }
               dispose();
            }
         }

         private boolean isAttributeConfigured(Control control) {
            boolean result = false;
            ConfigurationOperation configOp = decisionMap.get(control);
            if (configOp instanceof AttributeOperation) {
               AttributeOperation attOp = (AttributeOperation) configOp;
               String featureid = attOp.getFeature().getId();
               Feature feature = ReferenceResolverUtil.findFeature(featureid, featureModel);
               boolean isFeatureSelected = FeatureState.SELECTED.equals(feature.getConfigurationState());
               String attributeId = attOp.getAttribute().getName();
               Attribute attribute = ReferenceResolverUtil.findAttributeForFeature(attributeId, feature);
               String attributeValue = attribute.getValue();
               boolean isNotEmptyValue = attributeValue != null && !attributeValue.isEmpty();
               result = ((isFeatureSelected && isNotEmptyValue) || !isFeatureSelected);
            }
            return result;
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

   }

   private String[] getAttributeValues(Attribute attribute) {
      List<String> valueList = new ArrayList<String>();
      String empty = "";
      valueList.add(empty);
      FeatureLabelProvider labelProvider = new FeatureLabelProvider();
      Domain domain = attribute.getDomain();
      if (domain instanceof DiscreteDomain) {
         DiscreteDomain discrete = (DiscreteDomain) domain;
         EList<DomainValue> values = discrete.getValues();
         for (DomainValue domainValue : values) {
            String label = labelProvider.getText(domainValue);
            valueList.add(label);
         }
      }

      return (String[]) valueList.toArray(new String[valueList.size()]);
   }

   private void initUI() {
      setLayout(new FillLayout(SWT.HORIZONTAL));

      Composite composite = new Composite(this, SWT.NONE);
      composite.setLayout(new GridLayout(1, false));

      composite_config = new Composite(composite, SWT.NONE);
      RowLayout rl_composite_config = new RowLayout(SWT.VERTICAL);
      rl_composite_config.fill = true;
      composite_config.setLayout(rl_composite_config);
      composite_config.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

      Composite composite_buttons = new Composite(composite, SWT.NONE);
      composite_buttons.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
      composite_buttons.setLayout(new RowLayout(SWT.HORIZONTAL));

      button_ok = new Button(composite_buttons, SWT.NONE);
      button_ok.setText("Ok");

      button_cancel = new Button(composite_buttons, SWT.NONE);
      button_cancel.setText("Cancel");
   }

   private void setOkButtonEnabled() {
      button_ok.setEnabled(isFeatureModelSatisfiable());
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

   public void saveConfigLog(ArrayList<Group> configGroup, Role role, Action action) {
      Log log = (Log) WorkflowConfUtil.getAspectInstance(action, WorkflowConfUtil.LOG_ASPECT);
      log.getConfigurationOperations().clear();
      for (Group group : configGroup) {
         for (Control control : group.getChildren()) {
            if (control instanceof Button) {
               Button button = (Button) control;
               if (button.getSelection()) {
                  log.getConfigurationOperations().add(decisionMap.get(control));
               }
            } else if (control instanceof Combo) {
               Combo combo = (Combo) control;

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

   public void handleConfigurationOperation(SelectionEvent e) {
      Object source = e.getSource();
      if (source instanceof Button) {
         Button button = (Button) source;
         boolean isSelected = button.getSelection();
         ConfigurationOperation configOperation = decisionMap.get(button);
         checkConfigurationOperation(configOperation, isSelected);
         if (isSelected) {
            disableOtherButtonsInFeatureGroup(button);
         }
      } else if (source instanceof Combo) {
         Combo combo = (Combo) source;
         int index = combo.getSelectionIndex();
         String item = combo.getItem(index);
         ConfigurationOperation configOperation = decisionMap.get(combo);
         Attribute configuredAttribute = attributeMap.get(combo.getParent());
         handleAttributeSelection(configuredAttribute, configOperation, item);
      }
   }

   private void handleAttributeSelection(Attribute configuredAttribute, ConfigurationOperation configOperation, String selectedItem) {
      String value = parseAttributeValueName(selectedItem);
      configuredAttribute.setValue(value);
   }

   private String parseAttributeValueName(String selectedItem) {
      String result = "";
      String[] split = selectedItem.split(" ");
      if (split.length >= 1) {
         String name = split[0];
         name.trim();
         result = name;
      }
      return result;
   }

   private void checkConfigurationOperation(ConfigurationOperation op, boolean isSelected) {
      if (op instanceof FeatureOperation) {
         FeatureOperation featureOp = (FeatureOperation) op;
         Feature oldFeature = ((FeatureOperation) featureOp).getFeature();
         Feature configuredFeature = ReferenceResolverUtil.findFeature(oldFeature.getId(), featureModel);
         if (isSelected) {
            if (RbacHelper.isSelectFeatureOperation(featureOp)) {
               selectFeature(configuredFeature);
            } else if (RbacHelper.isDeselectFeatureOperation(featureOp)) {
               deselectFeature(configuredFeature);
            }
         } else {
            // revert operation on feature model
            unboundFeature(configuredFeature);
         }
      }
   }

   private void disableOtherButtonsInFeatureGroup(Button button) {
      Composite parent = button.getParent();
      if (parent instanceof Group) {
         Group group = (Group) parent;
         Control[] children = group.getChildren();
         for (Control control : children) {
            if (control instanceof Button) {
               Button controlButton = (Button) control;
               if (!controlButton.equals(button)) {
                  if (controlButton.isEnabled()) {
                     controlButton.setSelection(false);
                  }
               }
            }
         }
      }
   }

   private boolean isFeatureModelSatisfiable() {
      FeatureModelAnalyzer analyzer = new FeatureModelAnalyzer(featureModel);
      return analyzer.isSatisfiable();
   }

   private void selectFeature(Feature feature) {
      feature.setConfigurationState(FeatureState.SELECTED);
   }

   private void deselectFeature(Feature feature) {
      feature.setConfigurationState(FeatureState.DESELECTED);
   }

   private void unboundFeature(Feature feature) {
      feature.setConfigurationState(FeatureState.UNBOUND);
   }

//   public void handleSelectionLogic(Button button, HashMap<Button, ConfigurationOperation> decisionMap, Set<Permission> permissions,
//                                    FeatureModel featureModel) {
//      if (button.getSelection()) {
//         ConfigurationOperation configDecision = decisionMap.get(button);
//         if (configDecision instanceof FeatureOperation) {
//            Feature oldFeature = ((FeatureOperation) configDecision).getFeature();
//            Feature configuredFeature = ReferenceResolverUtil.findFeature(oldFeature.getId(), featureModel);
//            ArrayList<Feature> mandatoryChildFeatures = WorkflowUtil.getMandatoryChildFeatures(configuredFeature);
//            ArrayList<Feature> parentFeaures = WorkflowUtil.getParentFeatures(configuredFeature, featureModel);
//            ArrayList<Feature> groupFeatures = WorkflowUtil.getGroupFeatures(configuredFeature, featureModel);
//            ArrayList<Feature> constraintRightOperands = WorkflowUtil.getImpliesConstraintRightOperands(configuredFeature, featureModel);
//            ArrayList<Feature> constraintLeftOperands = WorkflowUtil.getImpliesConstraintLeftOperands(configuredFeature, featureModel);
//            ArrayList<Feature> childFeatures = WorkflowUtil.getChildFeatures(configuredFeature);
//            if (RbacHelper.isSelectFeatureOperation(configDecision)) {
//               for (Group group : featureMap.keySet()) {
//                  Feature feature = featureMap.get(group);
//                  org.js.model.feature.Group featureGroup = WorkflowUtil.getGroup(feature, featureModel);
//                  // 1. set all mandatory sub features into selected
//                  // 2. set parent feature into selected
//                  // 3. set features of related constraints into selected
//                  if (mandatoryChildFeatures.contains(feature) || parentFeaures.contains(feature)
//                      || constraintRightOperands.contains(feature)) {
//                     for (Control control : group.getChildren()) {
//                        if (RbacHelper.isSelectFeatureOperation(decisionMap.get(control))) {
//                           ((Button) control).setSelection(true);
//                        } else {
//                           ((Button) control).setSelection(false);
//                        }
//                     }
//                  }
//                  // 4. set the selected status of the other features in
//                  // the same group
//                  else if (featureGroup != null && WorkflowUtil.getGroupType(featureGroup) == WorkflowUtil.ALTERNATIVE_GROUP
//                           && feature != configuredFeature && groupFeatures.contains(feature)) {
//                     for (Control control : group.getChildren()) {
//                        if (RbacHelper.isSelectFeatureOperation(decisionMap.get(control))) {
//                           ((Button) control).setSelection(false);
//                        } else {
//                           ((Button) control).setSelection(true);
//                        }
//                     }
//                  }
//               }
//            } else if (RbacHelper.isDeselectFeatureOperation(configDecision)) {
//               Feature parentFeature = WorkflowUtil.getParentFeature(configuredFeature, featureModel.getRoot());
//               org.js.model.feature.Group featureGroup = WorkflowUtil.getGroup(configuredFeature, featureModel);
//               for (Group group : featureMap.keySet()) {
//                  Feature feature = featureMap.get(group);
//                  // 1. set all sub features into deselected
//                  // 2. related attributes are deselected
//                  if (childFeatures.contains(feature) || constraintLeftOperands.contains(feature)) {
//                     for (Control control : group.getChildren()) {
//                        if (RbacHelper.isSelectFeatureOperation(decisionMap.get(control))) {
//                           ((Button) control).setSelection(false);
//                        } else {
//                           ((Button) control).setSelection(true);
//                        }
//                     }
//                  }
//                  // 3. if it is mandatory feature and its parent feature
//                  // can not be deselected
//                  if (feature == parentFeature && WorkflowUtil.getGroupType(featureGroup) == WorkflowUtil.MANDATORY_GROUP) {
//                     for (Control control : group.getChildren()) {
//                        if (RbacHelper.isSelectFeatureOperation(decisionMap.get(control))) {
//                           ((Button) control).setSelection(false);
//                        }
//                     }
//                  }
//                  // 4. set the selected status of the other features in
//                  // the same group
//                  if (WorkflowUtil.getGroupType(featureGroup) == WorkflowUtil.OR_GROUP
//                      || WorkflowUtil.getGroupType(featureGroup) == WorkflowUtil.ALTERNATIVE_GROUP) {
//                     if (feature != configuredFeature && groupFeatures.contains(feature)) {
//
//                     }
//                  }
//               }
//            }
//         } else if (configDecision instanceof AttributeOperation) {
//            // related feature is selected
//            Feature oldFeature = ((AttributeOperation) configDecision).getFeature();
//
//         }
//      }
//   }
}
