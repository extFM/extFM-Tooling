/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.feature.validation;

import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintDescriptor;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class UniqueIdConstraint extends AbstractModelConstraint implements IModelConstraint {

   private static String pluginId = "org.js.model.feature.validation";

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

   private IStatus getReturnStatus(String msg, EObject target) {
      IStatus returnStatus;
      if (msg != null && !msg.equals("")) {
         returnStatus = new ConstraintStatus(this, target, msg, Collections.singleton(target));
      } else {
         returnStatus = Status.OK_STATUS;
      }
      return returnStatus;
   }

   private String validateTarget(EObject target) {
      String msg = "";
      EObject rootContainer = EcoreUtil.getRootContainer(target);
      TreeIterator<EObject> eAllContents = rootContainer.eAllContents();
      String targetId = EcoreUtil.getID(target);
      if (targetId != null) {
         while (eAllContents.hasNext()) {
            EObject next = eAllContents.next();
            if (next != target) {
               String otherObjectId = EcoreUtil.getID(next);
               if (targetId.equals(otherObjectId)) {
                  msg = "An element with identifier <" + targetId + "> is already defined";
                  break;
               }

            }
         }
      }
      return msg;
   }
}
