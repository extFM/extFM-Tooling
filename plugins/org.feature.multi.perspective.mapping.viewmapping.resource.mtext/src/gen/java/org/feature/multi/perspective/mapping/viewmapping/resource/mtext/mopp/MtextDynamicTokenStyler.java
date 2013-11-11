/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextDynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenStyle getDynamicTokenStyle(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource resource, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextToken token, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
}
