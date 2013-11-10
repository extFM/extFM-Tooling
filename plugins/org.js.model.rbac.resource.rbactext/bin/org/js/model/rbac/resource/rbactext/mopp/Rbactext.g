grammar Rbactext;

options {
	superClass = RbactextANTLRParserBase;
	backtrack = true;
	memoize = true;
}

@lexer::header {
	package org.js.model.rbac.resource.rbactext.mopp;
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
	package org.js.model.rbac.resource.rbactext.mopp;
}

@members{
	private org.js.model.rbac.resource.rbactext.IRbactextTokenResolverFactory tokenResolverFactory = new org.js.model.rbac.resource.rbactext.mopp.RbactextTokenResolverFactory();
	
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
	private java.util.List<org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal> expectedElements = new java.util.ArrayList<org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal>();
	
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
		postParseCommands.add(new org.js.model.rbac.resource.rbactext.IRbactextCommand<org.js.model.rbac.resource.rbactext.IRbactextTextResource>() {
			public boolean execute(org.js.model.rbac.resource.rbactext.IRbactextTextResource resource) {
				if (resource == null) {
					// the resource can be null if the parser is used for code completion
					return true;
				}
				resource.addProblem(new org.js.model.rbac.resource.rbactext.IRbactextProblem() {
					public org.js.model.rbac.resource.rbactext.RbactextEProblemSeverity getSeverity() {
						return org.js.model.rbac.resource.rbactext.RbactextEProblemSeverity.ERROR;
					}
					public org.js.model.rbac.resource.rbactext.RbactextEProblemType getType() {
						return org.js.model.rbac.resource.rbactext.RbactextEProblemType.SYNTAX_ERROR;
					}
					public String getMessage() {
						return errorMessage;
					}
					public java.util.Collection<org.js.model.rbac.resource.rbactext.IRbactextQuickFix> getQuickFixes() {
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
		org.js.model.rbac.resource.rbactext.IRbactextExpectedElement terminal = org.js.model.rbac.resource.rbactext.grammar.RbactextFollowSetProvider.TERMINALS[terminalID];
		org.js.model.rbac.resource.rbactext.mopp.RbactextContainedFeature[] containmentFeatures = new org.js.model.rbac.resource.rbactext.mopp.RbactextContainedFeature[ids.length - 2];
		for (int i = 2; i < ids.length; i++) {
			containmentFeatures[i - 2] = org.js.model.rbac.resource.rbactext.grammar.RbactextFollowSetProvider.LINKS[ids[i]];
		}
		org.js.model.rbac.resource.rbactext.grammar.RbactextContainmentTrace containmentTrace = new org.js.model.rbac.resource.rbactext.grammar.RbactextContainmentTrace(eClass, containmentFeatures);
		org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
		org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal expectedElement = new org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal(container, terminal, followSetID, containmentTrace);
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
		postParseCommands.add(new org.js.model.rbac.resource.rbactext.IRbactextCommand<org.js.model.rbac.resource.rbactext.IRbactextTextResource>() {
			public boolean execute(org.js.model.rbac.resource.rbactext.IRbactextTextResource resource) {
				org.js.model.rbac.resource.rbactext.IRbactextLocationMap locationMap = resource.getLocationMap();
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
		postParseCommands.add(new org.js.model.rbac.resource.rbactext.IRbactextCommand<org.js.model.rbac.resource.rbactext.IRbactextTextResource>() {
			public boolean execute(org.js.model.rbac.resource.rbactext.IRbactextTextResource resource) {
				org.js.model.rbac.resource.rbactext.IRbactextLocationMap locationMap = resource.getLocationMap();
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
	protected void setLocalizationEnd(java.util.Collection<org.js.model.rbac.resource.rbactext.IRbactextCommand<org.js.model.rbac.resource.rbactext.IRbactextTextResource>> postParseCommands , final org.eclipse.emf.ecore.EObject object, final int endChar, final int endLine) {
		if (disableLocationMap) {
			return;
		}
		postParseCommands.add(new org.js.model.rbac.resource.rbactext.IRbactextCommand<org.js.model.rbac.resource.rbactext.IRbactextTextResource>() {
			public boolean execute(org.js.model.rbac.resource.rbactext.IRbactextTextResource resource) {
				org.js.model.rbac.resource.rbactext.IRbactextLocationMap locationMap = resource.getLocationMap();
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
	
	public org.js.model.rbac.resource.rbactext.IRbactextTextParser createInstance(java.io.InputStream actualInputStream, String encoding) {
		try {
			if (encoding == null) {
				return new RbactextParser(new org.antlr.runtime3_4_0.CommonTokenStream(new RbactextLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream))));
			} else {
				return new RbactextParser(new org.antlr.runtime3_4_0.CommonTokenStream(new RbactextLexer(new org.antlr.runtime3_4_0.ANTLRInputStream(actualInputStream, encoding))));
			}
		} catch (java.io.IOException e) {
			new org.js.model.rbac.resource.rbactext.util.RbactextRuntimeUtil().logError("Error while creating parser.", e);
			return null;
		}
	}
	
	/**
	 * This default constructor is only used to call createInstance() on it.
	 */
	public RbactextParser() {
		super(null);
	}
	
	protected org.eclipse.emf.ecore.EObject doParse() throws org.antlr.runtime3_4_0.RecognitionException {
		this.lastPosition = 0;
		// required because the lexer class can not be subclassed
		((RbactextLexer) getTokenStream().getTokenSource()).lexerExceptions = lexerExceptions;
		((RbactextLexer) getTokenStream().getTokenSource()).lexerExceptionsPosition = lexerExceptionsPosition;
		Object typeObject = getTypeObject();
		if (typeObject == null) {
			return start();
		} else if (typeObject instanceof org.eclipse.emf.ecore.EClass) {
			org.eclipse.emf.ecore.EClass type = (org.eclipse.emf.ecore.EClass) typeObject;
			if (type.getInstanceClass() == org.js.model.rbac.AccessControlModel.class) {
				return parse_org_js_model_rbac_AccessControlModel();
			}
			if (type.getInstanceClass() == org.js.model.rbac.Role.class) {
				return parse_org_js_model_rbac_Role();
			}
			if (type.getInstanceClass() == org.js.model.rbac.FeatureOperation.class) {
				return parse_org_js_model_rbac_FeatureOperation();
			}
			if (type.getInstanceClass() == org.js.model.rbac.AttributeOperation.class) {
				return parse_org_js_model_rbac_AttributeOperation();
			}
			if (type.getInstanceClass() == org.js.model.rbac.DomainValueOperation.class) {
				return parse_org_js_model_rbac_DomainValueOperation();
			}
			if (type.getInstanceClass() == org.js.model.rbac.Subject.class) {
				return parse_org_js_model_rbac_Subject();
			}
			if (type.getInstanceClass() == org.js.model.rbac.Group.class) {
				return parse_org_js_model_rbac_Group();
			}
			if (type.getInstanceClass() == org.js.model.rbac.Task.class) {
				return parse_org_js_model_rbac_Task();
			}
			if (type.getInstanceClass() == org.js.model.rbac.VisibilityRestriction.class) {
				return parse_org_js_model_rbac_VisibilityRestriction();
			}
		}
		throw new org.js.model.rbac.resource.rbactext.mopp.RbactextUnexpectedContentTypeException(typeObject);
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
			typeObject = options.get(org.js.model.rbac.resource.rbactext.IRbactextOptions.RESOURCE_CONTENT_TYPE);
		}
		return typeObject;
	}
	
	/**
	 * Implementation that calls {@link #doParse()} and handles the thrown
	 * RecognitionExceptions.
	 */
	public org.js.model.rbac.resource.rbactext.IRbactextParseResult parse() {
		terminateParsing = false;
		postParseCommands = new java.util.ArrayList<org.js.model.rbac.resource.rbactext.IRbactextCommand<org.js.model.rbac.resource.rbactext.IRbactextTextResource>>();
		org.js.model.rbac.resource.rbactext.mopp.RbactextParseResult parseResult = new org.js.model.rbac.resource.rbactext.mopp.RbactextParseResult();
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
	
	public java.util.List<org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal> parseToExpectedElements(org.eclipse.emf.ecore.EClass type, org.js.model.rbac.resource.rbactext.IRbactextTextResource dummyResource, int cursorOffset) {
		this.rememberExpectedElements = true;
		this.parseToIndexTypeObject = type;
		this.cursorOffset = cursorOffset;
		this.lastStartIncludingHidden = -1;
		final org.antlr.runtime3_4_0.CommonTokenStream tokenStream = (org.antlr.runtime3_4_0.CommonTokenStream) getTokenStream();
		org.js.model.rbac.resource.rbactext.IRbactextParseResult result = parse();
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
			for (org.js.model.rbac.resource.rbactext.IRbactextCommand<org.js.model.rbac.resource.rbactext.IRbactextTextResource> command : result.getPostParseCommands()) {
				command.execute(dummyResource);
			}
		}
		// remove all expected elements that were added after the last complete element
		expectedElements = expectedElements.subList(0, expectedElementsIndexOfLastCompleteElement + 1);
		int lastFollowSetID = expectedElements.get(expectedElementsIndexOfLastCompleteElement).getFollowSetID();
		java.util.Set<org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal> currentFollowSet = new java.util.LinkedHashSet<org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal>();
		java.util.List<org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal> newFollowSet = new java.util.ArrayList<org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal>();
		for (int i = expectedElementsIndexOfLastCompleteElement; i >= 0; i--) {
			org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal expectedElementI = expectedElements.get(i);
			if (expectedElementI.getFollowSetID() == lastFollowSetID) {
				currentFollowSet.add(expectedElementI);
			} else {
				break;
			}
		}
		int followSetID = 72;
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
				for (org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal nextFollow : newFollowSet) {
					lastTokenIndex = 0;
					setPosition(nextFollow, i);
				}
				newFollowSet.clear();
				// normal tokens do reduce the follow set - only elements that match the token are
				// kept
				for (org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal nextFollow : currentFollowSet) {
					if (nextFollow.getTerminal().getTokenNames().contains(getTokenNames()[nextToken.getType()])) {
						// keep this one - it matches
						java.util.Collection<org.js.model.rbac.resource.rbactext.util.RbactextPair<org.js.model.rbac.resource.rbactext.IRbactextExpectedElement, org.js.model.rbac.resource.rbactext.mopp.RbactextContainedFeature[]>> newFollowers = nextFollow.getTerminal().getFollowers();
						for (org.js.model.rbac.resource.rbactext.util.RbactextPair<org.js.model.rbac.resource.rbactext.IRbactextExpectedElement, org.js.model.rbac.resource.rbactext.mopp.RbactextContainedFeature[]> newFollowerPair : newFollowers) {
							org.js.model.rbac.resource.rbactext.IRbactextExpectedElement newFollower = newFollowerPair.getLeft();
							org.eclipse.emf.ecore.EObject container = getLastIncompleteElement();
							org.js.model.rbac.resource.rbactext.grammar.RbactextContainmentTrace containmentTrace = new org.js.model.rbac.resource.rbactext.grammar.RbactextContainmentTrace(null, newFollowerPair.getRight());
							org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal newFollowTerminal = new org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal(container, newFollower, followSetID, containmentTrace);
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
		for (org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal nextFollow : newFollowSet) {
			lastTokenIndex = 0;
			setPosition(nextFollow, i);
		}
		return this.expectedElements;
	}
	
	public void setPosition(org.js.model.rbac.resource.rbactext.mopp.RbactextExpectedTerminal expectedElement, int tokenIndex) {
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
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[0]);
		expectedElementsIndexOfLastCompleteElement = 0;
	}
	(
		c0 = parse_org_js_model_rbac_AccessControlModel{ element = c0; }
	)
	EOF	{
		retrieveLayoutInformation(element, null, null, false);
	}
	
;

parse_org_js_model_rbac_AccessControlModel returns [org.js.model.rbac.AccessControlModel element = null]
@init{
}
:
	a0 = 'access control' {
		if (element == null) {
			element = org.js.model.rbac.RbacFactory.eINSTANCE.createAccessControlModel();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_0_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[1]);
	}
	
	(
		a1 = 'on' {
			if (element == null) {
				element = org.js.model.rbac.RbacFactory.eINSTANCE.createAccessControlModel();
				startIncompleteElement(element);
			}
			collectHiddenTokens(element);
			retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_0_0_0_2_0_0_0, null, true);
			copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
		}
		{
			// expected elements (follow set)
			addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[2]);
		}
		
		(
			a2 = QUOTED_60_62			
			{
				if (terminateParsing) {
					throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createAccessControlModel();
					startIncompleteElement(element);
				}
				if (a2 != null) {
					org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
					tokenResolver.setOptions(getOptions());
					org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ACCESS_CONTROL_MODEL__FEATURE_MODEL), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
					}
					String resolved = (String) resolvedObject;
					org.js.model.feature.FeatureModel proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createFeatureModel();
					collectHiddenTokens(element);
					registerContextDependentProxy(new org.js.model.rbac.resource.rbactext.mopp.RbactextContextDependentURIFragmentFactory<org.js.model.rbac.AccessControlModel, org.js.model.feature.FeatureModel>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAccessControlModelFeatureModelReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ACCESS_CONTROL_MODEL__FEATURE_MODEL), resolved, proxy);
					if (proxy != null) {
						Object value = proxy;
						element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ACCESS_CONTROL_MODEL__FEATURE_MODEL), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_0_0_0_2_0_0_2, proxy, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, proxy);
				}
			}
		)
		{
			// expected elements (follow set)
			addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[3]);
			addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[4]);
			addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[5]);
		}
		
	)
	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[6]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[7]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[8]);
	}
	
	(
		(
			(
				a3_0 = parse_org_js_model_rbac_Role				{
					if (terminateParsing) {
						throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.rbac.RbacFactory.eINSTANCE.createAccessControlModel();
						startIncompleteElement(element);
					}
					if (a3_0 != null) {
						if (a3_0 != null) {
							Object value = a3_0;
							addObjectToList(element, org.js.model.rbac.RbacPackage.ACCESS_CONTROL_MODEL__ROLES, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_0_0_0_4_0_0_0, a3_0, true);
						copyLocalizationInfos(a3_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[9]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[10]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[11]);
			}
			
			
			|			(
				a4_0 = parse_org_js_model_rbac_Group				{
					if (terminateParsing) {
						throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.rbac.RbacFactory.eINSTANCE.createAccessControlModel();
						startIncompleteElement(element);
					}
					if (a4_0 != null) {
						if (a4_0 != null) {
							Object value = a4_0;
							addObjectToList(element, org.js.model.rbac.RbacPackage.ACCESS_CONTROL_MODEL__GROUPS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_0_0_0_4_0_1_0, a4_0, true);
						copyLocalizationInfos(a4_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[12]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[13]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[14]);
			}
			
			
			|			(
				a5_0 = parse_org_js_model_rbac_Subject				{
					if (terminateParsing) {
						throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.rbac.RbacFactory.eINSTANCE.createAccessControlModel();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.js.model.rbac.RbacPackage.ACCESS_CONTROL_MODEL__SUBJECTS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_0_0_0_4_0_2_0, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[15]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[16]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[17]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[18]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[19]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[20]);
	}
	
;

parse_org_js_model_rbac_Role returns [org.js.model.rbac.Role element = null]
@init{
}
:
	a0 = 'role' {
		if (element == null) {
			element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[21]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[22]);
	}
	
	(
		(
			a1 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ROLE__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ROLE__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_2, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[23]);
	}
	
	(
		a2 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ROLE__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ROLE__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[24]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[25]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[26]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[27]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[28]);
	}
	
	(
		(
			a3 = 'extends' {
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_6_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[29]);
			}
			
			(
				(
					a4 = TEXT					
					{
						if (terminateParsing) {
							throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
						}
						if (element == null) {
							element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
							startIncompleteElement(element);
						}
						if (a4 != null) {
							org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
							tokenResolver.setOptions(getOptions());
							org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
							tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ROLE__PARENT_ROLES), result);
							Object resolvedObject = result.getResolvedToken();
							if (resolvedObject == null) {
								addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
							}
							String resolved = (String) resolvedObject;
							org.js.model.rbac.Role proxy = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
							collectHiddenTokens(element);
							registerContextDependentProxy(new org.js.model.rbac.resource.rbactext.mopp.RbactextContextDependentURIFragmentFactory<org.js.model.rbac.Role, org.js.model.rbac.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRoleParentRolesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ROLE__PARENT_ROLES), resolved, proxy);
							if (proxy != null) {
								Object value = proxy;
								addObjectToList(element, org.js.model.rbac.RbacPackage.ROLE__PARENT_ROLES, value);
								completedElement(value, false);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_6_0_0_2_0_0_0, proxy, true);
							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
						}
					}
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[30]);
					addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[31]);
					addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[32]);
					addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[33]);
					addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[34]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[35]);
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[36]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[37]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[38]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[39]);
			}
			
			(
				(
					a5 = ',' {
						if (element == null) {
							element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_6_0_0_3_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[40]);
					}
					
					(
						a6 = TEXT						
						{
							if (terminateParsing) {
								throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
							}
							if (element == null) {
								element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
								startIncompleteElement(element);
							}
							if (a6 != null) {
								org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ROLE__PARENT_ROLES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								org.js.model.rbac.Role proxy = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
								collectHiddenTokens(element);
								registerContextDependentProxy(new org.js.model.rbac.resource.rbactext.mopp.RbactextContextDependentURIFragmentFactory<org.js.model.rbac.Role, org.js.model.rbac.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getRoleParentRolesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ROLE__PARENT_ROLES), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, org.js.model.rbac.RbacPackage.ROLE__PARENT_ROLES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_6_0_0_3_0_0_3, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[41]);
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[42]);
						addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[43]);
						addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[44]);
						addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[45]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[46]);
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[47]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[48]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[49]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[50]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[51]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[52]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[53]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[54]);
	}
	
	(
		(
			(
				a7 = '{' {
					if (element == null) {
						element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_8_0_0_0_0_0_0, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getRole(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[55]);
					addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getRole(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[56]);
					addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getRole(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[57]);
					addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getRole(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[58]);
					addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getRole(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[59]);
				}
				
				(
					(
						a8_0 = parse_org_js_model_rbac_Permission						{
							if (terminateParsing) {
								throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
							}
							if (element == null) {
								element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
								startIncompleteElement(element);
							}
							if (a8_0 != null) {
								if (a8_0 != null) {
									Object value = a8_0;
									addObjectToList(element, org.js.model.rbac.RbacPackage.ROLE__PERMISSIONS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_8_0_0_0_0_0_2_0_0_0, a8_0, true);
								copyLocalizationInfos(a8_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[60]);
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[61]);
					}
					
					
					|					(
						a9_0 = parse_org_js_model_rbac_Task						{
							if (terminateParsing) {
								throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
							}
							if (element == null) {
								element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
								startIncompleteElement(element);
							}
							if (a9_0 != null) {
								if (a9_0 != null) {
									Object value = a9_0;
									addObjectToList(element, org.js.model.rbac.RbacPackage.ROLE__TASKS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_8_0_0_0_0_0_2_0_1_0, a9_0, true);
								copyLocalizationInfos(a9_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[62]);
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[63]);
					}
					
				)
				{
					// expected elements (follow set)
					addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[64]);
					addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[65]);
				}
				
				(
					(
						a10 = ',' {
							if (element == null) {
								element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
								startIncompleteElement(element);
							}
							collectHiddenTokens(element);
							retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_8_0_0_0_0_0_4_0_0_0, null, true);
							copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a10, element);
						}
						{
							// expected elements (follow set)
							addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getRole(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[66]);
							addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getRole(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[67]);
							addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getRole(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[68]);
							addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getRole(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[69]);
							addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getRole(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[70]);
						}
						
						(
							(
								a11_0 = parse_org_js_model_rbac_Permission								{
									if (terminateParsing) {
										throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
									}
									if (element == null) {
										element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
										startIncompleteElement(element);
									}
									if (a11_0 != null) {
										if (a11_0 != null) {
											Object value = a11_0;
											addObjectToList(element, org.js.model.rbac.RbacPackage.ROLE__PERMISSIONS, value);
											completedElement(value, true);
										}
										collectHiddenTokens(element);
										retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_8_0_0_0_0_0_4_0_0_2_0_0_0, a11_0, true);
										copyLocalizationInfos(a11_0, element);
									}
								}
							)
							{
								// expected elements (follow set)
								addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[71]);
								addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[72]);
							}
							
							
							|							(
								a12_0 = parse_org_js_model_rbac_Task								{
									if (terminateParsing) {
										throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
									}
									if (element == null) {
										element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
										startIncompleteElement(element);
									}
									if (a12_0 != null) {
										if (a12_0 != null) {
											Object value = a12_0;
											addObjectToList(element, org.js.model.rbac.RbacPackage.ROLE__TASKS, value);
											completedElement(value, true);
										}
										collectHiddenTokens(element);
										retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_8_0_0_0_0_0_4_0_0_2_0_1_0, a12_0, true);
										copyLocalizationInfos(a12_0, element);
									}
								}
							)
							{
								// expected elements (follow set)
								addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[73]);
								addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[74]);
							}
							
						)
						{
							// expected elements (follow set)
							addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[75]);
							addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[76]);
						}
						
					)
					
				)*				{
					// expected elements (follow set)
					addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[77]);
					addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[78]);
				}
				
				a13 = '}' {
					if (element == null) {
						element = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
						startIncompleteElement(element);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_1_0_0_8_0_0_0_0_0_7, null, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a13, element);
				}
				{
					// expected elements (follow set)
					addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[79]);
					addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[80]);
					addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[81]);
				}
				
			)
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[82]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[83]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[84]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[85]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[86]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[87]);
	}
	
