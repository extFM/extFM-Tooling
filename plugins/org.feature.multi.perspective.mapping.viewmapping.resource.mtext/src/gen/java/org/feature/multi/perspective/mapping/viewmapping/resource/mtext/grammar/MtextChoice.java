/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

public class MtextChoice extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement {
	
	public MtextChoice(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextStringUtil.explode(getChildren(), "|");
	}
	
}
