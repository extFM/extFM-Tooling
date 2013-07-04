/**
 */
package org.js.graph.transformation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.GraphTransformation#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getGraphTransformation()
 * @model
 * @generated
 */
public interface GraphTransformation extends EObject {
	/**
    * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
    * The list contents are of type {@link org.js.graph.transformation.Rule}.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Rules</em>' containment reference list.
    * @see org.js.graph.transformation.TransformationPackage#getGraphTransformation_Rules()
    * @model containment="true"
    * @generated
    */
	EList<Rule> getRules();

} // GraphTransformation
