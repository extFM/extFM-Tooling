/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

public class MtextCompound extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement {
	
	public MtextCompound(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice choice, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality) {
		super(cardinality, new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
