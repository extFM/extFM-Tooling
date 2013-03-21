/**
 */
package org.js.model.workflow.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.jwt.meta.model.application.ApplicationPackage;

import org.eclipse.jwt.meta.model.core.CorePackage;

import org.eclipse.jwt.meta.model.data.DataPackage;

import org.eclipse.jwt.meta.model.events.EventsPackage;

import org.eclipse.jwt.meta.model.functions.FunctionsPackage;

import org.eclipse.jwt.meta.model.organisations.OrganisationsPackage;

import org.eclipse.jwt.meta.model.primitiveTypes.PrimitiveTypesPackage;

import org.eclipse.jwt.meta.model.processes.ProcessesPackage;

import org.eclipse.jwt.we.conf.model.ConfPackage;

import org.js.model.rbac.RbacPackage;

import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.ConfSequence;
import org.js.model.workflow.InsertNodes;
import org.js.model.workflow.InsertNodesContainer;
import org.js.model.workflow.Log;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;
import org.js.model.workflow.WorkflowFactory;
import org.js.model.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowPackageImpl extends EPackageImpl implements WorkflowPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass acmConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass insertNodesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass insertNodesContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass confSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stateEnumEEnum = null;

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
	 * @see org.js.model.workflow.WorkflowPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WorkflowPackageImpl() {
		super(eNS_URI, WorkflowFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link WorkflowPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WorkflowPackage init() {
		if (isInited) return (WorkflowPackage)EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI);

		// Obtain or create and register package
		WorkflowPackageImpl theWorkflowPackage = (WorkflowPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WorkflowPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WorkflowPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ConfPackage.eINSTANCE.eClass();
		CorePackage.eINSTANCE.eClass();
		ProcessesPackage.eINSTANCE.eClass();
		EventsPackage.eINSTANCE.eClass();
		PrimitiveTypesPackage.eINSTANCE.eClass();
		FunctionsPackage.eINSTANCE.eClass();
		OrganisationsPackage.eINSTANCE.eClass();
		ApplicationPackage.eINSTANCE.eClass();
		DataPackage.eINSTANCE.eClass();
		RbacPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theWorkflowPackage.createPackageContents();

		// Initialize created meta-data
		theWorkflowPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWorkflowPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WorkflowPackage.eNS_URI, theWorkflowPackage);
		return theWorkflowPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getACMConnector() {
		return acmConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getACMConnector_Acmref() {
		return (EReference)acmConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoleConnector() {
		return roleConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoleConnector_Roleref() {
		return (EReference)roleConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLog() {
		return logEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLog_Permissions() {
		return (EReference)logEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInsertNodes() {
		return insertNodesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInsertNodes_Joinnode() {
		return (EReference)insertNodesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInsertNodes_Forknode() {
		return (EReference)insertNodesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInsertNodes_Action() {
		return (EReference)insertNodesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInsertNodesContainer() {
		return insertNodesContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInsertNodesContainer_Insertnodes() {
		return (EReference)insertNodesContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getState() {
		return stateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getState_State() {
		return (EAttribute)stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfSequence() {
		return confSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfSequence_Role() {
		return (EReference)confSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStateEnum() {
		return stateEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowFactory getWorkflowFactory() {
		return (WorkflowFactory)getEFactoryInstance();
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
		acmConnectorEClass = createEClass(ACM_CONNECTOR);
		createEReference(acmConnectorEClass, ACM_CONNECTOR__ACMREF);

		roleConnectorEClass = createEClass(ROLE_CONNECTOR);
		createEReference(roleConnectorEClass, ROLE_CONNECTOR__ROLEREF);

		logEClass = createEClass(LOG);
		createEReference(logEClass, LOG__PERMISSIONS);

		insertNodesEClass = createEClass(INSERT_NODES);
		createEReference(insertNodesEClass, INSERT_NODES__JOINNODE);
		createEReference(insertNodesEClass, INSERT_NODES__FORKNODE);
		createEReference(insertNodesEClass, INSERT_NODES__ACTION);

		insertNodesContainerEClass = createEClass(INSERT_NODES_CONTAINER);
		createEReference(insertNodesContainerEClass, INSERT_NODES_CONTAINER__INSERTNODES);

		stateEClass = createEClass(STATE);
		createEAttribute(stateEClass, STATE__STATE);

		confSequenceEClass = createEClass(CONF_SEQUENCE);
		createEReference(confSequenceEClass, CONF_SEQUENCE__ROLE);

		// Create enums
		stateEnumEEnum = createEEnum(STATE_ENUM);
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
		ConfPackage theConfPackage = (ConfPackage)EPackage.Registry.INSTANCE.getEPackage(ConfPackage.eNS_URI);
		RbacPackage theRbacPackage = (RbacPackage)EPackage.Registry.INSTANCE.getEPackage(RbacPackage.eNS_URI);
		ProcessesPackage theProcessesPackage = (ProcessesPackage)EPackage.Registry.INSTANCE.getEPackage(ProcessesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		acmConnectorEClass.getESuperTypes().add(theConfPackage.getAspectInstance());
		roleConnectorEClass.getESuperTypes().add(theConfPackage.getAspectInstance());
		logEClass.getESuperTypes().add(theConfPackage.getAspectInstance());
		insertNodesContainerEClass.getESuperTypes().add(theConfPackage.getAspectInstance());
		stateEClass.getESuperTypes().add(theConfPackage.getAspectInstance());
		confSequenceEClass.getESuperTypes().add(theConfPackage.getAspectInstance());

		// Initialize classes and features; add operations and parameters
		initEClass(acmConnectorEClass, ACMConnector.class, "ACMConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getACMConnector_Acmref(), theRbacPackage.getAccessControlModel(), null, "acmref", null, 0, 1, ACMConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleConnectorEClass, RoleConnector.class, "RoleConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoleConnector_Roleref(), theRbacPackage.getRole(), null, "roleref", null, 0, 1, RoleConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logEClass, Log.class, "Log", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLog_Permissions(), theRbacPackage.getPermission(), null, "permissions", null, 0, -1, Log.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(insertNodesEClass, InsertNodes.class, "InsertNodes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInsertNodes_Joinnode(), theProcessesPackage.getJoinNode(), null, "joinnode", null, 0, 1, InsertNodes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInsertNodes_Forknode(), theProcessesPackage.getForkNode(), null, "forknode", null, 0, 1, InsertNodes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInsertNodes_Action(), theProcessesPackage.getAction(), null, "action", null, 0, 1, InsertNodes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(insertNodesContainerEClass, InsertNodesContainer.class, "InsertNodesContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInsertNodesContainer_Insertnodes(), this.getInsertNodes(), null, "insertnodes", null, 0, -1, InsertNodesContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getState_State(), this.getStateEnum(), "state", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(confSequenceEClass, ConfSequence.class, "ConfSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfSequence_Role(), theRbacPackage.getRole(), null, "role", null, 0, -1, ConfSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(stateEnumEEnum, StateEnum.class, "StateEnum");
		addEEnumLiteral(stateEnumEEnum, StateEnum.INACTIVE);
		addEEnumLiteral(stateEnumEEnum, StateEnum.ENABLE);
		addEEnumLiteral(stateEnumEEnum, StateEnum.RUNNING);
		addEEnumLiteral(stateEnumEEnum, StateEnum.COMPLETED);

		// Create resource
		createResource(eNS_URI);
	}

} //WorkflowPackageImpl
