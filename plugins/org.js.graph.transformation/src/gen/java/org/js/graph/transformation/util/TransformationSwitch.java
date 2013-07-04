/**
 */
package org.js.graph.transformation.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.js.graph.transformation.*;

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
 * @see org.js.graph.transformation.TransformationPackage
 * @generated
 */
public class TransformationSwitch<T> extends Switch<T> {
	/**
    * The cached model package
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected static TransformationPackage modelPackage;

	/**
    * Creates an instance of the switch.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public TransformationSwitch() {
      if (modelPackage == null) {
         modelPackage = TransformationPackage.eINSTANCE;
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
         case TransformationPackage.GRAPH_TRANSFORMATION: {
            GraphTransformation graphTransformation = (GraphTransformation)theEObject;
            T result = caseGraphTransformation(graphTransformation);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.RULE: {
            Rule rule = (Rule)theEObject;
            T result = caseRule(rule);
            if (result == null) result = caseNameable(rule);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.LEFT_SIDE: {
            LeftSide leftSide = (LeftSide)theEObject;
            T result = caseLeftSide(leftSide);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.ROLES: {
            Roles roles = (Roles)theEObject;
            T result = caseRoles(roles);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.APPLICATION_CONDITIONS: {
            ApplicationConditions applicationConditions = (ApplicationConditions)theEObject;
            T result = caseApplicationConditions(applicationConditions);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.OPERATIONS: {
            Operations operations = (Operations)theEObject;
            T result = caseOperations(operations);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.NODE: {
            Node node = (Node)theEObject;
            T result = caseNode(node);
            if (result == null) result = caseNameable(node);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.EDGE: {
            Edge edge = (Edge)theEObject;
            T result = caseEdge(edge);
            if (result == null) result = caseNameable(edge);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.EXISTING_ROLE: {
            ExistingRole existingRole = (ExistingRole)theEObject;
            T result = caseExistingRole(existingRole);
            if (result == null) result = caseVariableRole(existingRole);
            if (result == null) result = caseNameable(existingRole);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.ARRIVING_ROLE: {
            ArrivingRole arrivingRole = (ArrivingRole)theEObject;
            T result = caseArrivingRole(arrivingRole);
            if (result == null) result = caseVariableRole(arrivingRole);
            if (result == null) result = caseNameable(arrivingRole);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.CONDITION: {
            Condition condition = (Condition)theEObject;
            T result = caseCondition(condition);
            if (result == null) result = caseNameable(condition);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.GRAPH_OPERATION: {
            GraphOperation graphOperation = (GraphOperation)theEObject;
            T result = caseGraphOperation(graphOperation);
            if (result == null) result = caseNameable(graphOperation);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.INITIAL: {
            Initial initial = (Initial)theEObject;
            T result = caseInitial(initial);
            if (result == null) result = caseNode(initial);
            if (result == null) result = caseNameable(initial);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.ACTIVITY_FINAL: {
            ActivityFinal activityFinal = (ActivityFinal)theEObject;
            T result = caseActivityFinal(activityFinal);
            if (result == null) result = caseNode(activityFinal);
            if (result == null) result = caseNameable(activityFinal);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.FLOW_FINAL: {
            FlowFinal flowFinal = (FlowFinal)theEObject;
            T result = caseFlowFinal(flowFinal);
            if (result == null) result = caseNode(flowFinal);
            if (result == null) result = caseNameable(flowFinal);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.FORK: {
            Fork fork = (Fork)theEObject;
            T result = caseFork(fork);
            if (result == null) result = caseNode(fork);
            if (result == null) result = caseNameable(fork);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.SPECIALIZATION_ACTION: {
            SpecializationAction specializationAction = (SpecializationAction)theEObject;
            T result = caseSpecializationAction(specializationAction);
            if (result == null) result = caseNode(specializationAction);
            if (result == null) result = caseNameable(specializationAction);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.IDLE_ACTION: {
            IdleAction idleAction = (IdleAction)theEObject;
            T result = caseIdleAction(idleAction);
            if (result == null) result = caseNode(idleAction);
            if (result == null) result = caseNameable(idleAction);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.VARIABLE_ROLE: {
            VariableRole variableRole = (VariableRole)theEObject;
            T result = caseVariableRole(variableRole);
            if (result == null) result = caseNameable(variableRole);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.INHERITS_FROM: {
            InheritsFrom inheritsFrom = (InheritsFrom)theEObject;
            T result = caseInheritsFrom(inheritsFrom);
            if (result == null) result = caseCondition(inheritsFrom);
            if (result == null) result = caseNameable(inheritsFrom);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.BELONGS_TO: {
            BelongsTo belongsTo = (BelongsTo)theEObject;
            T result = caseBelongsTo(belongsTo);
            if (result == null) result = caseCondition(belongsTo);
            if (result == null) result = caseNameable(belongsTo);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.REMOVE_NODES: {
            RemoveNodes removeNodes = (RemoveNodes)theEObject;
            T result = caseRemoveNodes(removeNodes);
            if (result == null) result = caseGraphOperation(removeNodes);
            if (result == null) result = caseNameable(removeNodes);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.REMOVE_EDGES: {
            RemoveEdges removeEdges = (RemoveEdges)theEObject;
            T result = caseRemoveEdges(removeEdges);
            if (result == null) result = caseGraphOperation(removeEdges);
            if (result == null) result = caseNameable(removeEdges);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.ADD_EDGES: {
            AddEdges addEdges = (AddEdges)theEObject;
            T result = caseAddEdges(addEdges);
            if (result == null) result = caseGraphOperation(addEdges);
            if (result == null) result = caseNameable(addEdges);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.ADD_NODES: {
            AddNodes addNodes = (AddNodes)theEObject;
            T result = caseAddNodes(addNodes);
            if (result == null) result = caseGraphOperation(addNodes);
            if (result == null) result = caseNameable(addNodes);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TransformationPackage.NAMEABLE: {
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
    * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Node</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseNode(Node object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseEdge(Edge object) {
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
    * Returns the result of interpreting the object as an instance of '<em>Graph Operation</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Graph Operation</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseGraphOperation(GraphOperation object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Initial</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Initial</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseInitial(Initial object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Activity Final</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Activity Final</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseActivityFinal(ActivityFinal object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Flow Final</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Flow Final</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseFlowFinal(FlowFinal object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Fork</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Fork</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseFork(Fork object) {
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
    * Returns the result of interpreting the object as an instance of '<em>Remove Nodes</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Remove Nodes</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseRemoveNodes(RemoveNodes object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Remove Edges</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Remove Edges</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseRemoveEdges(RemoveEdges object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Add Edges</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Add Edges</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseAddEdges(AddEdges object) {
      return null;
   }

	/**
    * Returns the result of interpreting the object as an instance of '<em>Add Nodes</em>'.
    * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Add Nodes</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
	public T caseAddNodes(AddNodes object) {
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

} //TransformationSwitch
