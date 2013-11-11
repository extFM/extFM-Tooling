/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.feature.multi.perspective.model.viewmodel.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.feature.multi.perspective.model.viewmodel.ViewmodelPackage
 * @generated
 */
public class ViewmodelValidator extends EObjectValidator {
   /**
	 * The cached model package
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static final ViewmodelValidator INSTANCE = new ViewmodelValidator();

   /**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
   public static final String DIAGNOSTIC_SOURCE = "org.feature.multi.perspective.model.viewmodel";

   /**
	 * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Check For Redundant View Points' of 'Abstract Group'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public static final int ABSTRACT_GROUP__CHECK_FOR_REDUNDANT_VIEW_POINTS = 1;

   /**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

   /**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

   /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ViewmodelValidator() {
		super();
	}

   /**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   protected EPackage getEPackage() {
	  return ViewmodelPackage.eINSTANCE;
	}

   /**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case ViewmodelPackage.CORE_GROUP:
				return validateCoreGroup((CoreGroup)value, diagnostics, context);
			case ViewmodelPackage.ABSTRACT_GROUP:
				return validateAbstractGroup((AbstractGroup)value, diagnostics, context);
			case ViewmodelPackage.VIEW_POINT:
				return validateViewPoint((ViewPoint)value, diagnostics, context);
			case ViewmodelPackage.ELEMENT:
				return validateElement((Element)value, diagnostics, context);
			case ViewmodelPackage.GROUP_MODEL:
				return validateGroupModel((GroupModel)value, diagnostics, context);
			case ViewmodelPackage.VIEW_POINT_CONTAINER:
				return validateViewPointContainer((ViewPointContainer)value, diagnostics, context);
			case ViewmodelPackage.GROUP:
				return validateGroup((Group)value, diagnostics, context);
			default:
				return true;
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean validateCoreGroup(CoreGroup coreGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(coreGroup, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(coreGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(coreGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(coreGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(coreGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(coreGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(coreGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(coreGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(coreGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractGroup_checkForRedundantViewPoints(coreGroup, diagnostics, context);
		return result;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean validateAbstractGroup(AbstractGroup abstractGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(abstractGroup, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(abstractGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(abstractGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(abstractGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(abstractGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(abstractGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(abstractGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(abstractGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(abstractGroup, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractGroup_checkForRedundantViewPoints(abstractGroup, diagnostics, context);
		return result;
	}

   /**
	 * Validates the checkForRedundantViewPoints constraint of '<em>Abstract Group</em>'.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean validateAbstractGroup_checkForRedundantViewPoints(AbstractGroup abstractGroup, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return abstractGroup.checkForRedundantViewPoints(diagnostics, context);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean validateGroup(Group group, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(group, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(group, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(group, diagnostics, context);
		if (result || diagnostics != null) result &= validateAbstractGroup_checkForRedundantViewPoints(group, diagnostics, context);
		return result;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean validateViewPoint(ViewPoint viewPoint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(viewPoint, diagnostics, context);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean validateElement(Element element, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(element, diagnostics, context);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean validateGroupModel(GroupModel groupModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(groupModel, diagnostics, context);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean validateViewPointContainer(ViewPointContainer viewPointContainer, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(viewPointContainer, diagnostics, context);
	}

   /**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //ViewmodelValidator
