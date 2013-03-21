/**
 */
package org.js.model.workflow;

import org.eclipse.jwt.we.conf.model.AspectInstance;

import org.js.model.rbac.Role;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.model.workflow.RoleConnector#getRoleref <em>Roleref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.model.workflow.WorkflowPackage#getRoleConnector()
 * @model
 * @generated
 */
public interface RoleConnector extends AspectInstance {
	/**
	 * Returns the value of the '<em><b>Roleref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roleref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Roleref</em>' reference.
	 * @see #setRoleref(Role)
	 * @see org.js.model.workflow.WorkflowPackage#getRoleConnector_Roleref()
	 * @model
	 * @generated
	 */
	Role getRoleref();

	/**
	 * Sets the value of the '{@link org.js.model.workflow.RoleConnector#getRoleref <em>Roleref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Roleref</em>' reference.
	 * @see #getRoleref()
	 * @generated
	 */
	void setRoleref(Role value);

} // RoleConnector
