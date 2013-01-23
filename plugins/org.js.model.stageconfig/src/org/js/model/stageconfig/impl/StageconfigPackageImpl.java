/**
 */
package org.js.model.stageconfig.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.js.model.feature.FeaturePackage;

import org.js.model.stageconfig.DomainValueOperation;
import org.js.model.stageconfig.FeatureOperation;
import org.js.model.stageconfig.Operation;
import org.js.model.stageconfig.Stage;
import org.js.model.stageconfig.StageModel;
import org.js.model.stageconfig.StageconfigFactory;
import org.js.model.stageconfig.StageconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StageconfigPackageImpl extends EPackageImpl implements StageconfigPackage {
	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass stageModelEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass stageEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass operationEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass featureOperationEClass = null;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private EClass domainValueOperationEClass = null;

	/**
    * Creates an instance of the model <b>Package</b>, registered with
    * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
    * package URI value.
    * <p>Note: the correct way to create the package is via the static
    * factory method {@link #init init()}, which also performs
    * initialization of the package, or returns the registered package,
    * if one already exists.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see org.eclipse.emf.ecore.EPackage.Registry
    * @see org.js.model.stageconfig.StageconfigPackage#eNS_URI
    * @see #init()
    * @generated
    */
	private StageconfigPackageImpl() {
      super(eNS_URI, StageconfigFactory.eINSTANCE);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private static boolean isInited = false;

	/**
    * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
    * 
    * <p>This method is used to initialize {@link StageconfigPackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
	public static StageconfigPackage init() {
      if (isInited) return (StageconfigPackage)EPackage.Registry.INSTANCE.getEPackage(StageconfigPackage.eNS_URI);

      // Obtain or create and register package
      StageconfigPackageImpl theStageconfigPackage = (StageconfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StageconfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StageconfigPackageImpl());

      isInited = true;

      // Initialize simple dependencies
      FeaturePackage.eINSTANCE.eClass();

      // Create package meta-data objects
      theStageconfigPackage.createPackageContents();

      // Initialize created meta-data
      theStageconfigPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theStageconfigPackage.freeze();

  
      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(StageconfigPackage.eNS_URI, theStageconfigPackage);
      return theStageconfigPackage;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getStageModel() {
      return stageModelEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getStageModel_FeatureModel() {
      return (EReference)stageModelEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getStageModel_FirstStage() {
      return (EReference)stageModelEClass.getEStructuralFeatures().get(1);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getStage() {
      return stageEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getStage_Operations() {
      return (EReference)stageEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getStage_NextStage() {
      return (EReference)stageEClass.getEStructuralFeatures().get(1);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EAttribute getStage_Name() {
      return (EAttribute)stageEClass.getEStructuralFeatures().get(2);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getOperation() {
      return operationEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getOperation_Feature() {
      return (EReference)operationEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getFeatureOperation() {
      return featureOperationEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EClass getDomainValueOperation() {
      return domainValueOperationEClass;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EAttribute getDomainValueOperation_Value() {
      return (EAttribute)domainValueOperationEClass.getEStructuralFeatures().get(0);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EReference getDomainValueOperation_Attribute() {
      return (EReference)domainValueOperationEClass.getEStructuralFeatures().get(1);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public StageconfigFactory getStageconfigFactory() {
      return (StageconfigFactory)getEFactoryInstance();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private boolean isCreated = false;

	/**
    * Creates the meta-model objects for the package.  This method is
    * guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void createPackageContents() {
      if (isCreated) return;
      isCreated = true;

      // Create classes and their features
      stageModelEClass = createEClass(STAGE_MODEL);
      createEReference(stageModelEClass, STAGE_MODEL__FEATURE_MODEL);
      createEReference(stageModelEClass, STAGE_MODEL__FIRST_STAGE);

      stageEClass = createEClass(STAGE);
      createEReference(stageEClass, STAGE__OPERATIONS);
      createEReference(stageEClass, STAGE__NEXT_STAGE);
      createEAttribute(stageEClass, STAGE__NAME);

      operationEClass = createEClass(OPERATION);
      createEReference(operationEClass, OPERATION__FEATURE);

      featureOperationEClass = createEClass(FEATURE_OPERATION);

      domainValueOperationEClass = createEClass(DOMAIN_VALUE_OPERATION);
      createEAttribute(domainValueOperationEClass, DOMAIN_VALUE_OPERATION__VALUE);
      createEReference(domainValueOperationEClass, DOMAIN_VALUE_OPERATION__ATTRIBUTE);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	private boolean isInitialized = false;

	/**
    * Complete the initialization of the package and its meta-model.  This
    * method is guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void initializePackageContents() {
      if (isInitialized) return;
      isInitialized = true;

      // Initialize package
      setName(eNAME);
      setNsPrefix(eNS_PREFIX);
      setNsURI(eNS_URI);

      // Obtain other dependent packages
      FeaturePackage theFeaturePackage = (FeaturePackage)EPackage.Registry.INSTANCE.getEPackage(FeaturePackage.eNS_URI);

      // Create type parameters

      // Set bounds for type parameters

      // Add supertypes to classes
      featureOperationEClass.getESuperTypes().add(this.getOperation());
      domainValueOperationEClass.getESuperTypes().add(this.getOperation());

      // Initialize classes and features; add operations and parameters
      initEClass(stageModelEClass, StageModel.class, "StageModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getStageModel_FeatureModel(), theFeaturePackage.getFeatureModel(), null, "featureModel", null, 1, 1, StageModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getStageModel_FirstStage(), this.getStage(), null, "firstStage", null, 0, 1, StageModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(stageEClass, Stage.class, "Stage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getStage_Operations(), this.getOperation(), null, "operations", null, 0, -1, Stage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getStage_NextStage(), this.getStage(), null, "nextStage", null, 0, 1, Stage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getStage_Name(), ecorePackage.getEString(), "name", null, 0, 1, Stage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      addEOperation(stageEClass, ecorePackage.getEBoolean(), "hasNext", 0, 1, IS_UNIQUE, IS_ORDERED);

      initEClass(operationEClass, Operation.class, "Operation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getOperation_Feature(), theFeaturePackage.getFeature(), null, "feature", null, 1, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(featureOperationEClass, FeatureOperation.class, "FeatureOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(domainValueOperationEClass, DomainValueOperation.class, "DomainValueOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEAttribute(getDomainValueOperation_Value(), ecorePackage.getEString(), "value", null, 1, 1, DomainValueOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getDomainValueOperation_Attribute(), theFeaturePackage.getAttribute(), null, "attribute", null, 1, 1, DomainValueOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} //StageconfigPackageImpl
