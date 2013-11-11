/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.term.propositional.expression.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.emftext.term.propositional.expression.FeatureRef;
import org.emftext.term.propositional.expression.TermPackage;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.term.propositional.expression.impl.FeatureRefImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureRefImpl extends TermImpl implements FeatureRef {
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
   protected FeatureRefImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return TermPackage.Literals.FEATURE_REF;
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
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, TermPackage.FEATURE_REF__FEATURE, oldFeature, feature));
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
         eNotify(new ENotificationImpl(this, Notification.SET, TermPackage.FEATURE_REF__FEATURE, oldFeature, feature));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case TermPackage.FEATURE_REF__FEATURE:
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
         case TermPackage.FEATURE_REF__FEATURE:
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
         case TermPackage.FEATURE_REF__FEATURE:
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
         case TermPackage.FEATURE_REF__FEATURE:
            return feature != null;
      }
      return super.eIsSet(featureID);
   }

} //FeatureRefImpl
