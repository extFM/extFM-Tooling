/**
 */
package org.js.model.expression.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.js.model.expression.Constraint2;
import org.js.model.expression.expressionFactory;
import org.js.model.expression.expressionPackage;

/**
 * This is the item provider adapter for a {@link org.js.model.expression.Constraint2} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class Constraint2ItemProvider
   extends Identifiable2ItemProvider
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
   public Constraint2ItemProvider(AdapterFactory adapterFactory) {
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

      }
      return itemPropertyDescriptors;
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
         childrenFeatures.add(expressionPackage.Literals.CONSTRAINT2__EXPRESSION);
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
    * This returns Constraint2.gif.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object getImage(Object object) {
      return overlayImage(object, getResourceLocator().getImage("full/obj16/Constraint2"));
   }

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public String getText(Object object) {
      String label = ((Constraint2)object).getId();
      return label == null || label.length() == 0 ?
         getString("_UI_Constraint2_type") :
         getString("_UI_Constraint2_type") + " " + label;
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

      switch (notification.getFeatureID(Constraint2.class)) {
         case expressionPackage.CONSTRAINT2__EXPRESSION:
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
            (expressionPackage.Literals.CONSTRAINT2__EXPRESSION,
             expressionFactory.eINSTANCE.createFeatureReference2()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.CONSTRAINT2__EXPRESSION,
             expressionFactory.eINSTANCE.createRequires()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.CONSTRAINT2__EXPRESSION,
             expressionFactory.eINSTANCE.createExcludes()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.CONSTRAINT2__EXPRESSION,
             expressionFactory.eINSTANCE.createEqual()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.CONSTRAINT2__EXPRESSION,
             expressionFactory.eINSTANCE.createUnequal()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.CONSTRAINT2__EXPRESSION,
             expressionFactory.eINSTANCE.createGreaterThan()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.CONSTRAINT2__EXPRESSION,
             expressionFactory.eINSTANCE.createGreaterThanOrEqual()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.CONSTRAINT2__EXPRESSION,
             expressionFactory.eINSTANCE.createLessThan()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.CONSTRAINT2__EXPRESSION,
             expressionFactory.eINSTANCE.createLessThanOrEqual()));
   }

}
