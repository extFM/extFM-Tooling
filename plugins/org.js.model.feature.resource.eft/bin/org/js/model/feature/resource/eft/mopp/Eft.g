grammar Eft;

options {
	superClass = EftANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.js.model.feature.resource.eft.mopp;
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
	package org.js.model.feature.resource.eft.mopp;
}

@members{
	private org.js.model.feature.resource.eft.IEftTokenResolverFactory tokenResolverFactory = new org.js.model.feature.resource.eft.mopp.EftTokenResolverFactory();
	
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
	private java.util.List<org.js.model.feature.resource.eft.mopp.EftExpectedTerminal> expectedElements = new java.util.ArrayList<org.js.model.feature.resource.eft.mopp.EftExpectedTerminal>();
	
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
		postParseCommands.add(new org.js.model.feature.resource.eft.IEftCommand<org.js.model.feature.resource.eft.IEftTextResource>() {
			public boolean execute(org.js.model.feature.resource.eft.IEftTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.js.model.feature.resource.eft.IEftProblem() {
					public org.js.model.feature.resource.eft.EftEProblemSeverity getSeverity() {
						return org.js.model.feature.resource.eft.EftEProblemSeverity.ERROR;
					}
					public org.js.model.feature.resource.eft.EftEProblemType getType() {
						return org.js.model.feature.resource.eft.EftEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.js.model.feature.resource.eft.IEftQuickFix> getQuickFixes() {
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
		org.js.model.feature.resource.eft.IEftExpectedElement terminal = org.js.model.feature.resource.eft.grammar.EftFollowSetProvider.TERMINALS[terminalID];
		org.js.model.feature.resource.eft.mopp.EftContainedFeature[] containmentFeatures = new org.js.model.feature.resource.eft.mopp.EftContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = org.js.model.feature.resource.eft.grammar.EftFollowSetProvider.LINKS[ids[i]];
		}
		org.js.model.feature.resource.eft.grammar.EftContainmentTrace containmentTrace = new org.js.model.feature.resource.eft.grammar.EftContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		org.js.model.feature.resource.eft.mopp.EftExpectedTerminal expectedElement = new org.js.model.feature.resource.eft.mopp.EftExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		postParseCommands.add(new org.js.model.feature.resource.eft.IEftCommand<org.js.model.feature.resource.eft.IEftTextResource>() {
			public boolean execute(org.js.model.feature.resource.eft.IEftTextResource resource) {
				org.js.model.feature.resource.eft.IEftLocationMap locationMap = resource.getLocationMap();
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
		postParseCommands.add(new org.js.model.feature.resource.eft.IEftCommand<org.js.model.feature.resource.eft.IEftTextResource>() {
			public boolean execute(org.js.model.feature.resource.eft.IEftTextResource resource) {
				org.js.model.feature.resource.eft.IEftLocationMap locationMap = resource.getLocationMap();
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
	protected void setLocalizationEnd(java.util.Collection<org.js.model.feature.resource.eft.IEftCommand<org.js.model.feature.resource.eft.IEftTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.js.model.feature.resource.eft.IEftCommand<org.js.model.feature.resource.eft.IEftTextResource>() {
			public boolean execute(org.js.model.feature.resource.eft.IEftTextResource resource) {
				org.js.model.feature.resource.eft.IEftLocationMap locationMap = resource.getLocationMap();
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
	
	public org.js.model.feature.resource.eft.IEftTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new EftParser(new org.antlr.runtime3_4_0.CommonTokenStream(new EftLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new EftParser(new org.antlr.runtime3_4_0.CommonTokenStream(new EftLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new org.js.model.feature.resource.eft.util.EftRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public EftParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((EftLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((EftLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.js.model.feature.FeatureModel.class) {
				return parse_org_js_model_feature_FeatureModel();
			}
			if (type.getInstanceClass() == org.js.model.feature.Feature.class) {
				return parse_org_js_model_feature_Feature();
			}
			if (type.getInstanceClass() == org.js.model.feature.Group.class) {
				return parse_org_js_model_feature_Group();
			}
			if (type.getInstanceClass() == org.js.model.feature.Attribute.class) {
				return parse_org_js_model_feature_Attribute();
			}
			if (type.getInstanceClass() == org.js.model.feature.NumericalDomain.class) {
				return parse_org_js_model_feature_NumericalDomain();
			}
			if (type.getInstanceClass() == org.js.model.feature.Interval.class) {
				return parse_org_js_model_feature_Interval();
			}
			if (type.getInstanceClass() == org.js.model.feature.DiscreteDomain.class) {
				return parse_org_js_model_feature_DiscreteDomain();
			}
			if (type.getInstanceClass() == org.js.model.feature.DomainValue.class) {
				return parse_org_js_model_feature_DomainValue();
			}
			if (type.getInstanceClass() == org.js.model.feature.Imply.class) {
				return parse_org_js_model_feature_Imply();
			}
			if (type.getInstanceClass() == org.js.model.feature.Exclude.class) {
				return parse_org_js_model_feature_Exclude();
			}
			if (type.getInstanceClass() == org.js.model.feature.AttributeConstraint.class) {
				return parse_org_js_model_feature_AttributeConstraint();
			}
			if (type.getInstanceClass() == org.js.model.feature.AttributeReference.class) {
				return parse_org_js_model_feature_AttributeReference();
			}
			if (type.getInstanceClass() == org.js.model.feature.AttributeValue.class) {
				return parse_org_js_model_feature_AttributeValue();
			}
		}
		throw new org.js.model.feature.resource.eft.mopp.EftUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(org.js.model.feature.resource.eft.IEftOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.js.model.feature.resource.eft.IEftParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.js.model.feature.resource.eft.IEftCommand<org.js.model.feature.resource.eft.IEftTextResource>>();
		org.js.model.feature.resource.eft.mopp.EftParseResult parseResult = new org.js.model.feature.resource.eft.mopp.EftParseResult();
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
	
	public java.util.List<org.js.model.feature.resource.eft.mopp.EftExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.js.model.feature.resource.eft.IEftTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		org.js.model.feature.resource.eft.IEftParseResult result = parse();
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
			for (org.js.model.feature.resource.eft.IEftCommand<org.js.model.feature.resource.eft.IEftTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.js.model.feature.resource.eft.mopp.EftExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.js.model.feature.resource.eft.mopp.EftExpectedTerminal>();
		java.util.List<org.js.model.feature.resource.eft.mopp.EftExpectedTerminal> newFollowSet = new java.util.ArrayList<org.js.model.feature.resource.eft.mopp.EftExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.js.model.feature.resource.eft.mopp.EftExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 88;
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
				for (org.js.model.feature.resource.eft.mopp.EftExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.js.model.feature.resource.eft.mopp.EftExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.js.model.feature.resource.eft.util.EftPair<org.js.model.feature.resource.eft.IEftExpectedElement, org.js.model.feature.resource.eft.mopp.EftContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.js.model.feature.resource.eft.util.EftPair<org.js.model.feature.resource.eft.IEftExpectedElement, org.js.model.feature.resource.eft.mopp.EftContainedFeature[]> newFollowerPair : newFollowers) {
							org.js.model.feature.resource.eft.IEftExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							org.js.model.feature.resource.eft.grammar.EftContainmentTrace containmentTrace = new org.js.model.feature.resource.eft.grammar.EftContainmentTrace(null, newFollowerPair.getRight());
							org.js.model.feature.resource.eft.mopp.EftExpectedTerminal newFollowTerminal = new org.js.model.feature.resource.eft.mopp.EftExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (org.js.model.feature.resource.eft.mopp.EftExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.js.model.feature.resource.eft.mopp.EftExpectedTerminal expectedElement, int tokenIndex) {
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
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_js_model_feature_FeatureModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_js_model_feature_FeatureModel returns [org.js.model.feature.FeatureModel element = null]
@init{
}
:
	a0 = 'featuremodel' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeatureModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[1]);
	}
	
	(
		a1 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeatureModel();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE_MODEL__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE_MODEL__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_0_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[2]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[3]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[4]);
	}
	
	(
		(
			a2_0 = parse_org_js_model_feature_Domain			{
				if (terminateParsing) {
					throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeatureModel();
					startIncompleteElement(element);
				}
				if (a2_0 != null) {
					if (a2_0 != null) {
						Object value = a2_0;
						addObjectToList(element, org.js.model.feature.FeaturePackage.FEATURE_MODEL__DOMAINS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_0_0_0_5, a2_0, true);
					copyLocalizationInfos(a2_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[5]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[7]);
	}
	
	(
		a3_0 = parse_org_js_model_feature_Feature		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeatureModel();
				startIncompleteElement(element);
			}
			if (a3_0 != null) {
				if (a3_0 != null) {
					Object value = a3_0;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE_MODEL__ROOT), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_0_0_0_7, a3_0, true);
				copyLocalizationInfos(a3_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[8]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[9]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[10]);
	}
	
	(
		(
			a4_0 = parse_org_js_model_feature_Constraint			{
				if (terminateParsing) {
					throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeatureModel();
					startIncompleteElement(element);
				}
				if (a4_0 != null) {
					if (a4_0 != null) {
						Object value = a4_0;
						addObjectToList(element, org.js.model.feature.FeaturePackage.FEATURE_MODEL__CONSTRAINTS, value);
						completedElement(value, true);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_0_0_0_9, a4_0, true);
					copyLocalizationInfos(a4_0, element);
				}
			}
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[11]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[12]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[13]);
	}
	
;

parse_org_js_model_feature_Feature returns [org.js.model.feature.Feature element = null]
@init{
}
:
	(
		(
			a0 = 'selected' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureState().getEEnumLiteral(org.js.model.feature.FeatureState.UNBOUND_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__CONFIGURATION_STATE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureState().getEEnumLiteral(org.js.model.feature.FeatureState.SELECTED_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__CONFIGURATION_STATE), value);
				completedElement(value, false);
			}
			|			a1 = 'deselected' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
					startIncompleteElement(element);
					// initialize enumeration attribute
					Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureState().getEEnumLiteral(org.js.model.feature.FeatureState.UNBOUND_VALUE).getInstance();
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__CONFIGURATION_STATE), value);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_1_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureState().getEEnumLiteral(org.js.model.feature.FeatureState.DESELECTED_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__CONFIGURATION_STATE), value);
				completedElement(value, false);
			}
		)?	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[14]);
	}
	
	a4 = 'feature' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureState().getEEnumLiteral(org.js.model.feature.FeatureState.UNBOUND_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__CONFIGURATION_STATE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_1_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[15]);
	}
	
	(
		a5 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureState().getEEnumLiteral(org.js.model.feature.FeatureState.UNBOUND_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__CONFIGURATION_STATE), value);
			}
			if (a5 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a5.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a5).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a5).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_1_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a5, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[16]);
	}
	
	a6 = '<' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureState().getEEnumLiteral(org.js.model.feature.FeatureState.UNBOUND_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__CONFIGURATION_STATE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_1_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[17]);
	}
	
	(
		a7 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
				startIncompleteElement(element);
				// initialize enumeration attribute
				Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureState().getEEnumLiteral(org.js.model.feature.FeatureState.UNBOUND_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__CONFIGURATION_STATE), value);
			}
			if (a7 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_1_0_0_6, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[18]);
	}
	
	a8 = '>' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
			startIncompleteElement(element);
			// initialize enumeration attribute
			Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureState().getEEnumLiteral(org.js.model.feature.FeatureState.UNBOUND_VALUE).getInstance();
			element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__CONFIGURATION_STATE), value);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_1_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[20]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[22]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[23]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[25]);
	}
	
	(
		(
			(
				(
					a9_0 = parse_org_js_model_feature_Attribute					{
						if (terminateParsing) {
							throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
						}
						if (element == null) {
							element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureState().getEEnumLiteral(org.js.model.feature.FeatureState.UNBOUND_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__CONFIGURATION_STATE), value);
						}
						if (a9_0 != null) {
							if (a9_0 != null) {
								Object value = a9_0;
								addObjectToList(element, org.js.model.feature.FeaturePackage.FEATURE__ATTRIBUTES, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_1_0_0_8_0_0_1_0_0_0, a9_0, true);
							copyLocalizationInfos(a9_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[26]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[27]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[28]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[29]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[30]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[31]);
					addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[32]);
				}
				
				
				|				(
					a10_0 = parse_org_js_model_feature_Group					{
						if (terminateParsing) {
							throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
						}
						if (element == null) {
							element = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
							startIncompleteElement(element);
							// initialize enumeration attribute
							Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureState().getEEnumLiteral(org.js.model.feature.FeatureState.UNBOUND_VALUE).getInstance();
							element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.FEATURE__CONFIGURATION_STATE), value);
						}
						if (a10_0 != null) {
							if (a10_0 != null) {
								Object value = a10_0;
								addObjectToList(element, org.js.model.feature.FeaturePackage.FEATURE__GROUPS, value);
								completedElement(value, true);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_1_0_0_8_0_0_1_0_1_0, a10_0, true);
							copyLocalizationInfos(a10_0, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[33]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[34]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[35]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[36]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[37]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[38]);
					addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[39]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[40]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[41]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[42]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[43]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[44]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[45]);
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[46]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[47]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[48]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[49]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[50]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[51]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[52]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[53]);
	}
	
;

parse_org_js_model_feature_Group returns [org.js.model.feature.Group element = null]
@init{
}
:
	a0 = 'group' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_2_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[54]);
	}
	
	a1 = '(' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_2_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[55]);
	}
	
	(
		a2 = INTEGER		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createGroup();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.GROUP__MIN_CARDINALITY), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.GROUP__MIN_CARDINALITY), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_2_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[56]);
	}
	
	a3 = '..' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_2_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[57]);
	}
	
	(
		a4 = INTEGER		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createGroup();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.GROUP__MAX_CARDINALITY), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.GROUP__MAX_CARDINALITY), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_2_0_0_5, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[58]);
	}
	
	a5 = ')' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_2_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[59]);
	}
	
	a6 = '{' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_2_0_0_8, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[60]);
	}
	
	(
		(
			(
				a7_0 = parse_org_js_model_feature_Feature				{
					if (terminateParsing) {
						throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.feature.FeatureFactory.eINSTANCE.createGroup();
						startIncompleteElement(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, org.js.model.feature.FeaturePackage.GROUP__CHILD_FEATURES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_2_0_0_9_0_0_1, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[61]);
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[62]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[63]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[64]);
	}
	
	a8 = '}' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_2_0_0_10, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[65]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[66]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[67]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[68]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[69]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[70]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[71]);
	}
	
;

parse_org_js_model_feature_Attribute returns [org.js.model.feature.Attribute element = null]
@init{
}
:
	a0 = 'attribute' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[72]);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE__NAME), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE__NAME), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_1, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[73]);
	}
	
	a2 = '[' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_3, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[74]);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE__DOMAIN), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.js.model.feature.Domain proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createDiscreteDomain();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.js.model.feature.resource.eft.mopp.EftContextDependentURIFragmentFactory<org.js.model.feature.Attribute, org.js.model.feature.Domain>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAttributeDomainReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE__DOMAIN), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE__DOMAIN), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_4, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[75]);
	}
	
	a4 = ']' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_5, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[76]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[77]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[78]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[79]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[80]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[81]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[82]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[83]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[84]);
	}
	
	(
		(
			a5 = '\\' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_6_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[85]);
			}
			
			a6 = '{' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_6_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[86]);
			}
			
			(
				a7 = TEXT				
				{
					if (terminateParsing) {
						throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
						startIncompleteElement(element);
					}
					if (a7 != null) {
						org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a7.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE__DESELECTED_DOMAIN_VALUES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a7).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a7).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							addObjectToList(element, org.js.model.feature.FeaturePackage.ATTRIBUTE__DESELECTED_DOMAIN_VALUES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_6_0_0_2, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a7, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[87]);
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[88]);
			}
			
			(
				(
					a8 = ',' {
						if (element == null) {
							element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_6_0_0_3_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[89]);
					}
					
					(
						a9 = TEXT						
						{
							if (terminateParsing) {
								throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
							}
							if (element == null) {
								element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
								startIncompleteElement(element);
							}
							if (a9 != null) {
								org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a9.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE__DESELECTED_DOMAIN_VALUES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a9).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a9).getStopIndex());
								}
								java.lang.String resolved = (java.lang.String) resolvedObject;
								if (resolved != null) {
									Object value = resolved;
									addObjectToList(element, org.js.model.feature.FeaturePackage.ATTRIBUTE__DESELECTED_DOMAIN_VALUES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_6_0_0_3_0_0_2, resolved, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a9, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[90]);
						addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[91]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[92]);
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[93]);
			}
			
			a10 = '}' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_6_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[94]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[95]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[96]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[97]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[98]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[99]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[100]);
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[101]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[102]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[103]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[104]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[105]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[106]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[107]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[108]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[109]);
	}
	
	(
		(
			a11 = ':=' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_7_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a11, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[110]);
			}
			
			(
				(
					a12 = QUOTED_34_34					
					{
						if (terminateParsing) {
							throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
						}
						if (element == null) {
							element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
							startIncompleteElement(element);
						}
						if (a12 != null) {
							org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
							tokenResolver.setOptions(getOptions());
							org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a12.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE__VALUE), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a12).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a12).getStopIndex());
							}
							java.lang.String resolved = (java.lang.String) resolvedObject;
							if (resolved != null) {
								Object value = resolved;
								element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE__VALUE), value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_3_0_0_7_0_0_3_0_0_0, resolved, true);
							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a12, element);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[111]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[112]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[113]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[114]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[115]);
					addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[116]);
					addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[117]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[118]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[119]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[120]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[121]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[122]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[123]);
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[124]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[125]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeature(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[126]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[127]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[128]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[129]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getGroup(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[130]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[131]);
	}
	
