/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.rbac.resource.rbactext.analysis;

public class SetAttributeDomainValueOperationsReferenceResolver implements org.js.model.rbac.resource.rbactext.IRbactextReferenceResolver<org.js.model.rbac.SetAttribute, org.js.model.rbac.DomainValueOperation> {
	
	private org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.SetAttribute, org.js.model.rbac.DomainValueOperation> delegate = new org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.SetAttribute, org.js.model.rbac.DomainValueOperation>();
	
	public void resolve(String identifier, org.js.model.rbac.SetAttribute container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.rbac.resource.rbactext.IRbactextReferenceResolveResult<org.js.model.rbac.DomainValueOperation> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.js.model.rbac.DomainValueOperation element, org.js.model.rbac.SetAttribute container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
