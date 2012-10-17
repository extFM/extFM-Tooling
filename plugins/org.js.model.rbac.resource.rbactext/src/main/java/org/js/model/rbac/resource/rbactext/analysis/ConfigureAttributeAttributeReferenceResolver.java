/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.js.model.rbac.resource.rbactext.analysis;

import org.eclipse.emf.common.util.EList;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;

public class ConfigureAttributeAttributeReferenceResolver implements
      org.js.model.rbac.resource.rbactext.IRbactextReferenceResolver<org.js.model.rbac.ConfigureAttribute, org.js.model.feature.Attribute> {

   private org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.ConfigureAttribute, org.js.model.feature.Attribute> delegate =
      new org.js.model.rbac.resource.rbactext.analysis.RbactextDefaultResolverDelegate<org.js.model.rbac.ConfigureAttribute, org.js.model.feature.Attribute>();

   public void resolve(String identifier, org.js.model.rbac.ConfigureAttribute container, org.eclipse.emf.ecore.EReference reference,
                       int position, boolean resolveFuzzy,
                       final org.js.model.rbac.resource.rbactext.IRbactextReferenceResolveResult<org.js.model.feature.Attribute> result) {
      if (identifier != null && identifier != "") {
         Feature feature = container.getFeature();
         if (feature != null) {
            EList<Attribute> attributes = feature.getAttributes();
            for (Attribute attribute : attributes) {
               String attributeName = attribute.getName();
               if (identifier.equals(attributeName)) {
                  result.addMapping(identifier, attribute);
               }
            }
         }
      }
      delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
   }

   public String deResolve(org.js.model.feature.Attribute element, org.js.model.rbac.ConfigureAttribute container,
                           org.eclipse.emf.ecore.EReference reference) {
      return delegate.deResolve(element, container, reference);
   }

   public void setOptions(java.util.Map< ? , ? > options) {
      // save options in a field or leave method empty if this resolver does not depend
      // on any option
   }

}
