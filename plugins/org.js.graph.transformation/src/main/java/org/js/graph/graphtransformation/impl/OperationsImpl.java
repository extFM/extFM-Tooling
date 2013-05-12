/**
 */
package org.js.graph.graphtransformation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.js.graph.graphtransformation.ChangePrimitive;
import org.js.graph.graphtransformation.GraphtransformationPackage;
import org.js.graph.graphtransformation.Operations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.graph.graphtransformation.impl.OperationsImpl#getChangePrimitives <em>Change Primitives</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationsImpl extends EObjectImpl implements Operations {
	/**
	 * The cached value of the '{@link #getChangePrimitives() <em>Change Primitives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangePrimitives()
	 * @generated
	 * @ordered
	 */
	protected EList<ChangePrimitive> changePrimitives;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphtransformationPackage.Literals.OPERATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ChangePrimitive> getChangePrimitives() {
		if (changePrimitives == null) {
			changePrimitives = new EObjectContainmentEList<ChangePrimitive>(ChangePrimitive.class, this, GraphtransformationPackage.OPERATIONS__CHANGE_PRIMITIVES);
		}
		return changePrimitives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphtransformationPackage.OPERATIONS__CHANGE_PRIMITIVES:
				return ((InternalEList<?>)getChangePrimitives()).basicRemove(otherEnd, msgs);
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
			case GraphtransformationPackage.OPERATIONS__CHANGE_PRIMITIVES:
				return getChangePrimitives();
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
			case GraphtransformationPackage.OPERATIONS__CHANGE_PRIMITIVES:
				getChangePrimitives().clear();
				getChangePrimitives().addAll((Collection<? extends ChangePrimitive>)newValue);
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
			case GraphtransformationPackage.OPERATIONS__CHANGE_PRIMITIVES:
				getChangePrimitives().clear();
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
			case GraphtransformationPackage.OPERATIONS__CHANGE_PRIMITIVES:
				return changePrimitives != null && !changePrimitives.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //OperationsImpl
