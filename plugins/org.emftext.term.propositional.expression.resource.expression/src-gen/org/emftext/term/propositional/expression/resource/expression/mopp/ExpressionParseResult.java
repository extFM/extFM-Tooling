/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionParseResult implements org.emftext.term.propositional.expression.resource.expression.IExpressionParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>> commands = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>>();
	
	public ExpressionParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