;

parse_org_js_model_feature_NumericalDomain returns [org.js.model.feature.NumericalDomain element = null]
@init{
}
:
	a0 = 'domain' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createNumericalDomain();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_4_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[132]);
	}
	
	a1 = '<' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createNumericalDomain();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_4_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[133]);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createNumericalDomain();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.NUMERICAL_DOMAIN__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.NUMERICAL_DOMAIN__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_4_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[134]);
	}
	
	a3 = '>' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createNumericalDomain();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_4_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[135]);
	}
	
	a4 = '[' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createNumericalDomain();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_4_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getNumericalDomain(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[136]);
	}
	
	(
		a5_0 = parse_org_js_model_feature_Interval		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createNumericalDomain();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					addObjectToList(element, org.js.model.feature.FeaturePackage.NUMERICAL_DOMAIN__INTERVALS, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_4_0_0_7, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[137]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[138]);
	}
	
	(
		(
			a6 = ',' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createNumericalDomain();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_4_0_0_8_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getNumericalDomain(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[139]);
			}
			
			(
				a7_0 = parse_org_js_model_feature_Interval				{
					if (terminateParsing) {
						throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.feature.FeatureFactory.eINSTANCE.createNumericalDomain();
						startIncompleteElement(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, org.js.model.feature.FeaturePackage.NUMERICAL_DOMAIN__INTERVALS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_4_0_0_8_0_0_2, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[140]);
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[141]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[142]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[143]);
	}
	
	a8 = ']' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createNumericalDomain();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_4_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[144]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[145]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[146]);
	}
	
