/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class MtextTokenResolveResult implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public MtextTokenResolveResult() {
		super();
		clear();
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Object getResolvedToken() {
		return resolvedToken;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void setResolvedToken(Object resolvedToken) {
		this.resolvedToken = resolvedToken;
	}
	
	public void clear() {
		errorMessage = "Can't resolve token.";
		resolvedToken = null;
	}
	
}
