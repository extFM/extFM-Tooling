/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class MtextPlaceholder extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextTerminal {
	
	private final String tokenName;
	
	public MtextPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
