/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private ExpressionSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public ExpressionSyntaxElementDecorator(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement decoratedElement, ExpressionSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public ExpressionSyntaxElementDecorator[] getChildDecorators() {
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
