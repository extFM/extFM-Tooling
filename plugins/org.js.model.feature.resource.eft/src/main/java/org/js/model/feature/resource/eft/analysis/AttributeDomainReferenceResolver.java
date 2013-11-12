/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.feature.resource.eft.analysis;

public class AttributeDomainReferenceResolver implements org.js.model.feature.resource.eft.IEftReferenceResolver<org.js.model.feature.Attribute, org.js.model.feature.Domain> {
	
	private org.js.model.feature.resource.eft.analysis.EftDefaultResolverDelegate<org.js.model.feature.Attribute, org.js.model.feature.Domain> delegate = new org.js.model.feature.resource.eft.analysis.EftDefaultResolverDelegate<org.js.model.feature.Attribute, org.js.model.feature.Domain>();
	
	public void resolve(String identifier, org.js.model.feature.Attribute container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.feature.resource.eft.IEftReferenceResolveResult<org.js.model.feature.Domain> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.js.model.feature.Domain element, org.js.model.feature.Attribute container, org.eclipse.emf.ecore.EReference reference) {
		return element.getId();
	   //return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
