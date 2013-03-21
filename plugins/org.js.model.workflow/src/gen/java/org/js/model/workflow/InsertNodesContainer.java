/**
 */
package org.js.model.workflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.jwt.we.conf.model.AspectInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Insert Nodes Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.model.workflow.InsertNodesContainer#getInsertnodes <em>Insertnodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.model.workflow.WorkflowPackage#getInsertNodesContainer()
 * @model
 * @generated
 */
public interface InsertNodesContainer extends AspectInstance {
	/**
	 * Returns the value of the '<em><b>Insertnodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.js.model.workflow.InsertNodes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Insertnodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Insertnodes</em>' containment reference list.
	 * @see org.js.model.workflow.WorkflowPackage#getInsertNodesContainer_Insertnodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<InsertNodes> getInsertnodes();

} // InsertNodesContainer
