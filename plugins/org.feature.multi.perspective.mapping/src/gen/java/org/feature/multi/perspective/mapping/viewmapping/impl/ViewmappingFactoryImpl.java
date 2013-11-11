/**
 */
package org.feature.multi.perspective.mapping.viewmapping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.feature.multi.perspective.mapping.viewmapping.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewmappingFactoryImpl extends EFactoryImpl implements ViewmappingFactory {
   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static ViewmappingFactory init() {
      try {
         ViewmappingFactory theViewmappingFactory = (ViewmappingFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.tudresden.de/viewmapping"); 
         if (theViewmappingFactory != null) {
            return theViewmappingFactory;
         }
      }
      catch (Exception exception) {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new ViewmappingFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ViewmappingFactoryImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public EObject create(EClass eClass) {
      switch (eClass.getClassifierID()) {
         case ViewmappingPackage.MAPPING_MODEL: return createMappingModel();
         case ViewmappingPackage.MAPPING: return createMapping();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public MappingModel createMappingModel() {
      MappingModelImpl mappingModel = new MappingModelImpl();
      return mappingModel;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Mapping createMapping() {
      MappingImpl mapping = new MappingImpl();
      return mapping;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ViewmappingPackage getViewmappingPackage() {
      return (ViewmappingPackage)getEPackage();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
   @Deprecated
   public static ViewmappingPackage getPackage() {
      return ViewmappingPackage.eINSTANCE;
   }

} //ViewmappingFactoryImpl
