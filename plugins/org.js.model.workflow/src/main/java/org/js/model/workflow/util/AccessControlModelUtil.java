package org.js.model.workflow.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.js.graph.transform.stagemodel.Stage;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.Role;
import org.js.model.rbac.RoleType;

public final class AccessControlModelUtil {

   public static Role getRole(String id, AccessControlModel accessControlModel) {
      Role result = null;
      EList<Role> roles = accessControlModel.getRoles();
      for (Role role : roles) {
         if (id.equals(role.getId())) {
            result = role;
         }
      }
      return result;
   }

   public static Group getRoleGroupForOwner(Role owner, AccessControlModel accessControlModel) {
      Group result = null;
      EList<Group> groups = accessControlModel.getGroups();
      for (Group group : groups) {
         if (owner.equals(group.getOwner())) {
            result = group;
            break;
         }
      }
      return result;
   }

   public static Group getRoleGroupForMember(Role member, AccessControlModel accessControlModel) {
      Group result = null;
      EList<Group> groups = accessControlModel.getGroups();
      for (Group group : groups) {
         EList<Role> members = group.getMembers();
         if (members.contains(member)) {
            result = group;
            break;
         }
      }
      return result;
   }

   public static Role getCorrespondingAbstractRole(Stage stage, AccessControlModel accessControlModel) {
      Role role = null;
      String stageId = stage.getId();
      EList<Role> roles = accessControlModel.getRoles();
      for (Role acRole : roles) {
         String roleId = acRole.getId();
         if (roleId.equals(stageId)) {
            role = acRole;
            break;
         }
      }
      return role;
   }

   public static void removeRoleGroupAndRole(Role role, AccessControlModel accessControlModel) {
      Group group = AccessControlModelUtil.getRoleGroupForOwner(role, accessControlModel);
      if (group != null) {
         EList<Role> members = group.getMembers();
         List<Role> copy = new ArrayList<Role>(members.size());
         copy.addAll(members);
         for (Role memberRole : copy) {
            removeRoleGroupAndRole(memberRole, accessControlModel);
         }
         accessControlModel.getGroups().remove(group);
      }
      removeRoleFromParents(role);
      Group memberGroup = AccessControlModelUtil.getRoleGroupForMember(role, accessControlModel);
      if (memberGroup != null) {
         memberGroup.getMembers().remove(role);
      }
      accessControlModel.getRoles().remove(role);
   }

   public static void removeRoleFromParents(Role role) {
      EList<Role> parentRoles = role.getParentRoles();
      Set<Role> copy = new HashSet<Role>(parentRoles.size());
      copy.addAll(parentRoles);
      for (Role parentRole : copy) {
         parentRole.getChildRoles().remove(role);
      }
   }

   public static Set<Role> getConcreteRoles(AccessControlModel accessControlModel) {
      EList<Role> roles = accessControlModel.getRoles();
      Set<Role> concreteRoles = new HashSet<Role>();
      for (Role role : roles) {
         if (RoleType.CONCRETE.equals(role.getType())) {
            concreteRoles.add(role);
         }
      }
      return concreteRoles;
   }

}