;

parse_org_js_model_feature_Interval returns [org.js.model.feature.Interval element = null]
@init{
}
:
	(
		a0 = INTEGER		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createInterval();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.INTERVAL__LOWER_BOUND), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.INTERVAL__LOWER_BOUND), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_5_0_0_0, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[147]);
	}
	
	a1 = '..' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createInterval();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_5_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[148]);
	}
	
	(
		a2 = INTEGER		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createInterval();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.INTERVAL__UPPER_BOUND), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.INTERVAL__UPPER_BOUND), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_5_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[149]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[150]);
	}
	
;

parse_org_js_model_feature_DiscreteDomain returns [org.js.model.feature.DiscreteDomain element = null]
@init{
}
:
	a0 = 'domain' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createDiscreteDomain();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_6_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[151]);
	}
	
	a1 = '<' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createDiscreteDomain();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_6_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[152]);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createDiscreteDomain();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.DISCRETE_DOMAIN__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.DISCRETE_DOMAIN__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_6_0_0_3, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[153]);
	}
	
	a3 = '>' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createDiscreteDomain();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_6_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[154]);
	}
	
	a4 = '[' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createDiscreteDomain();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_6_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getDiscreteDomain(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[155]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getDiscreteDomain(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[156]);
	}
	
	(
		a5_0 = parse_org_js_model_feature_DomainValue		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createDiscreteDomain();
				startIncompleteElement(element);
			}
			if (a5_0 != null) {
				if (a5_0 != null) {
					Object value = a5_0;
					addObjectToList(element, org.js.model.feature.FeaturePackage.DISCRETE_DOMAIN__VALUES, value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_6_0_0_7, a5_0, true);
				copyLocalizationInfos(a5_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[157]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[158]);
	}
	
	(
		(
			a6 = ',' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createDiscreteDomain();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_6_0_0_8_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getDiscreteDomain(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[159]);
				addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getDiscreteDomain(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[160]);
			}
			
			(
				a7_0 = parse_org_js_model_feature_DomainValue				{
					if (terminateParsing) {
						throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.feature.FeatureFactory.eINSTANCE.createDiscreteDomain();
						startIncompleteElement(element);
					}
					if (a7_0 != null) {
						if (a7_0 != null) {
							Object value = a7_0;
							addObjectToList(element, org.js.model.feature.FeaturePackage.DISCRETE_DOMAIN__VALUES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_6_0_0_8_0_0_2, a7_0, true);
						copyLocalizationInfos(a7_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[161]);
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[162]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[163]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[164]);
	}
	
	a8 = ']' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createDiscreteDomain();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_6_0_0_9, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[165]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[166]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[167]);
	}
	
;

parse_org_js_model_feature_DomainValue returns [org.js.model.feature.DomainValue element = null]
@init{
}
:
	(
		(
			(
				a0 = TEXT				
				{
					if (terminateParsing) {
						throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.feature.FeatureFactory.eINSTANCE.createDomainValue();
						startIncompleteElement(element);
					}
					if (a0 != null) {
						org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.DOMAIN_VALUE__NAME), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
						}
						java.lang.String resolved = (java.lang.String) resolvedObject;
						if (resolved != null) {
							Object value = resolved;
							element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.DOMAIN_VALUE__NAME), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_7_0_0_0_0_0_0, resolved, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[168]);
			}
			
			a1 = '=' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createDomainValue();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_7_0_0_0_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[169]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[170]);
	}
	
	(
		a2 = INTEGER		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createDomainValue();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.DOMAIN_VALUE__INT), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.DOMAIN_VALUE__INT), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_7_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[171]);
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[172]);
	}
	
