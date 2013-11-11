/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.utilities.FeatureMappingUtil;
import org.feature.model.utilities.FeatureModelInit;
import org.feature.multi.perspective.mapping.viewmapping.Mapping;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.CoreGroup;
import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * This class creates the views for every {@link Group} and the {@link CoreGroup} from the {@link GroupModel}.
 * 
 * @author Tim Winkelmann
 * 
 */
public class ViewCreator {

   private CoreGroup coreGroup;
   private EList<Mapping> mappings;
   private List<View> views;
   private List<Feature> mappedFeatures = new LinkedList<Feature>();

   public ViewCreator(MappingModel featureMapping) {
      init(featureMapping);
   }

   public ViewCreator(GroupModel groupModel, FeatureModel featureModel, MappingModel featureMapping){
      init(groupModel, featureModel, featureMapping);
   }
   
   private void init(GroupModel groupModel, FeatureModel featureModel, MappingModel featureMapping){
      setMappings(featureMapping.getMappings());
      setCoreGroup(groupModel.getCoreGroup());
      List<Feature> allFeatures = FeatureModelInit.getAllFeatures(featureModel);
      initViews(featureModel, allFeatures);
      
   }
   
   private void init(MappingModel featureMapping) {
      GroupModel groupModel = featureMapping.getViewModel();
      FeatureModel featureModel = featureMapping.getFeatureModel();
      init(groupModel, featureModel, featureMapping);
   }

   private void initViews(FeatureModel featureModel, List<Feature> allFeatures) {
      // <Name of Group, {@link Group}||{@link DefaultGroup}>
      List<EObject> listOfGroups = createMapOfGroups();
      views = createViews(listOfGroups, featureModel);
      for (View view : views) {
         if (view.getGroup().equals(coreGroup)) {
            allFeatures.removeAll(mappedFeatures);
            view.getFeatures().addAll(allFeatures);
         }
      }
   }

   public List<Feature> getUnmappedFeatures(FeatureModel featureModel) {
      List<Feature> unmapped = FeatureModelInit.getAllFeatures(featureModel);
      unmapped.removeAll(mappedFeatures);
      return unmapped;
   }

   /**
    * create the views
    * 
    * @param mapOfGroups
    */
   private List<View> createViews(List<EObject> groups, FeatureModel featureModel) {
      List<View> views = new LinkedList<View>();
      for (EObject group : groups) {
         views.add(new View(group, getFeatures(group), featureModel));
      }
      return views;
   }

   /**
    * finds the features mapped to the group. If no mapping exists the list will be empty.
    * 
    * @param group the {@link Group} or {@link CoreGroup}.
    * @return a set of features or an empty list.
    */
   private Set<Feature> getFeatures(EObject group) {
      Set<Feature> features = new HashSet<Feature>();
      for (Mapping mapping : getMappings()) {
         AbstractGroup viewgroup = mapping.getViewgroup();
         if (EcoreUtil.equals(viewgroup, group)){
            EList<Feature> mapFeatures = mapping.getFeatures();
            features.addAll(mapFeatures);
            mappedFeatures.addAll(mapFeatures);
         }
      }
         return features;
   }

   /**
    * creates a list of groups.
    * 
    * @return a list of groups.
    */
   private List<EObject> createMapOfGroups() {
      List<EObject> listOfGroups = new LinkedList<EObject>();
      listOfGroups.add(getCoreGroup());
      EList<Group> groups = getCoreGroup().getGroups();
      createMapOfGroups(groups, listOfGroups);
      return listOfGroups;
   }

   /**
    * used to create the map of groups.
    * 
    * @param groups the groups that will be added
    * @param listOfGroups the map.
    */
   private void createMapOfGroups(EList<Group> groups, List<EObject> listOfGroups) {
      for (Group group : groups) {
         listOfGroups.add(group);
         if (!group.getGroups().isEmpty()) {
            createMapOfGroups(group.getGroups(), listOfGroups);
         }
      }
   }

   /**
    * @return the views
    */
   public List<View> getViews() {
      return views;
   }

   public EList<Mapping> getMappings() {
      return mappings;
   }

   public void setMappings(EList<Mapping> mappings) {
      this.mappings = mappings;
   }

   public CoreGroup getCoreGroup() {
      return coreGroup;
   }

   public void setCoreGroup(CoreGroup coreGroup) {
      this.coreGroup = coreGroup;
   }
}
