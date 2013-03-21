/**
 */
package org.js.model.workflow.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.eclipse.jwt.meta.model.processes.JoinNode;

import org.js.model.workflow.InsertNodes;
import org.js.model.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Insert Nodes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.model.workflow.impl.InsertNodesImpl#getJoinnode <em>Joinnode</em>}</li>
 *   <li>{@link org.js.model.workflow.impl.InsertNodesImpl#getForknode <em>Forknode</em>}</li>
 *   <li>{@link org.js.model.workflow.impl.InsertNodesImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InsertNodesImpl extends EObjectImpl implements InsertNodes {
	/**
	 * The cached value of the '{@link #getJoinnode() <em>Joinnode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinnode()
	 * @generated
	 * @ordered
	 */
	protected JoinNode joinnode;

	/**
	 * The cached value of the '{@link #getForknode() <em>Forknode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForknode()
	 * @generated
	 * @ordered
	 */
	protected ForkNode forknode;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected Action action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InsertNodesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.INSERT_NODES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinNode getJoinnode() {
		if (joinnode != null && joinnode.eIsProxy()) {
			InternalEObject oldJoinnode = (InternalEObject)joinnode;
			joinnode = (JoinNode)eResolveProxy(oldJoinnode);
			if (joinnode != oldJoinnode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.INSERT_NODES__JOINNODE, oldJoinnode, joinnode));
			}
		}
		return joinnode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinNode basicGetJoinnode() {
		return joinnode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJoinnode(JoinNode newJoinnode) {
		JoinNode oldJoinnode = joinnode;
		joinnode = newJoinnode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.INSERT_NODES__JOINNODE, oldJoinnode, joinnode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForkNode getForknode() {
		if (forknode != null && forknode.eIsProxy()) {
			InternalEObject oldForknode = (InternalEObject)forknode;
			forknode = (ForkNode)eResolveProxy(oldForknode);
			if (forknode != oldForknode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.INSERT_NODES__FORKNODE, oldForknode, forknode));
			}
		}
		return forknode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForkNode basicGetForknode() {
		return forknode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForknode(ForkNode newForknode) {
		ForkNode oldForknode = forknode;
		forknode = newForknode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.INSERT_NODES__FORKNODE, oldForknode, forknode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getAction() {
		if (action != null && action.eIsProxy()) {
			InternalEObject oldAction = (InternalEObject)action;
			action = (Action)eResolveProxy(oldAction);
			if (action != oldAction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.INSERT_NODES__ACTION, oldAction, action));
			}
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action basicGetAction() {
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAction(Action newAction) {
		Action oldAction = action;
		action = newAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.INSERT_NODES__ACTION, oldAction, action));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorkflowPackage.INSERT_NODES__JOINNODE:
				if (resolve) return getJoinnode();
				return basicGetJoinnode();
			case WorkflowPackage.INSERT_NODES__FORKNODE:
				if (resolve) return getForknode();
				return basicGetForknode();
			case WorkflowPackage.INSERT_NODES__ACTION:
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
			case WorkflowPackage.INSERT_NODES__JOINNODE:
				setJoinnode((JoinNode)newValue);
				return;
			case WorkflowPackage.INSERT_NODES__FORKNODE:
				setForknode((ForkNode)newValue);
				return;
			case WorkflowPackage.INSERT_NODES__ACTION:
				setAction((Action)newValue);
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
			case WorkflowPackage.INSERT_NODES__JOINNODE:
				setJoinnode((JoinNode)null);
				return;
			case WorkflowPackage.INSERT_NODES__FORKNODE:
				setForknode((ForkNode)null);
				return;
			case WorkflowPackage.INSERT_NODES__ACTION:
				setAction((Action)null);
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
			case WorkflowPackage.INSERT_NODES__JOINNODE:
				return joinnode != null;
			case WorkflowPackage.INSERT_NODES__FORKNODE:
				return forknode != null;
			case WorkflowPackage.INSERT_NODES__ACTION:
				return action != null;
		}
		return super.eIsSet(featureID);
	}

} //InsertNodesImpl
