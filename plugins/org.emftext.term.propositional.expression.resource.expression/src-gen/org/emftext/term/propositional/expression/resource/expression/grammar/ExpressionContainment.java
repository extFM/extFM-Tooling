/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

public class ExpressionContainment extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public ExpressionContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.emftext.term.propositional.expression.resource.expression.util.ExpressionStringUtil.explode(allowedTypes, ", ", new org.emftext.term.propositional.expression.resource.expression.IExpressionFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
