/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.expression.resource.expressionText.analysis;

public class ExpressionTextGREATERTHANTokenResolver implements org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver {
	
	private org.js.model.expression.resource.expressionText.analysis.ExpressionTextDefaultTokenResolver defaultTokenResolver = new org.js.model.expression.resource.expressionText.analysis.ExpressionTextDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
