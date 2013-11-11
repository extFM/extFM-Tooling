/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.term.propositional.expression.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.emftext.term.propositional.expression.Constraint;
import org.emftext.term.propositional.expression.Term;
import org.emftext.term.propositional.expression.TermPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.term.propositional.expression.impl.ConstraintImpl#getTerm <em>Term</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintImpl extends EObjectImpl implements Constraint {
   /**
    * The cached value of the '{@link #getTerm() <em>Term</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getTerm()
    * @generated
    * @ordered
    */
   protected Term term;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected ConstraintImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return TermPackage.Literals.CONSTRAINT;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Term getTerm() {
      return term;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetTerm(Term newTerm, NotificationChain msgs) {
      Term oldTerm = term;
      term = newTerm;
      if (eNotificationRequired()) {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TermPackage.CONSTRAINT__TERM, oldTerm, newTerm);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setTerm(Term newTerm) {
      if (newTerm != term) {
         NotificationChain msgs = null;
         if (term != null)
            msgs = ((InternalEObject)term).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TermPackage.CONSTRAINT__TERM, null, msgs);
         if (newTerm != null)
            msgs = ((InternalEObject)newTerm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TermPackage.CONSTRAINT__TERM, null, msgs);
         msgs = basicSetTerm(newTerm, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, TermPackage.CONSTRAINT__TERM, newTerm, newTerm));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
      switch (featureID) {
         case TermPackage.CONSTRAINT__TERM:
            return basicSetTerm(null, msgs);
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
         case TermPackage.CONSTRAINT__TERM:
            return getTerm();
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
         case TermPackage.CONSTRAINT__TERM:
            setTerm((Term)newValue);
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
         case TermPackage.CONSTRAINT__TERM:
            setTerm((Term)null);
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
         case TermPackage.CONSTRAINT__TERM:
            return term != null;
      }
      return super.eIsSet(featureID);
   }

} //ConstraintImpl
