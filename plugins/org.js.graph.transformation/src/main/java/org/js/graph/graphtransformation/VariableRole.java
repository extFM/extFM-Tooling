/**
 */
package org.js.graph.graphtransformation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.graphtransformation.VariableRole#getAcion <em>Acion</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.graphtransformation.GraphtransformationPackage#getVariableRole()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface VariableRole extends Nameable {
	/**
	 * Returns the value of the '<em><b>Acion</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.js.graph.graphtransformation.SpecializationAction#getVariableRole <em>Variable Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acion</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acion</em>' reference.
	 * @see #setAcion(SpecializationAction)
	 * @see org.js.graph.graphtransformation.GraphtransformationPackage#getVariableRole_Acion()
	 * @see org.js.graph.graphtransformation.SpecializationAction#getVariableRole
	 * @model opposite="variableRole" required="true"
	 * @generated
	 */
	SpecializationAction getAcion();

	/**
	 * Sets the value of the '{@link org.js.graph.graphtransformation.VariableRole#getAcion <em>Acion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acion</em>' reference.
	 * @see #getAcion()
	 * @generated
	 */
	void setAcion(SpecializationAction value);

} // VariableRole
