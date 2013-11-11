/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

public class MtextHoverTextProvider implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextHoverTextProvider {
	
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextDefaultHoverTextProvider defaultProvider = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextDefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject referencedObject) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(referencedObject);
	}
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
