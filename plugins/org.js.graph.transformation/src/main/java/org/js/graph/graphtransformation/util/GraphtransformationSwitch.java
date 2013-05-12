/**
 */
package org.js.graph.graphtransformation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.js.graph.graphtransformation.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.js.graph.graphtransformation.GraphtransformationPackage
 * @generated
 */
public class GraphtransformationSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphtransformationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphtransformationSwitch() {
		if (modelPackage == null) {
			modelPackage = GraphtransformationPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GraphtransformationPackage.GRAPH_TRANSFORMATION: {
				GraphTransformation graphTransformation = (GraphTransformation)theEObject;
				T result = caseGraphTransformation(graphTransformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseNameable(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.LEFT_SIDE: {
				LeftSide leftSide = (LeftSide)theEObject;
				T result = caseLeftSide(leftSide);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.ROLES: {
				Roles roles = (Roles)theEObject;
				T result = caseRoles(roles);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.APPLICATION_CONDITIONS: {
				ApplicationConditions applicationConditions = (ApplicationConditions)theEObject;
				T result = caseApplicationConditions(applicationConditions);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.OPERATIONS: {
				Operations operations = (Operations)theEObject;
				T result = caseOperations(operations);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.ACTIVITY_NODE: {
				ActivityNode activityNode = (ActivityNode)theEObject;
				T result = caseActivityNode(activityNode);
				if (result == null) result = caseNameable(activityNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.ACTIVITY_EDGE: {
				ActivityEdge activityEdge = (ActivityEdge)theEObject;
				T result = caseActivityEdge(activityEdge);
				if (result == null) result = caseNameable(activityEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.EXISTING_ROLE: {
				ExistingRole existingRole = (ExistingRole)theEObject;
				T result = caseExistingRole(existingRole);
				if (result == null) result = caseVariableRole(existingRole);
				if (result == null) result = caseNameable(existingRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.ARRIVING_ROLE: {
				ArrivingRole arrivingRole = (ArrivingRole)theEObject;
				T result = caseArrivingRole(arrivingRole);
				if (result == null) result = caseVariableRole(arrivingRole);
				if (result == null) result = caseNameable(arrivingRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.CONDITION: {
				Condition condition = (Condition)theEObject;
				T result = caseCondition(condition);
				if (result == null) result = caseNameable(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.CHANGE_PRIMITIVE: {
				ChangePrimitive changePrimitive = (ChangePrimitive)theEObject;
				T result = caseChangePrimitive(changePrimitive);
				if (result == null) result = caseNameable(changePrimitive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.INITIAL_NODE: {
				InitialNode initialNode = (InitialNode)theEObject;
				T result = caseInitialNode(initialNode);
				if (result == null) result = caseActivityNode(initialNode);
				if (result == null) result = caseNameable(initialNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.ACTIVITY_FINAL_NODE: {
				ActivityFinalNode activityFinalNode = (ActivityFinalNode)theEObject;
				T result = caseActivityFinalNode(activityFinalNode);
				if (result == null) result = caseActivityNode(activityFinalNode);
				if (result == null) result = caseNameable(activityFinalNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.FLOW_FINAL_NODE: {
				FlowFinalNode flowFinalNode = (FlowFinalNode)theEObject;
				T result = caseFlowFinalNode(flowFinalNode);
				if (result == null) result = caseActivityNode(flowFinalNode);
				if (result == null) result = caseNameable(flowFinalNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.FORK_NODE: {
				ForkNode forkNode = (ForkNode)theEObject;
				T result = caseForkNode(forkNode);
				if (result == null) result = caseActivityNode(forkNode);
				if (result == null) result = caseNameable(forkNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseActivityNode(action);
				if (result == null) result = caseNameable(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.SPECIALIZATION_ACTION: {
				SpecializationAction specializationAction = (SpecializationAction)theEObject;
				T result = caseSpecializationAction(specializationAction);
				if (result == null) result = caseAction(specializationAction);
				if (result == null) result = caseActivityNode(specializationAction);
				if (result == null) result = caseNameable(specializationAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.IDLE_ACTION: {
				IdleAction idleAction = (IdleAction)theEObject;
				T result = caseIdleAction(idleAction);
				if (result == null) result = caseAction(idleAction);
				if (result == null) result = caseActivityNode(idleAction);
				if (result == null) result = caseNameable(idleAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.VARIABLE_ROLE: {
				VariableRole variableRole = (VariableRole)theEObject;
				T result = caseVariableRole(variableRole);
				if (result == null) result = caseNameable(variableRole);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.INHERITS_FROM: {
				InheritsFrom inheritsFrom = (InheritsFrom)theEObject;
				T result = caseInheritsFrom(inheritsFrom);
				if (result == null) result = caseCondition(inheritsFrom);
				if (result == null) result = caseNameable(inheritsFrom);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.BELONGS_TO: {
				BelongsTo belongsTo = (BelongsTo)theEObject;
				T result = caseBelongsTo(belongsTo);
				if (result == null) result = caseCondition(belongsTo);
				if (result == null) result = caseNameable(belongsTo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.REMOVE_NODE: {
				RemoveNode removeNode = (RemoveNode)theEObject;
				T result = caseRemoveNode(removeNode);
				if (result == null) result = caseChangePrimitive(removeNode);
				if (result == null) result = caseNameable(removeNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.REMOVE_EDGE: {
				RemoveEdge removeEdge = (RemoveEdge)theEObject;
				T result = caseRemoveEdge(removeEdge);
				if (result == null) result = caseChangePrimitive(removeEdge);
				if (result == null) result = caseNameable(removeEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.ADD_EDGE: {
				AddEdge addEdge = (AddEdge)theEObject;
				T result = caseAddEdge(addEdge);
				if (result == null) result = caseChangePrimitive(addEdge);
				if (result == null) result = caseNameable(addEdge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.ADD_NODE: {
				AddNode addNode = (AddNode)theEObject;
				T result = caseAddNode(addNode);
				if (result == null) result = caseChangePrimitive(addNode);
				if (result == null) result = caseNameable(addNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphtransformationPackage.NAMEABLE: {
				Nameable nameable = (Nameable)theEObject;
				T result = caseNameable(nameable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphTransformation(GraphTransformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Left Side</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Left Side</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLeftSide(LeftSide object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inherits From</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inherits From</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInheritsFrom(InheritsFrom object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Belongs To</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Belongs To</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBelongsTo(BelongsTo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operations</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operations</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperations(Operations object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityEdge(ActivityEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityNode(ActivityNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initial Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initial Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitialNode(InitialNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Final Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Final Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityFinalNode(ActivityFinalNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Final Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Final Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowFinalNode(FlowFinalNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fork Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fork Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForkNode(ForkNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specialization Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specialization Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecializationAction(SpecializationAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Idle Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Idle Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdleAction(IdleAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableRole(VariableRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Existing Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Existing Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExistingRole(ExistingRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arriving Role</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arriving Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrivingRole(ArrivingRole object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Conditions</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Conditions</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseApplicationConditions(ApplicationConditions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Roles</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Roles</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoles(Roles object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveNode(RemoveNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveEdge(RemoveEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Change Primitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Change Primitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChangePrimitive(ChangePrimitive object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddEdge(AddEdge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Add Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Add Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAddNode(AddNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //GraphtransformationSwitch
