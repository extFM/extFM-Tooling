/**
 * 
 */
package org.feature.multi.perspective.generator.viewmodel;

import java.util.ArrayList;
import java.util.List;


/**
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 *
 */
public class ViewpointGroupWrapper {

   private String viewpointName;
   private List<String> groupIds = new ArrayList<String>();
   
   /**
    * constructor to create a new wrapper.
    * @param viewpointName
    */
   public ViewpointGroupWrapper(String viewpointName) {
      this.viewpointName = viewpointName;
   }
   
   /**
    * add a group where this viewpoint is assigned to.
    * @param groupId
    */
   public void addGroup(String groupId){
      getGroupIds().add(groupId);
   }
   
   
   /**
    * get the viewpoint id.
    * @return
    */
   public String getViewpointName() {
      return viewpointName;
   }
   
   /**
    * get all ids assigned to this viewpoint.
    * @return
    */
   public List<String> getGroupIds() {
      return groupIds;
   }
   
}
