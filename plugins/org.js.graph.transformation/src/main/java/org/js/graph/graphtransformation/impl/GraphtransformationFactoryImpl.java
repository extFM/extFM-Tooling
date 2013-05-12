/**
 */
package org.js.graph.graphtransformation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.js.graph.graphtransformation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphtransformationFactoryImpl extends EFactoryImpl implements GraphtransformationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphtransformationFactory init() {
		try {
			GraphtransformationFactory theGraphtransformationFactory = (GraphtransformationFactory)EPackage.Registry.INSTANCE.getEFactory("http://graphtransformation/1.0"); 
			if (theGraphtransformationFactory != null) {
				return theGraphtransformationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphtransformationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphtransformationFactoryImpl() {
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
			case GraphtransformationPackage.GRAPH_TRANSFORMATION: return createGraphTransformation();
			case GraphtransformationPackage.RULE: return createRule();
			case GraphtransformationPackage.LEFT_SIDE: return createLeftSide();
			case GraphtransformationPackage.ROLES: return createRoles();
			case GraphtransformationPackage.APPLICATION_CONDITIONS: return createApplicationConditions();
			case GraphtransformationPackage.OPERATIONS: return createOperations();
			case GraphtransformationPackage.ACTIVITY_EDGE: return createActivityEdge();
			case GraphtransformationPackage.EXISTING_ROLE: return createExistingRole();
			case GraphtransformationPackage.ARRIVING_ROLE: return createArrivingRole();
			case GraphtransformationPackage.INITIAL_NODE: return createInitialNode();
			case GraphtransformationPackage.ACTIVITY_FINAL_NODE: return createActivityFinalNode();
			case GraphtransformationPackage.FLOW_FINAL_NODE: return createFlowFinalNode();
			case GraphtransformationPackage.FORK_NODE: return createForkNode();
			case GraphtransformationPackage.SPECIALIZATION_ACTION: return createSpecializationAction();
			case GraphtransformationPackage.IDLE_ACTION: return createIdleAction();
			case GraphtransformationPackage.INHERITS_FROM: return createInheritsFrom();
			case GraphtransformationPackage.BELONGS_TO: return createBelongsTo();
			case GraphtransformationPackage.REMOVE_NODE: return createRemoveNode();
			case GraphtransformationPackage.REMOVE_EDGE: return createRemoveEdge();
			case GraphtransformationPackage.ADD_EDGE: return createAddEdge();
			case GraphtransformationPackage.ADD_NODE: return createAddNode();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphTransformation createGraphTransformation() {
		GraphTransformationImpl graphTransformation = new GraphTransformationImpl();
		return graphTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule createRule() {
		RuleImpl rule = new RuleImpl();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeftSide createLeftSide() {
		LeftSideImpl leftSide = new LeftSideImpl();
		return leftSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InheritsFrom createInheritsFrom() {
		InheritsFromImpl inheritsFrom = new InheritsFromImpl();
		return inheritsFrom;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BelongsTo createBelongsTo() {
		BelongsToImpl belongsTo = new BelongsToImpl();
		return belongsTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operations createOperations() {
		OperationsImpl operations = new OperationsImpl();
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityEdge createActivityEdge() {
		ActivityEdgeImpl activityEdge = new ActivityEdgeImpl();
		return activityEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialNode createInitialNode() {
		InitialNodeImpl initialNode = new InitialNodeImpl();
		return initialNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityFinalNode createActivityFinalNode() {
		ActivityFinalNodeImpl activityFinalNode = new ActivityFinalNodeImpl();
		return activityFinalNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowFinalNode createFlowFinalNode() {
		FlowFinalNodeImpl flowFinalNode = new FlowFinalNodeImpl();
		return flowFinalNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForkNode createForkNode() {
		ForkNodeImpl forkNode = new ForkNodeImpl();
		return forkNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializationAction createSpecializationAction() {
		SpecializationActionImpl specializationAction = new SpecializationActionImpl();
		return specializationAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdleAction createIdleAction() {
		IdleActionImpl idleAction = new IdleActionImpl();
		return idleAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExistingRole createExistingRole() {
		ExistingRoleImpl existingRole = new ExistingRoleImpl();
		return existingRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrivingRole createArrivingRole() {
		ArrivingRoleImpl arrivingRole = new ArrivingRoleImpl();
		return arrivingRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationConditions createApplicationConditions() {
		ApplicationConditionsImpl applicationConditions = new ApplicationConditionsImpl();
		return applicationConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Roles createRoles() {
		RolesImpl roles = new RolesImpl();
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveNode createRemoveNode() {
		RemoveNodeImpl removeNode = new RemoveNodeImpl();
		return removeNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveEdge createRemoveEdge() {
		RemoveEdgeImpl removeEdge = new RemoveEdgeImpl();
		return removeEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddEdge createAddEdge() {
		AddEdgeImpl addEdge = new AddEdgeImpl();
		return addEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddNode createAddNode() {
		AddNodeImpl addNode = new AddNodeImpl();
		return addNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphtransformationPackage getGraphtransformationPackage() {
		return (GraphtransformationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphtransformationPackage getPackage() {
		return GraphtransformationPackage.eINSTANCE;
	}

} //GraphtransformationFactoryImpl
