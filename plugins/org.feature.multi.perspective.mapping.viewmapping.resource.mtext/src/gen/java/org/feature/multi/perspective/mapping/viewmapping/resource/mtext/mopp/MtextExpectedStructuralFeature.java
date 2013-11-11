/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class MtextExpectedStructuralFeature extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextAbstractExpectedElement {
	
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextPlaceholder placeholder;
	
	public MtextExpectedStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement getSymtaxElement() {
		return placeholder;
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof MtextExpectedStructuralFeature) {
			return getFeature().equals(((MtextExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
