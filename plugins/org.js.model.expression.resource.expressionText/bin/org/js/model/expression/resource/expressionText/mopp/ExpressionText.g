grammar ExpressionText;

options {
	superClass = ExpressionTextANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.js.model.expression.resource.expressionText.mopp;
}

@lexer::members {
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
	}
}
@header{
	package org.js.model.expression.resource.expressionText.mopp;
}

@members{
	private org.js.model.expression.resource.expressionText.IExpressionTextTokenResolverFactory tokenResolverFactory = new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTokenResolverFactory();
	
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
	private java.util.List<org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal> expectedElements = new java.util.ArrayList<org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal>();
	
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
		postParseCommands.add(new org.js.model.expression.resource.expressionText.IExpressionTextCommand<org.js.model.expression.resource.expressionText.IExpressionTextTextResource>() {
			public boolean execute(org.js.model.expression.resource.expressionText.IExpressionTextTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.js.model.expression.resource.expressionText.IExpressionTextProblem() {
					public org.js.model.expression.resource.expressionText.ExpressionTextEProblemSeverity getSeverity() {
						return org.js.model.expression.resource.expressionText.ExpressionTextEProblemSeverity.ERROR;
					}
					public org.js.model.expression.resource.expressionText.ExpressionTextEProblemType getType() {
						return org.js.model.expression.resource.expressionText.ExpressionTextEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.js.model.expression.resource.expressionText.IExpressionTextQuickFix> getQuickFixes() {
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
		org.js.model.expression.resource.expressionText.IExpressionTextExpectedElement terminal = org.js.model.expression.resource.expressionText.grammar.ExpressionTextFollowSetProvider.TERMINALS[terminalID];
		org.js.model.expression.resource.expressionText.mopp.ExpressionTextContainedFeature[] containmentFeatures = new org.js.model.expression.resource.expressionText.mopp.ExpressionTextContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = org.js.model.expression.resource.expressionText.grammar.ExpressionTextFollowSetProvider.LINKS[ids[i]];
		}
		org.js.model.expression.resource.expressionText.grammar.ExpressionTextContainmentTrace containmentTrace = new org.js.model.expression.resource.expressionText.grammar.ExpressionTextContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal expectedElement = new org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		postParseCommands.add(new org.js.model.expression.resource.expressionText.IExpressionTextCommand<org.js.model.expression.resource.expressionText.IExpressionTextTextResource>() {
			public boolean execute(org.js.model.expression.resource.expressionText.IExpressionTextTextResource resource) {
				org.js.model.expression.resource.expressionText.IExpressionTextLocationMap locationMap = resource.getLocationMap();
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
		postParseCommands.add(new org.js.model.expression.resource.expressionText.IExpressionTextCommand<org.js.model.expression.resource.expressionText.IExpressionTextTextResource>() {
			public boolean execute(org.js.model.expression.resource.expressionText.IExpressionTextTextResource resource) {
				org.js.model.expression.resource.expressionText.IExpressionTextLocationMap locationMap = resource.getLocationMap();
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
	protected void setLocalizationEnd(java.util.Collection<org.js.model.expression.resource.expressionText.IExpressionTextCommand<org.js.model.expression.resource.expressionText.IExpressionTextTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.js.model.expression.resource.expressionText.IExpressionTextCommand<org.js.model.expression.resource.expressionText.IExpressionTextTextResource>() {
			public boolean execute(org.js.model.expression.resource.expressionText.IExpressionTextTextResource resource) {
				org.js.model.expression.resource.expressionText.IExpressionTextLocationMap locationMap = resource.getLocationMap();
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
	
	public org.js.model.expression.resource.expressionText.IExpressionTextTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new ExpressionTextParser(new org.antlr.runtime3_4_0.CommonTokenStream(new ExpressionTextLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new ExpressionTextParser(new org.antlr.runtime3_4_0.CommonTokenStream(new ExpressionTextLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new org.js.model.expression.resource.expressionText.util.ExpressionTextRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public ExpressionTextParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((ExpressionTextLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((ExpressionTextLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.js.model.expression.FeatureModel2.class) {
				return parse_org_js_model_expression_FeatureModel2();
			}
			if (type.getInstanceClass() == org.js.model.expression.Feature2.class) {
				return parse_org_js_model_expression_Feature2();
			}
			if (type.getInstanceClass() == org.js.model.expression.Group2.class) {
				return parse_org_js_model_expression_Group2();
			}
			if (type.getInstanceClass() == org.js.model.expression.Attribute2.class) {
				return parse_org_js_model_expression_Attribute2();
			}
			if (type.getInstanceClass() == org.js.model.expression.DiscreteDomain2.class) {
				return parse_org_js_model_expression_DiscreteDomain2();
			}
			if (type.getInstanceClass() == org.js.model.expression.ContinuousDomain2.class) {
				return parse_org_js_model_expression_ContinuousDomain2();
			}
			if (type.getInstanceClass() == org.js.model.expression.Interval2.class) {
				return parse_org_js_model_expression_Interval2();
			}
			if (type.getInstanceClass() == org.js.model.expression.Constraint2.class) {
				return parse_org_js_model_expression_Constraint2();
			}
		}
		throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(org.js.model.expression.resource.expressionText.IExpressionTextOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.js.model.expression.resource.expressionText.IExpressionTextParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.js.model.expression.resource.expressionText.IExpressionTextCommand<org.js.model.expression.resource.expressionText.IExpressionTextTextResource>>();
		org.js.model.expression.resource.expressionText.mopp.ExpressionTextParseResult parseResult = new org.js.model.expression.resource.expressionText.mopp.ExpressionTextParseResult();
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
	
	public java.util.List<org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.js.model.expression.resource.expressionText.IExpressionTextTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		org.js.model.expression.resource.expressionText.IExpressionTextParseResult result = parse();
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
			for (org.js.model.expression.resource.expressionText.IExpressionTextCommand<org.js.model.expression.resource.expressionText.IExpressionTextTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal>();
		java.util.List<org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal> newFollowSet = new java.util.ArrayList<org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 79;
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
				for (org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.js.model.expression.resource.expressionText.util.ExpressionTextPair<org.js.model.expression.resource.expressionText.IExpressionTextExpectedElement, org.js.model.expression.resource.expressionText.mopp.ExpressionTextContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.js.model.expression.resource.expressionText.util.ExpressionTextPair<org.js.model.expression.resource.expressionText.IExpressionTextExpectedElement, org.js.model.expression.resource.expressionText.mopp.ExpressionTextContainedFeature[]> newFollowerPair : newFollowers) {
							org.js.model.expression.resource.expressionText.IExpressionTextExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							org.js.model.expression.resource.expressionText.grammar.ExpressionTextContainmentTrace containmentTrace = new org.js.model.expression.resource.expressionText.grammar.ExpressionTextContainmentTrace(null, newFollowerPair.getRight());
							org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal newFollowTerminal = new org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectedTerminal expectedElement, int tokenIndex) {
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
	
}

start returns [ org.eclipse.emf.ecore.EObject element = null]
:
	{
		// follow set for start rule(s)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_js_model_expression_FeatureModel2{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_js_model_expression_FeatureModel2 returns [org.js.model.expression.FeatureModel2 element = null]
@init{
}
:
	a0 = 'Feature' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createFeatureModel2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[1]);
	}
	
	a1 = 'Model' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createFeatureModel2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_0_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[2]);
	}
	
	(
		a2 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createFeatureModel2();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.FEATURE_MODEL2__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.FEATURE_MODEL2__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_0_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[3]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[4]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[5]);
	}
	
	(
		(
			a3_0 = parse_org_js_model_expression_Domain2			{
				if (terminateParsing) {
					throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.expression.expressionFactory.eINSTANCE.createFeatureModel2();
					startIncompleteElement(element);
				}
				if (a3_0 != null) {
					if (a3_0 != null) {
						Object value = a3_0;
						addObjectToList(element, org.js.model.expression.expressionPackage.FEATURE_MODEL2__DOMAINS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_0_0_0_6, a3_0, true);
					copyLocalizationInfos(a3_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[7]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[8]);
	}
	
	(
		a4_0 = parse_org_js_model_expression_Feature2		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createFeatureModel2();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.FEATURE_MODEL2__ROOT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_0_0_0_8, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[9]);
	}
	
	(
		(
			a5_0 = parse_org_js_model_expression_Constraint2			{
				if (terminateParsing) {
					throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.expression.expressionFactory.eINSTANCE.createFeatureModel2();
					startIncompleteElement(element);
				}
				if (a5_0 != null) {
					if (a5_0 != null) {
						Object value = a5_0;
						addObjectToList(element, org.js.model.expression.expressionPackage.FEATURE_MODEL2__CONSTRAINTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_0_0_0_10, a5_0, true);
					copyLocalizationInfos(a5_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[10]);
	}
	
;

parse_org_js_model_expression_Feature2 returns [org.js.model.expression.Feature2 element = null]
@init{
}
:
	a0 = 'feature' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createFeature2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[11]);
	}
	
	(
		a1 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createFeature2();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.FEATURE2__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.FEATURE2__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_1_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[12]);
	}
	
	a2 = '<' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createFeature2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_1_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[13]);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createFeature2();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.FEATURE2__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.FEATURE2__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_1_0_0_5, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[14]);
	}
	
	a4 = '>' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createFeature2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_1_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[15]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[16]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[17]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[18]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[19]);
	}
	
	(
		(
			(
				(
					(
						(
							a5_0 = parse_org_js_model_expression_Attribute2							{
								if (terminateParsing) {
									throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
								}
								if (element == null) {
									element = org.js.model.expression.expressionFactory.eINSTANCE.createFeature2();
									startIncompleteElement(element);
								}
								if (a5_0 != null) {
									if (a5_0 != null) {
										Object value = a5_0;
										addObjectToList(element, org.js.model.expression.expressionPackage.FEATURE2__ATTRIBUTES, value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_1_0_0_7_0_0_0_0_0_2_0_0_0, a5_0, true);
									copyLocalizationInfos(a5_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[20]);
							addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[21]);
							addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[22]);
							addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[23]);
							addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[24]);
						}
						
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[25]);
						addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[26]);
						addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[27]);
						addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[28]);
						addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[29]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[30]);
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[31]);
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[32]);
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[33]);
				addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[34]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[35]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[36]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[37]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[38]);
	}
	
	(
		(
			(
				(
					(
						(
							a6_0 = parse_org_js_model_expression_Group2							{
								if (terminateParsing) {
									throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
								}
								if (element == null) {
									element = org.js.model.expression.expressionFactory.eINSTANCE.createFeature2();
									startIncompleteElement(element);
								}
								if (a6_0 != null) {
									if (a6_0 != null) {
										Object value = a6_0;
										addObjectToList(element, org.js.model.expression.expressionPackage.FEATURE2__GROUPS, value);
										completedElement(value, true);
									}
									collectHiddenTokens(element);
									retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_1_0_0_8_0_0_0_0_0_2_0_0_0, a6_0, true);
									copyLocalizationInfos(a6_0, element);
								}
							}
						)
						{
							// expected elements (follow set)
							addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[39]);
							addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[40]);
							addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[41]);
							addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[42]);
						}
						
					)
					{
						// expected elements (follow set)
						addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[43]);
						addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[44]);
						addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[45]);
						addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[46]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[47]);
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[48]);
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[49]);
				addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[50]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[51]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[52]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[53]);
	}
	
;

parse_org_js_model_expression_Group2 returns [org.js.model.expression.Group2 element = null]
@init{
}
:
	a0 = 'group' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[54]);
	}
	
	a1 = '<' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[55]);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.GROUP2__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.GROUP2__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[56]);
	}
	
	a3 = '>' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[57]);
	}
	
	a4 = '(' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[58]);
	}
	
	(
		a5 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
				startIncompleteElement(element);
			}
			if (a5 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.GROUP2__MIN_CARDINALITY), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.GROUP2__MIN_CARDINALITY), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_7, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[59]);
	}
	
	a6 = '..' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[60]);
	}
	
	(
		a7 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
				startIncompleteElement(element);
			}
			if (a7 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.GROUP2__MAX_CARDINALITY), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.GROUP2__MAX_CARDINALITY), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_9, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[61]);
	}
	
	a8 = ')' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_10, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[62]);
	}
	
	a9 = '{' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_12, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a9, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[63]);
	}
	
	(
		(
			a10_0 = parse_org_js_model_expression_Feature2			{
				if (terminateParsing) {
					throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
					startIncompleteElement(element);
				}
				if (a10_0 != null) {
					if (a10_0 != null) {
						Object value = a10_0;
						addObjectToList(element, org.js.model.expression.expressionPackage.GROUP2__CHILD_FEATURES, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_14, a10_0, true);
					copyLocalizationInfos(a10_0, element);
				}
			}
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[64]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[65]);
	}
	
	a11 = '}' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createGroup2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_2_0_0_16, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[69]);
	}
	
