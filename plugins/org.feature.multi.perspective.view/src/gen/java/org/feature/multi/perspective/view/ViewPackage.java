/**
 */
package org.feature.multi.perspective.view;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.feature.multi.perspective.view.ViewFactory
 * @model kind="package"
 * @generated
 */
public interface ViewPackage extends EPackage {
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNAME = "view";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_URI = "http://www.conper.de/view";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_PREFIX = "view";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   ViewPackage eINSTANCE = org.feature.multi.perspective.view.impl.ViewPackageImpl.init();

   /**
    * The meta object id for the '{@link org.feature.multi.perspective.view.impl.ViewContainerImpl <em>Container</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.feature.multi.perspective.view.impl.ViewContainerImpl
    * @see org.feature.multi.perspective.view.impl.ViewPackageImpl#getViewContainer()
    * @generated
    */
   int VIEW_CONTAINER = 0;

   /**
    * The feature id for the '<em><b>Views</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VIEW_CONTAINER__VIEWS = 0;

   /**
    * The feature id for the '<em><b>Feature Mapping</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VIEW_CONTAINER__FEATURE_MAPPING = 1;

   /**
    * The number of structural features of the '<em>Container</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VIEW_CONTAINER_FEATURE_COUNT = 2;

   /**
    * The meta object id for the '{@link org.feature.multi.perspective.view.impl.ViewImpl <em>View</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.feature.multi.perspective.view.impl.ViewImpl
    * @see org.feature.multi.perspective.view.impl.ViewPackageImpl#getView()
    * @generated
    */
   int VIEW = 1;

   /**
    * The feature id for the '<em><b>Features</b></em>' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VIEW__FEATURES = 0;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VIEW__ID = 1;

   /**
    * The feature id for the '<em><b>Viewgroups</b></em>' reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VIEW__VIEWGROUPS = 2;

   /**
    * The number of structural features of the '<em>View</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int VIEW_FEATURE_COUNT = 3;


   /**
    * Returns the meta object for class '{@link org.feature.multi.perspective.view.ViewContainer <em>Container</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Container</em>'.
    * @see org.feature.multi.perspective.view.ViewContainer
    * @generated
    */
   EClass getViewContainer();

   /**
    * Returns the meta object for the containment reference list '{@link org.feature.multi.perspective.view.ViewContainer#getViews <em>Views</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Views</em>'.
    * @see org.feature.multi.perspective.view.ViewContainer#getViews()
    * @see #getViewContainer()
    * @generated
    */
   EReference getViewContainer_Views();

   /**
    * Returns the meta object for the reference '{@link org.feature.multi.perspective.view.ViewContainer#getFeatureMapping <em>Feature Mapping</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Feature Mapping</em>'.
    * @see org.feature.multi.perspective.view.ViewContainer#getFeatureMapping()
    * @see #getViewContainer()
    * @generated
    */
   EReference getViewContainer_FeatureMapping();

   /**
    * Returns the meta object for class '{@link org.feature.multi.perspective.view.View <em>View</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>View</em>'.
    * @see org.feature.multi.perspective.view.View
    * @generated
    */
   EClass getView();

   /**
    * Returns the meta object for the reference list '{@link org.feature.multi.perspective.view.View#getFeatures <em>Features</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference list '<em>Features</em>'.
    * @see org.feature.multi.perspective.view.View#getFeatures()
    * @see #getView()
    * @generated
    */
   EReference getView_Features();

   /**
    * Returns the meta object for the attribute '{@link org.feature.multi.perspective.view.View#getId <em>Id</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Id</em>'.
    * @see org.feature.multi.perspective.view.View#getId()
    * @see #getView()
    * @generated
    */
   EAttribute getView_Id();

   /**
    * Returns the meta object for the reference list '{@link org.feature.multi.perspective.view.View#getViewgroups <em>Viewgroups</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference list '<em>Viewgroups</em>'.
    * @see org.feature.multi.perspective.view.View#getViewgroups()
    * @see #getView()
    * @generated
    */
   EReference getView_Viewgroups();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the factory that creates the instances of the model.
    * @generated
    */
   ViewFactory getViewFactory();

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
       * The meta object literal for the '{@link org.feature.multi.perspective.view.impl.ViewContainerImpl <em>Container</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.feature.multi.perspective.view.impl.ViewContainerImpl
       * @see org.feature.multi.perspective.view.impl.ViewPackageImpl#getViewContainer()
       * @generated
       */
      EClass VIEW_CONTAINER = eINSTANCE.getViewContainer();

      /**
       * The meta object literal for the '<em><b>Views</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference VIEW_CONTAINER__VIEWS = eINSTANCE.getViewContainer_Views();

      /**
       * The meta object literal for the '<em><b>Feature Mapping</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference VIEW_CONTAINER__FEATURE_MAPPING = eINSTANCE.getViewContainer_FeatureMapping();

      /**
       * The meta object literal for the '{@link org.feature.multi.perspective.view.impl.ViewImpl <em>View</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.feature.multi.perspective.view.impl.ViewImpl
       * @see org.feature.multi.perspective.view.impl.ViewPackageImpl#getView()
       * @generated
       */
      EClass VIEW = eINSTANCE.getView();

      /**
       * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference VIEW__FEATURES = eINSTANCE.getView_Features();

      /**
       * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute VIEW__ID = eINSTANCE.getView_Id();

      /**
       * The meta object literal for the '<em><b>Viewgroups</b></em>' reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference VIEW__VIEWGROUPS = eINSTANCE.getView_Viewgroups();

   }

} //ViewPackage
