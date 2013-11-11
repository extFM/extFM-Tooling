/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see
 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.R
 * ESOURCE_CONTENT_TYPE
 */
public class MtextUnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  MtextUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
