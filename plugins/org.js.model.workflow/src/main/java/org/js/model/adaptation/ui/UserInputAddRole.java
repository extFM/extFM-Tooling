package org.js.model.adaptation.ui;

import org.eclipse.jwt.meta.model.processes.Action;
import org.js.model.rbac.Role;

public class UserInputAddRole {

   private Role abstractParentRole;
   private Role groupOwner;
   private String roleId;
   private String roleName;

   private Role newRbacRole;
   private org.eclipse.jwt.meta.model.organisations.Role newWorkflowRole;

   private Action specializationAction;

   public UserInputAddRole() {}

   public Role getAbstractParentRole() {
      return abstractParentRole;
   }

   public void setAbstractParentRole(Role abstractParentRole) {
      this.abstractParentRole = abstractParentRole;
   }

   public Role getGroupOwner() {
      return groupOwner;
   }

   public void setGroupOwner(Role groupOwner) {
      this.groupOwner = groupOwner;
   }

   public String getRoleId() {
      return roleId;
   }

   public void setRoleId(String roleId) {
      this.roleId = roleId;
   }

   public String getRoleName() {
      return roleName;
   }

   public void setRoleName(String roleName) {
      this.roleName = roleName;
   }

   public void setNewRole(Role role) {
      this.newRbacRole = role;
   }

   public Role getNewRole() {
      return this.newRbacRole;
   }

   public void setNewWorkflowRole(org.eclipse.jwt.meta.model.organisations.Role role) {
      this.newWorkflowRole = role;
   }

   public org.eclipse.jwt.meta.model.organisations.Role getNewWorkflowRole() {
      return this.newWorkflowRole;
   }

   public void setSpecializationAction(Action specializationAction) {
      this.specializationAction = specializationAction;
   }

   public Action getSpecializationAction() {
      return this.specializationAction;
   }
}
