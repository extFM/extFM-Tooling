/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.rbac.resource.rbactext.analysis;

public class VisibilityPermissionResourceReferenceResolver implements org.js.model.rbac.resource.rbactext.IRbactextReferenceResolver<org.js.model.rbac.VisibilityPermission, org.eclipse.emf.ecore.EObject> {
	
	private org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.VisibilityPermission, org.eclipse.emf.ecore.EObject> delegate = new org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.VisibilityPermission, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(String identifier, org.js.model.rbac.VisibilityPermission container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.rbac.resource.rbactext.IRbactextReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EObject element, org.js.model.rbac.VisibilityPermission container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
