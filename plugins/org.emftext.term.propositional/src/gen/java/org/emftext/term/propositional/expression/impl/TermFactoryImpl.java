/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.term.propositional.expression.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.emftext.term.propositional.expression.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TermFactoryImpl extends EFactoryImpl implements TermFactory {
   /**
    * Creates the default factory implementation.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static TermFactory init() {
      try {
         TermFactory theTermFactory = (TermFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.tu-dresden.de/expression"); 
         if (theTermFactory != null) {
            return theTermFactory;
         }
      }
      catch (Exception exception) {
         EcorePlugin.INSTANCE.log(exception);
      }
      return new TermFactoryImpl();
   }

   /**
    * Creates an instance of the factory.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public TermFactoryImpl() {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public EObject create(EClass eClass) {
      switch (eClass.getClassifierID()) {
         case TermPackage.AND: return createAnd();
         case TermPackage.OR: return createOr();
         case TermPackage.NOT: return createNot();
         case TermPackage.FEATURE_REF: return createFeatureRef();
         case TermPackage.NESTED: return createNested();
         case TermPackage.CONSTRAINT: return createConstraint();
         default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public And createAnd() {
      AndImpl and = new AndImpl();
      return and;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Or createOr() {
      OrImpl or = new OrImpl();
      return or;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Not createNot() {
      NotImpl not = new NotImpl();
      return not;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public FeatureRef createFeatureRef() {
      FeatureRefImpl featureRef = new FeatureRefImpl();
      return featureRef;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Nested createNested() {
      NestedImpl nested = new NestedImpl();
      return nested;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Constraint createConstraint() {
      ConstraintImpl constraint = new ConstraintImpl();
      return constraint;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public TermPackage getTermPackage() {
      return (TermPackage)getEPackage();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @deprecated
    * @generated
    */
   @Deprecated
   public static TermPackage getPackage() {
      return TermPackage.eINSTANCE;
   }

} //TermFactoryImpl
