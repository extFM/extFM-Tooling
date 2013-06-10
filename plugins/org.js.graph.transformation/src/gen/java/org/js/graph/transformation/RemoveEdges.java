/**
 */
package org.js.graph.transformation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remove Edges</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.RemoveEdges#getEdge <em>Edge</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getRemoveEdges()
 * @model
 * @generated
 */
public interface RemoveEdges extends GraphOperation {
	/**
	 * Returns the value of the '<em><b>Edge</b></em>' reference list.
	 * The list contents are of type {@link org.js.graph.transformation.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge</em>' reference list.
	 * @see org.js.graph.transformation.TransformationPackage#getRemoveEdges_Edge()
	 * @model
	 * @generated
	 */
	EList<Edge> getEdge();

} // RemoveEdges
