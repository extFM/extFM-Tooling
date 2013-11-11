/**
 */
package org.feature.multi.perspective.view.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.feature.multi.perspective.view.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewFactoryImpl extends EFactoryImpl implements ViewFactory {
   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static ViewFactory init() {
      try {
         ViewFactory theViewFactory = (ViewFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.conper.de/view"); 
         if (theViewFactory != null) {
            return theViewFactory;
         }
      }
      catch (Exception exception) {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new ViewFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ViewFactoryImpl() {
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
         case ViewPackage.VIEW_CONTAINER: return createViewContainer();
         case ViewPackage.VIEW: return createView();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ViewContainer createViewContainer() {
      ViewContainerImpl viewContainer = new ViewContainerImpl();
      return viewContainer;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public View createView() {
      ViewImpl view = new ViewImpl();
      return view;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ViewPackage getViewPackage() {
      return (ViewPackage)getEPackage();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
   @Deprecated
   public static ViewPackage getPackage() {
      return ViewPackage.eINSTANCE;
   }

} //ViewFactoryImpl
