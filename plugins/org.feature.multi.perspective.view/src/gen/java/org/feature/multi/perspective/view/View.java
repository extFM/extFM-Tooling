/**
 */
package org.feature.multi.perspective.view;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.feature.multi.perspective.model.viewmodel.AbstractGroup;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.view.View#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.view.View#getId <em>Id</em>}</li>
 *   <li>{@link org.feature.multi.perspective.view.View#getViewgroups <em>Viewgroups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.multi.perspective.view.ViewPackage#getView()
 * @model
 * @generated
 */
public interface View extends EObject {
   /**
    * Returns the value of the '<em><b>Features</b></em>' reference list.
    * The list contents are of type {@link org.featuremapper.models.feature.Feature}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Features</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Features</em>' reference list.
    * @see org.feature.multi.perspective.view.ViewPackage#getView_Features()
    * @model
    * @generated
    */
   EList<Feature> getFeatures();

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
    * @see org.feature.multi.perspective.view.ViewPackage#getView_Id()
    * @model id="true" required="true"
    * @generated
    */
   String getId();

   /**
    * Sets the value of the '{@link org.feature.multi.perspective.view.View#getId <em>Id</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Id</em>' attribute.
    * @see #getId()
    * @generated
    */
   void setId(String value);

   /**
    * Returns the value of the '<em><b>Viewgroups</b></em>' reference list.
    * The list contents are of type {@link org.feature.multi.perspective.model.viewmodel.AbstractGroup}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Viewgroups</em>' reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Viewgroups</em>' reference list.
    * @see org.feature.multi.perspective.view.ViewPackage#getView_Viewgroups()
    * @model
    * @generated
    */
   EList<AbstractGroup> getViewgroups();

} // View
