/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.expression.resource.expressionText.analysis;

public class ExpressionModelFeatureModelsReferenceResolver implements org.js.model.expression.resource.expressionText.IExpressionTextReferenceResolver<org.js.model.expression.ExpressionModel, org.js.model.feature.FeatureModel> {
	
	private org.js.model.expression.resource.expressionText.analysis.ExpressionTextDefaultResolverDelegate<org.js.model.expression.ExpressionModel, org.js.model.feature.FeatureModel> delegate = new org.js.model.expression.resource.expressionText.analysis.ExpressionTextDefaultResolverDelegate<org.js.model.expression.ExpressionModel, org.js.model.feature.FeatureModel>();
	
	public void resolve(String identifier, org.js.model.expression.ExpressionModel container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.expression.resource.expressionText.IExpressionTextReferenceResolveResult<org.js.model.feature.FeatureModel> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.js.model.feature.FeatureModel element, org.js.model.expression.ExpressionModel container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
