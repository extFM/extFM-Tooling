package org.feature.multi.perspective.model.editor.editors;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.editor.util.Flag;
import org.feature.multi.perspective.model.editor.util.Util;
import org.featuremapper.models.feature.Feature;
import org.featuremapper.models.feature.FeatureModel;

/**
 * This class represents a mapping between a {@link Group} from the {@link GroupModel} and a {@link Set} of
 * {@link Feature}.
 * 
 * @author Tim Winkelmann
 * 
 */
public class View {

   // private static Logger log = Logger.getLogger(View.class);
   private EObject group;
   private Set<Feature> features;
   private FeatureModel featureModel;
   private boolean isConsistent;

   /**
    * @param group
    * @param features
    */
   public View(EObject group, Set<Feature> features, FeatureModel featureModel) {
      super();
      this.group = group;
      this.features = features;
      this.featureModel = featureModel;
      checkConsistency();
   }

   /**
    * checks if the view can be used as a viewpoint
    * 
    * @return true if this is a viewpoint.
    */
   public boolean isViewPoint() {
      if (this.group instanceof Group) {
         Group group = (Group) this.group;
         return !group.getViewPointReference().isEmpty();
      } else {
         return false;// core group
      }
   }

   /**
    * checks the hierarchy of the features, the cardinalities and the constraint.
    * 
    * @return true if no violation is found.
    */
   private boolean checkConsistency() {
      Flag f = new Flag();
      FeatureModel view = Util.createFeatureModel(featureModel, features, f);
      if (f.isChanged() && f.isFlagged()) {
         isConsistent = false;
      } else {
         isConsistent = Util.isConsistent(view);
      }
      return isConsistent();
   }

   public boolean isConsistent() {
      return isConsistent;
   }

   /**
    * @return the group
    */
   public EObject getGroup() {
      return group;
   }

   /**
    * @return the features
    */
   public Set<Feature> getFeatures() {
      return features;
   }

   /**
    * @return the featureModel
    */
   public FeatureModel getFeatureModel() {
      return featureModel;
   }
}
