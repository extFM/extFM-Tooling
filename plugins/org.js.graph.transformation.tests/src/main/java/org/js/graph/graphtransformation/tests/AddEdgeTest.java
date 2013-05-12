/**
 */
package org.js.graph.graphtransformation.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.js.graph.graphtransformation.AddEdge;
import org.js.graph.graphtransformation.GraphtransformationFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Add Edge</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AddEdgeTest extends TestCase {

	/**
	 * The fixture for this Add Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddEdge fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AddEdgeTest.class);
	}

	/**
	 * Constructs a new Add Edge test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AddEdgeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Add Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AddEdge fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Add Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddEdge getFixture() {
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
		setFixture(GraphtransformationFactory.eINSTANCE.createAddEdge());
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

} //AddEdgeTest
