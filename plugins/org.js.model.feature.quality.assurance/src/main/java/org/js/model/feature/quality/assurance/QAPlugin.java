package org.js.model.feature.quality.assurance;

import java.util.*;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.js.model.feature.*;
import org.js.model.feature.csp.*;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class QAPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.js.model.feature.quality.assurance"; //$NON-NLS-1$

	// The shared instance
	private static QAPlugin plugin;
	
	/**
	 * The constructor
	 */
	public QAPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static QAPlugin getDefault() {
		return plugin;
	}
	
	//****************************************************************************************
	
	/*
	 * Start the algorithm here
	 */
	private void startAlgorithm() {
		retrieveInput();
	}
	
	/* 1. Retrieve Input:
	 * - one folder full of concrete configurations of one and the same feature model
	 * - (the corresponding feature model) -> which can be extracted from the configurations
	 * - the feature under test (feature ID?)
	 * */
	
	private ArrayList<FeatureModel> configs = new ArrayList<FeatureModel>();
	private Feature testfeature;
	
	private void retrieveInput() {
		
		// take the folder and store every model into the configs list
		
		// ask for feature under test
		
		// store feature under test into testfeature
		
	}
	
	/* 2. Get through the algorithm:
	 * - identify all constantly deselected features throughout all configurations
	 * - identify all configurations containing the feature under test
	 * - grab information of the feature under test
	 * 		* get name, ID and attributes
	 * 		* is that feature mandatory? (contained in a group which min-cardinality
	 * 		  equals the number of child-features)
	 * 		* are there any cross-tree-constraints referring this feature?
	 * 		* are there any implicating cross-tree-constraints which referencing
	 * 		  a child-feature of this feature in its consequence part? 
	 */
	
	/* 3. Push all the information to the console
	 */
	
	private void getThroughAlgo() {
		if(configs.isEmpty()) {
			// no configurations set
			// TODO: throw exception
			return;
		}
		
		if(testfeature == null) {
			// no feature set
			// TODO: throw exception
			return;
		}
		
		/*
		 * 1. identify all constantly deselected features throughout all configurations
		 */
		
		Set<Feature> featureset = new HashSet<Feature>();
		FeatureModel model = configs.get(0);
		
		// get all features from model into featureset (use FeatureModelHelper) 
		
		for (FeatureModel c : configs) {
			// get all selected and unbound features from c
			
			// subtract all these features from featureset
		}
		
		// output: featureset -> all deselected features
		
		/*
		 * 2. identify all configurations containing the feature under test
		 */
		
		/*
		 * 3. grab information of the feature under test
		 */
	}

}
