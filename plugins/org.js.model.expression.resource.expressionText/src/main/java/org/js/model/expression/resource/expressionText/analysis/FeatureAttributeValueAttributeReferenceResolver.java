/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.expression.resource.expressionText.analysis;

import org.eclipse.emf.common.util.EList;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;

public class FeatureAttributeValueAttributeReferenceResolver implements org.js.model.expression.resource.expressionText.IExpressionTextReferenceResolver<org.js.model.expression.FeatureAttributeValue, org.js.model.feature.Attribute> {
	
	private org.js.model.expression.resource.expressionText.analysis.ExpressionTextDefaultResolverDelegate<org.js.model.expression.FeatureAttributeValue, org.js.model.feature.Attribute> delegate = new org.js.model.expression.resource.expressionText.analysis.ExpressionTextDefaultResolverDelegate<org.js.model.expression.FeatureAttributeValue, org.js.model.feature.Attribute>();
	
	public void resolve(String identifier, org.js.model.expression.FeatureAttributeValue container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.expression.resource.expressionText.IExpressionTextReferenceResolveResult<org.js.model.feature.Attribute> result) {
	   Feature feature = container.getFeature();
	      if (feature != null) {
	         EList<Attribute> attributes = feature.getAttributes();
	         for (Attribute featureAttr : attributes) {
	            String attrName = featureAttr.getName();
	            if (identifier.equals(attrName)) {
	               result.addMapping(identifier, featureAttr);
	               return;
	            }
	         }
	      }	
	   delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.js.model.feature.Attribute element, org.js.model.expression.FeatureAttributeValue container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
