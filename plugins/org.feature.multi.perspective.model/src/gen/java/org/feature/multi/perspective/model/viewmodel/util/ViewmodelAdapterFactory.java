/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.feature.multi.perspective.model.viewmodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.feature.multi.perspective.model.viewmodel.ViewmodelPackage
 * @generated
 */
public class ViewmodelAdapterFactory extends AdapterFactoryImpl {
   /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected static ViewmodelPackage modelPackage;

   /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ViewmodelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ViewmodelPackage.eINSTANCE;
		}
	}

   /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
    * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
    * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
   @Override
   public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

   /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected ViewmodelSwitch<Adapter> modelSwitch =
      new ViewmodelSwitch<Adapter>() {
			@Override
			public Adapter caseCoreGroup(CoreGroup object) {
				return createCoreGroupAdapter();
			}
			@Override
			public Adapter caseAbstractGroup(AbstractGroup object) {
				return createAbstractGroupAdapter();
			}
			@Override
			public Adapter caseViewPoint(ViewPoint object) {
				return createViewPointAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseGroupModel(GroupModel object) {
				return createGroupModelAdapter();
			}
			@Override
			public Adapter caseViewPointContainer(ViewPointContainer object) {
				return createViewPointContainerAdapter();
			}
			@Override
			public Adapter caseGroup(Group object) {
				return createGroupAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

   /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
   @Override
   public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


   /**
	 * Creates a new adapter for an object of class '{@link org.feature.multi.perspective.model.viewmodel.CoreGroup <em>Core Group</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.feature.multi.perspective.model.viewmodel.CoreGroup
	 * @generated
	 */
   public Adapter createCoreGroupAdapter() {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link org.feature.multi.perspective.model.viewmodel.AbstractGroup <em>Abstract Group</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.feature.multi.perspective.model.viewmodel.AbstractGroup
	 * @generated
	 */
   public Adapter createAbstractGroupAdapter() {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link org.feature.multi.perspective.model.viewmodel.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.feature.multi.perspective.model.viewmodel.Group
	 * @generated
	 */
   public Adapter createGroupAdapter() {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link org.feature.multi.perspective.model.viewmodel.ViewPoint <em>View Point</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.feature.multi.perspective.model.viewmodel.ViewPoint
	 * @generated
	 */
   public Adapter createViewPointAdapter() {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link org.feature.multi.perspective.model.viewmodel.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.feature.multi.perspective.model.viewmodel.Element
	 * @generated
	 */
   public Adapter createElementAdapter() {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link org.feature.multi.perspective.model.viewmodel.GroupModel <em>Group Model</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.feature.multi.perspective.model.viewmodel.GroupModel
	 * @generated
	 */
   public Adapter createGroupModelAdapter() {
		return null;
	}

   /**
	 * Creates a new adapter for an object of class '{@link org.feature.multi.perspective.model.viewmodel.ViewPointContainer <em>View Point Container</em>}'.
	 * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.feature.multi.perspective.model.viewmodel.ViewPointContainer
	 * @generated
	 */
   public Adapter createViewPointContainerAdapter() {
		return null;
	}

   /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
    * This default implementation returns null.
    * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
   public Adapter createEObjectAdapter() {
		return null;
	}

} //ViewmodelAdapterFactory
