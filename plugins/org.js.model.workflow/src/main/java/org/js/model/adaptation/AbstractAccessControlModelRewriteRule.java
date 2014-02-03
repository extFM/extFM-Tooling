package org.js.model.adaptation;

import org.eclipse.core.runtime.Assert;
import org.js.model.rbac.AccessControlModel;


abstract public class AbstractAccessControlModelRewriteRule implements IRewriteRule {

   protected AccessControlModel accessControlModel;

   public AbstractAccessControlModelRewriteRule(AccessControlModel accessControlModel) {
      Assert.isNotNull(accessControlModel);
      this.accessControlModel = accessControlModel;
   }
   
}
