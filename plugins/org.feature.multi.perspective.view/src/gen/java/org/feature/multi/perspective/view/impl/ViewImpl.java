/**
 */
package org.feature.multi.perspective.view.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.feature.multi.perspective.model.viewmodel.AbstractGroup;

import org.feature.multi.perspective.view.View;
import org.feature.multi.perspective.view.ViewPackage;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.view.impl.ViewImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.view.impl.ViewImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.feature.multi.perspective.view.impl.ViewImpl#getViewgroups <em>Viewgroups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewImpl extends EObjectImpl implements View {
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
    * The default value of the '{@link #getId() <em>Id</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getId()
    * @generated
    * @ordered
    */
   protected static final String ID_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getId()
    * @generated
    * @ordered
    */
   protected String id = ID_EDEFAULT;

   /**
    * The cached value of the '{@link #getViewgroups() <em>Viewgroups</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getViewgroups()
    * @generated
    * @ordered
    */
   protected EList<AbstractGroup> viewgroups;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected ViewImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return ViewPackage.Literals.VIEW;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Feature> getFeatures() {
      if (features == null) {
         features = new EObjectResolvingEList<Feature>(Feature.class, this, ViewPackage.VIEW__FEATURES);
      }
      return features;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getId() {
      return id;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setId(String newId) {
      String oldId = id;
      id = newId;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, ViewPackage.VIEW__ID, oldId, id));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<AbstractGroup> getViewgroups() {
      if (viewgroups == null) {
         viewgroups = new EObjectResolvingEList<AbstractGroup>(AbstractGroup.class, this, ViewPackage.VIEW__VIEWGROUPS);
      }
      return viewgroups;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case ViewPackage.VIEW__FEATURES:
            return getFeatures();
         case ViewPackage.VIEW__ID:
            return getId();
         case ViewPackage.VIEW__VIEWGROUPS:
            return getViewgroups();
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
         case ViewPackage.VIEW__FEATURES:
            getFeatures().clear();
            getFeatures().addAll((Collection<? extends Feature>)newValue);
            return;
         case ViewPackage.VIEW__ID:
            setId((String)newValue);
            return;
         case ViewPackage.VIEW__VIEWGROUPS:
            getViewgroups().clear();
            getViewgroups().addAll((Collection<? extends AbstractGroup>)newValue);
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
         case ViewPackage.VIEW__FEATURES:
            getFeatures().clear();
            return;
         case ViewPackage.VIEW__ID:
            setId(ID_EDEFAULT);
            return;
         case ViewPackage.VIEW__VIEWGROUPS:
            getViewgroups().clear();
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
         case ViewPackage.VIEW__FEATURES:
            return features != null && !features.isEmpty();
         case ViewPackage.VIEW__ID:
            return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
         case ViewPackage.VIEW__VIEWGROUPS:
            return viewgroups != null && !viewgroups.isEmpty();
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
      result.append(" (id: ");
      result.append(id);
      result.append(')');
      return result.toString();
   }

} //ViewImpl
