/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionMetaInformation implements org.emftext.term.propositional.expression.resource.expression.IExpressionMetaInformation {
	
	public String getSyntaxName() {
		return "expression";
	}
	
	public String getURI() {
		return "http://www.tu-dresden.de/expression";
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTextScanner createLexer() {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionAntlrScanner(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLexer());
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionParser().createInstance(inputStream, encoding);
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTextPrinter createPrinter(java.io.OutputStream outputStream, org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource resource) {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolverSwitch getReferenceResolverSwitch() {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionReferenceResolverSwitch();
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolverFactory getTokenResolverFactory() {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "org.emftext.term.propositional/model/PropositionalTerm.cs";
	}
	
	public String[] getTokenNames() {
		return org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionParser.tokenNames;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTokenStyle getDefaultTokenStyle(String tokenName) {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionBracketPair> getBracketPairs() {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionResourceFactory();
	}
	
	public org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionNewFileContentProvider getNewFileContentProvider() {
		return new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionResourceFactory());
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
		return "org.emftext.term.propositional.expression.resource.expression.ui.launchConfigurationType";
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionNameProvider createNameProvider() {
		return new org.emftext.term.propositional.expression.resource.expression.analysis.ExpressionDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionAntlrTokenHelper tokenHelper = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionAntlrTokenHelper();
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
		highlightableTokens.add(org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
