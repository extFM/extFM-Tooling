/**
 * 
 */
package org.js.model.feature.edit;

import org.eclipse.jface.viewers.LabelProvider;
import org.js.model.feature.DomainValue;
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
      } else if (element instanceof DomainValue){
         DomainValue value = (DomainValue) element;
         String stringValue = value.getName();
         int integerValue = value.getInt();
         label = stringValue + " (" + integerValue +")";
      }
      return label;
   }
   
   
}
