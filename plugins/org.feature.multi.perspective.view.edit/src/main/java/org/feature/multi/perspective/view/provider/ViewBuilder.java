package org.feature.multi.perspective.view.provider;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.feature.model.constraint.FeatureExpression;
import org.feature.model.csp.TextExpressionParser;
import org.feature.model.utilities.FeatureMappingUtil;
import org.feature.model.utilities.GroupModelUtil;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.view.View;
import org.feature.multi.perspective.view.ViewContainer;
import org.feature.multi.perspective.view.ViewFactory;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * create all views specified by the given viewmapping.
 * 
 * @author <a href=mailto:julia.schroeter@tu-dresden.de>Julia Schroeter</a>
 * 
 */
public class ViewBuilder {

   private ViewContainer viewContainer;

   private Set<FeatureExpression> featureModelConstraints;

   private boolean considerViewHierarchy;

   public ViewBuilder(MappingModel viewMapping, boolean initViews, boolean considerViewHierarchy) {
      this.considerViewHierarchy = considerViewHierarchy;
      init(initViews, viewMapping);
   }

   private void init(boolean initViews, MappingModel viewMapping) {
      viewContainer = ViewFactory.eINSTANCE.createViewContainer();
      viewContainer.setFeatureMapping(viewMapping);

      initConstraints(viewMapping.getFeatureModel());

      if (initViews) {
         createAllViews();
      }
   }

   private void initConstraints(FeatureModel featuremodel) {
      featureModelConstraints = TextExpressionParser.getConstraints(featuremodel);
   }

   public Set<FeatureExpression> getConstraints() {
      return featureModelConstraints;
   }

   private void createAllViews() {
      GroupModel viewModel = viewContainer.getFeatureMapping().getViewModel();
      List<AbstractGroup> allGroups = GroupModelUtil.getAllGroups(viewModel, true);
      for (AbstractGroup abstractGroup : allGroups) {
         List<AbstractGroup> groups = new ArrayList<AbstractGroup>(1);
         groups.add(abstractGroup);
         createView(groups);
      }

   }

   /**
    * get the mapping model used to determine views.
    * 
    * @return
    */
   public MappingModel getViewMapping() {
      return viewContainer.getFeatureMapping();
   }

   /**
    * get all created views;
    * 
    * @return
    */
   public List<View> getAllViews() {
      return viewContainer.getViews();
   }

   /**
    * get the according view, i.e., a set of features for the given view group.
    * 
    * @param group
    * @return
    */
   public View getView(AbstractGroup group) {
      List<AbstractGroup> cache = new ArrayList<AbstractGroup>();
      cache.add(group);
      View view = getViewInternal(cache);
      if (view == null) {
         view = createView(cache);
      }
      return view;
   }

   public View getView(List<AbstractGroup> groups) {
      View view = getViewInternal(groups);
      if (view == null) {
         view = createView(groups);
      }
      return view;
   }

   private View getViewInternal(List<AbstractGroup> groups) {
      View view = null;
      EList<View> views = viewContainer.getViews();
      for (View cview : views) {
         EList<AbstractGroup> viewgroups = cview.getViewgroups();
         if (groups.size() == viewgroups.size() && 
          viewgroups.containsAll(groups))
               view = cview;
               break;
            }
      return view;
   }


   private void clearAllViews() {
      viewContainer.getViews().clear();
   }

   private String getGroupsName(List<AbstractGroup> groups){
      String name = "";
      for (AbstractGroup abstractGroup : groups) {
         name += "_" + abstractGroup.getName();
      }
      return name;
   }
   
   private View createView(List<AbstractGroup> groups) {
      View view = ViewFactory.eINSTANCE.createView();
      view.getViewgroups().addAll(groups);
      view.setId(getGroupsName(groups));
      EList<Feature> features = view.getFeatures();
      MappingModel viewMapping = viewContainer.getFeatureMapping();
      Set<Feature> collectedFeatures = new HashSet<Feature>();

      for (AbstractGroup group : groups) {
      if (considerViewHierarchy) {
         collectedFeatures.addAll(FeatureMappingUtil.collectViewFeatures(group, viewMapping));
      } else {
         collectedFeatures.addAll(FeatureMappingUtil.getGroupFeatures(group, viewMapping));
      }
      features.addAll(collectedFeatures);
      }

      viewContainer.getViews().add(view);
      return view;
   }

   /**
    * check if the given feature is contained in the view belonging to the given viewgroup.
    * 
    * @param feature
    * @param viewgroup
    * @return
    */
   public boolean isFeatureContained(Feature feature, AbstractGroup viewgroup) {
      View view = getView(viewgroup);
      return view.getFeatures().contains(feature);
   }

}
