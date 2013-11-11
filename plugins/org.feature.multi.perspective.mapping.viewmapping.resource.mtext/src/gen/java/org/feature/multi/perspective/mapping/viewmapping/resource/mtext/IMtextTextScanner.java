/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

/**
 * A common interface for scanners to be used by EMFText. A scanner is initialized
 * with a text and delivers a sequence of tokens.
 */
public interface IMtextTextScanner {
	
	/**
	 * Sets the text that must be scanned.
	 */
	public void setText(String text);
	
	/**
	 * Returns the next token found in the text.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextToken getNextToken();
	
}
