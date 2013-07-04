/**
 */
package org.js.graph.transformation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.js.graph.transformation.TransformationPackage
 * @generated
 */
public interface TransformationFactory extends EFactory {
	/**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	TransformationFactory eINSTANCE = org.js.graph.transformation.impl.TransformationFactoryImpl.init();

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
    * Returns a new object of class '<em>Roles</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Roles</em>'.
    * @generated
    */
	Roles createRoles();

	/**
    * Returns a new object of class '<em>Application Conditions</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Application Conditions</em>'.
    * @generated
    */
	ApplicationConditions createApplicationConditions();

	/**
    * Returns a new object of class '<em>Operations</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Operations</em>'.
    * @generated
    */
	Operations createOperations();

	/**
    * Returns a new object of class '<em>Edge</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Edge</em>'.
    * @generated
    */
	Edge createEdge();

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
    * Returns a new object of class '<em>Initial</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Initial</em>'.
    * @generated
    */
	Initial createInitial();

	/**
    * Returns a new object of class '<em>Activity Final</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Activity Final</em>'.
    * @generated
    */
	ActivityFinal createActivityFinal();

	/**
    * Returns a new object of class '<em>Flow Final</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Flow Final</em>'.
    * @generated
    */
	FlowFinal createFlowFinal();

	/**
    * Returns a new object of class '<em>Fork</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Fork</em>'.
    * @generated
    */
	Fork createFork();

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
    * Returns a new object of class '<em>Remove Nodes</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Remove Nodes</em>'.
    * @generated
    */
	RemoveNodes createRemoveNodes();

	/**
    * Returns a new object of class '<em>Remove Edges</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Remove Edges</em>'.
    * @generated
    */
	RemoveEdges createRemoveEdges();

	/**
    * Returns a new object of class '<em>Add Edges</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Add Edges</em>'.
    * @generated
    */
	AddEdges createAddEdges();

	/**
    * Returns a new object of class '<em>Add Nodes</em>'.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return a new object of class '<em>Add Nodes</em>'.
    * @generated
    */
	AddNodes createAddNodes();

	/**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
	TransformationPackage getTransformationPackage();

} //TransformationFactory
