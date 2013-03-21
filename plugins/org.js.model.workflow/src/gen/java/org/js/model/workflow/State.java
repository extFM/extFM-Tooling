/**
 */
package org.js.model.workflow;

import org.eclipse.jwt.we.conf.model.AspectInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.model.workflow.State#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.model.workflow.WorkflowPackage#getState()
 * @model
 * @generated
 */
public interface State extends AspectInstance {
	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link org.js.model.workflow.StateEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see org.js.model.workflow.StateEnum
	 * @see #setState(StateEnum)
	 * @see org.js.model.workflow.WorkflowPackage#getState_State()
	 * @model
	 * @generated
	 */
	StateEnum getState();

	/**
	 * Sets the value of the '{@link org.js.model.workflow.State#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see org.js.model.workflow.StateEnum
	 * @see #getState()
	 * @generated
	 */
	void setState(StateEnum value);

} // State
