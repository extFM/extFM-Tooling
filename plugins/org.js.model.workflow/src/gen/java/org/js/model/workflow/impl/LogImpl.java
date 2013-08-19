/**
 */
package org.js.model.workflow.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;



import org.eclipse.jwt.we.conf.model.impl.AspectInstanceImpl;
import org.js.model.rbac.ConfigurationOperation;
import org.js.model.rbac.Permission;

import org.js.model.workflow.Log;
import org.js.model.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Log</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.model.workflow.impl.LogImpl#getConfigurationOperations <em>Configuration Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogImpl extends 
AspectInstanceImpl implements Log {
	/**
    * The cached value of the '{@link #getConfigurationOperations() <em>Configuration Operations</em>}' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getConfigurationOperations()
    * @generated
    * @ordered
    */
   protected EList<ConfigurationOperation> configurationOperations;
   /**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected LogImpl() {
      super();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	protected EClass eStaticClass() {
      return WorkflowPackage.Literals.LOG;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public EList<ConfigurationOperation> getConfigurationOperations() {
      if (configurationOperations == null) {
         configurationOperations = new EObjectResolvingEList<ConfigurationOperation>(ConfigurationOperation.class, this, WorkflowPackage.LOG__CONFIGURATION_OPERATIONS);
      }
      return configurationOperations;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case WorkflowPackage.LOG__CONFIGURATION_OPERATIONS:
            return getConfigurationOperations();
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
         case WorkflowPackage.LOG__CONFIGURATION_OPERATIONS:
            getConfigurationOperations().clear();
            getConfigurationOperations().addAll((Collection<? extends ConfigurationOperation>)newValue);
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
         case WorkflowPackage.LOG__CONFIGURATION_OPERATIONS:
            getConfigurationOperations().clear();
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
         case WorkflowPackage.LOG__CONFIGURATION_OPERATIONS:
            return configurationOperations != null && !configurationOperations.isEmpty();
      }
      return super.eIsSet(featureID);
   }

} //LogImpl
