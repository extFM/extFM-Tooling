/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util;

/**
 * Utility class that provides a method to cast objects to type parameterized
 * classes without a warning.
 */
public class MtextCastUtil {
	
	@SuppressWarnings("unchecked")	
	public static <T> T cast(Object temp) {
		return (T) temp;
	}
}
