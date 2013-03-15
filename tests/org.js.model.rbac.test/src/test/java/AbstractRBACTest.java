import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.DeselectDomainValue;
import org.js.model.rbac.DeselectFeature;
import org.js.model.rbac.RBACService;
import org.js.model.rbac.RbacHelper;
import org.js.model.rbac.Role;
import org.js.model.rbac.SelectDomainValue;
import org.js.model.rbac.SelectFeature;
import org.js.model.rbac.SetAttribute;
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

   protected Feature getFeature(String featureId) {
      Feature result = null;
      EList<FeatureModel> featureModels = acModelUT.getFeatureModels();
      for (FeatureModel featureModel : featureModels) {
         TreeIterator<EObject> eAllContents = featureModel.eAllContents();
         while (eAllContents.hasNext()) {
            EObject next = eAllContents.next();
            if (next instanceof Feature) {
               Feature feature = (Feature) next;
               String id = feature.getId();
               if (featureId.equals(id)) {
                  result = feature;
                  break;
               }
            }
         }
      }
      return result;
   }

   protected Attribute getAttribute(Feature f, String attributeId) {
      Attribute result = null;
      EList<Attribute> attributes = f.getAttributes();
      for (Attribute attribute : attributes) {
         String name = attribute.getName();
         if (attributeId.equals(name)) {
            result = attribute;
            break;
         }
      }
      return result;
   }

   protected DeselectDomainValue createDeselectDomainValue(String domainValue, boolean enabled) {
      return RbacHelper.createDeselectDomainValue(domainValue, enabled);
   }

   protected SelectDomainValue createSelectDomainValue(String domainValue, boolean enabled) {
      return RbacHelper.createSelectDomainValue(domainValue, enabled);
   }

   protected SetAttribute createSetAttribute(Feature f, Attribute a, boolean enabled) {
      return RbacHelper.createSetAttribute(f, a, enabled);
   }

   protected SelectFeature createSelectFeature(Feature f, boolean enabled) {
      return RbacHelper.createSelectFeature(f, enabled);
   }

   protected DeselectFeature createDeselectFeature(Feature f, boolean enabled) {
      return RbacHelper.createDeselectFeature(f, enabled);
   }

}
