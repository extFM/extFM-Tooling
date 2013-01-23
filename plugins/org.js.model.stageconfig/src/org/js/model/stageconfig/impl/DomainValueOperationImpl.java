/**
 */
package org.js.model.stageconfig.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.js.model.feature.Attribute;

import org.js.model.stageconfig.DomainValueOperation;
import org.js.model.stageconfig.StageconfigPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Domain Value Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.model.stageconfig.impl.DomainValueOperationImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.js.model.stageconfig.impl.DomainValueOperationImpl#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DomainValueOperationImpl extends OperationImpl implements DomainValueOperation {
	/**
    * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #getValue()
    * @generated
    * @ordered
    */
	protected static final String VALUE_EDEFAULT = null;

	/**
    * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #getValue()
    * @generated
    * @ordered
    */
	protected String value = VALUE_EDEFAULT;

	/**
    * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #getAttribute()
    * @generated
    * @ordered
    */
	protected Attribute attribute;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected DomainValueOperationImpl() {
      super();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	protected EClass eStaticClass() {
      return StageconfigPackage.Literals.DOMAIN_VALUE_OPERATION;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public String getValue() {
      return value;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void setValue(String newValue) {
      String oldValue = value;
      value = newValue;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, StageconfigPackage.DOMAIN_VALUE_OPERATION__VALUE, oldValue, value));
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public Attribute getAttribute() {
      if (attribute != null && attribute.eIsProxy()) {
         InternalEObject oldAttribute = (InternalEObject)attribute;
         attribute = (Attribute)eResolveProxy(oldAttribute);
         if (attribute != oldAttribute) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, StageconfigPackage.DOMAIN_VALUE_OPERATION__ATTRIBUTE, oldAttribute, attribute));
         }
      }
      return attribute;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public Attribute basicGetAttribute() {
      return attribute;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void setAttribute(Attribute newAttribute) {
      Attribute oldAttribute = attribute;
      attribute = newAttribute;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, StageconfigPackage.DOMAIN_VALUE_OPERATION__ATTRIBUTE, oldAttribute, attribute));
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case StageconfigPackage.DOMAIN_VALUE_OPERATION__VALUE:
            return getValue();
         case StageconfigPackage.DOMAIN_VALUE_OPERATION__ATTRIBUTE:
            if (resolve) return getAttribute();
            return basicGetAttribute();
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
         case StageconfigPackage.DOMAIN_VALUE_OPERATION__VALUE:
            setValue((String)newValue);
            return;
         case StageconfigPackage.DOMAIN_VALUE_OPERATION__ATTRIBUTE:
            setAttribute((Attribute)newValue);
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
         case StageconfigPackage.DOMAIN_VALUE_OPERATION__VALUE:
            setValue(VALUE_EDEFAULT);
            return;
         case StageconfigPackage.DOMAIN_VALUE_OPERATION__ATTRIBUTE:
            setAttribute((Attribute)null);
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
         case StageconfigPackage.DOMAIN_VALUE_OPERATION__VALUE:
            return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
         case StageconfigPackage.DOMAIN_VALUE_OPERATION__ATTRIBUTE:
            return attribute != null;
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
      result.append(" (value: ");
      result.append(value);
      result.append(')');
      return result.toString();
   }

} //DomainValueOperationImpl
