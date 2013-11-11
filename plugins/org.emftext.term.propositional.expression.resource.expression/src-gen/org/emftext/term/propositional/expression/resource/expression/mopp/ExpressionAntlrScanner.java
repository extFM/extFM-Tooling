/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionAntlrScanner implements org.emftext.term.propositional.expression.resource.expression.IExpressionTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public ExpressionAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		org.emftext.term.propositional.expression.resource.expression.IExpressionTextToken result = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
