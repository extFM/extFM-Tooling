package org.js.model.rbac;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.js.model.feature.Attribute;
import org.js.model.feature.DomainValue;
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
public abstract class AbstractTestRbac {

   AccessControlModel acModelUT;
   RBACService rbacService;

   public AbstractTestRbac() {
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

   protected DeselectDomainValue createDeselectDomainValue(DomainValue domainValue) {
      return RbacHelper.createDeselectDomainValue(domainValue);
   }

   protected SelectDomainValue createSelectDomainValue(DomainValue domainValue) {
      return RbacHelper.createSelectDomainValue(domainValue);
   }

   protected SetAttribute createSetAttribute(Feature f, Attribute a) {
      return RbacHelper.createSetAttribute(f, a);
   }

   protected SelectFeature createSelectFeature(Feature f) {
      return RbacHelper.createSelectFeature(f);
   }

   protected DeselectFeature createDeselectFeature(Feature f) {
      return RbacHelper.createDeselectFeature(f);
   }

}
