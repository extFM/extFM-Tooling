/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.term.propositional.expression.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.emftext.term.propositional.expression.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.term.propositional.expression.TermPackage
 * @generated
 */
public class TermAdapterFactory extends AdapterFactoryImpl {
   /**
    * The cached model package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected static TermPackage modelPackage;

   /**
    * Creates an instance of the adapter factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public TermAdapterFactory() {
      if (modelPackage == null) {
         modelPackage = TermPackage.eINSTANCE;
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
   protected TermSwitch<Adapter> modelSwitch =
      new TermSwitch<Adapter>() {
         @Override
         public Adapter caseTerm(Term object) {
            return createTermAdapter();
         }
         @Override
         public Adapter caseAnd(And object) {
            return createAndAdapter();
         }
         @Override
         public Adapter caseOr(Or object) {
            return createOrAdapter();
         }
         @Override
         public Adapter caseNot(Not object) {
            return createNotAdapter();
         }
         @Override
         public Adapter caseFeatureRef(FeatureRef object) {
            return createFeatureRefAdapter();
         }
         @Override
         public Adapter caseNested(Nested object) {
            return createNestedAdapter();
         }
         @Override
         public Adapter caseBinaryOperator(BinaryOperator object) {
            return createBinaryOperatorAdapter();
         }
         @Override
         public Adapter caseUnaryOperator(UnaryOperator object) {
            return createUnaryOperatorAdapter();
         }
         @Override
         public Adapter caseConstraint(Constraint object) {
            return createConstraintAdapter();
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
    * Creates a new adapter for an object of class '{@link org.emftext.term.propositional.expression.Term <em>Term</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.emftext.term.propositional.expression.Term
    * @generated
    */
   public Adapter createTermAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.emftext.term.propositional.expression.And <em>And</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.emftext.term.propositional.expression.And
    * @generated
    */
   public Adapter createAndAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.emftext.term.propositional.expression.Or <em>Or</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.emftext.term.propositional.expression.Or
    * @generated
    */
   public Adapter createOrAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.emftext.term.propositional.expression.Not <em>Not</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.emftext.term.propositional.expression.Not
    * @generated
    */
   public Adapter createNotAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.emftext.term.propositional.expression.FeatureRef <em>Feature Ref</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.emftext.term.propositional.expression.FeatureRef
    * @generated
    */
   public Adapter createFeatureRefAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.emftext.term.propositional.expression.Nested <em>Nested</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.emftext.term.propositional.expression.Nested
    * @generated
    */
   public Adapter createNestedAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.emftext.term.propositional.expression.BinaryOperator <em>Binary Operator</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.emftext.term.propositional.expression.BinaryOperator
    * @generated
    */
   public Adapter createBinaryOperatorAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.emftext.term.propositional.expression.UnaryOperator <em>Unary Operator</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.emftext.term.propositional.expression.UnaryOperator
    * @generated
    */
   public Adapter createUnaryOperatorAdapter() {
      return null;
   }

   /**
    * Creates a new adapter for an object of class '{@link org.emftext.term.propositional.expression.Constraint <em>Constraint</em>}'.
    * <!-- begin-user-doc -->
    * This default implementation returns null so that we can easily ignore cases;
    * it's useful to ignore a case when inheritance will catch all the cases anyway.
    * <!-- end-user-doc -->
    * @return the new adapter.
    * @see org.emftext.term.propositional.expression.Constraint
    * @generated
    */
   public Adapter createConstraintAdapter() {
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

} //TermAdapterFactory
