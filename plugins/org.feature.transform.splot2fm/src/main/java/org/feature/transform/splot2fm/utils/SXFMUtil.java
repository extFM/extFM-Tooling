package org.feature.transform.splot2fm.utils;

import fm.FeatureModel;
import fm.FeatureModelException;
import fm.XMLFeatureModel;

public final class SXFMUtil {

	
	public static FeatureModel initSXFMFeatureModel(String featureModelFile) throws FeatureModelException{
	FeatureModel featureModel = new XMLFeatureModel(featureModelFile,
			XMLFeatureModel.USE_VARIABLE_NAME_AS_ID);
	// Load the XML file and creates the feature model
	featureModel.loadModel();
	return featureModel;
	}
	
}
