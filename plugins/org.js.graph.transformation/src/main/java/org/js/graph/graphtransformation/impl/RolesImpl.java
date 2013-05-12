/**
 */
package org.js.graph.graphtransformation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.js.graph.graphtransformation.ArrivingRole;
import org.js.graph.graphtransformation.ExistingRole;
import org.js.graph.graphtransformation.GraphtransformationPackage;
import org.js.graph.graphtransformation.Roles;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Roles</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.graph.graphtransformation.impl.RolesImpl#getExistingRoles <em>Existing Roles</em>}</li>
 *   <li>{@link org.js.graph.graphtransformation.impl.RolesImpl#getArrivingRole <em>Arriving Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RolesImpl extends EObjectImpl implements Roles {
	/**
	 * The cached value of the '{@link #getExistingRoles() <em>Existing Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExistingRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<ExistingRole> existingRoles;

	/**
	 * The cached value of the '{@link #getArrivingRole() <em>Arriving Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArrivingRole()
	 * @generated
	 * @ordered
	 */
	protected ArrivingRole arrivingRole;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RolesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphtransformationPackage.Literals.ROLES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrivingRole getArrivingRole() {
		return arrivingRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArrivingRole(ArrivingRole newArrivingRole, NotificationChain msgs) {
		ArrivingRole oldArrivingRole = arrivingRole;
		arrivingRole = newArrivingRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.ROLES__ARRIVING_ROLE, oldArrivingRole, newArrivingRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArrivingRole(ArrivingRole newArrivingRole) {
		if (newArrivingRole != arrivingRole) {
			NotificationChain msgs = null;
			if (arrivingRole != null)
				msgs = ((InternalEObject)arrivingRole).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphtransformationPackage.ROLES__ARRIVING_ROLE, null, msgs);
			if (newArrivingRole != null)
				msgs = ((InternalEObject)newArrivingRole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphtransformationPackage.ROLES__ARRIVING_ROLE, null, msgs);
			msgs = basicSetArrivingRole(newArrivingRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.ROLES__ARRIVING_ROLE, newArrivingRole, newArrivingRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExistingRole> getExistingRoles() {
		if (existingRoles == null) {
			existingRoles = new EObjectContainmentEList<ExistingRole>(ExistingRole.class, this, GraphtransformationPackage.ROLES__EXISTING_ROLES);
		}
		return existingRoles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphtransformationPackage.ROLES__EXISTING_ROLES:
				return ((InternalEList<?>)getExistingRoles()).basicRemove(otherEnd, msgs);
			case GraphtransformationPackage.ROLES__ARRIVING_ROLE:
				return basicSetArrivingRole(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphtransformationPackage.ROLES__EXISTING_ROLES:
				return getExistingRoles();
			case GraphtransformationPackage.ROLES__ARRIVING_ROLE:
				return getArrivingRole();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphtransformationPackage.ROLES__EXISTING_ROLES:
				getExistingRoles().clear();
				getExistingRoles().addAll((Collection<? extends ExistingRole>)newValue);
				return;
			case GraphtransformationPackage.ROLES__ARRIVING_ROLE:
				setArrivingRole((ArrivingRole)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GraphtransformationPackage.ROLES__EXISTING_ROLES:
				getExistingRoles().clear();
				return;
			case GraphtransformationPackage.ROLES__ARRIVING_ROLE:
				setArrivingRole((ArrivingRole)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GraphtransformationPackage.ROLES__EXISTING_ROLES:
				return existingRoles != null && !existingRoles.isEmpty();
			case GraphtransformationPackage.ROLES__ARRIVING_ROLE:
				return arrivingRole != null;
		}
		return super.eIsSet(featureID);
	}

} //RolesImpl
