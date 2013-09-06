package org.js.model.feature.quality.assurance.analyze;

import java.util.*;

import org.js.model.feature.*;
import org.js.model.feature.csp.FeatureModelHelper;

public class FeatureBasedStructureAnalyzer extends StructureAnalyzer {
	
	/**
	 * Create a new FeatureBasedStructureAnalyzer with all capabilities
	 * @param models
	 * @param model
	 * @param feature
	 * @throws Exception Throws, if there is any kind of inconsistency within the parameters  
	 */
	public FeatureBasedStructureAnalyzer(Set<FeatureModel> models, FeatureModel model, Feature feature) throws Exception {
		super(models, model, feature);
	}
	
	/**
	 * Reset the test environment (models, model feature)
	 * @param models
	 * @param model
	 * @param feature
	 * @return <code>True</code> if resetting was successful. If resetting was not successful,
	 * the former state will be rolled back and this method returns <code>false</code>.
	 */
	public boolean resetAll(Set<FeatureModel> models, FeatureModel model, Feature feature) {
		Set<FeatureModel> oldModels = getModels();
		FeatureModel oldModel = getModel();
		Feature oldFeature = getFeature();
		boolean success = true;
		
		setModels(models);
		success = setModel(model);
		if(!success) {
			setModels(oldModels);
			setModel(oldModel);
			setFeature(oldFeature);
			return false;
		}
		success = setFeature(feature);
		if(!success) {
			setModels(oldModels);
			setModel(oldModel);
			setFeature(oldFeature);
			return false;
		}
		
		return true;
	}
	
	/**
	 * Reset the feature under test
	 * @param feature
	 * @return <code>True</code> if resetting was successful. If resetting was not successful,
	 * the former state will be rolled back and this method returns <code>false</code>.
	 */
	public boolean resetFeature(Feature feature) {
		return setFeature(feature);
	}
	
	/**
	 * Identifies all models that contain the feature under test 
	 * @return A set of models that contain the feature under test. Returns null if the result set
	 * is not defined.
	 */
	public Set<FeatureModel> getFeatureModelsContainingFeature() {
		if(!isModelsSet() || !isFeatureSet()) return null;
		
		Set<FeatureModel> results = new HashSet<FeatureModel>();
		
		for (FeatureModel currentModel : getModels()) {
			FeatureModelHelper currentModelHelper = new FeatureModelHelper(currentModel);
			Feature concreteFeature = currentModelHelper.getFeature(getFeature().getId()); 
			if(concreteFeature != null) {
				if(concreteFeature.getConfigurationState() != FeatureState.DESELECTED)
					results.add(currentModel);	
			}
		}
		
		return results;
	}
	
