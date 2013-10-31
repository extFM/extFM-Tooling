package org.js.model.feature.quality.assurance.analyze;

import java.util.*;

import org.js.model.feature.*;
import org.js.model.feature.edit.FeatureModelHelper;

public class ConfigurationSetStructureAnalyzer extends StructureAnalyzer {
	
	/**
	 * Create a new ConfigurationSetStructureAnalyzer with a specific models set
	 * @param models
	 */
	public ConfigurationSetStructureAnalyzer(Set<FeatureModel> models) {
		super(models);
	}
	
	/**
	 * exchange the tested models
	 * @param models
	 */
	public void resetModels(Set<FeatureModel> models) {
		setModels(models);
	}
	
	/**
	 * Identify all constantly deselected features in all models under test. 
	 * Ensure that all configurations are based on the same feature model!
	 * @return A set of all features constantly deselected 
	 */
	public Set<Feature> getDeselectedFeatures() {
		//get a list with all features
		if(!isModelsSet()) return null;
		if(!setModel((FeatureModel)(getModels().toArray()[0]))) return null;
		FeatureModelHelper helper = new FeatureModelHelper(getModel());
		Set<Feature> features = helper.getAllFeatures();
		
		// iterate over all configurations
		Set<FeatureModel> allmodels = getModels();
		for (FeatureModel model : allmodels) {
			FeatureModelHelper modelHelper = new FeatureModelHelper(model);
			
			// collect all features to potentially remove from results set
			List<Feature> toDelete = new ArrayList<Feature>();
			toDelete.addAll(modelHelper.getSelectedFeatures());
			toDelete.addAll(modelHelper.getUnboundFeatures());
			
			// iterate over all features-to-be-deleted and remove them from the results set if contained
			for (Feature f : toDelete) {
				Feature ref = null;
				
				for (Feature g : features) {
					if(g.getId().equals(f.getId())) {
						ref = g;
						break;
					}
				}
				
				if(ref != null)
					features.remove(ref);
			}
		}
		
		// return results set
		return features;
	}

}
