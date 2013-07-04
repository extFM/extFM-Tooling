/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.feature.resource.eft.analysis;

public class AttributeReferenceFeatureReferenceResolver implements org.js.model.feature.resource.eft.IEftReferenceResolver<org.js.model.feature.AttributeReference, org.js.model.feature.Feature> {
	
	private org.js.model.feature.resource.eft.analysis.EftDefaultResolverDelegate<org.js.model.feature.AttributeReference, org.js.model.feature.Feature> delegate = new org.js.model.feature.resource.eft.analysis.EftDefaultResolverDelegate<org.js.model.feature.AttributeReference, org.js.model.feature.Feature>();
	
	public void resolve(String identifier, org.js.model.feature.AttributeReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.feature.resource.eft.IEftReferenceResolveResult<org.js.model.feature.Feature> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.js.model.feature.Feature element, org.js.model.feature.AttributeReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
