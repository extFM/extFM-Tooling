/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * A basic implementation of the
 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextURIMappin
 * g interface that can map identifiers to URIs.
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextURIMappin
 * g.
 */
public class MtextURIMapping<ReferenceType> implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextURIMapping<ReferenceType> {
	
	private org.eclipse.emf.common.util.URI uri;
	private String identifier;
	private String warning;
	
	public MtextURIMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
		super();
		this.uri = newIdentifier;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public org.eclipse.emf.common.util.URI getTargetIdentifier() {
		return uri;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
