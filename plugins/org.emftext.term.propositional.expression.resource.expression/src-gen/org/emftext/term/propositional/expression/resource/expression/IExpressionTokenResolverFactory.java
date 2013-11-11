/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

/**
 * A TokenResolverFactory creates TokenResolvers. The concrete resolver to be
 * created is determined by the given token name (i.e., the type of the token).
 * One may consider TokenResolverFactories as a registry, which maps token types
 * to TokenResolvers.
 */
public interface IExpressionTokenResolverFactory {
	
	/**
	 * Creates a token resolver for normal tokens of type <code>tokenName</code>.
	 */
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver createTokenResolver(String tokenName);
	
	/**
	 * Creates a token resolver for COLLECT-IN tokens that are stored in feature
	 * <code>featureName</code>.
	 */
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver createCollectInTokenResolver(String featureName);
	
}
