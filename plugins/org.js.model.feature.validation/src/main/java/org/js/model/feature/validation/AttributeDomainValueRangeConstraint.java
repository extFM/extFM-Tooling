/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.feature.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.js.model.feature.Attribute;
import org.js.model.feature.Domain;
import org.js.model.feature.edit.FeatureModelHelper;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class AttributeDomainValueRangeConstraint extends AbstractFeatureModelConstraint {

   public String validateTarget(EObject target) {
      String msg = "";
      if (target instanceof Attribute) {
         Attribute attribute = (Attribute) target;
         msg = checkDeselectedDomainValues(attribute);
         if (msg.isEmpty()) {
            msg = checkAssignedDomainValue(attribute);
         }
      }
      return msg;
   }

   private String checkAssignedDomainValue(Attribute attribute) {
      String msg = "";
      Domain domain = attribute.getDomain();
      String attributeValue = attribute.getValue();
      if (attributeValue != null) {
         if (!FeatureModelHelper.containsValue(domain, attributeValue)) {
            msg =
               "The assigned attribute value \"" + attributeValue + "\" is not contained in the referenced domain [" + domain.getId() + "]";
         }
      }
      return msg;
   }

   private String checkDeselectedDomainValues(Attribute attribute) {
      EList<String> deselectedDomainValues = attribute.getDeselectedDomainValues();
      Domain domain = attribute.getDomain();
      String msg = "";
      for (String deselectedValue : deselectedDomainValues) {
         if (!FeatureModelHelper.containsValue(domain, deselectedValue)) {
            msg =
               "The assigned attribute value \"" + deselectedValue + "\" is not contained in the referenced domain [" + domain.getId()
                     + "]";;
            break;
         }
      }
      return msg;
   }
}
