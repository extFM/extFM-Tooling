package org.feature.model.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.AttributeConstraint;
import org.js.model.feature.AttributeOperand;
import org.js.model.feature.AttributeReference;
import org.js.model.feature.AttributeValue;
import org.js.model.feature.Constraint;
import org.js.model.feature.Domain;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureConstraint;
import org.js.model.feature.FeatureFactory;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.Group;
import org.js.model.feature.Relop;
import org.js.model.feature.edit.FeatureModelHelper;

public final class FeatureModelInit {

   public static String id_prefix = "id_";
   public static String attribute_cardinality = "cardinality";
   public static String delimiter = "_";
   public static String whitespace = " ";
   public static String attribute_type_string = "String";
   public static String attribute_id = "id";

   private static Logger log = Logger.getLogger(FeatureModelInit.class);

   /**
    * Create the featuremodel and initialize it.
    * 
    * @return
    */
   public static FeatureModel initFeatureModel() {
      FeatureModel featureModel = FeatureFactory.eINSTANCE.createFeatureModel();
      return featureModel;
   }

   private static Group createFeatureGroup(Feature parentFeature) {
      Group newGroup = FeatureFactory.eINSTANCE.createGroup();
      EcoreUtil.setID(newGroup, getRandomId());
      // newGroup.setId(getRandomId());
      parentFeature.getGroups().add(newGroup);
      return newGroup;
   }

   public static Group createFeatureGroup(Feature parentFeature, int min, int max, String id) {
      Group group = createFeatureGroup(parentFeature);
      // group.setId(id);
      EcoreUtil.setID(group, id);
      group.setMinCardinality(min);
      group.setMaxCardinality(max);
      return group;
   }

   private static Feature createFeature(String name, String id) {
      Feature newFeature = FeatureFactory.eINSTANCE.createFeature();
      newFeature.setName(name);
      // createAttribute(newFeature, attribute_id, id, attribute_type_string);
      EcoreUtil.setID(newFeature, id);
      // newFeature.setId(id);
      return newFeature;
   }

   /**
    * create a feature in a group
    * 
    * @param parent
    * @param name
    * @param id
    * @return
    */
   public static Feature createGroupFeature(Group parent, String name, String id) {
      Feature newFeature = createFeature(name, id);
      Group group = (Group) parent;
      group.getChildFeatures().add(newFeature);
      return newFeature;
   }

   /**
    * create a feature in a group
    * 
    * @param parent
    * @param name
    * @param id
    * @return
    */
   public static Feature createGroupFeature(Feature parent, String name, String id, String groupId) {
      Group parentgroup = null;
      EList<Group> groups = parent.getGroups();
      for (Group group : groups) {
         String parentFeatureGroupId = group.getId();
         if (groupId.equals(parentFeatureGroupId)){
            parentgroup = group;
            break;
         }
         
      }
      return createGroupFeature(parentgroup, name, id);
   }

   
   

   /**
    * create a single feature and a single group containing only the single feature.
    * 
    * @param node
    * @param name
    * @param id
    * @param optional
    * @return
    */
   public static Feature createSingleFeature(Feature parent, String name, String id, boolean optional, String groupId) {
      Group group = null;
      int min = (optional) ? 0 : 1;
      int max = 1;
      group = createFeatureGroup(parent, min, max, groupId);

      Feature newFeature = createFeature(name, id);
      group.getChildFeatures().add(newFeature);

      return newFeature;
   }

   /**
    * create a single feature and a single group containing only the single feature.
    * 
    * @param node
    * @param name
    * @param id
    * @param optional
    * @return
    */
   public static Feature createSingleFeature(Group parent, String name, String id) {
      Feature newFeature = createFeature(name, id);
      parent.getChildFeatures().add(newFeature);
      
      return newFeature;
   }

  
   /**
    * create the root feature
    * 
    * @param fm
    * @param rootName
    * @param id
    * @return
    */
   public static Feature createRootFeature(FeatureModel fm, String rootName, String id) {
      Feature feature = FeatureFactory.eINSTANCE.createFeature();
      feature.setName(rootName);
      EcoreUtil.setID(feature, id);
      // feature.setId(id);
      // createAttribute(feature, attribute_id, id, attribute_type_string);
      // root feature is mandatory
      fm.setRoot(feature);
      return feature;
   }


