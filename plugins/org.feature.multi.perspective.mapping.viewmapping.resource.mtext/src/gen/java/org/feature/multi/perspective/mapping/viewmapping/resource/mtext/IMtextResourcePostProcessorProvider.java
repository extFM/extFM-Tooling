/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IMtextResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextResourcePostProcessor getResourcePostProcessor();
	
}
