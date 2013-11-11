/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * A basic implementation of the
 * org.emftext.term.propositional.expression.resource.expression.IExpressionReferen
 * ceResolveResult interface that collects mappings in a list.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class ExpressionReferenceResolveResult<ReferenceType> implements org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolveResult<ReferenceType> {
	
	private java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceMapping<ReferenceType>> mappings;
	private String errorMessage;
	private boolean resolveFuzzy;
	private java.util.Set<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix> quickFixes;
	
	public ExpressionReferenceResolveResult(boolean resolveFuzzy) {
		super();
		this.resolveFuzzy = resolveFuzzy;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix> getQuickFixes() {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix>();
		}
		return java.util.Collections.unmodifiableSet(quickFixes);
	}
	
	public void addQuickFix(org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix quickFix) {
		if (quickFixes == null) {
			quickFixes = new java.util.LinkedHashSet<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix>();
		}
		quickFixes.add(quickFix);
	}
	
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceMapping<ReferenceType>> getMappings() {
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
			mappings = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionElementMapping<ReferenceType>(identifier, target, warning));
		errorMessage = null;
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		addMapping(identifier, uri, null);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		if (mappings == null) {
			mappings = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceMapping<ReferenceType>>(1);
		}
		mappings.add(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionURIMapping<ReferenceType>(identifier, uri, warning));
	}
}
