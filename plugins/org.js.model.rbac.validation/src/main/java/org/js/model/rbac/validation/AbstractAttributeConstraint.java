/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.rbac.validation;

import org.eclipse.emf.ecore.EObject;
import org.js.model.rbac.AttributeConfiguration;
import org.js.model.rbac.DomainValueConfiguration;

/**
 * @author <a href=mailto:julia.schroeter@tu-dresden.de>Julia Schroeter</a>
 * 
 */
public abstract class AbstractAttributeConstraint extends AbstractRbacConstraint {

   @Override
   String validateTarget(EObject target) {
      String msg = null;
      if (target instanceof DomainValueConfiguration) {
         DomainValueConfiguration operation = (DomainValueConfiguration) target;
         EObject eContainer = operation.eContainer();
         if (eContainer instanceof AttributeConfiguration) {
            AttributeConfiguration attributeConfig = (AttributeConfiguration) eContainer;
            msg = checkAttributeConfiguration(attributeConfig, operation);
         }
      }
      return msg;
   }

   abstract String checkAttributeConfiguration(AttributeConfiguration attributeConfig, DomainValueConfiguration operation);

}
