/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

/**
 * A common interface for scanners to be used by EMFText. A scanner is initialized
 * with a text and delivers a sequence of tokens.
 */
public interface IExpressionTextScanner {
	
	/**
	 * Sets the text that must be scanned.
	 */
	public void setText(String text);
	
	/**
	 * Returns the next token found in the text.
	 */
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTextToken getNextToken();
	
}
