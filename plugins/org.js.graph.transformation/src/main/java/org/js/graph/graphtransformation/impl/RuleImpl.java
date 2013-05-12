/**
 */
package org.js.graph.graphtransformation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.js.graph.graphtransformation.ApplicationConditions;
import org.js.graph.graphtransformation.GraphtransformationPackage;
import org.js.graph.graphtransformation.LeftSide;
import org.js.graph.graphtransformation.Operations;
import org.js.graph.graphtransformation.Roles;
import org.js.graph.graphtransformation.Rule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.graph.graphtransformation.impl.RuleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.js.graph.graphtransformation.impl.RuleImpl#getLeftside <em>Leftside</em>}</li>
 *   <li>{@link org.js.graph.graphtransformation.impl.RuleImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.js.graph.graphtransformation.impl.RuleImpl#getApplicationConditions <em>Application Conditions</em>}</li>
 *   <li>{@link org.js.graph.graphtransformation.impl.RuleImpl#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleImpl extends EObjectImpl implements Rule {
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
	 * The cached value of the '{@link #getLeftside() <em>Leftside</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftside()
	 * @generated
	 * @ordered
	 */
	protected LeftSide leftside;

	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected Roles roles;

	/**
	 * The cached value of the '{@link #getApplicationConditions() <em>Application Conditions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplicationConditions()
	 * @generated
	 * @ordered
	 */
	protected ApplicationConditions applicationConditions;

	/**
	 * The cached value of the '{@link #getOperations() <em>Operations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperations()
	 * @generated
	 * @ordered
	 */
	protected Operations operations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphtransformationPackage.Literals.RULE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.RULE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LeftSide getLeftside() {
		return leftside;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftside(LeftSide newLeftside, NotificationChain msgs) {
		LeftSide oldLeftside = leftside;
		leftside = newLeftside;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.RULE__LEFTSIDE, oldLeftside, newLeftside);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftside(LeftSide newLeftside) {
		if (newLeftside != leftside) {
			NotificationChain msgs = null;
			if (leftside != null)
				msgs = ((InternalEObject)leftside).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphtransformationPackage.RULE__LEFTSIDE, null, msgs);
			if (newLeftside != null)
				msgs = ((InternalEObject)newLeftside).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphtransformationPackage.RULE__LEFTSIDE, null, msgs);
			msgs = basicSetLeftside(newLeftside, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.RULE__LEFTSIDE, newLeftside, newLeftside));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operations getOperations() {
		return operations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperations(Operations newOperations, NotificationChain msgs) {
		Operations oldOperations = operations;
		operations = newOperations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.RULE__OPERATIONS, oldOperations, newOperations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperations(Operations newOperations) {
		if (newOperations != operations) {
			NotificationChain msgs = null;
			if (operations != null)
				msgs = ((InternalEObject)operations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphtransformationPackage.RULE__OPERATIONS, null, msgs);
			if (newOperations != null)
				msgs = ((InternalEObject)newOperations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphtransformationPackage.RULE__OPERATIONS, null, msgs);
			msgs = basicSetOperations(newOperations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.RULE__OPERATIONS, newOperations, newOperations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Roles getRoles() {
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoles(Roles newRoles, NotificationChain msgs) {
		Roles oldRoles = roles;
		roles = newRoles;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.RULE__ROLES, oldRoles, newRoles);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoles(Roles newRoles) {
		if (newRoles != roles) {
			NotificationChain msgs = null;
			if (roles != null)
				msgs = ((InternalEObject)roles).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphtransformationPackage.RULE__ROLES, null, msgs);
			if (newRoles != null)
				msgs = ((InternalEObject)newRoles).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphtransformationPackage.RULE__ROLES, null, msgs);
			msgs = basicSetRoles(newRoles, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.RULE__ROLES, newRoles, newRoles));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ApplicationConditions getApplicationConditions() {
		return applicationConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplicationConditions(ApplicationConditions newApplicationConditions, NotificationChain msgs) {
		ApplicationConditions oldApplicationConditions = applicationConditions;
		applicationConditions = newApplicationConditions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.RULE__APPLICATION_CONDITIONS, oldApplicationConditions, newApplicationConditions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplicationConditions(ApplicationConditions newApplicationConditions) {
		if (newApplicationConditions != applicationConditions) {
			NotificationChain msgs = null;
			if (applicationConditions != null)
				msgs = ((InternalEObject)applicationConditions).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphtransformationPackage.RULE__APPLICATION_CONDITIONS, null, msgs);
			if (newApplicationConditions != null)
				msgs = ((InternalEObject)newApplicationConditions).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphtransformationPackage.RULE__APPLICATION_CONDITIONS, null, msgs);
			msgs = basicSetApplicationConditions(newApplicationConditions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphtransformationPackage.RULE__APPLICATION_CONDITIONS, newApplicationConditions, newApplicationConditions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GraphtransformationPackage.RULE__LEFTSIDE:
				return basicSetLeftside(null, msgs);
			case GraphtransformationPackage.RULE__ROLES:
				return basicSetRoles(null, msgs);
			case GraphtransformationPackage.RULE__APPLICATION_CONDITIONS:
				return basicSetApplicationConditions(null, msgs);
			case GraphtransformationPackage.RULE__OPERATIONS:
				return basicSetOperations(null, msgs);
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
			case GraphtransformationPackage.RULE__NAME:
				return getName();
			case GraphtransformationPackage.RULE__LEFTSIDE:
				return getLeftside();
			case GraphtransformationPackage.RULE__ROLES:
				return getRoles();
			case GraphtransformationPackage.RULE__APPLICATION_CONDITIONS:
				return getApplicationConditions();
			case GraphtransformationPackage.RULE__OPERATIONS:
				return getOperations();
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
			case GraphtransformationPackage.RULE__NAME:
				setName((String)newValue);
				return;
			case GraphtransformationPackage.RULE__LEFTSIDE:
				setLeftside((LeftSide)newValue);
				return;
			case GraphtransformationPackage.RULE__ROLES:
				setRoles((Roles)newValue);
				return;
			case GraphtransformationPackage.RULE__APPLICATION_CONDITIONS:
				setApplicationConditions((ApplicationConditions)newValue);
				return;
			case GraphtransformationPackage.RULE__OPERATIONS:
				setOperations((Operations)newValue);
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
			case GraphtransformationPackage.RULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphtransformationPackage.RULE__LEFTSIDE:
				setLeftside((LeftSide)null);
				return;
			case GraphtransformationPackage.RULE__ROLES:
				setRoles((Roles)null);
				return;
			case GraphtransformationPackage.RULE__APPLICATION_CONDITIONS:
				setApplicationConditions((ApplicationConditions)null);
				return;
			case GraphtransformationPackage.RULE__OPERATIONS:
				setOperations((Operations)null);
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
			case GraphtransformationPackage.RULE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphtransformationPackage.RULE__LEFTSIDE:
				return leftside != null;
			case GraphtransformationPackage.RULE__ROLES:
				return roles != null;
			case GraphtransformationPackage.RULE__APPLICATION_CONDITIONS:
				return applicationConditions != null;
			case GraphtransformationPackage.RULE__OPERATIONS:
				return operations != null;
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

} //RuleImpl
