/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * A factory for ContextDependentURIFragments. Given a feasible reference
 * resolver, this factory returns a matching fragment that used the resolver to
 * resolver proxy objects.
 * 
 * @param <ContainerType> the type of the class containing the reference to be
 * resolved
 * @param <ReferenceType> the type of the reference to be resolved
 */
public class ExpressionContextDependentURIFragmentFactory<ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject>  implements org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragmentFactory<ContainerType, ReferenceType> {
	
	private final org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<ContainerType, ReferenceType> resolver;
	
	public ExpressionContextDependentURIFragmentFactory(org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<ContainerType, ReferenceType> resolver) {
		this.resolver = resolver;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragment<?> create(String identifier, ContainerType container, org.eclipse.emf.ecore.EReference reference, int positionInReference, org.eclipse.emf.ecore.EObject proxy) {
		
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContextDependentURIFragment<ContainerType, ReferenceType>(identifier, container, reference, positionInReference, proxy) {
			public org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<ContainerType, ReferenceType> getResolver() {
				return resolver;
			}
		};
	}
}
