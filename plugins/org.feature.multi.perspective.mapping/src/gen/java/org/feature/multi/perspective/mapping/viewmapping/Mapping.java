/**
 */
package org.feature.multi.perspective.mapping.viewmapping;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.feature.multi.perspective.model.viewmodel.AbstractGroup;

import org.featuremapper.models.feature.Feature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.feature.multi.perspective.mapping.viewmapping.Mapping#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.feature.multi.perspective.mapping.viewmapping.Mapping#getViewgroup <em>Viewgroup</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends EObject {
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
    * @see org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage#getMapping_Features()
    * @model
    * @generated
    */
   EList<Feature> getFeatures();

   /**
    * Returns the value of the '<em><b>Viewgroup</b></em>' reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Viewgroup</em>' reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Viewgroup</em>' reference.
    * @see #setViewgroup(AbstractGroup)
    * @see org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage#getMapping_Viewgroup()
    * @model required="true"
    * @generated
    */
   AbstractGroup getViewgroup();

   /**
    * Sets the value of the '{@link org.feature.multi.perspective.mapping.viewmapping.Mapping#getViewgroup <em>Viewgroup</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Viewgroup</em>' reference.
    * @see #getViewgroup()
    * @generated
    */
   void setViewgroup(AbstractGroup value);

} // Mapping
