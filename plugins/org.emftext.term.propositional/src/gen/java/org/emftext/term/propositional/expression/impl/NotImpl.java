/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.term.propositional.expression.impl;

import org.eclipse.emf.ecore.EClass;

import org.emftext.term.propositional.expression.Not;
import org.emftext.term.propositional.expression.TermPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Not</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class NotImpl extends UnaryOperatorImpl implements Not {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected NotImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass() {
      return TermPackage.Literals.NOT;
   }

} //NotImpl