;

parse_org_js_model_feature_Imply returns [org.js.model.feature.Imply element = null]
@init{
}
:
	a0 = 'constraint' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createImply();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_8_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[173]);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createImply();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.IMPLY__LEFT_OPERAND), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.js.model.feature.Feature proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.js.model.feature.resource.eft.mopp.EftContextDependentURIFragmentFactory<org.js.model.feature.FeatureConstraint, org.js.model.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureConstraintLeftOperandReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.IMPLY__LEFT_OPERAND), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.IMPLY__LEFT_OPERAND), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_8_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[174]);
	}
	
	a2 = '->' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createImply();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_8_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[175]);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createImply();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.IMPLY__RIGHT_OPERAND), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.js.model.feature.Feature proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.js.model.feature.resource.eft.mopp.EftContextDependentURIFragmentFactory<org.js.model.feature.FeatureConstraint, org.js.model.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureConstraintRightOperandReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.IMPLY__RIGHT_OPERAND), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.IMPLY__RIGHT_OPERAND), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_8_0_0_6, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[176]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[177]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[178]);
	}
	
;

parse_org_js_model_feature_Exclude returns [org.js.model.feature.Exclude element = null]
@init{
}
:
	a0 = 'constraint' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createExclude();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_9_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[179]);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createExclude();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.EXCLUDE__LEFT_OPERAND), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.js.model.feature.Feature proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.js.model.feature.resource.eft.mopp.EftContextDependentURIFragmentFactory<org.js.model.feature.FeatureConstraint, org.js.model.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureConstraintLeftOperandReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.EXCLUDE__LEFT_OPERAND), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.EXCLUDE__LEFT_OPERAND), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_9_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[180]);
	}
	
	a2 = '<->' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createExclude();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_9_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[181]);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createExclude();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.EXCLUDE__RIGHT_OPERAND), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.js.model.feature.Feature proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.js.model.feature.resource.eft.mopp.EftContextDependentURIFragmentFactory<org.js.model.feature.FeatureConstraint, org.js.model.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureConstraintRightOperandReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.EXCLUDE__RIGHT_OPERAND), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.EXCLUDE__RIGHT_OPERAND), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_9_0_0_6, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[182]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[183]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[184]);
	}
	