;

parse_org_js_model_rbac_FeatureOperation returns [org.js.model.rbac.FeatureOperation element = null]
@init{
}
:
	(
		(
			a0 = 'select' {
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createFeatureOperation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_2_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.js.model.rbac.RbacPackage.eINSTANCE.getConfigurationType().getEEnumLiteral(org.js.model.rbac.ConfigurationType.SELECT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.FEATURE_OPERATION__TYPE), value);
				completedElement(value, false);
			}
			|			a1 = 'deselect' {
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createFeatureOperation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_2_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.js.model.rbac.RbacPackage.eINSTANCE.getConfigurationType().getEEnumLiteral(org.js.model.rbac.ConfigurationType.DESELECT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.FEATURE_OPERATION__TYPE), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[88]);
	}
	
	(
		a4 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.rbac.RbacFactory.eINSTANCE.createFeatureOperation();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.FEATURE_OPERATION__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.js.model.feature.Feature proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.js.model.rbac.resource.rbactext.mopp.RbactextContextDependentURIFragmentFactory<org.js.model.rbac.FeatureOperation, org.js.model.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureOperationFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.FEATURE_OPERATION__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.FEATURE_OPERATION__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_2_0_0_3, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[89]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[90]);
	}
	
;

parse_org_js_model_rbac_AttributeOperation returns [org.js.model.rbac.AttributeOperation element = null]
@init{
}
:
	a0 = 'set' {
		if (element == null) {
			element = org.js.model.rbac.RbacFactory.eINSTANCE.createAttributeOperation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_3_0_0_1, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[91]);
	}
	
	(
		a1 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.rbac.RbacFactory.eINSTANCE.createAttributeOperation();
				startIncompleteElement(element);
			}
			if (a1 != null) {
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ATTRIBUTE_OPERATION__FEATURE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.js.model.feature.Feature proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createFeature();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.js.model.rbac.resource.rbactext.mopp.RbactextContextDependentURIFragmentFactory<org.js.model.rbac.AttributeOperation, org.js.model.feature.Feature>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAttributeOperationFeatureReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ATTRIBUTE_OPERATION__FEATURE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ATTRIBUTE_OPERATION__FEATURE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_3_0_0_2, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[92]);
	}
	
	a2 = '.' {
		if (element == null) {
			element = org.js.model.rbac.RbacFactory.eINSTANCE.createAttributeOperation();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_3_0_0_4, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a2, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[93]);
	}
	
	(
		a3 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.rbac.RbacFactory.eINSTANCE.createAttributeOperation();
				startIncompleteElement(element);
			}
			if (a3 != null) {
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a3.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ATTRIBUTE_OPERATION__ATTRIBUTE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a3).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a3).getStopIndex());
				}
				String resolved = (String) resolvedObject;
				org.js.model.feature.Attribute proxy = org.js.model.feature.FeatureFactory.eINSTANCE.createAttribute();
				collectHiddenTokens(element);
				registerContextDependentProxy(new org.js.model.rbac.resource.rbactext.mopp.RbactextContextDependentURIFragmentFactory<org.js.model.rbac.AttributeOperation, org.js.model.feature.Attribute>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getAttributeOperationAttributeReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ATTRIBUTE_OPERATION__ATTRIBUTE), resolved, proxy);
				if (proxy != null) {
					Object value = proxy;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.ATTRIBUTE_OPERATION__ATTRIBUTE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_3_0_0_6, proxy, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, element);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a3, proxy);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[94]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[95]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[96]);
	}
	
	(
		(
			a4 = '{' {
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createAttributeOperation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_3_0_0_7_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a4, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAttributeOperation(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[97]);
			}
			
			(
				a5_0 = parse_org_js_model_rbac_DomainValueOperation				{
					if (terminateParsing) {
						throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.rbac.RbacFactory.eINSTANCE.createAttributeOperation();
						startIncompleteElement(element);
					}
					if (a5_0 != null) {
						if (a5_0 != null) {
							Object value = a5_0;
							addObjectToList(element, org.js.model.rbac.RbacPackage.ATTRIBUTE_OPERATION__VALUE_OPERATIONS, value);
							completedElement(value, true);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_3_0_0_7_0_0_3, a5_0, true);
						copyLocalizationInfos(a5_0, element);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[98]);
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[99]);
			}
			
			(
				(
					a6 = ',' {
						if (element == null) {
							element = org.js.model.rbac.RbacFactory.eINSTANCE.createAttributeOperation();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_3_0_0_7_0_0_4_0_0_0, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a6, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAttributeOperation(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[100]);
					}
					
					(
						a7_0 = parse_org_js_model_rbac_DomainValueOperation						{
							if (terminateParsing) {
								throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
							}
							if (element == null) {
								element = org.js.model.rbac.RbacFactory.eINSTANCE.createAttributeOperation();
								startIncompleteElement(element);
							}
							if (a7_0 != null) {
								if (a7_0 != null) {
									Object value = a7_0;
									addObjectToList(element, org.js.model.rbac.RbacPackage.ATTRIBUTE_OPERATION__VALUE_OPERATIONS, value);
									completedElement(value, true);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_3_0_0_7_0_0_4_0_0_2, a7_0, true);
								copyLocalizationInfos(a7_0, element);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[101]);
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[102]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[103]);
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[104]);
			}
			
			a8 = '}' {
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createAttributeOperation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_3_0_0_7_0_0_5, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a8, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[105]);
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[106]);
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[107]);
			}
			
		)
		
	)*	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[108]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[109]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[110]);
	}
	
