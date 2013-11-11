/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.analysis;

public class ExpressionTEXTTokenResolver implements org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver {
	
	private org.emftext.term.propositional.expression.resource.expression.analysis.ExpressionDefaultTokenResolver defaultTokenResolver = new org.emftext.term.propositional.expression.resource.expression.analysis.ExpressionDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
