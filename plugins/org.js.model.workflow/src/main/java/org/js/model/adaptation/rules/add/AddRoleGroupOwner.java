package org.js.model.adaptation.rules.add;

import org.js.graph.transform.stagemodel.Stage;
import org.js.graph.transform.stagemodel.StageModel;
import org.js.model.adaptation.IRewriteRule;
import org.js.model.adaptation.ui.UserInputAddRole;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.RbacFactory;
import org.js.model.rbac.Role;
import org.js.model.workflow.util.StageModelUtil;


public class AddRoleGroupOwner extends AbstractAccessControlAddRewriteRule {

   private StageModel stageModel;
   
   public AddRoleGroupOwner(UserInputAddRole input, AccessControlModel accessControlModel, StageModel stageModel) {
      super(input, accessControlModel);
      this.stageModel = stageModel;
   }

   @Override
   public int execute() {
      if (!isLastStage()){
         addRoleGroup();
      }
      return IRewriteRule.OK;
   }

   private boolean isLastStage() {
      String stageId = input.getAbstractParentRole().getId();
      Stage stage = StageModelUtil.getStageForId(stageId, stageModel);
      return StageModelUtil.isLastStage(stage);
   }

   private void addRoleGroup() {
      Role newRole = input.getNewRole();
      Group roleGroup = createRoleGroup();
      roleGroup.setId(newRole.getId());
      roleGroup.setName(newRole.getName() + "Group");
      roleGroup.setOwner(newRole);
   }

   
   private Group createRoleGroup(){
      Group group = RbacFactory.eINSTANCE.createGroup();
      accessControlModel.getGroups().add(group);
      return group;
   }
   
}