;

parse_org_js_model_expression_Attribute2 returns [org.js.model.expression.Attribute2 element = null]
@init{
}
:
	a0 = 'attribute' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createAttribute2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[70]);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createAttribute2();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.ATTRIBUTE2__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.ATTRIBUTE2__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_3_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[71]);
	}
	
	a2 = '[' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createAttribute2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[72]);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createAttribute2();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.ATTRIBUTE2__DOMAIN), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.js.model.expression.Domain2 proxy = org.js.model.expression.expressionFactory.eINSTANCE.createDiscreteDomain2();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.js.model.expression.resource.expressionText.mopp.ExpressionTextContextDependentURIFragmentFactory<org.js.model.expression.Attribute2, org.js.model.expression.Domain2>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAttribute2DomainReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.ATTRIBUTE2__DOMAIN), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.ATTRIBUTE2__DOMAIN), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_3_0_0_5, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[73]);
	}
	
	a4 = ']' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createAttribute2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_3_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[74]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[75]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[76]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[77]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[78]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[79]);
	}
	
	(
		(
			a5 = '=' {
				if (element == null) {
					element = org.js.model.expression.expressionFactory.eINSTANCE.createAttribute2();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_3_0_0_8_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[80]);
			}
			
			(
				(
					a6 = TEXT					
					{
						if (terminateParsing) {
							throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
						}
						if (element == null) {
							element = org.js.model.expression.expressionFactory.eINSTANCE.createAttribute2();
							startIncompleteElement(element);
						}
						if (a6 != null) {
							org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
							tokenResolver.setOptions(getOptions());
							org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.ATTRIBUTE2__VALUE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
							}
							java.lang.String resolved = (java.lang.String) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.ATTRIBUTE2__VALUE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_3_0_0_8_0_0_3_0_0_0, resolved, true);
							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[81]);
					addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[82]);
					addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[83]);
					addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[84]);
					addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[85]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[86]);
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[87]);
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[88]);
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[89]);
				addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[90]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[91]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeature2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[92]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[93]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGroup2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[94]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[95]);
	}
	
