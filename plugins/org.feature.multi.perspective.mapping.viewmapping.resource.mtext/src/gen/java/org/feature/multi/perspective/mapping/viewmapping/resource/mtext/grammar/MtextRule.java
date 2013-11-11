/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

/**
 * A class to represent a rules in the grammar.
 */
public class MtextRule extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement {
	
	private final org.eclipse.emf.ecore.EClass metaclass;
	
	public MtextRule(org.eclipse.emf.ecore.EClass metaclass, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice choice, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality) {
		super(cardinality, new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return metaclass;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice getDefinition() {
		return (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice) getChildren()[0];
	}
	
}

