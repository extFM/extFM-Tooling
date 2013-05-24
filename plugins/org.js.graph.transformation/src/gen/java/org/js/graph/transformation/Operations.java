/**
 */
package org.js.graph.transformation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.js.graph.transformation.Operations#getChangePrimitives <em>Change Primitives</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.js.graph.transformation.TransformationPackage#getOperations()
 * @model
 * @generated
 */
public interface Operations extends EObject {
	/**
	 * Returns the value of the '<em><b>Change Primitives</b></em>' containment reference list.
	 * The list contents are of type {@link org.js.graph.transformation.ChangePrimitive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Primitives</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Primitives</em>' containment reference list.
	 * @see org.js.graph.transformation.TransformationPackage#getOperations_ChangePrimitives()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ChangePrimitive> getChangePrimitives();

} // Operations
