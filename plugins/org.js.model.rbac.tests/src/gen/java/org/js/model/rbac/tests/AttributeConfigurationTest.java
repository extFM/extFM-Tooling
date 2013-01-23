/**
 */
package org.js.model.rbac.tests;

import junit.textui.TestRunner;

import org.js.model.rbac.AttributeConfiguration;
import org.js.model.rbac.RbacFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Attribute Configuration</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeConfigurationTest extends ConfigurationOperationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AttributeConfigurationTest.class);
	}

	/**
	 * Constructs a new Attribute Configuration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeConfigurationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Attribute Configuration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected AttributeConfiguration getFixture() {
		return (AttributeConfiguration)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RbacFactory.eINSTANCE.createAttributeConfiguration());
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

} //AttributeConfigurationTest
