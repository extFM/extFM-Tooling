/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextTokenStyleInformationProvider {
	
	public static String TASK_ITEM_TOKEN_NAME = "TASK_ITEM";
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenStyle getDefaultTokenStyle(String tokenName) {
		if ("viewmapping".equals(tokenName)) {
			return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("featuremodel".equals(tokenName)) {
			return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("viewmodel".equals(tokenName)) {
			return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("view group".equals(tokenName)) {
			return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("contains".equals(tokenName)) {
			return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenStyle(new int[] {0x80, 0x00, 0x55}, null, true, false, false, false);
		}
		if ("QUOTED_60_62".equals(tokenName)) {
			return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("QUOTED_34_34".equals(tokenName)) {
			return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenStyle(new int[] {0x2A, 0x00, 0xFF}, null, false, false, false, false);
		}
		if ("TASK_ITEM".equals(tokenName)) {
			return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenStyle(new int[] {0x7F, 0x9F, 0xBF}, null, true, false, false, false);
		}
		return null;
	}
	
}
