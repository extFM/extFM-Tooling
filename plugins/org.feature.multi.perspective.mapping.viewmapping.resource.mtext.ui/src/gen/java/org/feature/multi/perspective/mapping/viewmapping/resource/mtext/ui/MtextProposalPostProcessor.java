/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class MtextProposalPostProcessor {
	
	public java.util.List<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextCompletionProposal> process(java.util.List<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextCompletionProposal> proposals) {
		// the default implementation does returns the proposals as they are
		return proposals;
	}
	
}