;

parse_org_js_model_expression_DiscreteDomain2 returns [org.js.model.expression.DiscreteDomain2 element = null]
@init{
}
:
	a0 = 'domain' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createDiscreteDomain2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[96]);
	}
	
	a1 = '<' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createDiscreteDomain2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_4_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[97]);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createDiscreteDomain2();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.DISCRETE_DOMAIN2__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.DISCRETE_DOMAIN2__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_4_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[98]);
	}
	
	a3 = '>' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createDiscreteDomain2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_4_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[99]);
	}
	
	a4 = '[' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createDiscreteDomain2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_4_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[100]);
	}
	
	(
		a5 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createDiscreteDomain2();
				startIncompleteElement(element);
			}
			if (a5 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.DISCRETE_DOMAIN2__VALUES), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					addObjectToList(element, org.js.model.expression.expressionPackage.DISCRETE_DOMAIN2__VALUES, value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_4_0_0_6, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[101]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[102]);
	}
	
	(
		(
			a6 = ',' {
				if (element == null) {
					element = org.js.model.expression.expressionFactory.eINSTANCE.createDiscreteDomain2();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_4_0_0_7_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[103]);
			}
			
			(
				a7 = TEXT				
				{
					if (terminateParsing) {
						throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.expression.expressionFactory.eINSTANCE.createDiscreteDomain2();
						startIncompleteElement(element);
					}
					if (a7 != null) {
						org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.DISCRETE_DOMAIN2__VALUES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, org.js.model.expression.expressionPackage.DISCRETE_DOMAIN2__VALUES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_4_0_0_7_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[104]);
				addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[105]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[107]);
	}
	
	a8 = ']' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createDiscreteDomain2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_4_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[108]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[109]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[110]);
	}
	
