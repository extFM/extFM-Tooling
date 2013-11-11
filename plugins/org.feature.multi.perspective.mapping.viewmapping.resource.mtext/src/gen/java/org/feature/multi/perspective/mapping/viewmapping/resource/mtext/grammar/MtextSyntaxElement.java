/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class MtextSyntaxElement {
	
	private MtextSyntaxElement[] children;
	private MtextSyntaxElement parent;
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality;
	
	public MtextSyntaxElement(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality, MtextSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (MtextSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(MtextSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public MtextSyntaxElement getParent() {
		return parent;
	}
	
	public MtextSyntaxElement[] getChildren() {
		if (children == null) {
			return new MtextSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality getCardinality() {
		return cardinality;
	}
	
}
