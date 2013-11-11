/**
 */
package org.feature.multi.perspective.view;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.feature.multi.perspective.mapping.viewmapping.MappingModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.view.ViewContainer#getViews <em>Views</em>}</li>
 *   <li>{@link org.feature.multi.perspective.view.ViewContainer#getFeatureMapping <em>Feature Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.multi.perspective.view.ViewPackage#getViewContainer()
 * @model
 * @generated
 */
public interface ViewContainer extends EObject {
   /**
    * Returns the value of the '<em><b>Views</b></em>' containment reference list.
    * The list contents are of type {@link org.feature.multi.perspective.view.View}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Views</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Views</em>' containment reference list.
    * @see org.feature.multi.perspective.view.ViewPackage#getViewContainer_Views()
    * @model containment="true"
    * @generated
    */
   EList<View> getViews();

   /**
    * Returns the value of the '<em><b>Feature Mapping</b></em>' reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Feature Mapping</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Feature Mapping</em>' reference.
    * @see #setFeatureMapping(MappingModel)
    * @see org.feature.multi.perspective.view.ViewPackage#getViewContainer_FeatureMapping()
    * @model required="true"
    * @generated
    */
   MappingModel getFeatureMapping();

   /**
    * Sets the value of the '{@link org.feature.multi.perspective.view.ViewContainer#getFeatureMapping <em>Feature Mapping</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Feature Mapping</em>' reference.
    * @see #getFeatureMapping()
    * @generated
    */
   void setFeatureMapping(MappingModel value);

} // ViewContainer
