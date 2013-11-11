/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.mopp;

public class ExpressionPrinter implements org.emftext.term.propositional.expression.resource.expression.IExpressionTextPrinter {
	
	protected org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolverFactory tokenResolverFactory = new org.emftext.term.propositional.expression.resource.expression.mopp.ExpressionTokenResolverFactory();
	
	protected java.io.OutputStream outputStream;
	
	/**
	 * Holds the resource that is associated with this printer. This may be null if
	 * the printer is used stand alone.
	 */
	private org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource resource;
	
	private java.util.Map<?, ?> options;
	private String encoding = System.getProperty("file.encoding");
	
	public ExpressionPrinter(java.io.OutputStream outputStream, org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource resource) {
		super();
		this.outputStream = outputStream;
		this.resource = resource;
	}
	
	protected int matchCount(java.util.Map<String, Integer> featureCounter, java.util.Collection<String> needed) {
		int pos = 0;
		int neg = 0;
		
		for (String featureName : featureCounter.keySet()) {
			if (needed.contains(featureName)) {
				int value = featureCounter.get(featureName);
				if (value == 0) {
					neg += 1;
				} else {
					pos += 1;
				}
			}
		}
		return neg > 0 ? -neg : pos;
	}
	
	protected void doPrint(org.eclipse.emf.ecore.EObject element, java.io.PrintWriter out, String globaltab) {
		if (element == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write.");
		}
		if (out == null) {
			throw new java.lang.IllegalArgumentException("Nothing to write on.");
		}
		
		if (element instanceof org.emftext.term.propositional.expression.Constraint) {
			print_org_emftext_term_propositional_expression_Constraint((org.emftext.term.propositional.expression.Constraint) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.term.propositional.expression.Or) {
			print_org_emftext_term_propositional_expression_Or((org.emftext.term.propositional.expression.Or) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.term.propositional.expression.And) {
			print_org_emftext_term_propositional_expression_And((org.emftext.term.propositional.expression.And) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.term.propositional.expression.Not) {
			print_org_emftext_term_propositional_expression_Not((org.emftext.term.propositional.expression.Not) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.term.propositional.expression.Nested) {
			print_org_emftext_term_propositional_expression_Nested((org.emftext.term.propositional.expression.Nested) element, globaltab, out);
			return;
		}
		if (element instanceof org.emftext.term.propositional.expression.FeatureRef) {
			print_org_emftext_term_propositional_expression_FeatureRef((org.emftext.term.propositional.expression.FeatureRef) element, globaltab, out);
			return;
		}
		
		addWarningToResource("The printer can not handle " + element.eClass().getName() + " elements", element);
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
	
	public void setOptions(java.util.Map<?,?> options) {
		this.options = options;
	}
	
	public java.util.Map<?,?> getOptions() {
		return options;
	}
	
	public void setEncoding(String encoding) {
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public org.emftext.term.propositional.expression.resource.expression.IExpressionTextResource getResource() {
		return resource;
	}
	
	/**
	 * Calls {@link #doPrint(EObject, PrintWriter, String)} and writes the result to
	 * the underlying output stream.
	 */
	public void print(org.eclipse.emf.ecore.EObject element) throws java.io.IOException {
		java.io.PrintWriter out = new java.io.PrintWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(outputStream), encoding));
		doPrint(element, out, "");
		out.flush();
		out.close();
	}
	
	public void print_org_emftext_term_propositional_expression_Constraint(org.emftext.term.propositional.expression.Constraint element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.CONSTRAINT__TERM));
		printCountingMap.put("term", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("term");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.CONSTRAINT__TERM));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("term", count - 1);
		}
	}
	
	
	public void print_org_emftext_term_propositional_expression_Or(org.emftext.term.propositional.expression.Or element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.OR__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.OR__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.OR__OPERAND1));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("or");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.OR__OPERAND2));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
	}
	
	
	public void print_org_emftext_term_propositional_expression_And(org.emftext.term.propositional.expression.And element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(2);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.AND__OPERAND1));
		printCountingMap.put("operand1", temp == null ? 0 : 1);
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.AND__OPERAND2));
		printCountingMap.put("operand2", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand1");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.AND__OPERAND1));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operand1", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print("and");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand2");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.AND__OPERAND2));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operand2", count - 1);
		}
	}
	
	
	public void print_org_emftext_term_propositional_expression_Not(org.emftext.term.propositional.expression.Not element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.NOT__OPERAND));
		printCountingMap.put("operand", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("not");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.NOT__OPERAND));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operand", count - 1);
		}
	}
	
	
	public void print_org_emftext_term_propositional_expression_Nested(org.emftext.term.propositional.expression.Nested element, String outertab, java.io.PrintWriter out) {
		String localtab = outertab;
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.NESTED__OPERAND));
		printCountingMap.put("operand", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (CsString)
		out.print("(");
		out.print(" ");
		// DEFINITION PART BEGINS (Containment)
		count = printCountingMap.get("operand");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.NESTED__OPERAND));
			if (o != null) {
				doPrint((org.eclipse.emf.ecore.EObject) o, out, localtab);
			}
			printCountingMap.put("operand", count - 1);
		}
		// DEFINITION PART BEGINS (CsString)
		out.print(")");
		out.print(" ");
	}
	
	
	public void print_org_emftext_term_propositional_expression_FeatureRef(org.emftext.term.propositional.expression.FeatureRef element, String outertab, java.io.PrintWriter out) {
		// The printCountingMap contains a mapping from feature names to the number of
		// remaining elements that still need to be printed. The map is initialized with
		// the number of elements stored in each structural feature. For lists this is the
		// list size. For non-multiple features it is either 1 (if the feature is set) or
		// 0 (if the feature is null).
		java.util.Map<String, Integer> printCountingMap = new java.util.LinkedHashMap<String, Integer>(1);
		Object temp;
		temp = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.FEATURE_REF__FEATURE));
		printCountingMap.put("feature", temp == null ? 0 : 1);
		// print collected hidden tokens
		int count;
		// DEFINITION PART BEGINS (PlaceholderUsingDefaultToken)
		count = printCountingMap.get("feature");
		if (count > 0) {
			Object o = element.eGet(element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.FEATURE_REF__FEATURE));
			if (o != null) {
				org.emftext.term.propositional.expression.resource.expression.IExpressionTokenResolver resolver = tokenResolverFactory.createTokenResolver("TEXT");
				resolver.setOptions(getOptions());
				out.print(resolver.deResolve(getReferenceResolverSwitch() == null ? null : getReferenceResolverSwitch().getFeatureRefFeatureReferenceResolver().deResolve((org.js.model.feature.Feature) o, element, (org.eclipse.emf.ecore.EReference) element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.FEATURE_REF__FEATURE)), element.eClass().getEStructuralFeature(org.emftext.term.propositional.expression.TermPackage.FEATURE_REF__FEATURE), element));
				out.print(" ");
			}
			printCountingMap.put("feature", count - 1);
		}
	}
	
	
}
