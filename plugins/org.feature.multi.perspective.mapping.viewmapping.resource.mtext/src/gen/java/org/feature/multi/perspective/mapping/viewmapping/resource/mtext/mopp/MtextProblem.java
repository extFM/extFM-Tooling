/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextProblem implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem {
	
	private String message;
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType type;
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity severity;
	private java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix> quickFixes;
	
	public MtextProblem(String message, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType type, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix>emptySet());
	}
	
	public MtextProblem(String message, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType type, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity severity, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public MtextProblem(String message, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType type, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity severity, java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType getType() {
		return type;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
