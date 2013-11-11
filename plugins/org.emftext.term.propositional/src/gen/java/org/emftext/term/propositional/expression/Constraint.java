/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.term.propositional.expression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.emftext.term.propositional.expression.Constraint#getTerm <em>Term</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.emftext.term.propositional.expression.TermPackage#getConstraint()
 * @model
 * @generated
 */
public interface Constraint extends EObject {
   /**
    * Returns the value of the '<em><b>Term</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Term</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Term</em>' containment reference.
    * @see #setTerm(Term)
    * @see org.emftext.term.propositional.expression.TermPackage#getConstraint_Term()
    * @model containment="true" required="true"
    * @generated
    */
   Term getTerm();

   /**
    * Sets the value of the '{@link org.emftext.term.propositional.expression.Constraint#getTerm <em>Term</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Term</em>' containment reference.
    * @see #getTerm()
    * @generated
    */
   void setTerm(Term value);

} // Constraint
