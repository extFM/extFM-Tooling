/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextBracketInformationProvider {
	
	public class BracketPair implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextBracketPair {
		
		private String opening;
		private String closing;
		private boolean closingEnabledInside;
		
		public BracketPair(String opening, String closing, boolean closingEnabledInside) {
			super();
			this.opening = opening;
			this.closing = closing;
			this.closingEnabledInside = closingEnabledInside;
		}
		
		public String getOpeningBracket() {
			return opening;
		}
		
		public String getClosingBracket() {
			return closing;
		}
		
		public boolean isClosingEnabledInside() {
			return closingEnabledInside;
		}
	}
	
	public java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextBracketPair> getBracketPairs() {
		java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextBracketPair> result = new java.util.ArrayList<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextBracketPair>();
		result.add(new BracketPair("<", ">", false));
		result.add(new BracketPair("\"", "\"", false));
		return result;
	}
	
}
