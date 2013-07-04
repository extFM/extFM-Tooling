/**
 */
package org.js.model.feature.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.js.model.feature.AttributeReference;
import org.js.model.feature.FeaturePackage;

/**
 * This is the item provider adapter for a {@link org.js.model.feature.AttributeReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeReferenceItemProvider
   extends AttributeOperandItemProvider
   implements
      IEditingDomainItemProvider,
      IStructuredItemContentProvider,
      ITreeItemContentProvider,
      IItemLabelProvider,
      IItemPropertySource {
   /**
    * This constructs an instance from a factory and a notifier.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public AttributeReferenceItemProvider(AdapterFactory adapterFactory) {
      super(adapterFactory);
   }

   /**
    * This returns the property descriptors for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
      if (itemPropertyDescriptors == null) {
         super.getPropertyDescriptors(object);

         addAttributePropertyDescriptor(object);
         addFeaturePropertyDescriptor(object);
      }
      return itemPropertyDescriptors;
   }

   /**
    * This adds a property descriptor for the Attribute feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addAttributePropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_AttributeReference_attribute_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_AttributeReference_attribute_feature", "_UI_AttributeReference_type"),
             FeaturePackage.Literals.ATTRIBUTE_REFERENCE__ATTRIBUTE,
             true,
             false,
             true,
             null,
             null,
             null));
   }

   /**
    * This adds a property descriptor for the Feature feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addFeaturePropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_AttributeReference_feature_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_AttributeReference_feature_feature", "_UI_AttributeReference_type"),
             FeaturePackage.Literals.ATTRIBUTE_REFERENCE__FEATURE,
             true,
             false,
             true,
             null,
             null,
             null));
   }

   /**
    * This returns AttributeReference.gif.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object getImage(Object object) {
      return overlayImage(object, getResourceLocator().getImage("full/obj16/AttributeReference"));
   }

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated NOT
    */
   @Override
   public String getText(Object object) {
      String text = getString("_UI_AttributeReference_type");
      if (object instanceof AttributeReference) {
         AttributeReference reference = (AttributeReference) object;
         String featureId = reference.getFeature().getId();
         String attName = reference.getAttribute().getName();
         text += " " + featureId + "." + attName;
      }
      return text;
   }

   /**
    * This handles model notifications by calling {@link #updateChildren} to update any cached
    * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public void notifyChanged(Notification notification) {
      updateChildren(notification);
      super.notifyChanged(notification);
   }

   /**
    * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
    * that can be created under this object.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
      super.collectNewChildDescriptors(newChildDescriptors, object);
   }

}
