/**
 */
package org.js.model.stageconfig.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.js.model.stageconfig.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StageconfigFactoryImpl extends EFactoryImpl implements StageconfigFactory {
	/**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public static StageconfigFactory init() {
      try {
         StageconfigFactory theStageconfigFactory = (StageconfigFactory)EPackage.Registry.INSTANCE.getEFactory("stageconfig"); 
         if (theStageconfigFactory != null) {
            return theStageconfigFactory;
         }
      }
      catch (Exception exception) {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new StageconfigFactoryImpl();
   }

	/**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public StageconfigFactoryImpl() {
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
         case StageconfigPackage.STAGE_MODEL: return createStageModel();
         case StageconfigPackage.STAGE: return createStage();
         case StageconfigPackage.FEATURE_OPERATION: return createFeatureOperation();
         case StageconfigPackage.DOMAIN_VALUE_OPERATION: return createDomainValueOperation();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public StageModel createStageModel() {
      StageModelImpl stageModel = new StageModelImpl();
      return stageModel;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public Stage createStage() {
      StageImpl stage = new StageImpl();
      return stage;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public FeatureOperation createFeatureOperation() {
      FeatureOperationImpl featureOperation = new FeatureOperationImpl();
      return featureOperation;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public DomainValueOperation createDomainValueOperation() {
      DomainValueOperationImpl domainValueOperation = new DomainValueOperationImpl();
      return domainValueOperation;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public StageconfigPackage getStageconfigPackage() {
      return (StageconfigPackage)getEPackage();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
	@Deprecated
	public static StageconfigPackage getPackage() {
      return StageconfigPackage.eINSTANCE;
   }

} //StageconfigFactoryImpl
