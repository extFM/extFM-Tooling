/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * The ExpressionTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class ExpressionTokenResolverFactory implements org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolverFactory {
	
	private java.util.Map<String, org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver> featureName2CollectInTokenResolver;
	private static org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver defaultResolver = new org.emftext.term.propositional.expression.resource.expression.analysis.ExpressionDefaultTokenResolver();
	
	public ExpressionTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver>();
		registerTokenResolver("TEXT", new org.emftext.term.propositional.expression.resource.expression.analysis.ExpressionTEXTTokenResolver());
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver internalCreateResolver(java.util.Map<String, org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver> resolverMap, String key, org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
