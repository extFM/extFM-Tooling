package org.js.model.rbac.validation;

import org.eclipse.emf.common.util.EList;
import org.js.model.rbac.AttributeOperation;
import org.js.model.rbac.DomainValueOperation;
import org.js.model.rbac.RbacHelper;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class UniqueDomainValueConstraint extends AbstractAttributeConstraint {

   /**
    * Validate if an operation for the given domainvalue is already defined.
    */
   @Override
   String checkAttributeConfiguration(AttributeOperation attributeConfig, DomainValueOperation operation) {
      String errorMessage = null;

      if (attributeConfig instanceof AttributeOperation) {
         AttributeOperation setAttribute = (AttributeOperation) attributeConfig;

         EList<DomainValueOperation> valueOperations = setAttribute.getValueOperations();
         String newValue = operation.getValue();
         for (DomainValueOperation valueOperation : valueOperations) {
            if (valueOperation != operation) {
               String value = valueOperation.getValue();
               if (value.equals(newValue)) {
                  if ((RbacHelper.isSelectDomainValueOperation(operation) && RbacHelper.isSelectDomainValueOperation(valueOperation) || (RbacHelper
                     .isDeselectDomainValueOperation(operation) && RbacHelper.isDeselectDomainValueOperation(valueOperation)))) {
                     errorMessage = "A configuration operation on domain value '" + value + "' is already defined in this role.";
                     break;
                  }
               }
            }
         }
      }
      return errorMessage;
   }

}
