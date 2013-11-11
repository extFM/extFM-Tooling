/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

public class MtextGrammarInformationProvider {
	
	public final static org.eclipse.emf.ecore.EStructuralFeature ANONYMOUS_FEATURE = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEAttribute();
	static {
		ANONYMOUS_FEATURE.setName("_");
	}
	
	public final static MtextGrammarInformationProvider INSTANCE = new MtextGrammarInformationProvider();
	
	private java.util.Set<String> keywords;
	
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword MTEXT_0_0_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword("viewmapping", org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak MTEXT_0_0_0_1 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace MTEXT_0_0_0_2 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace(3, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword MTEXT_0_0_0_3_0_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword("featuremodel", org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace MTEXT_0_0_0_3_0_0_1 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace(1, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextPlaceholder MTEXT_0_0_0_3_0_0_2 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextPlaceholder(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL), "QUOTED_60_62", org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence MTEXT_0_0_0_3_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_0_0_0_3_0_0_0, MTEXT_0_0_0_3_0_0_1, MTEXT_0_0_0_3_0_0_2);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice MTEXT_0_0_0_3_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_0_0_0_3_0_0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCompound MTEXT_0_0_0_3 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCompound(MTEXT_0_0_0_3_0, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak MTEXT_0_0_0_4 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace MTEXT_0_0_0_5 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace(3, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword MTEXT_0_0_0_6_0_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword("viewmodel", org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace MTEXT_0_0_0_6_0_0_1 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace(1, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextPlaceholder MTEXT_0_0_0_6_0_0_2 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextPlaceholder(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL), "QUOTED_60_62", org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence MTEXT_0_0_0_6_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_0_0_0_6_0_0_0, MTEXT_0_0_0_6_0_0_1, MTEXT_0_0_0_6_0_0_2);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice MTEXT_0_0_0_6_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_0_0_0_6_0_0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCompound MTEXT_0_0_0_6 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCompound(MTEXT_0_0_0_6_0, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak MTEXT_0_0_0_7 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak MTEXT_0_0_0_8 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextContainment MTEXT_0_0_0_9_0_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextContainment(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__MAPPINGS), org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.STAR, new org.eclipse.emf.ecore.EClass[] {org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping(), }, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence MTEXT_0_0_0_9_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_0_0_0_9_0_0_0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice MTEXT_0_0_0_9_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_0_0_0_9_0_0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCompound MTEXT_0_0_0_9 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCompound(MTEXT_0_0_0_9_0, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence MTEXT_0_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_0_0_0_0, MTEXT_0_0_0_1, MTEXT_0_0_0_2, MTEXT_0_0_0_3, MTEXT_0_0_0_4, MTEXT_0_0_0_5, MTEXT_0_0_0_6, MTEXT_0_0_0_7, MTEXT_0_0_0_8, MTEXT_0_0_0_9);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice MTEXT_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_0_0_0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextRule MTEXT_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextRule(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel(), MTEXT_0_0, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword MTEXT_1_0_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword("view group", org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace MTEXT_1_0_0_1 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace(1, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextPlaceholder MTEXT_1_0_0_2 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextPlaceholder(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__VIEWGROUP), "QUOTED_34_34", org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace MTEXT_1_0_0_3 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace(1, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword MTEXT_1_0_0_4 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword("contains", org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak MTEXT_1_0_0_5 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace MTEXT_1_0_0_6 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace(3, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextPlaceholder MTEXT_1_0_0_7_0_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextPlaceholder(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__FEATURES), "QUOTED_34_34", org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace MTEXT_1_0_0_7_0_0_1 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextWhiteSpace(1, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence MTEXT_1_0_0_7_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_1_0_0_7_0_0_0, MTEXT_1_0_0_7_0_0_1);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice MTEXT_1_0_0_7_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_1_0_0_7_0_0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCompound MTEXT_1_0_0_7 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCompound(MTEXT_1_0_0_7_0, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.PLUS);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak MTEXT_1_0_0_8 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak MTEXT_1_0_0_9 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextLineBreak(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, 0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence MTEXT_1_0_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSequence(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_1_0_0_0, MTEXT_1_0_0_1, MTEXT_1_0_0_2, MTEXT_1_0_0_3, MTEXT_1_0_0_4, MTEXT_1_0_0_5, MTEXT_1_0_0_6, MTEXT_1_0_0_7, MTEXT_1_0_0_8, MTEXT_1_0_0_9);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice MTEXT_1_0 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextChoice(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE, MTEXT_1_0_0);
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextRule MTEXT_1 = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextRule(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping(), MTEXT_1_0, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality.ONE);
	
	public static String getSyntaxElementID(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement syntaxElement) {
		if (syntaxElement == null) {
			// null indicates EOF
			return "<EOF>";
		}
		for (java.lang.reflect.Field field : org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.class.getFields()) {
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
	
	public static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement getSyntaxElementByID(String syntaxElementID) {
		try {
			return (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement) org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.class.getField(syntaxElementID).get(null);
		} catch (Exception e) {
			return null;
		}
	}
	
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextRule[] RULES = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextRule[] {
		MTEXT_0,
		MTEXT_1,
	};
	
	/**
	 * Returns all keywords of the grammar. This includes all literals for boolean and
	 * enumeration terminals.
	 */
	public java.util.Set<String> getKeywords() {
		if (this.keywords == null) {
			this.keywords = new java.util.LinkedHashSet<String>();
			for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextRule rule : RULES) {
				findKeywords(rule, this.keywords);
			}
		}
		return keywords;
	}
	
	/**
	 * Finds all keywords in the given element and its children and adds them to the
	 * set. This includes all literals for boolean and enumeration terminals.
	 */
	private void findKeywords(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement element, java.util.Set<String> keywords) {
		if (element instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword) {
			keywords.add(((org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextKeyword) element).getValue());
		} else if (element instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextBooleanTerminal) {
			keywords.add(((org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextBooleanTerminal) element).getTrueLiteral());
			keywords.add(((org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextBooleanTerminal) element).getFalseLiteral());
		} else if (element instanceof org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextEnumerationTerminal) {
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextEnumerationTerminal terminal = (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextEnumerationTerminal) element;
			for (String key : terminal.getLiteralMapping().keySet()) {
				keywords.add(key);
			}
		}
		for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement child : element.getChildren()) {
			findKeywords(child, this.keywords);
		}
	}
	
}
