/**
 */
package org.js.graph.transformation.provider;


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
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import org.eclipse.emf.edit.provider.ViewerNotification;
import org.js.graph.transformation.Operations;
import org.js.graph.transformation.TransformationFactory;
import org.js.graph.transformation.TransformationPackage;

/**
 * This is the item provider adapter for a {@link org.js.graph.transformation.Operations} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OperationsItemProvider
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
	public OperationsItemProvider(AdapterFactory adapterFactory) {
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

         addRemoveEdgesPropertyDescriptor(object);
         addRemoveNodesPropertyDescriptor(object);
         addAddNodesPropertyDescriptor(object);
         addAddEdgesPropertyDescriptor(object);
      }
      return itemPropertyDescriptors;
   }

	/**
    * This adds a property descriptor for the Remove Edges feature.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected void addRemoveEdgesPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Operations_removeEdges_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Operations_removeEdges_feature", "_UI_Operations_type"),
             TransformationPackage.Literals.OPERATIONS__REMOVE_EDGES,
             true,
             false,
             true,
             null,
             null,
             null));
   }

	/**
    * This adds a property descriptor for the Remove Nodes feature.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected void addRemoveNodesPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Operations_removeNodes_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Operations_removeNodes_feature", "_UI_Operations_type"),
             TransformationPackage.Literals.OPERATIONS__REMOVE_NODES,
             true,
             false,
             true,
             null,
             null,
             null));
   }

	/**
    * This adds a property descriptor for the Add Nodes feature.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected void addAddNodesPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Operations_addNodes_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Operations_addNodes_feature", "_UI_Operations_type"),
             TransformationPackage.Literals.OPERATIONS__ADD_NODES,
             true,
             false,
             true,
             null,
             null,
             null));
   }

	/**
    * This adds a property descriptor for the Add Edges feature.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	protected void addAddEdgesPropertyDescriptor(Object object) {
      itemPropertyDescriptors.add
         (createItemPropertyDescriptor
            (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
             getResourceLocator(),
             getString("_UI_Operations_addEdges_feature"),
             getString("_UI_PropertyDescriptor_description", "_UI_Operations_addEdges_feature", "_UI_Operations_type"),
             TransformationPackage.Literals.OPERATIONS__ADD_EDGES,
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
         childrenFeatures.add(TransformationPackage.Literals.OPERATIONS__REMOVE_EDGES);
         childrenFeatures.add(TransformationPackage.Literals.OPERATIONS__REMOVE_NODES);
         childrenFeatures.add(TransformationPackage.Literals.OPERATIONS__ADD_NODES);
         childrenFeatures.add(TransformationPackage.Literals.OPERATIONS__ADD_EDGES);
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
    * This returns Operations.gif.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public Object getImage(Object object) {
      return overlayImage(object, getResourceLocator().getImage("full/obj16/Operations"));
   }

	/**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public String getText(Object object) {
      return getString("_UI_Operations_type");
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

      switch (notification.getFeatureID(Operations.class)) {
         case TransformationPackage.OPERATIONS__REMOVE_EDGES:
         case TransformationPackage.OPERATIONS__REMOVE_NODES:
         case TransformationPackage.OPERATIONS__ADD_NODES:
         case TransformationPackage.OPERATIONS__ADD_EDGES:
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
            (TransformationPackage.Literals.OPERATIONS__REMOVE_EDGES,
             TransformationFactory.eINSTANCE.createRemoveEdges()));

      newChildDescriptors.add
         (createChildParameter
            (TransformationPackage.Literals.OPERATIONS__REMOVE_NODES,
             TransformationFactory.eINSTANCE.createRemoveNodes()));

      newChildDescriptors.add
         (createChildParameter
            (TransformationPackage.Literals.OPERATIONS__ADD_NODES,
             TransformationFactory.eINSTANCE.createAddNodes()));

      newChildDescriptors.add
         (createChildParameter
            (TransformationPackage.Literals.OPERATIONS__ADD_EDGES,
             TransformationFactory.eINSTANCE.createAddEdges()));
   }

	/**
    * Return the resource locator for this item provider's resources.
    * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
    * @generated
    */
	@Override
	public ResourceLocator getResourceLocator() {
      return GraphTransformationEditPlugin.INSTANCE;
   }

}
