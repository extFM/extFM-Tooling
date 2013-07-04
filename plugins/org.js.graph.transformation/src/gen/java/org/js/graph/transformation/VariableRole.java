/**
 */
package org.js.graph.transformation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.VariableRole#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getVariableRole()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface VariableRole extends Nameable {
	/**
    * Returns the value of the '<em><b>Action</b></em>' reference.
    * It is bidirectional and its opposite is '{@link org.js.graph.transformation.SpecializationAction#getVariableRole <em>Variable Role</em>}'.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Action</em>' reference.
    * @see #setAction(SpecializationAction)
    * @see org.js.graph.transformation.TransformationPackage#getVariableRole_Action()
    * @see org.js.graph.transformation.SpecializationAction#getVariableRole
    * @model opposite="variableRole" required="true"
    * @generated
    */
	SpecializationAction getAction();

	/**
    * Sets the value of the '{@link org.js.graph.transformation.VariableRole#getAction <em>Action</em>}' reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>Action</em>' reference.
    * @see #getAction()
    * @generated
    */
	void setAction(SpecializationAction value);

} // VariableRole
