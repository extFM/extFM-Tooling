/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

public class ExpressionTerminal extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement {
	
	private final org.eclipse.emf.ecore.EStructuralFeature feature;
	private final int mandatoryOccurencesAfter;
	
	public ExpressionTerminal(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality, int mandatoryOccurencesAfter) {
		super(cardinality, null);
		this.feature = feature;
		this.mandatoryOccurencesAfter = mandatoryOccurencesAfter;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public int getMandatoryOccurencesAfter() {
		return mandatoryOccurencesAfter;
	}
	
	public String toString() {
		return feature.getName() + "[]";
	}
	
}
