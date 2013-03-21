/**
 */
package org.js.model.workflow;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.eclipse.jwt.meta.model.processes.JoinNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Insert Nodes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.model.workflow.InsertNodes#getJoinnode <em>Joinnode</em>}</li>
 *   <li>{@link org.js.model.workflow.InsertNodes#getForknode <em>Forknode</em>}</li>
 *   <li>{@link org.js.model.workflow.InsertNodes#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.model.workflow.WorkflowPackage#getInsertNodes()
 * @model
 * @generated
 */
public interface InsertNodes extends EObject {
	/**
	 * Returns the value of the '<em><b>Joinnode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Joinnode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Joinnode</em>' reference.
	 * @see #setJoinnode(JoinNode)
	 * @see org.js.model.workflow.WorkflowPackage#getInsertNodes_Joinnode()
	 * @model
	 * @generated
	 */
	JoinNode getJoinnode();

	/**
	 * Sets the value of the '{@link org.js.model.workflow.InsertNodes#getJoinnode <em>Joinnode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Joinnode</em>' reference.
	 * @see #getJoinnode()
	 * @generated
	 */
	void setJoinnode(JoinNode value);

	/**
	 * Returns the value of the '<em><b>Forknode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forknode</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forknode</em>' reference.
	 * @see #setForknode(ForkNode)
	 * @see org.js.model.workflow.WorkflowPackage#getInsertNodes_Forknode()
	 * @model
	 * @generated
	 */
	ForkNode getForknode();

	/**
	 * Sets the value of the '{@link org.js.model.workflow.InsertNodes#getForknode <em>Forknode</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forknode</em>' reference.
	 * @see #getForknode()
	 * @generated
	 */
	void setForknode(ForkNode value);

	/**
	 * Returns the value of the '<em><b>Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action</em>' reference.
	 * @see #setAction(Action)
	 * @see org.js.model.workflow.WorkflowPackage#getInsertNodes_Action()
	 * @model
	 * @generated
	 */
	Action getAction();

	/**
	 * Sets the value of the '{@link org.js.model.workflow.InsertNodes#getAction <em>Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action</em>' reference.
	 * @see #getAction()
	 * @generated
	 */
	void setAction(Action value);

} // InsertNodes
