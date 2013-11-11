/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.term.propositional.expression;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.emftext.term.propositional.expression.TermFactory
 * @model kind="package"
 * @generated
 */
public interface TermPackage extends EPackage {
   /**
    * The package name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNAME = "expression";

   /**
    * The package namespace URI.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_URI = "http://www.tu-dresden.de/expression";

   /**
    * The package namespace name.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   String eNS_PREFIX = "expression";

   /**
    * The singleton instance of the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   TermPackage eINSTANCE = org.emftext.term.propositional.expression.impl.TermPackageImpl.init();

   /**
    * The meta object id for the '{@link org.emftext.term.propositional.expression.impl.TermImpl <em>Term</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.emftext.term.propositional.expression.impl.TermImpl
    * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getTerm()
    * @generated
    */
   int TERM = 0;

   /**
    * The number of structural features of the '<em>Term</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int TERM_FEATURE_COUNT = 0;

   /**
    * The meta object id for the '{@link org.emftext.term.propositional.expression.impl.BinaryOperatorImpl <em>Binary Operator</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.emftext.term.propositional.expression.impl.BinaryOperatorImpl
    * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getBinaryOperator()
    * @generated
    */
   int BINARY_OPERATOR = 6;

   /**
    * The feature id for the '<em><b>Operand1</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BINARY_OPERATOR__OPERAND1 = TERM_FEATURE_COUNT + 0;

   /**
    * The feature id for the '<em><b>Operand2</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BINARY_OPERATOR__OPERAND2 = TERM_FEATURE_COUNT + 1;

   /**
    * The number of structural features of the '<em>Binary Operator</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int BINARY_OPERATOR_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

   /**
    * The meta object id for the '{@link org.emftext.term.propositional.expression.impl.AndImpl <em>And</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.emftext.term.propositional.expression.impl.AndImpl
    * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getAnd()
    * @generated
    */
   int AND = 1;

   /**
    * The feature id for the '<em><b>Operand1</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int AND__OPERAND1 = BINARY_OPERATOR__OPERAND1;

   /**
    * The feature id for the '<em><b>Operand2</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int AND__OPERAND2 = BINARY_OPERATOR__OPERAND2;

   /**
    * The number of structural features of the '<em>And</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int AND_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link org.emftext.term.propositional.expression.impl.OrImpl <em>Or</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.emftext.term.propositional.expression.impl.OrImpl
    * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getOr()
    * @generated
    */
   int OR = 2;

   /**
    * The feature id for the '<em><b>Operand1</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int OR__OPERAND1 = BINARY_OPERATOR__OPERAND1;

   /**
    * The feature id for the '<em><b>Operand2</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int OR__OPERAND2 = BINARY_OPERATOR__OPERAND2;

   /**
    * The number of structural features of the '<em>Or</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int OR_FEATURE_COUNT = BINARY_OPERATOR_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link org.emftext.term.propositional.expression.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.emftext.term.propositional.expression.impl.UnaryOperatorImpl
    * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getUnaryOperator()
    * @generated
    */
   int UNARY_OPERATOR = 7;

   /**
    * The feature id for the '<em><b>Operand</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int UNARY_OPERATOR__OPERAND = TERM_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Unary Operator</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int UNARY_OPERATOR_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link org.emftext.term.propositional.expression.impl.NotImpl <em>Not</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.emftext.term.propositional.expression.impl.NotImpl
    * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getNot()
    * @generated
    */
   int NOT = 3;

   /**
    * The feature id for the '<em><b>Operand</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NOT__OPERAND = UNARY_OPERATOR__OPERAND;

   /**
    * The number of structural features of the '<em>Not</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NOT_FEATURE_COUNT = UNARY_OPERATOR_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link org.emftext.term.propositional.expression.impl.FeatureRefImpl <em>Feature Ref</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.emftext.term.propositional.expression.impl.FeatureRefImpl
    * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getFeatureRef()
    * @generated
    */
   int FEATURE_REF = 4;

   /**
    * The feature id for the '<em><b>Feature</b></em>' reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FEATURE_REF__FEATURE = TERM_FEATURE_COUNT + 0;

   /**
    * The number of structural features of the '<em>Feature Ref</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int FEATURE_REF_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

   /**
    * The meta object id for the '{@link org.emftext.term.propositional.expression.impl.NestedImpl <em>Nested</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.emftext.term.propositional.expression.impl.NestedImpl
    * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getNested()
    * @generated
    */
   int NESTED = 5;

