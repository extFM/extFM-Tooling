/**
 */
package org.js.graph.transformation.impl;


import org.eclipse.emf.common.notify.Notification;


import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;


import org.js.graph.transformation.AddEdges;
import org.js.graph.transformation.AddNodes;
import org.js.graph.transformation.Operations;
import org.js.graph.transformation.RemoveEdges;
import org.js.graph.transformation.RemoveNodes;
import org.js.graph.transformation.TransformationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operations</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.graph.transformation.impl.OperationsImpl#getRemoveEdges <em>Remove Edges</em>}</li>
 *   <li>{@link org.js.graph.transformation.impl.OperationsImpl#getRemoveNodes <em>Remove Nodes</em>}</li>
 *   <li>{@link org.js.graph.transformation.impl.OperationsImpl#getAddNodes <em>Add Nodes</em>}</li>
 *   <li>{@link org.js.graph.transformation.impl.OperationsImpl#getAddEdges <em>Add Edges</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationsImpl extends MinimalEObjectImpl.Container implements Operations {
	/**
	 * The cached value of the '{@link #getRemoveEdges() <em>Remove Edges</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoveEdges()
	 * @generated
	 * @ordered
	 */
	protected RemoveEdges removeEdges;
	/**
	 * The cached value of the '{@link #getRemoveNodes() <em>Remove Nodes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemoveNodes()
	 * @generated
	 * @ordered
	 */
	protected RemoveNodes removeNodes;
	/**
	 * The cached value of the '{@link #getAddNodes() <em>Add Nodes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddNodes()
	 * @generated
	 * @ordered
	 */
	protected AddNodes addNodes;
	/**
	 * The cached value of the '{@link #getAddEdges() <em>Add Edges</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddEdges()
	 * @generated
	 * @ordered
	 */
	protected AddEdges addEdges;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransformationPackage.Literals.OPERATIONS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveEdges getRemoveEdges() {
		return removeEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRemoveEdges(RemoveEdges newRemoveEdges, NotificationChain msgs) {
		RemoveEdges oldRemoveEdges = removeEdges;
		removeEdges = newRemoveEdges;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformationPackage.OPERATIONS__REMOVE_EDGES, oldRemoveEdges, newRemoveEdges);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoveEdges(RemoveEdges newRemoveEdges) {
		if (newRemoveEdges != removeEdges) {
			NotificationChain msgs = null;
			if (removeEdges != null)
				msgs = ((InternalEObject)removeEdges).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransformationPackage.OPERATIONS__REMOVE_EDGES, null, msgs);
			if (newRemoveEdges != null)
				msgs = ((InternalEObject)newRemoveEdges).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransformationPackage.OPERATIONS__REMOVE_EDGES, null, msgs);
			msgs = basicSetRemoveEdges(newRemoveEdges, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.OPERATIONS__REMOVE_EDGES, newRemoveEdges, newRemoveEdges));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveNodes getRemoveNodes() {
		return removeNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRemoveNodes(RemoveNodes newRemoveNodes, NotificationChain msgs) {
		RemoveNodes oldRemoveNodes = removeNodes;
		removeNodes = newRemoveNodes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformationPackage.OPERATIONS__REMOVE_NODES, oldRemoveNodes, newRemoveNodes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoveNodes(RemoveNodes newRemoveNodes) {
		if (newRemoveNodes != removeNodes) {
			NotificationChain msgs = null;
			if (removeNodes != null)
				msgs = ((InternalEObject)removeNodes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransformationPackage.OPERATIONS__REMOVE_NODES, null, msgs);
			if (newRemoveNodes != null)
				msgs = ((InternalEObject)newRemoveNodes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransformationPackage.OPERATIONS__REMOVE_NODES, null, msgs);
			msgs = basicSetRemoveNodes(newRemoveNodes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.OPERATIONS__REMOVE_NODES, newRemoveNodes, newRemoveNodes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddNodes getAddNodes() {
		return addNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddNodes(AddNodes newAddNodes, NotificationChain msgs) {
		AddNodes oldAddNodes = addNodes;
		addNodes = newAddNodes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformationPackage.OPERATIONS__ADD_NODES, oldAddNodes, newAddNodes);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddNodes(AddNodes newAddNodes) {
		if (newAddNodes != addNodes) {
			NotificationChain msgs = null;
			if (addNodes != null)
				msgs = ((InternalEObject)addNodes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransformationPackage.OPERATIONS__ADD_NODES, null, msgs);
			if (newAddNodes != null)
				msgs = ((InternalEObject)newAddNodes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransformationPackage.OPERATIONS__ADD_NODES, null, msgs);
			msgs = basicSetAddNodes(newAddNodes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.OPERATIONS__ADD_NODES, newAddNodes, newAddNodes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddEdges getAddEdges() {
		return addEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAddEdges(AddEdges newAddEdges, NotificationChain msgs) {
		AddEdges oldAddEdges = addEdges;
		addEdges = newAddEdges;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TransformationPackage.OPERATIONS__ADD_EDGES, oldAddEdges, newAddEdges);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAddEdges(AddEdges newAddEdges) {
		if (newAddEdges != addEdges) {
			NotificationChain msgs = null;
			if (addEdges != null)
				msgs = ((InternalEObject)addEdges).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TransformationPackage.OPERATIONS__ADD_EDGES, null, msgs);
			if (newAddEdges != null)
				msgs = ((InternalEObject)newAddEdges).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TransformationPackage.OPERATIONS__ADD_EDGES, null, msgs);
			msgs = basicSetAddEdges(newAddEdges, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.OPERATIONS__ADD_EDGES, newAddEdges, newAddEdges));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TransformationPackage.OPERATIONS__REMOVE_EDGES:
				return basicSetRemoveEdges(null, msgs);
			case TransformationPackage.OPERATIONS__REMOVE_NODES:
				return basicSetRemoveNodes(null, msgs);
			case TransformationPackage.OPERATIONS__ADD_NODES:
				return basicSetAddNodes(null, msgs);
			case TransformationPackage.OPERATIONS__ADD_EDGES:
				return basicSetAddEdges(null, msgs);
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
			case TransformationPackage.OPERATIONS__REMOVE_EDGES:
				return getRemoveEdges();
			case TransformationPackage.OPERATIONS__REMOVE_NODES:
				return getRemoveNodes();
			case TransformationPackage.OPERATIONS__ADD_NODES:
				return getAddNodes();
			case TransformationPackage.OPERATIONS__ADD_EDGES:
				return getAddEdges();
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
			case TransformationPackage.OPERATIONS__REMOVE_EDGES:
				setRemoveEdges((RemoveEdges)newValue);
				return;
			case TransformationPackage.OPERATIONS__REMOVE_NODES:
				setRemoveNodes((RemoveNodes)newValue);
				return;
			case TransformationPackage.OPERATIONS__ADD_NODES:
				setAddNodes((AddNodes)newValue);
				return;
			case TransformationPackage.OPERATIONS__ADD_EDGES:
				setAddEdges((AddEdges)newValue);
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
			case TransformationPackage.OPERATIONS__REMOVE_EDGES:
				setRemoveEdges((RemoveEdges)null);
				return;
			case TransformationPackage.OPERATIONS__REMOVE_NODES:
				setRemoveNodes((RemoveNodes)null);
				return;
			case TransformationPackage.OPERATIONS__ADD_NODES:
				setAddNodes((AddNodes)null);
				return;
			case TransformationPackage.OPERATIONS__ADD_EDGES:
				setAddEdges((AddEdges)null);
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
			case TransformationPackage.OPERATIONS__REMOVE_EDGES:
				return removeEdges != null;
			case TransformationPackage.OPERATIONS__REMOVE_NODES:
				return removeNodes != null;
			case TransformationPackage.OPERATIONS__ADD_NODES:
				return addNodes != null;
			case TransformationPackage.OPERATIONS__ADD_EDGES:
				return addEdges != null;
		}
		return super.eIsSet(featureID);
	}

} //OperationsImpl
