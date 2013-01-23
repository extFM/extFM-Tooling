/**
 */
package org.js.model.rbac.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.js.model.rbac.FeatureReference;
import org.js.model.rbac.RbacFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Feature Reference</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureReferenceTest extends TestCase {

	/**
	 * The fixture for this Feature Reference test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureReference fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FeatureReferenceTest.class);
	}

	/**
	 * Constructs a new Feature Reference test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureReferenceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Feature Reference test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(FeatureReference fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Feature Reference test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureReference getFixture() {
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
		setFixture(RbacFactory.eINSTANCE.createFeatureReference());
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

} //FeatureReferenceTest
