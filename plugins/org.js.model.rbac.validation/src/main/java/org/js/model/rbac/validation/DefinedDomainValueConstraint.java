/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.rbac.validation;

import org.eclipse.emf.common.util.EList;
import org.js.model.feature.Attribute;
import org.js.model.feature.DiscreteDomain;
import org.js.model.feature.Domain;
import org.js.model.feature.DomainValue;
import org.js.model.rbac.AttributeOperation;
import org.js.model.rbac.AttributeValueOperation;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class DefinedDomainValueConstraint extends AbstractAttributeConstraint {

   /**
    * validate if the given domain value is defined in the attribute's domain.
    * 
    * @param attributeConfig
    * @param operation
    * @return
    */
   @Override
   String checkAttributeConfiguration(AttributeOperation attributeConfig, AttributeValueOperation operation) {
      String msg = null;
      Attribute attribute = attributeConfig.getAttribute();
      int value = operation.getValue();
      Domain domain = attribute.getDomain();
      if (domain instanceof DiscreteDomain) {
         DiscreteDomain discreteDomain = (DiscreteDomain) domain;
         EList<DomainValue> domainValues = discreteDomain.getValues();
         boolean iscontained = false;
         for (DomainValue domainValue : domainValues) {
            int name = domainValue.getInt();
            if (value == name) {
               iscontained = true;
               break;
            }
         }
         if (!iscontained) {
            msg = "Invalid domain value. '" + value + "' is not contained in domain " + discreteDomain.getId() + ".";
         }
      }
      return msg;
   }

}
