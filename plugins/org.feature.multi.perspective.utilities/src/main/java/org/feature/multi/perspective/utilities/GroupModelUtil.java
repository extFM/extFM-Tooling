/**
 * 
 */
package org.feature.multi.perspective.utilities;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.CoreGroup;
import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.model.viewmodel.ViewPointContainer;

/**
 * 
 * Utility class for commonly used GroupModel access and modification methods.
 * 
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public final class GroupModelUtil {

   /**
    * get all groups contained in the groupmodel.
    * 
    * @param grupModel
    * @return list containing all groups
    */
   public static List<AbstractGroup> getAllGroups(GroupModel groupModel, boolean containCoreGroup) {
      List<AbstractGroup> result = new ArrayList<AbstractGroup>();
      CoreGroup core = groupModel.getCoreGroup();
      if (core != null) {
         if (containCoreGroup){
            result.add(core);
         }
         result.addAll(getGroups(core));
      }
      return result;
   }

   private static List<AbstractGroup> getGroups(AbstractGroup parent) {
      List<AbstractGroup> result = new ArrayList<AbstractGroup>();
      EList<Group> groups = parent.getGroups();
      result.addAll(groups);
      for (AbstractGroup group : groups) {
         result.addAll(getGroups(group));
      }
      return result;
   }

  /**
   * Get a viewpoint from the groupmodel by name. 
   * @param viewpointName
   * @param groupModel
   * @return
   */
   public static ViewPoint getViewpointByName(String viewpointName, GroupModel groupModel) {
      ViewPoint viewpoint = null;
      ViewPointContainer container = groupModel.getViewPointContainer();
      for (ViewPoint vp : container.getViewPoints()) {
         if (viewpointName.equals(vp.getName())) {
            viewpoint = vp;
            break;
         }
      }
      return viewpoint;
   }
   
   /**
    * get the Ecore GroupModel instance from a GroupModel resource.
    * @param resource
    * @return
    */
   public static GroupModel getGroupModel(Resource resource){
      GroupModel groupModel = null;
      if (resource.isLoaded()){
         EList<EObject> contents = resource.getContents();
         for (EObject eObject : contents) {
            if (eObject instanceof GroupModel) {
               groupModel = (GroupModel) eObject;
               break;
            }
         }
      }
      return groupModel;
   }
   
   /**
    * gets all direct and indirect parent groups related to the given group in the view model hierarchy including the given group.
    * @param group
    * @return list of all parent view groups including the given view group itself.
    */
   public static List<AbstractGroup> getAllAnchestorGroups(AbstractGroup group){
      List<AbstractGroup> anchestorGroups = new ArrayList<AbstractGroup>();
      getAllAnchestorGroupsInternal(anchestorGroups, group);
      return anchestorGroups;
   }
   
   private static void getAllAnchestorGroupsInternal(List<AbstractGroup> anchestorGroups, AbstractGroup group){
      if (group != null){
         anchestorGroups.add(group);
         AbstractGroup parent = getParent(group);
         getAllAnchestorGroupsInternal(anchestorGroups, parent);
      }
   }
   
   private static AbstractGroup getParent(AbstractGroup origGroup){
      AbstractGroup parentGroup = null;
      if (origGroup instanceof Group) {
         Group group = (Group) origGroup;
         parentGroup = group.getParentGroup();
      }
      return parentGroup;
   }
   
   
}
