/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextParseResult implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>> commands = new java.util.ArrayList<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>>();
	
	public MtextParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
