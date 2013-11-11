/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

public interface IExpressionProblem {
	public String getMessage();
	public org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity getSeverity();
	public org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType getType();
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix> getQuickFixes();
}
