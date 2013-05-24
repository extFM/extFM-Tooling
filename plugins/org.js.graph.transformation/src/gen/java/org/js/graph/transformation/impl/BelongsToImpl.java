/**
 */
package org.js.graph.transformation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.js.graph.transformation.BelongsTo;
import org.js.graph.transformation.TransformationPackage;
import org.js.graph.transformation.VariableRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Belongs To</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.graph.transformation.impl.BelongsToImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.js.graph.transformation.impl.BelongsToImpl#getLeader <em>Leader</em>}</li>
 *   <li>{@link org.js.graph.transformation.impl.BelongsToImpl#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BelongsToImpl extends MinimalEObjectImpl.Container implements BelongsTo {
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
	 * The cached value of the '{@link #getLeader() <em>Leader</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeader()
	 * @generated
	 * @ordered
	 */
	protected VariableRole leader;

	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected VariableRole member;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BelongsToImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TransformationPackage.Literals.BELONGS_TO;
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
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.BELONGS_TO__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableRole getLeader() {
		if (leader != null && leader.eIsProxy()) {
			InternalEObject oldLeader = (InternalEObject)leader;
			leader = (VariableRole)eResolveProxy(oldLeader);
			if (leader != oldLeader) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformationPackage.BELONGS_TO__LEADER, oldLeader, leader));
			}
		}
		return leader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableRole basicGetLeader() {
		return leader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeader(VariableRole newLeader) {
		VariableRole oldLeader = leader;
		leader = newLeader;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.BELONGS_TO__LEADER, oldLeader, leader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableRole getMember() {
		if (member != null && member.eIsProxy()) {
			InternalEObject oldMember = (InternalEObject)member;
			member = (VariableRole)eResolveProxy(oldMember);
			if (member != oldMember) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TransformationPackage.BELONGS_TO__MEMBER, oldMember, member));
			}
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableRole basicGetMember() {
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMember(VariableRole newMember) {
		VariableRole oldMember = member;
		member = newMember;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TransformationPackage.BELONGS_TO__MEMBER, oldMember, member));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TransformationPackage.BELONGS_TO__NAME:
				return getName();
			case TransformationPackage.BELONGS_TO__LEADER:
				if (resolve) return getLeader();
				return basicGetLeader();
			case TransformationPackage.BELONGS_TO__MEMBER:
				if (resolve) return getMember();
				return basicGetMember();
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
			case TransformationPackage.BELONGS_TO__NAME:
				setName((String)newValue);
				return;
			case TransformationPackage.BELONGS_TO__LEADER:
				setLeader((VariableRole)newValue);
				return;
			case TransformationPackage.BELONGS_TO__MEMBER:
				setMember((VariableRole)newValue);
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
			case TransformationPackage.BELONGS_TO__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TransformationPackage.BELONGS_TO__LEADER:
				setLeader((VariableRole)null);
				return;
			case TransformationPackage.BELONGS_TO__MEMBER:
				setMember((VariableRole)null);
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
			case TransformationPackage.BELONGS_TO__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TransformationPackage.BELONGS_TO__LEADER:
				return leader != null;
			case TransformationPackage.BELONGS_TO__MEMBER:
				return member != null;
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

} //BelongsToImpl
