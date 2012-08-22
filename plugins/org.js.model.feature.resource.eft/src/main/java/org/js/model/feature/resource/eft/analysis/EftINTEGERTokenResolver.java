/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.feature.resource.eft.analysis;

public class EftINTEGERTokenResolver implements org.js.model.feature.resource.eft.IEftTokenResolver {
	
	private org.js.model.feature.resource.eft.analysis.EftDefaultTokenResolver defaultTokenResolver = new org.js.model.feature.resource.eft.analysis.EftDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.js.model.feature.resource.eft.IEftTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
