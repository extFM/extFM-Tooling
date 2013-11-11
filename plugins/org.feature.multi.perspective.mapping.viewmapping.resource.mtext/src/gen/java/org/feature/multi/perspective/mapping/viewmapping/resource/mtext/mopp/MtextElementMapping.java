/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * A basic implementation of the
 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextElementMa
 * pping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class MtextElementMapping<ReferenceType> implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public MtextElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
