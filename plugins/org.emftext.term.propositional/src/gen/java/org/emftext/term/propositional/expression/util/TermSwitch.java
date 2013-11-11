/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.term.propositional.expression.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.emftext.term.propositional.expression.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.emftext.term.propositional.expression.TermPackage
 * @generated
 */
public class TermSwitch<T> extends Switch<T> {
   /**
    * The cached model package
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected static TermPackage modelPackage;

   /**
    * Creates an instance of the switch.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public TermSwitch() {
      if (modelPackage == null) {
         modelPackage = TermPackage.eINSTANCE;
      }
   }

   /**
    * Checks whether this is a switch for the given package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @parameter ePackage the package in question.
    * @return whether this is a switch for the given package.
    * @generated
    */
   @Override
   protected boolean isSwitchFor(EPackage ePackage) {
      return ePackage == modelPackage;
   }

   /**
    * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the first non-null result returned by a <code>caseXXX</code> call.
    * @generated
    */
   @Override
   protected T doSwitch(int classifierID, EObject theEObject) {
      switch (classifierID) {
         case TermPackage.TERM: {
            Term term = (Term)theEObject;
            T result = caseTerm(term);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TermPackage.AND: {
            And and = (And)theEObject;
            T result = caseAnd(and);
            if (result == null) result = caseBinaryOperator(and);
            if (result == null) result = caseTerm(and);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TermPackage.OR: {
            Or or = (Or)theEObject;
            T result = caseOr(or);
            if (result == null) result = caseBinaryOperator(or);
            if (result == null) result = caseTerm(or);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TermPackage.NOT: {
            Not not = (Not)theEObject;
            T result = caseNot(not);
            if (result == null) result = caseUnaryOperator(not);
            if (result == null) result = caseTerm(not);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TermPackage.FEATURE_REF: {
            FeatureRef featureRef = (FeatureRef)theEObject;
            T result = caseFeatureRef(featureRef);
            if (result == null) result = caseTerm(featureRef);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TermPackage.NESTED: {
            Nested nested = (Nested)theEObject;
            T result = caseNested(nested);
            if (result == null) result = caseUnaryOperator(nested);
            if (result == null) result = caseTerm(nested);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TermPackage.BINARY_OPERATOR: {
            BinaryOperator binaryOperator = (BinaryOperator)theEObject;
            T result = caseBinaryOperator(binaryOperator);
            if (result == null) result = caseTerm(binaryOperator);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TermPackage.UNARY_OPERATOR: {
            UnaryOperator unaryOperator = (UnaryOperator)theEObject;
            T result = caseUnaryOperator(unaryOperator);
            if (result == null) result = caseTerm(unaryOperator);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         case TermPackage.CONSTRAINT: {
            Constraint constraint = (Constraint)theEObject;
            T result = caseConstraint(constraint);
            if (result == null) result = defaultCase(theEObject);
            return result;
         }
         default: return defaultCase(theEObject);
      }
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Term</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseTerm(Term object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>And</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>And</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseAnd(And object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Or</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Or</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseOr(Or object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Not</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Not</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseNot(Not object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Feature Ref</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Feature Ref</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseFeatureRef(FeatureRef object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Nested</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Nested</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseNested(Nested object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Binary Operator</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Binary Operator</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseBinaryOperator(BinaryOperator object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Unary Operator</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseUnaryOperator(UnaryOperator object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
    * @generated
    */
   public T caseConstraint(Constraint object) {
      return null;
   }

   /**
    * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
    * <!-- begin-user-doc -->
    * This implementation returns null;
    * returning a non-null result will terminate the switch, but this is the last case anyway.
    * <!-- end-user-doc -->
    * @param object the target of the switch.
    * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
    * @see #doSwitch(org.eclipse.emf.ecore.EObject)
    * @generated
    */
   @Override
   public T defaultCase(EObject object) {
      return null;
   }

} //TermSwitch
