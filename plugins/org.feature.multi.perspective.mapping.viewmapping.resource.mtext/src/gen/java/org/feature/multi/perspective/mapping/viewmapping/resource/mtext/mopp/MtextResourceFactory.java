/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public MtextResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextResource(uri);
	}
	
}
