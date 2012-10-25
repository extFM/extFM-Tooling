package org.js.model.rbac.validation;

import org.eclipse.emf.common.util.EList;
import org.js.model.rbac.AttributeConfiguration;
import org.js.model.rbac.DomainValueConfiguration;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class UniqueDomainValueConstraint extends AbstractAttributeConstraint {

   /**
    * Validate if an operation for the given domainvalue is already defined.
    */
   @Override
   String checkAttributeConfiguration(AttributeConfiguration attributeConfig, DomainValueConfiguration operation) {
      String errorMessage = null;

      EList<DomainValueConfiguration> valueOperations = attributeConfig.getValueConfigurations();
      String newValue = operation.getValue();
      for (DomainValueConfiguration valueOperation : valueOperations) {
         if (valueOperation != operation) {
            String value = valueOperation.getValue();
            if (value.equals(newValue)) {
               errorMessage = "A configuration operation on domain value '" + value + "' is already defined in this role.";
               break;
            }
         }
      }
      return errorMessage;
   }

}
