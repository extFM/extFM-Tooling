/**
 */
package org.js.graph.transformation;


import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.Operations#getRemoveEdges <em>Remove Edges</em>}</li>
 *   <li>{@link org.js.graph.transformation.Operations#getRemoveNodes <em>Remove Nodes</em>}</li>
 *   <li>{@link org.js.graph.transformation.Operations#getAddNodes <em>Add Nodes</em>}</li>
 *   <li>{@link org.js.graph.transformation.Operations#getAddEdges <em>Add Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getOperations()
 * @model
 * @generated
 */
public interface Operations extends EObject {
	/**
	 * Returns the value of the '<em><b>Remove Edges</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove Edges</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove Edges</em>' containment reference.
	 * @see #setRemoveEdges(RemoveEdges)
	 * @see org.js.graph.transformation.TransformationPackage#getOperations_RemoveEdges()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RemoveEdges getRemoveEdges();

	/**
	 * Sets the value of the '{@link org.js.graph.transformation.Operations#getRemoveEdges <em>Remove Edges</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove Edges</em>' containment reference.
	 * @see #getRemoveEdges()
	 * @generated
	 */
	void setRemoveEdges(RemoveEdges value);

	/**
	 * Returns the value of the '<em><b>Remove Nodes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remove Nodes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remove Nodes</em>' containment reference.
	 * @see #setRemoveNodes(RemoveNodes)
	 * @see org.js.graph.transformation.TransformationPackage#getOperations_RemoveNodes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RemoveNodes getRemoveNodes();

	/**
	 * Sets the value of the '{@link org.js.graph.transformation.Operations#getRemoveNodes <em>Remove Nodes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remove Nodes</em>' containment reference.
	 * @see #getRemoveNodes()
	 * @generated
	 */
	void setRemoveNodes(RemoveNodes value);

	/**
	 * Returns the value of the '<em><b>Add Nodes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Nodes</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Nodes</em>' containment reference.
	 * @see #setAddNodes(AddNodes)
	 * @see org.js.graph.transformation.TransformationPackage#getOperations_AddNodes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AddNodes getAddNodes();

	/**
	 * Sets the value of the '{@link org.js.graph.transformation.Operations#getAddNodes <em>Add Nodes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Nodes</em>' containment reference.
	 * @see #getAddNodes()
	 * @generated
	 */
	void setAddNodes(AddNodes value);

	/**
	 * Returns the value of the '<em><b>Add Edges</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Edges</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Edges</em>' containment reference.
	 * @see #setAddEdges(AddEdges)
	 * @see org.js.graph.transformation.TransformationPackage#getOperations_AddEdges()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AddEdges getAddEdges();

	/**
	 * Sets the value of the '{@link org.js.graph.transformation.Operations#getAddEdges <em>Add Edges</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Edges</em>' containment reference.
	 * @see #getAddEdges()
	 * @generated
	 */
	void setAddEdges(AddEdges value);

} // Operations
