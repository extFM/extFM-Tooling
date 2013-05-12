/**
 */
package org.js.model.workflow.impl;

import java.util.Collection;
import org.eclipse.jwt.we.conf.model.impl.AspectInstanceImpl;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;



import org.js.model.rbac.Role;

import org.js.model.workflow.StakeholderTypes;
import org.js.model.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stakeholder Types</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.model.workflow.impl.StakeholderTypesImpl#getStakeholderTypes <em>Stakeholder Types</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StakeholderTypesImpl extends AspectInstanceImpl implements StakeholderTypes {
	/**
	 * The cached value of the '{@link #getStakeholderTypes() <em>Stakeholder Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStakeholderTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> stakeholderTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StakeholderTypesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.STAKEHOLDER_TYPES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Role> getStakeholderTypes() {
		if (stakeholderTypes == null) {
			stakeholderTypes = new EObjectResolvingEList<Role>(Role.class, this, WorkflowPackage.STAKEHOLDER_TYPES__STAKEHOLDER_TYPES);
		}
		return stakeholderTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.STAKEHOLDER_TYPES__STAKEHOLDER_TYPES:
				return getStakeholderTypes();
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
			case WorkflowPackage.STAKEHOLDER_TYPES__STAKEHOLDER_TYPES:
				getStakeholderTypes().clear();
				getStakeholderTypes().addAll((Collection<? extends Role>)newValue);
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
			case WorkflowPackage.STAKEHOLDER_TYPES__STAKEHOLDER_TYPES:
				getStakeholderTypes().clear();
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
			case WorkflowPackage.STAKEHOLDER_TYPES__STAKEHOLDER_TYPES:
				return stakeholderTypes != null && !stakeholderTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StakeholderTypesImpl
