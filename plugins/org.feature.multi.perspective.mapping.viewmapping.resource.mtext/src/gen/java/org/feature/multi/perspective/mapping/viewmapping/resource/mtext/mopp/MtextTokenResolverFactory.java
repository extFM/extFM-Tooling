/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * The MtextTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class MtextTokenResolverFactory implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolverFactory {
	
	private java.util.Map<String, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver> featureName2CollectInTokenResolver;
	private static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver defaultResolver = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultTokenResolver();
	
	public MtextTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver>();
		registerTokenResolver("QUOTED_60_62", new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextQUOTED_60_62TokenResolver());
		registerTokenResolver("QUOTED_34_34", new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextQUOTED_34_34TokenResolver());
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver internalCreateResolver(java.util.Map<String, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver> resolverMap, String key, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
