import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.js.model.rbac.Permission;
import org.js.model.rbac.Role;
import org.js.model.rbac.Subject;
import org.junit.Test;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class RBACServiceTest extends AbstractRBACTest {

   @Test
   public void getAllRolePermissions() {
      Role r1 = getRole("r1");
      Set<Permission> permissions = rbacService.getAllRolePermissions(r1);
      assertTrue(permissions.size() == 2);
   }

   @Test
   public void getAllRolePermissionsInheritance() {
      Role r4 = getRole("r4");
      Set<Permission> permissions = rbacService.getAllRolePermissions(r4);
      assertTrue(permissions.size() == 3);
   }

   @Test
   public void getAllRolePermissionsMultiInheritance() {
      Role r4 = getRole("r6");
      Set<Permission> permissions = rbacService.getAllRolePermissions(r4);
      assertTrue(permissions.size() == 9);

      // Feature f5 = getFeature("f5");
      //
      // SelectFeature selectF5 = createSelectFeature(f5, true);
      // DeselectFeature deselectF5 = createDeselectFeature(f5, true);
      /*
       * r6: select f5, deselect f5 r5: select f9, deselect f9, select f4, deselect f4 r2: deselect f2 r1: select f3
       * select f2 r3: select f2, deselect f2
       */

   }

   @Test
   public void roleDirectSubjectsTest() {
      Subject s1 = getSubject("s1");
      Subject s2 = getSubject("s2");
      Subject s3 = getSubject("s3");
      Subject s4 = getSubject("s4");

      Role r1 = getRole("r1");
      Role r2 = getRole("r2");

      // r1 -> s1, s4, s3
      List<Subject> r1Subjects = rbacService.getRoleDirectSubjects(r1);
      assertTrue(r1Subjects.size() == 3);
      assertTrue(r1Subjects.contains(s1));
      assertTrue(r1Subjects.contains(s4));
      assertTrue(r1Subjects.contains(s3));

      // r2 -> s2, s3, s4
      List<Subject> r2Subjects = rbacService.getRoleDirectSubjects(r2);
      assertTrue(r2Subjects.size() == 3);
      assertTrue(r2Subjects.contains(s2));
      assertTrue(r2Subjects.contains(s3));
      assertTrue(r2Subjects.contains(s4));
   }

   @Test
   public void subjectRolesTest() {
      Subject s1 = getSubject("s1");
      Subject s3 = getSubject("s3");
      Subject s4 = getSubject("s4");
      Subject s5 = getSubject("s5");

      Role r1 = getRole("r1");
      Role r2 = getRole("r2");
      Role r4 = getRole("r4");

      // s1 -> r1
      List<Role> s1Roles = rbacService.getSubjectRoles(s1);
      assertTrue(s1Roles.size() == 1);
      assertTrue(s1Roles.contains(r1));

      // s3 -> r1 r2
      List<Role> s3Roles = rbacService.getSubjectRoles(s3);
      assertTrue(s3Roles.size() == 2);
      assertTrue(s3Roles.contains(r1));
      assertTrue(s3Roles.contains(r2));

      // s4 -> r1 r2
      List<Role> s4Roles = rbacService.getSubjectRoles(s4);
      assertTrue(s4Roles.size() == 2);
      assertTrue(s4Roles.contains(r1));
      assertTrue(s4Roles.contains(r2));
      // s5 -> r1 r2 r4
      List<Role> s5Roles = rbacService.getSubjectRoles(s5);
      assertTrue(s5Roles.size() == 3);
      assertTrue(s5Roles.contains(r1));
      assertTrue(s5Roles.contains(r2));
      assertTrue(s5Roles.contains(r4));
   }

   @Test
   public void getChildRolesTest() {
      Role r1 = getRole("r1");
      Role r2 = getRole("r2");
      Role r4 = getRole("r4");
      Role r6 = getRole("r6");

      // r1 -> r2, r4, r6
      List<Role> cr1 = rbacService.getChildRoles(r1);
      assertTrue(cr1.size() == 3);
      assertTrue(cr1.contains(r2));
      assertTrue(cr1.contains(r4));
      assertTrue(cr1.contains(r6));

      // r4 -> r6
      List<Role> cr4 = rbacService.getChildRoles(r4);
      assertTrue(cr4.size() == 1);
      assertTrue(cr4.contains(r6));

      // r6 -> 0
      List<Role> cr6 = rbacService.getChildRoles(r6);
      assertTrue(cr6.size() == 0);
   }

   @Test
   public void getParentRolesTest() {
      Role r1 = getRole("r1");
      Role r2 = getRole("r2");
      Role r3 = getRole("r3");
      Role r4 = getRole("r4");
      Role r5 = getRole("r5");
      Role r6 = getRole("r6");

      // r1 -> 0
      List<Role> cr1 = rbacService.getParentRoles(r1);
      assertTrue(cr1.size() == 0);

      // r4 -> r2, r1
      List<Role> cr4 = rbacService.getParentRoles(r4);
      assertTrue(cr4.size() == 2);
      assertTrue(cr4.contains(r2));
      assertTrue(cr4.contains(r1));

      // r6 -> r4, r5, r3, r2, r1
      List<Role> cr6 = rbacService.getParentRoles(r6);
      assertTrue(cr6.size() == 5);
      assertTrue(cr6.contains(r1));
      assertTrue(cr6.contains(r2));
      assertTrue(cr6.contains(r3));
      assertTrue(cr6.contains(r4));
      assertTrue(cr6.contains(r5));
   }
}
