package org.js.model.workflow.test.rewrite;

import org.eclipse.emf.common.util.EList;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.Role;
import org.js.model.rbac.impl.RbacFactoryImpl;
import org.js.model.workflow.util.AccessControlModelUtil;
import org.junit.Assert;
import org.junit.Test;

public class AccessControlModelRemoveGroupTest {

   AccessControlModel accessControlModel;
   Role r1, r2, r3, r4, r5;
   Group g1, g2, g3, g6;

   /**
    * the dummy model represents a subset of an access control model containing roles and groups of roles.
    * 
    * R2(G2) / R1(G1) \ R3(G3)-R4
    * 
    * G6 group without owner and members R6 role without relation to a group
    * 
    */
   private void createDummyModel() {
      accessControlModel = RbacFactoryImpl.eINSTANCE.createAccessControlModel();

      r1 = createRole("R1");
      r2 = createRole("R2");
      r3 = createRole("R3");
      r4 = createRole("R4");
      r5 = createRole("R5");

      g1 = createGroup("G1", r1);
      g1.getMembers().add(r2);
      g1.getMembers().add(r3);

      g2 = createGroup("G2", r2);

      g3 = createGroup("G3", r3);
      g3.getMembers().add(r4);

      g6 = createGroup("G6", null);

   }

   private Group createGroup(String id, Role owner) {
      Group g = RbacFactoryImpl.eINSTANCE.createGroup();
      g.setId(id);
      g.setName(id);
      g.setOwner(owner);
      accessControlModel.getGroups().add(g);
      return g;
   }

   private Role createRole(String id) {
      Role r = RbacFactoryImpl.eINSTANCE.createRole();
      r.setId(id);
      r.setName(id);
      accessControlModel.getRoles().add(r);
      return r;
   }

   @Test
   public void testRemoveRole1() {
      createDummyModel();
      AccessControlModelUtil.removeRoleGroupAndRole(r1, accessControlModel);
      EList<Role> roles = accessControlModel.getRoles();
      EList<Group> groups = accessControlModel.getGroups();
      Assert.assertTrue(roles.size() == 1);
      Assert.assertTrue(roles.contains(r5));
      
      Assert.assertTrue(groups.size() == 1);
      Assert.assertTrue(groups.contains(g6));
   }

   @Test
   public void testRemoveRole2() {
      createDummyModel();
      AccessControlModelUtil.removeRoleGroupAndRole(r2, accessControlModel);
      EList<Role> roles = accessControlModel.getRoles();
      EList<Group> groups = accessControlModel.getGroups();
      Assert.assertTrue(roles.size() == 4);
      Assert.assertTrue(roles.contains(r5));
      Assert.assertTrue(roles.contains(r1));
      Assert.assertTrue(roles.contains(r3));
      Assert.assertTrue(roles.contains(r4));
      
      Assert.assertTrue(groups.size() == 3);
      Assert.assertTrue(groups.contains(g6));
      Assert.assertTrue(groups.contains(g1));
      Assert.assertTrue(groups.contains(g3));
   }
   @Test
   public void testRemoveRole3() {
      createDummyModel();
      AccessControlModelUtil.removeRoleGroupAndRole(r3, accessControlModel);
      EList<Role> roles = accessControlModel.getRoles();
      EList<Group> groups = accessControlModel.getGroups();
      Assert.assertTrue(roles.size() == 3);
      Assert.assertTrue(roles.contains(r5));
      Assert.assertTrue(roles.contains(r1));
      Assert.assertTrue(roles.contains(r2));
      
      Assert.assertTrue(groups.size() == 3);
      Assert.assertTrue(groups.contains(g6));
      Assert.assertTrue(groups.contains(g1));
      Assert.assertTrue(groups.contains(g2));
   }

   @Test
   public void testRemoveRole5() {
      createDummyModel();
      AccessControlModelUtil.removeRoleGroupAndRole(r5, accessControlModel);
      EList<Role> roles = accessControlModel.getRoles();
      EList<Group> groups = accessControlModel.getGroups();
      Assert.assertTrue(roles.size() == 4);
      Assert.assertTrue(roles.contains(r1));
      Assert.assertTrue(roles.contains(r2));
      Assert.assertTrue(roles.contains(r3));
      Assert.assertTrue(roles.contains(r4));
      
      Assert.assertTrue(groups.size() == 4);
      Assert.assertTrue(groups.contains(g6));
      Assert.assertTrue(groups.contains(g1));
      Assert.assertTrue(groups.contains(g2));
      Assert.assertTrue(groups.contains(g3));
   }

}
