/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class ExpressionExpectedCsString extends org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionAbstractExpectedElement {
	
	private org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword keyword;
	
	public ExpressionExpectedCsString(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof ExpressionExpectedCsString) {
			return getValue().equals(((ExpressionExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
