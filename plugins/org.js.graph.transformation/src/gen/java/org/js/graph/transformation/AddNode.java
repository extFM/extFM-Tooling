/**
 */
package org.js.graph.transformation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.AddNode#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getAddNode()
 * @model
 * @generated
 */
public interface AddNode extends ChangePrimitive {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference list.
	 * The list contents are of type {@link org.js.graph.transformation.Node}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference list.
	 * @see org.js.graph.transformation.TransformationPackage#getAddNode_Node()
	 * @model containment="true"
	 * @generated
	 */
	EList<Node> getNode();

} // AddNode
