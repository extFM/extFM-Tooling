/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

/**
 * Implementors of this interface can be configured by a map of options (or
 * parameters).
 */
public interface IExpressionConfigurable {
	
	/**
	 * Passes the options given by the map to the configurable object.
	 */
	public void setOptions(java.util.Map<?,?> options);
}
