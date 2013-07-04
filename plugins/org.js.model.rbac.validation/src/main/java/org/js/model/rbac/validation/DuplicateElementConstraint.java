package org.js.model.rbac.validation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.Role;
import org.js.model.rbac.Subject;

public class DuplicateElementConstraint extends AbstractRbacConstraint {

   @Override
   String validateTarget(EObject target) {
      String msg = null;
      EObject eContainer = EcoreUtil.getRootContainer(target);
      if (eContainer instanceof AccessControlModel) {
         AccessControlModel model = (AccessControlModel) eContainer;
         List<EObject> objects = new ArrayList<EObject>();
         if (target instanceof Role) {
            objects.addAll(model.getRoles());
         } else if (target instanceof Subject) {
            objects.addAll(model.getSubjects());
         } else if (target instanceof Group) {
            objects.addAll(model.getGroups());
         }
         String targetId = EcoreUtil.getID(target);
         if (targetId != null) {
            for (EObject eObject : objects) {
               if (eObject != target) {
                  String otherObjectId = EcoreUtil.getID(eObject);
                  if (targetId.equals(otherObjectId)) {
                     msg = "An element with identifier <" + targetId + "> is already defined";
                  }
               }
            }
         }
      }
      return msg;
   }

}
