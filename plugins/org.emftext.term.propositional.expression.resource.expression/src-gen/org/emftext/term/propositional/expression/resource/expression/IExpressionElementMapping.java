/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression;

/**
 * A mapping from an identifier to an EObject.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IExpressionElementMapping<ReferenceType> extends org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the target object the identifier is mapped to.
	 */
	public ReferenceType getTargetElement();
}
