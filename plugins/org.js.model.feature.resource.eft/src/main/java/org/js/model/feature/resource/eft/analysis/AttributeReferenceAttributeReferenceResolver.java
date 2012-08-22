/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.feature.resource.eft.analysis;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.ReferenceResolverUtil;

public class AttributeReferenceAttributeReferenceResolver implements org.js.model.feature.resource.eft.IEftReferenceResolver<org.js.model.feature.AttributeReference, org.js.model.feature.Attribute> {
	
//	private org.js.model.feature.resource.eft.analysis.EftDefaultResolverDelegate<org.js.model.feature.AttributeReference, org.js.model.feature.Attribute> delegate = new org.js.model.feature.resource.eft.analysis.EftDefaultResolverDelegate<org.js.model.feature.AttributeReference, org.js.model.feature.Attribute>();
	
	public void resolve(String identifier, org.js.model.feature.AttributeReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.feature.resource.eft.IEftReferenceResolveResult<org.js.model.feature.Attribute> result) {
		FeatureModel featureModel = (FeatureModel) EcoreUtil.getRootContainer(container);
		Attribute attribute = ReferenceResolverUtil.resolveAttribute(identifier, featureModel);
		
		if (attribute != null) {
			//System.out.println("Attribute: " + attribute.getName() + ", Feature: " + feature.getId() + " identified.");
			//NOTE: identification of attribute is correct even though the
			//editor targets the wrong attribute if ctrl-clicked.
			result.addMapping(identifier, attribute);
		}
	}
	
	public String deResolve(org.js.model.feature.Attribute element, org.js.model.feature.AttributeReference container, org.eclipse.emf.ecore.EReference reference) {
//		return delegate.deResolve(element, container, reference);
		return ReferenceResolverUtil.deresolveAttribute(element);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
