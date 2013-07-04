package org.js.model.rbac;
import org.js.model.rbac.RBACResolverUtil;
import org.junit.Assert;
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
public class RbacResolverUtilTest {

   @Test
   public void getObjectIdentifierTest() {
      String p1 = "select f1";
      String e1 = "f1";
      String k1 = RBACResolverUtil.getKeyword(p1);
      String id1 = RBACResolverUtil.getObjectIdentifier(k1, p1);

      String p2 = "deselect f1";
      String k2 = RBACResolverUtil.getKeyword(p2);
      String id2 = RBACResolverUtil.getObjectIdentifier(k2, p2);

      String p3 = "set longername1";
      String e3 = "longername1";
      String k3 = RBACResolverUtil.getKeyword(p3);
      String id3 = RBACResolverUtil.getObjectIdentifier(k3, p3);

      Assert.assertEquals(e1, id1);
      Assert.assertEquals(e1, id2);
      Assert.assertEquals(e3, id3);

      String p4 = "not korrekt identifier";
      String e4 = null;
      String k4 = RBACResolverUtil.getKeyword(p4);
      String id4 = RBACResolverUtil.getObjectIdentifier(k4, p4);
      Assert.assertEquals(e4, id4);

      String p5 = "select     ";
      String k5 = RBACResolverUtil.getKeyword(p5);
      String id5 = RBACResolverUtil.getObjectIdentifier(k5, p5);
      Assert.assertEquals(e4, id5);

      String p6 = "         select     ";
      String k6 = RBACResolverUtil.getKeyword(p6);
      String id6 = RBACResolverUtil.getObjectIdentifier(k6, p6);
      Assert.assertEquals(e4, id6);

      String p7 = "         select     ";
      String k7 = RBACResolverUtil.getKeyword(p7);
      String id7 = RBACResolverUtil.getObjectIdentifier(k7, p7);
      Assert.assertEquals(e4, id7);

      String p8 = "";
      String k8 = RBACResolverUtil.getKeyword(p8);
      String id8 = RBACResolverUtil.getObjectIdentifier(k8, p8);
      Assert.assertEquals(e4, id8);

      String p9 = null;
      String k9 = RBACResolverUtil.getKeyword(p9);
      String id9 = RBACResolverUtil.getObjectIdentifier(k9, p9);
      Assert.assertEquals(e4, id9);

      String p10 = "set f4.a34 ";
      String e10 = "f4.a34";
      String k10 = RBACResolverUtil.getKeyword(p10);
      String id10 = RBACResolverUtil.getObjectIdentifier(k10, p10);
      Assert.assertEquals(e10, id10);
   }

   @Test
   public void isAttributeReferenceTest() {
      String objectId1 = "as1.sw";
      boolean isAttributeRef1 = RBACResolverUtil.isAttributeReference(objectId1);
      Assert.assertTrue(isAttributeRef1);

      String objectId2 = "as1.sw.sw";
      boolean isAttributeRef2 = RBACResolverUtil.isAttributeReference(objectId2);
      Assert.assertFalse(isAttributeRef2);
   }

   @Test
   public void isSelectFeatureTest() {
      String keyword = "select";
      String objectId = "select f";
      boolean isSelect = RBACResolverUtil.isSelectFeature(keyword, objectId);
      Assert.assertTrue(isSelect);

      String keyword1 = "deselect";
      String objectId1 = "deselect f";
      boolean isSelect1 = RBACResolverUtil.isSelectFeature(keyword1, objectId1);
      Assert.assertFalse(isSelect1);

      String keyword2 = "set";
      String objectId2 = "set f2.3";
      boolean isSelect2 = RBACResolverUtil.isSelectFeature(keyword2, objectId2);
      Assert.assertFalse(isSelect2);
   }

   @Test
   public void isDeselectFeatureTest() {
      String keyword = "select";
      String objectId = "select f";
      boolean isSelect = RBACResolverUtil.isDeselectFeature(keyword, objectId);
      Assert.assertFalse(isSelect);

      String keyword1 = "deselect";
      String objectId1 = "deselect f";
      boolean isSelect1 = RBACResolverUtil.isDeselectFeature(keyword1, objectId1);
      Assert.assertTrue(isSelect1);

      String keyword2 = "set";
      String objectId2 = "set f2.3";
      boolean isSelect2 = RBACResolverUtil.isDeselectFeature(keyword2, objectId2);
      Assert.assertFalse(isSelect2);
   }

   @Test
   public void isSetAttributeTest() {
      String keyword = "select";
      String objectId = "select f";
      boolean isSelect = RBACResolverUtil.isSetAttribute(keyword, objectId);
      Assert.assertFalse(isSelect);

      String keyword1 = "deselect";
      String objectId1 = "deselect f";
      boolean isSelect1 = RBACResolverUtil.isSetAttribute(keyword1, objectId1);
      Assert.assertFalse(isSelect1);

      String keyword2 = "set";
      String objectId2 = "set f2.3";
      boolean isSelect2 = RBACResolverUtil.isSetAttribute(keyword2, objectId2);
      Assert.assertTrue(isSelect2);
   }

   @Test
   public void splitObjectIdTest() {
      String objectId = "as.1";
      String[] split = RBACResolverUtil.splitObjectId(RBACResolverUtil.delimiter, objectId);
      Assert.assertEquals("as", split[0]);
      Assert.assertEquals("1", split[1]);
   }
}
