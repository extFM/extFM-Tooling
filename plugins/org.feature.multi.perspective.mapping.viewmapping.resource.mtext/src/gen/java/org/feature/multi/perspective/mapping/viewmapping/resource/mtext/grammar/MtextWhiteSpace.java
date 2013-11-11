/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

public class MtextWhiteSpace extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextFormattingElement {
	
	private final int amount;
	
	public MtextWhiteSpace(int amount, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
