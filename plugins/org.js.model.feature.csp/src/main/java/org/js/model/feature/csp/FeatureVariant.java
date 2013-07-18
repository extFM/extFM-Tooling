/**
 * 
 */
package org.js.model.feature.csp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.FeatureState;

/**
 * A variant feature configuration.
 * 
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class FeatureVariant {

   FeatureModelHelper helper;

   public FeatureVariant(FeatureModel model) {
      this.helper = new FeatureModelHelper(model);
   }

   public FeatureModel getModel(){
      return helper.getModel();
   }
   
   public void setAttributeValue(String attributeId) {
      Attribute attribute = helper.getAttribute(attributeId);
      if (attribute != null) {
         if (FeatureModelHelper.isAttributeValueSet(attribute)) {
            int value = helper.getValue(attributeId);
            String attributeValue = FeatureModelHelper.getAttributeValue(value, attribute);
            attribute.setValue(attributeValue);
         }
      }
   }

   public void setAttributeValue(int value, String attributeId) {
      if (value != TranslateFM2CSP.attributeDisabled) {
         Attribute attribute = helper.getAttribute(attributeId);
         if (attribute != null) {
            String attributeValue = FeatureModelHelper.getAttributeValue(value, attribute);
            attribute.setValue(attributeValue);
         }
      }
   }

   public void selectFeature(String featureId) {
      Feature feature = helper.getFeature(featureId);
      if (feature != null) {
         feature.setSelected(FeatureState.SELECTED);
      }
   }

   public void deselectFeature(String featureId) {
      Feature feature = helper.getFeature(featureId);
      if (feature != null) {
         feature.setSelected(FeatureState.DESELECTED);
      }
   }

   public int getSelectedFeatureCount() {
      return helper.getSelectedFeatures().size();
   }

   public String toString() {
      StringBuffer buffer = new StringBuffer();
      for (Feature feature : helper.getAllFeatures()) {
         if (buffer.length() > 0) {
            buffer.append(", ");
         }
         String featureId = EcoreUtil.getID(feature);
         buffer.append(getFeatureSelectionString(feature));
         buffer.append(featureId);
         EList<Attribute> attributes = feature.getAttributes();
         for (Attribute attribute : attributes) {
            buffer.append("; ");
            buffer.append(attribute.getFeature().getId());
            buffer.append(".");
            buffer.append(attribute.getName());
            buffer.append("=");
            buffer.append(attribute.getValue());
            buffer.append(" ");
         }
      }
      return buffer.toString();
   }

   private String getFeatureSelectionString(Feature feature) {
      String state;
      FeatureState selected = feature.getSelected();
      if (FeatureState.UNBOUND.equals(selected)) {
         state = "(" + selected.getLiteral() + ")";
      }
      state = FeatureState.SELECTED.equals(selected) ? "+" : "-";
      return state;
   }

}
