/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.model.viewmodel.ViewPoint#getContainedInGroup <em>Contained In Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.multi.perspective.model.viewmodel.ViewmodelPackage#getViewPoint()
 * @model
 * @generated
 */
public interface ViewPoint extends Element {
   /**
	 * Returns the value of the '<em><b>Contained In Group</b></em>' reference list.
	 * The list contents are of type {@link org.feature.multi.perspective.model.viewmodel.AbstractGroup}.
	 * It is bidirectional and its opposite is '{@link org.feature.multi.perspective.model.viewmodel.AbstractGroup#getViewPointReference <em>View Point Reference</em>}'.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Contained In Group</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained In Group</em>' reference list.
	 * @see org.feature.multi.perspective.model.viewmodel.ViewmodelPackage#getViewPoint_ContainedInGroup()
	 * @see org.feature.multi.perspective.model.viewmodel.AbstractGroup#getViewPointReference
	 * @model opposite="viewPointReference" changeable="false"
	 * @generated
	 */
   EList<AbstractGroup> getContainedInGroup();

} // ViewPoint
