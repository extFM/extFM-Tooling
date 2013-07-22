package org.js.model.feature.csp;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.internal.util.BundleUtility;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class CSPPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.js.model.feature.csp"; //$NON-NLS-1$

	// The shared instance
	private static CSPPlugin plugin;
	
	/**
	 * The constructor
	 */
	public CSPPlugin() {
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
	public static CSPPlugin getDefault() {
		return plugin;
	}

	
	@SuppressWarnings("restriction")
	public static Image getImage(String imagePath) {
		Bundle bundle = Platform.getBundle(PLUGIN_ID);
		URL fullPathString = BundleUtility.find(bundle, imagePath);
		ImageDescriptor descriptor = ImageDescriptor.createFromURL(fullPathString);
		Image image = descriptor.createImage();
		return image;
	}

}
