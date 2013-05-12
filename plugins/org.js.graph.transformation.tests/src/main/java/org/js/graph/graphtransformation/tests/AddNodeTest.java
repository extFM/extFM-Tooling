/**
 */
package org.js.graph.graphtransformation.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.js.graph.graphtransformation.AddNode;
import org.js.graph.graphtransformation.GraphtransformationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Add Node</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AddNodeTest extends TestCase {

	/**
	 * The fixture for this Add Node test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddNode fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AddNodeTest.class);
	}

	/**
	 * Constructs a new Add Node test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddNodeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Add Node test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AddNode fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Add Node test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddNode getFixture() {
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
		setFixture(GraphtransformationFactory.eINSTANCE.createAddNode());
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

} //AddNodeTest
