/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.grammar;

public class ExpressionGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static ExpressionGrammarInformationProvider INSTANCE = new ExpressionGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment EXPRESSION_0_0_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getConstraint().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.CONSTRAINT__TERM), org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence EXPRESSION_0_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_0_0_0_0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice EXPRESSION_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_0_0_0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule EXPRESSION_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getConstraint(), EXPRESSION_0_0, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment EXPRESSION_1_0_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.OR__OPERAND1), org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword EXPRESSION_1_0_0_1 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword("or", org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment EXPRESSION_1_0_0_2 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.OR__OPERAND2), org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence EXPRESSION_1_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_1_0_0_0, EXPRESSION_1_0_0_1, EXPRESSION_1_0_0_2);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice EXPRESSION_1_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_1_0_0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule EXPRESSION_1 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), EXPRESSION_1_0, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment EXPRESSION_2_0_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.AND__OPERAND1), org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword EXPRESSION_2_0_0_1 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword("and", org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment EXPRESSION_2_0_0_2 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.AND__OPERAND2), org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence EXPRESSION_2_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_2_0_0_0, EXPRESSION_2_0_0_1, EXPRESSION_2_0_0_2);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice EXPRESSION_2_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_2_0_0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule EXPRESSION_2 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), EXPRESSION_2_0, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword EXPRESSION_3_0_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword("not", org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment EXPRESSION_3_0_0_1 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.NOT__OPERAND), org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence EXPRESSION_3_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_3_0_0_0, EXPRESSION_3_0_0_1);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice EXPRESSION_3_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_3_0_0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule EXPRESSION_3 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), EXPRESSION_3_0, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword EXPRESSION_4_0_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword("(", org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment EXPRESSION_4_0_0_1 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.NESTED__OPERAND), org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, new org.eclipse.emf.ecore.EClass[] {org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getTerm(), }, 0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword EXPRESSION_4_0_0_2 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword(")", org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence EXPRESSION_4_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_4_0_0_0, EXPRESSION_4_0_0_1, EXPRESSION_4_0_0_2);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice EXPRESSION_4_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_4_0_0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule EXPRESSION_4 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), EXPRESSION_4_0, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionPlaceholder EXPRESSION_5_0_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionPlaceholder(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.FEATURE_REF__FEATURE), "TEXT", org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, 0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence EXPRESSION_5_0_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSequence(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_5_0_0_0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice EXPRESSION_5_0 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE, EXPRESSION_5_0_0);
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule EXPRESSION_5 = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getFeatureRef(), EXPRESSION_5_0, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE);
	
	public static String getSyntaxElementID(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.class.getFields()) {
			Object fieldValue;
			try {
				fieldValue = field.get(null);
				if (fieldValue == syntaxElement) {
					String id = field.getName();
					return id;
				}
			} catch (Exception e) { }
		}
		return null;
	}
	
	public static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement) org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule[] RULES = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule[] {
		EXPRESSION_0,
		EXPRESSION_1,
		EXPRESSION_2,
		EXPRESSION_3,
		EXPRESSION_4,
		EXPRESSION_5,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword) {
			keywords.add(((org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword) element).getValue());
		} else if (element instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionBooleanTerminal) {
			keywords.add(((org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionEnumerationTerminal) {
			org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionEnumerationTerminal terminal = (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
