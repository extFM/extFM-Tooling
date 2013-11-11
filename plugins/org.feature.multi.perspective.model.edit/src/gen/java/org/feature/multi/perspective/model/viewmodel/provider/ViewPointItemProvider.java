/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.feature.multi.perspective.model.viewmodel.ViewPoint;
import org.feature.multi.perspective.model.viewmodel.ViewmodelFactory;
import org.feature.multi.perspective.model.viewmodel.ViewmodelPackage;

/**
 * This is the item provider adapter for a {@link org.feature.multi.perspective.model.viewmodel.ViewPoint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewPointItemProvider
   extends ElementItemProvider
   implements
      IEditingDomainItemProvider,
      IStructuredItemContentProvider,
      ITreeItemContentProvider,
      IItemLabelProvider,
      IItemPropertySource,
      IItemFontProvider {
   /**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ViewPointItemProvider(AdapterFactory adapterFactory) {
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

			addContainedInGroupPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

   /**
	 * This adds a property descriptor for the Contained In Group feature.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected void addContainedInGroupPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ViewPoint_containedInGroup_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ViewPoint_containedInGroup_feature", "_UI_ViewPoint_type"),
				 ViewmodelPackage.Literals.VIEW_POINT__CONTAINED_IN_GROUP,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

   /**
	 * This returns ViewPoint.gif.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ViewPoint"));
	}

   /**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public String getText(Object object) {
		String label = ((ViewPoint)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_ViewPoint_type") :
			getString("_UI_ViewPoint_type") + " " + label;
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
