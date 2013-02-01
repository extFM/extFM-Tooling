import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.ConfigurationOperation;
import org.js.model.rbac.RBACService;
import org.js.model.rbac.RbacFactory;
import org.js.model.rbac.Role;
import org.junit.Test;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class RBACServiceTest {

   AccessControlModel acModelUT;
   RBACService rbacService;
   
   public RBACServiceTest() {
      initRBACService();
   }
   
   
   private void initRBACService() {
      acModelUT = (new TestModel()).getACTestModel();
      rbacService = new RBACService(acModelUT);
      
   }

   private Role getRole(String roleId){
      EList<Role> roles = acModelUT.getRoles();
      Role r1 = null;
      for (Role role : roles) {
         String id = role.getId();
         if (roleId.equals(id)) {
            r1 = role;
            break;
         }}
      return r1;
   }
   

   @Test
   public void getDirectRoleConfigOperationsTest() {
      Role r1 = getRole("r1");
      List<ConfigurationOperation> allRoleConfigOperations = rbacService.getAllRoleConfigOperations(r1);
      assertTrue(allRoleConfigOperations.size() == 1);
      
      ConfigurationOperation configurationOperation = allRoleConfigOperations.get(0);
      assertEquals(true, configurationOperation.isSelect());
      assertEquals(false, configurationOperation.isDeselect());
   }

   @Test
   public void getParentRoleConfigOperationsTest() {
      Role r2 = getRole("r2");
      List<ConfigurationOperation> allRoleConfigOperations = rbacService.getAllRoleConfigOperations(r2);
      assertTrue(allRoleConfigOperations.size() == 1);
      
      ConfigurationOperation configurationOperation = allRoleConfigOperations.get(0);
      assertEquals(true, configurationOperation.isSelect());
      assertEquals(true, configurationOperation.isDeselect());
   }

}
