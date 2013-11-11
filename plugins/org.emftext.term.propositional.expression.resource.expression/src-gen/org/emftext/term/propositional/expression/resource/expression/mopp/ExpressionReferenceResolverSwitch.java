/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionReferenceResolverSwitch implements org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected org.emftext.term.propositional.expression.resource.expression.analysis.FeatureRefFeatureReferenceResolver featureRefFeatureReferenceResolver = new org.emftext.term.propositional.expression.resource.expression.analysis.FeatureRefFeatureReferenceResolver();
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<org.emftext.term.propositional.expression.FeatureRef, org.js.model.feature.Feature> getFeatureRefFeatureReferenceResolver() {
		return getResolverChain(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef_Feature(), featureRefFeatureReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		featureRefFeatureReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef().isInstance(container)) {
			ExpressionFuzzyResolveResult<org.js.model.feature.Feature> frr = new ExpressionFuzzyResolveResult<org.js.model.feature.Feature>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("feature")) {
				featureRefFeatureReferenceResolver.resolve(identifier, (org.emftext.term.propositional.expression.FeatureRef) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef_Feature()) {
			return getResolverChain(reference, featureRefFeatureReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.emftext.term.propositional.expression.resource.expression.IExpressionOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.emftext.term.propositional.expression.resource.expression.util.ExpressionRuntimeUtil().logWarning("Found value with invalid type for option " + org.emftext.term.propositional.expression.resource.expression.IExpressionOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver) {
			org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver replacingResolver = (org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.emftext.term.propositional.expression.resource.expression.IExpressionDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.emftext.term.propositional.expression.resource.expression.IExpressionDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceCache) {
					org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver nextResolver = (org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver) next;
					if (nextResolver instanceof org.emftext.term.propositional.expression.resource.expression.IExpressionDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.emftext.term.propositional.expression.resource.expression.IExpressionDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.emftext.term.propositional.expression.resource.expression.util.ExpressionRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.term.propositional.expression.resource.expression.IExpressionOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.term.propositional.expression.resource.expression.IExpressionDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.emftext.term.propositional.expression.resource.expression.util.ExpressionRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.emftext.term.propositional.expression.resource.expression.IExpressionOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.emftext.term.propositional.expression.resource.expression.IExpressionDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