;

parse_org_js_model_feature_AttributeConstraint returns [org.js.model.feature.AttributeConstraint element = null]
@init{
}
:
	a0 = 'constraint' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeConstraint();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_10_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getAttributeConstraint(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[185]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getAttributeConstraint(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[186]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getAttributeConstraint(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[187]);
	}
	
	(
		a1_0 = parse_org_js_model_feature_AttributeOperand		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeConstraint();
				startIncompleteElement(element);
			}
			if (a1_0 != null) {
				if (a1_0 != null) {
					Object value = a1_0;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_CONSTRAINT__ATTRIBUTE1), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_10_0_0_2, a1_0, true);
				copyLocalizationInfos(a1_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[188]);
	}
	
	(
		(
			a2 = '==' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_10_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
				// set value of enumeration attribute
				Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getRelop().getEEnumLiteral(org.js.model.feature.Relop.EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_CONSTRAINT__OPERATOR), value);
				completedElement(value, false);
			}
			|			a3 = '!=' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_10_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
				// set value of enumeration attribute
				Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getRelop().getEEnumLiteral(org.js.model.feature.Relop.UNEQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_CONSTRAINT__OPERATOR), value);
				completedElement(value, false);
			}
			|			a4 = '>' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_10_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
				// set value of enumeration attribute
				Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getRelop().getEEnumLiteral(org.js.model.feature.Relop.GREATER_THAN_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_CONSTRAINT__OPERATOR), value);
				completedElement(value, false);
			}
			|			a5 = '>=' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_10_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
				// set value of enumeration attribute
				Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getRelop().getEEnumLiteral(org.js.model.feature.Relop.GREATER_THAN_OR_EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_CONSTRAINT__OPERATOR), value);
				completedElement(value, false);
			}
			|			a6 = '<' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_10_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
				// set value of enumeration attribute
				Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getRelop().getEEnumLiteral(org.js.model.feature.Relop.LESS_THAN_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_CONSTRAINT__OPERATOR), value);
				completedElement(value, false);
			}
			|			a7 = '<=' {
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeConstraint();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_10_0_0_4, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
				// set value of enumeration attribute
				Object value = org.js.model.feature.FeaturePackage.eINSTANCE.getRelop().getEEnumLiteral(org.js.model.feature.Relop.LESS_THAN_OR_EQUAL_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_CONSTRAINT__OPERATOR), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getAttributeConstraint(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[189]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getAttributeConstraint(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[190]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getAttributeConstraint(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[191]);
	}
	
	(
		a10_0 = parse_org_js_model_feature_AttributeOperand		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeConstraint();
				startIncompleteElement(element);
			}
			if (a10_0 != null) {
				if (a10_0 != null) {
					Object value = a10_0;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_CONSTRAINT__ATTRIBUTE2), value);
					completedElement(value, true);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_10_0_0_6, a10_0, true);
				copyLocalizationInfos(a10_0, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[192]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[193]);
		addExpectedElement(org.js.model.feature.FeaturePackage.eINSTANCE.getFeatureModel(), org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[194]);
	}
	
