/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class ExpressionRule extends org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public ExpressionRule(org.eclipse.emf.ecore.EClass metaclass, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice choice, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality) {
		super(cardinality, new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice getDefinition() {
		return (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice) getChildren()[0];
	}
	
}