   /**
    * create a new imply constraint
    * @param left
    * @param right
    * @return
    */
   public static Constraint createImplyConstraint(Feature left, Feature right, String id){
      FeatureConstraint constraint = FeatureFactory.eINSTANCE.createImply();
      constraint.setLeftOperand(left);
      constraint.setRightOperand(right);
      constraint.setId(id);
      return constraint;
   }

   /**
    * create a new exclude constraint
    * @param left
    * @param right
    * @return
    */
   public static Constraint createExcludeConstraint(Feature left, Feature right, String id){
      FeatureConstraint constraint = FeatureFactory.eINSTANCE.createExclude();
      constraint.setLeftOperand(left);
      constraint.setRightOperand(right);
      constraint.setId(id);
      return constraint;
   }

  
   
   /**
    * create a new Attribute Constraint
    * @param left
    * @param right
    * @param id
    * @param operator
    * @return
    */
   public static Constraint createAttributeConstraint(AttributeOperand left, AttributeOperand right, String id, Relop operator){
      AttributeConstraint constraint = FeatureFactory.eINSTANCE.createAttributeConstraint();
      constraint.setOperator(operator);
      constraint.setAttribute1(left);
      constraint.setAttribute2(right);
      constraint.setId(id);
      return constraint;
   }
   
   
   public static AttributeOperand createAttibuteOperand(Attribute attribute){
      AttributeReference attributeReference = FeatureFactory.eINSTANCE.createAttributeReference();
      attributeReference.setAttribute(attribute);
      attributeReference.setFeature(attribute.getFeature());
      return attributeReference;
   }

   public static AttributeOperand createAttibuteOperand(String value, int intValue){
      AttributeValue attributeValue = FeatureFactory.eINSTANCE.createAttributeValue();
      attributeValue.setName(value);
      attributeValue.setInt(intValue);
      return attributeValue;
   }
   
   /**
    * save the feature model in the file system.
    * 
    * @param model
    * @param fileName
    */
   public static void persistFMFeatureModel(FeatureModel model, String fileName) {
      ResourceSet set = new ResourceSetImpl();
      URI modelURI = URI.createFileURI(fileName);
      Resource modelResource = set.createResource(modelURI);
      modelResource.getContents().add(model);
      try {
         modelResource.save(null);
         log.info("Featuremodel saved to " + fileName);
         ResourceUtil.refreshModelResource(modelResource);
      } catch (IOException e) {
         log.error("Could not save featuremodel to path " + fileName);
      }
   }

   private static String getRandomId() {
      String id = id_prefix;
      id += RandomStringUtils.randomNumeric(6);
      return id;
   }

   /**
    * add an attribute to a feature.
    * 
    * @param feature
    * @param name
    * @param value
    * @param type
    */
   public static void createAttribute(Feature feature, String name, String value, Domain attributeDomain) {
      Attribute attribute = FeatureFactory.eINSTANCE.createAttribute();
      attribute.setName(name);
      attribute.setValue(value);
      attribute.setDomain(attributeDomain);
      feature.getAttributes().add(attribute);
   }

   /**
    * set an attribute value. if the attribute does not exist, create it.
    * 
    * @param feature
    * @param name
    * @param value
    * @param type
    */
   public static void setAttribute(Feature feature, String name, String value, Domain attributeDomain) {
      // check if attribute is already available
      EList<Attribute> attributes = feature.getAttributes();
      boolean attrExists = false;
      for (Attribute attribute : attributes) {
         String attrName = attribute.getName();
         Feature attrFeature = attribute.getFeature();
         if (StringUtils.equals(attrName, name) && (EcoreUtil.equals(attrFeature, feature))) {
            attribute.setValue(value);
            attrExists = true;
            break;
         }
      }
      if (!attrExists) {
         createAttribute(feature, name, value, attributeDomain);
      }
   }

