/**
 * 
 */
package org.js.model.rbac.edit;

import org.js.model.feature.Feature;
import org.js.model.rbac.AttributeOperation;
import org.js.model.rbac.DomainValueOperation;
import org.js.model.rbac.FeatureOperation;
import org.js.model.rbac.RBACResolverUtil;
import org.js.model.rbac.RbacHelper;

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

   public static String getText(Object object) {
      String label = "";
      if (object instanceof AttributeOperation) {
         AttributeOperation attOp = (AttributeOperation) object;
         label = getText(attOp);
      } else if (object instanceof FeatureOperation) {
         FeatureOperation featureOp = (FeatureOperation) object;
         label = getText(featureOp);
      } else if (object instanceof DomainValueOperation) {
         DomainValueOperation dvOp = (DomainValueOperation) object;
         label = getText(dvOp);
      }

      return label;
   }

   public static String getText(DomainValueOperation op) {
      String label = op.getType().getLiteral();
      String value = op.getValue();
      if (value != null) {
         label += " " + value;
      }
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
      } else if (object instanceof DomainValueOperation) {
         DomainValueOperation dvOp = (DomainValueOperation) object;
         imagePath = (RbacHelper.isSelectDomainValueOperation(dvOp)) ? image_selectDomainValue : image_deselectDomainValue;
      }
      return imagePath;
   }

}
