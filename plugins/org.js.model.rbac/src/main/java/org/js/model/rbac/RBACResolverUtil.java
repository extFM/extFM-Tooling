/************************************************************
 * Copyright (c) 2010 paperlocator.org - all rights reserved.
 * 
 * $Id$ 
 * $Revision$ 
 * $Author$
 ***********************************************************/
package org.js.model.rbac;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.js.model.feature.Attribute;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;

/**
 * @author <a href="mailto:julia.schroeter@tu-dresden.de">Julia Schroeter</a>
 * 
 */
public final class RBACResolverUtil {

   public static final String delimiter = ".";

   public static final String select = "select";
   public static final String deselect = "deselect";
   public static final String set = "assign";

   public static final String view = "view";
   public static final String modify = "modify";

   /**
    * find the feature identified by the given id in any feature model referenced by the given accesscontrol model;
    * 
    * @return
    */
   public static Feature findFeature(AccessControlModel model, String featureId) {
      Assert.isNotNull(featureId);
      Assert.isNotNull(model);
      Feature result = null;
      FeatureModel featureModel = model.getFeatureModel();
      TreeIterator<Object> allContents = EcoreUtil.getAllContents(featureModel, true);
      while (allContents.hasNext()) {
         Object next = allContents.next();
         if (next instanceof Feature) {
            Feature feature = (Feature) next;
            String refFeatureId = EcoreUtil.getID(feature);
            if (featureId.equals(refFeatureId)) {
               result = feature;
               break;
            }
         }
      }
      return result;
   }

   public static Attribute findAttribute(Feature feature, String attributeId) {
      Assert.isNotNull(feature);
      Assert.isNotNull(attributeId);

      Attribute result = null;
      EList<Attribute> attributes = feature.getAttributes();
      for (Attribute attribute : attributes) {
         String attributeName = attribute.getName();
         if (attributeId.equals(attributeName)) {
            result = attribute;
            break;
         }
      }
      return result;
   }

   /**
    * returns the permission according to the given identifier, which is in the form "select f1" or "set f1.a1".
    * 
    * @param model
    * @param identifier
    * @return
    */
   public static Permission findPermission(AccessControlModel model, String identifier) {
      Permission result = null;
      // List<Permission> permissions = new RBACService().getAllModelPermissions(model);
      // String keyword = getKeyword(identifier);
      // String objectId = getObjectIdentifier(keyword, identifier);
      // boolean isSelectFeature = isSelectFeature(keyword, objectId);
      // boolean isDeselectFeature = isDeselectFeature(keyword, objectId);
      // if (isSelectFeature || isDeselectFeature) {
      // for (Permission permission : permissions) {
      // if (permission instanceof FeatureOperation) {
      // FeatureOperation featureOp = (FeatureOperation) permission;
      // if (RbacHelper.isSelectFeatureOperation(featureOp) == isSelectFeature) {
      // String featureid = featureOp.getFeature().getId();
      // if (objectId.equals(featureid)) {
      // result = permission;
      // break;
      // }
      // }
      // }
      // }
      // } else if (isSetAttribute(keyword, objectId)) {
      // String[] split = splitObjectId(delimiter, objectId);
      // for (Permission permission : permissions) {
      // if (permission instanceof AttributeOperation) {
      // AttributeOperation setAttribute = (AttributeOperation) permission;
      // String featureId = setAttribute.getFeature().getId();
      // String attributeName = setAttribute.getAttribute().getName();
      // if (split[0].equals(featureId) && split[1].equals(attributeName)) {
      // result = permission;
      // break;
      // }
      // }
      // }
      // } else {
      // boolean isViewElement = isViewElement(keyword);
      // if (isViewElement || isModifyElement(keyword)) {
      // for (Permission permission : permissions) {
      // if (permission instanceof VisibilityRestriction) {
      // VisibilityRestriction restriction = (VisibilityRestriction) permission;
      // if (RbacHelper.isViewElement(restriction) == isViewElement) {
      // String resourceId = restriction.getResourceId();
      // if (objectId.equals(resourceId)) {
      // result = restriction;
      // break;
      // }
      // }
      // }
      // }
      // }
      // }
      return result;
   }

   public static String[] splitObjectId(String delimiter, String objectId) {
      int delimiterPosition = objectId.indexOf(delimiter);
      String objectFeatureId = objectId.substring(0, delimiterPosition);
      String objectAttributeId = objectId.substring(delimiterPosition + 1);
      List<String> objects = new LinkedList<String>();
      objects.add(objectFeatureId);
      objects.add(objectAttributeId);
      return (String[]) objects.toArray(new String[objects.size()]);
   }

   public static boolean isAttributeReference(String objectId) {
      boolean isAttribute = false;
      if (objectId != null && objectId.contains(delimiter)) {
         int firstPosition = objectId.indexOf(delimiter);
         int lastPosition = objectId.lastIndexOf(delimiter);
         isAttribute = (firstPosition == lastPosition);
      }
      return isAttribute;
   }

