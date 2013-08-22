/**
 */
package org.js.model.workflow;

import org.eclipse.jwt.we.conf.model.AspectInstance;

import org.js.graph.transformation.GraphTransformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graph Trans Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.model.workflow.GraphTransConnector#getGraphTransref <em>Graph Transref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.model.workflow.WorkflowPackage#getGraphTransConnector()
 * @model
 * @generated
 */
public interface GraphTransConnector extends AspectInstance {
	/**
    * Returns the value of the '<em><b>Graph Transref</b></em>' reference.
    * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Graph Transref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
    * @return the value of the '<em>Graph Transref</em>' reference.
    * @see #setGraphTransref(GraphTransformation)
    * @see org.js.model.workflow.WorkflowPackage#getGraphTransConnector_GraphTransref()
    * @model
    * @generated
    */
	GraphTransformation getGraphTransref();

	/**
    * Sets the value of the '{@link org.js.model.workflow.GraphTransConnector#getGraphTransref <em>Graph Transref</em>}' reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @param value the new value of the '<em>Graph Transref</em>' reference.
    * @see #getGraphTransref()
    * @generated
    */
	void setGraphTransref(GraphTransformation value);

} // GraphTransConnector
