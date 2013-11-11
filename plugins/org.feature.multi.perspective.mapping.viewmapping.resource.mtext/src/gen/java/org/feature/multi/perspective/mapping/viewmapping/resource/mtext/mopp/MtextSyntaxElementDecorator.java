/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private MtextSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public MtextSyntaxElementDecorator(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement decoratedElement, MtextSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public MtextSyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
