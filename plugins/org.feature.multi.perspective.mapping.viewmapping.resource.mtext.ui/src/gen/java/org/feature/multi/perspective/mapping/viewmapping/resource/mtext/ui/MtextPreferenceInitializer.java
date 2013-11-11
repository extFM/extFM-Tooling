/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui;

/**
 * A class used to initialize default preference values.
 */
public class MtextPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextBracketSet bracketSet = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextBracketSet(null, null);
		final java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.MtextSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
