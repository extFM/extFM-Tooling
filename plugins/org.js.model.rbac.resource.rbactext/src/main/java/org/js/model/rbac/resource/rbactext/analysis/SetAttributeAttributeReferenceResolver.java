/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.rbac.resource.rbactext.analysis;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.rbac.RBACResolverUtil;

public class SetAttributeAttributeReferenceResolver implements org.js.model.rbac.resource.rbactext.IRbactextReferenceResolver<org.js.model.rbac.SetAttribute, org.js.model.feature.Attribute> {
	
	private org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.SetAttribute, org.js.model.feature.Attribute> delegate = new org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.SetAttribute, org.js.model.feature.Attribute>();
	
	public void resolve(String identifier, org.js.model.rbac.SetAttribute container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.rbac.resource.rbactext.IRbactextReferenceResolveResult<org.js.model.feature.Attribute> result) {
	      Feature feature = container.getFeature();
	      Attribute attribute = RBACResolverUtil.findAttribute(feature, identifier);
	      if (attribute != null) {
	         result.addMapping(identifier, attribute);
	      } else {
	         delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	      }
	}
	
	public String deResolve(org.js.model.feature.Attribute element, org.js.model.rbac.SetAttribute container, org.eclipse.emf.ecore.EReference reference) {
	   return EcoreUtil.getID(element);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
