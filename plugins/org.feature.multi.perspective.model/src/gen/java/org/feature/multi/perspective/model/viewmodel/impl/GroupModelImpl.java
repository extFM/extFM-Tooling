/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.feature.multi.perspective.model.viewmodel.CoreGroup;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewPointContainer;
import org.feature.multi.perspective.model.viewmodel.ViewmodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.model.viewmodel.impl.GroupModelImpl#getCoreGroup <em>Core Group</em>}</li>
 *   <li>{@link org.feature.multi.perspective.model.viewmodel.impl.GroupModelImpl#getViewPointContainer <em>View Point Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupModelImpl extends EObjectImpl implements GroupModel {
   /**
	 * The cached value of the '{@link #getCoreGroup() <em>Core Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getCoreGroup()
	 * @generated
	 * @ordered
	 */
   protected CoreGroup coreGroup;

   /**
	 * The cached value of the '{@link #getViewPointContainer() <em>View Point Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getViewPointContainer()
	 * @generated
	 * @ordered
	 */
   protected ViewPointContainer viewPointContainer;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected GroupModelImpl() {
		super();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   protected EClass eStaticClass() {
		return ViewmodelPackage.Literals.GROUP_MODEL;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public CoreGroup getCoreGroup() {
		return coreGroup;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetCoreGroup(CoreGroup newCoreGroup, NotificationChain msgs) {
		CoreGroup oldCoreGroup = coreGroup;
		coreGroup = newCoreGroup;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ViewmodelPackage.GROUP_MODEL__CORE_GROUP, oldCoreGroup, newCoreGroup);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setCoreGroup(CoreGroup newCoreGroup) {
		if (newCoreGroup != coreGroup) {
			NotificationChain msgs = null;
			if (coreGroup != null)
				msgs = ((InternalEObject)coreGroup).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ViewmodelPackage.GROUP_MODEL__CORE_GROUP, null, msgs);
			if (newCoreGroup != null)
				msgs = ((InternalEObject)newCoreGroup).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ViewmodelPackage.GROUP_MODEL__CORE_GROUP, null, msgs);
			msgs = basicSetCoreGroup(newCoreGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ViewmodelPackage.GROUP_MODEL__CORE_GROUP, newCoreGroup, newCoreGroup));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ViewPointContainer getViewPointContainer() {
		return viewPointContainer;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetViewPointContainer(ViewPointContainer newViewPointContainer, NotificationChain msgs) {
		ViewPointContainer oldViewPointContainer = viewPointContainer;
		viewPointContainer = newViewPointContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ViewmodelPackage.GROUP_MODEL__VIEW_POINT_CONTAINER, oldViewPointContainer, newViewPointContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setViewPointContainer(ViewPointContainer newViewPointContainer) {
		if (newViewPointContainer != viewPointContainer) {
			NotificationChain msgs = null;
			if (viewPointContainer != null)
				msgs = ((InternalEObject)viewPointContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ViewmodelPackage.GROUP_MODEL__VIEW_POINT_CONTAINER, null, msgs);
			if (newViewPointContainer != null)
				msgs = ((InternalEObject)newViewPointContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ViewmodelPackage.GROUP_MODEL__VIEW_POINT_CONTAINER, null, msgs);
			msgs = basicSetViewPointContainer(newViewPointContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ViewmodelPackage.GROUP_MODEL__VIEW_POINT_CONTAINER, newViewPointContainer, newViewPointContainer));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ViewmodelPackage.GROUP_MODEL__CORE_GROUP:
				return basicSetCoreGroup(null, msgs);
			case ViewmodelPackage.GROUP_MODEL__VIEW_POINT_CONTAINER:
				return basicSetViewPointContainer(null, msgs);
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
			case ViewmodelPackage.GROUP_MODEL__CORE_GROUP:
				return getCoreGroup();
			case ViewmodelPackage.GROUP_MODEL__VIEW_POINT_CONTAINER:
				return getViewPointContainer();
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
			case ViewmodelPackage.GROUP_MODEL__CORE_GROUP:
				setCoreGroup((CoreGroup)newValue);
				return;
			case ViewmodelPackage.GROUP_MODEL__VIEW_POINT_CONTAINER:
				setViewPointContainer((ViewPointContainer)newValue);
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
			case ViewmodelPackage.GROUP_MODEL__CORE_GROUP:
				setCoreGroup((CoreGroup)null);
				return;
			case ViewmodelPackage.GROUP_MODEL__VIEW_POINT_CONTAINER:
				setViewPointContainer((ViewPointContainer)null);
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
			case ViewmodelPackage.GROUP_MODEL__CORE_GROUP:
				return coreGroup != null;
			case ViewmodelPackage.GROUP_MODEL__VIEW_POINT_CONTAINER:
				return viewPointContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //GroupModelImpl
