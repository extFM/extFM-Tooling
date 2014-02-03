/**
 */
package org.js.graph.transform.stagemodel;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.js.graph.transform.stagemodel.StagemodelFactory
 * @model kind="package"
 * @generated
 */
public interface StagemodelPackage extends EPackage {
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNAME = "stagemodel";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_URI = "http://www.tudresden.de/stagemodel";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_PREFIX = "stagemodel";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   StagemodelPackage eINSTANCE = org.js.graph.transform.stagemodel.impl.StagemodelPackageImpl.init();

   /**
    * The meta object id for the '{@link org.js.graph.transform.stagemodel.impl.StageModelImpl <em>Stage Model</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.js.graph.transform.stagemodel.impl.StageModelImpl
    * @see org.js.graph.transform.stagemodel.impl.StagemodelPackageImpl#getStageModel()
    * @generated
    */
   int STAGE_MODEL = 0;

   /**
    * The feature id for the '<em><b>Stages</b></em>' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STAGE_MODEL__STAGES = 0;

   /**
    * The number of structural features of the '<em>Stage Model</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STAGE_MODEL_FEATURE_COUNT = 1;

   /**
    * The number of operations of the '<em>Stage Model</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STAGE_MODEL_OPERATION_COUNT = 0;

   /**
    * The meta object id for the '{@link org.js.graph.transform.stagemodel.impl.StageImpl <em>Stage</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.js.graph.transform.stagemodel.impl.StageImpl
    * @see org.js.graph.transform.stagemodel.impl.StagemodelPackageImpl#getStage()
    * @generated
    */
   int STAGE = 1;

   /**
    * The feature id for the '<em><b>Name</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STAGE__NAME = 0;

   /**
    * The feature id for the '<em><b>Id</b></em>' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STAGE__ID = 1;

   /**
    * The feature id for the '<em><b>Predecessor</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STAGE__PREDECESSOR = 2;

   /**
    * The feature id for the '<em><b>Successor</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STAGE__SUCCESSOR = 3;

   /**
    * The number of structural features of the '<em>Stage</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STAGE_FEATURE_COUNT = 4;

   /**
    * The number of operations of the '<em>Stage</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int STAGE_OPERATION_COUNT = 0;


   /**
    * Returns the meta object for class '{@link org.js.graph.transform.stagemodel.StageModel <em>Stage Model</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Stage Model</em>'.
    * @see org.js.graph.transform.stagemodel.StageModel
    * @generated
    */
   EClass getStageModel();

   /**
    * Returns the meta object for the containment reference list '{@link org.js.graph.transform.stagemodel.StageModel#getStages <em>Stages</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference list '<em>Stages</em>'.
    * @see org.js.graph.transform.stagemodel.StageModel#getStages()
    * @see #getStageModel()
    * @generated
    */
   EReference getStageModel_Stages();

   /**
    * Returns the meta object for class '{@link org.js.graph.transform.stagemodel.Stage <em>Stage</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Stage</em>'.
    * @see org.js.graph.transform.stagemodel.Stage
    * @generated
    */
   EClass getStage();

   /**
    * Returns the meta object for the attribute '{@link org.js.graph.transform.stagemodel.Stage#getName <em>Name</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Name</em>'.
    * @see org.js.graph.transform.stagemodel.Stage#getName()
    * @see #getStage()
    * @generated
    */
   EAttribute getStage_Name();

   /**
    * Returns the meta object for the attribute '{@link org.js.graph.transform.stagemodel.Stage#getId <em>Id</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the attribute '<em>Id</em>'.
    * @see org.js.graph.transform.stagemodel.Stage#getId()
    * @see #getStage()
    * @generated
    */
   EAttribute getStage_Id();

   /**
    * Returns the meta object for the reference '{@link org.js.graph.transform.stagemodel.Stage#getPredecessor <em>Predecessor</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Predecessor</em>'.
    * @see org.js.graph.transform.stagemodel.Stage#getPredecessor()
    * @see #getStage()
    * @generated
    */
   EReference getStage_Predecessor();

   /**
    * Returns the meta object for the reference '{@link org.js.graph.transform.stagemodel.Stage#getSuccessor <em>Successor</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Successor</em>'.
    * @see org.js.graph.transform.stagemodel.Stage#getSuccessor()
    * @see #getStage()
    * @generated
    */
   EReference getStage_Successor();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the factory that creates the instances of the model.
    * @generated
    */
   StagemodelFactory getStagemodelFactory();

   /**
    * <!-- begin-user-doc -->
    * Defines literals for the meta objects that represent
    * <ul>
    *   <li>each class,</li>
    *   <li>each feature of each class,</li>
    *   <li>each operation of each class,</li>
    *   <li>each enum,</li>
    *   <li>and each data type</li>
    * </ul>
    * <!-- end-user-doc -->
    * @generated
    */
   interface Literals {
      /**
       * The meta object literal for the '{@link org.js.graph.transform.stagemodel.impl.StageModelImpl <em>Stage Model</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.js.graph.transform.stagemodel.impl.StageModelImpl
       * @see org.js.graph.transform.stagemodel.impl.StagemodelPackageImpl#getStageModel()
       * @generated
       */
      EClass STAGE_MODEL = eINSTANCE.getStageModel();

      /**
       * The meta object literal for the '<em><b>Stages</b></em>' containment reference list feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference STAGE_MODEL__STAGES = eINSTANCE.getStageModel_Stages();

      /**
       * The meta object literal for the '{@link org.js.graph.transform.stagemodel.impl.StageImpl <em>Stage</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.js.graph.transform.stagemodel.impl.StageImpl
       * @see org.js.graph.transform.stagemodel.impl.StagemodelPackageImpl#getStage()
       * @generated
       */
      EClass STAGE = eINSTANCE.getStage();

      /**
       * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute STAGE__NAME = eINSTANCE.getStage_Name();

      /**
       * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EAttribute STAGE__ID = eINSTANCE.getStage_Id();

      /**
       * The meta object literal for the '<em><b>Predecessor</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference STAGE__PREDECESSOR = eINSTANCE.getStage_Predecessor();

      /**
       * The meta object literal for the '<em><b>Successor</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference STAGE__SUCCESSOR = eINSTANCE.getStage_Successor();

   }

} //StagemodelPackage
