/**
 */
package org.js.model.stageconfig;

import org.eclipse.emf.ecore.EObject;

import org.js.model.feature.FeatureModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stage Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.model.stageconfig.StageModel#getFeatureModel <em>Feature Model</em>}</li>
 *   <li>{@link org.js.model.stageconfig.StageModel#getFirstStage <em>First Stage</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.model.stageconfig.StageconfigPackage#getStageModel()
 * @model
 * @generated
 */
public interface StageModel extends EObject {
	/**
    * Returns the value of the '<em><b>Feature Model</b></em>' reference.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Feature Model</em>' reference.
    * @see #setFeatureModel(FeatureModel)
    * @see org.js.model.stageconfig.StageconfigPackage#getStageModel_FeatureModel()
    * @model required="true"
    * @generated
    */
	FeatureModel getFeatureModel();

	/**
    * Sets the value of the '{@link org.js.model.stageconfig.StageModel#getFeatureModel <em>Feature Model</em>}' reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>Feature Model</em>' reference.
    * @see #getFeatureModel()
    * @generated
    */
	void setFeatureModel(FeatureModel value);

	/**
    * Returns the value of the '<em><b>First Stage</b></em>' containment reference.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Stage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>First Stage</em>' containment reference.
    * @see #setFirstStage(Stage)
    * @see org.js.model.stageconfig.StageconfigPackage#getStageModel_FirstStage()
    * @model containment="true"
    * @generated
    */
	Stage getFirstStage();

	/**
    * Sets the value of the '{@link org.js.model.stageconfig.StageModel#getFirstStage <em>First Stage</em>}' containment reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>First Stage</em>' containment reference.
    * @see #getFirstStage()
    * @generated
    */
	void setFirstStage(Stage value);

} // StageModel
