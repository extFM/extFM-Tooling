/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

public class ExpressionCompound extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement {
	
	public ExpressionCompound(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice choice, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality) {
		super(cardinality, new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
