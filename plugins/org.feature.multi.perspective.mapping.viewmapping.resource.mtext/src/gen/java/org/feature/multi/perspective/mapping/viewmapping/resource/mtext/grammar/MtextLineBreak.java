/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

public class MtextLineBreak extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextFormattingElement {
	
	private final int tabs;
	
	public MtextLineBreak(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
