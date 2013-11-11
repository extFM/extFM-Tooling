/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IMtextParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>> getPostParseCommands();
	
}
