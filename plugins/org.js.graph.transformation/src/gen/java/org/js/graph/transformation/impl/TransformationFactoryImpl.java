/**
 */
package org.js.graph.transformation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.js.graph.transformation.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TransformationFactoryImpl extends EFactoryImpl implements TransformationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransformationFactory init() {
		try {
			TransformationFactory theTransformationFactory = (TransformationFactory)EPackage.Registry.INSTANCE.getEFactory(TransformationPackage.eNS_URI);
			if (theTransformationFactory != null) {
				return theTransformationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TransformationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationFactoryImpl() {
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
			case TransformationPackage.GRAPH_TRANSFORMATION: return createGraphTransformation();
			case TransformationPackage.RULE: return createRule();
			case TransformationPackage.LEFT_SIDE: return createLeftSide();
			case TransformationPackage.ROLES: return createRoles();
			case TransformationPackage.APPLICATION_CONDITIONS: return createApplicationConditions();
			case TransformationPackage.OPERATIONS: return createOperations();
			case TransformationPackage.EDGE: return createEdge();
			case TransformationPackage.EXISTING_ROLE: return createExistingRole();
			case TransformationPackage.ARRIVING_ROLE: return createArrivingRole();
			case TransformationPackage.INITIAL: return createInitial();
			case TransformationPackage.ACTIVITY_FINAL: return createActivityFinal();
			case TransformationPackage.FLOW_FINAL: return createFlowFinal();
			case TransformationPackage.FORK: return createFork();
			case TransformationPackage.SPECIALIZATION_ACTION: return createSpecializationAction();
			case TransformationPackage.IDLE_ACTION: return createIdleAction();
			case TransformationPackage.INHERITS_FROM: return createInheritsFrom();
			case TransformationPackage.BELONGS_TO: return createBelongsTo();
			case TransformationPackage.REMOVE_NODES: return createRemoveNodes();
			case TransformationPackage.REMOVE_EDGES: return createRemoveEdges();
			case TransformationPackage.ADD_EDGES: return createAddEdges();
			case TransformationPackage.ADD_NODES: return createAddNodes();
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
	public Roles createRoles() {
		RolesImpl roles = new RolesImpl();
		return roles;
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
	public Operations createOperations() {
		OperationsImpl operations = new OperationsImpl();
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge createEdge() {
		EdgeImpl edge = new EdgeImpl();
		return edge;
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
	public Initial createInitial() {
		InitialImpl initial = new InitialImpl();
		return initial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityFinal createActivityFinal() {
		ActivityFinalImpl activityFinal = new ActivityFinalImpl();
		return activityFinal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowFinal createFlowFinal() {
		FlowFinalImpl flowFinal = new FlowFinalImpl();
		return flowFinal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fork createFork() {
		ForkImpl fork = new ForkImpl();
		return fork;
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
	public RemoveNodes createRemoveNodes() {
		RemoveNodesImpl removeNodes = new RemoveNodesImpl();
		return removeNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveEdges createRemoveEdges() {
		RemoveEdgesImpl removeEdges = new RemoveEdgesImpl();
		return removeEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddEdges createAddEdges() {
		AddEdgesImpl addEdges = new AddEdgesImpl();
		return addEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddNodes createAddNodes() {
		AddNodesImpl addNodes = new AddNodesImpl();
		return addNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationPackage getTransformationPackage() {
		return (TransformationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TransformationPackage getPackage() {
		return TransformationPackage.eINSTANCE;
	}

} //TransformationFactoryImpl
