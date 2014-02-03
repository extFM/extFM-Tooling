/**
 */
package org.js.model.workflow.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jwt.we.conf.model.AspectInstance;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;



import org.js.model.workflow.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.js.model.workflow.WorkflowPackage
 * @generated
 */
public class WorkflowAdapterFactory extends AdapterFactoryImpl {
	/**
    * The cached model package.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected static WorkflowPackage modelPackage;

	/**
    * Creates an instance of the adapter factory.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public WorkflowAdapterFactory() {
      if (modelPackage == null) {
         modelPackage = WorkflowPackage.eINSTANCE;
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
	protected WorkflowSwitch<Adapter> modelSwitch =
		new WorkflowSwitch<Adapter>() {
         @Override
         public Adapter caseACMConnector(ACMConnector object) {
            return createACMConnectorAdapter();
         }
         @Override
         public Adapter caseRoleConnector(RoleConnector object) {
            return createRoleConnectorAdapter();
         }
         @Override
         public Adapter caseEFMContainer(EFMContainer object) {
            return createEFMContainerAdapter();
         }
         @Override
         public Adapter caseLog(Log object) {
            return createLogAdapter();
         }
         @Override
         public Adapter caseState(State object) {
            return createStateAdapter();
         }
         @Override
         public Adapter caseStakeholderTypes(StakeholderTypes object) {
            return createStakeholderTypesAdapter();
         }
         @Override
         public Adapter caseGraphTransConnector(GraphTransConnector object) {
            return createGraphTransConnectorAdapter();
         }
         @Override
         public Adapter caseStagingConnector(StagingConnector object) {
            return createStagingConnectorAdapter();
         }
         @Override
         public Adapter caseAspectInstance(AspectInstance object) {
            return createAspectInstanceAdapter();
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
    * Creates a new adapter for an object of class '{@link org.js.model.workflow.ACMConnector <em>ACM Connector</em>}'.
    * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.js.model.workflow.ACMConnector
    * @generated
    */
	public Adapter createACMConnectorAdapter() {
      return null;
   }

	/**
    * Creates a new adapter for an object of class '{@link org.js.model.workflow.RoleConnector <em>Role Connector</em>}'.
    * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.js.model.workflow.RoleConnector
    * @generated
    */
	public Adapter createRoleConnectorAdapter() {
      return null;
   }

	/**
    * Creates a new adapter for an object of class '{@link org.js.model.workflow.EFMContainer <em>EFM Container</em>}'.
    * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.js.model.workflow.EFMContainer
    * @generated
    */
	public Adapter createEFMContainerAdapter() {
      return null;
   }

	/**
    * Creates a new adapter for an object of class '{@link org.js.model.workflow.Log <em>Log</em>}'.
    * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.js.model.workflow.Log
    * @generated
    */
	public Adapter createLogAdapter() {
      return null;
   }

	/**
    * Creates a new adapter for an object of class '{@link org.js.model.workflow.State <em>State</em>}'.
    * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.js.model.workflow.State
    * @generated
    */
	public Adapter createStateAdapter() {
      return null;
   }

	/**
    * Creates a new adapter for an object of class '{@link org.js.model.workflow.StakeholderTypes <em>Stakeholder Types</em>}'.
    * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.js.model.workflow.StakeholderTypes
    * @generated
    */
	public Adapter createStakeholderTypesAdapter() {
      return null;
   }

	/**
    * Creates a new adapter for an object of class '{@link org.js.model.workflow.GraphTransConnector <em>Graph Trans Connector</em>}'.
    * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.js.model.workflow.GraphTransConnector
    * @generated
    */
	public Adapter createGraphTransConnectorAdapter() {
      return null;
   }

	/**
    * Creates a new adapter for an object of class '{@link org.js.model.workflow.StagingConnector <em>Staging Connector</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.js.model.workflow.StagingConnector
    * @generated
    */
   public Adapter createStagingConnectorAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.eclipse.jwt.we.conf.AspectInstance <em>Aspect Instance</em>}'.
    * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.eclipse.jwt.we.conf.AspectInstance
    * @generated
    */
	public Adapter createAspectInstanceAdapter() {
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

} //WorkflowAdapterFactory
