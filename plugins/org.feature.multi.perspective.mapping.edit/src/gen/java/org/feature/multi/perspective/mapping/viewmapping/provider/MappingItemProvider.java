/**
 */
package org.feature.multi.perspective.mapping.viewmapping.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage;

/**
 * This is the item provider adapter for a {@link org.feature.multi.perspective.mapping.viewmapping.Mapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MappingItemProvider
   extends ItemProviderAdapter
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
   public MappingItemProvider(AdapterFactory adapterFactory) {
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

         addFeaturesPropertyDescriptor(object);
         addViewgroupPropertyDescriptor(object);
      }
      return itemPropertyDescriptors;
   }

   /**
    * This adds a property descriptor for the Features feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addFeaturesPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Mapping_features_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Mapping_features_feature", "_UI_Mapping_type"),
             ViewmappingPackage.Literals.MAPPING__FEATURES,
             true,
             false,
             true,
             null,
             null,
             null));
   }

   /**
    * This adds a property descriptor for the Viewgroup feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addViewgroupPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Mapping_viewgroup_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Mapping_viewgroup_feature", "_UI_Mapping_type"),
             ViewmappingPackage.Literals.MAPPING__VIEWGROUP,
             true,
             false,
             true,
             null,
             null,
             null));
   }

   /**
    * This returns Mapping.gif.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object getImage(Object object) {
      return overlayImage(object, getResourceLocator().getImage("full/obj16/Mapping"));
   }

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public String getText(Object object) {
      return getString("_UI_Mapping_type");
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

   /**
    * Return the resource locator for this item provider's resources.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public ResourceLocator getResourceLocator() {
      return ViewmappingEditPlugin.INSTANCE;
   }

}
