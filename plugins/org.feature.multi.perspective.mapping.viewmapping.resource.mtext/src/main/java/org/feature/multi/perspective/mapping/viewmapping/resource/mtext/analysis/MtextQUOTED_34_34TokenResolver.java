/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis;

public class MtextQUOTED_34_34TokenResolver implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver {
	
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultTokenResolver defaultTokenResolver = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
