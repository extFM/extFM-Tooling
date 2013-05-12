/**
 */
package org.js.graph.graphtransformation.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.js.graph.graphtransformation.GraphtransformationFactory;
import org.js.graph.graphtransformation.RemoveNode;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Remove Node</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class RemoveNodeTest extends TestCase {

	/**
	 * The fixture for this Remove Node test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveNode fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(RemoveNodeTest.class);
	}

	/**
	 * Constructs a new Remove Node test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveNodeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Remove Node test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(RemoveNode fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Remove Node test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RemoveNode getFixture() {
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
		setFixture(GraphtransformationFactory.eINSTANCE.createRemoveNode());
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

} //RemoveNodeTest
