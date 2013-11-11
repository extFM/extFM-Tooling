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

import org.emftext.term.propositional.expression.Term;
import org.emftext.term.propositional.expression.TermPackage;
import org.emftext.term.propositional.expression.UnaryOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.emftext.term.propositional.expression.impl.UnaryOperatorImpl#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UnaryOperatorImpl extends TermImpl implements UnaryOperator {
   /**
    * The cached value of the '{@link #getOperand() <em>Operand</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getOperand()
    * @generated
    * @ordered
    */
   protected Term operand;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected UnaryOperatorImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return TermPackage.Literals.UNARY_OPERATOR;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Term getOperand() {
      return operand;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetOperand(Term newOperand, NotificationChain msgs) {
      Term oldOperand = operand;
      operand = newOperand;
      if (eNotificationRequired()) {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TermPackage.UNARY_OPERATOR__OPERAND, oldOperand, newOperand);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setOperand(Term newOperand) {
      if (newOperand != operand) {
         NotificationChain msgs = null;
         if (operand != null)
            msgs = ((InternalEObject)operand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TermPackage.UNARY_OPERATOR__OPERAND, null, msgs);
         if (newOperand != null)
            msgs = ((InternalEObject)newOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TermPackage.UNARY_OPERATOR__OPERAND, null, msgs);
         msgs = basicSetOperand(newOperand, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, TermPackage.UNARY_OPERATOR__OPERAND, newOperand, newOperand));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
      switch (featureID) {
         case TermPackage.UNARY_OPERATOR__OPERAND:
            return basicSetOperand(null, msgs);
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
         case TermPackage.UNARY_OPERATOR__OPERAND:
            return getOperand();
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
         case TermPackage.UNARY_OPERATOR__OPERAND:
            setOperand((Term)newValue);
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
         case TermPackage.UNARY_OPERATOR__OPERAND:
            setOperand((Term)null);
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
         case TermPackage.UNARY_OPERATOR__OPERAND:
            return operand != null;
      }
      return super.eIsSet(featureID);
   }

} //UnaryOperatorImpl
