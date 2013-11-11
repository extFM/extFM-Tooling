/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util;

/**
 * Class MtextTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextResou
 * rceUtil.
 */
public class MtextTextResourceUtil {
	
	/**
	 * Use
	 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextResou
	 * rceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextResource getResource(org.eclipse.core.resources.IFile file) {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextResou
	 * rceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextResou
	 * rceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextResource getResource(org.eclipse.emf.common.util.URI uri) {
		return org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextResou
	 * rceUtil.getResource() instead.
	 */
	@Deprecated	
	public static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextResourceUtil.getResource(uri, options);
	}
	
}
