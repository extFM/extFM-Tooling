/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.expression.resource.expressionText.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.expression.ExpressionModel;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.ReferenceResolverUtil;

public class FeatureReferenceFeatureReferenceResolver implements org.js.model.expression.resource.expressionText.IExpressionTextReferenceResolver<org.js.model.feature.FeatureReference, org.js.model.feature.Feature> {
	
	private org.js.model.expression.resource.expressionText.analysis.ExpressionTextDefaultResolverDelegate<org.js.model.feature.FeatureReference, org.js.model.feature.Feature> delegate = new org.js.model.expression.resource.expressionText.analysis.ExpressionTextDefaultResolverDelegate<org.js.model.feature.FeatureReference, org.js.model.feature.Feature>();
	
	public void resolve(String identifier, org.js.model.feature.FeatureReference container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.js.model.expression.resource.expressionText.IExpressionTextReferenceResolveResult<org.js.model.feature.Feature> result) {
	   EObject rootContainer = EcoreUtil.getRootContainer(container);
	   if (rootContainer instanceof ExpressionModel) {
         ExpressionModel expressionModel = (ExpressionModel) rootContainer;
         EList<FeatureModel> featureModels = expressionModel.getFeatureModels();
         for (FeatureModel featureModel : featureModels) {
           Feature feature = ReferenceResolverUtil.findFeature(identifier, featureModel);
           if (feature != null){
              result.addMapping(identifier, feature);
              return;
           }
         }
      }
	   
	   delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.js.model.feature.Feature element, org.js.model.feature.FeatureReference container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
