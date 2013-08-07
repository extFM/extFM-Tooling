package org.js.model.feature.csp;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
import org.js.model.feature.Interval;
import org.js.model.feature.NumericalDomain;

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

   private static Logger log = Logger
			.getLogger(FeatureModelHelper.class);
   
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

   /**
    * get the currently set attribute value as integer representation.
    * beware: if the attribute does not have a value assigned, this methods returns -1.
    * Use the method isAttributeValueSet(Attribute attribute) before to ensure a correct result.
    * @param attribute
    * @return
    */
   public static int getAttributeValue(Attribute attribute){
	   String value = attribute.getValue();
	   return getAttributeValueForString(value, attribute);
   }
   
   /**
    * returns the attribute integer representation that belongs to the given String representation.
    * @param valueString
    * @param attribute
    * @return
    */
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

   /**
    * check if the given attribute value is contained in the given domain
    * @param domain
    * @param attributeValue
    * @return
    */
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

   /**
    * check if the attribute's value is already set.
    * @param attribute
    * @return
    */
   public static boolean isAttributeValueSet(Attribute attribute) {
      boolean isSet = false;
      String value = attribute.getValue();
      boolean existValue = (value != null && !value.isEmpty());
      if (existValue) {
         Domain domain = attribute.getDomain();
         if (domain instanceof DiscreteDomain) {
            DiscreteDomain discreteDomain = (DiscreteDomain) domain;
            isSet = containsValue(discreteDomain, value);
         } else if (domain instanceof NumericalDomain) {
			NumericalDomain numDomain = (NumericalDomain) domain;
			isSet = containsValue(numDomain, value);
		}
      }
      return isSet;
   }

   private static boolean containsValue(NumericalDomain numDomain, String value) {
	boolean isContained = false;
	int number = Integer.parseInt(value);
	for (Interval interval : numDomain.getIntervals()) {
		isContained = isInInterval(number, interval);
		if (isContained){
			break;
		}
	}
	return isContained;
}
   
   private static boolean isInInterval(int number, Interval interval){
	   boolean isinbounds = false;
	   int lowerBound = interval.getLowerBound();
	   int upperBound = interval.getUpperBound();
	   isinbounds = lowerBound <= number && upperBound >= number;
	   return isinbounds;
   }
   

/**
    * get the String representation of the given attribute and integer value
    * @param value
    * @param attribute
    * @return
    */
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

   /**
    * resolve the attribute identified by the given attributeId.
    * the attribute id is used in the cpmodel utilized in the csp solver.
    * @param attributeId
    * @return
    */
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

   /**
    * resolve the attribute by its name and feature.
    * @param featureId
    * @param attributeName
    * @return
    */
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
         result = FeatureState.SELECTED.equals(feature.getConfigurationState());
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

   
   
   /**
    * initialize a featuremodel from an Ifile.
    * 
    * @param file
    * @return
    */
   public static FeatureModel getFeatureModel(IFile file, ResourceSet resourceSet) {
      FeatureModel featuremodel = null;
      EObject object = getModel(file, resourceSet);
      if (object instanceof FeatureModel) {
         featuremodel = (FeatureModel) object;
      }
      return featuremodel;
   }

   public static FeatureModel getFeatureModel(IFile file){
	   return getFeatureModel(file, new ResourceSetImpl());
   }
   
   
   /**
    * Generic method to load a model from a file.
    * 
    * @param file
    * @return
    */
   public static EObject getModel(IFile file, ResourceSet resourceSet) {
      EObject result = null;
      Resource modelResource = getModelResource(file, resourceSet);
      if (modelResource == null) {
         log.warn("The selected resource is not an EMF model,");
      } else {
         try {
            modelResource.load(Collections.EMPTY_MAP);
         } catch (IOException e) {
            log.debug(e.getMessage());
         }
         if (modelResource.isLoaded()) {
            EList<EObject> contents = modelResource.getContents();
            if (contents != null && !contents.isEmpty()) {
               result = contents.get(0);
            }
         }
      }
      return result;
   }

   /**
    * get the according resource for a file.
    * 
    * @param file
    * @return
    */
   public static Resource getModelResource(IFile file, ResourceSet resourceSet) {
      Resource resource = null;
      if (file != null && file.exists()) {
         String locationUri = file.getLocationURI().normalize().getPath();
         URI uri = URI.createFileURI(locationUri);
         resource = resourceSet.createResource(uri);
      }
      return resource;
   }
   
}
