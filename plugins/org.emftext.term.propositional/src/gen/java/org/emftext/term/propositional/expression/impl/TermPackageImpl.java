/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.emftext.term.propositional.expression.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.emftext.term.propositional.expression.And;
import org.emftext.term.propositional.expression.BinaryOperator;
import org.emftext.term.propositional.expression.Constraint;
import org.emftext.term.propositional.expression.FeatureRef;
import org.emftext.term.propositional.expression.Nested;
import org.emftext.term.propositional.expression.Not;
import org.emftext.term.propositional.expression.Or;
import org.emftext.term.propositional.expression.Term;
import org.emftext.term.propositional.expression.TermFactory;
import org.emftext.term.propositional.expression.TermPackage;
import org.emftext.term.propositional.expression.UnaryOperator;

import org.featuremapper.models.feature.FeaturePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TermPackageImpl extends EPackageImpl implements TermPackage {
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass termEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass andEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass orEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass notEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass featureRefEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass nestedEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass binaryOperatorEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass unaryOperatorEClass = null;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private EClass constraintEClass = null;

   /**
    * Creates an instance of the model <b>Package</b>, registered with
    * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
    * package URI value.
    * <p>Note: the correct way to create the package is via the static
    * factory method {@link #init init()}, which also performs
    * initialization of the package, or returns the registered package,
    * if one already exists.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see org.eclipse.emf.ecore.EPackage.Registry
    * @see org.emftext.term.propositional.expression.TermPackage#eNS_URI
    * @see #init()
    * @generated
    */
   private TermPackageImpl() {
      super(eNS_URI, TermFactory.eINSTANCE);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private static boolean isInited = false;

   /**
    * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
    * 
    * <p>This method is used to initialize {@link TermPackage#eINSTANCE} when that field is accessed.
    * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #eNS_URI
    * @see #createPackageContents()
    * @see #initializePackageContents()
    * @generated
    */
   public static TermPackage init() {
      if (isInited) return (TermPackage)EPackage.Registry.INSTANCE.getEPackage(TermPackage.eNS_URI);

      // Obtain or create and register package
      TermPackageImpl theTermPackage = (TermPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TermPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TermPackageImpl());

      isInited = true;

      // Initialize simple dependencies
      FeaturePackage.eINSTANCE.eClass();

      // Create package meta-data objects
      theTermPackage.createPackageContents();

      // Initialize created meta-data
      theTermPackage.initializePackageContents();

      // Mark meta-data to indicate it can't be changed
      theTermPackage.freeze();

  
      // Update the registry and return the package
      EPackage.Registry.INSTANCE.put(TermPackage.eNS_URI, theTermPackage);
      return theTermPackage;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getTerm() {
      return termEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getAnd() {
      return andEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getOr() {
      return orEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getNot() {
      return notEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getFeatureRef() {
      return featureRefEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getFeatureRef_Feature() {
      return (EReference)featureRefEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getNested() {
      return nestedEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getBinaryOperator() {
      return binaryOperatorEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBinaryOperator_Operand1() {
      return (EReference)binaryOperatorEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getBinaryOperator_Operand2() {
      return (EReference)binaryOperatorEClass.getEStructuralFeatures().get(1);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getUnaryOperator() {
      return unaryOperatorEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getUnaryOperator_Operand() {
      return (EReference)unaryOperatorEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EClass getConstraint() {
      return constraintEClass;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EReference getConstraint_Term() {
      return (EReference)constraintEClass.getEStructuralFeatures().get(0);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public TermFactory getTermFactory() {
      return (TermFactory)getEFactoryInstance();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private boolean isCreated = false;

   /**
    * Creates the meta-model objects for the package.  This method is
    * guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void createPackageContents() {
      if (isCreated) return;
      isCreated = true;

      // Create classes and their features
      termEClass = createEClass(TERM);

      andEClass = createEClass(AND);

      orEClass = createEClass(OR);

      notEClass = createEClass(NOT);

      featureRefEClass = createEClass(FEATURE_REF);
      createEReference(featureRefEClass, FEATURE_REF__FEATURE);

      nestedEClass = createEClass(NESTED);

      binaryOperatorEClass = createEClass(BINARY_OPERATOR);
      createEReference(binaryOperatorEClass, BINARY_OPERATOR__OPERAND1);
      createEReference(binaryOperatorEClass, BINARY_OPERATOR__OPERAND2);

      unaryOperatorEClass = createEClass(UNARY_OPERATOR);
      createEReference(unaryOperatorEClass, UNARY_OPERATOR__OPERAND);

      constraintEClass = createEClass(CONSTRAINT);
      createEReference(constraintEClass, CONSTRAINT__TERM);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private boolean isInitialized = false;

   /**
    * Complete the initialization of the package and its meta-model.  This
    * method is guarded to have no affect on any invocation but its first.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void initializePackageContents() {
      if (isInitialized) return;
      isInitialized = true;

      // Initialize package
      setName(eNAME);
      setNsPrefix(eNS_PREFIX);
      setNsURI(eNS_URI);

      // Obtain other dependent packages
      FeaturePackage theFeaturePackage = (FeaturePackage)EPackage.Registry.INSTANCE.getEPackage(FeaturePackage.eNS_URI);

      // Create type parameters

      // Set bounds for type parameters

      // Add supertypes to classes
      andEClass.getESuperTypes().add(this.getBinaryOperator());
      orEClass.getESuperTypes().add(this.getBinaryOperator());
      notEClass.getESuperTypes().add(this.getUnaryOperator());
      featureRefEClass.getESuperTypes().add(this.getTerm());
      nestedEClass.getESuperTypes().add(this.getUnaryOperator());
      binaryOperatorEClass.getESuperTypes().add(this.getTerm());
      unaryOperatorEClass.getESuperTypes().add(this.getTerm());

      // Initialize classes and features; add operations and parameters
      initEClass(termEClass, Term.class, "Term", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(notEClass, Not.class, "Not", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(featureRefEClass, FeatureRef.class, "FeatureRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getFeatureRef_Feature(), theFeaturePackage.getFeature(), null, "feature", null, 1, 1, FeatureRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(nestedEClass, Nested.class, "Nested", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

      initEClass(binaryOperatorEClass, BinaryOperator.class, "BinaryOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getBinaryOperator_Operand1(), this.getTerm(), null, "operand1", null, 1, 1, BinaryOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
      initEReference(getBinaryOperator_Operand2(), this.getTerm(), null, "operand2", null, 1, 1, BinaryOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(unaryOperatorEClass, UnaryOperator.class, "UnaryOperator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getUnaryOperator_Operand(), this.getTerm(), null, "operand", null, 1, 1, UnaryOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
      initEReference(getConstraint_Term(), this.getTerm(), null, "term", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

      // Create resource
      createResource(eNS_URI);
   }

} //TermPackageImpl
