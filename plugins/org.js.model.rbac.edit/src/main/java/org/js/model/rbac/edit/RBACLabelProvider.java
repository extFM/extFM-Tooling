package org.js.model.rbac.edit;

import org.eclipse.jface.viewers.LabelProvider;
import org.js.model.rbac.Role;

public class RBACLabelProvider extends LabelProvider {

   @Override
   public String getText(Object element) {
      String label = "";
      if (element instanceof Role) {
         Role role = (Role) element;
         String name = role.getName();
         if (name != null && !name.isEmpty()) {
            label += name + " ";
         }
         String id = "<" + role.getId() + ">";
         label += id;
      } else {
         label = super.getText(element);
      }
      return label;
   }
   
}
