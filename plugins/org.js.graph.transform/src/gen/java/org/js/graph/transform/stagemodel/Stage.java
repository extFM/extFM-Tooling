/**
 */
package org.js.graph.transform.stagemodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transform.stagemodel.Stage#getName <em>Name</em>}</li>
 *   <li>{@link org.js.graph.transform.stagemodel.Stage#getId <em>Id</em>}</li>
 *   <li>{@link org.js.graph.transform.stagemodel.Stage#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link org.js.graph.transform.stagemodel.Stage#getSuccessor <em>Successor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transform.stagemodel.StagemodelPackage#getStage()
 * @model
 * @generated
 */
public interface Stage extends EObject {
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
    * @see org.js.graph.transform.stagemodel.StagemodelPackage#getStage_Name()
    * @model required="true"
    * @generated
    */
   String getName();

   /**
    * Sets the value of the '{@link org.js.graph.transform.stagemodel.Stage#getName <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Name</em>' attribute.
    * @see #getName()
    * @generated
    */
   void setName(String value);

   /**
    * Returns the value of the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Id</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Id</em>' attribute.
    * @see #setId(String)
    * @see org.js.graph.transform.stagemodel.StagemodelPackage#getStage_Id()
    * @model id="true" required="true"
    * @generated
    */
   String getId();

   /**
    * Sets the value of the '{@link org.js.graph.transform.stagemodel.Stage#getId <em>Id</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Id</em>' attribute.
    * @see #getId()
    * @generated
    */
   void setId(String value);

   /**
    * Returns the value of the '<em><b>Predecessor</b></em>' reference.
    * It is bidirectional and its opposite is '{@link org.js.graph.transform.stagemodel.Stage#getSuccessor <em>Successor</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Predecessor</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Predecessor</em>' reference.
    * @see #setPredecessor(Stage)
    * @see org.js.graph.transform.stagemodel.StagemodelPackage#getStage_Predecessor()
    * @see org.js.graph.transform.stagemodel.Stage#getSuccessor
    * @model opposite="successor"
    * @generated
    */
   Stage getPredecessor();

   /**
    * Sets the value of the '{@link org.js.graph.transform.stagemodel.Stage#getPredecessor <em>Predecessor</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Predecessor</em>' reference.
    * @see #getPredecessor()
    * @generated
    */
   void setPredecessor(Stage value);

   /**
    * Returns the value of the '<em><b>Successor</b></em>' reference.
    * It is bidirectional and its opposite is '{@link org.js.graph.transform.stagemodel.Stage#getPredecessor <em>Predecessor</em>}'.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Successor</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Successor</em>' reference.
    * @see #setSuccessor(Stage)
    * @see org.js.graph.transform.stagemodel.StagemodelPackage#getStage_Successor()
    * @see org.js.graph.transform.stagemodel.Stage#getPredecessor
    * @model opposite="predecessor"
    * @generated
    */
   Stage getSuccessor();

   /**
    * Sets the value of the '{@link org.js.graph.transform.stagemodel.Stage#getSuccessor <em>Successor</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Successor</em>' reference.
    * @see #getSuccessor()
    * @generated
    */
   void setSuccessor(Stage value);

} // Stage
