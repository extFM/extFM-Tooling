/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

public class MtextUIMetaInformation extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation {
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextHoverTextProvider getHoverTextProvider() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextHoverTextProvider();
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextImageProvider getImageProvider() {
		return org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextImageProvider.INSTANCE;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextColorManager createColorManager() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(org.feature.multi.perspective.mapping.viewmapping.resource.mt
	 * ext.IMtextTextResource,
	 * org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextColorMa
	 * nager) instead.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextTokenScanner createTokenScanner(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextTokenScanner createTokenScanner(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource resource, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextColorManager colorManager) {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextTokenScanner(resource, colorManager);
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextCodeCompletionHelper createCodeCompletionHelper() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextCodeCompletionHelper();
	}
	
}