;

parse_org_js_model_expression_ContinuousDomain2 returns [org.js.model.expression.ContinuousDomain2 element = null]
@init{
}
:
	a0 = 'domain' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createContinuousDomain2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_5_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[111]);
	}
	
	a1 = '<' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createContinuousDomain2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_5_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[112]);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createContinuousDomain2();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.CONTINUOUS_DOMAIN2__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.CONTINUOUS_DOMAIN2__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_5_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[113]);
	}
	
	a3 = '>' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createContinuousDomain2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_5_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[114]);
	}
	
	a4 = '[' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createContinuousDomain2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_5_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getContinuousDomain2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[115]);
	}
	
	(
		a5_0 = parse_org_js_model_expression_Interval2		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createContinuousDomain2();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					addObjectToList(element, org.js.model.expression.expressionPackage.CONTINUOUS_DOMAIN2__INTERVALS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_5_0_0_6, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[116]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[117]);
	}
	
	(
		(
			a6 = ',' {
				if (element == null) {
					element = org.js.model.expression.expressionFactory.eINSTANCE.createContinuousDomain2();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_5_0_0_7_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getContinuousDomain2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[118]);
			}
			
			(
				a7_0 = parse_org_js_model_expression_Interval2				{
					if (terminateParsing) {
						throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.expression.expressionFactory.eINSTANCE.createContinuousDomain2();
						startIncompleteElement(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, org.js.model.expression.expressionPackage.CONTINUOUS_DOMAIN2__INTERVALS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_5_0_0_7_0_0_2, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[119]);
				addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[120]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[122]);
	}
	
	a8 = ']' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createContinuousDomain2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_5_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[123]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[124]);
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[125]);
	}
	
