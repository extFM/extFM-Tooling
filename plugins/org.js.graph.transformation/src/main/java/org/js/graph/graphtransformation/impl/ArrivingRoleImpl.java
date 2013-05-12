/**
 */
package org.js.graph.graphtransformation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.js.graph.graphtransformation.ArrivingRole;
import org.js.graph.graphtransformation.GraphtransformationPackage;
import org.js.graph.graphtransformation.SpecializationAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arriving Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.graph.graphtransformation.impl.ArrivingRoleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.js.graph.graphtransformation.impl.ArrivingRoleImpl#getAcion <em>Acion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrivingRoleImpl extends EObjectImpl implements ArrivingRole {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAcion() <em>Acion</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcion()
	 * @generated
	 * @ordered
	 */
	protected SpecializationAction acion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrivingRoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphtransformationPackage.Literals.ARRIVING_ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.ARRIVING_ROLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializationAction getAcion() {
		if (acion != null && acion.eIsProxy()) {
			InternalEObject oldAcion = (InternalEObject)acion;
			acion = (SpecializationAction)eResolveProxy(oldAcion);
			if (acion != oldAcion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphtransformationPackage.ARRIVING_ROLE__ACION, oldAcion, acion));
			}
		}
		return acion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializationAction basicGetAcion() {
		return acion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAcion(SpecializationAction newAcion, NotificationChain msgs) {
		SpecializationAction oldAcion = acion;
		acion = newAcion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.ARRIVING_ROLE__ACION, oldAcion, newAcion);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAcion(SpecializationAction newAcion) {
		if (newAcion != acion) {
			NotificationChain msgs = null;
			if (acion != null)
				msgs = ((InternalEObject)acion).eInverseRemove(this, GraphtransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE, SpecializationAction.class, msgs);
			if (newAcion != null)
				msgs = ((InternalEObject)newAcion).eInverseAdd(this, GraphtransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE, SpecializationAction.class, msgs);
			msgs = basicSetAcion(newAcion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.ARRIVING_ROLE__ACION, newAcion, newAcion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphtransformationPackage.ARRIVING_ROLE__ACION:
				if (acion != null)
					msgs = ((InternalEObject)acion).eInverseRemove(this, GraphtransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE, SpecializationAction.class, msgs);
				return basicSetAcion((SpecializationAction)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphtransformationPackage.ARRIVING_ROLE__ACION:
				return basicSetAcion(null, msgs);
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
			case GraphtransformationPackage.ARRIVING_ROLE__NAME:
				return getName();
			case GraphtransformationPackage.ARRIVING_ROLE__ACION:
				if (resolve) return getAcion();
				return basicGetAcion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GraphtransformationPackage.ARRIVING_ROLE__NAME:
				setName((String)newValue);
				return;
			case GraphtransformationPackage.ARRIVING_ROLE__ACION:
				setAcion((SpecializationAction)newValue);
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
			case GraphtransformationPackage.ARRIVING_ROLE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphtransformationPackage.ARRIVING_ROLE__ACION:
				setAcion((SpecializationAction)null);
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
			case GraphtransformationPackage.ARRIVING_ROLE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphtransformationPackage.ARRIVING_ROLE__ACION:
				return acion != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ArrivingRoleImpl
