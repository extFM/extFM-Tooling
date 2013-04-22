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
import org.js.model.rbac.AttributeDecision;
import org.js.model.rbac.SetAttribute;

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
   String checkAttributeConfiguration(SetAttribute attributeConfig, AttributeDecision operation) {
      String msg = null;
      Attribute attribute = attributeConfig.getAttribute();
      String value = operation.getValue();
      Domain domain = attribute.getDomain();
      if (domain instanceof DiscreteDomain) {
         DiscreteDomain discreteDomain = (DiscreteDomain) domain;
         EList<String> domainValues = discreteDomain.getValues();
         boolean iscontained = false;
         for (String domainValue : domainValues) {
            if (domainValue.equals(value)) {
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
