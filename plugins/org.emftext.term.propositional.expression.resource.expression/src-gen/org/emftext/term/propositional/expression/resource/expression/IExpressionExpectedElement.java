/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IExpressionExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement follower, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.util.ExpressionPair<org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[]>> getFollowers();
	
}
