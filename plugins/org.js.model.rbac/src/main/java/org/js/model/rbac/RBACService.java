/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.rbac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.Domain;
import org.js.model.feature.Feature;

/**
 * Access information from the RBAC model.
 * 
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class RBACService {



   // default constructor
   public RBACService() {
   }



//   /**
//    * get all the configuration operations that belong to this role.
//    * 
//    * @param role
//    * @return
//    */
//   public List<Permission> getAllRoleConfigOperations(Role role) {
//      List<Permission> configOps = new ArrayList<Permission>();
//      getAllRoleConfigOperationsRecursively(role, configOps);
//      List<Permission> mergedOperations = mergeOperations(configOps);
//      return mergedOperations;
//   }
//
//   private List<Permission> mergeOperations(List<Permission> configOps) {
//      Map<Feature, List<FeatureReference>> featureConfigs = new HashMap<Feature, List<FeatureReference>>();
//      Map<Attribute, List<AttributeReference>> attributeConfigs = new HashMap<Attribute, List<AttributeReference>>();
//
//      // sort config operations
//      for (Permission configurationOperation : configOps) {
//         if (configurationOperation instanceof AttributeReference) {
//            AttributeReference ac = (AttributeReference) configurationOperation;
//            Attribute attribute = ac.getAttribute();
//            List<AttributeReference> list = attributeConfigs.get(attribute);
//            if (list == null) {
//               list = new ArrayList<AttributeReference>(2);
//               attributeConfigs.put(attribute, list);
//            }
//            list.add(ac);
//
//         } else {
//            FeatureReference fc = (FeatureReference) configurationOperation;
//            Feature feature = fc.getFeature();
//
//            List<FeatureReference> list = featureConfigs.get(feature);
//            if (list == null) {
//               list = new ArrayList<FeatureReference>(2);
//               featureConfigs.put(feature, list);
//            }
//            list.add(fc);
//         }
//      }
//
//      // merge config operations
//      List<Permission> mergedOps = new ArrayList<>();
//      Set<Feature> featureKeySet = featureConfigs.keySet();
//      for (Feature feature : featureKeySet) {
//         List<FeatureReference> list = featureConfigs.get(feature);
//         FeatureReference mergedOp = mergeFeatureConfigOperations(list);
//         mergedOps.add(mergedOp);
//      }
//
//      Set<Attribute> attributeKeySet = attributeConfigs.keySet();
//      for (Attribute attribute : attributeKeySet) {
//         List<AttributeConfiguration> list = attributeConfigs.get(attribute);
//         AttributeConfiguration mergedOp = mergeAttributeConfigOperations(list);
//         mergedOps.add(mergedOp);
//      }
//
//      return mergedOps;
//
//   }
//
//   private void getAllRoleConfigOperationsRecursively(Role role, List<ConfigurationOperation> configOps) {
//      configOps.addAll(role.getAllowedConfigOperations());
//      EList<Role> parentRoles = role.getParentRoles();
//      for (Role parentRole : parentRoles) {
//         getAllRoleConfigOperationsRecursively(parentRole, configOps);
//      }
//   }
//
//   private AttributeConfiguration mergeAttributeConfigOperations(List<AttributeConfiguration> ops) {
//      AttributeConfiguration newAttributeConfigOperation = null;
//      if (ops.size() == 1) {
//         newAttributeConfigOperation = ops.get(0);
//      } else {
//         newAttributeConfigOperation = RbacFactory.eINSTANCE.createAttributeConfiguration();
//         // if an attribute configuration has select=true and deselect=true it means
//         // that all domain values are allowed to be selected and deselected
//         // this is the most general case and no further child value config options need to be considered
//         for (AttributeConfiguration attributeConfiguration : ops) {
//            if (attributeConfiguration.isSelect()) {
//               newAttributeConfigOperation.setSelect(true);
//            }
//            if (attributeConfiguration.isDeselect()) {
//               newAttributeConfigOperation.setDeselect(true);
//            }
//            if (newAttributeConfigOperation.isSelect() && newAttributeConfigOperation.isDeselect()) {
//               newAttributeConfigOperation.getValueConfigurations().clear();
//               break;
//            }
//            // check domain value config operations
//            EList<DomainValueConfiguration> valueConfigurations = attributeConfiguration.getValueConfigurations();
//            Domain domain = attributeConfiguration.getAttribute().getDomain();
//            for (DomainValueConfiguration domainValueConfiguration : valueConfigurations) {
//               String value = domainValueConfiguration.getValue();
//               // TODO: check domain values
//            }
//         }
//      }
//      return newAttributeConfigOperation;
//   }
//
//   /**
//    * merge feature configuration operations if they cover the same feature. will only join 2 or more operations. If
//    * only one operation is contained then return this one.
//    * 
//    * @param ops
//    * @return
//    */
//   public FeatureConfiguration mergeFeatureConfigOperations(List<FeatureConfiguration> ops) {
//      FeatureConfiguration newFeatureConfigOperation = ops.get(0);
//      if (ops.size() > 1) {
//         Feature feature = newFeatureConfigOperation.getFeature();
//         newFeatureConfigOperation = RbacFactory.eINSTANCE.createFeatureConfiguration();
//         newFeatureConfigOperation.setFeature(feature);
//
//         for (FeatureConfiguration featureConfiguration : ops) {
//            if (EcoreUtil.equals(feature, featureConfiguration.getFeature())) {
//               if (featureConfiguration.isSelect()) {
//                  newFeatureConfigOperation.setSelect(true);
//               }
//               if (featureConfiguration.isDeselect()) {
//                  newFeatureConfigOperation.setDeselect(true);
//               }
//            }
//            if (newFeatureConfigOperation.isSelect() && newFeatureConfigOperation.isDeselect()) {
//               break;
//            }
//         }
//      }
//      return newFeatureConfigOperation;
//   }

   /**
    * get a subject's direct and indirect roles.
    * 
    * @param subject
    * @return
    */
   public List<Role> getSubjectRoles(Subject subject) {
      List<Role> allRoles = new ArrayList<>();
      EList<Role> roles = subject.getRoles();
      allRoles.addAll(roles);
      for (Role role : roles) {
         List<Role> parentRoles = getParentRoles(role);
         for (Role parent : parentRoles) {
            if (!allRoles.contains(parent)) {
               allRoles.add(parent);
            }
         }
      }
      return allRoles;
   }

   private void findParentRoles(Role role, List<Role> roles) {
      EList<Role> parents = role.getParentRoles();
      for (Role parent : parents) {
         if (!roles.contains(parent)) {
            roles.add(parent);
            findParentRoles(parent, roles);
         }
      }
   }

   private void findChildRoles(Role role, List<Role> roles) {
      EList<Role> children = role.getChildRoles();
      for (Role child : children) {
         if (!roles.contains(child)) {
            roles.add(child);
            findChildRoles(child, roles);
         }
      }
   }

   /**
    * get a role's directly assigned subjects.
    * 
    * @param role
    * @return
    */
   public List<Subject> getRoleDirectSubjects(Role role) {
      EList<Subject> subjects = role.getSubjects();
      return subjects;
   }

   /**
    * get all the roles that are direct and indirect children of the specified role.
    * 
    * @param role
    * @return
    */
   public List<Role> getChildRoles(Role role) {
      List<Role> children = new ArrayList<Role>();
      findChildRoles(role, children);
      return children;
   }

   /**
    * get all the roles that are directly and indirectly assigned parents of the specified role.
    * 
    * @param role
    * @return
    */
   public List<Role> getParentRoles(Role role) {
      List<Role> parents = new ArrayList<Role>();
      findParentRoles(role, parents);
      return parents;
   }
}
