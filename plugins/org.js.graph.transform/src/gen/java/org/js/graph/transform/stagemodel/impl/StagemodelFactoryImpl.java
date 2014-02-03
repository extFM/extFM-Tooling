/**
 */
package org.js.graph.transform.stagemodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.js.graph.transform.stagemodel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StagemodelFactoryImpl extends EFactoryImpl implements StagemodelFactory {
   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static StagemodelFactory init() {
      try {
         StagemodelFactory theStagemodelFactory = (StagemodelFactory)EPackage.Registry.INSTANCE.getEFactory(StagemodelPackage.eNS_URI);
         if (theStagemodelFactory != null) {
            return theStagemodelFactory;
         }
      }
      catch (Exception exception) {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new StagemodelFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public StagemodelFactoryImpl() {
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
         case StagemodelPackage.STAGE_MODEL: return createStageModel();
         case StagemodelPackage.STAGE: return createStage();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public StageModel createStageModel() {
      StageModelImpl stageModel = new StageModelImpl();
      return stageModel;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Stage createStage() {
      StageImpl stage = new StageImpl();
      return stage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public StagemodelPackage getStagemodelPackage() {
      return (StagemodelPackage)getEPackage();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
   @Deprecated
   public static StagemodelPackage getPackage() {
      return StagemodelPackage.eINSTANCE;
   }

} //StagemodelFactoryImpl
