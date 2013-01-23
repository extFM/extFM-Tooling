/**
 */
package org.js.model.stageconfig;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.js.model.stageconfig.StageconfigFactory
 * @model kind="package"
 * @generated
 */
public interface StageconfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "stageconfig";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "stageconfig";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StageconfigPackage eINSTANCE = org.js.model.stageconfig.impl.StageconfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.js.model.stageconfig.impl.StageModelImpl <em>Stage Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.stageconfig.impl.StageModelImpl
	 * @see org.js.model.stageconfig.impl.StageconfigPackageImpl#getStageModel()
	 * @generated
	 */
	int STAGE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Feature Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGE_MODEL__FEATURE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>First Stage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGE_MODEL__FIRST_STAGE = 1;

	/**
	 * The number of structural features of the '<em>Stage Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGE_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.js.model.stageconfig.impl.StageImpl <em>Stage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.stageconfig.impl.StageImpl
	 * @see org.js.model.stageconfig.impl.StageconfigPackageImpl#getStage()
	 * @generated
	 */
	int STAGE = 1;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGE__OPERATIONS = 0;

	/**
	 * The feature id for the '<em><b>Next Stage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGE__NEXT_STAGE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGE__NAME = 2;

	/**
	 * The number of structural features of the '<em>Stage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAGE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.js.model.stageconfig.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.stageconfig.impl.OperationImpl
	 * @see org.js.model.stageconfig.impl.StageconfigPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__FEATURE = 0;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.js.model.stageconfig.impl.FeatureOperationImpl <em>Feature Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.stageconfig.impl.FeatureOperationImpl
	 * @see org.js.model.stageconfig.impl.StageconfigPackageImpl#getFeatureOperation()
	 * @generated
	 */
	int FEATURE_OPERATION = 3;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION__FEATURE = OPERATION__FEATURE;

	/**
	 * The number of structural features of the '<em>Feature Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.js.model.stageconfig.impl.DomainValueOperationImpl <em>Domain Value Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.stageconfig.impl.DomainValueOperationImpl
	 * @see org.js.model.stageconfig.impl.StageconfigPackageImpl#getDomainValueOperation()
	 * @generated
	 */
	int DOMAIN_VALUE_OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_VALUE_OPERATION__FEATURE = OPERATION__FEATURE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_VALUE_OPERATION__VALUE = OPERATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_VALUE_OPERATION__ATTRIBUTE = OPERATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Domain Value Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_VALUE_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.js.model.stageconfig.StageModel <em>Stage Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stage Model</em>'.
	 * @see org.js.model.stageconfig.StageModel
	 * @generated
	 */
	EClass getStageModel();

	/**
	 * Returns the meta object for the reference '{@link org.js.model.stageconfig.StageModel#getFeatureModel <em>Feature Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Model</em>'.
	 * @see org.js.model.stageconfig.StageModel#getFeatureModel()
	 * @see #getStageModel()
	 * @generated
	 */
	EReference getStageModel_FeatureModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.model.stageconfig.StageModel#getFirstStage <em>First Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First Stage</em>'.
	 * @see org.js.model.stageconfig.StageModel#getFirstStage()
	 * @see #getStageModel()
	 * @generated
	 */
	EReference getStageModel_FirstStage();

	/**
	 * Returns the meta object for class '{@link org.js.model.stageconfig.Stage <em>Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stage</em>'.
	 * @see org.js.model.stageconfig.Stage
	 * @generated
	 */
	EClass getStage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.model.stageconfig.Stage#getOperations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.js.model.stageconfig.Stage#getOperations()
	 * @see #getStage()
	 * @generated
	 */
	EReference getStage_Operations();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.model.stageconfig.Stage#getNextStage <em>Next Stage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Next Stage</em>'.
	 * @see org.js.model.stageconfig.Stage#getNextStage()
	 * @see #getStage()
	 * @generated
	 */
	EReference getStage_NextStage();

	/**
	 * Returns the meta object for the attribute '{@link org.js.model.stageconfig.Stage#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.js.model.stageconfig.Stage#getName()
	 * @see #getStage()
	 * @generated
	 */
	EAttribute getStage_Name();

	/**
	 * Returns the meta object for class '{@link org.js.model.stageconfig.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.js.model.stageconfig.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the reference '{@link org.js.model.stageconfig.Operation#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.js.model.stageconfig.Operation#getFeature()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_Feature();

	/**
	 * Returns the meta object for class '{@link org.js.model.stageconfig.FeatureOperation <em>Feature Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Operation</em>'.
	 * @see org.js.model.stageconfig.FeatureOperation
	 * @generated
	 */
	EClass getFeatureOperation();

	/**
	 * Returns the meta object for class '{@link org.js.model.stageconfig.DomainValueOperation <em>Domain Value Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Value Operation</em>'.
	 * @see org.js.model.stageconfig.DomainValueOperation
	 * @generated
	 */
	EClass getDomainValueOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.js.model.stageconfig.DomainValueOperation#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.js.model.stageconfig.DomainValueOperation#getValue()
	 * @see #getDomainValueOperation()
	 * @generated
	 */
	EAttribute getDomainValueOperation_Value();

	/**
	 * Returns the meta object for the reference '{@link org.js.model.stageconfig.DomainValueOperation#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Attribute</em>'.
	 * @see org.js.model.stageconfig.DomainValueOperation#getAttribute()
	 * @see #getDomainValueOperation()
	 * @generated
	 */
	EReference getDomainValueOperation_Attribute();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StageconfigFactory getStageconfigFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.js.model.stageconfig.impl.StageModelImpl <em>Stage Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.stageconfig.impl.StageModelImpl
		 * @see org.js.model.stageconfig.impl.StageconfigPackageImpl#getStageModel()
		 * @generated
		 */
		EClass STAGE_MODEL = eINSTANCE.getStageModel();

		/**
		 * The meta object literal for the '<em><b>Feature Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAGE_MODEL__FEATURE_MODEL = eINSTANCE.getStageModel_FeatureModel();

		/**
		 * The meta object literal for the '<em><b>First Stage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAGE_MODEL__FIRST_STAGE = eINSTANCE.getStageModel_FirstStage();

		/**
		 * The meta object literal for the '{@link org.js.model.stageconfig.impl.StageImpl <em>Stage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.stageconfig.impl.StageImpl
		 * @see org.js.model.stageconfig.impl.StageconfigPackageImpl#getStage()
		 * @generated
		 */
		EClass STAGE = eINSTANCE.getStage();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAGE__OPERATIONS = eINSTANCE.getStage_Operations();

		/**
		 * The meta object literal for the '<em><b>Next Stage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAGE__NEXT_STAGE = eINSTANCE.getStage_NextStage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STAGE__NAME = eINSTANCE.getStage_Name();

		/**
		 * The meta object literal for the '{@link org.js.model.stageconfig.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.stageconfig.impl.OperationImpl
		 * @see org.js.model.stageconfig.impl.StageconfigPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__FEATURE = eINSTANCE.getOperation_Feature();

		/**
		 * The meta object literal for the '{@link org.js.model.stageconfig.impl.FeatureOperationImpl <em>Feature Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.stageconfig.impl.FeatureOperationImpl
		 * @see org.js.model.stageconfig.impl.StageconfigPackageImpl#getFeatureOperation()
		 * @generated
		 */
		EClass FEATURE_OPERATION = eINSTANCE.getFeatureOperation();

		/**
		 * The meta object literal for the '{@link org.js.model.stageconfig.impl.DomainValueOperationImpl <em>Domain Value Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.stageconfig.impl.DomainValueOperationImpl
		 * @see org.js.model.stageconfig.impl.StageconfigPackageImpl#getDomainValueOperation()
		 * @generated
		 */
		EClass DOMAIN_VALUE_OPERATION = eINSTANCE.getDomainValueOperation();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_VALUE_OPERATION__VALUE = eINSTANCE.getDomainValueOperation_Value();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_VALUE_OPERATION__ATTRIBUTE = eINSTANCE.getDomainValueOperation_Attribute();

	}

} //StageconfigPackage
