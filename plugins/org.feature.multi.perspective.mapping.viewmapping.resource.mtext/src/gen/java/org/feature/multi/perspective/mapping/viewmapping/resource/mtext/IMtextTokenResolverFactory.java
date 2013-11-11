/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

/**
 * A TokenResolverFactory creates TokenResolvers. The concrete resolver to be
 * created is determined by the given token name (i.e., the type of the token).
 * One may consider TokenResolverFactories as a registry, which maps token types
 * to TokenResolvers.
 */
public interface IMtextTokenResolverFactory {
	
	/**
	 * Creates a token resolver for normal tokens of type <code>tokenName</code>.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver createTokenResolver(String tokenName);
	
	/**
	 * Creates a token resolver for COLLECT-IN tokens that are stored in feature
	 * <code>featureName</code>.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver createCollectInTokenResolver(String featureName);
	
}
