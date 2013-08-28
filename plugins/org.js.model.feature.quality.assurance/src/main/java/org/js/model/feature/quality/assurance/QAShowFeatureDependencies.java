package org.js.model.feature.quality.assurance;

import java.util.*;

import org.eclipse.core.resources.*;
import org.js.model.feature.*;
import org.js.model.feature.csp.FeatureModelHelper;

public class QAShowFeatureDependencies {
	private List<FeatureModel> configurations;
	private FeatureModel model;
	private Feature featureundertest;
	
	/**
	 * Creates a new analyzer for identifying all configurations that
	 * contain the selected Feature
	 * @param files The list of configuration files
	 * @param featureundertest The feature to search for
	 */
	public QAShowFeatureDependencies(List<IFile> files, Feature featureundertest) {
		configurations = new ArrayList<FeatureModel>();
		
		// add feature models to configurations list 
		for (IFile f : files) {
			FeatureModel fm = FeatureModelHelper.getFeatureModel(f);
			if(fm != null)
				configurations.add(fm);
		}
		
		// select one model for analzsis
		model = configurations.get(0);
		
		this.featureundertest = featureundertest;
	}
	
	private boolean isFeatureMandatory() throws Exception {
		// a feature is mandatory if the parent group requires the selection
		// of at least the amount of features that this group contains.
		
		boolean isMandatory = true;	// per default, a feature is mandatory (e.g. root feature)
		
		// select the concrete feature
		Feature feature = null;
		FeatureModelHelper modelHelper = new FeatureModelHelper(model);
		feature = modelHelper.getFeature(featureundertest.getId().toString());
		
		if(feature == null) throw new java.lang.Exception("The feature is not part of the model.");
		
		// is this featureundertest the root? ...else look up in groups
		if(model.getRoot() == feature) {
			isMandatory = true;
			return isMandatory;
		}
		
		// find group this feature is part of
		boolean readyToBreak = false;
		Set<Feature> allFeatures = modelHelper.getAllFeatures();
		for (Feature f : allFeatures) {
			Set<Group> allGroupsOfFeature = new HashSet<Group>();
			allGroupsOfFeature.addAll(f.getGroups());
			for (Group g : allGroupsOfFeature) {
				Set<Feature> allFeaturesOfGroup = new HashSet<Feature>();
				allFeaturesOfGroup.addAll(g.getChildFeatures());
				
				for (Feature f2 : allFeaturesOfGroup) {
					if(f2 == feature) {
						readyToBreak = true;
						if(allFeaturesOfGroup.size() == g.getMinCardinality()) {
							isMandatory = true;
						}
						break;
					}
				}
				
				if(readyToBreak) break;
			}
			
			if(readyToBreak) break;
		}
		
		return isMandatory;
	}

	private Set<Feature> getSuborderedFeatures() {
		return null;
	}
	
	private Set<FeatureConstraint> getFeatureConstraintsAffectingTheFeature() {
		return null;
	}
	
	private Set<FeatureConstraint> getFeatureConstraintsAffectingAFeature(Feature feature) {
		return null;
	}
	
	private Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInRightOperand(Feature feature) {
		return null;
	}
	
	private Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInLeftOperand(Feature feature) {
		return null;
	}
}