;

parse_org_js_model_expression_Interval2 returns [org.js.model.expression.Interval2 element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createInterval2();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.INTERVAL2__LOWER_BOUND), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.INTERVAL2__LOWER_BOUND), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_6_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[126]);
	}
	
	a1 = '..' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createInterval2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_6_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[127]);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createInterval2();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.INTERVAL2__UPPER_BOUND), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.INTERVAL2__UPPER_BOUND), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_6_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[129]);
	}
	
;

parse_org_js_model_expression_Constraint2 returns [org.js.model.expression.Constraint2 element = null]
@init{
}
:
	a0 = 'constraint' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createConstraint2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_7_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[130]);
	}
	
	a1 = '<' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createConstraint2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_7_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[131]);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createConstraint2();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.CONSTRAINT2__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.CONSTRAINT2__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_7_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[132]);
	}
	
	a3 = '>' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createConstraint2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_7_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getConstraint2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[133]);
	}
	
	(
		a4_0 = parse_org_js_model_expression_Expression2		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createConstraint2();
				startIncompleteElement(element);
			}
			if (a4_0 != null) {
				if (a4_0 != null) {
					Object value = a4_0;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.CONSTRAINT2__EXPRESSION), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_7_0_0_6, a4_0, true);
				copyLocalizationInfos(a4_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[134]);
	}
	
	a5 = ';' {
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createConstraint2();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_7_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getFeatureModel2(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[135]);
	}
	
;

