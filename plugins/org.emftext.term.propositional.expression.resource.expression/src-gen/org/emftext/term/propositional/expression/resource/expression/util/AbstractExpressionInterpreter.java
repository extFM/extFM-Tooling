/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.term.propositional.expression.resource.expression.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractExpressionInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<org.emftext.term.propositional.expression.resource.expression.IExpressionInterpreterListener> listeners = new java.util.ArrayList<org.emftext.term.propositional.expression.resource.expression.IExpressionInterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof org.emftext.term.propositional.expression.And) {
			result = interprete_org_emftext_term_propositional_expression_And((org.emftext.term.propositional.expression.And) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.term.propositional.expression.Or) {
			result = interprete_org_emftext_term_propositional_expression_Or((org.emftext.term.propositional.expression.Or) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.term.propositional.expression.Not) {
			result = interprete_org_emftext_term_propositional_expression_Not((org.emftext.term.propositional.expression.Not) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.term.propositional.expression.FeatureRef) {
			result = interprete_org_emftext_term_propositional_expression_FeatureRef((org.emftext.term.propositional.expression.FeatureRef) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.term.propositional.expression.Nested) {
			result = interprete_org_emftext_term_propositional_expression_Nested((org.emftext.term.propositional.expression.Nested) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.term.propositional.expression.BinaryOperator) {
			result = interprete_org_emftext_term_propositional_expression_BinaryOperator((org.emftext.term.propositional.expression.BinaryOperator) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.term.propositional.expression.UnaryOperator) {
			result = interprete_org_emftext_term_propositional_expression_UnaryOperator((org.emftext.term.propositional.expression.UnaryOperator) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.term.propositional.expression.Term) {
			result = interprete_org_emftext_term_propositional_expression_Term((org.emftext.term.propositional.expression.Term) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.emftext.term.propositional.expression.Constraint) {
			result = interprete_org_emftext_term_propositional_expression_Constraint((org.emftext.term.propositional.expression.Constraint) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_org_emftext_term_propositional_expression_Term(org.emftext.term.propositional.expression.Term term, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_term_propositional_expression_And(org.emftext.term.propositional.expression.And and, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_term_propositional_expression_Or(org.emftext.term.propositional.expression.Or or, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_term_propositional_expression_Not(org.emftext.term.propositional.expression.Not not, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_term_propositional_expression_FeatureRef(org.emftext.term.propositional.expression.FeatureRef featureRef, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_term_propositional_expression_Nested(org.emftext.term.propositional.expression.Nested nested, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_term_propositional_expression_BinaryOperator(org.emftext.term.propositional.expression.BinaryOperator binaryOperator, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_term_propositional_expression_UnaryOperator(org.emftext.term.propositional.expression.UnaryOperator unaryOperator, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_emftext_term_propositional_expression_Constraint(org.emftext.term.propositional.expression.Constraint constraint, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (org.emftext.term.propositional.expression.resource.expression.IExpressionInterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(org.emftext.term.propositional.expression.resource.expression.IExpressionInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(org.emftext.term.propositional.expression.resource.expression.IExpressionInterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
