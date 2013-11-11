/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class ExpressionExpectedBooleanTerminal extends org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionAbstractExpectedElement {
	
	private org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionBooleanTerminal booleanTerminal;
	
	public ExpressionExpectedBooleanTerminal(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionBooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionBooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	/**
	 * Returns the expected boolean terminal.
	 */
	public org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement getSymtaxElement() {
		return booleanTerminal;
	}
	
	private org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof ExpressionExpectedBooleanTerminal) {
			return getFeature().equals(((ExpressionExpectedBooleanTerminal) o).getFeature());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
	public java.util.Set<String> getTokenNames() {
		// BooleanTerminals are associated with two or one token(s)
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>(2);
		String trueLiteral = booleanTerminal.getTrueLiteral();
		if (!"".equals(trueLiteral)) {
			tokenNames.add("'" + trueLiteral + "'");
		}
		String falseLiteral = booleanTerminal.getFalseLiteral();
		if (!"".equals(falseLiteral)) {
			tokenNames.add("'" + falseLiteral + "'");
		}
		return tokenNames;
	}
	
}