;

parse_org_js_model_rbac_DomainValueOperation returns [org.js.model.rbac.DomainValueOperation element = null]
@init{
}
:
	(
		(
			a0 = 'select' {
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createDomainValueOperation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.js.model.rbac.RbacPackage.eINSTANCE.getConfigurationType().getEEnumLiteral(org.js.model.rbac.ConfigurationType.SELECT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.DOMAIN_VALUE_OPERATION__TYPE), value);
				completedElement(value, false);
			}
			|			a1 = 'deselect' {
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createDomainValueOperation();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_4_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.js.model.rbac.RbacPackage.eINSTANCE.getConfigurationType().getEEnumLiteral(org.js.model.rbac.ConfigurationType.DESELECT_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.DOMAIN_VALUE_OPERATION__TYPE), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[111]);
	}
	
	(
		a4 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.rbac.RbacFactory.eINSTANCE.createDomainValueOperation();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.DOMAIN_VALUE_OPERATION__VALUE), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.DOMAIN_VALUE_OPERATION__VALUE), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_4_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[112]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[113]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[114]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[115]);
	}
	
;

parse_org_js_model_rbac_Subject returns [org.js.model.rbac.Subject element = null]
@init{
}
:
	a0 = 'subject' {
		if (element == null) {
			element = org.js.model.rbac.RbacFactory.eINSTANCE.createSubject();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_5_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[116]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[117]);
	}
	
	(
		(
			a1 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createSubject();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.SUBJECT__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.SUBJECT__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_5_0_0_2, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[118]);
	}
	
	(
		a2 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.rbac.RbacFactory.eINSTANCE.createSubject();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.SUBJECT__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.SUBJECT__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_5_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[119]);
	}
	
	a3 = 'plays' {
		if (element == null) {
			element = org.js.model.rbac.RbacFactory.eINSTANCE.createSubject();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_5_0_0_6, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[120]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[121]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[122]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[123]);
	}
	
	(
		(
			(
				a4 = TEXT				
				{
					if (terminateParsing) {
						throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.rbac.RbacFactory.eINSTANCE.createSubject();
						startIncompleteElement(element);
					}
					if (a4 != null) {
						org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.SUBJECT__ROLES), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.js.model.rbac.Role proxy = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.js.model.rbac.resource.rbactext.mopp.RbactextContextDependentURIFragmentFactory<org.js.model.rbac.Subject, org.js.model.rbac.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSubjectRolesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.SUBJECT__ROLES), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, org.js.model.rbac.RbacPackage.SUBJECT__ROLES, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_5_0_0_8_0_0_0, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[124]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[125]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[126]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[127]);
			}
			
			(
				(
					a5 = ',' {
						if (element == null) {
							element = org.js.model.rbac.RbacFactory.eINSTANCE.createSubject();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_5_0_0_8_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[128]);
					}
					
					(
						a6 = TEXT						
						{
							if (terminateParsing) {
								throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
							}
							if (element == null) {
								element = org.js.model.rbac.RbacFactory.eINSTANCE.createSubject();
								startIncompleteElement(element);
							}
							if (a6 != null) {
								org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.SUBJECT__ROLES), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								org.js.model.rbac.Role proxy = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
								collectHiddenTokens(element);
								registerContextDependentProxy(new org.js.model.rbac.resource.rbactext.mopp.RbactextContextDependentURIFragmentFactory<org.js.model.rbac.Subject, org.js.model.rbac.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getSubjectRolesReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.SUBJECT__ROLES), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, org.js.model.rbac.RbacPackage.SUBJECT__ROLES, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_5_0_0_8_0_0_1_0_0_3, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[129]);
						addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[130]);
						addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[131]);
						addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[132]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[133]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[134]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[135]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[136]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[137]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[138]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[139]);
	}
	
