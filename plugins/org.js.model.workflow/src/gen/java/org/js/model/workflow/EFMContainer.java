/**
 */
package org.js.model.workflow;

import org.eclipse.jwt.we.conf.model.AspectInstance;

import org.js.model.feature.FeatureModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EFM Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.model.workflow.EFMContainer#getEfmref <em>Efmref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.model.workflow.WorkflowPackage#getEFMContainer()
 * @model
 * @generated
 */
public interface EFMContainer extends AspectInstance {
	/**
	 * Returns the value of the '<em><b>Efmref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Efmref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Efmref</em>' containment reference.
	 * @see #setEfmref(FeatureModel)
	 * @see org.js.model.workflow.WorkflowPackage#getEFMContainer_Efmref()
	 * @model containment="true"
	 * @generated
	 */
	FeatureModel getEfmref();

	/**
	 * Sets the value of the '{@link org.js.model.workflow.EFMContainer#getEfmref <em>Efmref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Efmref</em>' containment reference.
	 * @see #getEfmref()
	 * @generated
	 */
	void setEfmref(FeatureModel value);

} // EFMContainer
