/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug;

public class MtextSourceLocator extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector {
	
	public void initializeParticipants() {
		addParticipants(new org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant[]{new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.MtextSourceLookupParticipant()});
	}
	
}
