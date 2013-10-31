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
import org.js.model.feature.edit.FeatureModelHelper;
import org.js.model.feature.quality.assurance.analyze.FeatureBasedStructureAnalyzer;
import org.js.model.feature.resource.eft.mopp.EftResourceFactory;

import junit.framework.TestCase;

/**
 * @author David
 *
 */
public class FeatureBasedStructureAnalyzerTestCase extends TestCase {

	private ResourceSet resourceSet = new ResourceSetImpl();
	
	private FeatureBasedStructureAnalyzer sa5, sa6, sa7, sa8;
	private FeatureBasedStructureAnalyzer sa9, sa10, sa11, sa12;
	
	private FeatureBasedStructureAnalyzer sa13, sa14, sa15, sa16;
	private FeatureBasedStructureAnalyzer sa17, sa18, sa19, sa20;
	private FeatureBasedStructureAnalyzer sa21, sa22, sa23, sa24;
	private FeatureBasedStructureAnalyzer sa25, sa26, sa27, sa28;
	private FeatureBasedStructureAnalyzer sa29, sa30;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		FeatureModel fm1 = (FeatureModel) loadTestModel("flattest1.eft", "eft", new EftResourceFactory());
		FeatureModel fm2 = (FeatureModel) loadTestModel("flattest2.eft", "eft", new EftResourceFactory());
		FeatureModel fm3 = (FeatureModel) loadTestModel("flattest3.eft", "eft", new EftResourceFactory());
		FeatureModel fm4 = (FeatureModel) loadTestModel("flattest4.eft", "eft", new EftResourceFactory());
		FeatureModel fm5 = (FeatureModel) loadTestModel("flattest5.eft", "eft", new EftResourceFactory());
		FeatureModel fm6 = (FeatureModel) loadTestModel("flattest6.eft", "eft", new EftResourceFactory());
		FeatureModel fm7 = (FeatureModel) loadTestModel("flattest7.eft", "eft", new EftResourceFactory());
		FeatureModel fm8 = (FeatureModel) loadTestModel("flattest8.eft", "eft", new EftResourceFactory());
		
		FeatureModel fm9 = (FeatureModel) loadTestModel("dependenciestest.eft", "eft", new EftResourceFactory());
		
		Set<FeatureModel> testset1to5 = new HashSet<FeatureModel>();
		testset1to5.add(fm1);
		testset1to5.add(fm2);
		testset1to5.add(fm3);
		testset1to5.add(fm4);
		testset1to5.add(fm5);
		Set<FeatureModel> testset1to6 = new HashSet<FeatureModel>();
		testset1to6.add(fm1);
		testset1to6.add(fm2);
		testset1to6.add(fm3);
		testset1to6.add(fm4);
		testset1to6.add(fm5);
		testset1to6.add(fm6);
		Set<FeatureModel> testset1to8 = new HashSet<FeatureModel>();
		testset1to8.add(fm1);
		testset1to8.add(fm2);
		testset1to8.add(fm3);
		testset1to8.add(fm4);
		testset1to8.add(fm5);
		testset1to8.add(fm6);
		testset1to8.add(fm7);
		testset1to8.add(fm8);
		Set<FeatureModel> testsetFeaDep = new HashSet<FeatureModel>();
		testsetFeaDep.add(fm9);
		
		FeatureModelHelper fmh1 = new FeatureModelHelper(fm1);
		FeatureModelHelper fmh9 = new FeatureModelHelper(fm9);
		
		Feature f01 = fmh1.getFeature("feature01");
		Feature f06 = fmh1.getFeature("feature06");
		Feature f11 = fmh1.getFeature("feature11");
		Feature f16 = fmh1.getFeature("feature16");
		Feature f20 = fmh1.getFeature("feature20");
		
