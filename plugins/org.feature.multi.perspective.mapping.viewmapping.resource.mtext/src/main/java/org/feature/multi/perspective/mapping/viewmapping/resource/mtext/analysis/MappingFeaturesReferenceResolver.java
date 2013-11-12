/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.edit.FeatureModelHelper;

public class MappingFeaturesReferenceResolver
      implements
      org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<org.feature.multi.perspective.mapping.viewmapping.Mapping, Feature> {

   private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultResolverDelegate<org.feature.multi.perspective.mapping.viewmapping.Mapping, Feature> delegate =
      new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultResolverDelegate<org.feature.multi.perspective.mapping.viewmapping.Mapping, Feature>();

   public void resolve(String identifier, org.feature.multi.perspective.mapping.viewmapping.Mapping container,
                       org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy,
                       final org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolveResult<Feature> result) {
      EObject model = EcoreUtil.getRootContainer(container);
      if (model instanceof MappingModel) {
         MappingModel mappingModel = (MappingModel) model;
         FeatureModel featureModel = mappingModel.getFeatureModel();
         FeatureModelHelper helper = new FeatureModelHelper(featureModel);
         Set<Feature> allFeatures = helper.getAllFeatures();
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

   public String deResolve(Feature element, org.feature.multi.perspective.mapping.viewmapping.Mapping container,
                           org.eclipse.emf.ecore.EReference reference) {
      return EcoreUtil.getID(element);
   }

   public void setOptions(java.util.Map< ? , ? > options) {
      // save options in a field or leave method empty if this resolver does not depend
      // on any option
   }

}