   /**
    * The feature id for the '<em><b>Operand</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NESTED__OPERAND = UNARY_OPERATOR__OPERAND;

   /**
    * The number of structural features of the '<em>Nested</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int NESTED_FEATURE_COUNT = UNARY_OPERATOR_FEATURE_COUNT + 0;

   /**
    * The meta object id for the '{@link org.emftext.term.propositional.expression.impl.ConstraintImpl <em>Constraint</em>}' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.emftext.term.propositional.expression.impl.ConstraintImpl
    * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getConstraint()
    * @generated
    */
   int CONSTRAINT = 8;

   /**
    * The feature id for the '<em><b>Term</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int CONSTRAINT__TERM = 0;

   /**
    * The number of structural features of the '<em>Constraint</em>' class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   int CONSTRAINT_FEATURE_COUNT = 1;


   /**
    * Returns the meta object for class '{@link org.emftext.term.propositional.expression.Term <em>Term</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Term</em>'.
    * @see org.emftext.term.propositional.expression.Term
    * @generated
    */
   EClass getTerm();

   /**
    * Returns the meta object for class '{@link org.emftext.term.propositional.expression.And <em>And</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>And</em>'.
    * @see org.emftext.term.propositional.expression.And
    * @generated
    */
   EClass getAnd();

   /**
    * Returns the meta object for class '{@link org.emftext.term.propositional.expression.Or <em>Or</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Or</em>'.
    * @see org.emftext.term.propositional.expression.Or
    * @generated
    */
   EClass getOr();

   /**
    * Returns the meta object for class '{@link org.emftext.term.propositional.expression.Not <em>Not</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Not</em>'.
    * @see org.emftext.term.propositional.expression.Not
    * @generated
    */
   EClass getNot();

   /**
    * Returns the meta object for class '{@link org.emftext.term.propositional.expression.FeatureRef <em>Feature Ref</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Feature Ref</em>'.
    * @see org.emftext.term.propositional.expression.FeatureRef
    * @generated
    */
   EClass getFeatureRef();

   /**
    * Returns the meta object for the reference '{@link org.emftext.term.propositional.expression.FeatureRef#getFeature <em>Feature</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the reference '<em>Feature</em>'.
    * @see org.emftext.term.propositional.expression.FeatureRef#getFeature()
    * @see #getFeatureRef()
    * @generated
    */
   EReference getFeatureRef_Feature();

   /**
    * Returns the meta object for class '{@link org.emftext.term.propositional.expression.Nested <em>Nested</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Nested</em>'.
    * @see org.emftext.term.propositional.expression.Nested
    * @generated
    */
   EClass getNested();

   /**
    * Returns the meta object for class '{@link org.emftext.term.propositional.expression.BinaryOperator <em>Binary Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Binary Operator</em>'.
    * @see org.emftext.term.propositional.expression.BinaryOperator
    * @generated
    */
   EClass getBinaryOperator();

   /**
    * Returns the meta object for the containment reference '{@link org.emftext.term.propositional.expression.BinaryOperator#getOperand1 <em>Operand1</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Operand1</em>'.
    * @see org.emftext.term.propositional.expression.BinaryOperator#getOperand1()
    * @see #getBinaryOperator()
    * @generated
    */
   EReference getBinaryOperator_Operand1();

   /**
    * Returns the meta object for the containment reference '{@link org.emftext.term.propositional.expression.BinaryOperator#getOperand2 <em>Operand2</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Operand2</em>'.
    * @see org.emftext.term.propositional.expression.BinaryOperator#getOperand2()
    * @see #getBinaryOperator()
    * @generated
    */
   EReference getBinaryOperator_Operand2();

   /**
    * Returns the meta object for class '{@link org.emftext.term.propositional.expression.UnaryOperator <em>Unary Operator</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Unary Operator</em>'.
    * @see org.emftext.term.propositional.expression.UnaryOperator
    * @generated
    */
   EClass getUnaryOperator();

   /**
    * Returns the meta object for the containment reference '{@link org.emftext.term.propositional.expression.UnaryOperator#getOperand <em>Operand</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Operand</em>'.
    * @see org.emftext.term.propositional.expression.UnaryOperator#getOperand()
    * @see #getUnaryOperator()
    * @generated
    */
   EReference getUnaryOperator_Operand();

   /**
    * Returns the meta object for class '{@link org.emftext.term.propositional.expression.Constraint <em>Constraint</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for class '<em>Constraint</em>'.
    * @see org.emftext.term.propositional.expression.Constraint
    * @generated
    */
   EClass getConstraint();

