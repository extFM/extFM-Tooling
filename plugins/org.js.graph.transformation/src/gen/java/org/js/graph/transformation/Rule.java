/**
 */
package org.js.graph.transformation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.Rule#getLeftside <em>Leftside</em>}</li>
 *   <li>{@link org.js.graph.transformation.Rule#getRoles <em>Roles</em>}</li>
 *   <li>{@link org.js.graph.transformation.Rule#getApplicationConditions <em>Application Conditions</em>}</li>
 *   <li>{@link org.js.graph.transformation.Rule#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends Nameable {
	/**
    * Returns the value of the '<em><b>Leftside</b></em>' containment reference.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leftside</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Leftside</em>' containment reference.
    * @see #setLeftside(LeftSide)
    * @see org.js.graph.transformation.TransformationPackage#getRule_Leftside()
    * @model containment="true" required="true"
    * @generated
    */
	LeftSide getLeftside();

	/**
    * Sets the value of the '{@link org.js.graph.transformation.Rule#getLeftside <em>Leftside</em>}' containment reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>Leftside</em>' containment reference.
    * @see #getLeftside()
    * @generated
    */
	void setLeftside(LeftSide value);

	/**
    * Returns the value of the '<em><b>Roles</b></em>' containment reference.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Roles</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Roles</em>' containment reference.
    * @see #setRoles(Roles)
    * @see org.js.graph.transformation.TransformationPackage#getRule_Roles()
    * @model containment="true" required="true"
    * @generated
    */
	Roles getRoles();

	/**
    * Sets the value of the '{@link org.js.graph.transformation.Rule#getRoles <em>Roles</em>}' containment reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>Roles</em>' containment reference.
    * @see #getRoles()
    * @generated
    */
	void setRoles(Roles value);

	/**
    * Returns the value of the '<em><b>Application Conditions</b></em>' containment reference.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application Conditions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Application Conditions</em>' containment reference.
    * @see #setApplicationConditions(ApplicationConditions)
    * @see org.js.graph.transformation.TransformationPackage#getRule_ApplicationConditions()
    * @model containment="true" required="true"
    * @generated
    */
	ApplicationConditions getApplicationConditions();

	/**
    * Sets the value of the '{@link org.js.graph.transformation.Rule#getApplicationConditions <em>Application Conditions</em>}' containment reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>Application Conditions</em>' containment reference.
    * @see #getApplicationConditions()
    * @generated
    */
	void setApplicationConditions(ApplicationConditions value);

	/**
    * Returns the value of the '<em><b>Operations</b></em>' containment reference.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Operations</em>' containment reference.
    * @see #setOperations(Operations)
    * @see org.js.graph.transformation.TransformationPackage#getRule_Operations()
    * @model containment="true" required="true"
    * @generated
    */
	Operations getOperations();

	/**
    * Sets the value of the '{@link org.js.graph.transformation.Rule#getOperations <em>Operations</em>}' containment reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>Operations</em>' containment reference.
    * @see #getOperations()
    * @generated
    */
	void setOperations(Operations value);

} // Rule
