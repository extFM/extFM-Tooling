/**
 */
package org.js.model.workflow.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;



import org.eclipse.jwt.we.conf.model.impl.AspectInstanceImpl;
import org.js.model.rbac.ConfigurationDecision;
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
 *   <li>{@link org.js.model.workflow.impl.LogImpl#getConfigurationDecisions <em>Configuration Decisions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogImpl extends AspectInstanceImpl implements Log {
	/**
	 * The cached value of the '{@link #getConfigurationDecisions() <em>Configuration Decisions</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurationDecisions()
	 * @generated
	 * @ordered
	 */
	protected EList<ConfigurationDecision> configurationDecisions;
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
	public EList<ConfigurationDecision> getConfigurationDecisions() {
		if (configurationDecisions == null) {
			configurationDecisions = new EObjectResolvingEList<ConfigurationDecision>(ConfigurationDecision.class, this, WorkflowPackage.LOG__CONFIGURATION_DECISIONS);
		}
		return configurationDecisions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.LOG__CONFIGURATION_DECISIONS:
				return getConfigurationDecisions();
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
			case WorkflowPackage.LOG__CONFIGURATION_DECISIONS:
				getConfigurationDecisions().clear();
				getConfigurationDecisions().addAll((Collection<? extends ConfigurationDecision>)newValue);
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
			case WorkflowPackage.LOG__CONFIGURATION_DECISIONS:
				getConfigurationDecisions().clear();
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
			case WorkflowPackage.LOG__CONFIGURATION_DECISIONS:
				return configurationDecisions != null && !configurationDecisions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LogImpl
