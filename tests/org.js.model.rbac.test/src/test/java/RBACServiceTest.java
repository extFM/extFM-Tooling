import static org.junit.Assert.*;

import java.util.List;

import org.js.model.rbac.Permission;
import org.js.model.rbac.Role;
import org.junit.Test;


/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class RBACServiceTest extends AbstractRBACTest{


   @Test
   public void getAllRolePermissions(){
      Role r1 = getRole("r1");
      List<Permission> permissions = rbacService.getAllRolePermissions(r1);
      assertTrue(permissions.size() == 2);
   }
//
//   @Test
//   public void getAllRoleConfigOperationsTest() {
//      Role r1 = getRole("r1");
//      List<ConfigurationOperation> allRoleConfigOperations = rbacService.getAllRoleConfigOperations(r1);
//      assertTrue(allRoleConfigOperations.size() == 1);
//
//      ConfigurationOperation configurationOperation = allRoleConfigOperations.get(0);
//      assertTrue(configurationOperation.isSelect());
//      assertTrue(false == configurationOperation.isDeselect());
//   }
//
//   @Test
//   public void getAllRoleConfigOperationsRecursively() {
//      Role r2 = getRole("r2");
//      List<ConfigurationOperation> allRoleConfigOperations = rbacService.getAllRoleConfigOperations(r2);
//      assertTrue(allRoleConfigOperations.size() == 1);
//
//      ConfigurationOperation configurationOperation = allRoleConfigOperations.get(0);
//      assertTrue(configurationOperation.isSelect());
//      assertTrue(configurationOperation.isDeselect());
//   }
//
//   @Test
//   public void mergeFeatureConfigOperationsTest() {
//      Feature feature = FeatureFactory.eINSTANCE.createFeature();
//      feature.setId("f1");
//      feature.setName("f1");
//
//      FeatureConfiguration fc1 = RbacFactory.eINSTANCE.createFeatureConfiguration();
//      fc1.setFeature(feature);
//      fc1.setSelect(true);
//      fc1.setDeselect(true);
//
//      FeatureConfiguration fc2 = RbacFactory.eINSTANCE.createFeatureConfiguration();
//      fc2.setFeature(feature);
//      fc2.setSelect(false);
//      fc2.setDeselect(false);
//
//      FeatureConfiguration fc3 = RbacFactory.eINSTANCE.createFeatureConfiguration();
//      fc3.setFeature(feature);
//      fc3.setSelect(true);
//      fc3.setDeselect(false);
//
//      FeatureConfiguration fc4 = RbacFactory.eINSTANCE.createFeatureConfiguration();
//      fc4.setFeature(feature);
//      fc4.setSelect(false);
//      fc4.setDeselect(true);
//
//      List<FeatureConfiguration> ops1 = new ArrayList<>();
//      ops1.add(fc1);
//      ops1.add(fc1);
//      FeatureConfiguration mergeops1 = rbacService.mergeFeatureConfigOperations(ops1);
//      assertTrue(mergeops1.isSelect());
//      assertTrue(mergeops1.isDeselect());
//
//      List<FeatureConfiguration> ops2 = new ArrayList<>();
//      ops2.add(fc2);
//      ops2.add(fc2);
//      FeatureConfiguration mergeops2 = rbacService.mergeFeatureConfigOperations(ops2);
//      assertTrue(false == mergeops2.isSelect());
//      assertTrue(false == mergeops2.isDeselect());
//
//      List<FeatureConfiguration> ops3 = new ArrayList<>();
//      ops3.add(fc3);
//      ops3.add(fc3);
//      FeatureConfiguration mergeops3 = rbacService.mergeFeatureConfigOperations(ops3);
//      assertTrue(mergeops3.isSelect());
//      assertTrue(false == mergeops3.isDeselect());
//
//      List<FeatureConfiguration> ops4 = new ArrayList<>();
//      ops4.add(fc4);
//      ops4.add(fc4);
//      FeatureConfiguration mergeops4 = rbacService.mergeFeatureConfigOperations(ops4);
//      assertTrue(false == mergeops4.isSelect());
//      assertTrue(mergeops4.isDeselect());
//
//      List<FeatureConfiguration> ops5 = new ArrayList<>();
//      ops5.add(fc1);
//      ops5.add(fc2);
//      FeatureConfiguration mergeops5 = rbacService.mergeFeatureConfigOperations(ops5);
//      assertTrue(mergeops5.isSelect());
//      assertTrue(mergeops5.isDeselect());
//
//      List<FeatureConfiguration> ops6 = new ArrayList<>();
//      ops6.add(fc1);
//      ops6.add(fc3);
//      FeatureConfiguration mergeops6 = rbacService.mergeFeatureConfigOperations(ops6);
//      assertTrue(mergeops6.isSelect());
//      assertTrue(mergeops6.isDeselect());
//
//      List<FeatureConfiguration> ops7 = new ArrayList<>();
//      ops7.add(fc1);
//      ops7.add(fc4);
//      FeatureConfiguration mergeops7 = rbacService.mergeFeatureConfigOperations(ops7);
//      assertTrue(mergeops7.isSelect());
//      assertTrue(mergeops7.isDeselect());
//
//      List<FeatureConfiguration> ops8 = new ArrayList<>();
//      ops8.add(fc2);
//      ops8.add(fc3);
//      FeatureConfiguration mergeops8 = rbacService.mergeFeatureConfigOperations(ops8);
//      assertTrue(mergeops8.isSelect());
//      assertTrue(false == mergeops8.isDeselect());
//
//      List<FeatureConfiguration> ops9 = new ArrayList<>();
//      ops9.add(fc2);
//      ops9.add(fc4);
//      FeatureConfiguration mergeops9 = rbacService.mergeFeatureConfigOperations(ops9);
//      assertTrue(false == mergeops9.isSelect());
//      assertTrue(mergeops9.isDeselect());
//
//      List<FeatureConfiguration> ops10 = new ArrayList<>();
//      ops10.add(fc3);
//      ops10.add(fc4);
//      FeatureConfiguration mergeops10 = rbacService.mergeFeatureConfigOperations(ops10);
//      assertTrue(mergeops10.isSelect());
//      assertTrue(mergeops10.isDeselect());
//
//      List<FeatureConfiguration> ops11 = new ArrayList<>();
//      ops11.add(fc4);
//      FeatureConfiguration mergeops11 = rbacService.mergeFeatureConfigOperations(ops11);
//      assertTrue(EcoreUtil.equals(fc4, mergeops11));
//   }

//   @Test
//   public void roleDirectSubjectsTest() {
//      Subject s1 = getSubject("s1");
//      Subject s2 = getSubject("s2");
//      Subject s3 = getSubject("s3");
//      Subject s4 = getSubject("s4");
//      
//      Role r1 = getRole("r1");
//      Role r2 = getRole("r2");
//      
//      // r1 -> s1, s4, s3
//      List<Subject> r1Subjects = rbacService.getRoleDirectSubjects(r1);
//      assertTrue(r1Subjects.size() == 3);
//      assertTrue(r1Subjects.contains(s1));
//      assertTrue(r1Subjects.contains(s4));
//      assertTrue(r1Subjects.contains(s3));
//      
//      // r2 -> s2, s3, s4
//      List<Subject> r2Subjects = rbacService.getRoleDirectSubjects(r2);
//      assertTrue(r2Subjects.size() == 3);
//      assertTrue(r2Subjects.contains(s2));
//      assertTrue(r2Subjects.contains(s3));
//      assertTrue(r2Subjects.contains(s4));
//   }
//   
//   @Test
//   public void subjectRolesTest() {
//      Subject s1 = getSubject("s1");
//      Subject s3 = getSubject("s3");
//      Subject s4 = getSubject("s4");
//      Subject s5 = getSubject("s5");
//      
//      Role r1 = getRole("r1");
//      Role r2 = getRole("r2");
//      Role r4 = getRole("r4");
//      
//      // s1 -> r1
//      List<Role> s1Roles = rbacService.getSubjectRoles(s1);
//      assertTrue(s1Roles.size() == 1);
//      assertTrue(s1Roles.contains(r1));
//      
//      // s3 -> r1 r2
//      List<Role> s3Roles = rbacService.getSubjectRoles(s3);
//      assertTrue(s3Roles.size() == 2);
//      assertTrue(s3Roles.contains(r1));
//      assertTrue(s3Roles.contains(r2));
//      
//      // s4 -> r1 r2
//      List<Role> s4Roles = rbacService.getSubjectRoles(s4);
//      assertTrue(s4Roles.size() == 2);
//      assertTrue(s4Roles.contains(r1));
//      assertTrue(s4Roles.contains(r2));
//      // s5 -> r1 r2 r4
//      List<Role> s5Roles = rbacService.getSubjectRoles(s5);
//      assertTrue(s5Roles.size() == 3);
//      assertTrue(s5Roles.contains(r1));
//      assertTrue(s5Roles.contains(r2));
//      assertTrue(s5Roles.contains(r4));
//   }
//
//   
//   @Test
//   public void getChildRolesTest() {
//      Role r1 = getRole("r1");
//      Role r2 = getRole("r2");
//      Role r4 = getRole("r4");
//      Role r5 = getRole("r5");
//      Role r6 = getRole("r6");
//      
//      // r1 -> r2, r4, r6
//      List<Role> cr1 = rbacService.getChildRoles(r1);
//      assertTrue(cr1.size() == 3);
//      assertTrue(cr1.contains(r2));
//      assertTrue(cr1.contains(r4));
//      assertTrue(cr1.contains(r6));
//      
//      // r4 -> r6
//      List<Role> cr4 = rbacService.getChildRoles(r4);
//      assertTrue(cr4.size() == 1);
//      assertTrue(cr4.contains(r6));
//      
//      // r6 -> 0
//      List<Role> cr6 = rbacService.getChildRoles(r6);
//      assertTrue(cr6.size() == 0);
//   }
//
//   @Test
//   public void getParentRolesTest() {
//      Role r1 = getRole("r1");
//      Role r2 = getRole("r2");
//      Role r3 = getRole("r3");
//      Role r4 = getRole("r4");
//      Role r5 = getRole("r5");
//      Role r6 = getRole("r6");
//      
//      // r1 -> 0
//      List<Role> cr1 = rbacService.getParentRoles(r1);
//      assertTrue(cr1.size() == 0);
//      
//      // r4 -> r2, r1
//      List<Role> cr4 = rbacService.getParentRoles(r4);
//      assertTrue(cr4.size() == 2);
//      assertTrue(cr4.contains(r2));
//      assertTrue(cr4.contains(r1));
//      
//      // r6 -> r4, r5, r3, r2, r1 
//      List<Role> cr6 = rbacService.getParentRoles(r6);
//      assertTrue(cr6.size() == 5);
//      assertTrue(cr6.contains(r1));
//      assertTrue(cr6.contains(r2));
//      assertTrue(cr6.contains(r3));
//      assertTrue(cr6.contains(r4));
//      assertTrue(cr6.contains(r5));
//   }
}
