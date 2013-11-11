/**
 */
package org.feature.multi.perspective.view.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage;

import org.feature.multi.perspective.model.viewmodel.ViewmodelPackage;

import org.feature.multi.perspective.view.View;
import org.feature.multi.perspective.view.ViewContainer;
import org.feature.multi.perspective.view.ViewFactory;
import org.feature.multi.perspective.view.ViewPackage;

import org.featuremapper.models.feature.FeaturePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewPackageImpl extends EPackageImpl implements ViewPackage {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass viewContainerEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass viewEClass = null;

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
    * @see org.feature.multi.perspective.view.ViewPackage#eNS_URI
    * @see #init()
    * @generated
    */
   private ViewPackageImpl() {
      super(eNS_URI, ViewFactory.eINSTANCE);
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
    * <p>This method is used to initialize {@link ViewPackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static ViewPackage init() {
      if (isInited) return (ViewPackage)EPackage.Registry.INSTANCE.getEPackage(ViewPackage.eNS_URI);

      // Obtain or create and register package
      ViewPackageImpl theViewPackage = (ViewPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ViewPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ViewPackageImpl());

      isInited = true;

      // Initialize simple dependencies
      ViewmappingPackage.eINSTANCE.eClass();

      // Create package meta-data objects
      theViewPackage.createPackageContents();

      // Initialize created meta-data
      theViewPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theViewPackage.freeze();

  
      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(ViewPackage.eNS_URI, theViewPackage);
      return theViewPackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getViewContainer() {
      return viewContainerEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getViewContainer_Views() {
      return (EReference)viewContainerEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getViewContainer_FeatureMapping() {
      return (EReference)viewContainerEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getView() {
      return viewEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getView_Features() {
      return (EReference)viewEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EAttribute getView_Id() {
      return (EAttribute)viewEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getView_Viewgroups() {
      return (EReference)viewEClass.getEStructuralFeatures().get(2);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ViewFactory getViewFactory() {
      return (ViewFactory)getEFactoryInstance();
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
      viewContainerEClass = createEClass(VIEW_CONTAINER);
      createEReference(viewContainerEClass, VIEW_CONTAINER__VIEWS);
      createEReference(viewContainerEClass, VIEW_CONTAINER__FEATURE_MAPPING);

      viewEClass = createEClass(VIEW);
      createEReference(viewEClass, VIEW__FEATURES);
      createEAttribute(viewEClass, VIEW__ID);
      createEReference(viewEClass, VIEW__VIEWGROUPS);
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
      ViewmappingPackage theViewmappingPackage = (ViewmappingPackage)EPackage.Registry.INSTANCE.getEPackage(ViewmappingPackage.eNS_URI);
      FeaturePackage theFeaturePackage = (FeaturePackage)EPackage.Registry.INSTANCE.getEPackage(FeaturePackage.eNS_URI);
      ViewmodelPackage theViewmodelPackage = (ViewmodelPackage)EPackage.Registry.INSTANCE.getEPackage(ViewmodelPackage.eNS_URI);

      // Create type parameters

      // Set bounds for type parameters

      // Add supertypes to classes

      // Initialize classes and features; add operations and parameters
      initEClass(viewContainerEClass, ViewContainer.class, "ViewContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getViewContainer_Views(), this.getView(), null, "views", null, 0, -1, ViewContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getViewContainer_FeatureMapping(), theViewmappingPackage.getMappingModel(), null, "featureMapping", null, 1, 1, ViewContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(viewEClass, View.class, "View", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getView_Features(), theFeaturePackage.getFeature(), null, "features", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEAttribute(getView_Id(), ecorePackage.getEString(), "id", null, 1, 1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getView_Viewgroups(), theViewmodelPackage.getAbstractGroup(), null, "viewgroups", null, 0, -1, View.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} //ViewPackageImpl
