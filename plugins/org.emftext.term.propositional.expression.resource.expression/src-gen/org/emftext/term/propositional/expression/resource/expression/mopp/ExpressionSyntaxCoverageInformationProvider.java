/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getConstraint(),
			org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(),
			org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(),
			org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(),
			org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(),
			org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getConstraint(),
		};
	}
	
}
