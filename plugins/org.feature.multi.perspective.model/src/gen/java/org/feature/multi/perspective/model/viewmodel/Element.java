/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.model.viewmodel.Element#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.multi.perspective.model.viewmodel.ViewmodelPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element extends EObject {
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
	 * @see org.feature.multi.perspective.model.viewmodel.ViewmodelPackage#getElement_Name()
	 * @model id="true"
	 * @generated
	 */
   String getName();

   /**
	 * Sets the value of the '{@link org.feature.multi.perspective.model.viewmodel.Element#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
   void setName(String value);

} // Element
