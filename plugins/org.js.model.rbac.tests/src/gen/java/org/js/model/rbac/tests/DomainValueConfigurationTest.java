/**
 */
package org.js.model.rbac.tests;

import junit.textui.TestRunner;

import org.js.model.rbac.DomainValueConfiguration;
import org.js.model.rbac.RbacFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Domain Value Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class DomainValueConfigurationTest extends ConfigurationOperationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(DomainValueConfigurationTest.class);
	}

	/**
	 * Constructs a new Domain Value Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainValueConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Domain Value Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected DomainValueConfiguration getFixture() {
		return (DomainValueConfiguration)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RbacFactory.eINSTANCE.createDomainValueConfiguration());
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

} //DomainValueConfigurationTest
