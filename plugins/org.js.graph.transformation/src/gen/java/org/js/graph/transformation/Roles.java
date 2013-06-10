/**
 */
package org.js.graph.transformation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Roles</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.Roles#getExistingRoles <em>Existing Roles</em>}</li>
 *   <li>{@link org.js.graph.transformation.Roles#getArrivingRole <em>Arriving Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getRoles()
 * @model
 * @generated
 */
public interface Roles extends EObject {
	/**
	 * Returns the value of the '<em><b>Existing Roles</b></em>' containment reference list.
	 * The list contents are of type {@link org.js.graph.transformation.ExistingRole}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Existing Roles</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Existing Roles</em>' containment reference list.
	 * @see org.js.graph.transformation.TransformationPackage#getRoles_ExistingRoles()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExistingRole> getExistingRoles();

	/**
	 * Returns the value of the '<em><b>Arriving Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arriving Role</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arriving Role</em>' containment reference.
	 * @see #setArrivingRole(ArrivingRole)
	 * @see org.js.graph.transformation.TransformationPackage#getRoles_ArrivingRole()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ArrivingRole getArrivingRole();

	/**
	 * Sets the value of the '{@link org.js.graph.transformation.Roles#getArrivingRole <em>Arriving Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arriving Role</em>' containment reference.
	 * @see #getArrivingRole()
	 * @generated
	 */
	void setArrivingRole(ArrivingRole value);

} // Roles
