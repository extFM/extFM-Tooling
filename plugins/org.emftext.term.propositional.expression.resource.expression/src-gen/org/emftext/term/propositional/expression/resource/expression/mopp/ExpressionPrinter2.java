/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionPrinter2 implements org.emftext.term.propositional.expression.resource.expression.IExpressionTextPrinter {
	
	protected class PrintToken {
		
		private String text;
		private String tokenName;
		private org.eclipse.emf.ecore.EObject container;
		
		public PrintToken(String text, String tokenName, org.eclipse.emf.ecore.EObject container) {
			this.text = text;
			this.tokenName = tokenName;
			this.container = container;
		}
		
		public String getText() {
			return text;
		}
		
		public String getTokenName() {
			return tokenName;
		}
		
		public org.eclipse.emf.ecore.EObject getContainer() {
			return container;
		}
		
		public String toString() {
			return "'" + text + "' [" + tokenName + "]";
		}
		
	}
	
	/**
	 * The PrintCountingMap keeps tracks of the values that must be printed for each
	 * feature of an EObject. It is also used to store the indices of all values that
	 * have been printed. This knowledge is used to avoid printing values twice. We
	 * must store the concrete indices of the printed values instead of basically
	 * counting them, because values may be printed in an order that differs from the
	 * order in which they are stored in the EObject's feature.
	 */
	protected class PrintCountingMap {
		
		private java.util.Map<String, java.util.List<Object>> featureToValuesMap = new java.util.LinkedHashMap<String, java.util.List<Object>>();
		private java.util.Map<String, java.util.Set<Integer>> featureToPrintedIndicesMap = new java.util.LinkedHashMap<String, java.util.Set<Integer>>();
		
		public void setFeatureValues(String featureName, java.util.List<Object> values) {
			featureToValuesMap.put(featureName, values);
			// If the feature does not have values it won't be printed. An entry in
			// 'featureToPrintedIndicesMap' is therefore not needed in this case.
			if (values != null) {
				featureToPrintedIndicesMap.put(featureName, new java.util.LinkedHashSet<Integer>());
			}
		}
		
		public java.util.Set<Integer> getIndicesToPrint(String featureName) {
			return featureToPrintedIndicesMap.get(featureName);
		}
		
		public void addIndexToPrint(String featureName, int index) {
			featureToPrintedIndicesMap.get(featureName).add(index);
		}
		
		public int getCountLeft(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal terminal) {
			org.eclipse.emf.ecore.EStructuralFeature feature = terminal.getFeature();
			String featureName = feature.getName();
			java.util.List<Object> totalValuesToPrint = featureToValuesMap.get(featureName);
			java.util.Set<Integer> printedIndices = featureToPrintedIndicesMap.get(featureName);
			if (totalValuesToPrint == null) {
				return 0;
			}
			if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
				// for attributes we do not need to check the type, since the CS languages does
				// not allow type restrictions for attributes.
				return totalValuesToPrint.size() - printedIndices.size();
			} else if (feature instanceof org.eclipse.emf.ecore.EReference) {
				org.eclipse.emf.ecore.EReference reference = (org.eclipse.emf.ecore.EReference) feature;
				if (!reference.isContainment()) {
					// for non-containment references we also do not need to check the type, since the
					// CS languages does not allow type restrictions for these either.
					return totalValuesToPrint.size() - printedIndices.size();
				}
			}
			// now we're left with containment references for which we check the type of the
			// objects to print
			java.util.List<Class<?>> allowedTypes = getAllowedTypes(terminal);
			java.util.Set<Integer> indicesWithCorrectType = new java.util.LinkedHashSet<Integer>();
			int index = 0;
			for (Object valueToPrint : totalValuesToPrint) {
				for (Class<?> allowedType : allowedTypes) {
					if (allowedType.isInstance(valueToPrint)) {
						indicesWithCorrectType.add(index);
					}
				}
				index++;
			}
			indicesWithCorrectType.removeAll(printedIndices);
			return indicesWithCorrectType.size();
		}
		
		public int getNextIndexToPrint(String featureName) {
			int printedValues = featureToPrintedIndicesMap.get(featureName).size();
			return printedValues;
		}
		
	}
	
	public final static String NEW_LINE = java.lang.System.getProperties().getProperty("line.separator");
	
	private final org.emftext.term.propositional.expression.resource.expression.util.ExpressionEClassUtil eClassUtil = new org.emftext.term.propositional.expression.resource.expression.util.ExpressionEClassUtil();
	
	/**
	 * Holds the resource that is associated with this printer. May be null if the
	 * printer is used stand alone.
	 */
	private org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource resource;
	
	private java.util.Map<?, ?> options;
	private java.io.OutputStream outputStream;
	private String encoding = System.getProperty("file.encoding");
	protected java.util.List<PrintToken> tokenOutputStream;
	private org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolverFactory tokenResolverFactory = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTokenResolverFactory();
	private boolean handleTokenSpaceAutomatically = true;
	private int tokenSpace = 1;
	/**
	 * A flag that indicates whether tokens have already been printed for some object.
	 * The flag is set to false whenever printing of an EObject tree is started. The
	 * status of the flag is used to avoid printing default token space in front of
	 * the root object.
	 */
	private boolean startedPrintingObject = false;
	/**
	 * The number of tab characters that were printed before the current line. This
	 * number is used to calculate the relative indentation when printing contained
	 * objects, because all contained objects must start with this indentation
	 * (tabsBeforeCurrentObject + currentTabs).
	 */
	private int currentTabs;
	/**
	 * The number of tab characters that must be printed before the current object.
	 * This number is used to calculate the indentation of new lines, when line breaks
	 * are printed within one object.
	 */
	private int tabsBeforeCurrentObject;
	/**
	 * This flag is used to indicate whether the number of tabs before the current
	 * object has been set for the current object. The flag is needed, because setting
	 * the number of tabs must be performed when the first token of the contained
	 * element is printed.
	 */
	private boolean startedPrintingContainedObject;
	
	public ExpressionPrinter2(java.io.OutputStream outputStream, org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		tokenOutputStream = new java.util.ArrayList<PrintToken>();
		currentTabs = 0;
		tabsBeforeCurrentObject = 0;
		startedPrintingObject = true;
		startedPrintingContainedObject = false;
		java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement>  formattingElements = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement>();
		doPrint(element, formattingElements);
		// print all remaining formatting elements
		java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations = getCopyOfLayoutInformation(element);
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation eofLayoutInformation = getLayoutInformation(layoutInformations, null, null, null);
		printFormattingElements(element, formattingElements, layoutInformations, eofLayoutInformation);
		java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
		if (handleTokenSpaceAutomatically) {
			printSmart(writer);
		} else {
			printBasic(writer);
		}
		writer.flush();
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> foundFormattingElements) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (outputStream == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.emftext.term.propositional.expression.Constraint) {
			printInternal(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_0, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.term.propositional.expression.Or) {
			printInternal(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_1, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.term.propositional.expression.And) {
			printInternal(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_2, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.term.propositional.expression.Not) {
			printInternal(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_3, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.term.propositional.expression.Nested) {
			printInternal(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_4, foundFormattingElements);
			return;
		}
		if (element instanceof org.emftext.term.propositional.expression.FeatureRef) {
			printInternal(element, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.EXPRESSION_5, foundFormattingElements);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
	}
	
	public void printInternal(org.eclipse.emf.ecore.EObject eObject, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement ruleElement, java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> foundFormattingElements) {
		java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations = getCopyOfLayoutInformation(eObject);
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator decoratorTree = getDecoratorTree(ruleElement);
		decorateTree(decoratorTree, eObject);
		printTree(decoratorTree, eObject, foundFormattingElements, layoutInformations);
	}
	
	/**
	 * creates a tree of decorator objects which reflects the syntax tree that is
	 * attached to the given syntax element
	 */
	public org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator getDecoratorTree(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement syntaxElement) {
		org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement[] children = syntaxElement.getChildren();
		int childCount = children.length;
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator[] childDecorators = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator[childCount];
		for (int i = 0; i < childCount; i++) {
			childDecorators[i] = getDecoratorTree(children[i]);
		}
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator decorator = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator(syntaxElement, childDecorators);
		return decorator;
	}
	
	public void decorateTree(org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject) {
		PrintCountingMap printCountingMap = initializePrintCountingMap(eObject);
		java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator> keywordsToPrint = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator>();
		decorateTreeBasic(decorator, eObject, printCountingMap, keywordsToPrint);
		for (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator keywordToPrint : keywordsToPrint) {
			// for keywords the concrete index does not matter, but we must add one to
			// indicate that the keyword needs to be printed here. Thus, we use 0 as index.
			keywordToPrint.addIndexToPrint(0);
		}
	}
	
	/**
	 * Tries to decorate the decorator with an attribute value, or reference held by
	 * the given EObject. Returns true if an attribute value or reference was found.
	 */
	public boolean decorateTreeBasic(org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, PrintCountingMap printCountingMap, java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator> keywordsToPrint) {
		boolean foundFeatureToPrint = false;
		org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement syntaxElement = decorator.getDecoratedElement();
		org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality = syntaxElement.getCardinality();
		boolean isFirstIteration = true;
		while (true) {
			java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator> subKeywordsToPrint = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator>();
			boolean keepDecorating = false;
			if (syntaxElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword) {
				subKeywordsToPrint.add(decorator);
			} else if (syntaxElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal) {
				org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal terminal = (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal) syntaxElement;
				org.eclipse.emf.ecore.EStructuralFeature feature = terminal.getFeature();
				if (feature == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.ANONYMOUS_FEATURE) {
					return false;
				}
				String featureName = feature.getName();
				int countLeft = printCountingMap.getCountLeft(terminal);
				if (countLeft > terminal.getMandatoryOccurencesAfter()) {
					// normally we print the element at the next index
					int indexToPrint = printCountingMap.getNextIndexToPrint(featureName);
					// But, if there are type restrictions for containments, we must choose an index
					// of an element that fits (i.e., which has the correct type)
					if (terminal instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment) {
						org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment containment = (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment) terminal;
						indexToPrint = findElementWithCorrectType(eObject, feature, printCountingMap.getIndicesToPrint(featureName), containment);
					}
					if (indexToPrint >= 0) {
						decorator.addIndexToPrint(indexToPrint);
						printCountingMap.addIndexToPrint(featureName, indexToPrint);
						keepDecorating = true;
					}
				}
			}
			if (syntaxElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice) {
				// for choices we do print only the choice which does print at least one feature
				org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator childToPrint = null;
				for (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
					// pick first choice as default, will be overridden if a choice that prints a
					// feature is found
					if (childToPrint == null) {
						childToPrint = childDecorator;
					}
					if (doesPrintFeature(childDecorator, eObject, printCountingMap)) {
						childToPrint = childDecorator;
						break;
					}
				}
				keepDecorating |= decorateTreeBasic(childToPrint, eObject, printCountingMap, subKeywordsToPrint);
			} else {
				// for all other syntax element we do print all children
				for (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
					keepDecorating |= decorateTreeBasic(childDecorator, eObject, printCountingMap, subKeywordsToPrint);
				}
			}
			foundFeatureToPrint |= keepDecorating;
			// only print keywords if a feature was printed or the syntax element is mandatory
			if (cardinality == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			} else if (cardinality == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.PLUS) {
				if (isFirstIteration) {
					keywordsToPrint.addAll(subKeywordsToPrint);
				} else {
					if (keepDecorating) {
						keywordsToPrint.addAll(subKeywordsToPrint);
					}
				}
			} else if (keepDecorating && (cardinality == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.STAR || cardinality == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.QUESTIONMARK)) {
				keywordsToPrint.addAll(subKeywordsToPrint);
			}
			if (cardinality == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE || cardinality == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.QUESTIONMARK) {
				break;
			} else if (!keepDecorating) {
				break;
			}
			isFirstIteration = false;
		}
		return foundFeatureToPrint;
	}
	
	private int findElementWithCorrectType(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EStructuralFeature feature, java.util.Set<Integer> indicesToPrint, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment containment) {
		// By default the type restrictions that are defined in the CS definition are
		// considered when printing models. You can change this behavior by setting the
		// 'ignoreTypeRestrictionsForPrinting' option to true.
		boolean ignoreTypeRestrictions = false;
		org.eclipse.emf.ecore.EClass[] allowedTypes = containment.getAllowedTypes();
		Object value = eObject.eGet(feature);
		if (value instanceof java.util.List<?>) {
			java.util.List<?> valueList = (java.util.List<?>) value;
			int listSize = valueList.size();
			for (int index = 0; index < listSize; index++) {
				if (indicesToPrint.contains(index)) {
					continue;
				}
				Object valueAtIndex = valueList.get(index);
				if (eClassUtil.isInstance(valueAtIndex, allowedTypes) || ignoreTypeRestrictions) {
					return index;
				}
			}
		} else {
			if (eClassUtil.isInstance(value, allowedTypes) || ignoreTypeRestrictions) {
				return 0;
			}
		}
		return -1;
	}
	
	/**
	 * Checks whether decorating the given node will use at least one attribute value,
	 * or reference held by eObject. Returns true if a printable attribute value or
	 * reference was found. This method is used to decide which choice to pick, when
	 * multiple choices are available. We pick the choice that prints at least one
	 * attribute or reference.
	 */
	public boolean doesPrintFeature(org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, PrintCountingMap printCountingMap) {
		org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement syntaxElement = decorator.getDecoratedElement();
		if (syntaxElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal) {
			org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal terminal = (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal) syntaxElement;
			org.eclipse.emf.ecore.EStructuralFeature feature = terminal.getFeature();
			if (feature == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionGrammarInformationProvider.ANONYMOUS_FEATURE) {
				return false;
			}
			int countLeft = printCountingMap.getCountLeft(terminal);
			if (countLeft > terminal.getMandatoryOccurencesAfter()) {
				// found a feature to print
				return true;
			}
		}
		for (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
			if (doesPrintFeature(childDecorator, eObject, printCountingMap)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean printTree(org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator decorator, org.eclipse.emf.ecore.EObject eObject, java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> foundFormattingElements, java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations) {
		org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement printElement = decorator.getDecoratedElement();
		org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality cardinality = printElement.getCardinality();
		java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> cloned = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement>();
		cloned.addAll(foundFormattingElements);
		boolean foundSomethingAtAll = false;
		boolean foundSomethingToPrint;
		while (true) {
			foundSomethingToPrint = false;
			Integer indexToPrint = decorator.getNextIndexToPrint();
			if (indexToPrint != null) {
				if (printElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword) {
					printKeyword(eObject, (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword) printElement, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionPlaceholder) {
					org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionPlaceholder placeholder = (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionPlaceholder) printElement;
					printFeature(eObject, placeholder, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment) {
					org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment containment = (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment) printElement;
					printContainedObject(eObject, containment, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionBooleanTerminal) {
					org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionBooleanTerminal booleanTerminal = (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionBooleanTerminal) printElement;
					printBooleanTerminal(eObject, booleanTerminal, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				} else if (printElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionEnumerationTerminal) {
					org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionEnumerationTerminal enumTerminal = (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionEnumerationTerminal) printElement;
					printEnumerationTerminal(eObject, enumTerminal, indexToPrint, foundFormattingElements, layoutInformations);
					foundSomethingToPrint = true;
				}
			}
			if (foundSomethingToPrint) {
				foundSomethingAtAll = true;
			}
			if (printElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionWhiteSpace) {
				foundFormattingElements.add((org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionWhiteSpace) printElement);
			}
			if (printElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionLineBreak) {
				foundFormattingElements.add((org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionLineBreak) printElement);
			}
			for (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionSyntaxElementDecorator childDecorator : decorator.getChildDecorators()) {
				foundSomethingToPrint |= printTree(childDecorator, eObject, foundFormattingElements, layoutInformations);
				org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement decoratedElement = decorator.getDecoratedElement();
				if (foundSomethingToPrint && decoratedElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionChoice) {
					break;
				}
			}
			if (cardinality == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.ONE || cardinality == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.QUESTIONMARK) {
				break;
			} else if (!foundSomethingToPrint) {
				break;
			}
		}
		// only print formatting elements if a feature was printed or the syntax element
		// is mandatory
		if (!foundSomethingAtAll && (cardinality == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.STAR || cardinality == org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionCardinality.QUESTIONMARK)) {
			foundFormattingElements.clear();
			foundFormattingElements.addAll(cloned);
		}
		return foundSomethingToPrint;
	}
	
	public void printKeyword(org.eclipse.emf.ecore.EObject eObject, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionKeyword keyword, java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> foundFormattingElements, java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations) {
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation keywordLayout = getLayoutInformation(layoutInformations, keyword, null, eObject);
		printFormattingElements(eObject, foundFormattingElements, layoutInformations, keywordLayout);
		String value = keyword.getValue();
		tokenOutputStream.add(new PrintToken(value, "'" + org.emftext.term.propositional.expression.resource.expression.util.ExpressionStringUtil.escapeToANTLRKeyword(value) + "'", eObject));
	}
	
	public void printFeature(org.eclipse.emf.ecore.EObject eObject, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionPlaceholder placeholder, int count, java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> foundFormattingElements, java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature feature = placeholder.getFeature();
		if (feature instanceof org.eclipse.emf.ecore.EAttribute) {
			printAttribute(eObject, (org.eclipse.emf.ecore.EAttribute) feature, placeholder, count, foundFormattingElements, layoutInformations);
		} else {
			printReference(eObject, (org.eclipse.emf.ecore.EReference) feature, placeholder, count, foundFormattingElements, layoutInformations);
		}
	}
	
	public void printAttribute(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EAttribute attribute, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionPlaceholder placeholder, int index, java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> foundFormattingElements, java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations) {
		String result = null;
		Object attributeValue = org.emftext.term.propositional.expression.resource.expression.util.ExpressionEObjectUtil.getFeatureValue(eObject, attribute, index);
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation attributeLayout = getLayoutInformation(layoutInformations, placeholder, attributeValue, eObject);
		String visibleTokenText = getVisibleTokenText(attributeLayout);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		}
		
		if (result == null) {
			// if no text is available, the attribute is deresolved to obtain its textual
			// representation
			org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(placeholder.getTokenName());
			tokenResolver.setOptions(getOptions());
			String deResolvedValue = tokenResolver.deResolve(attributeValue, attribute, eObject);
			result = deResolvedValue;
		}
		
		if (result != null && !"".equals(result)) {
			printFormattingElements(eObject, foundFormattingElements, layoutInformations, attributeLayout);
			// write result to the output stream
			tokenOutputStream.add(new PrintToken(result, placeholder.getTokenName(), eObject));
		}
	}
	
	
	public void printBooleanTerminal(org.eclipse.emf.ecore.EObject eObject, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionBooleanTerminal booleanTerminal, int index, java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> foundFormattingElements, java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EAttribute attribute = booleanTerminal.getAttribute();
		String result = null;
		Object attributeValue = org.emftext.term.propositional.expression.resource.expression.util.ExpressionEObjectUtil.getFeatureValue(eObject, attribute, index);
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation attributeLayout = getLayoutInformation(layoutInformations, booleanTerminal, attributeValue, eObject);
		String visibleTokenText = getVisibleTokenText(attributeLayout);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		}
		
		if (result == null) {
			// if no text is available, the boolean attribute is converted to its textual
			// representation using the literals of the boolean terminal
			if (Boolean.TRUE.equals(attributeValue)) {
				result = booleanTerminal.getTrueLiteral();
			} else {
				result = booleanTerminal.getFalseLiteral();
			}
		}
		
		if (result != null && !"".equals(result)) {
			printFormattingElements(eObject, foundFormattingElements, layoutInformations, attributeLayout);
			// write result to the output stream
			tokenOutputStream.add(new PrintToken(result, "'" + org.emftext.term.propositional.expression.resource.expression.util.ExpressionStringUtil.escapeToANTLRKeyword(result) + "'", eObject));
		}
	}
	
	
	public void printEnumerationTerminal(org.eclipse.emf.ecore.EObject eObject, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionEnumerationTerminal enumTerminal, int index, java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> foundFormattingElements, java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EAttribute attribute = enumTerminal.getAttribute();
		String result = null;
		Object attributeValue = org.emftext.term.propositional.expression.resource.expression.util.ExpressionEObjectUtil.getFeatureValue(eObject, attribute, index);
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation attributeLayout = getLayoutInformation(layoutInformations, enumTerminal, attributeValue, eObject);
		String visibleTokenText = getVisibleTokenText(attributeLayout);
		// if there is text for the attribute we use it
		if (visibleTokenText != null) {
			result = visibleTokenText;
		}
		
		if (result == null) {
			// if no text is available, the enumeration attribute is converted to its textual
			// representation using the literals of the enumeration terminal
			assert attributeValue instanceof org.eclipse.emf.common.util.Enumerator;
			result = enumTerminal.getText(((org.eclipse.emf.common.util.Enumerator) attributeValue).getName());
		}
		
		if (result != null && !"".equals(result)) {
			printFormattingElements(eObject, foundFormattingElements, layoutInformations, attributeLayout);
			// write result to the output stream
			tokenOutputStream.add(new PrintToken(result, "'" + org.emftext.term.propositional.expression.resource.expression.util.ExpressionStringUtil.escapeToANTLRKeyword(result) + "'", eObject));
		}
	}
	
	
	public void printContainedObject(org.eclipse.emf.ecore.EObject eObject, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment containment, int index, java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> foundFormattingElements, java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations) {
		org.eclipse.emf.ecore.EStructuralFeature reference = containment.getFeature();
		Object o = org.emftext.term.propositional.expression.resource.expression.util.ExpressionEObjectUtil.getFeatureValue(eObject, reference, index);
		// save current number of tabs to restore them after printing the contained object
		int oldTabsBeforeCurrentObject = tabsBeforeCurrentObject;
		int oldCurrentTabs = currentTabs;
		// use current number of tabs to indent contained object. we do not directly set
		// 'tabsBeforeCurrentObject' because the first element of the new object must be
		// printed with the old number of tabs.
		startedPrintingContainedObject = false;
		currentTabs = 0;
		doPrint((org.eclipse.emf.ecore.EObject) o, foundFormattingElements);
		// restore number of tabs after printing the contained object
		tabsBeforeCurrentObject = oldTabsBeforeCurrentObject;
		currentTabs = oldCurrentTabs;
	}
	
	public void printFormattingElements(org.eclipse.emf.ecore.EObject eObject, java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> foundFormattingElements, java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations, org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation layoutInformation) {
		String hiddenTokenText = getHiddenTokenText(layoutInformation);
		if (hiddenTokenText != null) {
			// removed used information
			if (layoutInformations != null) {
				layoutInformations.remove(layoutInformation);
			}
			tokenOutputStream.add(new PrintToken(hiddenTokenText, null, eObject));
			foundFormattingElements.clear();
			startedPrintingObject = false;
			setTabsBeforeCurrentObject(0);
			return;
		}
		int printedTabs = 0;
		if (foundFormattingElements.size() > 0) {
			for (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement foundFormattingElement : foundFormattingElements) {
				if (foundFormattingElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionWhiteSpace) {
					int amount = ((org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionWhiteSpace) foundFormattingElement).getAmount();
					for (int i = 0; i < amount; i++) {
						tokenOutputStream.add(createSpaceToken(eObject));
					}
				}
				if (foundFormattingElement instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionLineBreak) {
					currentTabs = ((org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionLineBreak) foundFormattingElement).getTabs();
					printedTabs += currentTabs;
					tokenOutputStream.add(createNewLineToken(eObject));
					for (int i = 0; i < tabsBeforeCurrentObject + currentTabs; i++) {
						tokenOutputStream.add(createTabToken(eObject));
					}
				}
			}
			foundFormattingElements.clear();
			startedPrintingObject = false;
		} else {
			if (startedPrintingObject) {
				// if no elements have been printed yet, we do not add the default token space,
				// because spaces before the first element are not desired.
				startedPrintingObject = false;
			} else {
				if (!handleTokenSpaceAutomatically) {
					tokenOutputStream.add(new PrintToken(getWhiteSpaceString(tokenSpace), null, eObject));
				}
			}
		}
		// after printing the first element, we can use the new number of tabs.
		setTabsBeforeCurrentObject(printedTabs);
	}
	
	private void setTabsBeforeCurrentObject(int tabs) {
		if (startedPrintingContainedObject) {
			return;
		}
		tabsBeforeCurrentObject = tabsBeforeCurrentObject + tabs;
		startedPrintingContainedObject = true;
	}
	
	@SuppressWarnings("unchecked")	
	public void printReference(org.eclipse.emf.ecore.EObject eObject, org.eclipse.emf.ecore.EReference reference, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionPlaceholder placeholder, int index, java.util.List<org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionFormattingElement> foundFormattingElements, java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations) {
		String tokenName = placeholder.getTokenName();
		Object referencedObject = org.emftext.term.propositional.expression.resource.expression.util.ExpressionEObjectUtil.getFeatureValue(eObject, reference, index, false);
		// first add layout before the reference
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation referenceLayout = getLayoutInformation(layoutInformations, placeholder, referencedObject, eObject);
		printFormattingElements(eObject, foundFormattingElements, layoutInformations, referenceLayout);
		// proxy objects must be printed differently
		String deresolvedReference = null;
		if (referencedObject instanceof org.eclipse.emf.ecore.EObject) {
			org.eclipse.emf.ecore.EObject eObjectToDeResolve = (org.eclipse.emf.ecore.EObject) referencedObject;
			if (eObjectToDeResolve.eIsProxy()) {
				deresolvedReference = ((org.eclipse.emf.ecore.InternalEObject) eObjectToDeResolve).eProxyURI().fragment();
				// If the proxy was created by EMFText, we can try to recover the identifier from
				// the proxy URI
				if (deresolvedReference != null && deresolvedReference.startsWith(org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX)) {
					deresolvedReference = deresolvedReference.substring(org.emftext.term.propositional.expression.resource.expression.IExpressionContextDependentURIFragment.INTERNAL_URI_FRAGMENT_PREFIX.length());
					deresolvedReference = deresolvedReference.substring(deresolvedReference.indexOf("_") + 1);
				}
			}
		}
		if (deresolvedReference == null) {
			// NC-References must always be printed by deresolving the reference. We cannot
			// use the visible token information, because deresolving usually depends on
			// attribute values of the referenced object instead of the object itself.
			@SuppressWarnings("rawtypes")			
			org.emftext.term.propositional.expression.resource.expression.IExpressionReferenceResolver referenceResolver = getReferenceResolverSwitch().getResolver(reference);
			referenceResolver.setOptions(getOptions());
			deresolvedReference = referenceResolver.deResolve((org.eclipse.emf.ecore.EObject) referencedObject, eObject, reference);
		}
		org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver tokenResolver = tokenResolverFactory.createTokenResolver(tokenName);
		tokenResolver.setOptions(getOptions());
		String deresolvedToken = tokenResolver.deResolve(deresolvedReference, reference, eObject);
		// write result to output stream
		tokenOutputStream.add(new PrintToken(deresolvedToken, tokenName, eObject));
	}
	
	@SuppressWarnings("unchecked")	
	public PrintCountingMap initializePrintCountingMap(org.eclipse.emf.ecore.EObject eObject) {
		// The PrintCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		PrintCountingMap printCountingMap = new PrintCountingMap();
		java.util.List<org.eclipse.emf.ecore.EStructuralFeature> features = eObject.eClass().getEAllStructuralFeatures();
		for (org.eclipse.emf.ecore.EStructuralFeature feature : features) {
			// We get the feature value without resolving it, because resolving is not
			// required to count the number of elements that are referenced by the feature.
			// Moreover, triggering reference resolving is not desired here, because we'd also
			// like to print models that contain unresolved references.
			Object featureValue = eObject.eGet(feature, false);
			if (featureValue != null) {
				if (featureValue instanceof java.util.List<?>) {
					printCountingMap.setFeatureValues(feature.getName(), (java.util.List<Object>) featureValue);
				} else {
					printCountingMap.setFeatureValues(feature.getName(), java.util.Collections.singletonList(featureValue));
				}
			} else {
				printCountingMap.setFeatureValues(feature.getName(), null);
			}
		}
		return printCountingMap;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource getResource() {
		return resource;
	}
	
	protected org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionReferenceResolverSwitch getReferenceResolverSwitch() {
		return (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionReferenceResolverSwitch) new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMetaInformation().getReferenceResolverSwitch();
	}
	
	protected void addWarningToResource(final String errorMessage, org.eclipse.emf.ecore.EObject cause) {
		org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource resource = getResource();
		if (resource == null) {
			// the resource can be null if the printer is used stand alone
			return;
		}
		resource.addProblem(new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionProblem(errorMessage, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemType.PRINT_PROBLEM, org.emftext.term.propositional.expression.resource.expression.ExpressionEProblemSeverity.WARNING), cause);
	}
	
	protected org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformationAdapter getLayoutInformationAdapter(org.eclipse.emf.ecore.EObject element) {
		for (org.eclipse.emf.common.notify.Adapter adapter : element.eAdapters()) {
			if (adapter instanceof org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformationAdapter) {
				return (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformationAdapter) adapter;
			}
		}
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformationAdapter newAdapter = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformationAdapter();
		element.eAdapters().add(newAdapter);
		return newAdapter;
	}
	
	private org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation getLayoutInformation(java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations, org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionSyntaxElement syntaxElement, Object object, org.eclipse.emf.ecore.EObject container) {
		for (org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation layoutInformation : layoutInformations) {
			if (syntaxElement == layoutInformation.getSyntaxElement()) {
				if (object == null) {
					return layoutInformation;
				}
				// The layout information adapter must only try to resolve the object it refers
				// to, if we compare with a non-proxy object. If we're printing a resource that
				// contains proxy objects, resolving must not be triggered.
				boolean isNoProxy = true;
				if (object instanceof org.eclipse.emf.ecore.EObject) {
					org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) object;
					isNoProxy = !eObject.eIsProxy();
				}
				if (isSame(object, layoutInformation.getObject(container, isNoProxy))) {
					return layoutInformation;
				}
			}
		}
		return null;
	}
	
	public java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> getCopyOfLayoutInformation(org.eclipse.emf.ecore.EObject eObject) {
		org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformationAdapter layoutInformationAdapter = getLayoutInformationAdapter(eObject);
		java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> originalLayoutInformations = layoutInformationAdapter.getLayoutInformations();
		// create a copy of the original list of layout information object in order to be
		// able to remove used informations during printing
		java.util.List<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation> layoutInformations = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation>(originalLayoutInformations.size());
		layoutInformations.addAll(originalLayoutInformations);
		return layoutInformations;
	}
	
	private String getHiddenTokenText(org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getHiddenTokenText();
		} else {
			return null;
		}
	}
	
	private String getVisibleTokenText(org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionLayoutInformation layoutInformation) {
		if (layoutInformation != null) {
			return layoutInformation.getVisibleTokenText();
		} else {
			return null;
		}
	}
	
	protected String getWhiteSpaceString(int count) {
		return getRepeatingString(count, ' ');
	}
	
	private String getRepeatingString(int count, char character) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < count; i++) {
			result.append(character);
		}
		return result.toString();
	}
	
	public void setHandleTokenSpaceAutomatically(boolean handleTokenSpaceAutomatically) {
		this.handleTokenSpaceAutomatically = handleTokenSpaceAutomatically;
	}
	
	public void setTokenSpace(int tokenSpace) {
		this.tokenSpace = tokenSpace;
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer (as it is).
	 */
	public void printBasic(java.io.PrintWriter writer) throws java.io.IOException {
		for (PrintToken nextToken : tokenOutputStream) {
			writer.write(nextToken.getText());
		}
	}
	
	/**
	 * Prints the current tokenOutputStream to the given writer.
	 * 
	 * This methods implements smart whitespace printing. It does so by writing output
	 * to a token stream instead of printing the raw token text to a PrintWriter.
	 * Tokens in this stream hold both the text and the type of the token (i.e., its
	 * name).
	 * 
	 * To decide where whitespace is needed, sequences of successive tokens are
	 * searched that can be printed without separating whitespace. To determine such
	 * groups we start with two successive non-whitespace tokens, concatenate their
	 * text and use the generated ANTLR lexer to split the text. If the resulting
	 * token sequence of the concatenated text is exactly the same as the one that is
	 * to be printed, no whitespace is needed. The tokens in the sequence are checked
	 * both regarding their type and their text. If two tokens successfully form a
	 * group a third one is added and so on.
	 */
	public void printSmart(java.io.PrintWriter writer) throws java.io.IOException {
		// stores the text of the current group of tokens. this text is given to the lexer
		// to check whether it can be correctly scanned.
		StringBuilder currentBlock = new StringBuilder();
		// stores the index of the first token of the current group.
		int currentBlockStart = 0;
		// stores the text that was already successfully checked (i.e., is can be scanned
		// correctly and can thus be printed).
		String validBlock = "";
		char lastCharWritten = ' ';
		for (int i = 0; i < tokenOutputStream.size(); i++) {
			PrintToken tokenI = tokenOutputStream.get(i);
			currentBlock.append(tokenI.getText());
			// if declared or preserved whitespace is found - print block
			if (tokenI.getTokenName() == null) {
				char[] charArray = currentBlock.toString().toCharArray();
				writer.write(charArray);
				if (charArray.length > 0) {
					lastCharWritten = charArray[charArray.length - 1];
				}
				// reset all values
				currentBlock = new StringBuilder();
				currentBlockStart = i + 1;
				validBlock = "";
				continue;
			}
			// now check whether the current block can be scanned
			org.emftext.term.propositional.expression.resource.expression.IExpressionTextScanner scanner = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionMetaInformation().createLexer();
			scanner.setText(currentBlock.toString());
			// retrieve all tokens from scanner and add them to list 'tempTokens'
			java.util.List<org.emftext.term.propositional.expression.resource.expression.IExpressionTextToken> tempTokens = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.IExpressionTextToken>();
			org.emftext.term.propositional.expression.resource.expression.IExpressionTextToken nextToken = scanner.getNextToken();
			while (nextToken != null && nextToken.getText() != null) {
				tempTokens.add(nextToken);
				nextToken = scanner.getNextToken();
			}
			boolean sequenceIsValid = true;
			// check whether the current block was scanned to the same token sequence
			for (int t = 0; t < tempTokens.size(); t++) {
				PrintToken printTokenT = tokenOutputStream.get(currentBlockStart + t);
				org.emftext.term.propositional.expression.resource.expression.IExpressionTextToken tempToken = tempTokens.get(t);
				if (!tempToken.getText().equals(printTokenT.getText())) {
					sequenceIsValid = false;
					break;
				}
				String commonTokenName = tempToken.getName();
				String printTokenName = printTokenT.getTokenName();
				if (printTokenName.length() > 2 && printTokenName.startsWith("'") && printTokenName.endsWith("'")) {
					printTokenName = printTokenName.substring(1, printTokenName.length() - 1);
				}
				if (!commonTokenName.equals(printTokenName)) {
					sequenceIsValid = false;
					break;
				}
			}
			if (sequenceIsValid) {
				// sequence is still valid, try adding one more token in the next iteration of the
				// loop
				validBlock += tokenI.getText();
			} else {
				// sequence is not valid, must print whitespace to separate tokens
				// print text that is valid so far
				char[] charArray = validBlock.toString().toCharArray();
				writer.write(charArray);
				if (charArray.length > 0) {
					lastCharWritten = charArray[charArray.length - 1];
				}
				// print separating whitespace
				// if no whitespace (or tab or linebreak) is already there
				if (lastCharWritten != ' ' && lastCharWritten != '\t' && lastCharWritten != '\n' && lastCharWritten != '\r') {
					lastCharWritten = ' ';
					writer.write(lastCharWritten);
				}
				// add current token as initial value for next iteration
				currentBlock = new StringBuilder(tokenI.getText());
				currentBlockStart = i;
				validBlock = tokenI.getText();
			}
		}
		// flush remaining valid text to writer
		writer.write(validBlock);
	}
	
	private boolean isSame(Object o1, Object o2) {
		if (o1 instanceof String || o1 instanceof Integer || o1 instanceof Long || o1 instanceof Byte || o1 instanceof Short || o1 instanceof Float || o2 instanceof Double) {
			return o1.equals(o2);
		}
		return o1 == o2;
	}
	
	protected java.util.List<Class<?>> getAllowedTypes(org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionTerminal terminal) {
		java.util.List<Class<?>> allowedTypes = new java.util.ArrayList<Class<?>>();
		allowedTypes.add(terminal.getFeature().getEType().getInstanceClass());
		if (terminal instanceof org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment) {
			org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment printingContainment = (org.emftext.term.propositional.expression.resource.expression.grammar.ExpressionContainment) terminal;
			org.eclipse.emf.ecore.EClass[] typeRestrictions = printingContainment.getAllowedTypes();
			if (typeRestrictions != null && typeRestrictions.length > 0) {
				allowedTypes.clear();
				for (org.eclipse.emf.ecore.EClass eClass : typeRestrictions) {
					allowedTypes.add(eClass.getInstanceClass());
				}
			}
		}
		return allowedTypes;
	}
	
	protected PrintToken createSpaceToken(org.eclipse.emf.ecore.EObject container) {
		return new PrintToken(" ", null, container);
	}
	
	protected PrintToken createTabToken(org.eclipse.emf.ecore.EObject container) {
		return new PrintToken("\t", null, container);
	}
	
	protected PrintToken createNewLineToken(org.eclipse.emf.ecore.EObject container) {
		return new PrintToken(NEW_LINE, null, container);
	}
	
}
