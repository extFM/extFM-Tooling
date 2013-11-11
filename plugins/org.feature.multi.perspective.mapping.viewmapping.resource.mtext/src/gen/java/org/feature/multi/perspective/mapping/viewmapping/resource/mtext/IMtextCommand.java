/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IMtextCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
