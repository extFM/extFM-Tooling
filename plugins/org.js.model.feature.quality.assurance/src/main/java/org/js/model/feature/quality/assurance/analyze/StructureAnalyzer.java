package org.js.model.feature.quality.assurance.analyze;

import java.util.Set;

import org.js.model.feature.*;
import org.js.model.feature.edit.FeatureModelHelper;

public abstract class StructureAnalyzer {
	
	/**
	 * Representation of the (set of) configurations/models under test
	 */
	private Set<FeatureModel> models;
	/**
	 * Representation of the configuration/model under test
	 */
	private FeatureModel model;
	/**
	 * Representation of the feature under test
	 */
	private Feature feature;
	
	/**
	 * Creates a full new Structure Analyzer with all input data (models, a model under test and a feature under test).
	 * <p>Please pay attention that the model must be contained in the models set and the feature must be one of
	 * the model. If not, the object cannot be created.</p>
	 * <p>Take as well into account that this method assumes that
	 * all models are of one and the same base feature model. There is no explicit test for this. If there are models
	 * that are based on a different feature model, this may cause unexpected behavior.</p>
	 * 
	 * @param models A set of (staged) configurations
	 * @param model One specific model that must be contained in the models set
	 * @param feature One specific feature that must be one of the model
	 * @throws Exception Throws if the model is not part of the models set or if the feature is not one of the model
	 */
	public StructureAnalyzer(Set<FeatureModel> models, FeatureModel model, Feature feature) throws Exception {
		setModels(models);
		if(!setModel(model))
			throw new Exception("The model could not be set.");
		if(!setFeature(feature))
			throw new Exception("The feature could not be set.");
	}
	
	/**
	 * Creates a new Structure Analyzer with models and a model as input data.
	 * <p>Please pay attention that the model must be contained in the models set. If not, the object cannot be created.</p>
	 * <p>Take as well into account that this method assumes that
	 * all models are of one and the same base feature model. There is no explicit test for this. If there are models
	 * that are based on a different feature model, this may cause unexpected behavior.</p>
	 * @param models A set of (staged) configurations
	 * @param model model One specific model that must be contained in the models set
	 * @throws Exception Throws if the model is not part of the models set
	 */
	public StructureAnalyzer(Set<FeatureModel> models, FeatureModel model) throws Exception {
		setModels(models);
		if(!setModel(model))
			throw new Exception("The model could not be set.");
	}
	
	/**
	 * Creates a new Structure Analyzer with models as input data.
	 * <p>Take into account that this method assumes that
	 * all models are of one and the same base feature model. There is no explicit test for this. If there are models
	 * that are based on a different feature model, this may cause unexpected behavior.</p>
	 * @param models A set of (staged) configurations
	 */
	public StructureAnalyzer(Set<FeatureModel> models) {
		setModels(models);
	}
	
	/**
	 * Creates a new Structure Analyzer without any input data.
	 */
	public StructureAnalyzer() {}
	
	/**
	 * Sets or resets the models set. If this invalidates the model and/or feature, they will be reseted to null
	 * @param models
	 */
	protected void setModels(Set<FeatureModel> models) {
		this.models = models;
		
		if(isModelSet() && !setModel(model)) model = null;
		if(isFeatureSet() && !setFeature(feature)) feature = null;
	}
	
	/**
	 * Returns the models set if existing (else null)
	 * @return
	 */
	protected Set<FeatureModel> getModels() {
		return this.models;
	}
	
	/**
	 * Checks if the models set is set
	 * @return <code>True</code> if the models set is not null, else <code>False</code>.
	 */
	protected boolean isModelsSet() {
		if(this.models != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Sets or resets the model. This must be part of the models set. If this invalidates the feature, this will be reseted to null
	 * @param model
	 * @return <code>True</code> if the model has been set. <code>False</code> if the model is invalid.
	 */
	protected boolean setModel(FeatureModel model) {
		if(!isModelsSet() || !models.contains(model))
			return false;
		
		this.model = model;
		
		if(isFeatureSet() && !setFeature(feature)) feature = null;
		
		return true;
	}
	
	/**
	 * Returns the model if existing (else null)
	 * @return
	 */
	protected FeatureModel getModel() {
		return this.model;
	}
	
	/**
	 * Checks if the model is set
	 * @return <code>True</code> if the model is not null, else <code>False</code>.
	 */
	protected boolean isModelSet() {
		if(this.model != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Sets or resets the feature. This must be one of the model.
	 * @param feature
	 * @return <code>True</code> if the feature has been set. <code>False</code> if the feature is invalid.
	 */
	protected boolean setFeature(Feature feature) {
		if(!isModelSet()) return false;
		FeatureModelHelper modelHelper = new FeatureModelHelper(model);
		Set<Feature> features = modelHelper.getAllFeatures();
		if(!features.contains(feature))
			return false;
		
		this.feature = feature;
		return true;
	}
	
	/**
	 * Returns the feature if existing (else null)
	 * @return
	 */
	protected Feature getFeature() {
		return this.feature;
	}
	
	/**
	 * Checks if the feature is set
	 * @return <code>True</code> if the feature is not null, else <code>False</code>.
	 */
	protected boolean isFeatureSet() {
		if(this.feature != null)
			return true;
		else
			return false;
	}
	
}
