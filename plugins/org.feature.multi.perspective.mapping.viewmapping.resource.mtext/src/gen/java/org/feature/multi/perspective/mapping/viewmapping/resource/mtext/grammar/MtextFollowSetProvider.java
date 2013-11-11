/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

/**
 * This class provides the follow sets for all terminals of the grammar. These
 * sets are used during code completion.
 */
public class MtextFollowSetProvider {
	
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement TERMINALS[] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement[9];
	
	public final static org.eclipse.emf.ecore.EStructuralFeature[] FEATURES = new org.eclipse.emf.ecore.EStructuralFeature[1];
	
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[] LINKS = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[5];
	
	public final static org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[] EMPTY_LINK_ARRAY = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[0];
	
	public static void initializeTerminals0() {
		TERMINALS[0] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedCsString(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_0_0_0_0);
		TERMINALS[1] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedCsString(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_0_0_0_3_0_0_0);
		TERMINALS[2] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_0_0_0_3_0_0_2);
		TERMINALS[3] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedCsString(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_0_0_0_6_0_0_0);
		TERMINALS[4] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_0_0_0_6_0_0_2);
		TERMINALS[5] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedCsString(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_1_0_0_0);
		TERMINALS[6] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_1_0_0_2);
		TERMINALS[7] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedCsString(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_1_0_0_4);
		TERMINALS[8] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_1_0_0_7_0_0_0);
	}
	
	public static void initializeTerminals() {
		initializeTerminals0();
	}
	
	public static void initializeFeatures0() {
		FEATURES[0] = org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__MAPPINGS);
	}
	
	public static void initializeFeatures() {
		initializeFeatures0();
	}
	
	public static void initializeLinks0() {
		LINKS[0] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping(), FEATURES[0]);
		LINKS[1] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping(), FEATURES[0]);
		LINKS[2] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping(), FEATURES[0]);
		LINKS[3] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping(), FEATURES[0]);
		LINKS[4] = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping(), FEATURES[0]);
	}
	
	public static void initializeLinks() {
		initializeLinks0();
	}
	
	public static void wire0() {
		TERMINALS[0].addFollower(TERMINALS[1], EMPTY_LINK_ARRAY);
		TERMINALS[1].addFollower(TERMINALS[2], EMPTY_LINK_ARRAY);
		TERMINALS[2].addFollower(TERMINALS[3], EMPTY_LINK_ARRAY);
		TERMINALS[3].addFollower(TERMINALS[4], EMPTY_LINK_ARRAY);
		TERMINALS[4].addFollower(TERMINALS[5], new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[] {new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping(), FEATURES[0]), });
		TERMINALS[5].addFollower(TERMINALS[6], EMPTY_LINK_ARRAY);
		TERMINALS[6].addFollower(TERMINALS[7], EMPTY_LINK_ARRAY);
		TERMINALS[7].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[8], EMPTY_LINK_ARRAY);
		TERMINALS[8].addFollower(TERMINALS[5], new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[] {new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping(), FEATURES[0]), });
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
