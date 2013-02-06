package org.js.model.rbac.validation;

import org.eclipse.emf.ecore.EObject;
import org.js.model.rbac.Role;

public abstract class AbstractRoleConstraint extends AbstractRbacConstraint {

   @Override
   String validateTarget(EObject target) {
      String msg = null;
      if (target instanceof Role) {
         Role role = (Role) target;
         msg = validateRole(role);
      }
      return msg;
   }

   abstract String validateRole(Role role);
}
