import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.rbac.DeselectDomainValue;
import org.js.model.rbac.DeselectFeature;
import org.js.model.rbac.Permission;
import org.js.model.rbac.PermissionComparator;
import org.js.model.rbac.SelectDomainValue;
import org.js.model.rbac.SelectFeature;
import org.js.model.rbac.SetAttribute;
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
public class PermissionComparatorTest extends AbstractRBACTest {

   @Test
   public void compareDiffDomainValuesofSameSetAttibuteBothEnabled() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature feature = getFeature("f5");
      Attribute attribute = getAttribute(feature, "a1");
      DeselectDomainValue dsdv1 = createDeselectDomainValue("v1");
      DeselectDomainValue dsdv2 = createDeselectDomainValue("v2");

      SetAttribute as1 = createSetAttribute(feature, attribute);
      as1.getDomainValueOperations().add(dsdv1);
      as1.getDomainValueOperations().add(dsdv2);

      int equal = permissionComparator.compare(dsdv1, dsdv2);
      assertEquals(-1, equal);
   }

   @Test
   public void compareSelelectDeselectDomainValuesofSameSetAttibuteBothEnabled() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature feature = getFeature("f5");
      Attribute attribute = getAttribute(feature, "a1");
      DeselectDomainValue dsdv1 = createDeselectDomainValue("v1");
      SelectDomainValue dsdv2 = createSelectDomainValue("v1");

      SetAttribute as1 = createSetAttribute(feature, attribute);
      as1.getDomainValueOperations().add(dsdv1);
      as1.getDomainValueOperations().add(dsdv2);

      int equal = permissionComparator.compare(dsdv1, dsdv2);
      assertEquals(-1, equal);
   }

   @Test
   public void compareSameDomainValuesofSameSetAttibuteBothEnabled() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature feature = getFeature("f5");
      Attribute attribute = getAttribute(feature, "a1");
      DeselectDomainValue dsdv1 = createDeselectDomainValue("v1");
      DeselectDomainValue dsdv2 = createDeselectDomainValue("v1");

      SetAttribute as1 = createSetAttribute(feature, attribute);
      as1.getDomainValueOperations().add(dsdv1);
      as1.getDomainValueOperations().add(dsdv2);

      int equal = permissionComparator.compare(dsdv1, dsdv2);
      assertEquals(0, equal);
   }

   @Test
   public void compareDiffDomainValuesofDifferentSetAttibutesBothEnabled() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature feature = getFeature("f5");
      Attribute attribute = getAttribute(feature, "a1");
      DeselectDomainValue dsdv1 = createDeselectDomainValue("v1");
      DeselectDomainValue dsdv2 = createDeselectDomainValue("v2");

      SetAttribute as1 = createSetAttribute(feature, attribute);
      as1.getDomainValueOperations().add(dsdv1);

      SetAttribute as2 = createSetAttribute(feature, attribute);
      as2.getDomainValueOperations().add(dsdv2);

      int equal = permissionComparator.compare(dsdv1, dsdv2);
      assertEquals(-1, equal);
   }

   @Test
   public void compareSameDomainValuesofDifferentSetAttibutesBothEnabled() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature feature = getFeature("f5");
      Attribute attribute = getAttribute(feature, "a1");
      DeselectDomainValue dsdv1 = createDeselectDomainValue("v1");
      DeselectDomainValue dsdv2 = createDeselectDomainValue("v1");

      SetAttribute as1 = createSetAttribute(feature, attribute);
      as1.getDomainValueOperations().add(dsdv1);

      SetAttribute as2 = createSetAttribute(feature, attribute);
      as2.getDomainValueOperations().add(dsdv2);

      int equal = permissionComparator.compare(dsdv1, dsdv2);
      assertEquals(0, equal);
   }

   @Test
   public void compareSameDomainValuesofDifferentFeaturesBothEnabled() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");
      Attribute f5a1 = getAttribute(f5, "a1");

      Feature f6 = getFeature("f6");
      Attribute f6a1 = getAttribute(f6, "a1");

      DeselectDomainValue dsdv1 = createDeselectDomainValue("v1");
      DeselectDomainValue dsdv2 = createDeselectDomainValue("v1");

      SetAttribute as1 = createSetAttribute(f5, f5a1);
      as1.getDomainValueOperations().add(dsdv1);

      SetAttribute as2 = createSetAttribute(f6, f6a1);
      as2.getDomainValueOperations().add(dsdv2);

      int equal = permissionComparator.compare(dsdv1, dsdv2);
      assertEquals(-1, equal);
   }

   @Test
   public void compareDiffDomainValuesofSameSetAttibuteOneEnabled() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature feature = getFeature("f5");
      Attribute attribute = getAttribute(feature, "a1");
      DeselectDomainValue dsdv1 = createDeselectDomainValue("v1");
      DeselectDomainValue dsdv2 = createDeselectDomainValue("v2");

      SetAttribute as1 = createSetAttribute(feature, attribute);
      as1.getDomainValueOperations().add(dsdv1);
      as1.getDomainValueOperations().add(dsdv2);

      int equal = permissionComparator.compare(dsdv1, dsdv2);
      assertEquals(-1, equal);
   }

   @Test
   public void compareSameDomainValuesofSameSetAttibuteOneEnabled() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature feature = getFeature("f5");
      Attribute attribute = getAttribute(feature, "a1");
      DeselectDomainValue dsdv1 = createDeselectDomainValue("v1");
      DeselectDomainValue dsdv2 = createDeselectDomainValue("v1");

      SetAttribute as1 = createSetAttribute(feature, attribute);
      as1.getDomainValueOperations().add(dsdv1);
      as1.getDomainValueOperations().add(dsdv2);

      int equal = permissionComparator.compare(dsdv1, dsdv2);
      assertEquals(0, equal);
   }

   @Test
   public void compareDiffDomainValuesofDifferentSetAttibutesOneEnabled() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature feature = getFeature("f5");
      Attribute attribute = getAttribute(feature, "a1");
      DeselectDomainValue dsdv1 = createDeselectDomainValue("v1");
      DeselectDomainValue dsdv2 = createDeselectDomainValue("v2");

      SetAttribute as1 = createSetAttribute(feature, attribute);
      as1.getDomainValueOperations().add(dsdv1);

      SetAttribute as2 = createSetAttribute(feature, attribute);
      as2.getDomainValueOperations().add(dsdv2);

      int equal = permissionComparator.compare(dsdv1, dsdv2);
      assertEquals(-1, equal);
   }

  
   @Test
   public void compareSameDomainValuesofDifferentFeaturesOneEnabled() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");
      Attribute f5a1 = getAttribute(f5, "a1");

      Feature f6 = getFeature("f6");
      Attribute f6a1 = getAttribute(f6, "a1");

      DeselectDomainValue dsdv1 = createDeselectDomainValue("v1");
      DeselectDomainValue dsdv2 = createDeselectDomainValue("v1");

      SetAttribute as1 = createSetAttribute(f5, f5a1);
      as1.getDomainValueOperations().add(dsdv1);

      SetAttribute as2 = createSetAttribute(f6, f6a1);
      as2.getDomainValueOperations().add(dsdv2);

      int equal = permissionComparator.compare(dsdv1, dsdv2);
      assertEquals(-1, equal);
   }

   @Test
   public void compareSetAttributesOfDiffFeatures() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");
      Attribute f5a1 = getAttribute(f5, "a1");

      Feature f6 = getFeature("f6");
      Attribute f6a1 = getAttribute(f6, "a1");
      SetAttribute as1 = createSetAttribute(f5, f5a1);
      SetAttribute as2 = createSetAttribute(f6, f6a1);

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
      SetAttribute as1 = createSetAttribute(f5, f5a1);
      SetAttribute as2 = createSetAttribute(f6, f6a1);

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
      SetAttribute as1 = createSetAttribute(f5, f5a1);
      SetAttribute as2 = createSetAttribute(f51, f51a1);

      int equal = permissionComparator.compare(as1, as2);
      assertEquals(0, equal);
   }

   
   @Test
   public void compareEqualSelectFeature() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");

      SelectFeature selectF51 = createSelectFeature(f5);
      SelectFeature selectF52 = createSelectFeature(f5);

      int equal = permissionComparator.compare(selectF51, selectF52);
      assertEquals(0, equal);
   }

  
   @Test
   public void compareUnequalSelectFeature() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");
      Feature f6 = getFeature("f6");

      SelectFeature selectF5 = createSelectFeature(f5);
      SelectFeature selectF6 = createSelectFeature(f6);

      int equal = permissionComparator.compare(selectF5, selectF6);
      assertEquals(-1, equal);
   }

   @Test
   public void compareSelectDeselectFeature() {
      Comparator<Permission> permissionComparator = new PermissionComparator();
      Feature f5 = getFeature("f5");
      Feature f51 = getFeature("f5");

      SelectFeature selectF5 = createSelectFeature(f5);
      DeselectFeature selectF51 = createDeselectFeature(f51);

      int equal = permissionComparator.compare(selectF5, selectF51);
      assertEquals(-1, equal);
   }

}
