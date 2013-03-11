/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.rbac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;

/**
 * Access information from the RBAC model.
 * 
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class RBACService {

   // default constructor
   public RBACService() {}

   public List<Permission> getAllRolePermissions(Role role) {
      List<Permission> permissions = new ArrayList<Permission>();
      getAllRolePermissionsRecursively(role, permissions);
      synchronized (this) { 
        Collections.sort(permissions, new PermissionComparator());
      }
      return permissions;
   }

   private void getAllRolePermissionsRecursively(Role role, List<Permission> permissions) {
      permissions.addAll(role.getPermissions());
      EList<Role> parentRoles = role.getParentRoles();
      for (Role parentRole : parentRoles) {
         getAllRolePermissionsRecursively(parentRole, permissions);
      }
   }

   /**
    * get a subject's direct and indirect roles.
    * 
    * @param subject
    * @return
    */
   public List<Role> getSubjectRoles(Subject subject) {
      List<Role> allRoles = new ArrayList<>();
      EList<Role> roles = subject.getRoles();
      allRoles.addAll(roles);
      for (Role role : roles) {
         List<Role> parentRoles = getParentRoles(role);
         for (Role parent : parentRoles) {
            if (!allRoles.contains(parent)) {
               allRoles.add(parent);
            }
         }
      }
      return allRoles;
   }

   private void findParentRoles(Role role, List<Role> roles) {
      EList<Role> parents = role.getParentRoles();
      for (Role parent : parents) {
         if (!roles.contains(parent)) {
            roles.add(parent);
            findParentRoles(parent, roles);
         }
      }
   }

   private void findChildRoles(Role role, List<Role> roles) {
      EList<Role> children = role.getChildRoles();
      for (Role child : children) {
         if (!roles.contains(child)) {
            roles.add(child);
            findChildRoles(child, roles);
         }
      }
   }

   /**
    * get a role's directly assigned subjects.
    * 
    * @param role
    * @return
    */
   public List<Subject> getRoleDirectSubjects(Role role) {
      EList<Subject> subjects = role.getSubjects();
      return subjects;
   }

   /**
    * get all the roles that are direct and indirect children of the specified role.
    * 
    * @param role
    * @return
    */
   public List<Role> getChildRoles(Role role) {
      List<Role> children = new ArrayList<Role>();
      findChildRoles(role, children);
      return children;
   }

   /**
    * get all the roles that are directly and indirectly assigned parents of the specified role.
    * 
    * @param role
    * @return
    */
   public List<Role> getParentRoles(Role role) {
      List<Role> parents = new ArrayList<Role>();
      findParentRoles(role, parents);
      return parents;
   }

 
}
