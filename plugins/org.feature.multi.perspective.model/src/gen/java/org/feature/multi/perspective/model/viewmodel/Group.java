/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.model.viewmodel.Group#getParentGroup <em>Parent Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.multi.perspective.model.viewmodel.ViewmodelPackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends AbstractGroup {
   /**
	 * Returns the value of the '<em><b>Parent Group</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.feature.multi.perspective.model.viewmodel.AbstractGroup#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Parent Group</em>' container reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Group</em>' container reference.
	 * @see #setParentGroup(AbstractGroup)
	 * @see org.feature.multi.perspective.model.viewmodel.ViewmodelPackage#getGroup_ParentGroup()
	 * @see org.feature.multi.perspective.model.viewmodel.AbstractGroup#getGroups
	 * @model opposite="groups" transient="false"
	 * @generated
	 */
   AbstractGroup getParentGroup();

   /**
	 * Sets the value of the '{@link org.feature.multi.perspective.model.viewmodel.Group#getParentGroup <em>Parent Group</em>}' container reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Group</em>' container reference.
	 * @see #getParentGroup()
	 * @generated
	 */
   void setParentGroup(AbstractGroup value);

} // Group
