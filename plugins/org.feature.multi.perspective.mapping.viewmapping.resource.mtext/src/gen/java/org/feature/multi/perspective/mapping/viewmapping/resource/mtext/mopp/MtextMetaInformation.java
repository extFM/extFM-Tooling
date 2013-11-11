/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

public class MtextMetaInformation implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextMetaInformation {
	
	public String getSyntaxName() {
		return "mtext";
	}
	
	public String getURI() {
		return "http://www.tudresden.de/viewmapping";
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextScanner createLexer() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextAntlrScanner(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextLexer());
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextParser().createInstance(inputStream, encoding);
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextPrinter createPrinter(java.io.OutputStream outputStream, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource resource) {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextReferenceResolverSwitch();
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolverFactory getTokenResolverFactory() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.feature.multi.perspective.mapping/model/viewmapping.cs";
	}
	
	public String[] getTokenNames() {
		return org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextParser.tokenNames;
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextBracketPair> getBracketPairs() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextResourceFactory();
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextNewFileContentProvider getNewFileContentProvider() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "org.feature.multi.perspective.mapping.viewmapping.resource.mtext.ui.launchConfigurationType";
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextNameProvider createNameProvider() {
		return new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.analysis.MtextDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextAntlrTokenHelper tokenHelper = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
