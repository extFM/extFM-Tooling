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
	 * The meta object id for the '{@link org.js.model.workflow.impl.EFMContainerImpl <em>EFM Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.impl.EFMContainerImpl
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getEFMContainer()
	 * @generated
	 */
	int EFM_CONTAINER = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFM_CONTAINER__ID = ConfPackage.ASPECT_INSTANCE__ID;

	/**
	 * The feature id for the '<em><b>Target Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFM_CONTAINER__TARGET_MODEL_ELEMENT = ConfPackage.ASPECT_INSTANCE__TARGET_MODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>Efmref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFM_CONTAINER__EFMREF = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>EFM Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EFM_CONTAINER_FEATURE_COUNT = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.js.model.workflow.impl.LogImpl <em>Log</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.impl.LogImpl
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getLog()
	 * @generated
	 */
	int LOG = 3;

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
	 * The meta object id for the '{@link org.js.model.workflow.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.impl.StateImpl
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getState()
	 * @generated
	 */
	int STATE = 4;

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
	 * The meta object id for the '{@link org.js.model.workflow.impl.StakeholderTypesImpl <em>Stakeholder Types</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.impl.StakeholderTypesImpl
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getStakeholderTypes()
	 * @generated
	 */
	int STAKEHOLDER_TYPES = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_TYPES__ID = ConfPackage.ASPECT_INSTANCE__ID;

	/**
	 * The feature id for the '<em><b>Target Model Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_TYPES__TARGET_MODEL_ELEMENT = ConfPackage.ASPECT_INSTANCE__TARGET_MODEL_ELEMENT;

	/**
	 * The feature id for the '<em><b>Stakeholder Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_TYPES__STAKEHOLDER_TYPES = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Stakeholder Types</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAKEHOLDER_TYPES_FEATURE_COUNT = ConfPackage.ASPECT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.js.model.workflow.StateEnum <em>State Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.js.model.workflow.StateEnum
	 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getStateEnum()
	 * @generated
	 */
	int STATE_ENUM = 6;


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
	 * Returns the meta object for class '{@link org.js.model.workflow.EFMContainer <em>EFM Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EFM Container</em>'.
	 * @see org.js.model.workflow.EFMContainer
	 * @generated
	 */
	EClass getEFMContainer();

	/**
	 * Returns the meta object for the containment reference '{@link org.js.model.workflow.EFMContainer#getEfmref <em>Efmref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Efmref</em>'.
	 * @see org.js.model.workflow.EFMContainer#getEfmref()
	 * @see #getEFMContainer()
	 * @generated
	 */
	EReference getEFMContainer_Efmref();

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
	 * Returns the meta object for class '{@link org.js.model.workflow.StakeholderTypes <em>Stakeholder Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stakeholder Types</em>'.
	 * @see org.js.model.workflow.StakeholderTypes
	 * @generated
	 */
	EClass getStakeholderTypes();

	/**
	 * Returns the meta object for the reference list '{@link org.js.model.workflow.StakeholderTypes#getStakeholderTypes <em>Stakeholder Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stakeholder Types</em>'.
	 * @see org.js.model.workflow.StakeholderTypes#getStakeholderTypes()
	 * @see #getStakeholderTypes()
	 * @generated
	 */
	EReference getStakeholderTypes_StakeholderTypes();

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
		 * The meta object literal for the '{@link org.js.model.workflow.impl.EFMContainerImpl <em>EFM Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.workflow.impl.EFMContainerImpl
		 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getEFMContainer()
		 * @generated
		 */
		EClass EFM_CONTAINER = eINSTANCE.getEFMContainer();

		/**
		 * The meta object literal for the '<em><b>Efmref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EFM_CONTAINER__EFMREF = eINSTANCE.getEFMContainer_Efmref();

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
		 * The meta object literal for the '{@link org.js.model.workflow.impl.StakeholderTypesImpl <em>Stakeholder Types</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.js.model.workflow.impl.StakeholderTypesImpl
		 * @see org.js.model.workflow.impl.WorkflowPackageImpl#getStakeholderTypes()
		 * @generated
		 */
		EClass STAKEHOLDER_TYPES = eINSTANCE.getStakeholderTypes();

		/**
		 * The meta object literal for the '<em><b>Stakeholder Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STAKEHOLDER_TYPES__STAKEHOLDER_TYPES = eINSTANCE.getStakeholderTypes_StakeholderTypes();

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
