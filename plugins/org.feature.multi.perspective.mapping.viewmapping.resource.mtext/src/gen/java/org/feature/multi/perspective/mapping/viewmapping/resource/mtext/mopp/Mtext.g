grammar Mtext;

options {
	superClass = MtextANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;
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
	package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;
}

@members{
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolverFactory tokenResolverFactory = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTokenResolverFactory();
	
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
	private java.util.List<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal> expectedElements = new java.util.ArrayList<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal>();
	
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
		postParseCommands.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>() {
			public boolean execute(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextProblem() {
					public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity getSeverity() {
						return org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemSeverity.ERROR;
					}
					public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType getType() {
						return org.feature.multi.perspective.mapping.viewmapping.resource.mtext.MtextEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextQuickFix> getQuickFixes() {
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
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement terminal = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextFollowSetProvider.TERMINALS[terminalID];
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[] containmentFeatures = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextFollowSetProvider.LINKS[ids[i]];
		}
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextContainmentTrace containmentTrace = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal expectedElement = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		postParseCommands.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>() {
			public boolean execute(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource resource) {
				org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextLocationMap locationMap = resource.getLocationMap();
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
		postParseCommands.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>() {
			public boolean execute(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource resource) {
				org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextLocationMap locationMap = resource.getLocationMap();
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
	protected void setLocalizationEnd(java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>() {
			public boolean execute(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource resource) {
				org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextLocationMap locationMap = resource.getLocationMap();
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
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new MtextParser(new org.antlr.runtime3_4_0.CommonTokenStream(new MtextLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new MtextParser(new org.antlr.runtime3_4_0.CommonTokenStream(new MtextLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public MtextParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((MtextLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((MtextLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.feature.multi.perspective.mapping.viewmapping.MappingModel.class) {
				return parse_org_feature_multi_perspective_mapping_viewmapping_MappingModel();
			}
			if (type.getInstanceClass() == org.feature.multi.perspective.mapping.viewmapping.Mapping.class) {
				return parse_org_feature_multi_perspective_mapping_viewmapping_Mapping();
			}
		}
		throw new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource>>();
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextParseResult parseResult = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextParseResult();
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
	
	public java.util.List<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextParseResult result = parse();
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
			for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextCommand<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal>();
		java.util.List<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal> newFollowSet = new java.util.ArrayList<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 15;
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
				for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextPair<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextPair<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[]> newFollowerPair : newFollowers) {
							org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextContainmentTrace containmentTrace = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextContainmentTrace(null, newFollowerPair.getRight());
							org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal newFollowTerminal = new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectedTerminal expectedElement, int tokenIndex) {
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
		addExpectedElement(null, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_feature_multi_perspective_mapping_viewmapping_MappingModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_feature_multi_perspective_mapping_viewmapping_MappingModel returns [org.feature.multi.perspective.mapping.viewmapping.MappingModel element = null]
@init{
}
:
	a0 = 'viewmapping' {
		if (element == null) {
			element = org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory.eINSTANCE.createMappingModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[1]);
	}
	
	(
		a1 = 'featuremodel' {
			if (element == null) {
				element = org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory.eINSTANCE.createMappingModel();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_0_0_0_3_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[2]);
		}
		
		(
			a2 = QUOTED_60_62			
			{
				if (terminateParsing) {
					throw new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTerminateParsingException();
				}
				if (element == null) {
					element = org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory.eINSTANCE.createMappingModel();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
					tokenResolver.setOptions(getOptions());
					org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					org.featuremapper.models.feature.FeatureModel proxy = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeatureModel();
					collectHiddenTokens(element);
					registerContextDependentProxy(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContextDependentURIFragmentFactory<org.feature.multi.perspective.mapping.viewmapping.MappingModel, org.featuremapper.models.feature.FeatureModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMappingModelFeatureModelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__FEATURE_MODEL), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_0_0_0_3_0_0_2, proxy, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(null, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[3]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[4]);
	}
	
	(
		a3 = 'viewmodel' {
			if (element == null) {
				element = org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory.eINSTANCE.createMappingModel();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_0_0_0_6_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[5]);
		}
		
		(
			a4 = QUOTED_60_62			
			{
				if (terminateParsing) {
					throw new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTerminateParsingException();
				}
				if (element == null) {
					element = org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory.eINSTANCE.createMappingModel();
					startIncompleteElement(element);
				}
				if (a4 != null) {
					org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
					tokenResolver.setOptions(getOptions());
					org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					org.feature.multi.perspective.model.viewmodel.GroupModel proxy = org.feature.multi.perspective.model.viewmodel.ViewmodelFactory.eINSTANCE.createGroupModel();
					collectHiddenTokens(element);
					registerContextDependentProxy(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContextDependentURIFragmentFactory<org.feature.multi.perspective.mapping.viewmapping.MappingModel, org.feature.multi.perspective.model.viewmodel.GroupModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMappingModelViewModelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__VIEW_MODEL), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_0_0_0_6_0_0_2, proxy, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel(), org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[6]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel(), org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[7]);
	}
	
	(
		(
			(
				a5_0 = parse_org_feature_multi_perspective_mapping_viewmapping_Mapping				{
					if (terminateParsing) {
						throw new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTerminateParsingException();
					}
					if (element == null) {
						element = org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory.eINSTANCE.createMappingModel();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING_MODEL__MAPPINGS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_0_0_0_9_0_0_0, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			
		)*		{
			// expected elements (follow set)
			addExpectedElement(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel(), org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[8]);
		}
		
	)
	{
		// expected elements (follow set)
	}
	
;

parse_org_feature_multi_perspective_mapping_viewmapping_Mapping returns [org.feature.multi.perspective.mapping.viewmapping.Mapping element = null]
@init{
}
:
	a0 = 'view group' {
		if (element == null) {
			element = org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory.eINSTANCE.createMapping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[9]);
	}
	
	(
		a1 = QUOTED_34_34		
		{
			if (terminateParsing) {
				throw new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTerminateParsingException();
			}
			if (element == null) {
				element = org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory.eINSTANCE.createMapping();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
				tokenResolver.setOptions(getOptions());
				org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__VIEWGROUP), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.feature.multi.perspective.model.viewmodel.AbstractGroup proxy = org.feature.multi.perspective.model.viewmodel.ViewmodelFactory.eINSTANCE.createAbstractGroup();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContextDependentURIFragmentFactory<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.feature.multi.perspective.model.viewmodel.AbstractGroup>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMappingViewgroupReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__VIEWGROUP), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__VIEWGROUP), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_1_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[10]);
	}
	
	a2 = 'contains' {
		if (element == null) {
			element = org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory.eINSTANCE.createMapping();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_1_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[11]);
	}
	
	(
		(
			(
				a3 = QUOTED_34_34				
				{
					if (terminateParsing) {
						throw new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextTerminateParsingException();
					}
					if (element == null) {
						element = org.feature.multi.perspective.mapping.viewmapping.ViewmappingFactory.eINSTANCE.createMapping();
						startIncompleteElement(element);
					}
					if (a3 != null) {
						org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
						tokenResolver.setOptions(getOptions());
						org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__FEATURES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.featuremapper.models.feature.Feature proxy = org.featuremapper.models.feature.FeatureFactory.eINSTANCE.createFeature();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContextDependentURIFragmentFactory<org.feature.multi.perspective.mapping.viewmapping.Mapping, org.featuremapper.models.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getMappingFeaturesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__FEATURES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.MAPPING__FEATURES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextGrammarInformationProvider.MTEXT_1_0_0_7_0_0_0, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[12]);
				addExpectedElement(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel(), org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[13]);
			}
			
		)
		
	)+	{
		// expected elements (follow set)
		addExpectedElement(null, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[14]);
		addExpectedElement(org.feature.multi.perspective.mapping.viewmapping.ViewmappingPackage.eINSTANCE.getMappingModel(), org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextExpectationConstants.EXPECTATIONS[15]);
	}
	
;

TEXT:
	(('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+)
	{ _channel = 99; }
;
WHITESPACE:
	((' ' | '\t' | '\f'))
	{ _channel = 99; }
;
LINEBREAK:
	(('\r\n' | '\r' | '\n'))
	{ _channel = 99; }
;
QUOTED_60_62:
	(('<')(~('>'))*('>'))
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

