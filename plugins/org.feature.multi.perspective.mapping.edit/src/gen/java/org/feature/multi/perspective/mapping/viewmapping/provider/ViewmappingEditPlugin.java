/**
 */
package org.feature.multi.perspective.mapping.viewmapping.provider;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import org.feature.multi.perspective.model.viewmodel.provider.ViewmodelEditPlugin;

import org.featuremapper.models.feature.provider.FeatureEditPlugin;

/**
 * This is the central singleton for the Viewmapping edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class ViewmappingEditPlugin extends EMFPlugin {
   /**
    * Keep track of the singleton.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final ViewmappingEditPlugin INSTANCE = new ViewmappingEditPlugin();

   /**
    * Keep track of the singleton.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   private static Implementation plugin;

   /**
    * Create the instance.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public ViewmappingEditPlugin() {
      super
        (new ResourceLocator [] {
           FeatureEditPlugin.INSTANCE,
           ViewmodelEditPlugin.INSTANCE,
         });
   }

   /**
    * Returns the singleton instance of the Eclipse plugin.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the singleton instance.
    * @generated
    */
   @Override
   public ResourceLocator getPluginResourceLocator() {
      return plugin;
   }

   /**
    * Returns the singleton instance of the Eclipse plugin.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return the singleton instance.
    * @generated
    */
   public static Implementation getPlugin() {
      return plugin;
   }

   /**
    * The actual implementation of the Eclipse <b>Plugin</b>.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static class Implementation extends EclipsePlugin {
      /**
       * Creates an instance.
       * <!-- begin-user-doc -->
       * <!-- end-user-doc -->
       * @generated
       */
      public Implementation() {
         super();

         // Remember the static instance.
         //
         plugin = this;
      }
   }

}
