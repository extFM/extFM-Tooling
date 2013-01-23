/**
 */
package org.js.model.stageconfig.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.js.model.feature.Feature;

import org.js.model.stageconfig.Operation;
import org.js.model.stageconfig.StageconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.model.stageconfig.impl.OperationImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class OperationImpl extends EObjectImpl implements Operation {
	/**
    * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #getFeature()
    * @generated
    * @ordered
    */
	protected Feature feature;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected OperationImpl() {
      super();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	protected EClass eStaticClass() {
      return StageconfigPackage.Literals.OPERATION;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public Feature getFeature() {
      if (feature != null && feature.eIsProxy()) {
         InternalEObject oldFeature = (InternalEObject)feature;
         feature = (Feature)eResolveProxy(oldFeature);
         if (feature != oldFeature) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, StageconfigPackage.OPERATION__FEATURE, oldFeature, feature));
         }
      }
      return feature;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public Feature basicGetFeature() {
      return feature;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void setFeature(Feature newFeature) {
      Feature oldFeature = feature;
      feature = newFeature;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, StageconfigPackage.OPERATION__FEATURE, oldFeature, feature));
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case StageconfigPackage.OPERATION__FEATURE:
            if (resolve) return getFeature();
            return basicGetFeature();
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
         case StageconfigPackage.OPERATION__FEATURE:
            setFeature((Feature)newValue);
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
         case StageconfigPackage.OPERATION__FEATURE:
            setFeature((Feature)null);
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
         case StageconfigPackage.OPERATION__FEATURE:
            return feature != null;
      }
      return super.eIsSet(featureID);
   }

} //OperationImpl
