/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis;

import org.feature.model.utilities.ResourceUtil;
import org.js.model.feature.FeatureModel;

public class MappingModelFeatureModelReferenceResolver
      implements
      org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<org.feature.multi.perspective.mapping.viewmapping.MappingModel, FeatureModel> {

   private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultResolverDelegate<org.feature.multi.perspective.mapping.viewmapping.MappingModel, FeatureModel> delegate =
      new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultResolverDelegate<org.feature.multi.perspective.mapping.viewmapping.MappingModel,FeatureModel>();

   public void resolve(String identifier,
                       org.feature.multi.perspective.mapping.viewmapping.MappingModel container,
                       org.eclipse.emf.ecore.EReference reference,
                       int position,
                       boolean resolveFuzzy,
                       final org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolveResult<FeatureModel> result) {
      delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
   }

   public String deResolve(FeatureModel element,
                           org.feature.multi.perspective.mapping.viewmapping.MappingModel container,
                           org.eclipse.emf.ecore.EReference reference) {
      return ResourceUtil.getRelativeURI(element, container);
   }

   public void setOptions(java.util.Map< ? , ? > options) {
      // save options in a field or leave method empty if this resolver does not depend
      // on any option
   }

}
