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
import org.js.model.feature.AttributeConstraint;
import org.js.model.feature.AttributeOperand;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureFactory;
import org.js.model.feature.FeaturePackage;
import org.js.model.feature.FeatureState;
import org.js.model.feature.Relop;
import org.js.model.feature.edit.FeatureModelUtil;

/**
 * This is the item provider adapter for a {@link org.js.model.feature.AttributeConstraint} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeConstraintItemProvider
   extends ConstraintItemProvider
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
   public AttributeConstraintItemProvider(AdapterFactory adapterFactory) {
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

			addOperatorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

   /**
	 * This adds a property descriptor for the Operator feature.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected void addOperatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AttributeConstraint_operator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AttributeConstraint_operator_feature", "_UI_AttributeConstraint_type"),
				 FeaturePackage.Literals.ATTRIBUTE_CONSTRAINT__OPERATOR,
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
			childrenFeatures.add(FeaturePackage.Literals.ATTRIBUTE_CONSTRAINT__ATTRIBUTE1);
			childrenFeatures.add(FeaturePackage.Literals.ATTRIBUTE_CONSTRAINT__ATTRIBUTE2);
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
    * This returns AttributeConstraint.gif.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated NOT
    */
   @Override
   public Object getImage(Object object) {
      String imagePath = "AttributeConstraint";
      if (object instanceof AttributeConstraint) {
         AttributeConstraint constraint = (AttributeConstraint) object;
        Relop operator = constraint.getOperator();
        if (operator != null){
           int operatorValue = operator.getValue();
           switch (operatorValue) {
            case Relop.EQUAL_VALUE:
               imagePath = "AttributeConstraint_Equals";
               break;
            case Relop.GREATER_THAN_OR_EQUAL_VALUE:
               imagePath = "AttributeConstraint_GreaterOrEqual";
               break;
            case Relop.GREATER_THAN_VALUE:
               imagePath = "AttributeConstraint_Greater";
               break;
            case Relop.LESS_THAN_OR_EQUAL_VALUE:
               imagePath = "AttributeConstraint_LessOrEqual";
               break;
            case Relop.LESS_THAN_VALUE:
               imagePath = "AttributeConstraint_Less";
               break;
            case Relop.UNEQUAL_VALUE:
               imagePath = "AttributeConstraint_Unequal";
               break;
            default:
               break;
         }
           
        }
      }
      
      return overlayImage(object, getResourceLocator().getImage("full/obj16/" + imagePath));
      
      //return overlayImage(object, getResourceLocator().getImage("full/obj16/AttributeConstraint"));
   }

   /**
    * This returns the label text for the adapted class.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated NOT
    */
   @Override
   public String getText(Object object) {
	  AttributeConstraint constraint = (AttributeConstraint)object;
      return FeatureModelUtil.getLabel(constraint);
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

		switch (notification.getFeatureID(AttributeConstraint.class)) {
			case FeaturePackage.ATTRIBUTE_CONSTRAINT__OPERATOR:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case FeaturePackage.ATTRIBUTE_CONSTRAINT__ATTRIBUTE1:
			case FeaturePackage.ATTRIBUTE_CONSTRAINT__ATTRIBUTE2:
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
				(FeaturePackage.Literals.ATTRIBUTE_CONSTRAINT__ATTRIBUTE1,
				 FeatureFactory.eINSTANCE.createAttributeReference()));

		newChildDescriptors.add
			(createChildParameter
				(FeaturePackage.Literals.ATTRIBUTE_CONSTRAINT__ATTRIBUTE1,
				 FeatureFactory.eINSTANCE.createAttributeValue()));

		newChildDescriptors.add
			(createChildParameter
				(FeaturePackage.Literals.ATTRIBUTE_CONSTRAINT__ATTRIBUTE2,
				 FeatureFactory.eINSTANCE.createAttributeReference()));

		newChildDescriptors.add
			(createChildParameter
				(FeaturePackage.Literals.ATTRIBUTE_CONSTRAINT__ATTRIBUTE2,
				 FeatureFactory.eINSTANCE.createAttributeValue()));
	}

   /**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == FeaturePackage.Literals.ATTRIBUTE_CONSTRAINT__ATTRIBUTE1 ||
			childFeature == FeaturePackage.Literals.ATTRIBUTE_CONSTRAINT__ATTRIBUTE2;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
