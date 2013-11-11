/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class MtextContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public MtextContextDependentURIFragmentFactory(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
