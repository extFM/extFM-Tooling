/**
 */
package org.js.model.stageconfig.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.js.model.stageconfig.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.js.model.stageconfig.StageconfigPackage
 * @generated
 */
public class StageconfigSwitch<T> extends Switch<T> {
	/**
    * The cached model package
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected static StageconfigPackage modelPackage;

	/**
    * Creates an instance of the switch.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public StageconfigSwitch() {
      if (modelPackage == null) {
         modelPackage = StageconfigPackage.eINSTANCE;
      }
   }

	/**
    * Checks whether this is a switch for the given package.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @parameter ePackage the package in question.
    * @return whether this is a switch for the given package.
    * @generated
    */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
      return ePackage == modelPackage;
   }

	/**
    * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return the first non-null result returned by a <code>caseXXX</code> call.
    * @generated
    */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
      switch (classifierID) {
         case StageconfigPackage.STAGE_MODEL: {
            StageModel stageModel = (StageModel)theEObject;
            T result = caseStageModel(stageModel);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case StageconfigPackage.STAGE: {
            Stage stage = (Stage)theEObject;
            T result = caseStage(stage);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case StageconfigPackage.OPERATION: {
            Operation operation = (Operation)theEObject;
            T result = caseOperation(operation);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case StageconfigPackage.FEATURE_OPERATION: {
            FeatureOperation featureOperation = (FeatureOperation)theEObject;
            T result = caseFeatureOperation(featureOperation);
            if (result == null) result = caseOperation(featureOperation);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case StageconfigPackage.DOMAIN_VALUE_OPERATION: {
            DomainValueOperation domainValueOperation = (DomainValueOperation)theEObject;
            T result = caseDomainValueOperation(domainValueOperation);
            if (result == null) result = caseOperation(domainValueOperation);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         default: return defaultCase(theEObject);
      }
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Stage Model</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Stage Model</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseStageModel(StageModel object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Stage</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Stage</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseStage(Stage object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseOperation(Operation object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Feature Operation</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Feature Operation</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseFeatureOperation(FeatureOperation object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Domain Value Operation</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Domain Value Operation</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseDomainValueOperation(DomainValueOperation object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject)
    * @generated
    */
	@Override
	public T defaultCase(EObject object) {
      return null;
   }

} //StageconfigSwitch
