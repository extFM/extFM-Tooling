/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextNewFileContentProvider {
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextMetaInformation getMetaInformation() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		String content = "";
		for (org.eclipse.emf.ecore.EClass next : startClasses) {
			content = getExampleContent(next, allClassesWithSyntax, newFileName);
			if (content.trim().length() > 0) {
				break;
			}
		}
		return content;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextMinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextRuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextPrinter getPrinter(java.io.OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextResource());
	}
	
}
