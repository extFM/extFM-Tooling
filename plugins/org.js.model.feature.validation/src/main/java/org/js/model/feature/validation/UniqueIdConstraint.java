/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.feature.validation;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.DomainValue;
import org.js.model.feature.Feature;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class UniqueIdConstraint extends AbstractFeatureModelConstraint {

   public String validateTarget(EObject target) {
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
                  // Attributes may have the same identifier but must belong to differing features
                  if (target instanceof Attribute && next instanceof Attribute) {
                     Attribute targetAttribute = (Attribute) target;
                     Attribute otherAttribute = (Attribute) next;
                     Feature otherFeature = otherAttribute.getFeature();
                     Feature targetFeature = targetAttribute.getFeature();
                     if (!EcoreUtil.equals(otherFeature, targetFeature)) {
                        msg = null;
                     }
                     // the id of a domain value is its integer representation. Multiple domain values of different
                     // domains may have the same integer representation
                  } else if (target instanceof DomainValue && next instanceof DomainValue) {
                     if (!EcoreUtil.equals(target.eContainer(), next.eContainer())) {
                        msg = null;
                     }
                  } else {
                     break;
                  }
               }
            }
         }
      }
      return msg;
   }
}