parseop_Expression2_level_1 returns [org.js.model.expression.Expression2 element = null]
@init{
}
:
	leftArg = parseop_Expression2_level_2	((
		()
		{ element = null; }
		(
			a0 = REQUIRES			
		)
		{
			anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a0);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getRequires(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[136]);
		}
		
		rightArg = parseop_Expression2_level_2		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createRequires();
				startIncompleteElement(element);
			}
			if (leftArg != null) {
				if (leftArg != null) {
					Object value = leftArg;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.REQUIRES__OPERAND1), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_15_0_0_0, leftArg, true);
				copyLocalizationInfos(leftArg, element);
			}
		}
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createRequires();
				startIncompleteElement(element);
			}
			if (rightArg != null) {
				if (rightArg != null) {
					Object value = rightArg;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.REQUIRES__OPERAND2), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_15_0_0_4, rightArg, true);
				copyLocalizationInfos(rightArg, element);
			}
		}
		{ leftArg = element; /* this may become an argument in the next iteration */ }
		|		
		()
		{ element = null; }
		(
			a0 = EXCLUDES			
		)
		{
			anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a0);
		}
		{
			// expected elements (follow set)
			addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getExcludes(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[137]);
		}
		
		rightArg = parseop_Expression2_level_2		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createExcludes();
				startIncompleteElement(element);
			}
			if (leftArg != null) {
				if (leftArg != null) {
					Object value = leftArg;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.EXCLUDES__OPERAND1), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_16_0_0_0, leftArg, true);
				copyLocalizationInfos(leftArg, element);
			}
		}
		{
			if (terminateParsing) {
				throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.expression.expressionFactory.eINSTANCE.createExcludes();
				startIncompleteElement(element);
			}
			if (rightArg != null) {
				if (rightArg != null) {
					Object value = rightArg;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.EXCLUDES__OPERAND2), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_16_0_0_4, rightArg, true);
				copyLocalizationInfos(rightArg, element);
			}
		}
		{ leftArg = element; /* this may become an argument in the next iteration */ }
	)+ | /* epsilon */ { element = leftArg; }
	
)
;

parseop_Expression2_level_2 returns [org.js.model.expression.Expression2 element = null]
@init{
}
:
leftArg = parseop_Expression2_level_3((
	()
	{ element = null; }
	(
		a0 = EQUAL		
	)
	{
		anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a0);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getEqual(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[138]);
	}
	
	rightArg = parseop_Expression2_level_3	{
		if (terminateParsing) {
			throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
		}
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createEqual();
			startIncompleteElement(element);
		}
		if (leftArg != null) {
			if (leftArg != null) {
				Object value = leftArg;
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.EQUAL__OPERAND1), value);
				completedElement(value, true);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_13_0_0_0, leftArg, true);
			copyLocalizationInfos(leftArg, element);
		}
	}
	{
		if (terminateParsing) {
			throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
		}
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createEqual();
			startIncompleteElement(element);
		}
		if (rightArg != null) {
			if (rightArg != null) {
				Object value = rightArg;
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.EQUAL__OPERAND2), value);
				completedElement(value, true);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_13_0_0_4, rightArg, true);
			copyLocalizationInfos(rightArg, element);
		}
	}
	{ leftArg = element; /* this may become an argument in the next iteration */ }
	|	
	()
	{ element = null; }
	(
		a0 = UNEQUAL		
	)
	{
		anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a0);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getUnequal(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[139]);
	}
	
	rightArg = parseop_Expression2_level_3	{
		if (terminateParsing) {
			throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
		}
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createUnequal();
			startIncompleteElement(element);
		}
		if (leftArg != null) {
			if (leftArg != null) {
				Object value = leftArg;
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.UNEQUAL__OPERAND1), value);
				completedElement(value, true);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_14_0_0_0, leftArg, true);
			copyLocalizationInfos(leftArg, element);
		}
	}
	{
		if (terminateParsing) {
			throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
		}
		if (element == null) {
			element = org.js.model.expression.expressionFactory.eINSTANCE.createUnequal();
			startIncompleteElement(element);
		}
		if (rightArg != null) {
			if (rightArg != null) {
				Object value = rightArg;
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.UNEQUAL__OPERAND2), value);
				completedElement(value, true);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_14_0_0_4, rightArg, true);
			copyLocalizationInfos(rightArg, element);
		}
	}
	{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_Expression2_level_3 returns [org.js.model.expression.Expression2 element = null]
@init{
}
:
leftArg = parseop_Expression2_level_4((
()
{ element = null; }
(
	a0 = GREATERTHAN	
)
{
	anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a0);
}
{
	// expected elements (follow set)
	addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGreaterThan(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[140]);
}

rightArg = parseop_Expression2_level_4{
	if (terminateParsing) {
		throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
	}
	if (element == null) {
		element = org.js.model.expression.expressionFactory.eINSTANCE.createGreaterThan();
		startIncompleteElement(element);
	}
	if (leftArg != null) {
		if (leftArg != null) {
			Object value = leftArg;
			element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.GREATER_THAN__OPERAND1), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_9_0_0_0, leftArg, true);
		copyLocalizationInfos(leftArg, element);
	}
}
{
	if (terminateParsing) {
		throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
	}
	if (element == null) {
		element = org.js.model.expression.expressionFactory.eINSTANCE.createGreaterThan();
		startIncompleteElement(element);
	}
	if (rightArg != null) {
		if (rightArg != null) {
			Object value = rightArg;
			element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.GREATER_THAN__OPERAND2), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_9_0_0_4, rightArg, true);
		copyLocalizationInfos(rightArg, element);
	}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
(
	a0 = GREATERTHANOREQUAL	
)
{
	anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a0);
}
{
	// expected elements (follow set)
	addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGreaterThanOrEqual(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[141]);
}

