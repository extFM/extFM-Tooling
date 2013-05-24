/**
 */
package org.js.model.workflow;


import org.eclipse.jwt.we.conf.model.AspectInstance;
import org.js.model.rbac.AccessControlModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ACM Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.model.workflow.ACMConnector#getAcmref <em>Acmref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.model.workflow.WorkflowPackage#getACMConnector()
 * @model
 * @generated
 */
public interface ACMConnector extends AspectInstance {
	/**
	 * Returns the value of the '<em><b>Acmref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Acmref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Acmref</em>' reference.
	 * @see #setAcmref(AccessControlModel)
	 * @see org.js.model.workflow.WorkflowPackage#getACMConnector_Acmref()
	 * @model
	 * @generated
	 */
	AccessControlModel getAcmref();

	/**
	 * Sets the value of the '{@link org.js.model.workflow.ACMConnector#getAcmref <em>Acmref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Acmref</em>' reference.
	 * @see #getAcmref()
	 * @generated
	 */
	void setAcmref(AccessControlModel value);

} // ACMConnector
