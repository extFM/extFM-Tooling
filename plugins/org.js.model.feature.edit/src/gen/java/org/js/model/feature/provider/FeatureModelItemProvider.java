/**
 */
package org.js.model.feature.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.js.model.feature.FeatureFactory;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.FeaturePackage;

/**
 * This is the item provider adapter for a {@link org.js.model.feature.FeatureModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FeatureModelItemProvider
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
   public FeatureModelItemProvider(AdapterFactory adapterFactory) {
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
				 getString("_UI_FeatureModel_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_FeatureModel_name_feature", "_UI_FeatureModel_type"),
				 FeaturePackage.Literals.FEATURE_MODEL__NAME,
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
			childrenFeatures.add(FeaturePackage.Literals.FEATURE_MODEL__ROOT);
			childrenFeatures.add(FeaturePackage.Literals.FEATURE_MODEL__DOMAINS);
			childrenFeatures.add(FeaturePackage.Literals.FEATURE_MODEL__CONSTRAINTS);
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
	 * This returns FeatureModel.gif.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/FeatureModel"));
	}

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated NOT
    */
   @Override
   public String getText(Object object) {
      String label = ((FeatureModel)object).getName();
      return label == null || label.length() == 0 ?
         "Featuremodel" : "Featuremodel " + label;
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

		switch (notification.getFeatureID(FeatureModel.class)) {
			case FeaturePackage.FEATURE_MODEL__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case FeaturePackage.FEATURE_MODEL__ROOT:
			case FeaturePackage.FEATURE_MODEL__DOMAINS:
			case FeaturePackage.FEATURE_MODEL__CONSTRAINTS:
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
				(FeaturePackage.Literals.FEATURE_MODEL__ROOT,
				 FeatureFactory.eINSTANCE.createFeature()));

		newChildDescriptors.add
			(createChildParameter
				(FeaturePackage.Literals.FEATURE_MODEL__DOMAINS,
				 FeatureFactory.eINSTANCE.createDiscreteDomain()));

		newChildDescriptors.add
			(createChildParameter
				(FeaturePackage.Literals.FEATURE_MODEL__DOMAINS,
				 FeatureFactory.eINSTANCE.createNumericalDomain()));

		newChildDescriptors.add
			(createChildParameter
				(FeaturePackage.Literals.FEATURE_MODEL__CONSTRAINTS,
				 FeatureFactory.eINSTANCE.createAttributeConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(FeaturePackage.Literals.FEATURE_MODEL__CONSTRAINTS,
				 FeatureFactory.eINSTANCE.createImply()));

		newChildDescriptors.add
			(createChildParameter
				(FeaturePackage.Literals.FEATURE_MODEL__CONSTRAINTS,
				 FeatureFactory.eINSTANCE.createExclude()));
	}

   /**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public ResourceLocator getResourceLocator() {
		return FeatureEditPlugin.INSTANCE;
	}

}
