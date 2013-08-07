/**
 */
package org.js.model.feature.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
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
import org.js.model.feature.Attribute;
import org.js.model.feature.Domain;
import org.js.model.feature.Feature;
import org.js.model.feature.FeaturePackage;
import org.js.model.feature.edit.FeatureModelUtil;

/**
 * This is the item provider adapter for a {@link org.js.model.feature.Attribute} object.
 * <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * @generated
 */
public class AttributeItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider,
      ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

   /**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
   public AttributeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

   /**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addDomainPropertyDescriptor(object);
			addValuePropertyDescriptor(object);
			addDeselectedDomainValuesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

   /**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
   protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Attribute_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Attribute_name_feature", "_UI_Attribute_type"),
				 FeaturePackage.Literals.ATTRIBUTE__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

   /**
	 * This adds a property descriptor for the Domain feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
   protected void addDomainPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Attribute_domain_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Attribute_domain_feature", "_UI_Attribute_type"),
				 FeaturePackage.Literals.ATTRIBUTE__DOMAIN,
				 true,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

   /**
	 * This adds a property descriptor for the Value feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
   protected void addValuePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Attribute_value_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Attribute_value_feature", "_UI_Attribute_type"),
				 FeaturePackage.Literals.ATTRIBUTE__VALUE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

   /**
	 * This adds a property descriptor for the Deselected Domain Values feature.
	 * <!-- begin-user-doc --> <!--
    * end-user-doc -->
	 * @generated
	 */
   protected void addDeselectedDomainValuesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Attribute_deselectedDomainValues_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Attribute_deselectedDomainValues_feature", "_UI_Attribute_type"),
				 FeaturePackage.Literals.ATTRIBUTE__DESELECTED_DOMAIN_VALUES,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

   /**
    * This returns Attribute.gif. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated NOT
    */
   @Override
   public Object getImage(Object object) {
      String imagePath = "Attribute";
      if (object instanceof Attribute) {
         Attribute attribute = (Attribute) object;
         Feature feature = attribute.getFeature();
         if (FeatureModelUtil.isFeatureDeselected(feature)) {
            imagePath = "DisabledAttribute";
         } else {
            String value = attribute.getValue();
            if (value != null && value.length() > 0) {
               imagePath = "SetAttribute";
            }
         }
      }
      return overlayImage(object, getResourceLocator().getImage("full/obj16/" + imagePath));
   }

   /**
    * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
    * 
    * @generated NOT
    */
   @Override
   public String getText(Object object) {
      String label = getString("_UI_Attribute_type");
      if (object instanceof Attribute) {
         Attribute attribute = (Attribute) object;
         String name = attribute.getName();
         if (name != null & name.length() != 0) {
            label += " " + name;
         }
         String domainDesc = "";
         String attributeValue = attribute.getValue();
         if (attributeValue != null && attributeValue.length() != 0) {
            String attributeSet = " = " + attributeValue;
            domainDesc += attributeSet;
         }
         Domain domain = attribute.getDomain();
         if (domain != null) {
            String domainId = domain.getId();
            domainDesc += " [" + domainId + "]";
            EList<String> deselectedValues = attribute.getDeselectedDomainValues();
            if (deselectedValues.size() > 0) {
               String deselected = "";
               for (String value : deselectedValues) {
                  if (deselected.length() > 0) {
                     deselected += ", ";
                  }
                  deselected += value;
               }
               if (deselected.length() > 0) {
                  domainDesc += " \\ (" + deselected + ")";
               }
            }
         }

         label += domainDesc;
      }
      return label;
   }

   /**
    * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
    * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
    * -->
    * 
    * @generated
    */
   @Override
   public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Attribute.class)) {
			case FeaturePackage.ATTRIBUTE__NAME:
			case FeaturePackage.ATTRIBUTE__DOMAIN:
			case FeaturePackage.ATTRIBUTE__VALUE:
			case FeaturePackage.ATTRIBUTE__DESELECTED_DOMAIN_VALUES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

   /**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(FeaturePackage.Literals.ATTRIBUTE__DESELECTED_DOMAIN_VALUES,
				 ""));
	}

   /**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public ResourceLocator getResourceLocator() {
		return FeatureEditPlugin.INSTANCE;
	}

}
