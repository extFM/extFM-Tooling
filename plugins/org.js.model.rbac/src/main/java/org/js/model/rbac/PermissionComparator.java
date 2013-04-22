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

         if ((o1 instanceof SelectFeature && o2 instanceof SelectFeature) || o1 instanceof DeselectFeature && o2 instanceof DeselectFeature) {
            // if permission is a FeatureOperation than compare referenced features
            FeatureDecision o1FeatureOp = (FeatureDecision) o1;
            FeatureDecision o2FeatureOp = (FeatureDecision) o2;
            return compareFeatureOperations(o1FeatureOp, o2FeatureOp);

         } else if ((o1 instanceof SelectDomainValue && o2 instanceof SelectDomainValue) || o1 instanceof DeselectDomainValue
                    && o2 instanceof DeselectDomainValue) {
            // if permission is a DomainValueOperation than compare domain values and referenced attributes
            AttributeDecision o1DomainOp = (AttributeDecision) o1;
            AttributeDecision o2DomainOp = (AttributeDecision) o2;
            return compareDomainValueOperations(o1DomainOp, o2DomainOp);
         } else if ((o1 instanceof SetAttribute && o2 instanceof SetAttribute)) {
            // if both are set attribute permissions than check attribute and contained domain value permissions
            SetAttribute o1SetOp = (SetAttribute) o1;
            SetAttribute o2SetOp = (SetAttribute) o2;
            Attribute o1Attribute = o1SetOp.getAttribute();
            Attribute o2Attribute = o2SetOp.getAttribute();
            if (EcoreUtil.equals(o1Attribute, o2Attribute)
                && (o1SetOp.getAttributeDecisions().size() == o2SetOp.getAttributeDecisions().size())) {
               // TODO: check each domainValuePermission
               return isEqual;
            }
         }
      } else if (o1 == null && o2 == null) {
         return isEqual;
      }
      return isNotEqual;
   }

   private int compareFeatureOperations(FeatureDecision o1FeatureOp, FeatureDecision o2FeatureOp) {
      Feature o1Feature = o1FeatureOp.getFeature();
      Feature o2Feature = o2FeatureOp.getFeature();
      return compareEObjects(o1Feature, o2Feature);
   }

   private int compareEObjects(EObject o1, EObject o2) {
      boolean equals = EcoreUtil.equals(o1, o2);
      if (equals) {
         return isEqual;
      }
      return isNotEqual;
   }

   private int compareDomainValueOperations(AttributeDecision o1DomainOp, AttributeDecision o2DomainOp) {
      String o1Value = o1DomainOp.getValue();
      String o2Value = o2DomainOp.getValue();
      if (o1Value != null) {
         int valueResult = o1Value.compareTo(o2Value);
         if (isEqual == valueResult) {
            EObject o1container = o1DomainOp.eContainer();
            EObject o2container = o2DomainOp.eContainer();
            if (o1container instanceof SetAttribute && o2container instanceof SetAttribute) {
               SetAttribute o1SetAttribute = (SetAttribute) o1container;
               SetAttribute o2SetAttribute = (SetAttribute) o2container;
               Attribute o1attribute = o1SetAttribute.getAttribute();
               Attribute o2attribute = o2SetAttribute.getAttribute();
               boolean equalAttributes = EcoreUtil.equals(o1attribute, o2attribute);
               if (equalAttributes) {
                  return isEqual;
               }
            }
         }
      }
      return isNotEqual;
   }

}
