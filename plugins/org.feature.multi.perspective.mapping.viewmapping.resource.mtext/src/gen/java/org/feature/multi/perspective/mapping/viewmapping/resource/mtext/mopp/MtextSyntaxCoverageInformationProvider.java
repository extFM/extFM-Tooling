/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel(),
			org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMapping(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel(),
		};
	}
	
}
