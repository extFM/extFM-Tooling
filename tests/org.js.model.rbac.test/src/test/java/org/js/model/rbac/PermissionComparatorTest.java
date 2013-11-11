package org.js.model.rbac;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.junit.Test;

/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class PermissionComparatorTest extends AbstractTestRbac {

   @Test
   public void compareSetAttributesOfDiffFeatures() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");
      Attribute f5a1 = getAttribute(f5, "a1");

      Feature f6 = getFeature("f6");
      Attribute f6a1 = getAttribute(f6, "a1");
      AttributeOperation as1 = createSetAttribute(f5, f5a1);
      AttributeOperation as2 = createSetAttribute(f6, f6a1);

      int equal = permissionComparator.compare(as1, as2);
      assertEquals(-1, equal);
   }

   @Test
   public void compareSetAttributesOfDiffFeaturesOneEnabled() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");
      Attribute f5a1 = getAttribute(f5, "a1");

      Feature f6 = getFeature("f6");
      Attribute f6a1 = getAttribute(f6, "a1");
      AttributeOperation as1 = createSetAttribute(f5, f5a1);
      AttributeOperation as2 = createSetAttribute(f6, f6a1);

      int equal = permissionComparator.compare(as1, as2);
      assertEquals(-1, equal);
   }

   @Test
   public void compareSetAttributesOfSameFeatures() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");
      Attribute f5a1 = getAttribute(f5, "a1");

      Feature f51 = getFeature("f5");
      Attribute f51a1 = getAttribute(f51, "a1");
      AttributeOperation as1 = createSetAttribute(f5, f5a1);
      AttributeOperation as2 = createSetAttribute(f51, f51a1);

      int equal = permissionComparator.compare(as1, as2);
      assertEquals(0, equal);
   }

   @Test
   public void compareEqualSelectFeature() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");

      FeatureOperation selectF51 = createSelectFeature(f5);
      FeatureOperation selectF52 = createSelectFeature(f5);

      int equal = permissionComparator.compare(selectF51, selectF52);
      assertEquals(0, equal);
   }

   @Test
   public void compareUnequalSelectFeature() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");
      Feature f6 = getFeature("f6");

      FeatureOperation selectF5 = createSelectFeature(f5);
      FeatureOperation selectF6 = createSelectFeature(f6);

      int equal = permissionComparator.compare(selectF5, selectF6);
      assertEquals(-1, equal);
   }

   @Test
   public void compareSelectDeselectFeature() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");
      Feature f51 = getFeature("f5");

      FeatureOperation selectF5 = createSelectFeature(f5);
      FeatureOperation selectF51 = createDeselectFeature(f51);

      int equal = permissionComparator.compare(selectF5, selectF51);
      assertEquals(-1, equal);
   }

}
