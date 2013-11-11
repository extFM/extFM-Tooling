/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class ExpressionPlaceholder extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal {
	
	private final String tokenName;
	
	public ExpressionPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
