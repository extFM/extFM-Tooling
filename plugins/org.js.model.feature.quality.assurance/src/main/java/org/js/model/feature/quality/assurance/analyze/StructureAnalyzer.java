package org.js.model.feature.quality.assurance.analyze;

import java.util.Set;

import org.js.model.feature.*;
import org.js.model.feature.csp.FeatureModelHelper;

public abstract class StructureAnalyzer {
	
	private Set<FeatureModel> models;
	private FeatureModel model;
	private Feature feature;
	
	public StructureAnalyzer(Set<FeatureModel> models, FeatureModel model, Feature feature) throws Exception {
		setModels(models);
		if(!setModel(model))
			throw new Exception("The model could not be set.");
		if(!setFeature(feature))
			throw new Exception("The feature could not be set.");
	}
	
	public StructureAnalyzer(Set<FeatureModel> models, FeatureModel model) throws Exception {
		setModels(models);
		if(!setModel(model))
			throw new Exception("The model could not be set.");
	}
	
	public StructureAnalyzer(Set<FeatureModel> models) {
		setModels(models);
	}
	
	public StructureAnalyzer() {}
	
	protected void setModels(Set<FeatureModel> models) {
		this.models = models;
	}
	
	protected Set<FeatureModel> getModels() {
		return this.models;
	}
	
	protected boolean isModelsSet() {
		if(this.models != null)
			return true;
		else
			return false;
	}
	
	protected boolean setModel(FeatureModel model) {
		if(!models.contains(model))
			return false;
		
		this.model = model;
		return true;
	}
	
	protected FeatureModel getModel() {
		return this.model;
	}
	
	protected boolean isModelSet() {
		if(this.model != null)
			return true;
		else
			return false;
	}
	
	protected boolean setFeature(Feature feature) {
		FeatureModelHelper modelHelper = new FeatureModelHelper(model);
		Set<Feature> features = modelHelper.getAllFeatures();
		if(!features.contains(feature))
			return false;
		
		this.feature = feature;
		return true;
	}
	
	protected Feature getFeature() {
		return this.feature;
	}
	
	protected boolean isFeatureSet() {
		if(this.feature != null)
			return true;
		else
			return false;
	}
}
