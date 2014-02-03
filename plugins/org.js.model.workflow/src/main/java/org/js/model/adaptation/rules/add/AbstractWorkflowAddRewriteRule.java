package org.js.model.adaptation.rules.add;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jwt.meta.model.core.Model;
import org.js.model.adaptation.AbstractWorkflowRewriteRule;
import org.js.model.adaptation.ui.UserInputAddRole;

public abstract class AbstractWorkflowAddRewriteRule extends AbstractWorkflowRewriteRule {

   protected UserInputAddRole input;

   public AbstractWorkflowAddRewriteRule(UserInputAddRole input, Model workflow) {
      super(workflow);
      Assert.isNotNull(input);
      this.input = input;
   }

}
