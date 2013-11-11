/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class MtextExpectedCsString extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextAbstractExpectedElement {
	
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword keyword;
	
	public MtextExpectedCsString(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof MtextExpectedCsString) {
			return getValue().equals(((MtextExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