		Feature g1f1 = fmh9.getFeature("g1f1");
		Feature g1f2 = fmh9.getFeature("g1f2");
		Feature g1f3 = fmh9.getFeature("g1f3");
		Feature g1f4 = fmh9.getFeature("g1f4");
		Feature g1f5 = fmh9.getFeature("g1f5");
		Feature g1f6 = fmh9.getFeature("g1f6");
		Feature g1f7 = fmh9.getFeature("g1f7");
		Feature g1f8 = fmh9.getFeature("g1f8");
		
		Feature g2f1 = fmh9.getFeature("g2f1");
		Feature g2f2 = fmh9.getFeature("g2f2");
		
		Feature g3f1 = fmh9.getFeature("g3f1");
		Feature g3f2 = fmh9.getFeature("g3f2");
		
		Feature g4f1 = fmh9.getFeature("g4f1");
		Feature g4f2 = fmh9.getFeature("g4f2");
		Feature g4f3 = fmh9.getFeature("g4f3");
		
		Feature g5f1 = fmh9.getFeature("g5f1");
		Feature g5f2 = fmh9.getFeature("g5f2");
		Feature g5f3 = fmh9.getFeature("g5f3");
		
		sa5 = new FeatureBasedStructureAnalyzer(testset1to5, fm1, f01);
		sa6 = new FeatureBasedStructureAnalyzer(testset1to5, fm1, f06);
		sa7 = new FeatureBasedStructureAnalyzer(testset1to5, fm1, f11);
		sa8 = new FeatureBasedStructureAnalyzer(testset1to5, fm1, f16);
		sa9 = new FeatureBasedStructureAnalyzer(testset1to8, fm1, f01);
		sa10 = new FeatureBasedStructureAnalyzer(testset1to6, fm1, f16);
		sa11 = new FeatureBasedStructureAnalyzer(testset1to8, fm1, f16);
		sa12 = new FeatureBasedStructureAnalyzer(testset1to8, fm1, f20);
		
