/**
 * 
 */
package org.feature.multi.perspective.model.editor.util;

/**
 * A boolean flag used for notifications. E.g. for pre-consistency checks.
 * 
 * @author Tim Winkelmann
 * 
 */
public class Flag {

   private boolean flagged = false;
   private boolean changed = false;

   /**
    * @return the flagged
    */
   public boolean isFlagged() {
      return flagged;
   }

   /**
    * @param flagged the flagged to set
    */
   public void setFlagged(boolean flagged) {
      changed = true;
      this.flagged = flagged;
   }

   /**
    * @return the changed
    */
   public boolean isChanged() {
      return changed;
   }
}
