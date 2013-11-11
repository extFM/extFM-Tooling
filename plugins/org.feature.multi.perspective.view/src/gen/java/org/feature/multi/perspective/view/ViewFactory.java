/**
 */
package org.feature.multi.perspective.view;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.feature.multi.perspective.view.ViewPackage
 * @generated
 */
public interface ViewFactory extends EFactory {
   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   ViewFactory eINSTANCE = org.feature.multi.perspective.view.impl.ViewFactoryImpl.init();

   /**
    * Returns a new object of class '<em>Container</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Container</em>'.
    * @generated
    */
   ViewContainer createViewContainer();

   /**
    * Returns a new object of class '<em>View</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>View</em>'.
    * @generated
    */
   View createView();

   /**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
   ViewPackage getViewPackage();

} //ViewFactory