;

parse_org_js_model_feature_AttributeReference returns [org.js.model.feature.AttributeReference element = null]
@init{
}
:
	(
		a0 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeReference();
				startIncompleteElement(element);
			}
			if (a0 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_REFERENCE__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.js.model.feature.Feature proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.js.model.feature.resource.eft.mopp.EftContextDependentURIFragmentFactory<org.js.model.feature.AttributeReference, org.js.model.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAttributeReferenceFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_REFERENCE__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_REFERENCE__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_11_0_0_0, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[195]);
	}
	
	a1 = '.' {
		if (element == null) {
			element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeReference();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_11_0_0_2, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[196]);
	}
	
	(
		a2 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeReference();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_REFERENCE__ATTRIBUTE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.js.model.feature.Attribute proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.js.model.feature.resource.eft.mopp.EftContextDependentURIFragmentFactory<org.js.model.feature.AttributeReference, org.js.model.feature.Attribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAttributeReferenceAttributeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_REFERENCE__ATTRIBUTE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_REFERENCE__ATTRIBUTE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_11_0_0_4, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[197]);
	}
	
;

parse_org_js_model_feature_AttributeValue returns [org.js.model.feature.AttributeValue element = null]
@init{
}
:
	(
		(
			a0 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeValue();
					startIncompleteElement(element);
				}
				if (a0 != null) {
					org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a0.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_VALUE__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a0).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a0).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_VALUE__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_12_0_0_0_0_0_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a0, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[198]);
		}
		
		
		|		(
			a1 = INTEGER			
			{
				if (terminateParsing) {
					throw new org.js.model.feature.resource.eft.mopp.EftTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.feature.FeatureFactory.eINSTANCE.createAttributeValue();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					org.js.model.feature.resource.eft.IEftTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("INTEGER");
					tokenResolver.setOptions(getOptions());
					org.js.model.feature.resource.eft.IEftTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_VALUE__INT), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
					}
					java.lang.Integer resolved = (java.lang.Integer) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.js.model.feature.FeaturePackage.ATTRIBUTE_VALUE__INT), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.feature.resource.eft.grammar.EftGrammarInformationProvider.EFT_12_0_0_0_0_1_0, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[199]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.feature.resource.eft.mopp.EftExpectationConstants.EXPECTATIONS[200]);
	}
	
;

parse_org_js_model_feature_Domain returns [org.js.model.feature.Domain element = null]
:
	c0 = parse_org_js_model_feature_NumericalDomain{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_js_model_feature_DiscreteDomain{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_js_model_feature_Constraint returns [org.js.model.feature.Constraint element = null]
:
	c0 = parse_org_js_model_feature_Imply{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_js_model_feature_Exclude{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_js_model_feature_AttributeConstraint{ element = c2; /* this is a subclass or primitive expression choice */ }
	
;

parse_org_js_model_feature_AttributeOperand returns [org.js.model.feature.AttributeOperand element = null]
:
	c0 = parse_org_js_model_feature_AttributeReference{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_js_model_feature_AttributeValue{ element = c1; /* this is a subclass or primitive expression choice */ }
	
;

INTEGER:
	(('0'..'9')+ )
;
COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))* )
	{ _channel = 99; }
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

