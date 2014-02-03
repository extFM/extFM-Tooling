package org.js.model.adaptation.ui;

import java.util.HashSet;
import java.util.Set;

import org.js.model.rbac.Role;

public class RoleInput {

   Set<Role> roles;

   public RoleInput() {
      roles = new HashSet<Role>();
   }

   
   
   public void addRoles(Set<Role> roles) {
      this.roles.addAll(roles);
   }
   
   
   public void addRole(Role role) {
      roles.add(role);
   }

   public Set<Role> getRoles() {
      return roles;
   }

}
