/**
 * 
 */
package org.feature.multi.perspective.generator.viewmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.model.utilities.ResourceUtil;
import org.feature.multi.perspective.mapping.viewmapping.Mapping;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.CoreGroup;
import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.model.viewmodel.ViewPointContainer;
import org.feature.multi.perspective.model.editor.editors.View;
import org.feature.multi.perspective.model.editor.editors.ViewCreator;
import org.feature.multi.perspective.model.editor.editors.algorithms.BruteForceAlgorithm;
import org.feature.multi.perspective.model.editor.editors.algorithms.IncrementalAlgorithm;
import org.feature.multi.perspective.utilities.GroupModelUtil;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.csp.FeatureModelAnalyzer;
import org.js.model.feature.csp.FeatureVariant;


/**
 * Generates mappings between a featuremodel and a cluster model.
 * 
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class FeatureMappingGenerator extends AbstractGenerator {

   private static Logger log = Logger.getLogger(FeatureMappingGenerator.class);

   private int generatedConsistentVPs = 0;
   private boolean isCanceled = false;
   private int attempts = 0;

   /**
    * generate the mapping by combining all featuremodels with all clustermodels in the generated project. Be aware of
    * when creating consistent mappings, the groupmodelis modified and must be persisted afterwards.
    */
   public void generateMapping(boolean consistent, boolean reuseFeatureMapping) {
      ResourceSet set = new ResourceSetImpl();
      List<FeatureModel> fms = getAllFeatureModels(set);
      List<GroupModel> vms = getAllViewModels(set);
      for (FeatureModel featureModel : fms) {
         FeatureModelAnalyzer analyzer = new FeatureModelAnalyzer(featureModel);
         for (int featuresPerGroup : assignedFeaturesPerGroup) {
            if (reuseFeatureMapping) {
               // create the largest valid featuremapping and reuse it for all groupmodels
               generateAndReuseFeatureMapping(set, featureModel, featuresPerGroup, analyzer, consistent);
               if (isCanceled) {
                  log.info("No mapping created. The process was cancelled due to a time out.");
                  return;
               }
            } else {
               // generate a new featuremapping for every group model
               for (GroupModel groupModel : vms) {
                  generateMapping(featureModel, groupModel, featuresPerGroup, analyzer, false, consistent);
                  if (isCanceled) {
                     log.info("No mapping created. The process was cancelled due to a time out.");
                     return;
                  }
               }
            }
         }
      }
   }

   private void resetCancelled() {
      isCanceled = false;
      generatedConsistentVPs = 0;
   }

   private void generateAndReuseFeatureMapping(ResourceSet set, FeatureModel featureModel, int featuresPerGroup,
                                               FeatureModelAnalyzer analyzer, boolean consistent) {
      List<GroupModel> allGroupModels = getAllViewModels(set);
      // find highest number of viewpoints a featuremapping will be generated for
      GroupModel largestGroupModel = findGroupModelWithMostViewpoints(allGroupModels);
      allGroupModels.remove(largestGroupModel);

      // generate persisted largest featuremapping
      MappingModel largestMapping =
         generateLargestMapping(featureModel, largestGroupModel, featuresPerGroup, analyzer, consistent, false);
      if (!isCanceled) {
      // create wrapping viewpoint-group instances
      List<ViewpointGroupWrapper> viewpointGroups = getWrappedViewpoints(largestGroupModel);
      for (GroupModel gModel : allGroupModels) {
         // for every groupmodel copy viewpount-group assignments
         //copyViewpointGroupAssignment(gModel, viewpointGroups);
         //saveGroupModel(gModel);
         // copy the largest feature mapping and change references to each other groupmodel
         MappingModel mappingCopy = EcoreUtil.copy(largestMapping);
         exchangeGroupModel(mappingCopy, gModel);
         exchangeElementMappings(mappingCopy, gModel);
         // persist new featuremapping
         saveFeatureMapping(mappingCopy, featureModel, gModel, featuresPerGroup);
         }
      }
   }

   private MappingModel generateLargestMapping(FeatureModel featureModel, GroupModel largestGroupModel, int featuresPerGroup,
                                                      FeatureModelAnalyzer analyzer, boolean bruteforceConsistent,
                                                      boolean heuristicConsistent) {
      log.info("Try to generate largest feature mapping and reuse it.");
      if (attempts > 10) {
         isCanceled = true;
         log.info("Generating cancelled because number of maximal attemps reached.");
         return null;
      }
      MappingModel largestMapping =
         generateMapping(featureModel, largestGroupModel, featuresPerGroup, analyzer, bruteforceConsistent, heuristicConsistent);
      if (isCanceled) {
         resetCancelled();
         attempts++;
         // try to regenerate mapping
         return generateLargestMapping(featureModel, largestGroupModel, featuresPerGroup, analyzer, bruteforceConsistent,
                                       heuristicConsistent);
      }
      return largestMapping;
   }

   private void exchangeElementMappings(MappingModel mappingCopy, GroupModel groupModel) {
      List<AbstractGroup> allGroups = GroupModelUtil.getAllGroups(groupModel, false);
      EList<Mapping> mappings = mappingCopy.getMappings();
      for (Mapping mapping : mappings) {
         EObject element = mapping.getViewgroup();
         if (element instanceof CoreGroup) {
            mapping.setViewgroup(groupModel.getCoreGroup());
         } else if (element instanceof Group) {
            Group oldGroup = (Group) element;
            String oldGroupName = oldGroup.getName();
            for (AbstractGroup newGroup : allGroups) {
               if (newGroup.getName().equals(oldGroupName)) {
                  mapping.setViewgroup(newGroup);
                  break;
               }
            }
         }
      }

   }

   private void exchangeGroupModel(MappingModel mappingCopy, GroupModel groupModel) {
      mappingCopy.setViewModel(groupModel);
   }

   private void copyViewpointGroupAssignment(GroupModel groupModel, List<ViewpointGroupWrapper> viewpointGroups) {
      ViewModelGenerator vmGenerator = new ViewModelGenerator();
      // all groups except the coregroup
      List<AbstractGroup> allGroups = GroupModelUtil.getAllGroups(groupModel, true);
      EList<ViewPoint> viewpoints = groupModel.getViewPointContainer().getViewPoints();
      for (ViewPoint viewpoint : viewpoints) {
         for (ViewpointGroupWrapper viewpointGroupWrapper : viewpointGroups) {
            String vpName = viewpointGroupWrapper.getViewpointName();
            if (vpName.equals(viewpoint.getName())) {
               vmGenerator.removeViewPointFromGroups(viewpoint);
               List<String> groupIds = viewpointGroupWrapper.getGroupIds();
               assignVPtoGroups(viewpoint, groupIds, allGroups);
               break;
            }
         }
      }
   }

   private void assignVPtoGroups(ViewPoint viewPoint, List<String> groupIds, List<AbstractGroup> allGroups) {
      for (String string : groupIds) {
         for (AbstractGroup group : allGroups) {
            if (group.getName().equals(string)) {
               group.getViewPointReference().add(viewPoint);
               break;
            }
         }
      }
   }

   private List<ViewpointGroupWrapper> getWrappedViewpoints(GroupModel groupModel) {
      EList<ViewPoint> viewPoints = groupModel.getViewPointContainer().getViewPoints();
      List<ViewpointGroupWrapper> viewpointGroupWrappers = new ArrayList<ViewpointGroupWrapper>(viewPoints.size());
      for (ViewPoint viewPoint : viewPoints) {
         String vpName = viewPoint.getName();
         ViewpointGroupWrapper wrapper = new ViewpointGroupWrapper(vpName);
         EList<AbstractGroup> assignedGroups = viewPoint.getContainedInGroup();
         for (AbstractGroup group : assignedGroups) {
            String groupName = group.getName();
            wrapper.addGroup(groupName);
         }
         viewpointGroupWrappers.add(wrapper);
      }
      return viewpointGroupWrappers;
   }

   private GroupModel findGroupModelWithMostViewpoints(List<GroupModel> allGroupModels) {
      GroupModel groupModel = null;
      int highestVPCount = 0;
      for (GroupModel model : allGroupModels) {
         ViewPointContainer viewPointContainer = model.getViewPointContainer();
         if (viewPointContainer != null) {
            List<ViewPoint> viewPoints = viewPointContainer.getViewPoints();
            int size = viewPoints.size();
            if (size > highestVPCount) {
               highestVPCount = size;
               groupModel = model;
            }
         }
      }
      return groupModel;
   }


   private MappingModel generateMapping(FeatureModel fm, GroupModel groupModel, int assignedFeatureCount,
                                               FeatureModelAnalyzer analyzer, boolean bruteforceConsistent, boolean heuristicConsistent) {
      MappingModel featuremapping = ViewmappingFactory.eINSTANCE.createMappingModel();
      featuremapping.setFeatureModel(fm);
      featuremapping.setViewModel(groupModel);

      // map variant features to core group
      FeatureVariant variant = analyzer.getOneVariant();
      log.info("Core Group Features " + variant);

      Set<Feature> variantFeatures = variant.getFeatures();
      CoreGroup coreGroup = groupModel.getCoreGroup();
      Mapping coremapping = createCoreFeatureMapping(variantFeatures, coreGroup);
      featuremapping.getMappings().add(coremapping);
      boolean isCoreViewPointValid =
         isVPValidBruteforce(GroupModelUtil.getViewpointByName(coreViewpointName, groupModel), fm, groupModel, featuremapping);
      log.info("Core Viewpoint is valid: " + isCoreViewPointValid);
      // map all other features somewhere
      Set<Feature> variableFeatures = analyzer.getAllFeatures();
      List<AbstractGroup> allGroups = GroupModelUtil.getAllGroups(groupModel, false);
      createVariableFeatureMapping(variableFeatures, allGroups, featuremapping, assignedFeatureCount);
      mapUnmappedFeatures(featuremapping, groupModel);

      if (bruteforceConsistent) {
         checkMappingBruteForce(groupModel, featuremapping, fm);
      } else if (heuristicConsistent) {
         checkMappingHeuristic(groupModel, featuremapping, fm);
      }
      if (!isCanceled) {
         saveGroupModel(groupModel);
         saveFeatureMapping(featuremapping, fm, groupModel, assignedFeatureCount);
      }
      return featuremapping;
   }

   private void saveFeatureMapping(MappingModel featureMapping, FeatureModel featureModel, GroupModel groupModel,
                                   int assignedFeatureCount) {
      String fmFile = ResourceUtil.getFile(featureModel.eResource()).getName();
      String viewModelFile = ResourceUtil.getFile(groupModel.eResource()).getName();
      String type = fmFile + "_" + viewModelFile + param_FCount + assignedFeatureCount;
      persistModel(featureMapping, type, "mtext", mappingFolder);
   }

   private void mapUnmappedFeatures(MappingModel featureMapping, GroupModel groupModel) {
      FeatureModel featureModel = featureMapping.getFeatureModel();
      List<AbstractGroup> allGroups = GroupModelUtil.getAllGroups(groupModel, false);
      ViewCreator viewCreator = new ViewCreator(groupModel, featureModel, featureMapping);
      Set<Feature> unmapped = viewCreator.getUnmappedFeatures(featureModel);
      EList<Mapping> mappings = featureMapping.getMappings();

      for (Feature feature : unmapped) {
         int index = getRandomGenerator().nextInt(allGroups.size() - 1);
         AbstractGroup group = allGroups.get(index);
         Mapping elementMapping = ViewmappingFactory.eINSTANCE.createMapping();
         elementMapping.setViewgroup(group);
         elementMapping.getFeatures().add(feature);
         mappings.add(elementMapping);
      }
   }

   private void checkMappingBruteForce(GroupModel groupModel, MappingModel featureMapping, FeatureModel featureModel) {
      List<ViewPoint> viewPoints = groupModel.getViewPointContainer().getViewPoints();
      for (ViewPoint viewPoint : viewPoints) {
         if (!coreViewpointName.equals(viewPoint.getName())) {
            exchangeViewpoint(viewPoint, featureModel, groupModel, featureMapping, false);
            if (isCanceled) {
               break;
            }
         }
      }
   }

   private void checkMappingHeuristic(GroupModel groupModel, MappingModel featureMapping, FeatureModel featureModel) {
      List<ViewPoint> viewPoints = groupModel.getViewPointContainer().getViewPoints();
      for (ViewPoint viewPoint : viewPoints) {
         if (!coreViewpointName.equals(viewPoint.getName())) {
            exchangeViewpoint(viewPoint, featureModel, groupModel, featureMapping, true);
            if (isCanceled) {
               break;
            }
         }
      }
   }

   private void exchangeViewpoint(ViewPoint viewpoint, FeatureModel featureModel, GroupModel groupModel,
                                  MappingModel featureMapping, boolean useHeuristic) {

      ViewModelGenerator generator = new ViewModelGenerator();
      boolean isValid = false;
      if (useHeuristic) {
         isValid = isVPValidHeuristic(viewpoint, featureModel, groupModel, featureMapping);
      } else {
         isValid = isVPValidBruteforce(viewpoint, featureModel, groupModel, featureMapping);
      }

      // time out set to 20 sek.
      long endTimeMillis = System.currentTimeMillis() + 30000;

      while (!isValid && !isCanceled) {
        // saveFeatureMapping(featureMapping, featureModel, groupModel, 5);
         generator.exchangeViewpoint(viewpoint, groupModel);
         if (useHeuristic) {
            isValid = isVPValidHeuristic(viewpoint, featureModel, groupModel, featureMapping);
         } else {
            isValid = isVPValidBruteforce(viewpoint, featureModel, groupModel, featureMapping);
         }
         if (System.currentTimeMillis() > endTimeMillis && generatedConsistentVPs == 0) {
            isCanceled = true;
         }
      }
      if (isValid) {
         generatedConsistentVPs++;

         String logMsg = "FeatureMappingGen ";
         logMsg += viewpoint.getName();
         logMsg += " contained in ";
         EList<AbstractGroup> containedInGroup = viewpoint.getContainedInGroup();
         for (AbstractGroup group : containedInGroup) {
            logMsg += group.getName() + ", ";
         }
         log.info(logMsg);
      }
   }

   private boolean isVPValidBruteforce(ViewPoint vp, FeatureModel featureModel, GroupModel groupModel, MappingModel featureMapping) {
      boolean result = false;
      ViewCreator viewCreator = new ViewCreator(groupModel, featureModel, featureMapping);
      List<View> views = viewCreator.getViews();
      BruteForceAlgorithm bruteForce = new BruteForceAlgorithm(groupModel, views, featureModel);
      result = bruteForce.isViewpointConsistent(vp);
      log.debug(vp.getName() + " is valid in bruteforce: " + result);
      return result;
   }

   private boolean isVPValidHeuristic(ViewPoint vp, FeatureModel featureModel, GroupModel groupModel, MappingModel featureMapping) {
      boolean result = false;
      ViewCreator viewCreator = new ViewCreator(groupModel, featureModel, featureMapping);
      List<View> views = viewCreator.getViews();
      IncrementalAlgorithm incremental = new IncrementalAlgorithm(groupModel, views, featureModel);
      result = incremental.checkViewPoint(vp);
      log.debug(vp.getName() + " is valid in bruteforce: " + result);
      return result;
   }

   private Mapping createCoreFeatureMapping(Set<Feature> coreFeatures, CoreGroup coreGroup) {
      Mapping elementMapping = ViewmappingFactory.eINSTANCE.createMapping();
      elementMapping.setViewgroup(coreGroup);
      elementMapping.getFeatures().addAll(coreFeatures);
      return elementMapping;
   }

   private void createVariableFeatureMapping(Set<Feature> variableFeatures, List<AbstractGroup> allGroups, MappingModel featuremapping,
                                             int assignedFeatureCount) {
      EList<Mapping> mappings = featuremapping.getMappings();
      int numberFeatures = variableFeatures.size();
      Feature[] featureArray = variableFeatures.toArray(new Feature[numberFeatures]);
      
      if (numberFeatures > assignedFeatureCount) {
         for (AbstractGroup group : allGroups) {
            int randomFeatureCount = 0;
            while (randomFeatureCount == 0) {
               randomFeatureCount = getRandomGenerator().nextInt(assignedFeatureCount);
            }
            List<Feature> features = new ArrayList<Feature>(randomFeatureCount);
            for (int i = 0; i < randomFeatureCount; i++) {
               int index = getRandomGenerator().nextInt(numberFeatures - 1);
               features.add(featureArray[index]);
            }
            Mapping elementMapping = ViewmappingFactory.eINSTANCE.createMapping();
            elementMapping.setViewgroup(group);
            elementMapping.getFeatures().addAll(features);
            mappings.add(elementMapping);
         }
      }
   }



}
