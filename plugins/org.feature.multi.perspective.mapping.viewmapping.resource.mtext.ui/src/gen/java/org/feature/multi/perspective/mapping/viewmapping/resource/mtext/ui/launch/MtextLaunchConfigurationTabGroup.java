/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.launch;

/**
 * A class that provides the tabs for the launch configuration.
 */
public class MtextLaunchConfigurationTabGroup extends org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup {
	
	public void createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog dialog, String mode) {
		// Set the overrideLaunchConfigurationTabGroup option to false to implement this
		// method.
		setTabs(new org.eclipse.debug.ui.ILaunchConfigurationTab[] {new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.launch.MtextLaunchConfigurationMainTab()});
	}
	
}
