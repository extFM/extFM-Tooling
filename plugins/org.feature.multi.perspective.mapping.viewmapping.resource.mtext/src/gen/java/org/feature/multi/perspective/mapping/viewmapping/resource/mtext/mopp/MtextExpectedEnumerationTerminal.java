/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * A representation for a range in a document where an enumeration literal (i.e.,
 * a set of static strings) is expected.
 */
public class MtextExpectedEnumerationTerminal extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextAbstractExpectedElement {
	
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextEnumerationTerminal enumerationTerminal;
	
	public MtextExpectedEnumerationTerminal(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextEnumerationTerminal enumerationTerminal) {
		super(enumerationTerminal.getMetaclass());
		this.enumerationTerminal = enumerationTerminal;
	}
	
	public java.util.Set<String> getTokenNames() {
		// EnumerationTerminals are associated with multiple tokens, one for each literal
		// that was mapped to a string
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>();
		java.util.Map<String, String> mapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : mapping.keySet()) {
			String text = mapping.get(literalName);
			if (text != null && !"".equals(text)) {
				tokenNames.add("'" + text + "'");
			}
		}
		return tokenNames;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextEnumerationTerminal getEnumerationTerminal() {
		return this.enumerationTerminal;
	}
	
	/**
	 * Returns the expected enumeration terminal.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement getSymtaxElement() {
		return enumerationTerminal;
	}
	
	public String toString() {
		return "EnumTerminal \"" + getEnumerationTerminal() + "\"";
	}
	
}
