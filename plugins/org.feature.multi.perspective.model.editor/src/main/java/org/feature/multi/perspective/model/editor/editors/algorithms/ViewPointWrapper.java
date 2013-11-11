/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors.algorithms;

import org.feature.multi.perspective.model.viewmodel.ViewPoint;

/**
 * @author <a href=mailto:info@juliaschroeter.de>Julia Schroeter</a>
 * 
 */
public class ViewPointWrapper {

   boolean isConsistent;
   private final ViewPoint viewpoint;

   public ViewPointWrapper(ViewPoint viewpoint, boolean isConsistent) {
      this.viewpoint = viewpoint;
      this.isConsistent = isConsistent;
   }

   /**
    * return the name of the viewpoint.
    * @return
    */
   public String getVpName() {
      return viewpoint.getName();
   }

   /**
    * return whether the viewpoint is consistent.
    * @return tru if consistent
    */
   public boolean isConsistent() {
      return isConsistent;
   }

   @Override
   public String toString() {
      return getVpName() + "[" + isConsistent + "]";
   }

}
