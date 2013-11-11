/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.analysis;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.edit.FeatureModelHelper;

public class FeatureRefFeatureReferenceResolver
      implements
      org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver<org.emftext.term.propositional.expression.FeatureRef, Feature> {

   private org.emftext.term.propositional.expression.resource.expression.analysis.ExpressionDefaultResolverDelegate<org.emftext.term.propositional.expression.FeatureRef, Feature> delegate =
      new org.emftext.term.propositional.expression.resource.expression.analysis.ExpressionDefaultResolverDelegate<org.emftext.term.propositional.expression.FeatureRef, Feature>();

   public void resolve(String identifier, org.emftext.term.propositional.expression.FeatureRef container,
                       org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy,
                       final org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolveResult<Feature> result) {
      Resource containerResource = container.eResource();
      URI featureModelResource = containerResource.getURI().trimFileExtension().trimFileExtension();
      FeatureModel fm = getFeatureModel(featureModelResource, containerResource.getResourceSet());
      if (fm != null) {
         FeatureModelHelper helper = new FeatureModelHelper(fm);
         Set<Feature> allFeatures = helper.getAllFeatures();
         for (Feature feature : allFeatures) {
            String id = EcoreUtil.getID(feature);
            if (id.equals(identifier)) {
               result.addMapping(identifier, feature);
               return;
            }
         }
      }
      delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
   }

   private FeatureModel getFeatureModel(URI featureModelResource, ResourceSet resourceSet) {
      FeatureModel fm = null;
      URI uri = featureModelResource.appendFileExtension("feature");
      Resource resource = resourceSet.getResource(uri, false);
      if (resource != null && resource.getContents().size() == 1 && resource.getContents().get(0) instanceof FeatureModel) {
         fm = (FeatureModel) resource.getContents().get(0);
      } else {
         uri = featureModelResource.appendFileExtension("eft");
         resource = resourceSet.getResource(uri, true);
         if (resource != null && resource.getContents().size() == 1 && resource.getContents().get(0) instanceof FeatureModel) {
            fm = (FeatureModel) resource.getContents().get(0);
         }
      }
      return fm;
   }

   public String deResolve(Feature element, org.emftext.term.propositional.expression.FeatureRef container,
                           org.eclipse.emf.ecore.EReference reference) {
      
     return container.getFeature().getId();
   }

   public void setOptions(java.util.Map< ? , ? > options) {
      // save options in a field or leave method empty if this resolver does not depend
      // on any option
   }

}
