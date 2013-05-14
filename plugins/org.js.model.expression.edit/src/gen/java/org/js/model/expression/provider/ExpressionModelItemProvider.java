/**
 */
package org.js.model.expression.provider;


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

import org.js.model.expression.ExpressionModel;
import org.js.model.expression.expressionFactory;
import org.js.model.expression.expressionPackage;

import org.js.model.feature.FeatureFactory;

/**
 * This is the item provider adapter for a {@link org.js.model.expression.ExpressionModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionModelItemProvider
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
   public ExpressionModelItemProvider(AdapterFactory adapterFactory) {
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
         addFeatureModelsPropertyDescriptor(object);
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
             getString("_UI_ExpressionModel_name_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_ExpressionModel_name_feature", "_UI_ExpressionModel_type"),
             expressionPackage.Literals.EXPRESSION_MODEL__NAME,
             true,
             false,
             false,
             ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
             null,
             null));
   }

   /**
    * This adds a property descriptor for the Feature Models feature.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected void addFeatureModelsPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_ExpressionModel_featureModels_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_ExpressionModel_featureModels_feature", "_UI_ExpressionModel_type"),
             expressionPackage.Literals.EXPRESSION_MODEL__FEATURE_MODELS,
             true,
             false,
             true,
             null,
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
         childrenFeatures.add(expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS);
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
    * This returns ExpressionModel.gif.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object getImage(Object object) {
      return overlayImage(object, getResourceLocator().getImage("full/obj16/ExpressionModel"));
   }

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public String getText(Object object) {
      String label = ((ExpressionModel)object).getName();
      return label == null || label.length() == 0 ?
         getString("_UI_ExpressionModel_type") :
         getString("_UI_ExpressionModel_type") + " " + label;
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

      switch (notification.getFeatureID(ExpressionModel.class)) {
         case expressionPackage.EXPRESSION_MODEL__NAME:
            fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
            return;
         case expressionPackage.EXPRESSION_MODEL__EXPRESSIONS:
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
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             expressionFactory.eINSTANCE.createFeatureAttributeReference()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             expressionFactory.eINSTANCE.createFeatureAttributeValue()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             expressionFactory.eINSTANCE.createAddition()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             expressionFactory.eINSTANCE.createSubtraction()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             expressionFactory.eINSTANCE.createMultiplication()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             expressionFactory.eINSTANCE.createDivision()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             expressionFactory.eINSTANCE.createFeatureReference()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             FeatureFactory.eINSTANCE.createFeatureReference()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             FeatureFactory.eINSTANCE.createNotExpression()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             FeatureFactory.eINSTANCE.createAndExpression()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             FeatureFactory.eINSTANCE.createOrExpression()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             FeatureFactory.eINSTANCE.createImpliesExpression()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             FeatureFactory.eINSTANCE.createExcludesExpression()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             FeatureFactory.eINSTANCE.createNestedExpression()));

      newChildDescriptors.add
         (createChildParameter
            (expressionPackage.Literals.EXPRESSION_MODEL__EXPRESSIONS,
             FeatureFactory.eINSTANCE.createAttributeComparisonExpression()));
   }

   /**
    * Return the resource locator for this item provider's resources.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public ResourceLocator getResourceLocator() {
      return expressionEditPlugin.INSTANCE;
   }

}
