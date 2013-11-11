/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * An implementation of the ResolveResult interface that delegates all method
 * calls to another ResolveResult. Client may subclass this class to easily create
 * custom ResolveResults.
 * 
 * @param <ReferenceType> the type of the references that can be contained in this
 * result
 */
public class ExpressionDelegatingResolveResult<ReferenceType> implements org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolveResult<ReferenceType> {
	
	private org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolveResult<ReferenceType> delegate;
	
	public ExpressionDelegatingResolveResult(org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolveResult<ReferenceType> delegate) {
		this.delegate = delegate;
	}
	
	public String getErrorMessage() {
		return delegate.getErrorMessage();
	}
	
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceMapping<ReferenceType>> getMappings() {
		return delegate.getMappings();
	}
	
	public boolean wasResolved() {
		return delegate.wasResolved();
	}
	
	public boolean wasResolvedMultiple() {
		return delegate.wasResolvedMultiple();
	}
	
	public boolean wasResolvedUniquely() {
		return delegate.wasResolvedUniquely();
	}
	
	public void setErrorMessage(String message) {
		delegate.setErrorMessage(message);
	}
	
	public void addMapping(String identifier, ReferenceType target) {
		delegate.addMapping(identifier, target);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri) {
		delegate.addMapping(identifier, uri);
	}
	
	public void addMapping(String identifier, ReferenceType target, String warning) {
		delegate.addMapping(identifier, target, warning);
	}
	
	public void addMapping(String identifier, org.eclipse.emf.common.util.URI uri, String warning) {
		delegate.addMapping(identifier, uri, warning);
	}
	
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix> getQuickFixes() {
		return delegate.getQuickFixes();
	}
	
	public void addQuickFix(org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix quickFix) {
		delegate.addQuickFix(quickFix);
	}
	
}
