/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.feature.multi.perspective.model.viewmodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewmodelFactoryImpl extends EFactoryImpl implements ViewmodelFactory {
   /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static ViewmodelFactory init() {
		try {
			ViewmodelFactory theViewmodelFactory = (ViewmodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://org.feature.multi.perspective.model/schema/1.0"); 
			if (theViewmodelFactory != null) {
				return theViewmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ViewmodelFactoryImpl();
	}

   /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ViewmodelFactoryImpl() {
		super();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ViewmodelPackage.CORE_GROUP: return createCoreGroup();
			case ViewmodelPackage.ABSTRACT_GROUP: return createAbstractGroup();
			case ViewmodelPackage.VIEW_POINT: return createViewPoint();
			case ViewmodelPackage.GROUP_MODEL: return createGroupModel();
			case ViewmodelPackage.VIEW_POINT_CONTAINER: return createViewPointContainer();
			case ViewmodelPackage.GROUP: return createGroup();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public CoreGroup createCoreGroup() {
		CoreGroupImpl coreGroup = new CoreGroupImpl();
		return coreGroup;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public AbstractGroup createAbstractGroup() {
		AbstractGroupImpl abstractGroup = new AbstractGroupImpl();
		return abstractGroup;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Group createGroup() {
		GroupImpl group = new GroupImpl();
		return group;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ViewPoint createViewPoint() {
		ViewPointImpl viewPoint = new ViewPointImpl();
		return viewPoint;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public GroupModel createGroupModel() {
		GroupModelImpl groupModel = new GroupModelImpl();
		return groupModel;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ViewPointContainer createViewPointContainer() {
		ViewPointContainerImpl viewPointContainer = new ViewPointContainerImpl();
		return viewPointContainer;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ViewmodelPackage getViewmodelPackage() {
		return (ViewmodelPackage)getEPackage();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
   @Deprecated
   public static ViewmodelPackage getPackage() {
		return ViewmodelPackage.eINSTANCE;
	}

} //ViewmodelFactoryImpl
