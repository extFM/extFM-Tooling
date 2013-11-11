/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

public class ExpressionWhiteSpace extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement {
	
	private final int amount;
	
	public ExpressionWhiteSpace(int amount, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
