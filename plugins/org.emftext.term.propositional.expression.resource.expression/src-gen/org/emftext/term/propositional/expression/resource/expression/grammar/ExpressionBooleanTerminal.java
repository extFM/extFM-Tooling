/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class ExpressionBooleanTerminal extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public ExpressionBooleanTerminal(org.eclipse.emf.ecore.EStructuralFeature attribute, String trueLiteral, String falseLiteral, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality, int mandatoryOccurrencesAfter) {
		super(attribute, cardinality, mandatoryOccurrencesAfter);
		assert attribute instanceof org.eclipse.emf.ecore.EAttribute;
		this.trueLiteral = trueLiteral;
		this.falseLiteral = falseLiteral;
	}
	
	public String getTrueLiteral() {
		return trueLiteral;
	}
	
	public String getFalseLiteral() {
		return falseLiteral;
	}
	
	public org.eclipse.emf.ecore.EAttribute getAttribute() {
		return (org.eclipse.emf.ecore.EAttribute) getFeature();
	}
	
}
