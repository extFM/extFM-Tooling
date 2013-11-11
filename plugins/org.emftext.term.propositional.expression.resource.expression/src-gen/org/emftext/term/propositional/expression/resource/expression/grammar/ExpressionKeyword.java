/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class ExpressionKeyword extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement {
	
	private final String value;
	
	public ExpressionKeyword(String value, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
