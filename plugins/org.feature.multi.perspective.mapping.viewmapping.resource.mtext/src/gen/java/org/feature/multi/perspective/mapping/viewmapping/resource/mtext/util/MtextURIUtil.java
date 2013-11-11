/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util;

public class MtextURIUtil {
	
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
