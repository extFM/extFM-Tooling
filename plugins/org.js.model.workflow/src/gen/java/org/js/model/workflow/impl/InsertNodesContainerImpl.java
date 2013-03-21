/**
 */
package org.js.model.workflow.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jwt.we.conf.model.impl.AspectInstanceImpl;

import org.js.model.workflow.InsertNodes;
import org.js.model.workflow.InsertNodesContainer;
import org.js.model.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Insert Nodes Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.model.workflow.impl.InsertNodesContainerImpl#getInsertnodes <em>Insertnodes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InsertNodesContainerImpl extends AspectInstanceImpl implements InsertNodesContainer {
	/**
	 * The cached value of the '{@link #getInsertnodes() <em>Insertnodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsertnodes()
	 * @generated
	 * @ordered
	 */
	protected EList<InsertNodes> insertnodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InsertNodesContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.INSERT_NODES_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InsertNodes> getInsertnodes() {
		if (insertnodes == null) {
			insertnodes = new EObjectContainmentEList<InsertNodes>(InsertNodes.class, this, WorkflowPackage.INSERT_NODES_CONTAINER__INSERTNODES);
		}
		return insertnodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.INSERT_NODES_CONTAINER__INSERTNODES:
				return ((InternalEList<?>)getInsertnodes()).basicRemove(otherEnd, msgs);
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
			case WorkflowPackage.INSERT_NODES_CONTAINER__INSERTNODES:
				return getInsertnodes();
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
			case WorkflowPackage.INSERT_NODES_CONTAINER__INSERTNODES:
				getInsertnodes().clear();
				getInsertnodes().addAll((Collection<? extends InsertNodes>)newValue);
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
			case WorkflowPackage.INSERT_NODES_CONTAINER__INSERTNODES:
				getInsertnodes().clear();
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
			case WorkflowPackage.INSERT_NODES_CONTAINER__INSERTNODES:
				return insertnodes != null && !insertnodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InsertNodesContainerImpl
