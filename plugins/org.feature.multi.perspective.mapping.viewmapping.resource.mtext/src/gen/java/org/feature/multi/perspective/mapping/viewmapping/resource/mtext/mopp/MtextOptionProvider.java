/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'org.feature.multi.perspective.mapping.viewmapping.resource.mtext.default_load_o
 * ptions' with the difference that the options defined in this class are used
 * even if no Eclipse platform is running.
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextOptionProvider implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptionProvider {
	
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
		return java.util.Collections.emptyMap();
	}
	
}
