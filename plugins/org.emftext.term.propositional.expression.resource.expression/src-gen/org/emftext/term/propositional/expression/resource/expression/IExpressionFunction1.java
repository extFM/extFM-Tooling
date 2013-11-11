/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

/**
 * A simple interface for generic functions with one argument.
 */
public interface IExpressionFunction1<ReturnType, ArgumentType1> {
	
	public ReturnType execute(ArgumentType1 argument1);
}
