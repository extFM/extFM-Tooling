/**
 */
package org.js.model.rbac.tests;

import junit.textui.TestRunner;

import org.js.model.rbac.CreateFeatureModel;
import org.js.model.rbac.RbacFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Create Feature Model</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CreateFeatureModelTest extends EngineeringOperationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CreateFeatureModelTest.class);
	}

	/**
	 * Constructs a new Create Feature Model test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateFeatureModelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Create Feature Model test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CreateFeatureModel getFixture() {
		return (CreateFeatureModel)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(RbacFactory.eINSTANCE.createCreateFeatureModel());
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

} //CreateFeatureModelTest