rightArg = parseop_Expression2_level_4{
	if (terminateParsing) {
		throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
	}
	if (element == null) {
		element = org.js.model.expression.expressionFactory.eINSTANCE.createGreaterThanOrEqual();
		startIncompleteElement(element);
	}
	if (leftArg != null) {
		if (leftArg != null) {
			Object value = leftArg;
			element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.GREATER_THAN_OR_EQUAL__OPERAND1), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_10_0_0_0, leftArg, true);
		copyLocalizationInfos(leftArg, element);
	}
}
{
	if (terminateParsing) {
		throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
	}
	if (element == null) {
		element = org.js.model.expression.expressionFactory.eINSTANCE.createGreaterThanOrEqual();
		startIncompleteElement(element);
	}
	if (rightArg != null) {
		if (rightArg != null) {
			Object value = rightArg;
			element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.GREATER_THAN_OR_EQUAL__OPERAND2), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_10_0_0_4, rightArg, true);
		copyLocalizationInfos(rightArg, element);
	}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
(
	a0 = LESSTHAN	
)
{
	anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a0);
}
{
	// expected elements (follow set)
	addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getLessThan(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[142]);
}

rightArg = parseop_Expression2_level_4{
	if (terminateParsing) {
		throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
	}
	if (element == null) {
		element = org.js.model.expression.expressionFactory.eINSTANCE.createLessThan();
		startIncompleteElement(element);
	}
	if (leftArg != null) {
		if (leftArg != null) {
			Object value = leftArg;
			element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.LESS_THAN__OPERAND1), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_11_0_0_0, leftArg, true);
		copyLocalizationInfos(leftArg, element);
	}
}
{
	if (terminateParsing) {
		throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
	}
	if (element == null) {
		element = org.js.model.expression.expressionFactory.eINSTANCE.createLessThan();
		startIncompleteElement(element);
	}
	if (rightArg != null) {
		if (rightArg != null) {
			Object value = rightArg;
			element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.LESS_THAN__OPERAND2), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_11_0_0_4, rightArg, true);
		copyLocalizationInfos(rightArg, element);
	}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
|
()
{ element = null; }
(
	a0 = LESSTHANOREQUAL	
)
{
	anonymousTokens.add((org.antlr.runtime3_4_0.CommonToken) a0);
}
{
	// expected elements (follow set)
	addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getLessThanOrEqual(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[143]);
}

rightArg = parseop_Expression2_level_4{
	if (terminateParsing) {
		throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
	}
	if (element == null) {
		element = org.js.model.expression.expressionFactory.eINSTANCE.createLessThanOrEqual();
		startIncompleteElement(element);
	}
	if (leftArg != null) {
		if (leftArg != null) {
			Object value = leftArg;
			element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.LESS_THAN_OR_EQUAL__OPERAND1), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_12_0_0_0, leftArg, true);
		copyLocalizationInfos(leftArg, element);
	}
}
{
	if (terminateParsing) {
		throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
	}
	if (element == null) {
		element = org.js.model.expression.expressionFactory.eINSTANCE.createLessThanOrEqual();
		startIncompleteElement(element);
	}
	if (rightArg != null) {
		if (rightArg != null) {
			Object value = rightArg;
			element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.LESS_THAN_OR_EQUAL__OPERAND2), value);
			completedElement(value, true);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_12_0_0_4, rightArg, true);
		copyLocalizationInfos(rightArg, element);
	}
}
{ leftArg = element; /* this may become an argument in the next iteration */ }
)+ | /* epsilon */ { element = leftArg; }

)
;

