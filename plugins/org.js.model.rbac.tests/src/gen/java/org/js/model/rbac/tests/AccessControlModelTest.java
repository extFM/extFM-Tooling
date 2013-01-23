/**
 */
package org.js.model.rbac.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.RbacFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Access Control Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AccessControlModelTest extends TestCase {

	/**
	 * The fixture for this Access Control Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessControlModel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AccessControlModelTest.class);
	}

	/**
	 * Constructs a new Access Control Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessControlModelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Access Control Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AccessControlModel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Access Control Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessControlModel getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RbacFactory.eINSTANCE.createAccessControlModel());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //AccessControlModelTest
