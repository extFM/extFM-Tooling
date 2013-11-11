/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * A basic implementation of the
 * org.emftext.term.propositional.expression.resource.expression.IExpressionURIMapp
 * ing interface that can map identifiers to URIs.
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * org.emftext.term.propositional.expression.resource.expression.IExpressionURIMapp
 * ing.
 */
public class ExpressionURIMapping<ReferenceType> implements org.emftext.term.propositional.expression.resource.expression.IExpressionURIMapping<ReferenceType> {
	
	private org.eclipse.emf.common.util.URI uri;
	private String identifier;
	private String warning;
	
	public ExpressionURIMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
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
