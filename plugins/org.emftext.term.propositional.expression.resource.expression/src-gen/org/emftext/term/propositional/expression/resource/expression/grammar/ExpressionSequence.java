/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

public class ExpressionSequence extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement {
	
	public ExpressionSequence(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.emftext.term.propositional.expression.resource.expression.util.ExpressionStringUtil.explode(getChildren(), " ");
	}
	
}
