/**
 */
package org.js.graph.transformation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.js.graph.transformation.ExistingRole;
import org.js.graph.transformation.SpecializationAction;
import org.js.graph.transformation.TransformationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Existing Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.graph.transformation.impl.ExistingRoleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.js.graph.transformation.impl.ExistingRoleImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExistingRoleImpl extends MinimalEObjectImpl.Container implements ExistingRole {
	/**
    * The default value of the '{@link #getName() <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #getName()
    * @generated
    * @ordered
    */
	protected static final String NAME_EDEFAULT = "";

	/**
    * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #getName()
    * @generated
    * @ordered
    */
	protected String name = NAME_EDEFAULT;

	/**
    * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #getAction()
    * @generated
    * @ordered
    */
	protected SpecializationAction action;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected ExistingRoleImpl() {
      super();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	protected EClass eStaticClass() {
      return TransformationPackage.Literals.EXISTING_ROLE;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public String getName() {
      return name;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void setName(String newName) {
      String oldName = name;
      name = newName;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.EXISTING_ROLE__NAME, oldName, name));
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public SpecializationAction getAction() {
      if (action != null && action.eIsProxy()) {
         InternalEObject oldAction = (InternalEObject)action;
         action = (SpecializationAction)eResolveProxy(oldAction);
         if (action != oldAction) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformationPackage.EXISTING_ROLE__ACTION, oldAction, action));
         }
      }
      return action;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public SpecializationAction basicGetAction() {
      return action;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public NotificationChain basicSetAction(SpecializationAction newAction, NotificationChain msgs) {
      SpecializationAction oldAction = action;
      action = newAction;
      if (eNotificationRequired()) {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformationPackage.EXISTING_ROLE__ACTION, oldAction, newAction);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void setAction(SpecializationAction newAction) {
      if (newAction != action) {
         NotificationChain msgs = null;
         if (action != null)
            msgs = ((InternalEObject)action).eInverseRemove(this, TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE, SpecializationAction.class, msgs);
         if (newAction != null)
            msgs = ((InternalEObject)newAction).eInverseAdd(this, TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE, SpecializationAction.class, msgs);
         msgs = basicSetAction(newAction, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.EXISTING_ROLE__ACTION, newAction, newAction));
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
      switch (featureID) {
         case TransformationPackage.EXISTING_ROLE__ACTION:
            if (action != null)
               msgs = ((InternalEObject)action).eInverseRemove(this, TransformationPackage.SPECIALIZATION_ACTION__VARIABLE_ROLE, SpecializationAction.class, msgs);
            return basicSetAction((SpecializationAction)otherEnd, msgs);
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
         case TransformationPackage.EXISTING_ROLE__ACTION:
            return basicSetAction(null, msgs);
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
         case TransformationPackage.EXISTING_ROLE__NAME:
            return getName();
         case TransformationPackage.EXISTING_ROLE__ACTION:
            if (resolve) return getAction();
            return basicGetAction();
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
         case TransformationPackage.EXISTING_ROLE__NAME:
            setName((String)newValue);
            return;
         case TransformationPackage.EXISTING_ROLE__ACTION:
            setAction((SpecializationAction)newValue);
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
         case TransformationPackage.EXISTING_ROLE__NAME:
            setName(NAME_EDEFAULT);
            return;
         case TransformationPackage.EXISTING_ROLE__ACTION:
            setAction((SpecializationAction)null);
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
         case TransformationPackage.EXISTING_ROLE__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
         case TransformationPackage.EXISTING_ROLE__ACTION:
            return action != null;
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
      result.append(" (name: ");
      result.append(name);
      result.append(')');
      return result.toString();
   }

} //ExistingRoleImpl
