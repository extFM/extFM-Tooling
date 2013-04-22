/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.rbac.validation;

import org.eclipse.emf.ecore.EObject;
import org.js.model.rbac.AttributeDecision;
import org.js.model.rbac.SetAttribute;

/**
 * @author <a href=mailto:julia.schroeter@tu-dresden.de>Julia Schroeter</a>
 * 
 */
public abstract class AbstractAttributeConstraint extends AbstractRbacConstraint {

   @Override
   String validateTarget(EObject target) {
      String msg = null;
      if (target instanceof AttributeDecision) {
         AttributeDecision operation = (AttributeDecision) target;
         EObject eContainer = operation.eContainer();
         if (eContainer instanceof SetAttribute) {
            SetAttribute attributeConfig = (SetAttribute) eContainer;
            msg = checkAttributeConfiguration(attributeConfig, operation);
         }
      }
      return msg;
   }

   abstract String checkAttributeConfiguration(SetAttribute attributeConfig, AttributeDecision operation);

}
