/**
 */
package org.js.model.stageconfig;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.model.stageconfig.Stage#getOperations <em>Operations</em>}</li>
 *   <li>{@link org.js.model.stageconfig.Stage#getNextStage <em>Next Stage</em>}</li>
 *   <li>{@link org.js.model.stageconfig.Stage#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.model.stageconfig.StageconfigPackage#getStage()
 * @model
 * @generated
 */
public interface Stage extends EObject {
	/**
    * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
    * The list contents are of type {@link org.js.model.stageconfig.Operation}.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Operations</em>' containment reference list.
    * @see org.js.model.stageconfig.StageconfigPackage#getStage_Operations()
    * @model containment="true"
    * @generated
    */
	EList<Operation> getOperations();

	/**
    * Returns the value of the '<em><b>Next Stage</b></em>' containment reference.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Stage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Next Stage</em>' containment reference.
    * @see #setNextStage(Stage)
    * @see org.js.model.stageconfig.StageconfigPackage#getStage_NextStage()
    * @model containment="true"
    * @generated
    */
	Stage getNextStage();

	/**
    * Sets the value of the '{@link org.js.model.stageconfig.Stage#getNextStage <em>Next Stage</em>}' containment reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>Next Stage</em>' containment reference.
    * @see #getNextStage()
    * @generated
    */
	void setNextStage(Stage value);

	/**
    * Returns the value of the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Name</em>' attribute.
    * @see #setName(String)
    * @see org.js.model.stageconfig.StageconfigPackage#getStage_Name()
    * @model
    * @generated
    */
	String getName();

	/**
    * Sets the value of the '{@link org.js.model.stageconfig.Stage#getName <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>Name</em>' attribute.
    * @see #getName()
    * @generated
    */
	void setName(String value);

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @model
    * @generated
    */
	boolean hasNext();

} // Stage
