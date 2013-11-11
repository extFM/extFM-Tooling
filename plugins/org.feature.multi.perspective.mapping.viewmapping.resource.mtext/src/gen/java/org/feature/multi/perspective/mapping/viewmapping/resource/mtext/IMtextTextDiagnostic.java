/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

/**
 * An extended diagnostic that gives access to the exact position of the problem
 * in a character stream.
 */
public interface IMtextTextDiagnostic extends org.eclipse.emf.ecore.resource.Resource.Diagnostic {
	
	/**
	 * Returns the position of the first character of the problem area.
	 */
	public int getCharStart();
	
	/**
	 * Returns the position of the last character of the problem area.
	 */
	public int getCharEnd();
	
	/**
	 * Returns the column of the problem area.
	 */
	public int getColumn();
	
	/**
	 * Returns the line that contains the problem area.
	 */
	public int getLine();
	
	/**
	 * Returns the problem that was found.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem getProblem();
	
	/**
	 * Checks whether the problem was caused by the given element.
	 * 
	 * @return true if the problem was caused by <code>element</code>
	 */
	public boolean wasCausedBy(org.eclipse.emf.ecore.EObject element);
	
}
