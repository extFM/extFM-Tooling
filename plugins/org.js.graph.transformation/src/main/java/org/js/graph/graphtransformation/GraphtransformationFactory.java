/**
 */
package org.js.graph.graphtransformation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.js.graph.graphtransformation.GraphtransformationPackage
 * @generated
 */
public interface GraphtransformationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphtransformationFactory eINSTANCE = org.js.graph.graphtransformation.impl.GraphtransformationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Graph Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph Transformation</em>'.
	 * @generated
	 */
	GraphTransformation createGraphTransformation();

	/**
	 * Returns a new object of class '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule</em>'.
	 * @generated
	 */
	Rule createRule();

	/**
	 * Returns a new object of class '<em>Left Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Left Side</em>'.
	 * @generated
	 */
	LeftSide createLeftSide();

	/**
	 * Returns a new object of class '<em>Inherits From</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inherits From</em>'.
	 * @generated
	 */
	InheritsFrom createInheritsFrom();

	/**
	 * Returns a new object of class '<em>Belongs To</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Belongs To</em>'.
	 * @generated
	 */
	BelongsTo createBelongsTo();

	/**
	 * Returns a new object of class '<em>Operations</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operations</em>'.
	 * @generated
	 */
	Operations createOperations();

	/**
	 * Returns a new object of class '<em>Activity Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Edge</em>'.
	 * @generated
	 */
	ActivityEdge createActivityEdge();

	/**
	 * Returns a new object of class '<em>Initial Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Initial Node</em>'.
	 * @generated
	 */
	InitialNode createInitialNode();

	/**
	 * Returns a new object of class '<em>Activity Final Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Final Node</em>'.
	 * @generated
	 */
	ActivityFinalNode createActivityFinalNode();

	/**
	 * Returns a new object of class '<em>Flow Final Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow Final Node</em>'.
	 * @generated
	 */
	FlowFinalNode createFlowFinalNode();

	/**
	 * Returns a new object of class '<em>Fork Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fork Node</em>'.
	 * @generated
	 */
	ForkNode createForkNode();

	/**
	 * Returns a new object of class '<em>Specialization Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specialization Action</em>'.
	 * @generated
	 */
	SpecializationAction createSpecializationAction();

	/**
	 * Returns a new object of class '<em>Idle Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Idle Action</em>'.
	 * @generated
	 */
	IdleAction createIdleAction();

	/**
	 * Returns a new object of class '<em>Existing Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Existing Role</em>'.
	 * @generated
	 */
	ExistingRole createExistingRole();

	/**
	 * Returns a new object of class '<em>Arriving Role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arriving Role</em>'.
	 * @generated
	 */
	ArrivingRole createArrivingRole();

	/**
	 * Returns a new object of class '<em>Application Conditions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Application Conditions</em>'.
	 * @generated
	 */
	ApplicationConditions createApplicationConditions();

	/**
	 * Returns a new object of class '<em>Roles</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Roles</em>'.
	 * @generated
	 */
	Roles createRoles();

	/**
	 * Returns a new object of class '<em>Remove Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Node</em>'.
	 * @generated
	 */
	RemoveNode createRemoveNode();

	/**
	 * Returns a new object of class '<em>Remove Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Edge</em>'.
	 * @generated
	 */
	RemoveEdge createRemoveEdge();

	/**
	 * Returns a new object of class '<em>Add Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Edge</em>'.
	 * @generated
	 */
	AddEdge createAddEdge();

	/**
	 * Returns a new object of class '<em>Add Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Add Node</em>'.
	 * @generated
	 */
	AddNode createAddNode();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GraphtransformationPackage getGraphtransformationPackage();

} //GraphtransformationFactory
