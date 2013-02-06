/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.rbac.resource.rbactext.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.rbac.AccessControlModel;

public class ConfigurationOperationFeatureReferenceResolver implements org.js.model.rbac.resource.rbactext.IRbactextReferenceResolver<org.js.model.rbac.ConfigurationOperation, org.js.model.feature.Feature> {
	
	private org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.ConfigurationOperation, org.js.model.feature.Feature> delegate = new org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.ConfigurationOperation, org.js.model.feature.Feature>();
	
	public void resolve(String identifier, org.js.model.rbac.ConfigurationOperation container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.rbac.resource.rbactext.IRbactextReferenceResolveResult<org.js.model.feature.Feature> result) {
	   if (identifier != null && identifier != "") {
	         EObject eContainer = EcoreUtil.getRootContainer(container);
	         if (eContainer instanceof AccessControlModel) {
	            AccessControlModel model = (AccessControlModel) eContainer;
	            EList<FeatureModel> featureModels = model.getFeatureModels();
	            for (FeatureModel featureModel : featureModels) {
	               TreeIterator<Object> allContents = EcoreUtil.getAllContents(featureModel, true);
	               while (allContents.hasNext()) {
	                  Object next = allContents.next();
	                  if (next instanceof Feature) {
	                     Feature feature = (Feature) next;
	                     String featureId = EcoreUtil.getID(feature);
	                     if (identifier.equals(featureId)) {
	                        result.addMapping(identifier, feature);
	                        return;
	                     }
	                  }
	               }
	            }
	         }
	      }
	   delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.js.model.feature.Feature element, org.js.model.rbac.ConfigurationOperation container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
