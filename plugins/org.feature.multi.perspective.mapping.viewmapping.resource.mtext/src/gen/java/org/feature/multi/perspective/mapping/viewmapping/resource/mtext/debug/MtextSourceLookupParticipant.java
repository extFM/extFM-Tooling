/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug;

public class MtextSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.MtextStackFrame) {
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.MtextStackFrame frame = (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.MtextStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
