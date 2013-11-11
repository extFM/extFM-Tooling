/**
 */
package org.feature.multi.perspective.mapping.viewmapping.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.feature.multi.perspective.mapping.viewmapping.Mapping;
import org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage;

import org.feature.multi.perspective.model.viewmodel.AbstractGroup;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.mapping.viewmapping.impl.MappingImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.mapping.viewmapping.impl.MappingImpl#getViewgroup <em>Viewgroup</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingImpl extends EObjectImpl implements Mapping {
   /**
    * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getFeatures()
    * @generated
    * @ordered
    */
   protected EList<Feature> features;

   /**
    * The cached value of the '{@link #getViewgroup() <em>Viewgroup</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getViewgroup()
    * @generated
    * @ordered
    */
   protected AbstractGroup viewgroup;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected MappingImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return ViewmappingPackage.Literals.MAPPING;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Feature> getFeatures() {
      if (features == null) {
         features = new EObjectResolvingEList<Feature>(Feature.class, this, ViewmappingPackage.MAPPING__FEATURES);
      }
      return features;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public AbstractGroup getViewgroup() {
      if (viewgroup != null && viewgroup.eIsProxy()) {
         InternalEObject oldViewgroup = (InternalEObject)viewgroup;
         viewgroup = (AbstractGroup)eResolveProxy(oldViewgroup);
         if (viewgroup != oldViewgroup) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, ViewmappingPackage.MAPPING__VIEWGROUP, oldViewgroup, viewgroup));
         }
      }
      return viewgroup;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public AbstractGroup basicGetViewgroup() {
      return viewgroup;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setViewgroup(AbstractGroup newViewgroup) {
      AbstractGroup oldViewgroup = viewgroup;
      viewgroup = newViewgroup;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ViewmappingPackage.MAPPING__VIEWGROUP, oldViewgroup, viewgroup));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case ViewmappingPackage.MAPPING__FEATURES:
            return getFeatures();
         case ViewmappingPackage.MAPPING__VIEWGROUP:
            if (resolve) return getViewgroup();
            return basicGetViewgroup();
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
         case ViewmappingPackage.MAPPING__FEATURES:
            getFeatures().clear();
            getFeatures().addAll((Collection<? extends Feature>)newValue);
            return;
         case ViewmappingPackage.MAPPING__VIEWGROUP:
            setViewgroup((AbstractGroup)newValue);
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
         case ViewmappingPackage.MAPPING__FEATURES:
            getFeatures().clear();
            return;
         case ViewmappingPackage.MAPPING__VIEWGROUP:
            setViewgroup((AbstractGroup)null);
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
         case ViewmappingPackage.MAPPING__FEATURES:
            return features != null && !features.isEmpty();
         case ViewmappingPackage.MAPPING__VIEWGROUP:
            return viewgroup != null;
      }
      return super.eIsSet(featureID);
   }

} //MappingImpl
