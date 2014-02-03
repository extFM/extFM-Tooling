/**
 * 
 */
package org.js.model.adaptation.ui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.feature.model.utilities.WorkbenchUtil;
import org.js.graph.transform.stagemodel.Stage;
import org.js.graph.transform.stagemodel.StageModel;
import org.js.graph.transform.stagemodel.StageModelLabelProvider;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.Role;
import org.js.model.rbac.edit.RBACLabelProvider;
import org.js.model.workflow.util.AccessControlModelUtil;
import org.js.model.workflow.util.StageModelUtil;
import org.js.model.workflow.util.WorkflowUtil;

/**
 * @author Julia
 * 
 */
public class AddRoleDialog extends MessageDialog {

   private Text stakeholderName;
   private Text stakeholderId;
   // private Combo stakeholderTypeCombo;
   // private Combo stakeholderGroupCombo;
   private AccessControlModel accessControlModel;
   private StageModel stageModel;
   private UserInputAddRole roleInput;
   private ComboViewer stakeholderType;
   private Label msg;
   private ComboViewer stakeholderGroup;

   public AddRoleDialog() {
      super(WorkbenchUtil.getShell(), "Add Stakeholder", null, "Add a Stakeholder", MessageDialog.CONFIRM, new String[] {
            "Ok", "Cancel" }, 0);
   }

   @Override
   protected Control createCustomArea(Composite parent) {

      Composite composite = parent;

      Label dummy = new Label(composite, SWT.NONE);
      dummy.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
      msg = new Label(composite, SWT.NONE);
      msg.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
      Display display = getShell().getDisplay();
      msg.setForeground(new Color(display, 250, 0, 0));
      msg.setText("");

      Label lblNewLabel = new Label(composite, SWT.NONE);
      lblNewLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
      lblNewLabel.setText("Name");

      stakeholderName = new Text(composite, SWT.BORDER);
      stakeholderName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

      Label lblIdLabel = new Label(composite, SWT.NONE);
      lblIdLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
      lblIdLabel.setText("Id");

      stakeholderId = new Text(composite, SWT.BORDER);
      stakeholderId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

      Label lblNewLabel_1 = new Label(composite, SWT.NONE);
      lblNewLabel_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
      lblNewLabel_1.setText("Stage");

      stakeholderType = new ComboViewer(composite, SWT.READ_ONLY);
      stakeholderType.setLabelProvider(new StageModelLabelProvider());
      stakeholderType.setContentProvider(new DialogContentProvider());
      stakeholderType.addFilter(new StageInputFilter(accessControlModel));
      Combo stakeholderTypeCombo = stakeholderType.getCombo();
      stakeholderTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      stakeholderType.setInput(stageModel);

      Label stakeholerGroupComboLabel = new Label(composite, SWT.NONE);
      stakeholerGroupComboLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
      stakeholerGroupComboLabel.setText("Role Owner");

      stakeholderGroup = new ComboViewer(composite, SWT.READ_ONLY);
      stakeholderGroup.setLabelProvider(new RBACLabelProvider());
      stakeholderGroup.setContentProvider(new DialogContentProvider());
      Combo stakeholderGroupCombo = stakeholderGroup.getCombo();
      stakeholderGroupCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      stakeholderGroup.setInput(new RoleInput());

      // stakeholderGroupCombo = new Combo(composite, SWT.READ_ONLY);
      // stakeholderGroupCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      // new Label(composite, SWT.NONE);
      //
      // Composite composite_1 = new Composite(composite, SWT.NONE);
      // composite_1.setLayout(new RowLayout(SWT.HORIZONTAL));
      // composite_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));

      addComboSelectionListener();

      return composite;
   }

