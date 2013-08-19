/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.rbac.resource.rbactext.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Feature;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.RBACResolverUtil;

public class FeatureOperationFeatureReferenceResolver implements org.js.model.rbac.resource.rbactext.IRbactextReferenceResolver<org.js.model.rbac.FeatureOperation, org.js.model.feature.Feature> {
	
	private org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.FeatureOperation, org.js.model.feature.Feature> delegate = new org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.FeatureOperation, org.js.model.feature.Feature>();
	
	public void resolve(String identifier, org.js.model.rbac.FeatureOperation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.rbac.resource.rbactext.IRbactextReferenceResolveResult<org.js.model.feature.Feature> result) {
	   EObject rootContainer = EcoreUtil.getRootContainer(container);
       if (rootContainer instanceof AccessControlModel) {
          AccessControlModel model = (AccessControlModel) rootContainer;
          Feature feature = RBACResolverUtil.findFeature(model, identifier);
          if (feature != null) {
             result.addMapping(identifier, feature);
          }
       } else {
          delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
       }
	}
	
	public String deResolve(org.js.model.feature.Feature element, org.js.model.rbac.FeatureOperation container, org.eclipse.emf.ecore.EReference reference) {
	   return EcoreUtil.getID(element);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
