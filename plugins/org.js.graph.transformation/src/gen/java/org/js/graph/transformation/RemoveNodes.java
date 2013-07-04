/**
 */
package org.js.graph.transformation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remove Nodes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.RemoveNodes#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getRemoveNodes()
 * @model
 * @generated
 */
public interface RemoveNodes extends GraphOperation {
	/**
    * Returns the value of the '<em><b>Node</b></em>' reference list.
    * The list contents are of type {@link org.js.graph.transformation.Node}.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Node</em>' reference list.
    * @see org.js.graph.transformation.TransformationPackage#getRemoveNodes_Node()
    * @model
    * @generated
    */
	EList<Node> getNode();

} // RemoveNodes