   public static boolean isSelectFeature(String keyword, String objectId) {
      return (select.equals(keyword) && !isAttributeReference(objectId));
   }

   public static boolean isModifyElement(String keyword, String objectId) {
      return (modify.equals(keyword));
   }

   public static boolean isViewElement(String keyword) {
      return (view.equals(keyword));
   }

   public static boolean isModifyElement(String keyword) {
      return (modify.equals(keyword));
   }

   public static boolean isDeselectFeature(String keyword, String objectId) {
      return (deselect.equals(keyword) && !isAttributeReference(objectId));
   }

   public static boolean isSetAttribute(String keyword, String objectId) {
      return (set.equals(keyword) && isAttributeReference(objectId));
   }

   public static String getKeyword(String permissionId) {
      String keyword = null;
      if (permissionId != null) {
         permissionId = permissionId.trim();
         if (permissionId.startsWith(select)) {
            keyword = select;
         } else if (permissionId.startsWith(deselect)) {
            keyword = deselect;
         } else if (permissionId.startsWith(set)) {
            keyword = set;
         } else if (permissionId.startsWith(view)) {
            keyword = view;
         } else if (permissionId.startsWith(modify)) {
            keyword = modify;
         }
      }
      return keyword;
   }

   public static String getObjectIdentifier(String keyword, String permissionId) {
      String text = permissionId;
      String lastSection = null;
      if (keyword != null && text != null) {
         text = text.trim();
         int subStringLength = keyword.length() + 1;
         if (subStringLength < text.length()) {
            lastSection = text.substring(subStringLength);
            if (lastSection != null) {
               lastSection = lastSection.trim();
               if (containsWhitespaceOnly(lastSection)) {
                  lastSection = null;
               }
            }
         }
      }
      return lastSection;
   }

   private static boolean containsWhitespaceOnly(String text) {
      boolean onlySpace = true;
      char space = '\u0020';
      char[] charArray = text.toCharArray();
      for (char c : charArray) {
         if (c != space) {
            onlySpace = false;
            break;
         }
      }
      return onlySpace;
   }

   /**
    * find the relative uri for the given EObjects.
    * 
    * @param objectToConvert
    * @param baseObject
    * @return
    */
   public static String getRelativeURI(EObject objectToConvert, EObject baseObject) {
      String relative = null;

      if (objectToConvert != null && baseObject != null) {
         String fileName = getFileName(objectToConvert);
         // return relative uri
         java.net.URI objectToConvertUri = getContainerURI(objectToConvert.eResource());
         java.net.URI baseObjectUri = getContainerURI(baseObject.eResource());
         if (objectToConvertUri != null && baseObjectUri != null) {
            java.net.URI relativeUri = URIUtil.makeRelative(objectToConvertUri, baseObjectUri);
            relative = relativeUri.toString();
            // add filename
            relative += "/" + fileName;
         } else if (objectToConvertUri == null && baseObjectUri == null) {
            return fileName;
         }
      }
      return relative;
   }

   private static String getFileName(EObject eObject) {
      String fileName = null;
      IFile file = getFile(eObject.eResource());
      if (file != null) {
         fileName = file.getName();
      }
      return fileName;
   }

   private static java.net.URI getContainerURI(Resource resource) {
      java.net.URI parent = null;
      IFile file = getFile(resource);
      if (file != null) {
         IContainer container = file.getParent();
         if (container != null) {
            parent = container.getRawLocationURI();
         }
      }
      return parent;
   }

   /**
    * get the ifile representation of a resource.
    * 
    * @param modelResource
    * @return
    */
   public static IFile getFile(Resource modelResource) {
      IFile file = WorkspaceSynchronizer.getFile(modelResource);
      return file;
   }

   public static String getPermissionIdentifier(Permission permission) {
      String identifier = null;
      if (permission instanceof FeatureOperation) {
         FeatureOperation featureOp = (FeatureOperation) permission;
         identifier = (RbacHelper.isSelectFeatureOperation(featureOp)) ? select : deselect;
         Feature feature = featureOp.getFeature();
         identifier += " " + feature.getId();
      } else if (permission instanceof AttributeOperation) {
         AttributeOperation attrOp = (AttributeOperation) permission;
         identifier = set + " " + attrOp.getFeature().getId() + delimiter + attrOp.getAttribute().getName();
      } else if (permission instanceof AttributeValueOperation) {
         AttributeValueOperation dvOp = (AttributeValueOperation) permission;
         identifier = (RbacHelper.isSelectDomainValueOperation(dvOp)) ? select : deselect;
         identifier += " " + dvOp.getFeature().getId() + delimiter + dvOp.getAttribute().getName() + delimiter + dvOp.getValue();
      }
      return identifier;
   }

   
}
