/**
 */
package org.feature.multi.perspective.mapping.viewmapping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory
 * @model kind="package"
 * @generated
 */
public interface ViewmappingPackage extends EPackage {
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNAME = "viewmapping";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_URI = "http://www.tudresden.de/viewmapping";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_PREFIX = "viewmapping";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   ViewmappingPackage eINSTANCE = org.feature.multi.perspective.mapping.viewmapping.impl.ViewmappingPackageImpl.init();

   /**
    * The meta object id for the '{@link org.feature.multi.perspective.mapping.viewmapping.impl.MappingModelImpl <em>Mapping Model</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.feature.multi.perspective.mapping.viewmapping.impl.MappingModelImpl
    * @see org.feature.multi.perspective.mapping.viewmapping.impl.ViewmappingPackageImpl#getMappingModel()
    * @generated
    */
   int MAPPING_MODEL = 0;

   /**
    * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING_MODEL__MAPPINGS = 0;

   /**
    * The feature id for the '<em><b>Feature Model</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING_MODEL__FEATURE_MODEL = 1;

   /**
    * The feature id for the '<em><b>View Model</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING_MODEL__VIEW_MODEL = 2;

   /**
    * The number of structural features of the '<em>Mapping Model</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING_MODEL_FEATURE_COUNT = 3;

   /**
    * The meta object id for the '{@link org.feature.multi.perspective.mapping.viewmapping.impl.MappingImpl <em>Mapping</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.feature.multi.perspective.mapping.viewmapping.impl.MappingImpl
    * @see org.feature.multi.perspective.mapping.viewmapping.impl.ViewmappingPackageImpl#getMapping()
    * @generated
    */
   int MAPPING = 1;

   /**
    * The feature id for the '<em><b>Features</b></em>' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING__FEATURES = 0;

   /**
    * The feature id for the '<em><b>Viewgroup</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING__VIEWGROUP = 1;

   /**
    * The number of structural features of the '<em>Mapping</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int MAPPING_FEATURE_COUNT = 2;


   /**
    * Returns the meta object for class '{@link org.feature.multi.perspective.mapping.viewmapping.MappingModel <em>Mapping Model</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Mapping Model</em>'.
    * @see org.feature.multi.perspective.mapping.viewmapping.MappingModel
    * @generated
    */
   EClass getMappingModel();

   /**
    * Returns the meta object for the containment reference list '{@link org.feature.multi.perspective.mapping.viewmapping.MappingModel#getMappings <em>Mappings</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Mappings</em>'.
    * @see org.feature.multi.perspective.mapping.viewmapping.MappingModel#getMappings()
    * @see #getMappingModel()
    * @generated
    */
   EReference getMappingModel_Mappings();

   /**
    * Returns the meta object for the reference '{@link org.feature.multi.perspective.mapping.viewmapping.MappingModel#getFeatureModel <em>Feature Model</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Feature Model</em>'.
    * @see org.feature.multi.perspective.mapping.viewmapping.MappingModel#getFeatureModel()
    * @see #getMappingModel()
    * @generated
    */
   EReference getMappingModel_FeatureModel();

   /**
    * Returns the meta object for the reference '{@link org.feature.multi.perspective.mapping.viewmapping.MappingModel#getViewModel <em>View Model</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>View Model</em>'.
    * @see org.feature.multi.perspective.mapping.viewmapping.MappingModel#getViewModel()
    * @see #getMappingModel()
    * @generated
    */
   EReference getMappingModel_ViewModel();

   /**
    * Returns the meta object for class '{@link org.feature.multi.perspective.mapping.viewmapping.Mapping <em>Mapping</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Mapping</em>'.
    * @see org.feature.multi.perspective.mapping.viewmapping.Mapping
    * @generated
    */
   EClass getMapping();

   /**
    * Returns the meta object for the reference list '{@link org.feature.multi.perspective.mapping.viewmapping.Mapping#getFeatures <em>Features</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference list '<em>Features</em>'.
    * @see org.feature.multi.perspective.mapping.viewmapping.Mapping#getFeatures()
    * @see #getMapping()
    * @generated
    */
   EReference getMapping_Features();

   /**
    * Returns the meta object for the reference '{@link org.feature.multi.perspective.mapping.viewmapping.Mapping#getViewgroup <em>Viewgroup</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Viewgroup</em>'.
    * @see org.feature.multi.perspective.mapping.viewmapping.Mapping#getViewgroup()
    * @see #getMapping()
    * @generated
    */
   EReference getMapping_Viewgroup();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the factory that creates the instances of the model.
    * @generated
    */
   ViewmappingFactory getViewmappingFactory();

   /**
    * <!-- begin-user-doc -->
    * Defines literals for the meta objects that represent
    * <ul>
    *   <li>each class,</li>
    *   <li>each feature of each class,</li>
    *   <li>each enum,</li>
    *   <li>and each data type</li>
    * </ul>
    * <!-- end-user-doc -->
    * @generated
    */
   interface Literals {
      /**
       * The meta object literal for the '{@link org.feature.multi.perspective.mapping.viewmapping.impl.MappingModelImpl <em>Mapping Model</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.feature.multi.perspective.mapping.viewmapping.impl.MappingModelImpl
       * @see org.feature.multi.perspective.mapping.viewmapping.impl.ViewmappingPackageImpl#getMappingModel()
       * @generated
       */
      EClass MAPPING_MODEL = eINSTANCE.getMappingModel();

      /**
       * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference MAPPING_MODEL__MAPPINGS = eINSTANCE.getMappingModel_Mappings();

      /**
       * The meta object literal for the '<em><b>Feature Model</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference MAPPING_MODEL__FEATURE_MODEL = eINSTANCE.getMappingModel_FeatureModel();

      /**
       * The meta object literal for the '<em><b>View Model</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference MAPPING_MODEL__VIEW_MODEL = eINSTANCE.getMappingModel_ViewModel();

      /**
       * The meta object literal for the '{@link org.feature.multi.perspective.mapping.viewmapping.impl.MappingImpl <em>Mapping</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.feature.multi.perspective.mapping.viewmapping.impl.MappingImpl
       * @see org.feature.multi.perspective.mapping.viewmapping.impl.ViewmappingPackageImpl#getMapping()
       * @generated
       */
      EClass MAPPING = eINSTANCE.getMapping();

      /**
       * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference MAPPING__FEATURES = eINSTANCE.getMapping_Features();

      /**
       * The meta object literal for the '<em><b>Viewgroup</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference MAPPING__VIEWGROUP = eINSTANCE.getMapping_Viewgroup();

   }

} //ViewmappingPackage
