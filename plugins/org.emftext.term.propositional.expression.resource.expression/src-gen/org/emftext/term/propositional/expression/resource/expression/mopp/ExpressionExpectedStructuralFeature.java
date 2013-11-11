/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class ExpressionExpectedStructuralFeature extends org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionAbstractExpectedElement {
	
	private org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionPlaceholder placeholder;
	
	public ExpressionExpectedStructuralFeature(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement getSymtaxElement() {
		return placeholder;
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof ExpressionExpectedStructuralFeature) {
			return getFeature().equals(((ExpressionExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