   private void addComboSelectionListener() {
      stakeholderName.addModifyListener(new ModifyListener() {

         @Override
         public void modifyText(ModifyEvent e) {
            String name = stakeholderName.getText();
            roleInput.setRoleName(name);
            validateInput();
         }
      });

      stakeholderId.addModifyListener(new ModifyListener() {

         @Override
         public void modifyText(ModifyEvent e) {
            String id = stakeholderId.getText();
            roleInput.setRoleId(id);
            validateInput();
         }
      });

      stakeholderType.addSelectionChangedListener(new ISelectionChangedListener() {

         @Override
         public void selectionChanged(SelectionChangedEvent event) {
            ISelection selection = event.getSelection();
            if (selection instanceof StructuredSelection) {
               StructuredSelection structSelection = (StructuredSelection) selection;
               Object element = structSelection.getFirstElement();
               if (element instanceof Stage) {
                  Stage stage = (Stage) element;
                  Role abstractParentRole = AccessControlModelUtil.getCorrespondingAbstractRole(stage, accessControlModel);
                  roleInput.setAbstractParentRole(abstractParentRole);
               }
            }
            setOwnerInput();
            validateInput();
         }
      });

      stakeholderGroup.addSelectionChangedListener(new ISelectionChangedListener() {

         @Override
         public void selectionChanged(SelectionChangedEvent event) {
            ISelection selection = event.getSelection();
            if (selection instanceof StructuredSelection) {
               StructuredSelection structSelection = (StructuredSelection) selection;
               Object element = structSelection.getFirstElement();
               if (element instanceof Role) {
                  Role stakeholder = (Role) element;
                  roleInput.setGroupOwner(stakeholder);
               }
            }
            validateInput();
         }
      });

   }

   private void validateInput() {
      String roleId = roleInput.getRoleId();
      Role owner = roleInput.getGroupOwner();
      Role abstractRole = roleInput.getAbstractParentRole();

      String message = validateRoleId(roleId);
      if (message.isEmpty()) {
         message = validateAbstractRole(abstractRole);
      }
      if (message.isEmpty()) {
         message = validateOwnerRole(owner, abstractRole);
      }
      msg.setText(message);
      msg.pack();
      setOkButtonEnabled();
   }

   private String validateOwnerRole(Role owner, Role abstractRole) {
      String message = "";
      if (owner == null) {
         Stage stage = StageModelUtil.getStageForId(abstractRole.getId(), stageModel);
         if (!StageModelUtil.isFirstStage(stage)) {
            message = "Specify role owner";
         }
      }
      return message;
   }

   private String validateAbstractRole(Role abstractRole) {
      String message = "";
      if (abstractRole == null) {
         message = "Select a stage.";
      }
      return message;
   }

   private String validateRoleId(String roleId) {
      String message = "";
      // role Id must not be null or empty
      if (roleId != null && !roleId.isEmpty()) {
         // role Id must not contain whitespace
         for (char c : roleId.toCharArray()) {
            if (c == ' ') {
               message = "Role id must not contain whitespace.";
               break;
            }
         }
         if (message.isEmpty()) {
            // role Id must be unique
            EList<Role> roles = accessControlModel.getRoles();
            for (Role role : roles) {
               String existingRoleId = role.getId();
               if (existingRoleId.equals(roleId)) {
                  message = "Role id is already used.";
                  break;
               }
            }
         }
      } else {
         message = "Specify role id.";
      }
      return message;
   }

   private void setOkButtonEnabled() {
      boolean enabled = msg.getText() == "";
      Button okButton = getButton(IDialogConstants.OK_ID);
      okButton.setEnabled(enabled);
   }

   public void setWorkflow(Model workflowModel) {
      accessControlModel = WorkflowUtil.getAccessControlModel(workflowModel);
      stageModel = WorkflowUtil.getStageModel(workflowModel);
   }

   public void setUserInput(UserInputAddRole roleInput) {
      this.roleInput = roleInput;
   }

   private void setOwnerInput() {
      RoleInput input = new RoleInput();

      // find group owners that belong to the predecessor stage
      Role abstractRole = roleInput.getAbstractParentRole();
      if (abstractRole != null) {
         Stage stage = StageModelUtil.getStageForId(abstractRole.getId(), stageModel);
         Stage predecessor = stage.getPredecessor();
         if (predecessor != null) {
            Role parentRole = AccessControlModelUtil.getCorrespondingAbstractRole(predecessor, accessControlModel);
            EList<Group> groups = accessControlModel.getGroups();
            for (Group group : groups) {
               Role owner = group.getOwner();
               EList<Role> parentOwnerRoles = owner.getParentRoles();
               if (parentOwnerRoles.contains(parentRole)) {
                  input.addRole(owner);
               }
            }
         }
      }
      stakeholderGroup.setInput(input);
      roleInput.setGroupOwner(null);
   }

}
