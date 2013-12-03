/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.rbac;

import java.util.Comparator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class PermissionComparator implements Comparator<Permission> {

   final static int isEqual = 0;
   final static int isNotEqual = -1;

   @Override
   public int compare(Permission o1, Permission o2) {
      if (o1 != null && o2 != null) {

         if ((o1 instanceof FeatureOperation && o2 instanceof FeatureOperation)) {
            // if permission is a FeatureOperation than compare referenced features
            FeatureOperation o1FeatureOp = (FeatureOperation) o1;
            FeatureOperation o2FeatureOp = (FeatureOperation) o2;
            return compareFeatureOperations(o1FeatureOp, o2FeatureOp);

         } else if (o1 instanceof AttributeValueOperation && o2 instanceof AttributeValueOperation) {
            // if permission is a DomainValueOperation than compare domain values and referenced attributes
            AttributeValueOperation o1DomainOp = (AttributeValueOperation) o1;
            AttributeValueOperation o2DomainOp = (AttributeValueOperation) o2;
            return compareDomainValueOperations(o1DomainOp, o2DomainOp);
         } else if (o1 instanceof AttributeOperation && o2 instanceof AttributeOperation) {
            // if both are set attribute permissions than check attribute and contained domain value permissions
            AttributeOperation o1SetOp = (AttributeOperation) o1;
            AttributeOperation o2SetOp = (AttributeOperation) o2;
            Attribute o1Attribute = o1SetOp.getAttribute();
            Attribute o2Attribute = o2SetOp.getAttribute();
            if (EcoreUtil.equals(o1Attribute, o2Attribute)) {
               // TODO: check each domainValuePermission
               return isEqual;
            }
         }
      } else if (o1 == null && o2 == null) {
         return isEqual;
      }
      return isNotEqual;
   }

   private int compareFeatureOperations(FeatureOperation o1FeatureOp, FeatureOperation o2FeatureOp) {
      boolean isEqualType = RbacHelper.isSelectFeatureOperation(o1FeatureOp) && RbacHelper.isSelectFeatureOperation(o2FeatureOp);
      Feature o1Feature = o1FeatureOp.getFeature();
      Feature o2Feature = o2FeatureOp.getFeature();
      return (isEqualType) ? compareEObjects(o1Feature, o2Feature) : isNotEqual;
   }

   private int compareEObjects(EObject o1, EObject o2) {
      boolean equals = EcoreUtil.equals(o1, o2);
      if (equals) {
         return isEqual;
      }
      return isNotEqual;
   }

   private int compareDomainValueOperations(AttributeValueOperation o1DomainOp, AttributeValueOperation o2DomainOp) {
      int equals = isNotEqual;
      int o1Value = o1DomainOp.getValue();
      int o2Value = o2DomainOp.getValue();
      if (o1Value == o2Value) {
            Attribute o1attribute = getAttributeFromDomainValueOp(o1DomainOp);
            Attribute o2attribute = getAttributeFromDomainValueOp(o2DomainOp);
            if (EcoreUtil.equals(o1attribute, o2attribute)) {
               equals = isEqual;
            }
         }
      return equals;
   }

   private AttributeOperation getContainerAttribute(AttributeValueOperation op) {
      AttributeOperation attrOp = null;
      EObject container = op.eContainer();
      if (container instanceof AttributeOperation) {
         attrOp = (AttributeOperation) container;
      }
      return attrOp;
   }

   private Attribute getAttributeFromDomainValueOp(AttributeValueOperation op) {
      Attribute attribute = null;
      AttributeOperation containerAttribute = getContainerAttribute(op);
      if (containerAttribute != null) {
         attribute = containerAttribute.getAttribute();
      }
      return attribute;
   }

}
