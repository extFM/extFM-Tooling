package org.js.model.rbac.validation;

import org.eclipse.emf.common.util.EList;
import org.js.model.rbac.AttributeConfiguration;
import org.js.model.rbac.ValueOperation;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class UniqueDomainValueConstraint extends AbstractRbacConstraint {

   /**
    * Validate if an operation for the given domainvalue is already defined.
    */
   @Override
   String checkAttributeConfiguration(AttributeConfiguration attributeConfig, ValueOperation operation) {
      String errorMessage = null;

      EList<ValueOperation> valueOperations = attributeConfig.getValueOperations();
      String newValue = operation.getValue();
      for (ValueOperation valueOperation : valueOperations) {
         if (valueOperation != operation) {
            String value = valueOperation.getValue();
            if (value.equals(newValue)) {
               errorMessage = "A configuration operation on domain value '" + value + "' is already defined.";
               break;
            }
         }
      }
      return errorMessage;
   }

}
