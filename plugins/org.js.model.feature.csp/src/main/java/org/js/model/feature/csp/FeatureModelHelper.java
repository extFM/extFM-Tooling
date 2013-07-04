package org.js.model.feature.csp;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.AttributeConstraint;
import org.js.model.feature.DiscreteDomain;
import org.js.model.feature.Domain;
import org.js.model.feature.DomainValue;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureConstraint;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.FeatureState;

/**
 * 
 */

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public class FeatureModelHelper {

   Set<Feature> allFeatures;
   private Set<Attribute> allAttributes;
   private Set<FeatureConstraint> allFeatureConstraints;
   private Set<AttributeConstraint> allAttributeConstraints;
   private FeatureModel model;

   public FeatureModelHelper(FeatureModel model) {
      this.model = model;
      initLists();
      initModel(model);
   }

   private void initLists() {
      allFeatures = new HashSet<Feature>();
      setAllAttributes(new HashSet<Attribute>());
      setAllFeatureConstraints(new HashSet<FeatureConstraint>());
      setAllAttributeConstraints(new HashSet<AttributeConstraint>());
   }

   private void initModel(FeatureModel model) {
      TreeIterator<Object> allContents = EcoreUtil.getAllContents(model, true);
      while (allContents.hasNext()) {
         Object object = (Object) allContents.next();
         if (object instanceof Feature) {
            Feature feature = (Feature) object;
            allFeatures.add(feature);
         } else if (object instanceof Attribute) {
            Attribute attribute = (Attribute) object;
            getAllAttributes().add(attribute);
         } else if (object instanceof FeatureConstraint) {
            FeatureConstraint featureConstraint = (FeatureConstraint) object;
            getAllFeatureConstraints().add(featureConstraint);
         } else if (object instanceof AttributeConstraint) {
            AttributeConstraint attributeConstraint = (AttributeConstraint) object;
            getAllAttributeConstraints().add(attributeConstraint);
         }
      }
   }

   public int getValue(String attributeId) {
      String[] split = attributeId.split("~");
      // fourth is value, if available
      String value = split[3];
      return Integer.parseInt(value);
   }

   public static int getAttributeValueForString(String valueString, Attribute attribute) {
      // if value is -1, it is not found in domain value list
      int value = -1;
      Domain domain = attribute.getDomain();
      if (domain instanceof DiscreteDomain) {
         DiscreteDomain discreteDomain = (DiscreteDomain) domain;
         EList<DomainValue> values = discreteDomain.getValues();
         for (DomainValue domainValue : values) {
            String domainValueString = domainValue.getName();
            if (valueString.equals(domainValueString)) {
               value = domainValue.getInt();
               break;
            }
         }
      } else {
         value = Integer.parseInt(valueString);
      }
      return value;
   }

   public static boolean containsValue(DiscreteDomain domain, String attributeValue) {
      boolean isContained = false;
      DiscreteDomain discreteDomain = (DiscreteDomain) domain;
      EList<DomainValue> values = discreteDomain.getValues();
      for (DomainValue domainValue : values) {
         String domainValueString = domainValue.getName();
         if (attributeValue.equals(domainValueString)) {
            isContained = true;
            break;
         }
      }
      return isContained;
   }

   public static boolean isAttributeValueSet(Attribute attribute) {
      boolean isSet = false;
      String value = attribute.getValue();
      boolean existValue = (value != null && !value.isEmpty());
      if (existValue) {
         Domain domain = attribute.getDomain();
         if (domain instanceof DiscreteDomain) {
            DiscreteDomain discreteDomain = (DiscreteDomain) domain;
            isSet = containsValue(discreteDomain, value);
         }
      }
      return isSet;
   }

   public static String getAttributeValue(int value, Attribute attribute) {
      String valueName = null;
      Domain domain = attribute.getDomain();
      if (domain instanceof DiscreteDomain) {
         DiscreteDomain discreteDomain = (DiscreteDomain) domain;
         EList<DomainValue> values = discreteDomain.getValues();
         for (DomainValue domainValue : values) {
            int domainValueInt = domainValue.getInt();
            if (value == domainValueInt) {
               valueName = domainValue.getName();
               break;
            }
         }
      } else {
         valueName = Integer.toString(value);
      }
      return valueName;
   }

   public Attribute getAttribute(String attributeId) {
      Attribute attribute = null;
      String[] split = attributeId.split("~");
         // first is identifier value or enablement
         // String identifier = split[0];
         // second is feature id
         String featureId = split[1];
         // third is attribute id
         String attributeName = split[2];
         // fourth is value
         //String value = split[3];
         attribute = getAttribute(featureId, attributeName);
      return attribute;
   }

   public Attribute getAttribute(String featureId, String attributeName) {
      Attribute rattribute = null;
      Feature feature = getFeature(featureId);
      EList<Attribute> attributes = feature.getAttributes();
      for (Attribute attribute : attributes) {
         if (attribute.getName().equals(attributeName)) {
            rattribute = attribute;
            break;
         }
      }
      return rattribute;
   }

   public Feature getFeature(String featureId) {
      Feature result = null;
      for (Feature feature : allFeatures) {
         String id = feature.getId();
         if (id.equals(featureId)) {
            result = feature;
            break;
         }
      }
      return result;
   }

   public Set<Feature> getAllFeatures() {
      return allFeatures;
   }

   public Set<Feature> getSelectedFeatures() {
      Set<Feature> selectedFeatures = new HashSet<Feature>();
      for (Feature feature : allFeatures) {
         if (isFeatureSelected(feature)) {
            selectedFeatures.add(feature);
         }
      }
      return selectedFeatures;
   }

   public boolean isFeatureSelected(String featureId) {
      Feature feature = getFeature(featureId);
      return isFeatureSelected(feature);
   }

   public boolean isFeatureSelected(Feature feature) {
      boolean result = false;
      if (feature != null) {
         result = FeatureState.SELECTED.equals(feature.getSelected());
      }
      return result;
   }

   public Set<FeatureConstraint> getAllFeatureConstraints() {
      return allFeatureConstraints;
   }

   public void setAllFeatureConstraints(Set<FeatureConstraint> allFeatureConstraints) {
      this.allFeatureConstraints = allFeatureConstraints;
   }

   public Set<AttributeConstraint> getAllAttributeConstraints() {
      return allAttributeConstraints;
   }

   public void setAllAttributeConstraints(Set<AttributeConstraint> allAttributeConstraints) {
      this.allAttributeConstraints = allAttributeConstraints;
   }

   public Set<Attribute> getAllAttributes() {
      return allAttributes;
   }

   public void setAllAttributes(Set<Attribute> allAttributes) {
      this.allAttributes = allAttributes;
   }

   public FeatureModel getModel() {
      return model;
   }

}