;

parse_org_js_model_rbac_Group returns [org.js.model.rbac.Group element = null]
@init{
}
:
	a0 = 'group' {
		if (element == null) {
			element = org.js.model.rbac.RbacFactory.eINSTANCE.createGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_6_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[140]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[141]);
	}
	
	(
		(
			a1 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createGroup();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.GROUP__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.GROUP__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_6_0_0_2, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[142]);
	}
	
	(
		a2 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.rbac.RbacFactory.eINSTANCE.createGroup();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.GROUP__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.GROUP__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_6_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[143]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[144]);
	}
	
	(
		(
			a3 = 'of' {
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createGroup();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_6_0_0_5_0_0_1, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a3, element);
			}
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[145]);
			}
			
			(
				a4 = TEXT				
				{
					if (terminateParsing) {
						throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.rbac.RbacFactory.eINSTANCE.createGroup();
						startIncompleteElement(element);
					}
					if (a4 != null) {
						org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.GROUP__OWNER), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.js.model.rbac.Role proxy = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.js.model.rbac.resource.rbactext.mopp.RbactextContextDependentURIFragmentFactory<org.js.model.rbac.Group, org.js.model.rbac.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGroupOwnerReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.GROUP__OWNER), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.GROUP__OWNER), value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_6_0_0_5_0_0_3, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[146]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[147]);
	}
	
	a5 = 'has members' {
		if (element == null) {
			element = org.js.model.rbac.RbacFactory.eINSTANCE.createGroup();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_6_0_0_7, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a5, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[148]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[149]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[150]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[151]);
	}
	
	(
		(
			(
				a6 = TEXT				
				{
					if (terminateParsing) {
						throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
					}
					if (element == null) {
						element = org.js.model.rbac.RbacFactory.eINSTANCE.createGroup();
						startIncompleteElement(element);
					}
					if (a6 != null) {
						org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
						tokenResolver.setOptions(getOptions());
						org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
						tokenResolver.resolve(a6.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.GROUP__MEMBERS), result);
						Object resolvedObject = result.getResolvedToken();
						if (resolvedObject == null) {
							addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a6).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a6).getStopIndex());
						}
						String resolved = (String) resolvedObject;
						org.js.model.rbac.Role proxy = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
						collectHiddenTokens(element);
						registerContextDependentProxy(new org.js.model.rbac.resource.rbactext.mopp.RbactextContextDependentURIFragmentFactory<org.js.model.rbac.Group, org.js.model.rbac.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGroupMembersReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.GROUP__MEMBERS), resolved, proxy);
						if (proxy != null) {
							Object value = proxy;
							addObjectToList(element, org.js.model.rbac.RbacPackage.GROUP__MEMBERS, value);
							completedElement(value, false);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_6_0_0_9_0_0_0, proxy, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, element);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a6, proxy);
					}
				}
			)
			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[152]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[153]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[154]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[155]);
			}
			
			(
				(
					a7 = ',' {
						if (element == null) {
							element = org.js.model.rbac.RbacFactory.eINSTANCE.createGroup();
							startIncompleteElement(element);
						}
						collectHiddenTokens(element);
						retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_6_0_0_9_0_0_1_0_0_1, null, true);
						copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a7, element);
					}
					{
						// expected elements (follow set)
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[156]);
					}
					
					(
						a8 = TEXT						
						{
							if (terminateParsing) {
								throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
							}
							if (element == null) {
								element = org.js.model.rbac.RbacFactory.eINSTANCE.createGroup();
								startIncompleteElement(element);
							}
							if (a8 != null) {
								org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
								tokenResolver.setOptions(getOptions());
								org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
								tokenResolver.resolve(a8.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.GROUP__MEMBERS), result);
								Object resolvedObject = result.getResolvedToken();
								if (resolvedObject == null) {
									addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a8).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a8).getStopIndex());
								}
								String resolved = (String) resolvedObject;
								org.js.model.rbac.Role proxy = org.js.model.rbac.RbacFactory.eINSTANCE.createRole();
								collectHiddenTokens(element);
								registerContextDependentProxy(new org.js.model.rbac.resource.rbactext.mopp.RbactextContextDependentURIFragmentFactory<org.js.model.rbac.Group, org.js.model.rbac.Role>(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getGroupMembersReferenceResolver()), element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.GROUP__MEMBERS), resolved, proxy);
								if (proxy != null) {
									Object value = proxy;
									addObjectToList(element, org.js.model.rbac.RbacPackage.GROUP__MEMBERS, value);
									completedElement(value, false);
								}
								collectHiddenTokens(element);
								retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_6_0_0_9_0_0_1_0_0_3, proxy, true);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, element);
								copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a8, proxy);
							}
						}
					)
					{
						// expected elements (follow set)
						addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[157]);
						addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[158]);
						addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[159]);
						addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[160]);
					}
					
				)
				
			)*			{
				// expected elements (follow set)
				addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[161]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[162]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[163]);
				addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[164]);
			}
			
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[165]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[166]);
		addExpectedElement(org.js.model.rbac.RbacPackage.eINSTANCE.getAccessControlModel(), org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[167]);
	}
	
