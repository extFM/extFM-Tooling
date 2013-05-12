/**
 */
package org.js.model.workflow.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;


import org.eclipse.jwt.we.conf.model.impl.AspectInstanceImpl;

import org.js.model.rbac.AccessControlModel;

import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ACM Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.model.workflow.impl.ACMConnectorImpl#getAcmref <em>Acmref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ACMConnectorImpl extends AspectInstanceImpl implements ACMConnector {
	/**
	 * The cached value of the '{@link #getAcmref() <em>Acmref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAcmref()
	 * @generated
	 * @ordered
	 */
	protected AccessControlModel acmref;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ACMConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.ACM_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessControlModel getAcmref() {
		if (acmref != null && acmref.eIsProxy()) {
			InternalEObject oldAcmref = (InternalEObject)acmref;
			acmref = (AccessControlModel)eResolveProxy(oldAcmref);
			if (acmref != oldAcmref) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.ACM_CONNECTOR__ACMREF, oldAcmref, acmref));
			}
		}
		return acmref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessControlModel basicGetAcmref() {
		return acmref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAcmref(AccessControlModel newAcmref) {
		AccessControlModel oldAcmref = acmref;
		acmref = newAcmref;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.ACM_CONNECTOR__ACMREF, oldAcmref, acmref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.ACM_CONNECTOR__ACMREF:
				if (resolve) return getAcmref();
				return basicGetAcmref();
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
			case WorkflowPackage.ACM_CONNECTOR__ACMREF:
				setAcmref((AccessControlModel)newValue);
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
			case WorkflowPackage.ACM_CONNECTOR__ACMREF:
				setAcmref((AccessControlModel)null);
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
			case WorkflowPackage.ACM_CONNECTOR__ACMREF:
				return acmref != null;
		}
		return super.eIsSet(featureID);
	}

} //ACMConnectorImpl