   /**
    * Returns the meta object for the containment reference '{@link org.emftext.term.propositional.expression.Constraint#getTerm <em>Term</em>}'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the meta object for the containment reference '<em>Term</em>'.
    * @see org.emftext.term.propositional.expression.Constraint#getTerm()
    * @see #getConstraint()
    * @generated
    */
   EReference getConstraint_Term();

   /**
    * Returns the factory that creates the instances of the model.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the factory that creates the instances of the model.
    * @generated
    */
   TermFactory getTermFactory();

   /**
    * <!-- begin-user-doc -->
    * Defines literals for the meta objects that represent
    * <ul>
    *   <li>each class,</li>
    *   <li>each feature of each class,</li>
    *   <li>each enum,</li>
    *   <li>and each data type</li>
    * </ul>
    * <!-- end-user-doc -->
    * @generated
    */
   interface Literals {
      /**
       * The meta object literal for the '{@link org.emftext.term.propositional.expression.impl.TermImpl <em>Term</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.emftext.term.propositional.expression.impl.TermImpl
       * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getTerm()
       * @generated
       */
      EClass TERM = eINSTANCE.getTerm();

      /**
       * The meta object literal for the '{@link org.emftext.term.propositional.expression.impl.AndImpl <em>And</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.emftext.term.propositional.expression.impl.AndImpl
       * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getAnd()
       * @generated
       */
      EClass AND = eINSTANCE.getAnd();

      /**
       * The meta object literal for the '{@link org.emftext.term.propositional.expression.impl.OrImpl <em>Or</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.emftext.term.propositional.expression.impl.OrImpl
       * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getOr()
       * @generated
       */
      EClass OR = eINSTANCE.getOr();

      /**
       * The meta object literal for the '{@link org.emftext.term.propositional.expression.impl.NotImpl <em>Not</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.emftext.term.propositional.expression.impl.NotImpl
       * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getNot()
       * @generated
       */
      EClass NOT = eINSTANCE.getNot();

      /**
       * The meta object literal for the '{@link org.emftext.term.propositional.expression.impl.FeatureRefImpl <em>Feature Ref</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.emftext.term.propositional.expression.impl.FeatureRefImpl
       * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getFeatureRef()
       * @generated
       */
      EClass FEATURE_REF = eINSTANCE.getFeatureRef();

      /**
       * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference FEATURE_REF__FEATURE = eINSTANCE.getFeatureRef_Feature();

      /**
       * The meta object literal for the '{@link org.emftext.term.propositional.expression.impl.NestedImpl <em>Nested</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.emftext.term.propositional.expression.impl.NestedImpl
       * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getNested()
       * @generated
       */
      EClass NESTED = eINSTANCE.getNested();

      /**
       * The meta object literal for the '{@link org.emftext.term.propositional.expression.impl.BinaryOperatorImpl <em>Binary Operator</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.emftext.term.propositional.expression.impl.BinaryOperatorImpl
       * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getBinaryOperator()
       * @generated
       */
      EClass BINARY_OPERATOR = eINSTANCE.getBinaryOperator();

      /**
       * The meta object literal for the '<em><b>Operand1</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BINARY_OPERATOR__OPERAND1 = eINSTANCE.getBinaryOperator_Operand1();

      /**
       * The meta object literal for the '<em><b>Operand2</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference BINARY_OPERATOR__OPERAND2 = eINSTANCE.getBinaryOperator_Operand2();

      /**
       * The meta object literal for the '{@link org.emftext.term.propositional.expression.impl.UnaryOperatorImpl <em>Unary Operator</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.emftext.term.propositional.expression.impl.UnaryOperatorImpl
       * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getUnaryOperator()
       * @generated
       */
      EClass UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

      /**
       * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference UNARY_OPERATOR__OPERAND = eINSTANCE.getUnaryOperator_Operand();

      /**
       * The meta object literal for the '{@link org.emftext.term.propositional.expression.impl.ConstraintImpl <em>Constraint</em>}' class.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @see org.emftext.term.propositional.expression.impl.ConstraintImpl
       * @see org.emftext.term.propositional.expression.impl.TermPackageImpl#getConstraint()
       * @generated
       */
      EClass CONSTRAINT = eINSTANCE.getConstraint();

      /**
       * The meta object literal for the '<em><b>Term</b></em>' containment reference feature.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      EReference CONSTRAINT__TERM = eINSTANCE.getConstraint_Term();

   }

} //TermPackage
