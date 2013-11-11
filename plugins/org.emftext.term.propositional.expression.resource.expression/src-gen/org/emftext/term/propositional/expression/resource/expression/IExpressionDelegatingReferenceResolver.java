/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

/**
 * A delegating reference resolver is an extension of a normal reference resolver
 * that can be configured with another resolver that it may delegate method calls
 * to. This interface can be implemented by additional resolvers to customize
 * resolving using the load option ADDITIONAL_REFERENCE_RESOLVERS.
 * 
 * @see
 * org.emftext.term.propositional.expression.resource.expression.IExpressionOptions
 */
public interface IExpressionDelegatingReferenceResolver<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> extends org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<ContainerType, ReferenceType> {
	
	/**
	 * Sets the delegate for this resolver.
	 */
	public void setDelegate(org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<ContainerType, ReferenceType> delegate);
	
}
