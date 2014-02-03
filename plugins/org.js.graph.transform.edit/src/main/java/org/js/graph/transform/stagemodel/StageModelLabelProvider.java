package org.js.graph.transform.stagemodel;

import org.eclipse.jface.viewers.LabelProvider;


public class StageModelLabelProvider extends LabelProvider {

   @Override
   public String getText(Object element) {
      String label = "";
      if (element instanceof Stage) {
         Stage stage = (Stage) element;
         String name = stage.getName();
         String id = "<"+ stage.getId() + ">";
         if (name != null && !name.isEmpty()){
            label += name + " ";
         }
         label += id;
      } else {
         label = super.getText(element);
      }
      return label;
   }        
   
}
