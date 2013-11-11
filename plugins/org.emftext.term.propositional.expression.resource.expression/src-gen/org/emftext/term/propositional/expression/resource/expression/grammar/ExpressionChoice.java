/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

public class ExpressionChoice extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement {
	
	public ExpressionChoice(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.emftext.term.propositional.expression.resource.expression.util.ExpressionStringUtil.explode(getChildren(), "|");
	}
	
}
