/**
 * 
 */
package sedaj.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.Group;
import org.js.model.feature.SelectedState;
import org.junit.Test;

import sedaj.Main;

/**
 * Tests for creating simple {@link FeatureModel}
 * @author Tim Winkelmann
 *
 */
public class MainTest {

//	/**
//	 * Test method for {@link sedaj.Main#createSimpleFM(java.lang.String)}.
//	 */
//	@Test
//	public void testCreateSimpleFM() {
//		FeatureModel fm = Main.createSimpleFM("TestName");
//		assertTrue(fm.getChildren().size() == 0); // no child FM
//		assertTrue(fm.getParent() == null); // no parent
//		assertTrue(fm.getName().equals("TestName"));
//		assertTrue(fm.getParent() == null); //has no parent
//		assertTrue(fm.getRoot() != null); //has a root feature
//		Feature root = fm.getRoot();
//		assertTrue(root.getName().equals("root"));//root Feature has the name root
//		assertTrue(root.getGroups().isEmpty());//has no groups
//		assertTrue(root.getAttributes().size() == 0);//has one attribute
//		assertTrue(root.getSelected().equals(SelectedState.SELECTED));
//	}
//
//	/**
//	 * Test method for {@link sedaj.Main#createFMwithMandatory(java.lang.String)}.
//	 */
//	@Test
//	public void testCreateFMwithMandatory() {
//		FeatureModel fm = Main.createFMwithMandatory("test");
//		assertTrue(fm.getRoot() != null);
//		Feature root = fm.getRoot();
//		assertFalse(root.getGroups().isEmpty());
//		assertTrue(root.getGroups().size() == 1);
//		Group group = root.getGroups().get(0);
//		assertFalse(group.getChildFeatures().isEmpty());
//		assertTrue(group.getMinCardinality() == 1);
//		assertTrue(group.getMaxCardinality() == 1);
//		assertTrue(group.getParentFeature().equals(root));
//		assertTrue(group.getChildFeatures().size() == 1);
//		Feature feature = group.getChildFeatures().get(0);
//		assertTrue(feature.getName().equals("f1"));
//		assertTrue(feature.getParentGroup().equals(group));
//	}
//
//	/**
//	 * Test method for {@link sedaj.Main#createFMwithOptional(java.lang.String)}.
//	 */
//	@Test
//	public void testCreateFMwithOptional() {
//		FeatureModel fm = Main.createFMwithOptional("test");
//		assertTrue(fm.getRoot() != null);
//		Feature root = fm.getRoot();
//		assertFalse(root.getGroups().isEmpty());
//		assertTrue(root.getGroups().size() == 1);
//		Group group = root.getGroups().get(0);
//		assertFalse(group.getChildFeatures().isEmpty());
//		assertEquals(0, group.getMinCardinality());
//		assertEquals(1, group.getMaxCardinality());
//		assertTrue(group.getParentFeature().equals(root));
//		assertTrue(group.getChildFeatures().size() == 1);
//		Feature feature = group.getChildFeatures().get(0);
//		assertTrue(feature.getName().equals("f1"));
//		assertTrue(feature.getParentGroup().equals(group));
//	}
//
//	/**
//	 * Test method for {@link sedaj.Main#createFMwithAlternative(java.lang.String)}.
//	 */
//	@Test
//	public void testCreateFMwithAlternative() {
//		FeatureModel fm = Main.createFMwithAlternative("test");
//		assertTrue(fm.getRoot() != null);
//		Feature root = fm.getRoot();
//		assertFalse(root.getGroups().isEmpty());
//		assertTrue(root.getGroups().size() == 1);
//		Group group = root.getGroups().get(0);
//		assertFalse(group.getChildFeatures().isEmpty());
//		assertTrue(group.getMinCardinality() == 1);
//		assertTrue(group.getMaxCardinality() == 1);
//		assertTrue(group.getParentFeature().equals(root));
//		assertTrue(group.getChildFeatures().size() == 2);
//		Feature feature = group.getChildFeatures().get(0);
//		assertTrue(feature.getName().equals("f1"));
//		assertTrue(feature.getParentGroup().equals(group));
//		feature = group.getChildFeatures().get(1);
//		assertTrue(feature.getName().equals("f2"));
//		assertTrue(feature.getParentGroup().equals(group));
//	}
//
//	/**
//	 * Test method for {@link sedaj.Main#createFMwithInclusiveOr(java.lang.String)}.
//	 */
//	@Test
//	public void testCreateFMwithInclusiveOr() {
//		FeatureModel fm = Main.createFMwithInclusiveOr("test");
//		assertTrue(fm.getRoot() != null);
//		Feature root = fm.getRoot();
//		assertFalse(root.getGroups().isEmpty());
//		assertTrue(root.getGroups().size() == 1);
//		Group group = root.getGroups().get(0);
//		assertFalse(group.getChildFeatures().isEmpty());
//		assertTrue(group.getMinCardinality() == 1);
//		assertTrue(group.getMaxCardinality() == 2);
//		assertTrue(group.getParentFeature().equals(root));
//		assertTrue(group.getChildFeatures().size() == 2);
//		Feature feature = group.getChildFeatures().get(0);
//		assertTrue(feature.getName().equals("f1"));
//		assertTrue(feature.getParentGroup().equals(group));
//		feature = group.getChildFeatures().get(1);
//		assertTrue(feature.getName().equals("f2"));
//		assertTrue(feature.getParentGroup().equals(group));
//	}
//
//	/**
//	 * Test method for {@link sedaj.Main#createFMwithExclusiveOptional(java.lang.String)}.
//	 */
//	@Test
//	public void testCreateFMwithExclusiveOr() {
//		FeatureModel fm = Main.createFMwithExclusiveOptional("test");
//		assertTrue(fm.getRoot() != null);
//		Feature root = fm.getRoot();
//		assertFalse(root.getGroups().isEmpty());
//		assertTrue(root.getGroups().size() == 1);
//		Group group = root.getGroups().get(0);
//		assertFalse(group.getChildFeatures().isEmpty());
//		assertTrue(group.getMinCardinality() == 0);
//		assertTrue(group.getMaxCardinality() == 1);
//		assertTrue(group.getParentFeature().equals(root));
//		assertTrue(group.getChildFeatures().size() == 2);
//		Feature feature = group.getChildFeatures().get(0);
//		assertTrue(feature.getName().equals("f1"));
//		assertTrue(feature.getParentGroup().equals(group));
//		feature = group.getChildFeatures().get(1);
//		assertTrue(feature.getName().equals("f2"));
//		assertTrue(feature.getParentGroup().equals(group));
//	}

}