parseop_Expression2_level_4 returns [org.js.model.expression.Expression2 element = null]
@init{
}
:
c0 = parse_org_js_model_expression_FeatureReference2{ element = c0; /* this is a subclass or primitive expression choice */ }
;

parse_org_js_model_expression_FeatureReference2 returns [org.js.model.expression.FeatureReference2 element = null]
@init{
}
:
(
a0 = TEXT
{
if (terminateParsing) {
	throw new org.js.model.expression.resource.expressionText.mopp.ExpressionTextTerminateParsingException();
}
if (element == null) {
	element = org.js.model.expression.expressionFactory.eINSTANCE.createFeatureReference2();
	startIncompleteElement(element);
}
if (a0 != null) {
	org.js.model.expression.resource.expressionText.IExpressionTextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
	tokenResolver.setOptions(getOptions());
	org.js.model.expression.resource.expressionText.IExpressionTextTokenResolveResult result = getFreshTokenResolveResult();
	tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.FEATURE_REFERENCE2__FEATURE), result);
	Object resolvedObject = result.getResolvedToken();
	if (resolvedObject == null) {
		addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
	}
	String resolved = (String) resolvedObject;
	org.js.model.expression.Feature2 proxy = org.js.model.expression.expressionFactory.eINSTANCE.createFeature2();
	collectHiddenTokens(element);
	registerContextDependentProxy(new org.js.model.expression.resource.expressionText.mopp.ExpressionTextContextDependentURIFragmentFactory<org.js.model.expression.FeatureReference2, org.js.model.expression.Feature2>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureReference2FeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.FEATURE_REFERENCE2__FEATURE), resolved, proxy);
	if (proxy != null) {
		Object value = proxy;
		element.eSet(element.eClass().getEStructuralFeature(org.js.model.expression.expressionPackage.FEATURE_REFERENCE2__FEATURE), value);
		completedElement(value, false);
	}
	collectHiddenTokens(element);
	retrieveLayoutInformation(element, org.js.model.expression.resource.expressionText.grammar.ExpressionTextGrammarInformationProvider.EXPRESSIONTEXT_8_0_0_0, proxy, true);
	copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
	copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
}
}
)
{
// expected elements (follow set)
addExpectedElement(null, org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[144]);
addExpectedElement(org.js.model.expression.expressionPackage.eINSTANCE.getGreaterThan(), org.js.model.expression.resource.expressionText.mopp.ExpressionTextExpectationConstants.EXPECTATIONS[145]);
}

;

parse_org_js_model_expression_Domain2 returns [org.js.model.expression.Domain2 element = null]
:
c0 = parse_org_js_model_expression_DiscreteDomain2{ element = c0; /* this is a subclass or primitive expression choice */ }
|c1 = parse_org_js_model_expression_ContinuousDomain2{ element = c1; /* this is a subclass or primitive expression choice */ }

;

parse_org_js_model_expression_Expression2 returns [org.js.model.expression.Expression2 element = null]
:
c = parseop_Expression2_level_1{ element = c; /* this rule is an expression root */ }

;

QUALIFIED_ATTRIBUTE_NAME_LITERAL:
((('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+'#'('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+))
{ _channel = 99; }
;
COMMENT:
('//'(~('\n'|'\r'|'\uffff'))* )
{ _channel = 99; }
;
ADDITION:
(('+'))
{ _channel = 99; }
;
SUBTRACTION:
(('-'))
{ _channel = 99; }
;
MULTIPLICATION:
(('*'))
{ _channel = 99; }
;
DIVISION:
(('/'))
{ _channel = 99; }
;
EQUAL:
(('=='))
;
UNEQUAL:
(('!='))
;
GREATERTHAN:
(('>'))
;
GREATERTHANOREQUAL:
(('>='))
;
LESSTHAN:
'<';
LESSTHANOREQUAL:
(('<='))
;
REQUIRES:
('requires')
;
EXCLUDES:
('excludes')
;
TEXT:
(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
;
WHITESPACE:
((' ' | '\t' | '\f'))
{ _channel = 99; }
;
LINEBREAK:
(('\r\n' | '\r' | '\n'))
{ _channel = 99; }
;
QUOTED_34_34:
(('"')(~('"'))*('"'))
;

