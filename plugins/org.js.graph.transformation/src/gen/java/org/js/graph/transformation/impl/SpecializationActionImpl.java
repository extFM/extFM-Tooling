/**
 */
package org.js.graph.transformation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.js.graph.transformation.Edge;
import org.js.graph.transformation.SpecializationAction;
import org.js.graph.transformation.TransformationPackage;
import org.js.graph.transformation.VariableRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specialization Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.graph.transformation.impl.SpecializationActionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.js.graph.transformation.impl.SpecializationActionImpl#getIn <em>In</em>}</li>
 *   <li>{@link org.js.graph.transformation.impl.SpecializationActionImpl#getOut <em>Out</em>}</li>
 *   <li>{@link org.js.graph.transformation.impl.SpecializationActionImpl#getVariableRole <em>Variable Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecializationActionImpl extends MinimalEObjectImpl.Container implements SpecializationAction {
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
	 * The cached value of the '{@link #getIn() <em>In</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIn()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> in;

	/**
	 * The cached value of the '{@link #getOut() <em>Out</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOut()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> out;

	/**
	 * The cached value of the '{@link #getVariableRole() <em>Variable Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableRole()
	 * @generated
	 * @ordered
	 */
	protected VariableRole variableRole;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecializationActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransformationPackage.Literals.SPECIALIZATION_ACTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.SPECIALIZATION_ACTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getIn() {
		if (in == null) {
			in = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, TransformationPackage.SPECIALIZATION_ACTION__IN, TransformationPackage.EDGE__TARGET);
		}
		return in;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getOut() {
		if (out == null) {
			out = new EObjectWithInverseResolvingEList<Edge>(Edge.class, this, TransformationPackage.SPECIALIZATION_ACTION__OUT, TransformationPackage.EDGE__SOURCE);
		}
		return out;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableRole getVariableRole() {
		if (variableRole != null && variableRole.eIsProxy()) {
			InternalEObject oldVariableRole = (InternalEObject)variableRole;
			variableRole = (VariableRole)eResolveProxy(oldVariableRole);
			if (variableRole != oldVariableRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE, oldVariableRole, variableRole));
			}
		}
		return variableRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableRole basicGetVariableRole() {
		return variableRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableRole(VariableRole newVariableRole, NotificationChain msgs) {
		VariableRole oldVariableRole = variableRole;
		variableRole = newVariableRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE, oldVariableRole, newVariableRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableRole(VariableRole newVariableRole) {
		if (newVariableRole != variableRole) {
			NotificationChain msgs = null;
			if (variableRole != null)
				msgs = ((InternalEObject)variableRole).eInverseRemove(this, TransformationPackage.VARIABLE_ROLE__ACTION, VariableRole.class, msgs);
			if (newVariableRole != null)
				msgs = ((InternalEObject)newVariableRole).eInverseAdd(this, TransformationPackage.VARIABLE_ROLE__ACTION, VariableRole.class, msgs);
			msgs = basicSetVariableRole(newVariableRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE, newVariableRole, newVariableRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransformationPackage.SPECIALIZATION_ACTION__IN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIn()).basicAdd(otherEnd, msgs);
			case TransformationPackage.SPECIALIZATION_ACTION__OUT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOut()).basicAdd(otherEnd, msgs);
			case TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE:
				if (variableRole != null)
					msgs = ((InternalEObject)variableRole).eInverseRemove(this, TransformationPackage.VARIABLE_ROLE__ACTION, VariableRole.class, msgs);
				return basicSetVariableRole((VariableRole)otherEnd, msgs);
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
			case TransformationPackage.SPECIALIZATION_ACTION__IN:
				return ((InternalEList<?>)getIn()).basicRemove(otherEnd, msgs);
			case TransformationPackage.SPECIALIZATION_ACTION__OUT:
				return ((InternalEList<?>)getOut()).basicRemove(otherEnd, msgs);
			case TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE:
				return basicSetVariableRole(null, msgs);
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
			case TransformationPackage.SPECIALIZATION_ACTION__NAME:
				return getName();
			case TransformationPackage.SPECIALIZATION_ACTION__IN:
				return getIn();
			case TransformationPackage.SPECIALIZATION_ACTION__OUT:
				return getOut();
			case TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE:
				if (resolve) return getVariableRole();
				return basicGetVariableRole();
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
			case TransformationPackage.SPECIALIZATION_ACTION__NAME:
				setName((String)newValue);
				return;
			case TransformationPackage.SPECIALIZATION_ACTION__IN:
				getIn().clear();
				getIn().addAll((Collection<? extends Edge>)newValue);
				return;
			case TransformationPackage.SPECIALIZATION_ACTION__OUT:
				getOut().clear();
				getOut().addAll((Collection<? extends Edge>)newValue);
				return;
			case TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE:
				setVariableRole((VariableRole)newValue);
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
			case TransformationPackage.SPECIALIZATION_ACTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TransformationPackage.SPECIALIZATION_ACTION__IN:
				getIn().clear();
				return;
			case TransformationPackage.SPECIALIZATION_ACTION__OUT:
				getOut().clear();
				return;
			case TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE:
				setVariableRole((VariableRole)null);
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
			case TransformationPackage.SPECIALIZATION_ACTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TransformationPackage.SPECIALIZATION_ACTION__IN:
				return in != null && !in.isEmpty();
			case TransformationPackage.SPECIALIZATION_ACTION__OUT:
				return out != null && !out.isEmpty();
			case TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE:
				return variableRole != null;
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

} //SpecializationActionImpl
