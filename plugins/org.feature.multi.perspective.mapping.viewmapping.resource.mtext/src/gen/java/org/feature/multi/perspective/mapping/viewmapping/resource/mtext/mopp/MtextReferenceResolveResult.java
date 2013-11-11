/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * A basic implementation of the
 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReference
 * ResolveResult interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class MtextReferenceResolveResult<ReferenceType> implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix> quickFixes;
	
	public MtextReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceMapping<ReferenceType>> getMappings() {
		return mappings;
	}
	
	public boolean wasResolved() {
		return mappings != null;
	}
	
	public boolean wasResolvedMultiple() {
		return mappings != null && mappings.size() > 1;
	}
	
	public boolean wasResolvedUniquely() {
		return mappings != null && mappings.size() == 1;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		if (!resolveFuzzy && target == null) {
			throw new IllegalArgumentException("Mapping references to null is only allowed for fuzzy resolution.");
		}
		addMapping(identifier, target, null);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
