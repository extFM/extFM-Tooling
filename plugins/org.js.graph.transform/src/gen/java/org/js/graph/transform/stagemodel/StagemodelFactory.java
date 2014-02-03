/**
 */
package org.js.graph.transform.stagemodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.js.graph.transform.stagemodel.StagemodelPackage
 * @generated
 */
public interface StagemodelFactory extends EFactory {
   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   StagemodelFactory eINSTANCE = org.js.graph.transform.stagemodel.impl.StagemodelFactoryImpl.init();

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
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
   StagemodelPackage getStagemodelPackage();

} //StagemodelFactory
