/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.feature.edit;

import org.js.model.feature.Feature;
import org.js.model.feature.SelectedState;


/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 *
 */
public final class FeatureModelUtil {

   public static boolean isFeatureSelected(Feature feature){
      SelectedState selected = feature.getSelected();
      return SelectedState.SELECTED.equals(selected);
   }
   
   public static boolean isFeatureDeselected(Feature feature){
      SelectedState selected = feature.getSelected();
      return SelectedState.DESELECTED.equals(selected);
   }
}
