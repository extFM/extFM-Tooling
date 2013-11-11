/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IExpressionCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
