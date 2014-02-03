package org.js.model.adaptation.rules.add;

import org.js.model.adaptation.IRewriteRule;
import org.js.model.adaptation.ui.UserInputAddRole;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.AccessControlModelUtil;

public class AddRoleGroupMember extends AbstractAccessControlAddRewriteRule {

   public AddRoleGroupMember(UserInputAddRole input, AccessControlModel accessControlModel) {
      super(input, accessControlModel);
   }

   @Override
   public int execute() {
      return addMember();
   }

   private int addMember() {
      int returnCode = IRewriteRule.OK;
      Role owner = input.getGroupOwner();
      Role newRole = input.getNewRole();
      if (newRole != null) {
         if (owner != null) {
            Group roleGroup = AccessControlModelUtil.getRoleGroupForOwner(owner, accessControlModel);
            roleGroup.getMembers().add(newRole);
         }
      } else {
         returnCode = IRewriteRule.Error;
      }
      return returnCode;
   }

}
