/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

/**
 * A mapping from an identifier to an EObject.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IMtextElementMapping<ReferenceType> extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
