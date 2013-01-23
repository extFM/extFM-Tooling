/**
 */
package org.js.model.stageconfig;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.js.model.stageconfig.StageconfigPackage
 * @generated
 */
public interface StageconfigFactory extends EFactory {
	/**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	StageconfigFactory eINSTANCE = org.js.model.stageconfig.impl.StageconfigFactoryImpl.init();

	/**
    * Returns a new object of class '<em>Stage Model</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Stage Model</em>'.
    * @generated
    */
	StageModel createStageModel();

	/**
    * Returns a new object of class '<em>Stage</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Stage</em>'.
    * @generated
    */
	Stage createStage();

	/**
    * Returns a new object of class '<em>Feature Operation</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Feature Operation</em>'.
    * @generated
    */
	FeatureOperation createFeatureOperation();

	/**
    * Returns a new object of class '<em>Domain Value Operation</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Domain Value Operation</em>'.
    * @generated
    */
	DomainValueOperation createDomainValueOperation();

	/**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
	StageconfigPackage getStageconfigPackage();

} //StageconfigFactory
