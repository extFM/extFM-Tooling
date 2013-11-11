/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public ExpressionResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionResource(uri);
	}
	
}
