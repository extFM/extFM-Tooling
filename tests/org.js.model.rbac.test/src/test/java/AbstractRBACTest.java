import org.eclipse.emf.common.util.EList;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.RBACService;
import org.js.model.rbac.Role;
import org.js.model.rbac.Subject;

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
public abstract class AbstractRBACTest {

   AccessControlModel acModelUT;
   RBACService rbacService;

   public AbstractRBACTest() {
      initModels();
   }

   private void initModels() {
      TestModel tm = new TestModel();
      acModelUT = tm.getACTestModel();
      rbacService = new RBACService();

   }

   protected Role getRole(String roleId) {
      EList<Role> roles = acModelUT.getRoles();
      Role r1 = null;
      for (Role role : roles) {
         String id = role.getId();
         if (roleId.equals(id)) {
            r1 = role;
            break;
         }
      }
      return r1;
   }

   protected Subject getSubject(String subjectId) {
      EList<Subject> subjects = acModelUT.getSubjects();
      Subject s1 = null;
      for (Subject s : subjects) {
         String id = s.getId();
         if (subjectId.equals(id)) {
            s1 = s;
            break;
         }
      }
      return s1;
   }

}
