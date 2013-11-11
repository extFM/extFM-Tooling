/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.CoreGroup;
import org.feature.multi.perspective.model.viewmodel.Element;
import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.model.viewmodel.ViewPointContainer;
import org.feature.multi.perspective.model.viewmodel.ViewmodelFactory;
import org.feature.multi.perspective.model.viewmodel.ViewmodelPackage;

import org.feature.multi.perspective.model.viewmodel.util.ViewmodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewmodelPackageImpl extends EPackageImpl implements ViewmodelPackage {
   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private EClass coreGroupEClass = null;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private EClass abstractGroupEClass = null;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private EClass groupEClass = null;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private EClass viewPointEClass = null;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private EClass elementEClass = null;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private EClass groupModelEClass = null;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private EClass viewPointContainerEClass = null;

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
	 * @see org.feature.multi.perspective.model.viewmodel.ViewmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
   private ViewmodelPackageImpl() {
		super(eNS_URI, ViewmodelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ViewmodelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
   public static ViewmodelPackage init() {
		if (isInited) return (ViewmodelPackage)EPackage.Registry.INSTANCE.getEPackage(ViewmodelPackage.eNS_URI);

		// Obtain or create and register package
		ViewmodelPackageImpl theViewmodelPackage = (ViewmodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ViewmodelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ViewmodelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theViewmodelPackage.createPackageContents();

		// Initialize created meta-data
		theViewmodelPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theViewmodelPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return ViewmodelValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theViewmodelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ViewmodelPackage.eNS_URI, theViewmodelPackage);
		return theViewmodelPackage;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EClass getCoreGroup() {
		return coreGroupEClass;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EClass getAbstractGroup() {
		return abstractGroupEClass;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EReference getAbstractGroup_ViewPointReference() {
		return (EReference)abstractGroupEClass.getEStructuralFeatures().get(0);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EReference getAbstractGroup_Groups() {
		return (EReference)abstractGroupEClass.getEStructuralFeatures().get(1);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EClass getGroup() {
		return groupEClass;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EReference getGroup_ParentGroup() {
		return (EReference)groupEClass.getEStructuralFeatures().get(0);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EClass getViewPoint() {
		return viewPointEClass;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EReference getViewPoint_ContainedInGroup() {
		return (EReference)viewPointEClass.getEStructuralFeatures().get(0);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EClass getElement() {
		return elementEClass;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EAttribute getElement_Name() {
		return (EAttribute)elementEClass.getEStructuralFeatures().get(0);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EClass getGroupModel() {
		return groupModelEClass;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EReference getGroupModel_CoreGroup() {
		return (EReference)groupModelEClass.getEStructuralFeatures().get(0);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EReference getGroupModel_ViewPointContainer() {
		return (EReference)groupModelEClass.getEStructuralFeatures().get(1);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EClass getViewPointContainer() {
		return viewPointContainerEClass;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EReference getViewPointContainer_ViewPoints() {
		return (EReference)viewPointContainerEClass.getEStructuralFeatures().get(0);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ViewmodelFactory getViewmodelFactory() {
		return (ViewmodelFactory)getEFactoryInstance();
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
		coreGroupEClass = createEClass(CORE_GROUP);

		abstractGroupEClass = createEClass(ABSTRACT_GROUP);
		createEReference(abstractGroupEClass, ABSTRACT_GROUP__VIEW_POINT_REFERENCE);
		createEReference(abstractGroupEClass, ABSTRACT_GROUP__GROUPS);

		viewPointEClass = createEClass(VIEW_POINT);
		createEReference(viewPointEClass, VIEW_POINT__CONTAINED_IN_GROUP);

		elementEClass = createEClass(ELEMENT);
		createEAttribute(elementEClass, ELEMENT__NAME);

		groupModelEClass = createEClass(GROUP_MODEL);
		createEReference(groupModelEClass, GROUP_MODEL__CORE_GROUP);
		createEReference(groupModelEClass, GROUP_MODEL__VIEW_POINT_CONTAINER);

		viewPointContainerEClass = createEClass(VIEW_POINT_CONTAINER);
		createEReference(viewPointContainerEClass, VIEW_POINT_CONTAINER__VIEW_POINTS);

		groupEClass = createEClass(GROUP);
		createEReference(groupEClass, GROUP__PARENT_GROUP);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		coreGroupEClass.getESuperTypes().add(this.getAbstractGroup());
		abstractGroupEClass.getESuperTypes().add(this.getElement());
		viewPointEClass.getESuperTypes().add(this.getElement());
		groupEClass.getESuperTypes().add(this.getAbstractGroup());

		// Initialize classes and features; add operations and parameters
		initEClass(coreGroupEClass, CoreGroup.class, "CoreGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractGroupEClass, AbstractGroup.class, "AbstractGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractGroup_ViewPointReference(), this.getViewPoint(), this.getViewPoint_ContainedInGroup(), "viewPointReference", null, 0, -1, AbstractGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractGroup_Groups(), this.getGroup(), this.getGroup_ParentGroup(), "groups", null, 0, -1, AbstractGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(abstractGroupEClass, ecorePackage.getEBoolean(), "checkForRedundantViewPoints", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "eDiagnosticChain", 1, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "eMap", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(viewPointEClass, ViewPoint.class, "ViewPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewPoint_ContainedInGroup(), this.getAbstractGroup(), this.getAbstractGroup_ViewPointReference(), "containedInGroup", null, 0, -1, ViewPoint.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, Element.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupModelEClass, GroupModel.class, "GroupModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroupModel_CoreGroup(), this.getCoreGroup(), null, "coreGroup", null, 1, 1, GroupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroupModel_ViewPointContainer(), this.getViewPointContainer(), null, "viewPointContainer", null, 1, 1, GroupModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(viewPointContainerEClass, ViewPointContainer.class, "ViewPointContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getViewPointContainer_ViewPoints(), this.getViewPoint(), null, "viewPoints", null, 0, -1, ViewPointContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroup_ParentGroup(), this.getAbstractGroup(), this.getAbstractGroup_Groups(), "parentGroup", null, 0, 1, Group.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ViewmodelPackageImpl
