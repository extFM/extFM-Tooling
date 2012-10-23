package org.js.model.rbac.validation;

import org.eclipse.emf.validation.model.IClientSelector;
import org.js.model.rbac.Role;


public class RbacDelegateClientSelector  implements IClientSelector{

   @Override
   public boolean selects(Object object) {
      return (object instanceof Role);
   }

   
}
