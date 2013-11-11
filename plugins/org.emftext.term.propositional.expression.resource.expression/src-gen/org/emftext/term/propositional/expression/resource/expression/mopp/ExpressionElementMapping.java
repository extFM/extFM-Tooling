/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * A basic implementation of the
 * org.emftext.term.propositional.expression.resource.expression.IExpressionElement
 * Mapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class ExpressionElementMapping<ReferenceType> implements org.emftext.term.propositional.expression.resource.expression.IExpressionElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public ExpressionElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
