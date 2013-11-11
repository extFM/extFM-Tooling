/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see
 * org.emftext.term.propositional.expression.resource.expression.IExpressionOptions
 * .RESOURCE_CONTENT_TYPE
 */
public class ExpressionUnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  ExpressionUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
