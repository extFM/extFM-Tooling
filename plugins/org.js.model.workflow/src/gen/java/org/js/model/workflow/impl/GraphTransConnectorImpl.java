/**
 */
package org.js.model.workflow.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jwt.we.conf.model.impl.AspectInstanceImpl;

import org.js.graph.transformation.GraphTransformation;

import org.js.model.workflow.GraphTransConnector;
import org.js.model.workflow.WorkflowPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph Trans Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.model.workflow.impl.GraphTransConnectorImpl#getGraphTransref <em>Graph Transref</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphTransConnectorImpl extends 
AspectInstanceImpl implements GraphTransConnector {
	/**
    * The cached value of the '{@link #getGraphTransref() <em>Graph Transref</em>}' reference.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @see #getGraphTransref()
    * @generated
    * @ordered
    */
	protected GraphTransformation graphTransref;

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected GraphTransConnectorImpl() {
      super();
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	protected EClass eStaticClass() {
      return WorkflowPackage.Literals.GRAPH_TRANS_CONNECTOR;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public GraphTransformation getGraphTransref() {
      if (graphTransref != null && graphTransref.eIsProxy()) {
         InternalEObject oldGraphTransref = (InternalEObject)graphTransref;
         graphTransref = (GraphTransformation)eResolveProxy(oldGraphTransref);
         if (graphTransref != oldGraphTransref) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorkflowPackage.GRAPH_TRANS_CONNECTOR__GRAPH_TRANSREF, oldGraphTransref, graphTransref));
         }
      }
      return graphTransref;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public GraphTransformation basicGetGraphTransref() {
      return graphTransref;
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	public void setGraphTransref(GraphTransformation newGraphTransref) {
      GraphTransformation oldGraphTransref = graphTransref;
      graphTransref = newGraphTransref;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.GRAPH_TRANS_CONNECTOR__GRAPH_TRANSREF, oldGraphTransref, graphTransref));
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case WorkflowPackage.GRAPH_TRANS_CONNECTOR__GRAPH_TRANSREF:
            if (resolve) return getGraphTransref();
            return basicGetGraphTransref();
      }
      return super.eGet(featureID, resolve, coreType);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public void eSet(int featureID, Object newValue) {
      switch (featureID) {
         case WorkflowPackage.GRAPH_TRANS_CONNECTOR__GRAPH_TRANSREF:
            setGraphTransref((GraphTransformation)newValue);
            return;
      }
      super.eSet(featureID, newValue);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public void eUnset(int featureID) {
      switch (featureID) {
         case WorkflowPackage.GRAPH_TRANS_CONNECTOR__GRAPH_TRANSREF:
            setGraphTransref((GraphTransformation)null);
            return;
      }
      super.eUnset(featureID);
   }

	/**
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public boolean eIsSet(int featureID) {
      switch (featureID) {
         case WorkflowPackage.GRAPH_TRANS_CONNECTOR__GRAPH_TRANSREF:
            return graphTransref != null;
      }
      return super.eIsSet(featureID);
   }

} //GraphTransConnectorImpl