;

parse_org_js_model_rbac_Task returns [org.js.model.rbac.Task element = null]
@init{
}
:
	a0 = 'task' {
		if (element == null) {
			element = org.js.model.rbac.RbacFactory.eINSTANCE.createTask();
			startIncompleteElement(element);
		}
		collectHiddenTokens(element);
		retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_7_0_0_0, null, true);
		copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
	}
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[168]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[169]);
	}
	
	(
		(
			a1 = QUOTED_34_34			
			{
				if (terminateParsing) {
					throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
				}
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createTask();
					startIncompleteElement(element);
				}
				if (a1 != null) {
					org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_34_34");
					tokenResolver.setOptions(getOptions());
					org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
					tokenResolver.resolve(a1.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.TASK__NAME), result);
					Object resolvedObject = result.getResolvedToken();
					if (resolvedObject == null) {
						addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a1).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a1).getStopIndex());
					}
					java.lang.String resolved = (java.lang.String) resolvedObject;
					if (resolved != null) {
						Object value = resolved;
						element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.TASK__NAME), value);
						completedElement(value, false);
					}
					collectHiddenTokens(element);
					retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_7_0_0_2, resolved, true);
					copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a1, element);
				}
			}
		)
		
	)?	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[170]);
	}
	
	(
		a2 = QUOTED_60_62		
		{
			if (terminateParsing) {
				throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.rbac.RbacFactory.eINSTANCE.createTask();
				startIncompleteElement(element);
			}
			if (a2 != null) {
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("QUOTED_60_62");
				tokenResolver.setOptions(getOptions());
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a2.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.TASK__ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a2).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a2).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.TASK__ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_7_0_0_4, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a2, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[171]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[172]);
	}
	
