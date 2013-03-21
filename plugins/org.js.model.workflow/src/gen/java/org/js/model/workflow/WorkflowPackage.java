/**
 */
package org.js.model.workflow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.jwt.we.conf.model.ConfPackage;

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
 * @see org.js.model.workflow.WorkflowFactory
 * @model kind="package"
 * @generated
 */
public interface WorkflowPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "workflow";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "org.js.model.workflow";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "workflow";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorkflowPackage eINSTANCE = org.js.model.workflow.impl.WorkflowPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.js.model.workflow.impl.ACMConnectorImpl <em>ACM Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.impl.ACMConnectorImpl
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getACMConnector()
	 * @generated
	 */
	int ACM_CONNECTOR = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACM_CONNECTOR__ID = ConfPackage.ASPECT_INSTANCE__ID;

	/**
	 * The feature id for the '<em><b>Target Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACM_CONNECTOR__TARGET_MODEL_ELEMENT = ConfPackage.ASPECT_INSTANCE__TARGET_MODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>Acmref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACM_CONNECTOR__ACMREF = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ACM Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACM_CONNECTOR_FEATURE_COUNT = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.js.model.workflow.impl.RoleConnectorImpl <em>Role Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.impl.RoleConnectorImpl
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getRoleConnector()
	 * @generated
	 */
	int ROLE_CONNECTOR = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_CONNECTOR__ID = ConfPackage.ASPECT_INSTANCE__ID;

	/**
	 * The feature id for the '<em><b>Target Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_CONNECTOR__TARGET_MODEL_ELEMENT = ConfPackage.ASPECT_INSTANCE__TARGET_MODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>Roleref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_CONNECTOR__ROLEREF = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Role Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_CONNECTOR_FEATURE_COUNT = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.js.model.workflow.impl.LogImpl <em>Log</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.impl.LogImpl
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getLog()
	 * @generated
	 */
	int LOG = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG__ID = ConfPackage.ASPECT_INSTANCE__ID;

	/**
	 * The feature id for the '<em><b>Target Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG__TARGET_MODEL_ELEMENT = ConfPackage.ASPECT_INSTANCE__TARGET_MODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG__PERMISSIONS = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Log</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_FEATURE_COUNT = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.js.model.workflow.impl.InsertNodesImpl <em>Insert Nodes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.impl.InsertNodesImpl
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getInsertNodes()
	 * @generated
	 */
	int INSERT_NODES = 3;

	/**
	 * The feature id for the '<em><b>Joinnode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT_NODES__JOINNODE = 0;

	/**
	 * The feature id for the '<em><b>Forknode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT_NODES__FORKNODE = 1;

	/**
	 * The feature id for the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT_NODES__ACTION = 2;

	/**
	 * The number of structural features of the '<em>Insert Nodes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT_NODES_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.js.model.workflow.impl.InsertNodesContainerImpl <em>Insert Nodes Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.impl.InsertNodesContainerImpl
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getInsertNodesContainer()
	 * @generated
	 */
	int INSERT_NODES_CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT_NODES_CONTAINER__ID = ConfPackage.ASPECT_INSTANCE__ID;

	/**
	 * The feature id for the '<em><b>Target Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT_NODES_CONTAINER__TARGET_MODEL_ELEMENT = ConfPackage.ASPECT_INSTANCE__TARGET_MODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>Insertnodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT_NODES_CONTAINER__INSERTNODES = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Insert Nodes Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSERT_NODES_CONTAINER_FEATURE_COUNT = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.js.model.workflow.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.impl.StateImpl
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getState()
	 * @generated
	 */
	int STATE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__ID = ConfPackage.ASPECT_INSTANCE__ID;

	/**
	 * The feature id for the '<em><b>Target Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__TARGET_MODEL_ELEMENT = ConfPackage.ASPECT_INSTANCE__TARGET_MODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__STATE = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.js.model.workflow.impl.ConfSequenceImpl <em>Conf Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.impl.ConfSequenceImpl
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getConfSequence()
	 * @generated
	 */
	int CONF_SEQUENCE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONF_SEQUENCE__ID = ConfPackage.ASPECT_INSTANCE__ID;

	/**
	 * The feature id for the '<em><b>Target Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONF_SEQUENCE__TARGET_MODEL_ELEMENT = ConfPackage.ASPECT_INSTANCE__TARGET_MODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>Role</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONF_SEQUENCE__ROLE = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Conf Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONF_SEQUENCE_FEATURE_COUNT = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.js.model.workflow.StateEnum <em>State Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.StateEnum
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getStateEnum()
	 * @generated
	 */
	int STATE_ENUM = 7;


	/**
	 * Returns the meta object for class '{@link org.js.model.workflow.ACMConnector <em>ACM Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ACM Connector</em>'.
	 * @see org.js.model.workflow.ACMConnector
	 * @generated
	 */
	EClass getACMConnector();

	/**
	 * Returns the meta object for the reference '{@link org.js.model.workflow.ACMConnector#getAcmref <em>Acmref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Acmref</em>'.
	 * @see org.js.model.workflow.ACMConnector#getAcmref()
	 * @see #getACMConnector()
	 * @generated
	 */
	EReference getACMConnector_Acmref();

	/**
	 * Returns the meta object for class '{@link org.js.model.workflow.RoleConnector <em>Role Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role Connector</em>'.
	 * @see org.js.model.workflow.RoleConnector
	 * @generated
	 */
	EClass getRoleConnector();

	/**
	 * Returns the meta object for the reference '{@link org.js.model.workflow.RoleConnector#getRoleref <em>Roleref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Roleref</em>'.
	 * @see org.js.model.workflow.RoleConnector#getRoleref()
	 * @see #getRoleConnector()
	 * @generated
	 */
	EReference getRoleConnector_Roleref();

	/**
	 * Returns the meta object for class '{@link org.js.model.workflow.Log <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log</em>'.
	 * @see org.js.model.workflow.Log
	 * @generated
	 */
	EClass getLog();

	/**
	 * Returns the meta object for the reference list '{@link org.js.model.workflow.Log#getPermissions <em>Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Permissions</em>'.
	 * @see org.js.model.workflow.Log#getPermissions()
	 * @see #getLog()
	 * @generated
	 */
	EReference getLog_Permissions();

	/**
	 * Returns the meta object for class '{@link org.js.model.workflow.InsertNodes <em>Insert Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Insert Nodes</em>'.
	 * @see org.js.model.workflow.InsertNodes
	 * @generated
	 */
	EClass getInsertNodes();

	/**
	 * Returns the meta object for the reference '{@link org.js.model.workflow.InsertNodes#getJoinnode <em>Joinnode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Joinnode</em>'.
	 * @see org.js.model.workflow.InsertNodes#getJoinnode()
	 * @see #getInsertNodes()
	 * @generated
	 */
	EReference getInsertNodes_Joinnode();

	/**
	 * Returns the meta object for the reference '{@link org.js.model.workflow.InsertNodes#getForknode <em>Forknode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Forknode</em>'.
	 * @see org.js.model.workflow.InsertNodes#getForknode()
	 * @see #getInsertNodes()
	 * @generated
	 */
	EReference getInsertNodes_Forknode();

	/**
	 * Returns the meta object for the reference '{@link org.js.model.workflow.InsertNodes#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Action</em>'.
	 * @see org.js.model.workflow.InsertNodes#getAction()
	 * @see #getInsertNodes()
	 * @generated
	 */
	EReference getInsertNodes_Action();

	/**
	 * Returns the meta object for class '{@link org.js.model.workflow.InsertNodesContainer <em>Insert Nodes Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Insert Nodes Container</em>'.
	 * @see org.js.model.workflow.InsertNodesContainer
	 * @generated
	 */
	EClass getInsertNodesContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.js.model.workflow.InsertNodesContainer#getInsertnodes <em>Insertnodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Insertnodes</em>'.
	 * @see org.js.model.workflow.InsertNodesContainer#getInsertnodes()
	 * @see #getInsertNodesContainer()
	 * @generated
	 */
	EReference getInsertNodesContainer_Insertnodes();

	/**
	 * Returns the meta object for class '{@link org.js.model.workflow.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.js.model.workflow.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the attribute '{@link org.js.model.workflow.State#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see org.js.model.workflow.State#getState()
	 * @see #getState()
	 * @generated
	 */
	EAttribute getState_State();

	/**
	 * Returns the meta object for class '{@link org.js.model.workflow.ConfSequence <em>Conf Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conf Sequence</em>'.
	 * @see org.js.model.workflow.ConfSequence
	 * @generated
	 */
	EClass getConfSequence();

	/**
	 * Returns the meta object for the reference list '{@link org.js.model.workflow.ConfSequence#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Role</em>'.
	 * @see org.js.model.workflow.ConfSequence#getRole()
	 * @see #getConfSequence()
	 * @generated
	 */
	EReference getConfSequence_Role();

	/**
	 * Returns the meta object for enum '{@link org.js.model.workflow.StateEnum <em>State Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State Enum</em>'.
	 * @see org.js.model.workflow.StateEnum
	 * @generated
	 */
	EEnum getStateEnum();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorkflowFactory getWorkflowFactory();

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
		 * The meta object literal for the '{@link org.js.model.workflow.impl.ACMConnectorImpl <em>ACM Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.workflow.impl.ACMConnectorImpl
		 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getACMConnector()
		 * @generated
		 */
		EClass ACM_CONNECTOR = eINSTANCE.getACMConnector();

		/**
		 * The meta object literal for the '<em><b>Acmref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACM_CONNECTOR__ACMREF = eINSTANCE.getACMConnector_Acmref();

		/**
		 * The meta object literal for the '{@link org.js.model.workflow.impl.RoleConnectorImpl <em>Role Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.workflow.impl.RoleConnectorImpl
		 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getRoleConnector()
		 * @generated
		 */
		EClass ROLE_CONNECTOR = eINSTANCE.getRoleConnector();

		/**
		 * The meta object literal for the '<em><b>Roleref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROLE_CONNECTOR__ROLEREF = eINSTANCE.getRoleConnector_Roleref();

		/**
		 * The meta object literal for the '{@link org.js.model.workflow.impl.LogImpl <em>Log</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.workflow.impl.LogImpl
		 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getLog()
		 * @generated
		 */
		EClass LOG = eINSTANCE.getLog();

		/**
		 * The meta object literal for the '<em><b>Permissions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOG__PERMISSIONS = eINSTANCE.getLog_Permissions();

		/**
		 * The meta object literal for the '{@link org.js.model.workflow.impl.InsertNodesImpl <em>Insert Nodes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.workflow.impl.InsertNodesImpl
		 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getInsertNodes()
		 * @generated
		 */
		EClass INSERT_NODES = eINSTANCE.getInsertNodes();

		/**
		 * The meta object literal for the '<em><b>Joinnode</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSERT_NODES__JOINNODE = eINSTANCE.getInsertNodes_Joinnode();

		/**
		 * The meta object literal for the '<em><b>Forknode</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSERT_NODES__FORKNODE = eINSTANCE.getInsertNodes_Forknode();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSERT_NODES__ACTION = eINSTANCE.getInsertNodes_Action();

		/**
		 * The meta object literal for the '{@link org.js.model.workflow.impl.InsertNodesContainerImpl <em>Insert Nodes Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.workflow.impl.InsertNodesContainerImpl
		 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getInsertNodesContainer()
		 * @generated
		 */
		EClass INSERT_NODES_CONTAINER = eINSTANCE.getInsertNodesContainer();

		/**
		 * The meta object literal for the '<em><b>Insertnodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSERT_NODES_CONTAINER__INSERTNODES = eINSTANCE.getInsertNodesContainer_Insertnodes();

		/**
		 * The meta object literal for the '{@link org.js.model.workflow.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.workflow.impl.StateImpl
		 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE__STATE = eINSTANCE.getState_State();

		/**
		 * The meta object literal for the '{@link org.js.model.workflow.impl.ConfSequenceImpl <em>Conf Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.workflow.impl.ConfSequenceImpl
		 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getConfSequence()
		 * @generated
		 */
		EClass CONF_SEQUENCE = eINSTANCE.getConfSequence();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONF_SEQUENCE__ROLE = eINSTANCE.getConfSequence_Role();

		/**
		 * The meta object literal for the '{@link org.js.model.workflow.StateEnum <em>State Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.workflow.StateEnum
		 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getStateEnum()
		 * @generated
		 */
		EEnum STATE_ENUM = eINSTANCE.getStateEnum();

	}

} //WorkflowPackage