   public static List<Feature> getAllAchestorFeatures(Feature feature) {
      List<Feature> anchestors = new ArrayList<Feature>();
      Feature consideredFeature = feature;
      while (consideredFeature != null) {
         consideredFeature = getParentFeature(consideredFeature);
         if (consideredFeature != null) anchestors.add(consideredFeature);
      }
      return anchestors;
   }

   /**
    * get the parent feature of the given feature. May return null, if the given feature is the root feature.
    * 
    * @param childFeature
    * @return
    */
   public static Feature getParentFeature(Feature childFeature) {
      Feature parentFeature = null;
      if (childFeature != null) {
         EObject groupContainer = childFeature.eContainer();
         if (groupContainer != null && groupContainer instanceof Group) {
            Group parentGroup = (Group) groupContainer;
            parentFeature = (Feature) parentGroup.eContainer();
         }
      }
      return parentFeature;
   }

   /**
    * get an attribute by its name
    * 
    * @param feature
    * @param attributeName
    * @return
    */
   public static Attribute getAttribute(Feature feature, String attributeName) {
      Attribute attribute = null;
      EList<Attribute> attributes = feature.getAttributes();
      for (Attribute att : attributes) {
         String name = att.getName();
         if (StringUtils.equals(name, attributeName)) {
            attribute = att;
            break;
         }
      }
      return attribute;
   }

   /**
    * get all features contained in a feature model.
    * 
    * @param featuremodel
    * @return
    */
   public static Set<Feature> getAllFeatures(FeatureModel featuremodel) {
      FeatureModelHelper helper = new FeatureModelHelper(featuremodel);
      return helper.getAllFeatures();
   }

  
   /**
    * get featuremodel constraints
    * 
    * @param featuremodel
    * @param language
    * @return
    */
   public static List<Constraint> getConstraints(FeatureModel featuremodel, String language) {
      return featuremodel.getConstraints();
   }

   /**
    * initialize a featuremodel from an Ifile.
    * 
    * @param file
    * @return
    */
   public static FeatureModel getFeatureModel(IFile file, ResourceSet resourceSet) {
      FeatureModel featuremodel = null;
      EObject object = ResourceUtil.getModel(file, resourceSet);
      if (object instanceof FeatureModel) {
         featuremodel = (FeatureModel) object;
      }
      return featuremodel;
   }

   /**
    * Makes feature ids unique.
    * 
    * @param allFeatures
    */
   public static boolean makeFeatureIdsUnique(Set<Feature> allFeatures) {
      boolean isChanged = false;
      List<Feature> featuresToCompare = new ArrayList<Feature>(allFeatures.size());
      featuresToCompare.addAll(allFeatures);

      for (Feature current : allFeatures) {
         featuresToCompare.remove(current);
         for (Feature next : featuresToCompare) {
            String currentFeatureId = current.getId();
            String nextFeatureId = next.getId();
            if (currentFeatureId.equals(nextFeatureId)) {
                  int hash = current.hashCode();
                  currentFeatureId += hash;
               log.info("Feature id changed. Was: '" + current.getId() + "' Is: '" + currentFeatureId + "'.");
               current.setId(currentFeatureId);
               isChanged = true;
               break;
            }
         }
      }
      return isChanged;
   }

   /**
    * Makes feature names unique.
    * 
    * @param allFeatures
    */
   public static boolean makeFeatureIdsUnique(FeatureModel featureModel) {
      boolean isChanged = false;
      if (featureModel != null) {
         Set<Feature> allFeatures = getAllFeatures(featureModel);
         isChanged = makeFeatureIdsUnique(allFeatures);
      }
      return isChanged;
   }

}
