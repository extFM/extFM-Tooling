/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.expression.resource.expressionText.analysis;

public class AttributeReferenceAttributeReferenceResolver implements org.js.model.expression.resource.expressionText.IExpressionTextReferenceResolver<org.js.model.feature.AttributeReference, org.js.model.feature.Attribute> {
	
	private org.js.model.expression.resource.expressionText.analysis.ExpressionTextDefaultResolverDelegate<org.js.model.feature.AttributeReference, org.js.model.feature.Attribute> delegate = new org.js.model.expression.resource.expressionText.analysis.ExpressionTextDefaultResolverDelegate<org.js.model.feature.AttributeReference, org.js.model.feature.Attribute>();
	
	public void resolve(String identifier, org.js.model.feature.AttributeReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.expression.resource.expressionText.IExpressionTextReferenceResolveResult<org.js.model.feature.Attribute> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.js.model.feature.Attribute element, org.js.model.feature.AttributeReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
