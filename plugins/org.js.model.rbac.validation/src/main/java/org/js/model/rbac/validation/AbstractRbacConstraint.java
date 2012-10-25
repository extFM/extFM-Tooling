package org.js.model.rbac.validation;

import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.js.model.rbac.AttributeConfiguration;
import org.js.model.rbac.DomainValueConfiguration;

public abstract class AbstractRbacConstraint extends AbstractModelConstraint implements IModelConstraint {

   private static String pluginId = "org.js.model.rbac.validation";

   @Override
   public IConstraintDescriptor getDescriptor() {
      return new AbstractConstraintDescriptor() {

         @Override
         public boolean targetsTypeOf(EObject eObject) {
            return true;
         }

         @Override
         public boolean targetsEvent(Notification notification) {
            return false;
         }

         @Override
         public int getStatusCode() {
            return 0;
         }

         @Override
         public ConstraintSeverity getSeverity() {
            return ConstraintSeverity.ERROR;
         }

         @Override
         public String getPluginId() {
            return pluginId;
         }

         @Override
         public String getName() {
            return "name";
         }

         @Override
         public String getMessagePattern() {
            return "message";
         }

         @Override
         public String getId() {
            return null;
         }

         @Override
         public EvaluationMode< ? > getEvaluationMode() {
            return EvaluationMode.LIVE;
         }

         @Override
         public String getDescription() {
            return "description";
         }

         @Override
         public String getBody() {
            return null;
         }
      };
   }

   @Override
   public IStatus validate(IValidationContext ctx) {
      EObject target = ctx.getTarget();
      String msg = validateTarget(target);
      return getReturnStatus(msg, target);
   }
 
   abstract String validateTarget(EObject target);
   
   private IStatus getReturnStatus(String msg, EObject target) {
      IStatus returnStatus;
      if (msg != null && !msg.equals("")) {
         returnStatus = new ConstraintStatus(this, target, msg, Collections.singleton(target));
      } else {
         returnStatus = Status.OK_STATUS;
      }
      return returnStatus;
   }
   
}
