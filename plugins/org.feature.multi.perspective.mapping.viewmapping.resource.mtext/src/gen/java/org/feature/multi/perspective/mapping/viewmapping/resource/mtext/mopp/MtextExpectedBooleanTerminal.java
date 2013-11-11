/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class MtextExpectedBooleanTerminal extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextAbstractExpectedElement {
	
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextBooleanTerminal booleanTerminal;
	
	public MtextExpectedBooleanTerminal(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextBooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextBooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	/**
	 * Returns the expected boolean terminal.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement getSymtaxElement() {
		return booleanTerminal;
	}
	
	private org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof MtextExpectedBooleanTerminal) {
			return getFeature().equals(((MtextExpectedBooleanTerminal) o).getFeature());
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
