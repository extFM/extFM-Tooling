/**
 * 
 */
package org.js.model.rbac.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.rbac.Group;
import org.js.model.rbac.Role;

/**
 * A constraint to ensure that a group represented by a role does not contain that role.
 * 
 * @author Julia
 * 
 */
public class GroupRoleCycleConstraint extends AbstractGroupConstraint {

   @Override
   String validateGroup(Group group) {
      String msg = null;
      Role represents = group.getOwner();
      if (represents != null) {
         EList<Role> contains = group.getMembers();
         for (Role containedRole : contains) {
            if (EcoreUtil.equals(containedRole, represents)) {
               msg = "Role with id <" + represents.getId() + "> cannot be contained in own group <" + group.getId() + ">.";
               break;
            }
         }
      }
      return msg;
   }

}
