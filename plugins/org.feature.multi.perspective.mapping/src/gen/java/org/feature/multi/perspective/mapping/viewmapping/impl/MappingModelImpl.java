/**
 */
package org.feature.multi.perspective.mapping.viewmapping.impl;

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

import org.feature.multi.perspective.mapping.viewmapping.Mapping;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage;

import org.feature.multi.perspective.model.viewmodel.GroupModel;

import org.featuremapper.models.feature.FeatureModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.mapping.viewmapping.impl.MappingModelImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.feature.multi.perspective.mapping.viewmapping.impl.MappingModelImpl#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link org.feature.multi.perspective.mapping.viewmapping.impl.MappingModelImpl#getViewModel <em>View Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingModelImpl extends EObjectImpl implements MappingModel {
   /**
    * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getMappings()
    * @generated
    * @ordered
    */
   protected EList<Mapping> mappings;

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
    * The cached value of the '{@link #getViewModel() <em>View Model</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getViewModel()
    * @generated
    * @ordered
    */
   protected GroupModel viewModel;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected MappingModelImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return ViewmappingPackage.Literals.MAPPING_MODEL;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Mapping> getMappings() {
      if (mappings == null) {
         mappings = new EObjectContainmentEList<Mapping>(Mapping.class, this, ViewmappingPackage.MAPPING_MODEL__MAPPINGS);
      }
      return mappings;
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
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL, oldFeatureModel, featureModel));
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
         eNotify(new ENotificationImpl(this, Notification.SET, ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL, oldFeatureModel, featureModel));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public GroupModel getViewModel() {
      if (viewModel != null && viewModel.eIsProxy()) {
         InternalEObject oldViewModel = (InternalEObject)viewModel;
         viewModel = (GroupModel)eResolveProxy(oldViewModel);
         if (viewModel != oldViewModel) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL, oldViewModel, viewModel));
         }
      }
      return viewModel;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public GroupModel basicGetViewModel() {
      return viewModel;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setViewModel(GroupModel newViewModel) {
      GroupModel oldViewModel = viewModel;
      viewModel = newViewModel;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL, oldViewModel, viewModel));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
      switch (featureID) {
         case ViewmappingPackage.MAPPING_MODEL__MAPPINGS:
            return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
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
         case ViewmappingPackage.MAPPING_MODEL__MAPPINGS:
            return getMappings();
         case ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL:
            if (resolve) return getFeatureModel();
            return basicGetFeatureModel();
         case ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL:
            if (resolve) return getViewModel();
            return basicGetViewModel();
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
         case ViewmappingPackage.MAPPING_MODEL__MAPPINGS:
            getMappings().clear();
            getMappings().addAll((Collection<? extends Mapping>)newValue);
            return;
         case ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL:
            setFeatureModel((FeatureModel)newValue);
            return;
         case ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL:
            setViewModel((GroupModel)newValue);
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
         case ViewmappingPackage.MAPPING_MODEL__MAPPINGS:
            getMappings().clear();
            return;
         case ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL:
            setFeatureModel((FeatureModel)null);
            return;
         case ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL:
            setViewModel((GroupModel)null);
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
         case ViewmappingPackage.MAPPING_MODEL__MAPPINGS:
            return mappings != null && !mappings.isEmpty();
         case ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL:
            return featureModel != null;
         case ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL:
            return viewModel != null;
      }
      return super.eIsSet(featureID);
   }

} //MappingModelImpl
