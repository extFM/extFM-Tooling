/**
 * 
 */
package org.js.model.feature.quality.assurance.test;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.js.model.feature.*;
import org.js.model.feature.quality.assurance.analyze.ConfigurationSetStructureAnalyzer;
import org.js.model.feature.resource.eft.mopp.EftResourceFactory;

import junit.framework.TestCase;

/**
 * @author David Gollasch
 *
 */
public class ConfigurationSetStructureAnalyzerTestCase extends TestCase {

	private ResourceSet resourceSet = new ResourceSetImpl();
	
	private ConfigurationSetStructureAnalyzer sa1, sa2, sa3, sa4;
	
	/**
	 * @throws java.lang.Exception
	 */
	protected void setUp() throws Exception {
		// set 1 will be filled with model 1 to 5
		Set<FeatureModel> testset1 = new HashSet<FeatureModel>();
		// set 2 will be filled with model 1 to 6
		Set<FeatureModel> testset2 = new HashSet<FeatureModel>();
		// set 2 will be filled with model 7
		Set<FeatureModel> testset3 = new HashSet<FeatureModel>();
		// set 2 will be filled with model 8
		Set<FeatureModel> testset4 = new HashSet<FeatureModel>();
		
		FeatureModel fm1 = (FeatureModel) loadTestModel("flattest1.eft", "eft", new EftResourceFactory());
		FeatureModel fm2 = (FeatureModel) loadTestModel("flattest2.eft", "eft", new EftResourceFactory());
		FeatureModel fm3 = (FeatureModel) loadTestModel("flattest3.eft", "eft", new EftResourceFactory());
		FeatureModel fm4 = (FeatureModel) loadTestModel("flattest4.eft", "eft", new EftResourceFactory());
		FeatureModel fm5 = (FeatureModel) loadTestModel("flattest5.eft", "eft", new EftResourceFactory());
		FeatureModel fm6 = (FeatureModel) loadTestModel("flattest6.eft", "eft", new EftResourceFactory());
		FeatureModel fm7 = (FeatureModel) loadTestModel("flattest7.eft", "eft", new EftResourceFactory());
		FeatureModel fm8 = (FeatureModel) loadTestModel("flattest8.eft", "eft", new EftResourceFactory());
		
		testset1.add(fm1);
		testset1.add(fm2);
		testset1.add(fm3);
		testset1.add(fm4);
		testset1.add(fm5);
		
		testset2.add(fm1);
		testset2.add(fm2);
		testset2.add(fm3);
		testset2.add(fm4);
		testset2.add(fm5);
		testset2.add(fm6);
		
		testset3.add(fm7);
		
		testset4.add(fm8);
		
		sa1 = new ConfigurationSetStructureAnalyzer(testset1);
		sa2 = new ConfigurationSetStructureAnalyzer(testset2);
		sa3 = new ConfigurationSetStructureAnalyzer(testset3);
		sa4 = new ConfigurationSetStructureAnalyzer(testset4);
	}

	/**
	 * Test method for {@link org.js.model.feature.quality.assurance.analyze.ConfigurationSetStructureAnalyzer#getDeselectedFeatures()}.
	 */
	public void testSA1() {
		Set<Feature> result = sa1.getDeselectedFeatures();
		Set<String> resultIds = new HashSet<String>();
		resultIds.add("feature16");
		resultIds.add("feature17");
		resultIds.add("feature18");
		resultIds.add("feature19");
		resultIds.add("feature20");
		
		assertTrue(result.size() == 5);
		
		for (Feature feature : result) {
			String id = null;
			
			for (String string : resultIds) {
				if(string.equalsIgnoreCase(feature.getId()))
					id = string;
			}
			
			assertNotNull(id);
			
			if(id != null)
				resultIds.remove(id);
		}
	}
	
	/**
	 * Test method for {@link org.js.model.feature.quality.assurance.analyze.ConfigurationSetStructureAnalyzer#getDeselectedFeatures()}.
	 */
	public void testSA2() {
		Set<Feature> result = sa2.getDeselectedFeatures();
		Set<String> resultIds = new HashSet<String>();
		resultIds.add("feature17");
		resultIds.add("feature18");
		resultIds.add("feature19");
		resultIds.add("feature20");
		
		assertTrue(result.size() == 4);
		
		for (Feature feature : result) {
			String id = null;
			
			for (String string : resultIds) {
				if(string.equalsIgnoreCase(feature.getId()))
					id = string;
			}
			
			assertNotNull(id);
			
			if(id != null)
				resultIds.remove(id);
		}
	}
	
	/**
	 * Test method for {@link org.js.model.feature.quality.assurance.analyze.ConfigurationSetStructureAnalyzer#getDeselectedFeatures()}.
	 */
	public void testSA3() {
		Set<Feature> result = sa3.getDeselectedFeatures();
		Set<String> resultIds = new HashSet<String>();
		resultIds.add("feature02");
		resultIds.add("feature03");
		resultIds.add("feature04");
		resultIds.add("feature05");
		resultIds.add("feature06");
		resultIds.add("feature07");
		resultIds.add("feature08");
		resultIds.add("feature09");
		resultIds.add("feature10");
		resultIds.add("feature11");
		resultIds.add("feature12");
		resultIds.add("feature13");
		resultIds.add("feature14");
		resultIds.add("feature15");
		resultIds.add("feature16");
		resultIds.add("feature17");
		resultIds.add("feature18");
		resultIds.add("feature19");
		resultIds.add("feature20");
		
		assertTrue(result.size() == 19);
		
		for (Feature feature : result) {
			String id = null;
			
			for (String string : resultIds) {
				if(string.equalsIgnoreCase(feature.getId()))
					id = string;
			}
			
			assertNotNull(id);
			
			if(id != null)
				resultIds.remove(id);
		}
	}
	
	/**
	 * Test method for {@link org.js.model.feature.quality.assurance.analyze.ConfigurationSetStructureAnalyzer#getDeselectedFeatures()}.
	 */
	public void testSA4() {
		Set<Feature> result = sa4.getDeselectedFeatures();
		assertTrue(result.size() == 0);
	}
	
	//---------------------------------------------------------------------------
	
	private EObject loadTestModel(String filename, String suffix, Factory resourceFactory) {
	      resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(suffix, resourceFactory);
	      URL fileresource = this.getClass().getClassLoader().getResource(filename);
	      String path = fileresource.getPath();
	      path = path.replace("%20", " "); // Workaround to handle spaced in path (interpreted as %20 and reinterpreted as %2520)
	      URI uri = URI.createFileURI(path);
	      Resource resource = resourceSet.getResource(uri, true);
	      try {
	         resource.load(Collections.EMPTY_MAP);
	         System.out.println("Loaded " + uri);
	         
	         EList<EObject> contents = resource.getContents();
	         if (contents != null && !contents.isEmpty()) {
	            return contents.get(0);
	         }
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      return null;
	   }


}
