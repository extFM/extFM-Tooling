/**
 */
package org.js.model.feature.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.js.model.feature.Feature;
import org.js.model.feature.FeatureFactory;
import org.js.model.feature.FeaturePackage;
import org.js.model.feature.FeatureState;


/**
 * This is the item provider adapter for a {@link org.js.model.feature.Feature} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureItemProvider
   extends IdentifiableItemProvider
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
   public FeatureItemProvider(AdapterFactory adapterFactory) {
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

         addNamePropertyDescriptor(object);
         addSelectedPropertyDescriptor(object);
      }
      return itemPropertyDescriptors;
   }

   /**
    * This adds a property descriptor for the Name feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addNamePropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Feature_name_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Feature_name_feature", "_UI_Feature_type"),
             FeaturePackage.Literals.FEATURE__NAME,
             true,
             false,
             false,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
             null,
             null));
   }

   /**
    * This adds a property descriptor for the Selected feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addSelectedPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Feature_selected_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Feature_selected_feature", "_UI_Feature_type"),
             FeaturePackage.Literals.FEATURE__SELECTED,
             true,
             false,
             false,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
             null,
             null));
   }

   /**
    * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
    * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
    * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
      if (childrenFeatures == null) {
         super.getChildrenFeatures(object);
         childrenFeatures.add(FeaturePackage.Literals.FEATURE__ATTRIBUTES);
         childrenFeatures.add(FeaturePackage.Literals.FEATURE__GROUPS);
      }
      return childrenFeatures;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EStructuralFeature getChildFeature(Object object, Object child) {
      // Check the type of the specified child object and return the proper feature to use for
      // adding (see {@link AddCommand}) it as a child.

      return super.getChildFeature(object, child);
   }

   /**
    * This returns Feature.gif.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated NOT
    */
   @Override
   public Object getImage(Object object) {
      String imagePath = "Feature";
      if (object instanceof Feature) {
         Feature feature = (Feature) object;
         FeatureState selected = feature.getSelected();
        if (FeatureState.DESELECTED.equals(selected)){
           imagePath = "DeSelectedFeature";
         } else if (FeatureState.SELECTED.equals(selected)) {
           imagePath = "SelectedFeature";
         }
      }
      
      return overlayImage(object, getResourceLocator().getImage("full/obj16/" + imagePath));
   }

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public String getText(Object object) {
      String label = ((Feature)object).getName();
      return label == null || label.length() == 0 ?
         getString("_UI_Feature_type") :
         getString("_UI_Feature_type") + " " + label;
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

      switch (notification.getFeatureID(Feature.class)) {
         case FeaturePackage.FEATURE__NAME:
         case FeaturePackage.FEATURE__SELECTED:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
         case FeaturePackage.FEATURE__ATTRIBUTES:
         case FeaturePackage.FEATURE__GROUPS:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
            return;
      }
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

      newChildDescriptors.add
         (createChildParameter
            (FeaturePackage.Literals.FEATURE__ATTRIBUTES,
             FeatureFactory.eINSTANCE.createAttribute()));

      newChildDescriptors.add
         (createChildParameter
            (FeaturePackage.Literals.FEATURE__GROUPS,
             FeatureFactory.eINSTANCE.createGroup()));
   }

}
