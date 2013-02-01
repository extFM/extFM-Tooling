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

   private AccessControlModel model;

   private Map<Role, List<ConfigurationOperation>> roleCache;

   public RBACService(AccessControlModel model) {
      this.model = model;
      initRoles();
   }

   private void initRoles() {
      roleCache = new HashMap<Role, List<ConfigurationOperation>>();
      EList<Role> roles = model.getRoles();
      // a single role is a role without parent and child roles
      List<Role> singleRoles = new ArrayList<Role>();
      // a root role is a role having children, but no parent roles
      List<Role> rootRoles = new ArrayList<Role>();
      // a leaf role is a role having parents, but no child roles
      List<Role> leafRoles = new ArrayList<Role>();
      // all other roles, that have parent and children
      List<Role> otherRoles = new ArrayList<Role>();

      // initially sort roles
      for (Role role : roles) {
         boolean noParent = role.getParentRoles().isEmpty();
         boolean noChildren = role.getChildRoles().isEmpty();
         if (noParent && noChildren) {
            singleRoles.add(role);
         } else if (noParent) {
            rootRoles.add(role);
         } else if (noChildren) {
            leafRoles.add(role);
         } else {
            otherRoles.add(role);
         }

         // 1. check single roles
         for (Role singleRole : singleRoles) {
            roleCache.put(role, getDirectRoleConfigOperations(singleRole));

         }
      }

   }

   public List<ConfigurationOperation> getAllRoleConfigOperations(Role role) {
      List<ConfigurationOperation> configOps = new ArrayList<ConfigurationOperation>();
      EList<Role> parentRoles = role.getParentRoles();
      for (Role parentRole : parentRoles) {}

      configOps.addAll(getDirectRoleConfigOperations(role));
      return configOps;
   }

   private List<ConfigurationOperation> getDirectRoleConfigOperations(Role role) {
      List<ConfigurationOperation> configOps = new ArrayList<ConfigurationOperation>();

      EList<ConfigurationOperation> allowedConfigOperations = role.getAllowedConfigOperations();
      List<ConfigurationOperation> copiedConfigOperations = new ArrayList<ConfigurationOperation>(allowedConfigOperations.size());
      copiedConfigOperations.addAll(allowedConfigOperations);

      for (ConfigurationOperation configurationOperation : allowedConfigOperations) {
         copiedConfigOperations.remove(configurationOperation);
         if (configurationOperation instanceof FeatureConfiguration) {
            FeatureConfiguration featureConfiguration = (FeatureConfiguration) configurationOperation;
            Feature feature = featureConfiguration.getFeature();

            // cache all feature config operations that cover the same feature
            List<FeatureConfiguration> featureConfigOperations = new ArrayList<FeatureConfiguration>();
            featureConfigOperations.add(featureConfiguration);
            for (ConfigurationOperation copiedOperation : copiedConfigOperations) {
               if (copiedOperation instanceof FeatureConfiguration) {
                  FeatureConfiguration copiedFeatureConfig = (FeatureConfiguration) copiedOperation;
                  Feature copiedOpFeature = copiedFeatureConfig.getFeature();
                  if (EcoreUtil.equals(feature, copiedOpFeature)) {
                     featureConfigOperations.add(copiedFeatureConfig);
                  }
               }
            }
            copiedConfigOperations.removeAll(featureConfigOperations);
            configOps.add(joinFeatureConfigOperations(featureConfigOperations));
         }

         else if (configurationOperation instanceof AttributeConfiguration) {
            AttributeConfiguration attributeConfiguration = (AttributeConfiguration) configurationOperation;
            Attribute attribute = attributeConfiguration.getAttribute();

            // cache all attribute config operations that cover the same feature
            List<AttributeConfiguration> attributeConfigOperations = new ArrayList<AttributeConfiguration>();
            attributeConfigOperations.add(attributeConfiguration);

            for (ConfigurationOperation copiedOperation : copiedConfigOperations) {
               if (copiedOperation instanceof AttributeConfiguration) {
                  AttributeConfiguration copiedattributeConfig = (AttributeConfiguration) copiedOperation;
                  Feature copiedOpAttribute = copiedattributeConfig.getFeature();
                  if (EcoreUtil.equals(attribute, copiedOpAttribute)) {
                     attributeConfigOperations.add(copiedattributeConfig);
                  }
               }
            }
            copiedConfigOperations.removeAll(attributeConfigOperations);
            configOps.add(joinAttributeConfigOperations(attributeConfigOperations));

         }
      }

     // configOps.addAll(allowedConfigOperations);
      return configOps;
   }

   private AttributeConfiguration joinAttributeConfigOperations(List<AttributeConfiguration> ops) {
      AttributeConfiguration newAttributeConfigOperation = null;
      if (ops.size() == 1) {
         newAttributeConfigOperation = ops.get(0);
      } else {
         newAttributeConfigOperation = RbacFactory.eINSTANCE.createAttributeConfiguration();
         // if an attribute configuration has select=true and deselect=true it means
         // that all domain values are allowed to be selected and deselected
         // this is the most general case and no further child value config options need to be considered
         for (AttributeConfiguration attributeConfiguration : ops) {
            if (attributeConfiguration.isSelect()) {
               newAttributeConfigOperation.setSelect(true);
            }
            if (attributeConfiguration.isDeselect()) {
               newAttributeConfigOperation.setDeselect(true);
            }
            if (newAttributeConfigOperation.isSelect() && newAttributeConfigOperation.isDeselect()) {
               newAttributeConfigOperation.getValueConfigurations().clear();
               break;
            }
            // check domain value config operations
            EList<DomainValueConfiguration> valueConfigurations = attributeConfiguration.getValueConfigurations();
            Domain domain = attributeConfiguration.getAttribute().getDomain();
            for (DomainValueConfiguration domainValueConfiguration : valueConfigurations) {
               String value = domainValueConfiguration.getValue();
               // TODO: check domain values
            }
         }
      }
      return newAttributeConfigOperation;
   }

   private FeatureConfiguration joinFeatureConfigOperations(List<FeatureConfiguration> ops) {
      FeatureConfiguration newFeatureConfigOperation = null;
      if (ops.size() > 1) {
         newFeatureConfigOperation = RbacFactory.eINSTANCE.createFeatureConfiguration();
         for (FeatureConfiguration featureConfiguration : ops) {
            if (featureConfiguration.isSelect()) {
               newFeatureConfigOperation.setSelect(true);
            }
            if (featureConfiguration.isDeselect()) {
               newFeatureConfigOperation.setDeselect(true);
            }
            if (newFeatureConfigOperation.isSelect() && newFeatureConfigOperation.isDeselect()) {
               break;
            }
         }
      } else {
         newFeatureConfigOperation = ops.get(0);
      }
      return newFeatureConfigOperation;
   }

}
