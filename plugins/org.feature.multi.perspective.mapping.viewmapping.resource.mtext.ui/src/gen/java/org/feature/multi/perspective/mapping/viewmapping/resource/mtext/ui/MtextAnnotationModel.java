/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

public class MtextAnnotationModel extends org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel {
	
	public MtextAnnotationModel(org.eclipse.core.resources.IResource resource) {
		super(resource);
	}
	
	protected org.eclipse.ui.texteditor.MarkerAnnotation createMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextMarkerAnnotation(marker);
	}
	
}
