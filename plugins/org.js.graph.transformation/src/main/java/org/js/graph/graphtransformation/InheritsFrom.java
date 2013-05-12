/**
 */
package org.js.graph.graphtransformation;

import org.js.model.rbac.Role;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inherits From</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.graphtransformation.InheritsFrom#getParent <em>Parent</em>}</li>
 *   <li>{@link org.js.graph.graphtransformation.InheritsFrom#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.graphtransformation.GraphtransformationPackage#getInheritsFrom()
 * @model
 * @generated
 */
public interface InheritsFrom extends Condition {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Role)
	 * @see org.js.graph.graphtransformation.GraphtransformationPackage#getInheritsFrom_Parent()
	 * @model required="true"
	 * @generated
	 */
	Role getParent();

	/**
	 * Sets the value of the '{@link org.js.graph.graphtransformation.InheritsFrom#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Role value);

	/**
	 * Returns the value of the '<em><b>Child</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child</em>' reference.
	 * @see #setChild(VariableRole)
	 * @see org.js.graph.graphtransformation.GraphtransformationPackage#getInheritsFrom_Child()
	 * @model required="true"
	 * @generated
	 */
	VariableRole getChild();

	/**
	 * Sets the value of the '{@link org.js.graph.graphtransformation.InheritsFrom#getChild <em>Child</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child</em>' reference.
	 * @see #getChild()
	 * @generated
	 */
	void setChild(VariableRole value);

} // InheritsFrom
