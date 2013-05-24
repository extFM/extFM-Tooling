/**
 */
package org.js.graph.transformation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Left Side</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.LeftSide#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.js.graph.transformation.LeftSide#getEdges <em>Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getLeftSide()
 * @model
 * @generated
 */
public interface LeftSide extends EObject {
	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.js.graph.transformation.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.js.graph.transformation.TransformationPackage#getLeftSide_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNodes();

	/**
	 * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.js.graph.transformation.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edges</em>' containment reference list.
	 * @see org.js.graph.transformation.TransformationPackage#getLeftSide_Edges()
	 * @model containment="true"
	 * @generated
	 */
	EList<Edge> getEdges();

} // LeftSide
