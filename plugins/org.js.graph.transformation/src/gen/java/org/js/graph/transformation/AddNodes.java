/**
 */
package org.js.graph.transformation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Nodes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.AddNodes#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getAddNodes()
 * @model
 * @generated
 */
public interface AddNodes extends GraphOperation {
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
    * @see org.js.graph.transformation.TransformationPackage#getAddNodes_Node()
    * @model containment="true"
    * @generated
    */
	EList<Node> getNode();

} // AddNodes
