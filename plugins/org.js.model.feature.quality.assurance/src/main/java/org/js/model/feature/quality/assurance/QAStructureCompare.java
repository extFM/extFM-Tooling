package org.js.model.feature.quality.assurance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.csp.FeatureModelHelper;

import org.apache.log4j.*;

public class QAStructureCompare {
	private static Logger log = Logger.getLogger(QAStructureCompare.class);
		/*
		 * Start the algorithm here
		 */
		private void startAlgorithm() {
			log.debug("los gehts");
			log.info("Hey, ich bin ne Info!");
			
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
			
			/*
			 * commonly used pattern:
			 *	if (selection instanceof IStructuredSelection) {
			   		IStructuredSelection ssel = (IStructuredSelection) selection;
			        Object obj = ssel.getFirstElement();
			        IFile file = (IFile) Platform.getAdapterManager().getAdapter(obj,
			                IFile.class);
			        if (file == null) {
			            if (obj instanceof IAdaptable) {
			                file = (IFile) ((IAdaptable) obj).getAdapter(IFile.class);
			            }
			        }
			        if (file != null) {
			            // do something
			        }
			  	}
			 */
			
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
		
		private void walkThroughAlgo() {
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
			
			FeatureModelHelper helper = new FeatureModelHelper(model);
			featureset = helper.getAllFeatures();
			
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
