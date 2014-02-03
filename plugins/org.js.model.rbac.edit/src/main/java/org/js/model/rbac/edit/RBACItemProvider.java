/**
 * 
 */
package org.js.model.rbac.edit;

import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.feature.edit.FeatureModelHelper;
import org.js.model.rbac.AttributeOperation;
import org.js.model.rbac.AttributeValueOperation;
import org.js.model.rbac.FeatureOperation;
import org.js.model.rbac.RBACResolverUtil;
import org.js.model.rbac.RbacHelper;
import org.js.model.rbac.Role;

/**
 * Provider to get Text and Images for Itemproviders.
 * 
 * @author Julia
 * 
 */
public class RBACItemProvider {

   public static String image_selectFeature = "full/obj16/SelectFeature";
   public static String image_deselectFeature = "full/obj16/DeselectFeature";
   public static String image_selectDomainValue = "full/obj16/SelectDomainValue";
   public static String image_deselectDomainValue = "full/obj16/DeselectDomainValue";
   public static String image_concreteRole = "full/obj16/Role";
   public static String image_abstractRole = "full/obj16/AbstractRole";

   public static String getText(Object object) {
      String label = "";
      if (object instanceof AttributeOperation) {
         AttributeOperation attOp = (AttributeOperation) object;
         label = getText(attOp);
      } else if (object instanceof FeatureOperation) {
         FeatureOperation featureOp = (FeatureOperation) object;
         label = getText(featureOp);
      } else if (object instanceof AttributeValueOperation) {
         AttributeValueOperation dvOp = (AttributeValueOperation) object;
         label = getText(dvOp);
      }

      return label;
   }

   public static String getText(AttributeValueOperation op) {
      String label = op.getType().getLiteral();
      int value = op.getValue();
      Attribute attribute = op.getAttribute();
      String valueString = FeatureModelHelper.getAttributeValue(value, attribute);
      String featureId = op.getFeature().getId();
      String attributeId = attribute.getName();
      label += " " + featureId + RBACResolverUtil.delimiter + attributeId + RBACResolverUtil.delimiter + valueString;
      return label;
   }

   public static String getText(FeatureOperation op) {
      String label = op.getType().getLiteral();
      Feature feature = op.getFeature();
      if (feature != null) {
         label += " <" + feature.getId() + ">";
      }
      return label;
   }

   public static String getText(AttributeOperation op) {
      String featureId = op.getFeature().getId();
      String attributeId = op.getAttribute().getName();
      return RBACResolverUtil.set + " " + featureId + RBACResolverUtil.delimiter + attributeId;
   }

   public static String getImage(Object object) {
      String imagePath = "";
      if (object instanceof FeatureOperation) {
         FeatureOperation featureOp = (FeatureOperation) object;
         imagePath = (RbacHelper.isSelectFeatureOperation(featureOp)) ? image_selectFeature : image_deselectFeature;
      } else if (object instanceof AttributeValueOperation) {
         AttributeValueOperation dvOp = (AttributeValueOperation) object;
         imagePath = (RbacHelper.isSelectDomainValueOperation(dvOp)) ? image_selectDomainValue : image_deselectDomainValue;
      } else if (object instanceof Role) {
         Role role = (Role) object;
         imagePath = (RbacHelper.isAbstractRole(role)) ? image_abstractRole : image_concreteRole;
      }
      return imagePath;
   }

}
