package org.js.model.rbac.validation;

import java.util.List;

import org.js.model.rbac.RBACService;
import org.js.model.rbac.Role;

/**
 * ensure that there are no role cycles defined.
 * 
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class RoleCycleConstraint extends AbstractRoleConstraint {

   @Override
   String validateRole(Role role) {
      String msg = null;
      RBACService service = new RBACService();
      List<Role> parents = service.getParentRoles(role);
      if (parents.contains(role)) {
         msg = "Cycle detected on role with id <" + role.getId() + ">.";
      }
      return msg;
   }

}
