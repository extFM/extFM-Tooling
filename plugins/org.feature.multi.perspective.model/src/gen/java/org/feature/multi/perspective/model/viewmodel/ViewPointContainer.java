/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Point Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.model.viewmodel.ViewPointContainer#getViewPoints <em>View Points</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.multi.perspective.model.viewmodel.ViewmodelPackage#getViewPointContainer()
 * @model
 * @generated
 */
public interface ViewPointContainer extends EObject {
   /**
	 * Returns the value of the '<em><b>View Points</b></em>' containment reference list.
	 * The list contents are of type {@link org.feature.multi.perspective.model.viewmodel.ViewPoint}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>View Points</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>View Points</em>' containment reference list.
	 * @see org.feature.multi.perspective.model.viewmodel.ViewmodelPackage#getViewPointContainer_ViewPoints()
	 * @model containment="true"
	 * @generated
	 */
   EList<ViewPoint> getViewPoints();

} // ViewPointContainer
