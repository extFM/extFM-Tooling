/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar;

public class MtextContainment extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public MtextContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextStringUtil.explode(allowedTypes, ", ", new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
