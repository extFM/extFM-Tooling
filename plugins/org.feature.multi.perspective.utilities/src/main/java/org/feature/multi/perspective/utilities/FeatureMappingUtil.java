/**
 * 
 */
package org.feature.multi.perspective.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.utilities.ResourceUtil;
import org.feature.multi.perspective.mapping.viewmapping.Mapping;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.js.model.feature.Feature;

/**
 * Utility class for accessing the featuremapping models.
 * 
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public final class FeatureMappingUtil {
   

   public static MappingModel getFeatureMapping(IFile featureMapping, ResourceSet resourceSet) {
      MappingModel mapping = null;
      EObject model = ResourceUtil.getModel(featureMapping, resourceSet);
      if (model instanceof MappingModel) {
         mapping = (MappingModel) model;
      }
      return mapping;
   }

   public static MappingModel getFeatureMapping(Resource resource) {
      MappingModel featureMappingModel = null;
      if (resource != null) {
         EList<EObject> contents = resource.getContents();
         for (EObject eObject : contents) {
            if (eObject instanceof MappingModel) {
               featureMappingModel = (MappingModel) eObject;
               break;
            }
         }
      }
      return featureMappingModel;
   }

  
   /**
    * Collects all features that will be contained in the view that is associated with the given group.
    * @param viewgroup
    * @param mappingModel
    * @return list of features belonging to the view defined by the given group.
    */
   public static List<Feature> collectViewFeatures(AbstractGroup viewgroup, MappingModel mappingModel) {
      List<AbstractGroup> allgroups = GroupModelUtil.getAllAnchestorGroups(viewgroup);

      List<Feature> features = new ArrayList<Feature>();
      for (AbstractGroup group : allgroups) {
         Mapping parentMapping = getMapping(group, mappingModel);
         if (parentMapping != null) {
            features.addAll(parentMapping.getFeatures());
         }
      }
      return features;
   }

   /**
    *  get the features that are mapped to the given group
    *  
    * @param group
    * @param mappingModel
    * @return
    */
   public static List<Feature> getGroupFeatures(AbstractGroup group, MappingModel mappingModel){
      List<Feature> features = new ArrayList<Feature>();
     Mapping mapping = FeatureMappingUtil.getMapping(group, mappingModel);
     if (mapping != null){
        features.addAll(mapping.getFeatures());
     }
     return features;
   }
   
   
   /**
    * find the mapping in the mapping model that belongs to the given group. May return null, if no direct mapping is specified.
    * @param group
    * @param mappingmodel
    * @return mapping referring to the given group. May return null if no explicit mapping specified.
    */
   public static Mapping getMapping(AbstractGroup group, MappingModel mappingmodel) {
      Mapping result = null;
      EList<Mapping> mappings = mappingmodel.getMappings();
      for (Mapping mapping : mappings) {
         AbstractGroup viewgroup = mapping.getViewgroup();
         if (EcoreUtil.equals(group, viewgroup)) {
            result = mapping;
            break;
         }
      }
      return result;
   }
   
}