		sa13 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g1f1);
		sa14 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g1f2);
		sa15 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g1f3);
		sa16 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g1f4);
		sa17 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g1f5);
		sa18 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g1f6);
		sa19 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g1f7);
		sa20 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g1f8);
		
		sa21 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g2f1);
		sa22 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g2f2);
		
		sa23 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g3f1);
		sa24 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g3f2);
		
		sa25 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g4f1);
		sa26 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g4f2);
		sa27 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g4f3);
		
		sa28 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g5f1);
		sa29 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g5f2);
		sa30 = new FeatureBasedStructureAnalyzer(testsetFeaDep, fm9, g5f3);
	}

	public void testSA5() {
		Set<FeatureModel> results = sa5.getFeatureModelsContainingFeature();
		assertTrue(results.size() == 5);
	}
	
	public void testSA6() {
		Set<FeatureModel> results = sa6.getFeatureModelsContainingFeature();
		assertTrue(results.size() == 1);
	}
	
	public void testSA7() {
		Set<FeatureModel> results = sa7.getFeatureModelsContainingFeature();
		assertTrue(results.size() == 2);
	}
	
	public void testSA8() {
		Set<FeatureModel> results = sa8.getFeatureModelsContainingFeature();
		assertTrue(results.size() == 0);
	}
	
	public void testSA9() {
		Set<FeatureModel> results = sa9.getFeatureModelsContainingFeature();
		assertTrue(results.size() == 7);
	}
	
	public void testSA10() {
		Set<FeatureModel> results = sa10.getFeatureModelsContainingFeature();
		assertTrue(results.size() == 1);
	}
	
	public void testSA11() {
		Set<FeatureModel> results = sa11.getFeatureModelsContainingFeature();
		assertTrue(results.size() == 2);
	}
	
	public void testSA12() {
		Set<FeatureModel> results = sa12.getFeatureModelsContainingFeature();
		assertTrue(results.size() == 1);
	}
	
	public void testSA13() throws Exception {
		Set<FeatureConstraint> results = sa13.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa13.isFeatureMandatory();
		
		assertTrue(results.size() == 0);
		assertFalse(isMandatory);
	}
	
	public void testSA14() throws Exception {
		Set<FeatureConstraint> results = sa14.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa14.isFeatureMandatory();
		
		assertTrue(results.size() == 0);
		assertFalse(isMandatory);
	}
	
	public void testSA15() throws Exception {
		Set<FeatureConstraint> results = sa15.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa15.isFeatureMandatory();
		
		assertTrue(results.size() == 0);
		assertFalse(isMandatory);
	}
	
	public void testSA16() throws Exception {
		Set<FeatureConstraint> results = sa16.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa16.isFeatureMandatory();
		
		assertTrue(results.size() == 0);
		assertFalse(isMandatory);
	}
	
	public void testSA17() throws Exception {
		Set<FeatureConstraint> results = sa17.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa17.isFeatureMandatory();
		
		assertTrue(results.size() == 0);
		assertFalse(isMandatory);
	}
	
	public void testSA18() throws Exception {
		Set<FeatureConstraint> results = sa18.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa18.isFeatureMandatory();
		
		assertTrue(results.size() == 0);
		assertFalse(isMandatory);
	}
	
	public void testSA19() throws Exception {
		Set<FeatureConstraint> results = sa19.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa19.isFeatureMandatory();
		
		assertTrue(results.size() == 0);
		assertFalse(isMandatory);
	}
	
	public void testSA20() throws Exception {
		Set<FeatureConstraint> results = sa20.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa20.isFeatureMandatory();
		
		assertTrue(results.size() == 1);
		assertFalse(isMandatory);
	}
	
	public void testSA21() throws Exception {
		Set<FeatureConstraint> results = sa21.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa21.isFeatureMandatory();
		
		assertTrue(results.size() == 0);
		assertTrue(isMandatory);
	}
	
	public void testSA22() throws Exception {
		Set<FeatureConstraint> results = sa22.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa22.isFeatureMandatory();
		
		assertTrue(results.size() == 2);
		assertTrue(isMandatory);
	}
	
	public void testSA23() throws Exception {
		Set<FeatureConstraint> results = sa23.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa23.isFeatureMandatory();
		
		assertTrue(results.size() == 0);
		assertFalse(isMandatory);
	}
	
	public void testSA24() throws Exception {
		Set<FeatureConstraint> results = sa24.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa24.isFeatureMandatory();
		
		assertTrue(results.size() == 1);
		assertFalse(isMandatory);
	}
	
	public void testSA25() throws Exception {
		Set<FeatureConstraint> results = sa25.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa25.isFeatureMandatory();
		
		assertTrue(results.size() == 1);
		assertFalse(isMandatory);
	}
	
	public void testSA26() throws Exception {
		Set<FeatureConstraint> results = sa26.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa26.isFeatureMandatory();
		
		assertTrue(results.size() == 1);
		assertFalse(isMandatory);
	}
	
	public void testSA27() throws Exception {
		Set<FeatureConstraint> results = sa27.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa27.isFeatureMandatory();
		
		assertTrue(results.size() == 0);
		assertFalse(isMandatory);
	}
	
	public void testSA28() throws Exception {
		Set<FeatureConstraint> results = sa28.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa28.isFeatureMandatory();
		
		assertTrue(results.size() == 1);
		assertFalse(isMandatory);
	}
	
	public void testSA29() throws Exception {
		Set<FeatureConstraint> results = sa29.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa29.isFeatureMandatory();
		
		assertTrue(results.size() == 1);
		assertFalse(isMandatory);
	}
	
	public void testSA30() throws Exception {
		Set<FeatureConstraint> results = sa30.getFeatureConstraintsAffectingFeature();
		boolean isMandatory = sa30.isFeatureMandatory();
		
		assertTrue(results.size() == 0);
		assertFalse(isMandatory);
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
