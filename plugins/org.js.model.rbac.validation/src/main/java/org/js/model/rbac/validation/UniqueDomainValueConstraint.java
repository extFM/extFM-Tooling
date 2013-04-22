package org.js.model.rbac.validation;

import org.eclipse.emf.common.util.EList;
import org.js.model.rbac.AttributeDecision;
import org.js.model.rbac.SetAttribute;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class UniqueDomainValueConstraint extends AbstractAttributeConstraint {

   /**
    * Validate if an operation for the given domainvalue is already defined.
    */
   @Override
   String checkAttributeConfiguration(SetAttribute attributeConfig, AttributeDecision operation) {
      String errorMessage = null;

      if (attributeConfig instanceof SetAttribute) {
         SetAttribute setAttribute = (SetAttribute) attributeConfig;

         EList<AttributeDecision> valueOperations = setAttribute.getAttributeDecisions();
         String newValue = operation.getValue();
         for (AttributeDecision valueOperation : valueOperations) {
            if (valueOperation != operation) {
               String value = valueOperation.getValue();
               if (value.equals(newValue)) {
                  errorMessage = "A configuration operation on domain value '" + value + "' is already defined in this role.";
                  break;
               }
            }
         }
      }
      return errorMessage;
   }

}
