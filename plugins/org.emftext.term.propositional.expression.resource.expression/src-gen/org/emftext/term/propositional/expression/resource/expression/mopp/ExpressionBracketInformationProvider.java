/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionBracketInformationProvider {
	
	public class BracketPair implements org.emftext.term.propositional.expression.resource.expression.IExpressionBracketPair {
		
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
	
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionBracketPair> getBracketPairs() {
		java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionBracketPair> result = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.IExpressionBracketPair>();
		result.add(new BracketPair("(", ")", true));
		return result;
	}
	
}
