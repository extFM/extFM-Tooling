/**
 */
package org.js.graph.transformation.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.js.graph.transformation.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.js.graph.transformation.TransformationPackage
 * @generated
 */
public class TransformationAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static TransformationPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TransformationPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationSwitch<Adapter> modelSwitch =
		new TransformationSwitch<Adapter>() {
			@Override
			public Adapter caseGraphTransformation(GraphTransformation object) {
				return createGraphTransformationAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter caseLeftSide(LeftSide object) {
				return createLeftSideAdapter();
			}
			@Override
			public Adapter caseRoles(Roles object) {
				return createRolesAdapter();
			}
			@Override
			public Adapter caseApplicationConditions(ApplicationConditions object) {
				return createApplicationConditionsAdapter();
			}
			@Override
			public Adapter caseOperations(Operations object) {
				return createOperationsAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseEdge(Edge object) {
				return createEdgeAdapter();
			}
			@Override
			public Adapter caseExistingRole(ExistingRole object) {
				return createExistingRoleAdapter();
			}
			@Override
			public Adapter caseArrivingRole(ArrivingRole object) {
				return createArrivingRoleAdapter();
			}
			@Override
			public Adapter caseCondition(Condition object) {
				return createConditionAdapter();
			}
			@Override
			public Adapter caseGraphOperation(GraphOperation object) {
				return createGraphOperationAdapter();
			}
			@Override
			public Adapter caseInitial(Initial object) {
				return createInitialAdapter();
			}
			@Override
			public Adapter caseActivityFinal(ActivityFinal object) {
				return createActivityFinalAdapter();
			}
			@Override
			public Adapter caseFlowFinal(FlowFinal object) {
				return createFlowFinalAdapter();
			}
			@Override
			public Adapter caseFork(Fork object) {
				return createForkAdapter();
			}
			@Override
			public Adapter caseSpecializationAction(SpecializationAction object) {
				return createSpecializationActionAdapter();
			}
			@Override
			public Adapter caseIdleAction(IdleAction object) {
				return createIdleActionAdapter();
			}
			@Override
			public Adapter caseVariableRole(VariableRole object) {
				return createVariableRoleAdapter();
			}
			@Override
			public Adapter caseInheritsFrom(InheritsFrom object) {
				return createInheritsFromAdapter();
			}
			@Override
			public Adapter caseBelongsTo(BelongsTo object) {
				return createBelongsToAdapter();
			}
			@Override
			public Adapter caseRemoveNode(RemoveNode object) {
				return createRemoveNodeAdapter();
			}
			@Override
			public Adapter caseRemoveEdge(RemoveEdge object) {
				return createRemoveEdgeAdapter();
			}
			@Override
			public Adapter caseAddEdge(AddEdge object) {
				return createAddEdgeAdapter();
			}
			@Override
			public Adapter caseAddNode(AddNode object) {
				return createAddNodeAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.GraphTransformation <em>Graph Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.GraphTransformation
	 * @generated
	 */
	public Adapter createGraphTransformationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.LeftSide <em>Left Side</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.LeftSide
	 * @generated
	 */
	public Adapter createLeftSideAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.Roles <em>Roles</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.Roles
	 * @generated
	 */
	public Adapter createRolesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.ApplicationConditions <em>Application Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.ApplicationConditions
	 * @generated
	 */
	public Adapter createApplicationConditionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.Operations <em>Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.Operations
	 * @generated
	 */
	public Adapter createOperationsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.Edge
	 * @generated
	 */
	public Adapter createEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.ExistingRole <em>Existing Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.ExistingRole
	 * @generated
	 */
	public Adapter createExistingRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.ArrivingRole <em>Arriving Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.ArrivingRole
	 * @generated
	 */
	public Adapter createArrivingRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.GraphOperation <em>Graph Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.GraphOperation
	 * @generated
	 */
	public Adapter createGraphOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.Initial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.Initial
	 * @generated
	 */
	public Adapter createInitialAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.ActivityFinal <em>Activity Final</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.ActivityFinal
	 * @generated
	 */
	public Adapter createActivityFinalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.FlowFinal <em>Flow Final</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.FlowFinal
	 * @generated
	 */
	public Adapter createFlowFinalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.Fork <em>Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.Fork
	 * @generated
	 */
	public Adapter createForkAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.SpecializationAction <em>Specialization Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.SpecializationAction
	 * @generated
	 */
	public Adapter createSpecializationActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.IdleAction <em>Idle Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.IdleAction
	 * @generated
	 */
	public Adapter createIdleActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.VariableRole <em>Variable Role</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.VariableRole
	 * @generated
	 */
	public Adapter createVariableRoleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.InheritsFrom <em>Inherits From</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.InheritsFrom
	 * @generated
	 */
	public Adapter createInheritsFromAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.BelongsTo <em>Belongs To</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.BelongsTo
	 * @generated
	 */
	public Adapter createBelongsToAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.RemoveNode <em>Remove Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.RemoveNode
	 * @generated
	 */
	public Adapter createRemoveNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.RemoveEdge <em>Remove Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.RemoveEdge
	 * @generated
	 */
	public Adapter createRemoveEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.AddEdge <em>Add Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.AddEdge
	 * @generated
	 */
	public Adapter createAddEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.AddNode <em>Add Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.AddNode
	 * @generated
	 */
	public Adapter createAddNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.js.graph.transformation.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.js.graph.transformation.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //TransformationAdapterFactory
