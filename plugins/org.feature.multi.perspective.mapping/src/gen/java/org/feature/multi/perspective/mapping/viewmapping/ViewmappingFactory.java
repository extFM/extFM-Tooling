/**
 */
package org.feature.multi.perspective.mapping.viewmapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage
 * @generated
 */
public interface ViewmappingFactory extends EFactory {
   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   ViewmappingFactory eINSTANCE = org.feature.multi.perspective.mapping.viewmapping.impl.ViewmappingFactoryImpl.init();

   /**
    * Returns a new object of class '<em>Mapping Model</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Mapping Model</em>'.
    * @generated
    */
   MappingModel createMappingModel();

   /**
    * Returns a new object of class '<em>Mapping</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Mapping</em>'.
    * @generated
    */
   Mapping createMapping();

   /**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
   ViewmappingPackage getViewmappingPackage();

} //ViewmappingFactory
