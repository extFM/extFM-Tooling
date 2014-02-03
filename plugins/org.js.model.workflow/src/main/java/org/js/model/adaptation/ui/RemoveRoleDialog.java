package org.js.model.adaptation.ui;

import java.util.Set;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.feature.model.utilities.WorkbenchUtil;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Role;
import org.js.model.rbac.edit.RBACLabelProvider;
import org.js.model.workflow.util.AccessControlModelUtil;

public class RemoveRoleDialog extends MessageDialog {

   private UserInputRemoveRole roleInput;
   private ComboViewer stakeholderGroup;
   private AccessControlModel accessControlModel;

   public RemoveRoleDialog() {
      super(WorkbenchUtil.getShell(), "Remove Stakeholder", null, "Remove a Stakeholder", MessageDialog.CONFIRM, new String[] {
            "Ok", "Cancel" }, 0);
   }

   public void setInput(UserInputRemoveRole roleInput) {
      this.roleInput = roleInput;
   }

   @Override
   protected Control createCustomArea(Composite parent) {

      Label stakeholerGroupComboLabel = new Label(parent, SWT.NONE);
      stakeholerGroupComboLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
      stakeholerGroupComboLabel.setText("Removable Role");

      stakeholderGroup = new ComboViewer(parent);
      stakeholderGroup.setLabelProvider(new RBACLabelProvider());
      stakeholderGroup.setContentProvider(new DialogContentProvider());
      Combo stakeholderGroupCombo = stakeholderGroup.getCombo();
      stakeholderGroupCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
      
      
      RoleInput roleInput = getRoleInput();
      stakeholderGroup.setInput(roleInput);

      addComboSelectionListener();
      return parent;
   }

   private void addComboSelectionListener() {
         stakeholderGroup.addSelectionChangedListener(new ISelectionChangedListener() {
         
         @Override
         public void selectionChanged(SelectionChangedEvent event) {
            ISelection selection = event.getSelection();
            if (selection instanceof StructuredSelection) {
               StructuredSelection structSelection = (StructuredSelection) selection;
               Object element = structSelection.getFirstElement();
               if (element instanceof Role) {
                  Role stakeholder = (Role) element;
                  roleInput.setRole(stakeholder);
                  enableOkButton(true);
               }
            }
         }
      });      
   }

   protected void enableOkButton(boolean enable) {
      Button okButton = getButton(IDialogConstants.OK_ID);
      okButton.setEnabled(enable);
   }

   private RoleInput getRoleInput() {
      RoleInput input = new RoleInput();
      Set<Role> roles = AccessControlModelUtil.getConcreteRoles(accessControlModel);
      input.addRoles(roles);
      return input;
   }

   public void setAccessControlModel(AccessControlModel accessControlModel) {
      this.accessControlModel = accessControlModel;
   }

}
