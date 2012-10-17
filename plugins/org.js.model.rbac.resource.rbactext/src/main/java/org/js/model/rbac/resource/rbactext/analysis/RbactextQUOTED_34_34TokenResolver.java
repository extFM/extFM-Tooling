/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.rbac.resource.rbactext.analysis;

public class RbactextQUOTED_34_34TokenResolver implements org.js.model.rbac.resource.rbactext.IRbactextTokenResolver {
	
	private org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultTokenResolver defaultTokenResolver = new org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "\"", "\"", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "\"", "\"", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
