/**
 */
package org.feature.multi.perspective.mapping.viewmapping.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.feature.multi.perspective.mapping.viewmapping.Mapping;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory;
import org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage;

import org.feature.multi.perspective.model.viewmodel.ViewmodelPackage;

import org.featuremapper.models.feature.FeaturePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewmappingPackageImpl extends EPackageImpl implements ViewmappingPackage {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass mappingModelEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass mappingEClass = null;

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
    * @see org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage#eNS_URI
    * @see #init()
    * @generated
    */
   private ViewmappingPackageImpl() {
      super(eNS_URI, ViewmappingFactory.eINSTANCE);
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
    * <p>This method is used to initialize {@link ViewmappingPackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static ViewmappingPackage init() {
      if (isInited) return (ViewmappingPackage)EPackage.Registry.INSTANCE.getEPackage(ViewmappingPackage.eNS_URI);

      // Obtain or create and register package
      ViewmappingPackageImpl theViewmappingPackage = (ViewmappingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ViewmappingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ViewmappingPackageImpl());

      isInited = true;

      // Initialize simple dependencies
      FeaturePackage.eINSTANCE.eClass();
      ViewmodelPackage.eINSTANCE.eClass();

      // Create package meta-data objects
      theViewmappingPackage.createPackageContents();

      // Initialize created meta-data
      theViewmappingPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theViewmappingPackage.freeze();

  
      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(ViewmappingPackage.eNS_URI, theViewmappingPackage);
      return theViewmappingPackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getMappingModel() {
      return mappingModelEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getMappingModel_Mappings() {
      return (EReference)mappingModelEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getMappingModel_FeatureModel() {
      return (EReference)mappingModelEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getMappingModel_ViewModel() {
      return (EReference)mappingModelEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getMapping() {
      return mappingEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getMapping_Features() {
      return (EReference)mappingEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getMapping_Viewgroup() {
      return (EReference)mappingEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ViewmappingFactory getViewmappingFactory() {
      return (ViewmappingFactory)getEFactoryInstance();
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
      mappingModelEClass = createEClass(MAPPING_MODEL);
      createEReference(mappingModelEClass, MAPPING_MODEL__MAPPINGS);
      createEReference(mappingModelEClass, MAPPING_MODEL__FEATURE_MODEL);
      createEReference(mappingModelEClass, MAPPING_MODEL__VIEW_MODEL);

      mappingEClass = createEClass(MAPPING);
      createEReference(mappingEClass, MAPPING__FEATURES);
      createEReference(mappingEClass, MAPPING__VIEWGROUP);
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
      ViewmodelPackage theViewmodelPackage = (ViewmodelPackage)EPackage.Registry.INSTANCE.getEPackage(ViewmodelPackage.eNS_URI);

      // Create type parameters

      // Set bounds for type parameters

      // Add supertypes to classes

      // Initialize classes and features; add operations and parameters
      initEClass(mappingModelEClass, MappingModel.class, "MappingModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getMappingModel_Mappings(), this.getMapping(), null, "mappings", null, 0, -1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getMappingModel_FeatureModel(), theFeaturePackage.getFeatureModel(), null, "featureModel", null, 1, 1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getMappingModel_ViewModel(), theViewmodelPackage.getGroupModel(), null, "viewModel", null, 1, 1, MappingModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getMapping_Features(), theFeaturePackage.getFeature(), null, "features", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getMapping_Viewgroup(), theViewmodelPackage.getAbstractGroup(), null, "viewgroup", null, 1, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} //ViewmappingPackageImpl
