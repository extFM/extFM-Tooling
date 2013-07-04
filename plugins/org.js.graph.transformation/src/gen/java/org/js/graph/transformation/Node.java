/**
 */
package org.js.graph.transformation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.Node#getIn <em>In</em>}</li>
 *   <li>{@link org.js.graph.transformation.Node#getOut <em>Out</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Node extends Nameable {
	/**
    * Returns the value of the '<em><b>In</b></em>' reference list.
    * The list contents are of type {@link org.js.graph.transformation.Edge}.
    * It is bidirectional and its opposite is '{@link org.js.graph.transformation.Edge#getTarget <em>Target</em>}'.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>In</em>' reference list.
    * @see org.js.graph.transformation.TransformationPackage#getNode_In()
    * @see org.js.graph.transformation.Edge#getTarget
    * @model opposite="target"
    * @generated
    */
	EList<Edge> getIn();

	/**
    * Returns the value of the '<em><b>Out</b></em>' reference list.
    * The list contents are of type {@link org.js.graph.transformation.Edge}.
    * It is bidirectional and its opposite is '{@link org.js.graph.transformation.Edge#getSource <em>Source</em>}'.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Out</em>' reference list.
    * @see org.js.graph.transformation.TransformationPackage#getNode_Out()
    * @see org.js.graph.transformation.Edge#getSource
    * @model opposite="source"
    * @generated
    */
	EList<Edge> getOut();

} // Node
