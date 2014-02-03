package org.js.model.adaptation.rules.add;

import org.eclipse.core.runtime.Assert;
import org.js.model.adaptation.AbstractAccessControlModelRewriteRule;
import org.js.model.adaptation.ui.UserInputAddRole;
import org.js.model.rbac.AccessControlModel;

public abstract class AbstractAccessControlAddRewriteRule extends AbstractAccessControlModelRewriteRule {

   protected UserInputAddRole input;

   public AbstractAccessControlAddRewriteRule(UserInputAddRole input, AccessControlModel accessControlModel) {
      super(accessControlModel);
      Assert.isNotNull(input);
      this.input = input;
   }

}
