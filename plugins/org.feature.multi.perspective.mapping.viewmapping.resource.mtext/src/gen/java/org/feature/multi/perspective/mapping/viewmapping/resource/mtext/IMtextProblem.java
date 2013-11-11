/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

public interface IMtextProblem {
	public String getMessage();
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity getSeverity();
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType getType();
	public java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix> getQuickFixes();
}