	/**
	 * Identifies the feature as mandatory or optional
	 * @return <code>True</code> if the feature is mandatory, else <code>false</code>.
	 * @throws Exception If there is no model or feature that has been set.
	 */
	public boolean isFeatureMandatory() throws Exception {
		if(!isModelSet() || !isFeatureSet())
			throw new Exception("At least the model or feature is not set.");
		
		// a feature is mandatory if the parent group requires the selection
		// of at least the amount of features that this group contains.
		
		boolean isMandatory = true;	// per default, a feature is mandatory (e.g. root feature)
		FeatureModelHelper modelHelper = new FeatureModelHelper(getModel());
		
		// is this feature the root feature of the model? ...else look up in groups
		if(getModel().getRoot() == getFeature()) {
			// isMandatory = true; (it's already true by default)
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
					if(f2 == getFeature()) {
						readyToBreak = true;
						if(allFeaturesOfGroup.size() > g.getMinCardinality()) {
							isMandatory = false;
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
	
	/**
	 * Get all Feature Constraints that affect the selection state of the feature
	 * @return
	 */
	public Set<FeatureConstraint> getFeatureConstraintsAffectingFeature() {
		Set<FeatureConstraint> results = new HashSet<FeatureConstraint>();
		
		results.addAll(getFeatureConstraintsAffectingFeatureInAnyOperand());
		for (Feature feature : getSuborderedFeatures()) {
			results.addAll(getFeatureConstraintsAffectingFeatureInImplyRightOperand(feature));
		}
		
		return results;
	}
	
	/**
	 * Get all feature constraints that directly affect the selection state of the feature under test
	 * @return
	 */
	public Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInAnyOperand() {
		if(!isFeatureSet()) return null;
		return getFeatureConstraintsAffectingFeatureInAnyOperand(getFeature());
	}
	
	/**
	 * Get all feature constraints that directly affect the selection state of the given feature
	 * @param feature
	 * @return
	 */
	private Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInAnyOperand(Feature feature) {
		Set<FeatureConstraint> results = new HashSet<FeatureConstraint>();
		results.addAll(getFeatureConstraintsAffectingFeatureInImplyRightOperand(feature));
		results.addAll(getFeatureConstraintsAffectingFeatureInImplyLeftOperand(feature));
		results.addAll(getFeatureConstraintsAffectingFeatureInExcludeRightOperand(feature));
		results.addAll(getFeatureConstraintsAffectingFeatureInExcludeLeftOperand(feature));
		
		return results;
	}
	
	/**
	 * Get all imply feature constraints that contain the feature under test in the right operand.
	 * @return
	 */
	public Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInImplyRightOperand() {
		if(!isFeatureSet()) return null;
		return getFeatureConstraintsAffectingFeatureInImplyRightOperand(getFeature());
	}
	
	/**
	 * Get all imply feature constraints that contain the feature in the right operand.
	 * @param feature
	 * @return
	 */
	private Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInImplyRightOperand(Feature feature) {
		if(!isModelSet()) return null;
		FeatureModelHelper fmh = new FeatureModelHelper(getModel());
		Set<FeatureConstraint> allconstraints = fmh.getAllFeatureConstraints();
		Set<Imply> allimplys = new HashSet<Imply>();
		
		for (FeatureConstraint fc : allconstraints) {
			if(fc instanceof Imply) {
				allimplys.add((Imply) fc);
			}
		}
		
		Set<FeatureConstraint> results = new HashSet<FeatureConstraint>();
		
		for (Imply imply : allimplys) {
			if(imply.getRightOperand() == feature)
				results.add(imply);
		}
		
		return results;
	}
	
	/**
	 * Get all imply feature constraints that contain the feature under test in the left operand.
	 * @return
	 */
	public Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInImplyLeftOperand() {
		if(!isFeatureSet()) return null;
		return getFeatureConstraintsAffectingFeatureInImplyLeftOperand(getFeature());
	}
	
	/**
	 * Get all imply feature constraints that contain the feature in the left operand.
	 * @param feature
	 * @return
	 */
	private Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInImplyLeftOperand(Feature feature) {
		if(!isModelSet()) return null;
		FeatureModelHelper fmh = new FeatureModelHelper(getModel());
		Set<FeatureConstraint> allconstraints = fmh.getAllFeatureConstraints();
		Set<Imply> allimplys = new HashSet<Imply>();
		
		for (FeatureConstraint fc : allconstraints) {
			if(fc instanceof Imply) {
				allimplys.add((Imply) fc);
			}
		}
		
		Set<FeatureConstraint> results = new HashSet<FeatureConstraint>();
		
		for (Imply imply : allimplys) {
			if(imply.getLeftOperand() == feature)
				results.add(imply);
		}
		
		return results;
	}
	
	/**
	 * Get all exclude feature constraints that contain the feature under test in the right operand.
	 * @return
	 */
	public Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInExcludeRightOperand() {
		if(!isFeatureSet()) return null;
		return getFeatureConstraintsAffectingFeatureInExcludeRightOperand(getFeature());
	}
	
	/**
	 * Get all exclude feature constraints that contain the feature in the right operand.
	 * @param feature
	 * @return
	 */
	private Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInExcludeRightOperand(Feature feature) {
		if(!isModelSet()) return null;
		FeatureModelHelper fmh = new FeatureModelHelper(getModel());
		Set<FeatureConstraint> allconstraints = fmh.getAllFeatureConstraints();
		Set<Exclude> allexcludes = new HashSet<Exclude>();
		
		for (FeatureConstraint fc : allconstraints) {
			if(fc instanceof Exclude) {
				allexcludes.add((Exclude) fc);
			}
		}
		
		Set<FeatureConstraint> results = new HashSet<FeatureConstraint>();
		
		for (Exclude exclude : allexcludes) {
			if(exclude.getRightOperand() == feature)
				results.add(exclude);
		}
		
		return results;
	}
	
	/**
	 * Get all exclude feature constraints that contain the feature under test in the left operand.
	 * @return
	 */
	public Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInExcludeLeftOperand() {
		if(!isFeatureSet()) return null;
		return getFeatureConstraintsAffectingFeatureInExcludeLeftOperand(getFeature());
	}
	
	/**
	 * Get all exclude feature constraints that contain the feature in the left operand.
	 * @param feature
	 * @return
	 */
	private Set<FeatureConstraint> getFeatureConstraintsAffectingFeatureInExcludeLeftOperand(Feature feature) {
		if(!isModelSet()) return null;
		FeatureModelHelper fmh = new FeatureModelHelper(getModel());
		Set<FeatureConstraint> allconstraints = fmh.getAllFeatureConstraints();
		Set<Exclude> allexcludes = new HashSet<Exclude>();
		
		for (FeatureConstraint fc : allconstraints) {
			if(fc instanceof Exclude) {
				allexcludes.add((Exclude) fc);
			}
		}
		
		Set<FeatureConstraint> results = new HashSet<FeatureConstraint>();
		
		for (Exclude exclude : allexcludes) {
			if(exclude.getLeftOperand() == feature)
				results.add(exclude);
		}
		
		return results;
	}
	
	/**
	 * Get all sub ordered features of the feature under test
	 * @return
	 */
	private Set<Feature> getSuborderedFeatures() {
		if(!isFeatureSet()) return null;
		return getSuborderedFeatures(getFeature());
	}
	
	/**
	 * Get all sub ordered features of the feature parameter
	 * @param feature
	 * @return
	 */
	private Set<Feature> getSuborderedFeatures(Feature feature) {
		Set<Group> groups = new HashSet<Group>();
		groups.addAll(feature.getGroups());
		
		Set<Feature> results = new HashSet<Feature>();
		
		for (Group group : groups) {
			Set<Feature> childfeatures = new HashSet<Feature>();
			childfeatures.addAll(group.getChildFeatures());
			
			for (Feature cf : childfeatures) {
				// add this child feature and get all sub ordered features via recursion
				results.add(cf);
				results.addAll(getSuborderedFeatures(cf));
			}
		}
		
		return results;
	}
}
