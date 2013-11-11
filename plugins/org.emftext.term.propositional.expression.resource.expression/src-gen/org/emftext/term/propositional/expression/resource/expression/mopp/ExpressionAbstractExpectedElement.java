/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class ExpressionAbstractExpectedElement implements org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.emftext.term.propositional.expression.resource.expression.util.ExpressionPair<org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[]>> followers = new java.util.LinkedHashSet<org.emftext.term.propositional.expression.resource.expression.util.ExpressionPair<org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[]>>();
	
	public ExpressionAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement follower, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] path) {
		followers.add(new org.emftext.term.propositional.expression.resource.expression.util.ExpressionPair<org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.util.ExpressionPair<org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
