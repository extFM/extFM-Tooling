/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'org.emftext.term.propositional.expression.resource.expression.default_load_opti
 * ons' with the difference that the options defined in this class are used even
 * if no Eclipse platform is running.
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionOptionProvider implements org.emftext.term.propositional.expression.resource.expression.IExpressionOptionProvider {
	
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
		return java.util.Collections.emptyMap();
	}
	
}
