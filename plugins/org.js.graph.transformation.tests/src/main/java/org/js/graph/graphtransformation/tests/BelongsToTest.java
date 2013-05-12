/**
 */
package org.js.graph.graphtransformation.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.js.graph.graphtransformation.BelongsTo;
import org.js.graph.graphtransformation.GraphtransformationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Belongs To</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BelongsToTest extends TestCase {

	/**
	 * The fixture for this Belongs To test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BelongsTo fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BelongsToTest.class);
	}

	/**
	 * Constructs a new Belongs To test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BelongsToTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Belongs To test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(BelongsTo fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Belongs To test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BelongsTo getFixture() {
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
		setFixture(GraphtransformationFactory.eINSTANCE.createBelongsTo());
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

} //BelongsToTest
