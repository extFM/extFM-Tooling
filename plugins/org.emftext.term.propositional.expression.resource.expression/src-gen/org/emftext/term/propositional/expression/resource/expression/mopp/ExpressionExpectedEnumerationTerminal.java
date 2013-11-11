/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * A representation for a range in a document where an enumeration literal (i.e.,
 * a set of static strings) is expected.
 */
public class ExpressionExpectedEnumerationTerminal extends org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionAbstractExpectedElement {
	
	private org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionEnumerationTerminal enumerationTerminal;
	
	public ExpressionExpectedEnumerationTerminal(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionEnumerationTerminal enumerationTerminal) {
		super(enumerationTerminal.getMetaclass());
		this.enumerationTerminal = enumerationTerminal;
	}
	
	public java.util.Set<String> getTokenNames() {
		// EnumerationTerminals are associated with multiple tokens, one for each literal
		// that was mapped to a string
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>();
		java.util.Map<String, String> mapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : mapping.keySet()) {
			String text = mapping.get(literalName);
			if (text != null && !"".equals(text)) {
				tokenNames.add("'" + text + "'");
			}
		}
		return tokenNames;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionEnumerationTerminal getEnumerationTerminal() {
		return this.enumerationTerminal;
	}
	
	/**
	 * Returns the expected enumeration terminal.
	 */
	public org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement getSymtaxElement() {
		return enumerationTerminal;
	}
	
	public String toString() {
		return "EnumTerminal \"" + getEnumerationTerminal() + "\"";
	}
	
}
