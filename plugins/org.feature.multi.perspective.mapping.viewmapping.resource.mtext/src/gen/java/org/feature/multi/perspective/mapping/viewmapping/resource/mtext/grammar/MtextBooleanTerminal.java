/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class MtextBooleanTerminal extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextTerminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public MtextBooleanTerminal(org.eclipse.emf.ecore.EStructuralFeature attribute, String trueLiteral, String falseLiteral, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality, int mandatoryOccurrencesAfter) {
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
