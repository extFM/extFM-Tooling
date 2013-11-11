/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class MtextKeyword extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement {
	
	private final String value;
	
	public MtextKeyword(String value, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
