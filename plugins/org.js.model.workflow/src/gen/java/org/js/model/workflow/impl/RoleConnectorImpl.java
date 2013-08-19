/**
 */
package org.js.model.workflow.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;




import org.eclipse.jwt.we.conf.model.impl.AspectInstanceImpl;
import org.js.model.rbac.Role;

import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.model.workflow.impl.RoleConnectorImpl#getRoleref <em>Roleref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleConnectorImpl extends 
AspectInstanceImpl implements RoleConnector {
	/**
    * The cached value of the '{@link #getRoleref() <em>Roleref</em>}' reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #getRoleref()
    * @generated
    * @ordered
    */
	protected Role roleref;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected RoleConnectorImpl() {
      super();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	protected EClass eStaticClass() {
      return WorkflowPackage.Literals.ROLE_CONNECTOR;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public Role getRoleref() {
      if (roleref != null && roleref.eIsProxy()) {
         InternalEObject oldRoleref = (InternalEObject)roleref;
         roleref = (Role)eResolveProxy(oldRoleref);
         if (roleref != oldRoleref) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.ROLE_CONNECTOR__ROLEREF, oldRoleref, roleref));
         }
      }
      return roleref;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public Role basicGetRoleref() {
      return roleref;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void setRoleref(Role newRoleref) {
      Role oldRoleref = roleref;
      roleref = newRoleref;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.ROLE_CONNECTOR__ROLEREF, oldRoleref, roleref));
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case WorkflowPackage.ROLE_CONNECTOR__ROLEREF:
            if (resolve) return getRoleref();
            return basicGetRoleref();
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
         case WorkflowPackage.ROLE_CONNECTOR__ROLEREF:
            setRoleref((Role)newValue);
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
         case WorkflowPackage.ROLE_CONNECTOR__ROLEREF:
            setRoleref((Role)null);
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
         case WorkflowPackage.ROLE_CONNECTOR__ROLEREF:
            return roleref != null;
      }
      return super.eIsSet(featureID);
   }

} //RoleConnectorImpl
