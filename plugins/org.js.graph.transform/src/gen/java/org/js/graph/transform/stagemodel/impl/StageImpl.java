/**
 */
package org.js.graph.transform.stagemodel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.js.graph.transform.stagemodel.Stage;
import org.js.graph.transform.stagemodel.StagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.js.graph.transform.stagemodel.impl.StageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.js.graph.transform.stagemodel.impl.StageImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.js.graph.transform.stagemodel.impl.StageImpl#getPredecessor <em>Predecessor</em>}</li>
 *   <li>{@link org.js.graph.transform.stagemodel.impl.StageImpl#getSuccessor <em>Successor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StageImpl extends MinimalEObjectImpl.Container implements Stage {
   /**
    * The default value of the '{@link #getName() <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getName()
    * @generated
    * @ordered
    */
   protected static final String NAME_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getName()
    * @generated
    * @ordered
    */
   protected String name = NAME_EDEFAULT;

   /**
    * The default value of the '{@link #getId() <em>Id</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getId()
    * @generated
    * @ordered
    */
   protected static final String ID_EDEFAULT = null;

   /**
    * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getId()
    * @generated
    * @ordered
    */
   protected String id = ID_EDEFAULT;

   /**
    * The cached value of the '{@link #getPredecessor() <em>Predecessor</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getPredecessor()
    * @generated
    * @ordered
    */
   protected Stage predecessor;

   /**
    * The cached value of the '{@link #getSuccessor() <em>Successor</em>}' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getSuccessor()
    * @generated
    * @ordered
    */
   protected Stage successor;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected StageImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return StagemodelPackage.Literals.STAGE;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getName() {
      return name;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setName(String newName) {
      String oldName = name;
      name = newName;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, StagemodelPackage.STAGE__NAME, oldName, name));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public String getId() {
      return id;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setId(String newId) {
      String oldId = id;
      id = newId;
      if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, StagemodelPackage.STAGE__ID, oldId, id));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Stage getPredecessor() {
      if (predecessor != null && predecessor.eIsProxy()) {
         InternalEObject oldPredecessor = (InternalEObject)predecessor;
         predecessor = (Stage)eResolveProxy(oldPredecessor);
         if (predecessor != oldPredecessor) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, StagemodelPackage.STAGE__PREDECESSOR, oldPredecessor, predecessor));
         }
      }
      return predecessor;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Stage basicGetPredecessor() {
      return predecessor;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetPredecessor(Stage newPredecessor, NotificationChain msgs) {
      Stage oldPredecessor = predecessor;
      predecessor = newPredecessor;
      if (eNotificationRequired()) {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StagemodelPackage.STAGE__PREDECESSOR, oldPredecessor, newPredecessor);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setPredecessor(Stage newPredecessor) {
      if (newPredecessor != predecessor) {
         NotificationChain msgs = null;
         if (predecessor != null)
            msgs = ((InternalEObject)predecessor).eInverseRemove(this, StagemodelPackage.STAGE__SUCCESSOR, Stage.class, msgs);
         if (newPredecessor != null)
            msgs = ((InternalEObject)newPredecessor).eInverseAdd(this, StagemodelPackage.STAGE__SUCCESSOR, Stage.class, msgs);
         msgs = basicSetPredecessor(newPredecessor, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, StagemodelPackage.STAGE__PREDECESSOR, newPredecessor, newPredecessor));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Stage getSuccessor() {
      if (successor != null && successor.eIsProxy()) {
         InternalEObject oldSuccessor = (InternalEObject)successor;
         successor = (Stage)eResolveProxy(oldSuccessor);
         if (successor != oldSuccessor) {
            if (eNotificationRequired())
               eNotify(new ENotificationImpl(this, Notification.RESOLVE, StagemodelPackage.STAGE__SUCCESSOR, oldSuccessor, successor));
         }
      }
      return successor;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Stage basicGetSuccessor() {
      return successor;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetSuccessor(Stage newSuccessor, NotificationChain msgs) {
      Stage oldSuccessor = successor;
      successor = newSuccessor;
      if (eNotificationRequired()) {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StagemodelPackage.STAGE__SUCCESSOR, oldSuccessor, newSuccessor);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setSuccessor(Stage newSuccessor) {
      if (newSuccessor != successor) {
         NotificationChain msgs = null;
         if (successor != null)
            msgs = ((InternalEObject)successor).eInverseRemove(this, StagemodelPackage.STAGE__PREDECESSOR, Stage.class, msgs);
         if (newSuccessor != null)
            msgs = ((InternalEObject)newSuccessor).eInverseAdd(this, StagemodelPackage.STAGE__PREDECESSOR, Stage.class, msgs);
         msgs = basicSetSuccessor(newSuccessor, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, StagemodelPackage.STAGE__SUCCESSOR, newSuccessor, newSuccessor));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
      switch (featureID) {
         case StagemodelPackage.STAGE__PREDECESSOR:
            if (predecessor != null)
               msgs = ((InternalEObject)predecessor).eInverseRemove(this, StagemodelPackage.STAGE__SUCCESSOR, Stage.class, msgs);
            return basicSetPredecessor((Stage)otherEnd, msgs);
         case StagemodelPackage.STAGE__SUCCESSOR:
            if (successor != null)
               msgs = ((InternalEObject)successor).eInverseRemove(this, StagemodelPackage.STAGE__PREDECESSOR, Stage.class, msgs);
            return basicSetSuccessor((Stage)otherEnd, msgs);
      }
      return super.eInverseAdd(otherEnd, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
      switch (featureID) {
         case StagemodelPackage.STAGE__PREDECESSOR:
            return basicSetPredecessor(null, msgs);
         case StagemodelPackage.STAGE__SUCCESSOR:
            return basicSetSuccessor(null, msgs);
      }
      return super.eInverseRemove(otherEnd, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType) {
      switch (featureID) {
         case StagemodelPackage.STAGE__NAME:
            return getName();
         case StagemodelPackage.STAGE__ID:
            return getId();
         case StagemodelPackage.STAGE__PREDECESSOR:
            if (resolve) return getPredecessor();
            return basicGetPredecessor();
         case StagemodelPackage.STAGE__SUCCESSOR:
            if (resolve) return getSuccessor();
            return basicGetSuccessor();
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
         case StagemodelPackage.STAGE__NAME:
            setName((String)newValue);
            return;
         case StagemodelPackage.STAGE__ID:
            setId((String)newValue);
            return;
         case StagemodelPackage.STAGE__PREDECESSOR:
            setPredecessor((Stage)newValue);
            return;
         case StagemodelPackage.STAGE__SUCCESSOR:
            setSuccessor((Stage)newValue);
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
         case StagemodelPackage.STAGE__NAME:
            setName(NAME_EDEFAULT);
            return;
         case StagemodelPackage.STAGE__ID:
            setId(ID_EDEFAULT);
            return;
         case StagemodelPackage.STAGE__PREDECESSOR:
            setPredecessor((Stage)null);
            return;
         case StagemodelPackage.STAGE__SUCCESSOR:
            setSuccessor((Stage)null);
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
         case StagemodelPackage.STAGE__NAME:
            return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
         case StagemodelPackage.STAGE__ID:
            return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
         case StagemodelPackage.STAGE__PREDECESSOR:
            return predecessor != null;
         case StagemodelPackage.STAGE__SUCCESSOR:
            return successor != null;
      }
      return super.eIsSet(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public String toString() {
      if (eIsProxy()) return super.toString();

      StringBuffer result = new StringBuffer(super.toString());
      result.append(" (name: ");
      result.append(name);
      result.append(", id: ");
      result.append(id);
      result.append(')');
      return result.toString();
   }

} //StageImpl
