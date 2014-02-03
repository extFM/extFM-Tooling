package org.js.model.adaptation.ui;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.js.graph.transform.stagemodel.Stage;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.AccessControlModelUtil;
import org.js.model.workflow.util.StageModelUtil;

/**
 * Select only a stage, where - roles are assigned to direct predecessor stage - or stage is the first stage without a
 * role assigned to
 * 
 * @author Julia
 * 
 */
public class StageInputFilter extends ViewerFilter {

   private AccessControlModel accessControlModel;

   public StageInputFilter(AccessControlModel accessControlModel) {
      this.accessControlModel = accessControlModel;
   }

   @Override
   public boolean select(Viewer viewer, Object parentElement, Object element) {
      boolean result = false;

      if (element instanceof Stage) {
         Stage stage = (Stage) element;
         if (StageModelUtil.isFirstStage(stage)) {
            result = !isAnyRoleAssignedToStage(stage);
         } else {
            Stage predecessorStage = stage.getPredecessor();
            result = isAnyRoleAssignedToStage(predecessorStage);
         }
      }
      return result;
   }

   private boolean isAnyRoleAssignedToStage(Stage stage) {
      Role role = AccessControlModelUtil.getCorrespondingAbstractRole(stage, accessControlModel);
      EList<Role> childRoles = role.getChildRoles();
      boolean result = !childRoles.isEmpty();
      return result;
   }

}
