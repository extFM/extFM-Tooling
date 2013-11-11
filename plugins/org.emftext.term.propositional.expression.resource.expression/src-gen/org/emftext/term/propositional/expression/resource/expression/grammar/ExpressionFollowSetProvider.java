/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class ExpressionFollowSetProvider {
	
	public final static org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement TERMINALS[] = new org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement[6];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[4];
	
	public final static org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] LINKS = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[45];
	
	public final static org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] EMPTY_LINK_ARRAY = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedCsString(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_3_0_0_0);
		TERMINALS[1] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedCsString(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_4_0_0_0);
		TERMINALS[2] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedStructuralFeature(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_5_0_0_0);
		TERMINALS[3] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedCsString(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_1_0_0_1);
		TERMINALS[4] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedCsString(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_2_0_0_1);
		TERMINALS[5] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedCsString(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_4_0_0_2);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getBinaryOperator().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.BINARY_OPERATOR__OPERAND1);
		FEATURES[1] = org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getBinaryOperator().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.BINARY_OPERATOR__OPERAND2);
		FEATURES[2] = org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getUnaryOperator().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.UNARY_OPERATOR__OPERAND);
		FEATURES[3] = org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getConstraint().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.CONSTRAINT__TERM);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), FEATURES[0]);
		LINKS[1] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[2] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[3]);
		LINKS[3] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), FEATURES[0]);
		LINKS[4] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[5] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[3]);
		LINKS[6] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef(), FEATURES[0]);
		LINKS[7] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[8] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[3]);
		LINKS[9] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), FEATURES[0]);
		LINKS[10] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[11] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]);
		LINKS[12] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), FEATURES[0]);
		LINKS[13] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[14] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]);
		LINKS[15] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef(), FEATURES[0]);
		LINKS[16] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[17] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]);
		LINKS[18] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), FEATURES[0]);
		LINKS[19] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[20] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]);
		LINKS[21] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), FEATURES[0]);
		LINKS[22] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[23] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]);
		LINKS[24] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef(), FEATURES[0]);
		LINKS[25] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[26] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]);
		LINKS[27] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), FEATURES[0]);
		LINKS[28] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[29] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]);
		LINKS[30] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), FEATURES[0]);
		LINKS[31] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[32] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]);
		LINKS[33] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef(), FEATURES[0]);
		LINKS[34] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[35] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]);
		LINKS[36] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), FEATURES[0]);
		LINKS[37] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[38] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]);
		LINKS[39] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), FEATURES[0]);
		LINKS[40] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[41] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]);
		LINKS[42] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef(), FEATURES[0]);
		LINKS[43] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]);
		LINKS[44] = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[3].addFollower(TERMINALS[0], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]), });
		TERMINALS[3].addFollower(TERMINALS[1], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]), });
		TERMINALS[3].addFollower(TERMINALS[2], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]), });
		TERMINALS[4].addFollower(TERMINALS[0], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]), });
		TERMINALS[4].addFollower(TERMINALS[1], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]), });
		TERMINALS[4].addFollower(TERMINALS[2], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[1]), });
		TERMINALS[0].addFollower(TERMINALS[0], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]), });
		TERMINALS[0].addFollower(TERMINALS[1], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]), });
		TERMINALS[0].addFollower(TERMINALS[2], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]), });
		TERMINALS[1].addFollower(TERMINALS[0], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]), });
		TERMINALS[1].addFollower(TERMINALS[1], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]), });
		TERMINALS[1].addFollower(TERMINALS[2], new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] {new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), FEATURES[0]), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), FEATURES[2]), });
		TERMINALS[5].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[5].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[5], EMPTY_LINK_ARRAY);
	}
	
	public static void wire() {
		wire0();
	}
	
	static {
		// initialize the arrays
		initializeTerminals();
		initializeFeatures();
		initializeLinks();
		// wire the terminals
		wire();
	}
}
