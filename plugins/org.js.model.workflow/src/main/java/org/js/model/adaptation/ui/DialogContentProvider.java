package org.js.model.adaptation.ui;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.js.graph.transform.stagemodel.Stage;
import org.js.graph.transform.stagemodel.StageModel;
import org.js.model.rbac.Role;

public class DialogContentProvider implements IStructuredContentProvider {

   @Override
   public void dispose() {}

   @Override
   public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

   @Override
   public Object[] getElements(Object inputElement) {
      Object[] result = null;
      if (inputElement instanceof StageModel) {
         StageModel stageModel = (StageModel) inputElement;
         EList<Stage> stages = stageModel.getStages();
         result = stages.toArray(new Object[stages.size()]);
      } else if (inputElement instanceof RoleInput) {
         RoleInput owner = (RoleInput) inputElement;
         Set<Role> ownerRoles = owner.getRoles();
         result = ownerRoles.toArray(new Object[ownerRoles.size()]);
      }
      return result;
   }

}