;

parse_org_js_model_rbac_VisibilityRestriction returns [org.js.model.rbac.VisibilityRestriction element = null]
@init{
}
:
	(
		(
			a0 = 'modify' {
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createVisibilityRestriction();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_8_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a0, element);
				// set value of enumeration attribute
				Object value = org.js.model.rbac.RbacPackage.eINSTANCE.getModificationType().getEEnumLiteral(org.js.model.rbac.ModificationType.MODIFY_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.VISIBILITY_RESTRICTION__VISIBILITY), value);
				completedElement(value, false);
			}
			|			a1 = 'view' {
				if (element == null) {
					element = org.js.model.rbac.RbacFactory.eINSTANCE.createVisibilityRestriction();
					startIncompleteElement(element);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_8_0_0_0, null, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken)a1, element);
				// set value of enumeration attribute
				Object value = org.js.model.rbac.RbacPackage.eINSTANCE.getModificationType().getEEnumLiteral(org.js.model.rbac.ModificationType.VIEW_VALUE).getInstance();
				element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.VISIBILITY_RESTRICTION__VISIBILITY), value);
				completedElement(value, false);
			}
		)
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[173]);
	}
	
	(
		a4 = TEXT		
		{
			if (terminateParsing) {
				throw new org.js.model.rbac.resource.rbactext.mopp.RbactextTerminateParsingException();
			}
			if (element == null) {
				element = org.js.model.rbac.RbacFactory.eINSTANCE.createVisibilityRestriction();
				startIncompleteElement(element);
			}
			if (a4 != null) {
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver("TEXT");
				tokenResolver.setOptions(getOptions());
				org.js.model.rbac.resource.rbactext.IRbactextTokenResolveResult result = getFreshTokenResolveResult();
				tokenResolver.resolve(a4.getText(), element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.VISIBILITY_RESTRICTION__RESOURCE_ID), result);
				Object resolvedObject = result.getResolvedToken();
				if (resolvedObject == null) {
					addErrorToResource(result.getErrorMessage(), ((org.antlr.runtime3_4_0.CommonToken) a4).getLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getCharPositionInLine(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStartIndex(), ((org.antlr.runtime3_4_0.CommonToken) a4).getStopIndex());
				}
				java.lang.String resolved = (java.lang.String) resolvedObject;
				if (resolved != null) {
					Object value = resolved;
					element.eSet(element.eClass().getEStructuralFeature(org.js.model.rbac.RbacPackage.VISIBILITY_RESTRICTION__RESOURCE_ID), value);
					completedElement(value, false);
				}
				collectHiddenTokens(element);
				retrieveLayoutInformation(element, org.js.model.rbac.resource.rbactext.grammar.RbactextGrammarInformationProvider.RBACTEXT_8_0_0_2, resolved, true);
				copyLocalizationInfos((org.antlr.runtime3_4_0.CommonToken) a4, element);
			}
		}
	)
	{
		// expected elements (follow set)
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[174]);
		addExpectedElement(null, org.js.model.rbac.resource.rbactext.mopp.RbactextExpectationConstants.EXPECTATIONS[175]);
	}
	
;

parse_org_js_model_rbac_Permission returns [org.js.model.rbac.Permission element = null]
:
	c0 = parse_org_js_model_rbac_FeatureOperation{ element = c0; /* this is a subclass or primitive expression choice */ }
	|	c1 = parse_org_js_model_rbac_AttributeOperation{ element = c1; /* this is a subclass or primitive expression choice */ }
	|	c2 = parse_org_js_model_rbac_DomainValueOperation{ element = c2; /* this is a subclass or primitive expression choice */ }
	|	c3 = parse_org_js_model_rbac_VisibilityRestriction{ element = c3; /* this is a subclass or primitive expression choice */ }
	
;

COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))* )
	{ _channel = 99; }
;
TEXT:
	(('A'..'Z'|'a'..'z'|'0'..'9'|'_')+ )
;
LINEBREAK:
	( ('\r\n'|'\r'|'\n')+ )
	{ _channel = 99; }
;
WHITESPACE:
	( (' '|'\t'|'\f')+ )
	{ _channel = 99; }
;
QUOTED_60_62:
	(('<')(~('>'))*('>'))
;
QUOTED_34_34:
	(('"')(~('"'))*('"'))
;

