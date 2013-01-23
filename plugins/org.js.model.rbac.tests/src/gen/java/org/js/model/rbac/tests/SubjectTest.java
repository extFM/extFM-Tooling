/**
 */
package org.js.model.rbac.tests;

import junit.textui.TestRunner;

import org.js.model.rbac.RbacFactory;
import org.js.model.rbac.Subject;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Subject</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SubjectTest extends NameableTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SubjectTest.class);
	}

	/**
	 * Constructs a new Subject test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubjectTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Subject test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Subject getFixture() {
		return (Subject)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RbacFactory.eINSTANCE.createSubject());
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

} //SubjectTest
