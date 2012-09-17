package org.js.model.feature.ptnet.m2m.atl;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;



/**
 * @author Julia Schroeter
 *
 */
public class ATLTransformPetriPlugin extends AbstractUIPlugin {

// The plug-in ID
   public static final String PLUGIN_ID = "org.js.model.feature.ptnet.m2m.atl"; //$NON-NLS-1$

   // The shared instance
   private static ATLTransformPetriPlugin plugin;
   
   /**
    * The constructor
    */
   public ATLTransformPetriPlugin() {
   }

   /*
    * (non-Javadoc)
    * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
    */
   public void start(BundleContext context) throws Exception {
       super.start(context);
       plugin = this;
   }

   /*
    * (non-Javadoc)
    * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
    */
   public void stop(BundleContext context) throws Exception {
       plugin = null;
       super.stop(context);
   }

   /**
    * Returns the shared instance
    *
    * @return the shared instance
    */
   public static ATLTransformPetriPlugin getDefault() {
       return plugin;
   }

   
}
