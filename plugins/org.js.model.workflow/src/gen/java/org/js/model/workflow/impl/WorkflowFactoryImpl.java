/**
 */
package org.js.model.workflow.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.js.model.workflow.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowFactoryImpl extends EFactoryImpl implements WorkflowFactory {
	/**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public static WorkflowFactory init() {
      try {
         WorkflowFactory theWorkflowFactory = (WorkflowFactory)EPackage.Registry.INSTANCE.getEFactory(WorkflowPackage.eNS_URI);
         if (theWorkflowFactory != null) {
            return theWorkflowFactory;
         }
      }
      catch (Exception exception) {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new WorkflowFactoryImpl();
   }

	/**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public WorkflowFactoryImpl() {
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
         case WorkflowPackage.ACM_CONNECTOR: return createACMConnector();
         case WorkflowPackage.ROLE_CONNECTOR: return createRoleConnector();
         case WorkflowPackage.EFM_CONTAINER: return createEFMContainer();
         case WorkflowPackage.LOG: return createLog();
         case WorkflowPackage.STATE: return createState();
         case WorkflowPackage.STAKEHOLDER_TYPES: return createStakeholderTypes();
         case WorkflowPackage.GRAPH_TRANS_CONNECTOR: return createGraphTransConnector();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
      switch (eDataType.getClassifierID()) {
         case WorkflowPackage.STATE_ENUM:
            return createStateEnumFromString(eDataType, initialValue);
         default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
      }
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
      switch (eDataType.getClassifierID()) {
         case WorkflowPackage.STATE_ENUM:
            return convertStateEnumToString(eDataType, instanceValue);
         default:
            throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
      }
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public ACMConnector createACMConnector() {
      ACMConnectorImpl acmConnector = new ACMConnectorImpl();
      return acmConnector;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public RoleConnector createRoleConnector() {
      RoleConnectorImpl roleConnector = new RoleConnectorImpl();
      return roleConnector;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EFMContainer createEFMContainer() {
      EFMContainerImpl efmContainer = new EFMContainerImpl();
      return efmContainer;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public Log createLog() {
      LogImpl log = new LogImpl();
      return log;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public State createState() {
      StateImpl state = new StateImpl();
      return state;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public StakeholderTypes createStakeholderTypes() {
      StakeholderTypesImpl stakeholderTypes = new StakeholderTypesImpl();
      return stakeholderTypes;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public GraphTransConnector createGraphTransConnector() {
      GraphTransConnectorImpl graphTransConnector = new GraphTransConnectorImpl();
      return graphTransConnector;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public StateEnum createStateEnumFromString(EDataType eDataType, String initialValue) {
      StateEnum result = StateEnum.get(initialValue);
      if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
      return result;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public String convertStateEnumToString(EDataType eDataType, Object instanceValue) {
      return instanceValue == null ? null : instanceValue.toString();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public WorkflowPackage getWorkflowPackage() {
      return (WorkflowPackage)getEPackage();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
	@Deprecated
	public static WorkflowPackage getPackage() {
      return WorkflowPackage.eINSTANCE;
   }

} //WorkflowFactoryImpl
