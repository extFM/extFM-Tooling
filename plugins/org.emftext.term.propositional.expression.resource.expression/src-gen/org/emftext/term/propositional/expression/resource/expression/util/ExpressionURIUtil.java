/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.util;

public class ExpressionURIUtil {
	
	public boolean isInBinFolder(org.eclipse.emf.common.util.URI uri) {
		String[] segments = uri.segments();
		for (String segment : segments) {
			if ("bin".equals(segment)) {
				return true;
			}
		}
		return false;
	}
	
}
