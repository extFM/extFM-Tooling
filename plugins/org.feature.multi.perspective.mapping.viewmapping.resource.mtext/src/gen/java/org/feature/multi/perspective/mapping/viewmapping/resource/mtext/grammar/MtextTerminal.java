/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

public class MtextTerminal extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement {
	
	private final org.eclipse.emf.ecore.EStructuralFeature feature;
	private final int mandatoryOccurencesAfter;
	
	public MtextTerminal(org.eclipse.emf.ecore.EStructuralFeature feature, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality, int mandatoryOccurencesAfter) {
		super(cardinality, null);
		this.feature = feature;
		this.mandatoryOccurencesAfter = mandatoryOccurencesAfter;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return feature;
	}
	
	public int getMandatoryOccurencesAfter() {
		return mandatoryOccurencesAfter;
	}
	
	public String toString() {
		return feature.getName() + "[]";
	}
	
}
