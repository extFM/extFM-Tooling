package org.js.model.feature.quality.assurance;

import java.util.*;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.js.model.feature.*;
import org.js.model.feature.csp.*;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class QAPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.js.model.feature.quality.assurance"; //$NON-NLS-1$

	// The shared instance
	private static QAPlugin plugin;
	
	/**
	 * The constructor
	 */
	public QAPlugin() {
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
	public static QAPlugin getDefault() {
		return plugin;
	}

}
