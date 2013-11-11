/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextAntlrScanner implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public MtextAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextToken result = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
