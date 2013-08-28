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
	 * Creates a new analyzer for identifying all feature constraints
	 * affecting the selection state of a feature in a configuration
	 * @param files The list of configuration files
	 * @param featureundertest The feature to search for
	 * @throws Exception 
	 */
	public QAShowFeatureDependencies(List<IFile> files, Feature featureundertest) throws Exception {
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
		
		// select the concrete feature
		Feature feature = null;
		FeatureModelHelper modelHelper = new FeatureModelHelper(model);
		feature = modelHelper.getFeature(featureundertest.getId().toString());
		
		if(feature == null) throw new java.lang.Exception("The feature is not part of the model.");
		
		// ensures that the featureundertest is a reference to a concrete feature in model
		this.featureundertest = feature;
	}
	
	public boolean isFeatureMandatory() {
		// a feature is mandatory if the parent group requires the selection
		// of at least the amount of features that this group contains.
		
		boolean isMandatory = true;	// per default, a feature is mandatory (e.g. root feature)
		
		// select the concrete feature
		Feature feature = featureundertest;
		FeatureModelHelper modelHelper = new FeatureModelHelper(model);
		
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
	
	public Set<FeatureConstraint> getAffectingFeatureConstraints() {
		Set<FeatureConstraint> results = new HashSet<FeatureConstraint>();
		
		results.addAll(getFeatureConstraintsAffectingTheFeature());
		for (Feature feature : getSuborderedFeatures()) {
			results.addAll(getFeatureConstraintsAffectingFeatureInImplyRightOperand(feature));
		}
		
		return results;
	}

	private Set<Feature> getSuborderedFeatures() {
		return getSuborderedFeatures(featureundertest);
	}
	
	private Set<Feature> getSuborderedFeatures(Feature feature) {
		Set<Group> groups = new HashSet<Group>();
		groups.addAll(feature.getGroups());
		
		Set<Feature> results = new HashSet<Feature>();
		
		for (Group group : groups) {
			Set<Feature> childfeatures = new HashSet<Feature>();
			childfeatures.addAll(group.getChildFeatures());
			
			for (Feature cf : childfeatures) {
				// add this child feature and get all subordered features via recursion
				results.add(cf);
				results.addAll(getSuborderedFeatures(cf));
			}
		}
		
		return results;
	}
	
	private Set<FeatureConstraint> getFeatureConstraintsAffectingTheFeature() {
		return getFeatureConstraintsAffectingAFeature(featureundertest);
	}
	
	private Set<FeatureConstraint> getFeatureConstraintsAffectingAFeature(Feature feature) {
		Set<FeatureConstraint> results = new HashSet<FeatureConstraint>();
		results.addAll(getFeatureConstraintsAffectingFeatureInImplyRightOperand(feature));
		results.addAll(getFeatureConstraintsAffectingFeatureInImplyLeftOperand(feature));
		results.addAll(getFeatureConstraintsAffectingFeatureInExcludeRightOperand(feature));
		results.addAll(getFeatureConstraintsAffectingFeatureInExcludeLeftOperand(feature));
		
		return results;
	}
	
	private Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInImplyRightOperand(Feature feature) {
		//TODO: implement this method
		return null;
	}
	
	private Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInImplyLeftOperand(Feature feature) {
		//TODO: implement this method
		return null;
	}
	
	private Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInExcludeRightOperand(Feature feature) {
		//TODO: implement this method
		return null;
	}
	
	private Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInExcludeLeftOperand(Feature feature) {
		//TODO: implement this method
		return null;
	}
}
