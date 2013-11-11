/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextBuilderAdapter extends org.eclipse.core.resources.IncrementalProjectBuilder implements org.eclipse.core.resources.IResourceDeltaVisitor, org.eclipse.core.resources.IResourceVisitor {
	
	/**
	 * The ID of the default, generated builder.
	 */
	public final static String BUILDER_ID = "org.feature.multi.perspective.mapping.viewmapping.resource.mtext.builder";
	
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextBuilder defaultBuilder = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextBuilder();
	
	/**
	 * This resource set is used during the whole build.
	 */
	private org.eclipse.emf.ecore.resource.ResourceSet resourceSet;
	
	/**
	 * This monitor is used during the build.
	 */
	private org.eclipse.core.runtime.IProgressMonitor monitor;
	
	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map<String, String> args, final org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		// Set context for build
		this.monitor = monitor;
		this.resourceSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		// Perform build by calling the resource visitors
		org.eclipse.core.resources.IResourceDelta delta = getDelta(getProject());
		if (delta != null) {
			// This is an incremental build
			delta.accept(this);
		} else {
			// This is a full build
			getProject().accept(this);
		}
		// Reset build context
		this.resourceSet = null;
		this.monitor = null;
		return null;
	}
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextBuilder builder = getBuilder();
		if (builder.isBuildingNeeded(uri)) {
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextResource customResource = (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextResource) resourceSet.getResource(uri, true);
			new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			builder.build(customResource, monitor);
		}
	}
	
	/**
	 * Returns the builder that shall be used by this adapter. This allows subclasses
	 * to perform builds with different builders.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextBuilder getBuilder() {
		return defaultBuilder;
	}
	
	/**
	 * Returns the id for the markers that are created by this builder. This allows
	 * subclasses to produce different kinds of markers.
	 */
	public String getBuilderMarkerId() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper().getMarkerID(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.BUILDER_ERROR);
	}
	
	/**
	 * Runs the task item builder to search for new task items in changed resources.
	 */
	public void runTaskItemBuilder(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTaskItemBuilder taskItemBuilder = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTaskItemBuilder();
		new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper().removeAllMarkers(resource, taskItemBuilder.getBuilderMarkerId());
		taskItemBuilder.build(resource, resourceSet, monitor);
	}
	
	@Override	
	public boolean visit(org.eclipse.core.resources.IResourceDelta delta) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IResource resource = delta.getResource();
		return doVisit(resource, delta.getKind() == org.eclipse.core.resources.IResourceDelta.REMOVED);
	}
	
	@Override	
	public boolean visit(org.eclipse.core.resources.IResource resource) throws org.eclipse.core.runtime.CoreException {
		return doVisit(resource, false);
	}
	
	protected boolean doVisit(org.eclipse.core.resources.IResource resource, boolean removed) throws org.eclipse.core.runtime.CoreException {
		if (removed) {
			org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextBuilder builder = getBuilder();
			if (builder.isBuildingNeeded(uri)) {
				builder.handleDeletion(uri, monitor);
			}
			new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			return false;
		}
		if (resource instanceof org.eclipse.core.resources.IFile && resource.getName().endsWith("." + new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation().getSyntaxName())) {
			// First, call the default generated builder that is usually customized to add
			// compilation-like behavior.
			build((org.eclipse.core.resources.IFile) resource, resourceSet, monitor);
			// Second, call the task item builder that searches for task items in DSL
			// documents and creates task markers.
			runTaskItemBuilder((org.eclipse.core.resources.IFile) resource, resourceSet, monitor);
			return false;
		}
		return true;
	}
	
}
