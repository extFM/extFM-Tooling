/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

public interface IMtextNameProvider {
	
	/**
	 * Returns a list of potential identifiers that may be used to reference the given
	 * element. This method can be used to customize the identification of elements.
	 */
	public java.util.List<String> getNames(org.eclipse.emf.ecore.EObject element);
	
}
