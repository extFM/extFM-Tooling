/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionProblem implements org.emftext.term.propositional.expression.resource.expression.IExpressionProblem {
	
	private String message;
	private org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType type;
	private org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity severity;
	private java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix> quickFixes;
	
	public ExpressionProblem(String message, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType type, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix>emptySet());
	}
	
	public ExpressionProblem(String message, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType type, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity severity, org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public ExpressionProblem(String message, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType type, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity severity, java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType getType() {
		return type;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
