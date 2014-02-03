package org.js.model.adaptation.rules.remove;

import org.js.model.adaptation.AbstractAccessControlModelRewriteRule;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.AccessControlModelUtil;

public class RemoveRoleAssociationsInAccessControlModel extends AbstractAccessControlModelRewriteRule {

   private Role role;

   public RemoveRoleAssociationsInAccessControlModel(Role role, AccessControlModel accessControlModel) {
      super(accessControlModel);
      this.role = role;
   }

   @Override
   public int execute() {
      AccessControlModelUtil.removeRoleGroupAndRole(role, accessControlModel);
      return 0;
   }

}
