package org.js.model.feature.quality.assurance;

import java.util.*;

import org.eclipse.core.resources.*;
import org.js.model.feature.*;
import org.js.model.feature.csp.FeatureModelHelper;
import org.js.model.feature.impl.FeatureImpl;

public class QAShowDeselectedFeatures {

	private List<FeatureModel> configurations;
	
	/**
	 * Creates a new analyzer for identifying all deselected features
	 * @param files The list of configuration files
	 */
	public QAShowDeselectedFeatures(List<IFile> files) {
		configurations = new ArrayList<FeatureModel>();
		
		// add feature models to configurations list 
		for (IFile f : files) {
			FeatureModel fm = FeatureModelHelper.getFeatureModel(f);
			if(fm != null)
				configurations.add(fm);
		}
	}
	
	/**
	 * Identify all constantly deselected features in all configurations under test<br />
	 * Ensure that all configurations are based on the same feature model!
	 * @return A set of all features constantly deselected 
	 */
	public Set<Feature> getAllDeselectedFeatures() {
		// create a list with all features of the model
		FeatureModelHelper helper = new FeatureModelHelper(configurations.get(0));
		Set<Feature> features = helper.getAllFeatures();
		
		// iterate over all configurations
		for (FeatureModel config : configurations) {
			FeatureModelHelper configHelper = new FeatureModelHelper(config);
			
			// collect all features to potentially remove from results set
			List<Feature> toDelete = new ArrayList<Feature>();
			toDelete.addAll(configHelper.getSelectedFeatures());
			toDelete.addAll(configHelper.getUnboundFeatures());
			
			// iterate over all features-to-be-deleted and remove them from the results set if contained
			for (Feature f : toDelete) {
				Feature ref = null;
				
				for (Feature g : features) {
					if(g.getId() == f.getId()) {
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
