/**
 */
package org.js.model.stageconfig.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.js.model.feature.FeatureModel;

import org.js.model.stageconfig.Stage;
import org.js.model.stageconfig.StageModel;
import org.js.model.stageconfig.StageconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stage Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.model.stageconfig.impl.StageModelImpl#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link org.js.model.stageconfig.impl.StageModelImpl#getFirstStage <em>First Stage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StageModelImpl extends EObjectImpl implements StageModel {
	/**
	 * The cached value of the '{@link #getFeatureModel() <em>Feature Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureModel()
	 * @generated
	 * @ordered
	 */
	protected FeatureModel featureModel;

	/**
	 * The cached value of the '{@link #getFirstStage() <em>First Stage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstStage()
	 * @generated
	 * @ordered
	 */
	protected Stage firstStage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StageModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StageconfigPackage.Literals.STAGE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureModel getFeatureModel() {
		if (featureModel != null && featureModel.eIsProxy()) {
			InternalEObject oldFeatureModel = (InternalEObject)featureModel;
			featureModel = (FeatureModel)eResolveProxy(oldFeatureModel);
			if (featureModel != oldFeatureModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StageconfigPackage.STAGE_MODEL__FEATURE_MODEL, oldFeatureModel, featureModel));
			}
		}
		return featureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureModel basicGetFeatureModel() {
		return featureModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureModel(FeatureModel newFeatureModel) {
		FeatureModel oldFeatureModel = featureModel;
		featureModel = newFeatureModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StageconfigPackage.STAGE_MODEL__FEATURE_MODEL, oldFeatureModel, featureModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stage getFirstStage() {
		return firstStage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstStage(Stage newFirstStage, NotificationChain msgs) {
		Stage oldFirstStage = firstStage;
		firstStage = newFirstStage;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StageconfigPackage.STAGE_MODEL__FIRST_STAGE, oldFirstStage, newFirstStage);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstStage(Stage newFirstStage) {
		if (newFirstStage != firstStage) {
			NotificationChain msgs = null;
			if (firstStage != null)
				msgs = ((InternalEObject)firstStage).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StageconfigPackage.STAGE_MODEL__FIRST_STAGE, null, msgs);
			if (newFirstStage != null)
				msgs = ((InternalEObject)newFirstStage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StageconfigPackage.STAGE_MODEL__FIRST_STAGE, null, msgs);
			msgs = basicSetFirstStage(newFirstStage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StageconfigPackage.STAGE_MODEL__FIRST_STAGE, newFirstStage, newFirstStage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StageconfigPackage.STAGE_MODEL__FIRST_STAGE:
				return basicSetFirstStage(null, msgs);
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
			case StageconfigPackage.STAGE_MODEL__FEATURE_MODEL:
				if (resolve) return getFeatureModel();
				return basicGetFeatureModel();
			case StageconfigPackage.STAGE_MODEL__FIRST_STAGE:
				return getFirstStage();
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
			case StageconfigPackage.STAGE_MODEL__FEATURE_MODEL:
				setFeatureModel((FeatureModel)newValue);
				return;
			case StageconfigPackage.STAGE_MODEL__FIRST_STAGE:
				setFirstStage((Stage)newValue);
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
			case StageconfigPackage.STAGE_MODEL__FEATURE_MODEL:
				setFeatureModel((FeatureModel)null);
				return;
			case StageconfigPackage.STAGE_MODEL__FIRST_STAGE:
				setFirstStage((Stage)null);
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
			case StageconfigPackage.STAGE_MODEL__FEATURE_MODEL:
				return featureModel != null;
			case StageconfigPackage.STAGE_MODEL__FIRST_STAGE:
				return firstStage != null;
		}
		return super.eIsSet(featureID);
	}

} //StageModelImpl
