/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.model.viewmodel.ViewPointContainer;
import org.feature.multi.perspective.model.viewmodel.ViewmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>View Point Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.model.viewmodel.impl.ViewPointContainerImpl#getViewPoints <em>View Points</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ViewPointContainerImpl extends EObjectImpl implements ViewPointContainer {
   /**
	 * The cached value of the '{@link #getViewPoints() <em>View Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getViewPoints()
	 * @generated
	 * @ordered
	 */
   protected EList<ViewPoint> viewPoints;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected ViewPointContainerImpl() {
		super();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   protected EClass eStaticClass() {
		return ViewmodelPackage.Literals.VIEW_POINT_CONTAINER;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<ViewPoint> getViewPoints() {
		if (viewPoints == null) {
			viewPoints = new EObjectContainmentEList<ViewPoint>(ViewPoint.class, this, ViewmodelPackage.VIEW_POINT_CONTAINER__VIEW_POINTS);
		}
		return viewPoints;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ViewmodelPackage.VIEW_POINT_CONTAINER__VIEW_POINTS:
				return ((InternalEList<?>)getViewPoints()).basicRemove(otherEnd, msgs);
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
			case ViewmodelPackage.VIEW_POINT_CONTAINER__VIEW_POINTS:
				return getViewPoints();
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
			case ViewmodelPackage.VIEW_POINT_CONTAINER__VIEW_POINTS:
				getViewPoints().clear();
				getViewPoints().addAll((Collection<? extends ViewPoint>)newValue);
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
			case ViewmodelPackage.VIEW_POINT_CONTAINER__VIEW_POINTS:
				getViewPoints().clear();
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
			case ViewmodelPackage.VIEW_POINT_CONTAINER__VIEW_POINTS:
				return viewPoints != null && !viewPoints.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ViewPointContainerImpl
