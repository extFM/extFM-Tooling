/**
 */
package org.js.graph.transformation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specialization Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.SpecializationAction#getVariableRole <em>Variable Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getSpecializationAction()
 * @model
 * @generated
 */
public interface SpecializationAction extends Node {
	/**
    * Returns the value of the '<em><b>Variable Role</b></em>' reference.
    * It is bidirectional and its opposite is '{@link org.js.graph.transformation.VariableRole#getAction <em>Action</em>}'.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Role</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Variable Role</em>' reference.
    * @see #setVariableRole(VariableRole)
    * @see org.js.graph.transformation.TransformationPackage#getSpecializationAction_VariableRole()
    * @see org.js.graph.transformation.VariableRole#getAction
    * @model opposite="action" required="true"
    * @generated
    */
	VariableRole getVariableRole();

	/**
    * Sets the value of the '{@link org.js.graph.transformation.SpecializationAction#getVariableRole <em>Variable Role</em>}' reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>Variable Role</em>' reference.
    * @see #getVariableRole()
    * @generated
    */
	void setVariableRole(VariableRole value);

} // SpecializationAction
