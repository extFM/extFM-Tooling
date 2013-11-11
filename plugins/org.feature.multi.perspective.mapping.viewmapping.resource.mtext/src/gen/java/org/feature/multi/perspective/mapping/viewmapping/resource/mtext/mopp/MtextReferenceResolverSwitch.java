/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextReferenceResolverSwitch implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MappingModelFeatureModelReferenceResolver mappingModelFeatureModelReferenceResolver = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MappingModelFeatureModelReferenceResolver();
	protected org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MappingModelViewModelReferenceResolver mappingModelViewModelReferenceResolver = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MappingModelViewModelReferenceResolver();
	protected org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MappingViewgroupReferenceResolver mappingViewgroupReferenceResolver = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MappingViewgroupReferenceResolver();
	protected org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MappingFeaturesReferenceResolver mappingFeaturesReferenceResolver = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MappingFeaturesReferenceResolver();
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<org.feature.multi.perspective.mapping.viewmapping.MappingModel, org.featuremapper.models.feature.FeatureModel> getMappingModelFeatureModelReferenceResolver() {
		return getResolverChain(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel_FeatureModel(), mappingModelFeatureModelReferenceResolver);
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<org.feature.multi.perspective.mapping.viewmapping.MappingModel, org.feature.multi.perspective.model.viewmodel.GroupModel> getMappingModelViewModelReferenceResolver() {
		return getResolverChain(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel_ViewModel(), mappingModelViewModelReferenceResolver);
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.feature.multi.perspective.model.viewmodel.AbstractGroup> getMappingViewgroupReferenceResolver() {
		return getResolverChain(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping_Viewgroup(), mappingViewgroupReferenceResolver);
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.featuremapper.models.feature.Feature> getMappingFeaturesReferenceResolver() {
		return getResolverChain(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping_Features(), mappingFeaturesReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		mappingModelFeatureModelReferenceResolver.setOptions(options);
		mappingModelViewModelReferenceResolver.setOptions(options);
		mappingViewgroupReferenceResolver.setOptions(options);
		mappingFeaturesReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel().isInstance(container)) {
			MtextFuzzyResolveResult<org.featuremapper.models.feature.FeatureModel> frr = new MtextFuzzyResolveResult<org.featuremapper.models.feature.FeatureModel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("featureModel")) {
				mappingModelFeatureModelReferenceResolver.resolve(identifier, (org.feature.multi.perspective.mapping.viewmapping.MappingModel) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel().isInstance(container)) {
			MtextFuzzyResolveResult<org.feature.multi.perspective.model.viewmodel.GroupModel> frr = new MtextFuzzyResolveResult<org.feature.multi.perspective.model.viewmodel.GroupModel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("viewModel")) {
				mappingModelViewModelReferenceResolver.resolve(identifier, (org.feature.multi.perspective.mapping.viewmapping.MappingModel) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping().isInstance(container)) {
			MtextFuzzyResolveResult<org.feature.multi.perspective.model.viewmodel.AbstractGroup> frr = new MtextFuzzyResolveResult<org.feature.multi.perspective.model.viewmodel.AbstractGroup>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("viewgroup")) {
				mappingViewgroupReferenceResolver.resolve(identifier, (org.feature.multi.perspective.mapping.viewmapping.Mapping) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping().isInstance(container)) {
			MtextFuzzyResolveResult<org.featuremapper.models.feature.Feature> frr = new MtextFuzzyResolveResult<org.featuremapper.models.feature.Feature>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("features")) {
				mappingFeaturesReferenceResolver.resolve(identifier, (org.feature.multi.perspective.mapping.viewmapping.Mapping) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel_FeatureModel()) {
			return getResolverChain(reference, mappingModelFeatureModelReferenceResolver);
		}
		if (reference == org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel_ViewModel()) {
			return getResolverChain(reference, mappingModelViewModelReferenceResolver);
		}
		if (reference == org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping_Viewgroup()) {
			return getResolverChain(reference, mappingViewgroupReferenceResolver);
		}
		if (reference == org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping_Features()) {
			return getResolverChain(reference, mappingFeaturesReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextRuntimeUtil().logWarning("Found value with invalid type for option " + org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver) {
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver replacingResolver = (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver) resolverValue;
			if (replacingResolver instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceCache) {
					org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver nextResolver = (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver) next;
					if (nextResolver instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextRuntimeUtil().logWarning("Found value with invalid type in value map for option " + org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
