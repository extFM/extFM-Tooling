/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

public class ExpressionLineBreak extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement {
	
	private final int tabs;
	
	public ExpressionLineBreak(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
