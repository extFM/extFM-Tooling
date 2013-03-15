package org.js.model.rbac;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.DeselectFeature;
import org.js.model.rbac.Permission;
import org.js.model.rbac.SelectFeature;
import org.js.model.rbac.SetAttribute;

public class PermissionInitialization {

   private AccessControlModel model;

   public PermissionInitialization(AccessControlModel model) {
      this.model = model;
   }

   public void initPermissions() {
      EList<FeatureModel> featureModels = model.getFeatureModels();
      for (FeatureModel featureModel : featureModels) {
         Feature root = featureModel.getRoot();
         addSelectRootFeaturePermission(root);
         TreeIterator<EObject> treeIterator = root.eAllContents();
         while (treeIterator.hasNext()) {
            EObject eObject = (EObject) treeIterator.next();
            createPermissions(eObject);
         }
      }
   }

   private void addSelectRootFeaturePermission(Feature root) {
      SelectFeature selectFeature = RbacHelper.createSelectFeature(root);
      EList<Permission> permissions = model.getPermissions();
      permissions.add(selectFeature);
   }

   private void createPermissions(EObject eObject) {
      if (eObject instanceof Feature) {
         Feature feature = (Feature) eObject;
         createFeaturePermissions(feature);
      } else if (eObject instanceof Attribute) {
         Attribute attribute = (Attribute) eObject;
         createAttributePermissions(attribute);
      }
   }

   
   private void createAttributePermissions(Attribute attribute) {
      Feature feature = attribute.getFeature();
      SetAttribute setAttribute = RbacHelper.createSetAttribute(feature, attribute);
      EList<Permission> permissions = model.getPermissions();
      permissions.add(setAttribute);
   }

   private void createFeaturePermissions(Feature feature) {
      SelectFeature selectFeature = RbacHelper.createSelectFeature(feature);
      DeselectFeature deselectFeature = RbacHelper.createDeselectFeature(feature);
      
      EList<Permission> permissions = model.getPermissions();
      permissions.add(selectFeature);
      permissions.add(deselectFeature);
   }

}
