/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.eclipse.emf.ecore.util.InternalEList;

import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.model.viewmodel.ViewmodelPackage;

import org.feature.multi.perspective.model.viewmodel.util.ViewmodelValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.model.viewmodel.impl.GroupImpl#getParentGroup <em>Parent Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupImpl extends AbstractGroupImpl implements Group {
   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected GroupImpl() {
		super();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   protected EClass eStaticClass() {
		return ViewmodelPackage.Literals.GROUP;
	}

   
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated NOT
    */
   public EList<ViewPoint> getViewPointReference() {
       if (viewPointReference == null) {
          viewPointReference = new EObjectResolvingEList<ViewPoint>(ViewPoint.class, this, ViewmodelPackage.GROUP__VIEW_POINT_REFERENCE){

               /* (non-Javadoc)
                * @see org.eclipse.emf.common.util.AbstractEList#didAdd(int, java.lang.Object)
                */
               @Override
               protected void didAdd(int index, ViewPoint newObject) {
                   super.didAdd(index, newObject);
                   newObject.getContainedInGroup().add(GroupImpl.this);
               }

               /* (non-Javadoc)
                * @see org.eclipse.emf.common.util.AbstractEList#didRemove(int, java.lang.Object)
                */
               @Override
               protected void didRemove(int index, ViewPoint oldObject) {
                   super.didRemove(index, oldObject);
                   oldObject.getContainedInGroup().remove(GroupImpl.this);
               }
               
           };
       }
       return viewPointReference;
   }
   
   
   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public AbstractGroup getParentGroup() {
		if (eContainerFeatureID() != ViewmodelPackage.GROUP__PARENT_GROUP) return null;
		return (AbstractGroup)eContainer();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetParentGroup(AbstractGroup newParentGroup, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentGroup, ViewmodelPackage.GROUP__PARENT_GROUP, msgs);
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setParentGroup(AbstractGroup newParentGroup) {
		if (newParentGroup != eInternalContainer() || (eContainerFeatureID() != ViewmodelPackage.GROUP__PARENT_GROUP && newParentGroup != null)) {
			if (EcoreUtil.isAncestor(this, newParentGroup))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentGroup != null)
				msgs = ((InternalEObject)newParentGroup).eInverseAdd(this, ViewmodelPackage.ABSTRACT_GROUP__GROUPS, AbstractGroup.class, msgs);
			msgs = basicSetParentGroup(newParentGroup, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ViewmodelPackage.GROUP__PARENT_GROUP, newParentGroup, newParentGroup));
	}

  
   
   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @SuppressWarnings("unchecked")
   @Override
   public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ViewmodelPackage.GROUP__PARENT_GROUP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentGroup((AbstractGroup)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ViewmodelPackage.GROUP__PARENT_GROUP:
				return basicSetParentGroup(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ViewmodelPackage.GROUP__PARENT_GROUP:
				return eInternalContainer().eInverseRemove(this, ViewmodelPackage.ABSTRACT_GROUP__GROUPS, AbstractGroup.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ViewmodelPackage.GROUP__PARENT_GROUP:
				return getParentGroup();
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
			case ViewmodelPackage.GROUP__PARENT_GROUP:
				setParentGroup((AbstractGroup)newValue);
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
			case ViewmodelPackage.GROUP__PARENT_GROUP:
				setParentGroup((AbstractGroup)null);
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
			case ViewmodelPackage.GROUP__PARENT_GROUP:
				return getParentGroup() != null;
		}
		return super.eIsSet(featureID);
	}

} //GroupImpl
