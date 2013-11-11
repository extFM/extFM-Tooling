// $ANTLR 3.4

	package org.emftext.term.propositional.expression.resource.expression.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ExpressionParser extends ExpressionANTLRParserBase {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LINEBREAK", "TEXT", "WHITESPACE", "'('", "')'", "'and'", "'not'", "'or'"
    };

    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int LINEBREAK=4;
    public static final int TEXT=5;
    public static final int WHITESPACE=6;

    // delegates
    public ExpressionANTLRParserBase[] getDelegates() {
        return new ExpressionANTLRParserBase[] {};
    }

    // delegators


    public ExpressionParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public ExpressionParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.initializeRuleMemo(15 + 1);
         

    }

    public String[] getTokenNames() { return ExpressionParser.tokenNames; }
    public String getGrammarFileName() { return "Expression.g"; }


    	private org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolverFactory tokenResolverFactory = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTokenResolverFactory();
    	
    	/**
    	 * the index of the last token that was handled by collectHiddenTokens()
    	 */
    	private int lastPosition;
    	
    	/**
    	 * A flag that indicates whether the parser should remember all expected elements.
    	 * This flag is set to true when using the parse for code completion. Otherwise it
    	 * is set to false.
    	 */
    	private boolean rememberExpectedElements = false;
    	
    	private Object parseToIndexTypeObject;
    	private int lastTokenIndex = 0;
    	
    	/**
    	 * A list of expected elements the were collected while parsing the input stream.
    	 * This list is only filled if <code>rememberExpectedElements</code> is set to
    	 * true.
    	 */
    	private java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal> expectedElements = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal>();
    	
    	private int mismatchedTokenRecoveryTries = 0;
    	/**
    	 * A helper list to allow a lexer to pass errors to its parser
    	 */
    	protected java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = java.util.Collections.synchronizedList(new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>());
    	
    	/**
    	 * Another helper list to allow a lexer to pass positions of errors to its parser
    	 */
    	protected java.util.List<Integer> lexerExceptionsPosition = java.util.Collections.synchronizedList(new java.util.ArrayList<Integer>());
    	
    	/**
    	 * A stack for incomplete objects. This stack is used filled when the parser is
    	 * used for code completion. Whenever the parser starts to read an object it is
    	 * pushed on the stack. Once the element was parser completely it is popped from
    	 * the stack.
    	 */
    	java.util.List<org.eclipse.emf.ecore.EObject> incompleteObjects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
    	
    	private int stopIncludingHiddenTokens;
    	private int stopExcludingHiddenTokens;
    	private int tokenIndexOfLastCompleteElement;
    	
    	private int expectedElementsIndexOfLastCompleteElement;
    	
    	/**
    	 * The offset indicating the cursor position when the parser is used for code
    	 * completion by calling parseToExpectedElements().
    	 */
    	private int cursorOffset;
    	
    	/**
    	 * The offset of the first hidden token of the last expected element. This offset
    	 * is used to discard expected elements, which are not needed for code completion.
    	 */
    	private int lastStartIncludingHidden;
    	
    	protected void addErrorToResource(final String errorMessage, final int column, final int line, final int startIndex, final int stopIndex) {
    		postParseCommands.add(new org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>() {
    			public boolean execute(org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource resource) {
    				if (resource == null) {
    					// the resource can be null if the parser is used for code completion
    					return true;
    				}
    				resource.addProblem(new org.emftext.term.propositional.expression.resource.expression.IExpressionProblem() {
    					public org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity getSeverity() {
    						return org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity.ERROR;
    					}
    					public org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType getType() {
    						return org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.SYNTAX_ERROR;
    					}
    					public String getMessage() {
    						return errorMessage;
    					}
    					public java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionQuickFix> getQuickFixes() {
    						return null;
    					}
    				}, column, line, startIndex, stopIndex);
    				return true;
    			}
    		});
    	}
    	
    	public void addExpectedElement(org.eclipse.emf.ecore.EClass eClass, int[] ids) {
    		if (!this.rememberExpectedElements) {
    			return;
    		}
    		int terminalID = ids[0];
    		int followSetID = ids[1];
    		org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement terminal = org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFollowSetProvider.TERMINALS[terminalID];
    		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[] containmentFeatures = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[ids.length - 2];
    		for (int i = 2; i < ids.length; i++) {
    			containmentFeatures[i - 2] = org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFollowSetProvider.LINKS[ids[i]];
    		}
    		org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainmentTrace containmentTrace = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainmentTrace(eClass, containmentFeatures);
    		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal expectedElement = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal(container, terminal, followSetID, containmentTrace);
    		setPosition(expectedElement, input.index());
    		int startIncludingHiddenTokens = expectedElement.getStartIncludingHiddenTokens();
    		if (lastStartIncludingHidden >= 0 && lastStartIncludingHidden < startIncludingHiddenTokens && cursorOffset > startIncludingHiddenTokens) {
    			// clear list of expected elements
    			this.expectedElements.clear();
    			this.expectedElementsIndexOfLastCompleteElement = 0;
    		}
    		lastStartIncludingHidden = startIncludingHiddenTokens;
    		this.expectedElements.add(expectedElement);
    	}
    	
    	protected void collectHiddenTokens(org.eclipse.emf.ecore.EObject element) {
    	}
    	
    	protected void copyLocalizationInfos(final org.eclipse.emf.ecore.EObject source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>() {
    			public boolean execute(org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource resource) {
    				org.emftext.term.propositional.expression.resource.expression.IExpressionLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharStart(target, locationMap.getCharStart(source));
    				locationMap.setCharEnd(target, locationMap.getCharEnd(source));
    				locationMap.setColumn(target, locationMap.getColumn(source));
    				locationMap.setLine(target, locationMap.getLine(source));
    				return true;
    			}
    		});
    	}
    	
    	protected void copyLocalizationInfos(final org.antlr.runtime3_4_0.CommonToken source, final org.eclipse.emf.ecore.EObject target) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>() {
    			public boolean execute(org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource resource) {
    				org.emftext.term.propositional.expression.resource.expression.IExpressionLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				if (source == null) {
    					return true;
    				}
    				locationMap.setCharStart(target, source.getStartIndex());
    				locationMap.setCharEnd(target, source.getStopIndex());
    				locationMap.setColumn(target, source.getCharPositionInLine());
    				locationMap.setLine(target, source.getLine());
    				return true;
    			}
    		});
    	}
    	
    	/**
    	 * Sets the end character index and the last line for the given object in the
    	 * location map.
    	 */
    	protected void setLocalizationEnd(java.util.Collection<org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
    		if (disableLocationMap) {
    			return;
    		}
    		postParseCommands.add(new org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>() {
    			public boolean execute(org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource resource) {
    				org.emftext.term.propositional.expression.resource.expression.IExpressionLocationMap locationMap = resource.getLocationMap();
    				if (locationMap == null) {
    					// the locationMap can be null if the parser is used for code completion
    					return true;
    				}
    				locationMap.setCharEnd(object, endChar);
    				locationMap.setLine(object, endLine);
    				return true;
    			}
    		});
    	}
    	
    	public org.emftext.term.propositional.expression.resource.expression.IExpressionTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
    		try {
    			if (encoding == null) {
    				return new ExpressionParser(new org.antlr.runtime3_4_0.CommonTokenStream(new ExpressionLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
    			} else {
    				return new ExpressionParser(new org.antlr.runtime3_4_0.CommonTokenStream(new ExpressionLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
    			}
    		} catch (java.io.IOException e) {
    			new org.emftext.term.propositional.expression.resource.expression.util.ExpressionRuntimeUtil().logError("Error while creating parser.", e);
    			return null;
    		}
    	}
    	
    	/**
    	 * This default constructor is only used to call createInstance() on it.
    	 */
    	public ExpressionParser() {
    		super(null);
    	}
    	
    	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
    		this.lastPosition = 0;
    		// required because the lexer class can not be subclassed
    		((ExpressionLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
    		((ExpressionLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
    		Object typeObject = getTypeObject();
    		if (typeObject == null) {
    			return start();
    		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
    			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
    			if (type.getInstanceClass() == org.emftext.term.propositional.expression.Constraint.class) {
    				return parse_org_emftext_term_propositional_expression_Constraint();
    			}
    		}
    		throw new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionUnexpectedContentTypeException(typeObject);
    	}
    	
    	public int getMismatchedTokenRecoveryTries() {
    		return mismatchedTokenRecoveryTries;
    	}
    	
    	public Object getMissingSymbol(org.antlr.runtime3_4_0.IntStream arg0, org.antlr.runtime3_4_0.RecognitionException arg1, int arg2, org.antlr.runtime3_4_0.BitSet arg3) {
    		mismatchedTokenRecoveryTries++;
    		return super.getMissingSymbol(arg0, arg1, arg2, arg3);
    	}
    	
    	public Object getParseToIndexTypeObject() {
    		return parseToIndexTypeObject;
    	}
    	
    	protected Object getTypeObject() {
    		Object typeObject = getParseToIndexTypeObject();
    		if (typeObject != null) {
    			return typeObject;
    		}
    		java.util.Map<?,?> options = getOptions();
    		if (options != null) {
    			typeObject = options.get(org.emftext.term.propositional.expression.resource.expression.IExpressionOptions.RESOURCE_CONTENT_TYPE);
    		}
    		return typeObject;
    	}
    	
    	/**
    	 * Implementation that calls {@link #doParse()} and handles the thrown
    	 * RecognitionExceptions.
    	 */
    	public org.emftext.term.propositional.expression.resource.expression.IExpressionParseResult parse() {
    		terminateParsing = false;
    		postParseCommands = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource>>();
    		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionParseResult parseResult = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionParseResult();
    		try {
    			org.eclipse.emf.ecore.EObject result =  doParse();
    			if (lexerExceptions.isEmpty()) {
    				parseResult.setRoot(result);
    			}
    		} catch (org.antlr.runtime3_4_0.RecognitionException re) {
    			reportError(re);
    		} catch (java.lang.IllegalArgumentException iae) {
    			if ("The 'no null' constraint is violated".equals(iae.getMessage())) {
    				// can be caused if a null is set on EMF models where not allowed. this will just
    				// happen if other errors occurred before
    			} else {
    				iae.printStackTrace();
    			}
    		}
    		for (org.antlr.runtime3_4_0.RecognitionException re : lexerExceptions) {
    			reportLexicalError(re);
    		}
    		parseResult.getPostParseCommands().addAll(postParseCommands);
    		return parseResult;
    	}
    	
    	public java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource dummyResource, int cursorOffset) {
    		this.rememberExpectedElements = true;
    		this.parseToIndexTypeObject = type;
    		this.cursorOffset = cursorOffset;
    		this.lastStartIncludingHidden = -1;
    		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
    		org.emftext.term.propositional.expression.resource.expression.IExpressionParseResult result = parse();
    		for (org.eclipse.emf.ecore.EObject incompleteObject : incompleteObjects) {
    			org.antlr.runtime3_4_0.Lexer lexer = (org.antlr.runtime3_4_0.Lexer) tokenStream.getTokenSource();
    			int endChar = lexer.getCharIndex();
    			int endLine = lexer.getLine();
    			setLocalizationEnd(result.getPostParseCommands(), incompleteObject, endChar, endLine);
    		}
    		if (result != null) {
    			org.eclipse.emf.ecore.EObject root = result.getRoot();
    			if (root != null) {
    				dummyResource.getContentsInternal().add(root);
    			}
    			for (org.emftext.term.propositional.expression.resource.expression.IExpressionCommand<org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource> command : result.getPostParseCommands()) {
    				command.execute(dummyResource);
    			}
    		}
    		// remove all expected elements that were added after the last complete element
    		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
    		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
    		java.util.Set<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal>();
    		java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal> newFollowSet = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal>();
    		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
    			org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal expectedElementI = expectedElements.get(i);
    			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
    				currentFollowSet.add(expectedElementI);
    			} else {
    				break;
    			}
    		}
    		int followSetID = 9;
    		int i;
    		for (i = tokenIndexOfLastCompleteElement; i < tokenStream.size(); i++) {
    			org.antlr.runtime3_4_0.CommonToken nextToken = (org.antlr.runtime3_4_0.CommonToken) tokenStream.get(i);
    			if (nextToken.getType() < 0) {
    				break;
    			}
    			if (nextToken.getChannel() == 99) {
    				// hidden tokens do not reduce the follow set
    			} else {
    				// now that we have found the next visible token the position for that expected
    				// terminals can be set
    				for (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal nextFollow : newFollowSet) {
    					lastTokenIndex = 0;
    					setPosition(nextFollow, i);
    				}
    				newFollowSet.clear();
    				// normal tokens do reduce the follow set - only elements that match the token are
    				// kept
    				for (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal nextFollow : currentFollowSet) {
    					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
    						// keep this one - it matches
    						java.util.Collection<org.emftext.term.propositional.expression.resource.expression.util.ExpressionPair<org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
    						for (org.emftext.term.propositional.expression.resource.expression.util.ExpressionPair<org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContainedFeature[]> newFollowerPair : newFollowers) {
    							org.emftext.term.propositional.expression.resource.expression.IExpressionExpectedElement newFollower = newFollowerPair.getLeft();
    							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
    							org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainmentTrace containmentTrace = new org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainmentTrace(null, newFollowerPair.getRight());
    							org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal newFollowTerminal = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal(container, newFollower, followSetID, containmentTrace);
    							newFollowSet.add(newFollowTerminal);
    							expectedElements.add(newFollowTerminal);
    						}
    					}
    				}
    				currentFollowSet.clear();
    				currentFollowSet.addAll(newFollowSet);
    			}
    			followSetID++;
    		}
    		// after the last token in the stream we must set the position for the elements
    		// that were added during the last iteration of the loop
    		for (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal nextFollow : newFollowSet) {
    			lastTokenIndex = 0;
    			setPosition(nextFollow, i);
    		}
    		return this.expectedElements;
    	}
    	
    	public void setPosition(org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectedTerminal expectedElement, int tokenIndex) {
    		int currentIndex = Math.max(0, tokenIndex);
    		for (int index = lastTokenIndex; index < currentIndex; index++) {
    			if (index >= input.size()) {
    				break;
    			}
    			org.antlr.runtime3_4_0.CommonToken tokenAtIndex = (org.antlr.runtime3_4_0.CommonToken) input.get(index);
    			stopIncludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			if (tokenAtIndex.getChannel() != 99 && !anonymousTokens.contains(tokenAtIndex)) {
    				stopExcludingHiddenTokens = tokenAtIndex.getStopIndex() + 1;
    			}
    		}
    		lastTokenIndex = Math.max(0, currentIndex);
    		expectedElement.setPosition(stopExcludingHiddenTokens, stopIncludingHiddenTokens);
    	}
    	
    	public Object recoverFromMismatchedToken(org.antlr.runtime3_4_0.IntStream input, int ttype, org.antlr.runtime3_4_0.BitSet follow) throws org.antlr.runtime3_4_0.RecognitionException {
    		if (!rememberExpectedElements) {
    			return super.recoverFromMismatchedToken(input, ttype, follow);
    		} else {
    			return null;
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the parser into human readable messages.
    	 */
    	public void reportError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = e.getMessage();
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			String expectedTokenName = formatTokenName(mte.expecting);
    			String actualTokenName = formatTokenName(e.token.getType());
    			message = "Syntax error on token \"" + e.token.getText() + " (" + actualTokenName + ")\", \"" + expectedTokenName + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedTreeNodeException) {
    			org.antlr.runtime3_4_0.MismatchedTreeNodeException mtne = (org.antlr.runtime3_4_0.MismatchedTreeNodeException) e;
    			String expectedTokenName = formatTokenName(mtne.expecting);
    			message = "mismatched tree node: " + "xxx" + "; tokenName " + expectedTokenName;
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", check following tokens";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			message = "Syntax error on token \"" + e.token.getText() + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched token: " + e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched token: " +  e.token + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" +  fpe.predicateText + "}?";
    		}
    		// the resource may be null if the parser is used for code completion
    		final String finalMessage = message;
    		if (e.token instanceof org.antlr.runtime3_4_0.CommonToken) {
    			final org.antlr.runtime3_4_0.CommonToken ct = (org.antlr.runtime3_4_0.CommonToken) e.token;
    			addErrorToResource(finalMessage, ct.getCharPositionInLine(), ct.getLine(), ct.getStartIndex(), ct.getStopIndex());
    		} else {
    			addErrorToResource(finalMessage, e.token.getCharPositionInLine(), e.token.getLine(), 1, 5);
    		}
    	}
    	
    	/**
    	 * Translates errors thrown by the lexer into human readable messages.
    	 */
    	public void reportLexicalError(final org.antlr.runtime3_4_0.RecognitionException e)  {
    		String message = "";
    		if (e instanceof org.antlr.runtime3_4_0.MismatchedTokenException) {
    			org.antlr.runtime3_4_0.MismatchedTokenException mte = (org.antlr.runtime3_4_0.MismatchedTokenException) e;
    			message = "Syntax error on token \"" + ((char) e.c) + "\", \"" + (char) mte.expecting + "\" expected";
    		} else if (e instanceof org.antlr.runtime3_4_0.NoViableAltException) {
    			message = "Syntax error on token \"" + ((char) e.c) + "\", delete this token";
    		} else if (e instanceof org.antlr.runtime3_4_0.EarlyExitException) {
    			org.antlr.runtime3_4_0.EarlyExitException eee = (org.antlr.runtime3_4_0.EarlyExitException) e;
    			message = "required (...)+ loop (decision=" + eee.decisionNumber + ") did not match anything; on line " + e.line + ":" + e.charPositionInLine + " char=" + ((char) e.c) + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedSetException) {
    			org.antlr.runtime3_4_0.MismatchedSetException mse = (org.antlr.runtime3_4_0.MismatchedSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedNotSetException) {
    			org.antlr.runtime3_4_0.MismatchedNotSetException mse = (org.antlr.runtime3_4_0.MismatchedNotSetException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set " + mse.expecting;
    		} else if (e instanceof org.antlr.runtime3_4_0.MismatchedRangeException) {
    			org.antlr.runtime3_4_0.MismatchedRangeException mre = (org.antlr.runtime3_4_0.MismatchedRangeException) e;
    			message = "mismatched char: '" + ((char) e.c) + "' on line " + e.line + ":" + e.charPositionInLine + "; expecting set '" + (char) mre.a + "'..'" + (char) mre.b + "'";
    		} else if (e instanceof org.antlr.runtime3_4_0.FailedPredicateException) {
    			org.antlr.runtime3_4_0.FailedPredicateException fpe = (org.antlr.runtime3_4_0.FailedPredicateException) e;
    			message = "rule " + fpe.ruleName + " failed predicate: {" + fpe.predicateText + "}?";
    		}
    		addErrorToResource(message, e.charPositionInLine, e.line, lexerExceptionsPosition.get(lexerExceptions.indexOf(e)), lexerExceptionsPosition.get(lexerExceptions.indexOf(e)));
    	}
    	
    	private void startIncompleteElement(Object object) {
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.incompleteObjects.add((org.eclipse.emf.ecore.EObject) object);
    		}
    	}
    	
    	private void completedElement(Object object, boolean isContainment) {
    		if (isContainment && !this.incompleteObjects.isEmpty()) {
    			boolean exists = this.incompleteObjects.remove(object);
    			if (!exists) {
    			}
    		}
    		if (object instanceof org.eclipse.emf.ecore.EObject) {
    			this.tokenIndexOfLastCompleteElement = getTokenStream().index();
    			this.expectedElementsIndexOfLastCompleteElement = expectedElements.size() - 1;
    		}
    	}
    	
    	private org.eclipse.emf.ecore.EObject getLastIncompleteElement() {
    		if (incompleteObjects.isEmpty()) {
    			return null;
    		}
    		return incompleteObjects.get(incompleteObjects.size() - 1);
    	}
    	



    // $ANTLR start "start"
    // Expression.g:499:1: start returns [ org.eclipse.emf.ecore.EObject element = null] : (c0= parse_org_emftext_term_propositional_expression_Constraint ) EOF ;
    public final org.eclipse.emf.ecore.EObject start() throws RecognitionException {
        org.eclipse.emf.ecore.EObject element =  null;

        int start_StartIndex = input.index();

        org.emftext.term.propositional.expression.Constraint c0 =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return element; }

            // Expression.g:500:2: ( (c0= parse_org_emftext_term_propositional_expression_Constraint ) EOF )
            // Expression.g:501:2: (c0= parse_org_emftext_term_propositional_expression_Constraint ) EOF
            {
            if ( state.backtracking==0 ) {
            		// follow set for start rule(s)
            		addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getConstraint(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[0]);
            		addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getConstraint(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[1]);
            		addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getConstraint(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[2]);
            		expectedElementsIndexOfLastCompleteElement = 0;
            	}

            // Expression.g:508:2: (c0= parse_org_emftext_term_propositional_expression_Constraint )
            // Expression.g:509:3: c0= parse_org_emftext_term_propositional_expression_Constraint
            {
            pushFollow(FOLLOW_parse_org_emftext_term_propositional_expression_Constraint_in_start82);
            c0=parse_org_emftext_term_propositional_expression_Constraint();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c0; }

            }


            match(input,EOF,FOLLOW_EOF_in_start89); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            		retrieveLayoutInformation(element, null, null, false);
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, start_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "start"



    // $ANTLR start "parse_org_emftext_term_propositional_expression_Constraint"
    // Expression.g:517:1: parse_org_emftext_term_propositional_expression_Constraint returns [org.emftext.term.propositional.expression.Constraint element = null] : (a0_0= parse_org_emftext_term_propositional_expression_Term ) ;
    public final org.emftext.term.propositional.expression.Constraint parse_org_emftext_term_propositional_expression_Constraint() throws RecognitionException {
        org.emftext.term.propositional.expression.Constraint element =  null;

        int parse_org_emftext_term_propositional_expression_Constraint_StartIndex = input.index();

        org.emftext.term.propositional.expression.Term a0_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return element; }

            // Expression.g:520:2: ( (a0_0= parse_org_emftext_term_propositional_expression_Term ) )
            // Expression.g:521:2: (a0_0= parse_org_emftext_term_propositional_expression_Term )
            {
            // Expression.g:521:2: (a0_0= parse_org_emftext_term_propositional_expression_Term )
            // Expression.g:522:3: a0_0= parse_org_emftext_term_propositional_expression_Term
            {
            pushFollow(FOLLOW_parse_org_emftext_term_propositional_expression_Term_in_parse_org_emftext_term_propositional_expression_Constraint119);
            a0_0=parse_org_emftext_term_propositional_expression_Term();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            			if (terminateParsing) {
            				throw new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTerminateParsingException();
            			}
            			if (element == null) {
            				element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createConstraint();
            				startIncompleteElement(element);
            			}
            			if (a0_0 != null) {
            				if (a0_0 != null) {
            					Object value = a0_0;
            					element.eSet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.CONSTRAINT__TERM), value);
            					completedElement(value, true);
            				}
            				collectHiddenTokens(element);
            				retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_0_0_0_0, a0_0, true);
            				copyLocalizationInfos(a0_0, element);
            			}
            		}

            }


            if ( state.backtracking==0 ) {
            		// expected elements (follow set)
            	}

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, parse_org_emftext_term_propositional_expression_Constraint_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_term_propositional_expression_Constraint"



    // $ANTLR start "parseop_Term_level_1"
    // Expression.g:548:1: parseop_Term_level_1 returns [org.emftext.term.propositional.expression.Term element = null] : leftArg= parseop_Term_level_2 ( ( () a0= 'or' rightArg= parseop_Term_level_2 )+ |) ;
    public final org.emftext.term.propositional.expression.Term parseop_Term_level_1() throws RecognitionException {
        org.emftext.term.propositional.expression.Term element =  null;

        int parseop_Term_level_1_StartIndex = input.index();

        Token a0=null;
        org.emftext.term.propositional.expression.Term leftArg =null;

        org.emftext.term.propositional.expression.Term rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return element; }

            // Expression.g:551:2: (leftArg= parseop_Term_level_2 ( ( () a0= 'or' rightArg= parseop_Term_level_2 )+ |) )
            // Expression.g:552:2: leftArg= parseop_Term_level_2 ( ( () a0= 'or' rightArg= parseop_Term_level_2 )+ |)
            {
            pushFollow(FOLLOW_parseop_Term_level_2_in_parseop_Term_level_1152);
            leftArg=parseop_Term_level_2();

            state._fsp--;
            if (state.failed) return element;

            // Expression.g:552:33: ( ( () a0= 'or' rightArg= parseop_Term_level_2 )+ |)
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==EOF||LA2_0==8) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }
            switch (alt2) {
                case 1 :
                    // Expression.g:552:34: ( () a0= 'or' rightArg= parseop_Term_level_2 )+
                    {
                    // Expression.g:552:34: ( () a0= 'or' rightArg= parseop_Term_level_2 )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==11) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // Expression.g:553:3: () a0= 'or' rightArg= parseop_Term_level_2
                    	    {
                    	    // Expression.g:553:3: ()
                    	    // Expression.g:553:4: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,11,FOLLOW_11_in_parseop_Term_level_1172); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    			if (element == null) {
                    	    				element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createOr();
                    	    				startIncompleteElement(element);
                    	    			}
                    	    			collectHiddenTokens(element);
                    	    			retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_1_0_0_1, null, true);
                    	    			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			// expected elements (follow set)
                    	    			addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[3]);
                    	    			addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[4]);
                    	    			addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getOr(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[5]);
                    	    		}

                    	    pushFollow(FOLLOW_parseop_Term_level_2_in_parseop_Term_level_1189);
                    	    rightArg=parseop_Term_level_2();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTerminateParsingException();
                    	    			}
                    	    			if (element == null) {
                    	    				element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createOr();
                    	    				startIncompleteElement(element);
                    	    			}
                    	    			if (leftArg != null) {
                    	    				if (leftArg != null) {
                    	    					Object value = leftArg;
                    	    					element.eSet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.OR__OPERAND1), value);
                    	    					completedElement(value, true);
                    	    				}
                    	    				collectHiddenTokens(element);
                    	    				retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_1_0_0_0, leftArg, true);
                    	    				copyLocalizationInfos(leftArg, element);
                    	    			}
                    	    		}

                    	    if ( state.backtracking==0 ) {
                    	    			if (terminateParsing) {
                    	    				throw new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTerminateParsingException();
                    	    			}
                    	    			if (element == null) {
                    	    				element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createOr();
                    	    				startIncompleteElement(element);
                    	    			}
                    	    			if (rightArg != null) {
                    	    				if (rightArg != null) {
                    	    					Object value = rightArg;
                    	    					element.eSet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.OR__OPERAND2), value);
                    	    					completedElement(value, true);
                    	    				}
                    	    				collectHiddenTokens(element);
                    	    				retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_1_0_0_2, rightArg, true);
                    	    				copyLocalizationInfos(rightArg, element);
                    	    			}
                    	    		}

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Expression.g:610:21: 
                    {
                    if ( state.backtracking==0 ) { element = leftArg; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, parseop_Term_level_1_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_Term_level_1"



    // $ANTLR start "parseop_Term_level_2"
    // Expression.g:615:1: parseop_Term_level_2 returns [org.emftext.term.propositional.expression.Term element = null] : leftArg= parseop_Term_level_3 ( ( () a0= 'and' rightArg= parseop_Term_level_3 )+ |) ;
    public final org.emftext.term.propositional.expression.Term parseop_Term_level_2() throws RecognitionException {
        org.emftext.term.propositional.expression.Term element =  null;

        int parseop_Term_level_2_StartIndex = input.index();

        Token a0=null;
        org.emftext.term.propositional.expression.Term leftArg =null;

        org.emftext.term.propositional.expression.Term rightArg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return element; }

            // Expression.g:618:9: (leftArg= parseop_Term_level_3 ( ( () a0= 'and' rightArg= parseop_Term_level_3 )+ |) )
            // Expression.g:619:9: leftArg= parseop_Term_level_3 ( ( () a0= 'and' rightArg= parseop_Term_level_3 )+ |)
            {
            pushFollow(FOLLOW_parseop_Term_level_3_in_parseop_Term_level_2235);
            leftArg=parseop_Term_level_3();

            state._fsp--;
            if (state.failed) return element;

            // Expression.g:619:31: ( ( () a0= 'and' rightArg= parseop_Term_level_3 )+ |)
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==9) ) {
                alt4=1;
            }
            else if ( (LA4_0==EOF||LA4_0==8||LA4_0==11) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // Expression.g:619:32: ( () a0= 'and' rightArg= parseop_Term_level_3 )+
                    {
                    // Expression.g:619:32: ( () a0= 'and' rightArg= parseop_Term_level_3 )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==9) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Expression.g:620:2: () a0= 'and' rightArg= parseop_Term_level_3
                    	    {
                    	    // Expression.g:620:2: ()
                    	    // Expression.g:620:3: 
                    	    {
                    	    }


                    	    if ( state.backtracking==0 ) { element = null; }

                    	    a0=(Token)match(input,9,FOLLOW_9_in_parseop_Term_level_2251); if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    		if (element == null) {
                    	    			element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createAnd();
                    	    			startIncompleteElement(element);
                    	    		}
                    	    		collectHiddenTokens(element);
                    	    		retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_2_0_0_1, null, true);
                    	    		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		// expected elements (follow set)
                    	    		addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[6]);
                    	    		addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[7]);
                    	    		addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getAnd(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[8]);
                    	    	}

                    	    pushFollow(FOLLOW_parseop_Term_level_3_in_parseop_Term_level_2265);
                    	    rightArg=parseop_Term_level_3();

                    	    state._fsp--;
                    	    if (state.failed) return element;

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTerminateParsingException();
                    	    		}
                    	    		if (element == null) {
                    	    			element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createAnd();
                    	    			startIncompleteElement(element);
                    	    		}
                    	    		if (leftArg != null) {
                    	    			if (leftArg != null) {
                    	    				Object value = leftArg;
                    	    				element.eSet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.AND__OPERAND1), value);
                    	    				completedElement(value, true);
                    	    			}
                    	    			collectHiddenTokens(element);
                    	    			retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_2_0_0_0, leftArg, true);
                    	    			copyLocalizationInfos(leftArg, element);
                    	    		}
                    	    	}

                    	    if ( state.backtracking==0 ) {
                    	    		if (terminateParsing) {
                    	    			throw new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTerminateParsingException();
                    	    		}
                    	    		if (element == null) {
                    	    			element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createAnd();
                    	    			startIncompleteElement(element);
                    	    		}
                    	    		if (rightArg != null) {
                    	    			if (rightArg != null) {
                    	    				Object value = rightArg;
                    	    				element.eSet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.AND__OPERAND2), value);
                    	    				completedElement(value, true);
                    	    			}
                    	    			collectHiddenTokens(element);
                    	    			retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_2_0_0_2, rightArg, true);
                    	    			copyLocalizationInfos(rightArg, element);
                    	    		}
                    	    	}

                    	    if ( state.backtracking==0 ) { leftArg = element; /* this may become an argument in the next iteration */ }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                    	    if (state.backtracking>0) {state.failed=true; return element;}
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // Expression.g:677:20: 
                    {
                    if ( state.backtracking==0 ) { element = leftArg; }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, parseop_Term_level_2_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_Term_level_2"



    // $ANTLR start "parseop_Term_level_3"
    // Expression.g:682:1: parseop_Term_level_3 returns [org.emftext.term.propositional.expression.Term element = null] : (a0= 'not' arg= parseop_Term_level_4 |arg= parseop_Term_level_4 );
    public final org.emftext.term.propositional.expression.Term parseop_Term_level_3() throws RecognitionException {
        org.emftext.term.propositional.expression.Term element =  null;

        int parseop_Term_level_3_StartIndex = input.index();

        Token a0=null;
        org.emftext.term.propositional.expression.Term arg =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return element; }

            // Expression.g:685:0: (a0= 'not' arg= parseop_Term_level_4 |arg= parseop_Term_level_4 )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==10) ) {
                alt5=1;
            }
            else if ( (LA5_0==TEXT||LA5_0==7) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // Expression.g:686:0: a0= 'not' arg= parseop_Term_level_4
                    {
                    a0=(Token)match(input,10,FOLLOW_10_in_parseop_Term_level_3306); if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (element == null) {
                    	element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createNot();
                    	startIncompleteElement(element);
                    }
                    collectHiddenTokens(element);
                    retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_3_0_0_0, null, true);
                    copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
                    }

                    if ( state.backtracking==0 ) {
                    // expected elements (follow set)
                    addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[9]);
                    addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[10]);
                    addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNot(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[11]);
                    }

                    pushFollow(FOLLOW_parseop_Term_level_4_in_parseop_Term_level_3317);
                    arg=parseop_Term_level_4();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) {
                    if (terminateParsing) {
                    	throw new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTerminateParsingException();
                    }
                    if (element == null) {
                    	element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createNot();
                    	startIncompleteElement(element);
                    }
                    if (arg != null) {
                    	if (arg != null) {
                    		Object value = arg;
                    		element.eSet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.NOT__OPERAND), value);
                    		completedElement(value, true);
                    	}
                    	collectHiddenTokens(element);
                    	retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_3_0_0_1, arg, true);
                    	copyLocalizationInfos(arg, element);
                    }
                    }

                    }
                    break;
                case 2 :
                    // Expression.g:723:5: arg= parseop_Term_level_4
                    {
                    pushFollow(FOLLOW_parseop_Term_level_4_in_parseop_Term_level_3327);
                    arg=parseop_Term_level_4();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = arg; }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, parseop_Term_level_3_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_Term_level_3"



    // $ANTLR start "parseop_Term_level_4"
    // Expression.g:726:1: parseop_Term_level_4 returns [org.emftext.term.propositional.expression.Term element = null] : (c0= parse_org_emftext_term_propositional_expression_Nested |c1= parse_org_emftext_term_propositional_expression_FeatureRef );
    public final org.emftext.term.propositional.expression.Term parseop_Term_level_4() throws RecognitionException {
        org.emftext.term.propositional.expression.Term element =  null;

        int parseop_Term_level_4_StartIndex = input.index();

        org.emftext.term.propositional.expression.Nested c0 =null;

        org.emftext.term.propositional.expression.FeatureRef c1 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return element; }

            // Expression.g:729:0: (c0= parse_org_emftext_term_propositional_expression_Nested |c1= parse_org_emftext_term_propositional_expression_FeatureRef )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==7) ) {
                alt6=1;
            }
            else if ( (LA6_0==TEXT) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return element;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // Expression.g:730:0: c0= parse_org_emftext_term_propositional_expression_Nested
                    {
                    pushFollow(FOLLOW_parse_org_emftext_term_propositional_expression_Nested_in_parseop_Term_level_4349);
                    c0=parse_org_emftext_term_propositional_expression_Nested();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c0; /* this is a subclass or primitive expression choice */ }

                    }
                    break;
                case 2 :
                    // Expression.g:731:2: c1= parse_org_emftext_term_propositional_expression_FeatureRef
                    {
                    pushFollow(FOLLOW_parse_org_emftext_term_propositional_expression_FeatureRef_in_parseop_Term_level_4357);
                    c1=parse_org_emftext_term_propositional_expression_FeatureRef();

                    state._fsp--;
                    if (state.failed) return element;

                    if ( state.backtracking==0 ) { element = c1; /* this is a subclass or primitive expression choice */ }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, parseop_Term_level_4_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parseop_Term_level_4"



    // $ANTLR start "parse_org_emftext_term_propositional_expression_Nested"
    // Expression.g:734:1: parse_org_emftext_term_propositional_expression_Nested returns [org.emftext.term.propositional.expression.Nested element = null] : a0= '(' (a1_0= parse_org_emftext_term_propositional_expression_Term ) a2= ')' ;
    public final org.emftext.term.propositional.expression.Nested parse_org_emftext_term_propositional_expression_Nested() throws RecognitionException {
        org.emftext.term.propositional.expression.Nested element =  null;

        int parse_org_emftext_term_propositional_expression_Nested_StartIndex = input.index();

        Token a0=null;
        Token a2=null;
        org.emftext.term.propositional.expression.Term a1_0 =null;




        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return element; }

            // Expression.g:737:4: (a0= '(' (a1_0= parse_org_emftext_term_propositional_expression_Term ) a2= ')' )
            // Expression.g:738:4: a0= '(' (a1_0= parse_org_emftext_term_propositional_expression_Term ) a2= ')'
            {
            a0=(Token)match(input,7,FOLLOW_7_in_parse_org_emftext_term_propositional_expression_Nested379); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            	element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createNested();
            	startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_4_0_0_0, null, true);
            copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[12]);
            addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[13]);
            addExpectedElement(org.emftext.term.propositional.expression.TermPackage.eINSTANCE.getNested(), org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[14]);
            }

            // Expression.g:754:6: (a1_0= parse_org_emftext_term_propositional_expression_Term )
            // Expression.g:755:6: a1_0= parse_org_emftext_term_propositional_expression_Term
            {
            pushFollow(FOLLOW_parse_org_emftext_term_propositional_expression_Term_in_parse_org_emftext_term_propositional_expression_Nested392);
            a1_0=parse_org_emftext_term_propositional_expression_Term();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) {
            	if (terminateParsing) {
            		throw new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTerminateParsingException();
            	}
            	if (element == null) {
            		element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createNested();
            		startIncompleteElement(element);
            	}
            	if (a1_0 != null) {
            		if (a1_0 != null) {
            			Object value = a1_0;
            			element.eSet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.NESTED__OPERAND), value);
            			completedElement(value, true);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_4_0_0_1, a1_0, true);
            		copyLocalizationInfos(a1_0, element);
            	}
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[15]);
            }

            a2=(Token)match(input,8,FOLLOW_8_in_parse_org_emftext_term_propositional_expression_Nested404); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            if (element == null) {
            	element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createNested();
            	startIncompleteElement(element);
            }
            collectHiddenTokens(element);
            retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_4_0_0_2, null, true);
            copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
            }

            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[16]);
            addExpectedElement(null, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[17]);
            addExpectedElement(null, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[18]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, parse_org_emftext_term_propositional_expression_Nested_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_term_propositional_expression_Nested"



    // $ANTLR start "parse_org_emftext_term_propositional_expression_FeatureRef"
    // Expression.g:798:1: parse_org_emftext_term_propositional_expression_FeatureRef returns [org.emftext.term.propositional.expression.FeatureRef element = null] : (a0= TEXT ) ;
    public final org.emftext.term.propositional.expression.FeatureRef parse_org_emftext_term_propositional_expression_FeatureRef() throws RecognitionException {
        org.emftext.term.propositional.expression.FeatureRef element =  null;

        int parse_org_emftext_term_propositional_expression_FeatureRef_StartIndex = input.index();

        Token a0=null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return element; }

            // Expression.g:801:4: ( (a0= TEXT ) )
            // Expression.g:802:4: (a0= TEXT )
            {
            // Expression.g:802:4: (a0= TEXT )
            // Expression.g:803:4: a0= TEXT
            {
            a0=(Token)match(input,TEXT,FOLLOW_TEXT_in_parse_org_emftext_term_propositional_expression_FeatureRef432); if (state.failed) return element;

            if ( state.backtracking==0 ) {
            	if (terminateParsing) {
            		throw new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTerminateParsingException();
            	}
            	if (element == null) {
            		element = org.emftext.term.propositional.expression.TermFactory.eINSTANCE.createFeatureRef();
            		startIncompleteElement(element);
            	}
            	if (a0 != null) {
            		org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
            		tokenResolver.setOptions(getOptions());
            		org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolveResult result = getFreshTokenResolveResult();
            		tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.FEATURE_REF__FEATURE), result);
            		Object resolvedObject = result.getResolvedToken();
            		if (resolvedObject == null) {
            			addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
            		}
            		String resolved = (String) resolvedObject;
            		org.js.model.feature.Feature proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
            		collectHiddenTokens(element);
            		registerContextDependentProxy(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionContextDependentURIFragmentFactory<org.emftext.term.propositional.expression.FeatureRef, org.js.model.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureRefFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.FEATURE_REF__FEATURE), resolved, proxy);
            		if (proxy != null) {
            			Object value = proxy;
            			element.eSet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.FEATURE_REF__FEATURE), value);
            			completedElement(value, false);
            		}
            		collectHiddenTokens(element);
            		retrieveLayoutInformation(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_5_0_0_0, proxy, true);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
            		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
            	}
            }

            }


            if ( state.backtracking==0 ) {
            // expected elements (follow set)
            addExpectedElement(null, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[19]);
            addExpectedElement(null, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[20]);
            addExpectedElement(null, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionExpectationConstants.EXPECTATIONS[21]);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, parse_org_emftext_term_propositional_expression_FeatureRef_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_term_propositional_expression_FeatureRef"



    // $ANTLR start "parse_org_emftext_term_propositional_expression_Term"
    // Expression.g:846:1: parse_org_emftext_term_propositional_expression_Term returns [org.emftext.term.propositional.expression.Term element = null] : c= parseop_Term_level_1 ;
    public final org.emftext.term.propositional.expression.Term parse_org_emftext_term_propositional_expression_Term() throws RecognitionException {
        org.emftext.term.propositional.expression.Term element =  null;

        int parse_org_emftext_term_propositional_expression_Term_StartIndex = input.index();

        org.emftext.term.propositional.expression.Term c =null;


        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return element; }

            // Expression.g:847:3: (c= parseop_Term_level_1 )
            // Expression.g:848:3: c= parseop_Term_level_1
            {
            pushFollow(FOLLOW_parseop_Term_level_1_in_parse_org_emftext_term_propositional_expression_Term456);
            c=parseop_Term_level_1();

            state._fsp--;
            if (state.failed) return element;

            if ( state.backtracking==0 ) { element = c; /* this rule is an expression root */ }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, parse_org_emftext_term_propositional_expression_Term_StartIndex); }

        }
        return element;
    }
    // $ANTLR end "parse_org_emftext_term_propositional_expression_Term"

    // Delegated rules


 

    public static final BitSet FOLLOW_parse_org_emftext_term_propositional_expression_Constraint_in_start82 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_start89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_term_propositional_expression_Term_in_parse_org_emftext_term_propositional_expression_Constraint119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_Term_level_2_in_parseop_Term_level_1152 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_parseop_Term_level_1172 = new BitSet(new long[]{0x00000000000004A0L});
    public static final BitSet FOLLOW_parseop_Term_level_2_in_parseop_Term_level_1189 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_parseop_Term_level_3_in_parseop_Term_level_2235 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_9_in_parseop_Term_level_2251 = new BitSet(new long[]{0x00000000000004A0L});
    public static final BitSet FOLLOW_parseop_Term_level_3_in_parseop_Term_level_2265 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_10_in_parseop_Term_level_3306 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_parseop_Term_level_4_in_parseop_Term_level_3317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_Term_level_4_in_parseop_Term_level_3327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_term_propositional_expression_Nested_in_parseop_Term_level_4349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parse_org_emftext_term_propositional_expression_FeatureRef_in_parseop_Term_level_4357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_7_in_parse_org_emftext_term_propositional_expression_Nested379 = new BitSet(new long[]{0x00000000000004A0L});
    public static final BitSet FOLLOW_parse_org_emftext_term_propositional_expression_Term_in_parse_org_emftext_term_propositional_expression_Nested392 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_parse_org_emftext_term_propositional_expression_Nested404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_in_parse_org_emftext_term_propositional_expression_FeatureRef432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_parseop_Term_level_1_in_parse_org_emftext_term_propositional_expression_Term456 = new BitSet(new long[]{0x0000000000000002L});

}