/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

public class MtextSequence extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement {
	
	public MtextSequence(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextStringUtil.explode(getChildren(), " ");
	}
	
}
