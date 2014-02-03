package org.js.model.adaptation.rules.remove;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jwt.meta.model.core.Model;
import org.js.model.adaptation.AbstractWorkflowRewriteRule;
import org.js.model.rbac.Role;


public abstract class AbstractWorkflowRemoveRewriteRule extends AbstractWorkflowRewriteRule{

   
   protected Role role;

   public AbstractWorkflowRemoveRewriteRule(Role role, Model workflow) {
      super(workflow);
      Assert.isNotNull(role);
      this.role = role;
   }
   
}
