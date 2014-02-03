/**
 */
package org.js.graph.transform.stagemodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stage Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transform.stagemodel.StageModel#getStages <em>Stages</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transform.stagemodel.StagemodelPackage#getStageModel()
 * @model
 * @generated
 */
public interface StageModel extends EObject {
   /**
    * Returns the value of the '<em><b>Stages</b></em>' containment reference list.
    * The list contents are of type {@link org.js.graph.transform.stagemodel.Stage}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Stages</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Stages</em>' containment reference list.
    * @see org.js.graph.transform.stagemodel.StagemodelPackage#getStageModel_Stages()
    * @model containment="true"
    * @generated
    */
   EList<Stage> getStages();

} // StageModel
