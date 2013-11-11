/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IExpressionResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.emftext.term.propositional.expression.resource.expression.IExpressionResourcePostProcessor getResourcePostProcessor();
	
}
