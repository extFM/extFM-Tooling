/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.rbac;

import org.js.model.feature.Attribute;
import org.js.model.feature.DomainValue;
import org.js.model.feature.Feature;

/**
 * Helper Class to handle model changes.
 * 
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public final class RbacHelper {

   public static AttributeValueOperation createDeselectDomainValue(DomainValue value) {
      AttributeValueOperation domainValue = RbacFactory.eINSTANCE.createAttributeValueOperation();
      domainValue.setType(ConfigurationType.DESELECT);
       int name = value.getInt();
      domainValue.setValue(name);
      return domainValue;
   }

   public static AttributeValueOperation createSelectDomainValue(DomainValue value) {
      AttributeValueOperation domainValue = RbacFactory.eINSTANCE.createAttributeValueOperation();
      domainValue.setType(ConfigurationType.SELECT);
      int name = value.getInt();
      domainValue.setValue(name);
      return domainValue;
   }

   public static AttributeOperation createSetAttribute(Feature f, Attribute a) {
      AttributeOperation sa1 = RbacFactory.eINSTANCE.createAttributeOperation();
      sa1.setAttribute(a);
      sa1.setFeature(f);
      return sa1;
   }

   public static FeatureOperation createSelectFeature(Feature f) {
      FeatureOperation selectFeature = RbacFactory.eINSTANCE.createFeatureOperation();
      selectFeature.setType(ConfigurationType.SELECT);
      selectFeature.setFeature(f);
      return selectFeature;
   }

   public static FeatureOperation createDeselectFeature(Feature f) {
      FeatureOperation deselectFeature = RbacFactory.eINSTANCE.createFeatureOperation();
      deselectFeature.setType(ConfigurationType.DESELECT);
      deselectFeature.setFeature(f);
      return deselectFeature;
   }

   public static boolean isSelectFeatureOperation(Permission permission) {
      boolean result = false;
      if (permission instanceof FeatureOperation) {
         FeatureOperation operation = (FeatureOperation) permission;
         result = ConfigurationType.SELECT.equals(operation.getType());
      }
      return result;
   }
   public static boolean isDeselectFeatureOperation(Permission permission) {
      boolean result = false;
      if (permission instanceof FeatureOperation) {
         FeatureOperation operation = (FeatureOperation) permission;
         result = ConfigurationType.DESELECT.equals(operation.getType());
      }
      return result;
   }

   public static boolean isSelectDomainValueOperation(Permission permission) {
      boolean result = false;
      if (permission instanceof AttributeValueOperation) {
         AttributeValueOperation operation = (AttributeValueOperation) permission;
         result = ConfigurationType.SELECT.equals(operation.getType());
      }
      return result;
   }

   public static boolean isDeselectDomainValueOperation(Permission permission) {
      boolean result = false;
      if (permission instanceof AttributeValueOperation) {
         AttributeValueOperation operation = (AttributeValueOperation) permission;
         result = ConfigurationType.DESELECT.equals(operation.getType());
      }
      return result;
   }
   public static boolean isAbstractRole(Role role) {
      RoleType type = role.getType();
      return RoleType.ABSTRACT.equals(type);
   }
   
   public static boolean isViewElement(Permission permission){
      boolean result = false;
      if (permission instanceof VisibilityRestriction) {
         VisibilityRestriction operation = (VisibilityRestriction) permission;
         result = ModificationType.VIEW.equals(operation.getVisibility());
      }
      return result;
   }
   
}
