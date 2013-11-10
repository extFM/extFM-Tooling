/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.rbac.resource.rbactext.analysis;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Permission;
import org.js.model.rbac.RBACResolverUtil;

public class RolePermissionsReferenceResolver implements
      org.js.model.rbac.resource.rbactext.IRbactextReferenceResolver<org.js.model.rbac.Role, org.js.model.rbac.Permission> {

   private org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.Role, org.js.model.rbac.Permission> delegate =
      new org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.Role, org.js.model.rbac.Permission>();

   public void resolve(String identifier, org.js.model.rbac.Role container, org.eclipse.emf.ecore.EReference reference, int position,
                       boolean resolveFuzzy,
                       final org.js.model.rbac.resource.rbactext.IRbactextReferenceResolveResult<org.js.model.rbac.Permission> result) {
      // identifier looks like "select f2"
      AccessControlModel model = (AccessControlModel) EcoreUtil.getRootContainer(container);
      Permission permission = RBACResolverUtil.findPermission(model, identifier);
      if (permission != null) {
         result.addMapping(identifier, permission);
      } else
         delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
   }

   public String deResolve(org.js.model.rbac.Permission element, org.js.model.rbac.Role container,
                           org.eclipse.emf.ecore.EReference reference) {
      String identifier = RBACResolverUtil.getPermissionIdentifier(element);
      if (identifier == null){
         identifier = delegate.deResolve(element, container, reference);
      }
      return identifier;
   }

   public void setOptions(java.util.Map< ? , ? > options) {
      // save options in a field or leave method empty if this resolver does not depend
      // on any option
   }
}
