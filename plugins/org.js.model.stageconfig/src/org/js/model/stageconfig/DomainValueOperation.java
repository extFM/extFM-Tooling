/**
 */
package org.js.model.stageconfig;

import org.js.model.feature.Attribute;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Value Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.model.stageconfig.DomainValueOperation#getValue <em>Value</em>}</li>
 *   <li>{@link org.js.model.stageconfig.DomainValueOperation#getAttribute <em>Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.model.stageconfig.StageconfigPackage#getDomainValueOperation()
 * @model
 * @generated
 */
public interface DomainValueOperation extends Operation {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.js.model.stageconfig.StageconfigPackage#getDomainValueOperation_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.js.model.stageconfig.DomainValueOperation#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference.
	 * @see #setAttribute(Attribute)
	 * @see org.js.model.stageconfig.StageconfigPackage#getDomainValueOperation_Attribute()
	 * @model required="true"
	 * @generated
	 */
	Attribute getAttribute();

	/**
	 * Sets the value of the '{@link org.js.model.stageconfig.DomainValueOperation#getAttribute <em>Attribute</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(Attribute value);

} // DomainValueOperation
