/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

public class MappingFeaturesReferenceResolver
      implements
      org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.featuremapper.models.feature.Feature> {

   private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultResolverDelegate<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.featuremapper.models.feature.Feature> delegate =
      new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultResolverDelegate<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.featuremapper.models.feature.Feature>();

   public void resolve(String identifier,
                       org.feature.multi.perspective.mapping.viewmapping.Mapping container,
                       org.eclipse.emf.ecore.EReference reference,
                       int position,
                       boolean resolveFuzzy,
                       final org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolveResult<org.featuremapper.models.feature.Feature> result) {
      EObject model = EcoreUtil.getRootContainer(container);
      if (model instanceof MappingModel) {
         MappingModel mappingModel = (MappingModel) model;
         FeatureModel featureModel = mappingModel.getFeatureModel();
         EList<Feature> allFeatures = featureModel.getAllFeatures();
         for (Feature feature : allFeatures) {
            String featureId = EcoreUtil.getID(feature);
            if (identifier.equals(featureId)) {
               result.addMapping(identifier, feature);
               break;
            }
         }
      } else {
         delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
      }
   }

   public String deResolve(org.featuremapper.models.feature.Feature element,
                           org.feature.multi.perspective.mapping.viewmapping.Mapping container, org.eclipse.emf.ecore.EReference reference) {
         return element.getName();
   }

   public void setOptions(java.util.Map< ? , ? > options) {
      // save options in a field or leave method empty if this resolver does not depend
      // on any option
   }

}
