/**
 * 
 */
package org.js.model.feature.quality.assurance.popup.actions;

import org.eclipse.jface.viewers.LabelProvider;
import org.js.model.feature.Feature;


/**
 * <code>LabelProvider</code> shows a meaningful label for a feature
 * 
 * @author Julia
 * 
 *
 */
public class FeatureLabelProvider extends LabelProvider {

   
   @Override
   public String getText(Object element) {
     String label = "";
      if (element instanceof Feature) {
         Feature feature = (Feature) element;
         label += feature.getName();
         label += " <" + feature.getId() + ">";
      }
      return label;
   }
   
   
}
