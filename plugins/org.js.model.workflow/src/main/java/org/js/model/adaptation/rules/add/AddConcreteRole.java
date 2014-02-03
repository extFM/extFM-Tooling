package org.js.model.adaptation.rules.add;

import org.js.model.adaptation.IRewriteRule;
import org.js.model.adaptation.ui.UserInputAddRole;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.RbacFactory;
import org.js.model.rbac.Role;
import org.js.model.rbac.RoleType;

public class AddConcreteRole extends AbstractAccessControlAddRewriteRule {

   public AddConcreteRole(UserInputAddRole input, AccessControlModel accessControlModel) {
      super(input, accessControlModel);
   }

   @Override
   public int execute() {
      int returnCode = IRewriteRule.Error;
      createRole();
      Role newConcreteRole = input.getNewRole();
      if (newConcreteRole != null) {
         addRole(newConcreteRole);
         returnCode = IRewriteRule.OK;
      }
      return returnCode;
   }

   private void addRole(Role newRole) {
      accessControlModel.getRoles().add(newRole);
      Role parentRole = input.getAbstractParentRole();
      parentRole.getChildRoles().add(newRole);
   }

   private void createRole() {
      String id = input.getRoleId();
      String name = input.getRoleName();
      Role newRole = createConcreteRole(name, id);
      input.setNewRole(newRole);
   }

   private Role createConcreteRole(String roleName, String roleId) {
      Role role = RbacFactory.eINSTANCE.createRole();
      role.setId(roleId);
      role.setName(roleName);
      role.setType(RoleType.CONCRETE);
      return role;
   }

}
