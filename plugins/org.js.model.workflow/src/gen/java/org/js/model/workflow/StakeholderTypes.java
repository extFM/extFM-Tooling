/**
 */
package org.js.model.workflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.jwt.we.conf.model.AspectInstance;
import org.js.model.rbac.Role;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stakeholder Types</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.model.workflow.StakeholderTypes#getStakeholderTypes <em>Stakeholder Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.model.workflow.WorkflowPackage#getStakeholderTypes()
 * @model
 * @generated
 */
public interface StakeholderTypes extends AspectInstance {
	/**
	 * Returns the value of the '<em><b>Stakeholder Types</b></em>' reference list.
	 * The list contents are of type {@link org.js.model.rbac.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stakeholder Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stakeholder Types</em>' reference list.
	 * @see org.js.model.workflow.WorkflowPackage#getStakeholderTypes_StakeholderTypes()
	 * @model
	 * @generated
	 */
	EList<Role> getStakeholderTypes();

} // StakeholderTypes
