/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.GroupModel;

public class MappingViewgroupReferenceResolver
      implements
      org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolver<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.feature.multi.perspective.model.viewmodel.AbstractGroup> {

   private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultResolverDelegate<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.feature.multi.perspective.model.viewmodel.AbstractGroup> delegate =
      new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultResolverDelegate<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.feature.multi.perspective.model.viewmodel.AbstractGroup>();

   public void resolve(String identifier,
                       org.feature.multi.perspective.mapping.viewmapping.Mapping container,
                       org.eclipse.emf.ecore.EReference reference,
                       int position,
                       boolean resolveFuzzy,
                       final org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolveResult<org.feature.multi.perspective.model.viewmodel.AbstractGroup> result) {
      EObject model = EcoreUtil.getRootContainer(container);
      if (model instanceof MappingModel) {
         MappingModel mappingModel = (MappingModel) model;
         GroupModel viewModel = mappingModel.getViewModel();
         AbstractGroup group = traverseTree(viewModel, identifier);
         if (group != null) {
            result.addMapping(identifier, group);
         }
      } else {
         delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
      }
   }

   private AbstractGroup traverseTree(GroupModel viewModel, String identifier) {
      AbstractGroup result = null;
      TreeIterator<EObject> eAllContents = viewModel.eAllContents();
      while (eAllContents.hasNext()) {
         EObject next = eAllContents.next();
         if (next instanceof AbstractGroup) {
            AbstractGroup containedGroup = (AbstractGroup) next;
            if (isEqual(identifier, containedGroup)) {
               result = containedGroup;
               break;
            }
         }
      }
      return result;
   }

   private boolean isEqual(String identifier, AbstractGroup group) {
      return identifier.equals(group.getName());
   }

   public String deResolve(org.feature.multi.perspective.model.viewmodel.AbstractGroup element,
                           org.feature.multi.perspective.mapping.viewmapping.Mapping container, org.eclipse.emf.ecore.EReference reference) {
      if (element != null) {
         return element.getName();
      } else {
         return delegate.deResolve(element, container, reference);
      }
   }

   public void setOptions(java.util.Map< ? , ? > options) {
      // save options in a field or leave method empty if this resolver does not depend
      // on any option
   }

}
