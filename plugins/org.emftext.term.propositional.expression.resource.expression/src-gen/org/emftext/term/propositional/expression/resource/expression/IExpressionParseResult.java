/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IExpressionParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>> getPostParseCommands();
	
}
