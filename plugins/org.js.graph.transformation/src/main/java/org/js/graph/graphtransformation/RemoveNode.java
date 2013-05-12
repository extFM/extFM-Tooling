/**
 */
package org.js.graph.graphtransformation;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Remove Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.graphtransformation.RemoveNode#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.graphtransformation.GraphtransformationPackage#getRemoveNode()
 * @model
 * @generated
 */
public interface RemoveNode extends ChangePrimitive {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference list.
	 * The list contents are of type {@link org.js.graph.graphtransformation.ActivityNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference list.
	 * @see org.js.graph.graphtransformation.GraphtransformationPackage#getRemoveNode_Node()
	 * @model
	 * @generated
	 */
	EList<ActivityNode> getNode();

} // RemoveNode
