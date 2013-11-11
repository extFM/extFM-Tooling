/**
 */
package org.feature.multi.perspective.view.impl;

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

import org.feature.multi.perspective.mapping.viewmapping.MappingModel;

import org.feature.multi.perspective.view.View;
import org.feature.multi.perspective.view.ViewContainer;
import org.feature.multi.perspective.view.ViewPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.view.impl.ViewContainerImpl#getViews <em>Views</em>}</li>
 *   <li>{@link org.feature.multi.perspective.view.impl.ViewContainerImpl#getFeatureMapping <em>Feature Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewContainerImpl extends EObjectImpl implements ViewContainer {
   /**
    * The cached value of the '{@link #getViews() <em>Views</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getViews()
    * @generated
    * @ordered
    */
   protected EList<View> views;

   /**
    * The cached value of the '{@link #getFeatureMapping() <em>Feature Mapping</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getFeatureMapping()
    * @generated
    * @ordered
    */
   protected MappingModel featureMapping;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected ViewContainerImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return ViewPackage.Literals.VIEW_CONTAINER;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<View> getViews() {
      if (views == null) {
         views = new EObjectContainmentEList<View>(View.class, this, ViewPackage.VIEW_CONTAINER__VIEWS);
      }
      return views;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public MappingModel getFeatureMapping() {
      if (featureMapping != null && featureMapping.eIsProxy()) {
         InternalEObject oldFeatureMapping = (InternalEObject)featureMapping;
         featureMapping = (MappingModel)eResolveProxy(oldFeatureMapping);
         if (featureMapping != oldFeatureMapping) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, ViewPackage.VIEW_CONTAINER__FEATURE_MAPPING, oldFeatureMapping, featureMapping));
         }
      }
      return featureMapping;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public MappingModel basicGetFeatureMapping() {
      return featureMapping;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setFeatureMapping(MappingModel newFeatureMapping) {
      MappingModel oldFeatureMapping = featureMapping;
      featureMapping = newFeatureMapping;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.VIEW_CONTAINER__FEATURE_MAPPING, oldFeatureMapping, featureMapping));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
      switch (featureID) {
         case ViewPackage.VIEW_CONTAINER__VIEWS:
            return ((InternalEList<?>)getViews()).basicRemove(otherEnd, msgs);
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
         case ViewPackage.VIEW_CONTAINER__VIEWS:
            return getViews();
         case ViewPackage.VIEW_CONTAINER__FEATURE_MAPPING:
            if (resolve) return getFeatureMapping();
            return basicGetFeatureMapping();
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
         case ViewPackage.VIEW_CONTAINER__VIEWS:
            getViews().clear();
            getViews().addAll((Collection<? extends View>)newValue);
            return;
         case ViewPackage.VIEW_CONTAINER__FEATURE_MAPPING:
            setFeatureMapping((MappingModel)newValue);
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
         case ViewPackage.VIEW_CONTAINER__VIEWS:
            getViews().clear();
            return;
         case ViewPackage.VIEW_CONTAINER__FEATURE_MAPPING:
            setFeatureMapping((MappingModel)null);
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
         case ViewPackage.VIEW_CONTAINER__VIEWS:
            return views != null && !views.isEmpty();
         case ViewPackage.VIEW_CONTAINER__FEATURE_MAPPING:
            return featureMapping != null;
      }
      return super.eIsSet(featureID);
   }

} //ViewContainerImpl
