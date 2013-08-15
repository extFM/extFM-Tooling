/**
 * 
 */
package org.js.model.rbac.validation;

import org.eclipse.emf.ecore.EObject;
import org.js.model.rbac.Group;


/**
 * @author Julia
 *
 */
public abstract class AbstractGroupConstraint extends AbstractRbacConstraint {

   @Override
   String validateTarget(EObject target) {
      String msg = null;
      if (target instanceof Group) {
         Group group = (Group) target;
         msg = validateGroup(group);
      }
      return msg;
   }

   abstract String validateGroup(Group group);
   
   
}
