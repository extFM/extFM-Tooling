/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.term.propositional.expression;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.emftext.term.propositional.expression.TermPackage
 * @generated
 */
public interface TermFactory extends EFactory {
   /**
    * The singleton instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   TermFactory eINSTANCE = org.emftext.term.propositional.expression.impl.TermFactoryImpl.init();

   /**
    * Returns a new object of class '<em>And</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>And</em>'.
    * @generated
    */
   And createAnd();

   /**
    * Returns a new object of class '<em>Or</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Or</em>'.
    * @generated
    */
   Or createOr();

   /**
    * Returns a new object of class '<em>Not</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Not</em>'.
    * @generated
    */
   Not createNot();

   /**
    * Returns a new object of class '<em>Feature Ref</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Feature Ref</em>'.
    * @generated
    */
   FeatureRef createFeatureRef();

   /**
    * Returns a new object of class '<em>Nested</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Nested</em>'.
    * @generated
    */
   Nested createNested();

   /**
    * Returns a new object of class '<em>Constraint</em>'.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return a new object of class '<em>Constraint</em>'.
    * @generated
    */
   Constraint createConstraint();

   /**
    * Returns the package supported by this factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the package supported by this factory.
    * @generated
    */
   TermPackage getTermPackage();

} //TermFactory
