/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.util;

/**
 * Utility class that provides a method to cast objects to type parameterized
 * classes without a warning.
 */
public class ExpressionCastUtil {
	
	@SuppressWarnings("unchecked")	
	public static <T> T cast(Object temp) {
		return (T) temp;
	}
}
