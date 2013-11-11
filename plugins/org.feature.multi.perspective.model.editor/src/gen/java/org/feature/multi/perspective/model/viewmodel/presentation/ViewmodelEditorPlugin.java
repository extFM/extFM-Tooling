/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.feature.multi.perspective.model.viewmodel.presentation;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.ui.EclipseUIPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

/**
 * This is the central singleton for the Viewmodel editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class ViewmodelEditorPlugin extends EMFPlugin {
   /**
    * Keep track of the singleton.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public static final ViewmodelEditorPlugin INSTANCE = new ViewmodelEditorPlugin();
   
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
   public ViewmodelEditorPlugin() {
      super
         (new ResourceLocator [] {
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
   public static class Implementation extends EclipseUIPlugin {
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
