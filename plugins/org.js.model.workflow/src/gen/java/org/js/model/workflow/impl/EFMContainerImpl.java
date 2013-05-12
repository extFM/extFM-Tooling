/**
 */
package org.js.model.workflow.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;


import org.eclipse.jwt.we.conf.model.impl.AspectInstanceImpl;

import org.js.model.feature.FeatureModel;

import org.js.model.workflow.EFMContainer;
import org.js.model.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EFM Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.model.workflow.impl.EFMContainerImpl#getEfmref <em>Efmref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EFMContainerImpl extends AspectInstanceImpl implements EFMContainer {
	/**
	 * The cached value of the '{@link #getEfmref() <em>Efmref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEfmref()
	 * @generated
	 * @ordered
	 */
	protected FeatureModel efmref;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EFMContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.EFM_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureModel getEfmref() {
		return efmref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEfmref(FeatureModel newEfmref, NotificationChain msgs) {
		FeatureModel oldEfmref = efmref;
		efmref = newEfmref;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.EFM_CONTAINER__EFMREF, oldEfmref, newEfmref);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEfmref(FeatureModel newEfmref) {
		if (newEfmref != efmref) {
			NotificationChain msgs = null;
			if (efmref != null)
				msgs = ((InternalEObject)efmref).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.EFM_CONTAINER__EFMREF, null, msgs);
			if (newEfmref != null)
				msgs = ((InternalEObject)newEfmref).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.EFM_CONTAINER__EFMREF, null, msgs);
			msgs = basicSetEfmref(newEfmref, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.EFM_CONTAINER__EFMREF, newEfmref, newEfmref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.EFM_CONTAINER__EFMREF:
				return basicSetEfmref(null, msgs);
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
			case WorkflowPackage.EFM_CONTAINER__EFMREF:
				return getEfmref();
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
			case WorkflowPackage.EFM_CONTAINER__EFMREF:
				setEfmref((FeatureModel)newValue);
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
			case WorkflowPackage.EFM_CONTAINER__EFMREF:
				setEfmref((FeatureModel)null);
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
			case WorkflowPackage.EFM_CONTAINER__EFMREF:
				return efmref != null;
		}
		return super.eIsSet(featureID);
	}

} //EFMContainerImpl
