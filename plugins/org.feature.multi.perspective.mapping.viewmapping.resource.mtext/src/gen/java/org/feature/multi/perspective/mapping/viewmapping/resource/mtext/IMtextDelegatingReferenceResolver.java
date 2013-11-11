/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

/**
 * A delegating reference resolver is an extension of a normal reference resolver
 * that can be configured with another resolver that it may delegate method calls
 * to. This interface can be implemented by additional resolvers to customize
 * resolving using the load option ADDITIONAL_REFERENCE_RESOLVERS.
 * 
 * @see
 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions
 */
public interface IMtextDelegatingReferenceResolver<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Sets the delegate for this resolver.
	 */
	public void setDelegate(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<ContainerType, ReferenceType> delegate);
	
}
