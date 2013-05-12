/**
 */
package org.js.graph.graphtransformation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Belongs To</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.graphtransformation.BelongsTo#getLeader <em>Leader</em>}</li>
 *   <li>{@link org.js.graph.graphtransformation.BelongsTo#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.graphtransformation.GraphtransformationPackage#getBelongsTo()
 * @model
 * @generated
 */
public interface BelongsTo extends Condition {
	/**
	 * Returns the value of the '<em><b>Leader</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leader</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leader</em>' reference.
	 * @see #setLeader(VariableRole)
	 * @see org.js.graph.graphtransformation.GraphtransformationPackage#getBelongsTo_Leader()
	 * @model required="true"
	 * @generated
	 */
	VariableRole getLeader();

	/**
	 * Sets the value of the '{@link org.js.graph.graphtransformation.BelongsTo#getLeader <em>Leader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leader</em>' reference.
	 * @see #getLeader()
	 * @generated
	 */
	void setLeader(VariableRole value);

	/**
	 * Returns the value of the '<em><b>Member</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' reference.
	 * @see #setMember(VariableRole)
	 * @see org.js.graph.graphtransformation.GraphtransformationPackage#getBelongsTo_Member()
	 * @model required="true"
	 * @generated
	 */
	VariableRole getMember();

	/**
	 * Sets the value of the '{@link org.js.graph.graphtransformation.BelongsTo#getMember <em>Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Member</em>' reference.
	 * @see #getMember()
	 * @generated
	 */
	void setMember(VariableRole value);

} // BelongsTo
