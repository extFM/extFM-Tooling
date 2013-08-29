package org.js.model.feature.quality.assurance;

import java.util.*;

import org.eclipse.core.resources.IFile;
import org.js.model.feature.*;
import org.js.model.feature.csp.FeatureModelHelper;

public class QAShowModelsContainingAFeature {
	
	private List<FeatureModel> configurations;
	private Feature featureundertest;
	
	/**
	 * Creates a new analyzer for identifying all configurations that
	 * contain the selected Feature
	 * @param files The list of configuration files
	 * @param featureundertest The feature to search for
	 */
	public QAShowModelsContainingAFeature(List<IFile> files, Feature featureundertest) {
		configurations = new ArrayList<FeatureModel>();
		
		// add feature models to configurations list 
		for (IFile f : files) {
			FeatureModel fm = FeatureModelHelper.getFeatureModel(f);
			if(fm != null)
				configurations.add(fm);
		}
		
		this.featureundertest = featureundertest;
	}
	
	/**
	 * Identifies all configurations that contain the feature under test 
	 * @return A set of configurations that contain the feature under test.
	 */
	public Set<FeatureModel> getAllModelsContainingTheFeature() {
		Set<FeatureModel> results = new HashSet<FeatureModel>();
		
		for (FeatureModel currentModel : configurations) {
			FeatureModelHelper currentModelHelper = new FeatureModelHelper(currentModel);
			Feature concreteFeature = currentModelHelper.getFeature(featureundertest.getId()); 
			if(concreteFeature != null) {
				if(concreteFeature.getConfigurationState() != FeatureState.DESELECTED)
					results.add(currentModel);	
			}
		}
		
		return results;
	}
}
