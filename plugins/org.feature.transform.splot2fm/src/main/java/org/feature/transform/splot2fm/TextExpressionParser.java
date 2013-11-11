/**
 * 
 */
package org.feature.transform.splot2fm;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.term.propositional.expression.BinaryOperator;
import org.emftext.term.propositional.expression.FeatureRef;
import org.emftext.term.propositional.expression.Nested;
import org.emftext.term.propositional.expression.Not;
import org.emftext.term.propositional.expression.Or;
import org.emftext.term.propositional.expression.Term;
import org.emftext.term.propositional.expression.UnaryOperator;
import org.emftext.term.propositional.expression.resource.expression.util.ExpressionResourceUtil;
import org.feature.model.utilities.FeatureModelInit;
import org.js.model.feature.Constraint;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureFactory;
import org.js.model.feature.FeaturePackage;
import org.js.model.feature.resource.eft.mopp.EftResourceFactory;

/**
 * @author <a href="mailto:info@juliaschroeter.de">Julia Schroeter</a>
 * 
 */
public class TextExpressionParser {

   private static Logger log = Logger.getLogger(TextExpressionParser.class);


   public static Set<Feature> getFeaturesFromTerm(Term term) {
      Set<Feature> constrainedFeatures = new LinkedHashSet<Feature>();
      Set<FeatureRef> references = getFeatureRefsFromTerm(term);
      for (FeatureRef featureRef : references) {
         constrainedFeatures.add(featureRef.getFeature());
      }
      return constrainedFeatures;
   }

   public static Set<FeatureRef> getFeatureRefsFromTerm(Term term) {
      Set<FeatureRef> constrainedFeatures = new LinkedHashSet<FeatureRef>();
      if (term instanceof BinaryOperator) {
         BinaryOperator binTerm = (BinaryOperator) term;
         Term leftTerm = binTerm.getOperand1();
         constrainedFeatures.addAll(getFeatureRefsFromTerm(leftTerm));
         Term rightTerm = binTerm.getOperand2();
         constrainedFeatures.addAll(getFeatureRefsFromTerm(rightTerm));

      } else if (term instanceof UnaryOperator) {
         UnaryOperator unaryTerm = (UnaryOperator) term;
         Term singleTerm = unaryTerm.getOperand();
         constrainedFeatures.addAll(getFeatureRefsFromTerm(singleTerm));
      } else if (term instanceof FeatureRef) {
         FeatureRef featureRefTerm = (FeatureRef) term;
         constrainedFeatures.add(featureRefTerm);
      }
      return constrainedFeatures;
   }

   
   /**
    * parses a String expression and creates a feature constraint.
    * @param expression
    * @param fm
    * @return
    */
   public static Constraint createFeatureConstraint(String expression, URI modelURI) {
      Constraint constraint = null;
      Term term = parseExpression(expression, modelURI);
      constraint = createExcludes(term);
      if (constraint == null) {
         constraint = createRequires(term);
      }
      return constraint;
   }

   
   /**
    * parse a constraint expression and return the term model
    * 
    * @param expression as String
    * @param featuremodelURI an uri to create a temporary file from
    * @return
    */
   private static Term parseExpression(String expression, URI modelURI) {
      Term term = null;
      InputStream inputStream = new ByteArrayInputStream(expression.getBytes());
      ResourceSet resourceSet = new ResourceSetImpl();
     // EPackage.Registry.INSTANCE.put(FeaturePackage.eNS_URI, FeaturePackage.eINSTANCE);
      resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("eft", new EftResourceFactory());
      resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("feature", FeatureFactory.eINSTANCE);
      
      if (inputStream != null) {
         URI uri = modelURI.trimFileExtension().trimFragment();

         String uriString = uri.toString();
         log.debug("FeaturemodelURI: " + uriString);
         uri = URI.createURI(uriString);
         uri = uri.appendFileExtension("_" + inputStream.hashCode());
         uri = uri.appendFileExtension("expression");

         log.debug("Expression resource created for URI " + uri);
         Resource resource = resourceSet.createResource(uri);
         try {
            resource.load(inputStream, Collections.EMPTY_MAP);
            EList<EObject> contents = resource.getContents();
            // an expression must contain only one Term
            if (contents.size() == 1 && contents.get(0) instanceof org.emftext.term.propositional.expression.Constraint) {
               org.emftext.term.propositional.expression.Constraint constraint =
                  (org.emftext.term.propositional.expression.Constraint) contents.get(0);
               term = constraint.getTerm();
            }
            boolean resolved = ExpressionResourceUtil.resolveAll(resource);
            if (resolved) {
               log.debug("All proxies of the expression have been resolved.");
            } else {
               // log.warn("Not all proxies of the expression could be resolved.");
            }

         } catch (IOException e) {
            log.warn("Could not load temporary expression resource '" + uri + "'.");
         }
      }
      return term;
   }

   private static Constraint createRequires(Feature left, Feature right) {
    String id = "c_" + "imply" + left.getId() + "_" + right.getId(); 
    return  FeatureModelInit.createImplyConstraint(left, right, id);
   }

   private static Constraint createExcludes(List<Feature> notFeatures) {
      Constraint createExclude = null;
      if (2 == notFeatures.size()) {
         Feature left = notFeatures.get(0);
         Feature right = notFeatures.get(1);
         String id = "c_" + "exclude" + left.getId() + "_" + right.getId(); 
         createExclude = FeatureModelInit.createExcludeConstraint(left, right, id);
      }
      return createExclude;
   }

   public static Constraint createRequires(Term term) {
      Feature right = null;
      Feature left = null;
      Set<FeatureRef> features = getFeatureRefsFromTerm(term);
      if (features.size() == 2) {
         for (FeatureRef featureRef : features) {
            EObject container = featureRef.eContainer();
            if (container instanceof Nested) {
               container = unnestContainer((Nested) container);
            }
            if (container instanceof Not) {
               left = featureRef.getFeature();
            } else if (container instanceof Or) {
               right = featureRef.getFeature();
            }
         }
      }
      return createRequires(left, right);
   }

   public static Constraint createExcludes(Term term) {
      List<Feature> notFeatures = new ArrayList<Feature>(2);
      Set<FeatureRef> features = getFeatureRefsFromTerm(term);
      if (features.size() == 2) {
         for (FeatureRef featureRef : features) {
            EObject container = featureRef.eContainer();
            if (container instanceof Nested) {
               container = unnestContainer((Nested) container);
            }
            if (container instanceof Not) {
               EObject containerofNot = container.eContainer();
               if (containerofNot instanceof Nested) {
                  containerofNot = unnestContainer((Nested) containerofNot);
               }
               if (containerofNot instanceof Or) {
                  notFeatures.add(featureRef.getFeature());
               }
            }
         }
      }
      return createExcludes(notFeatures);
   }

   private static Term unnestContainer(Nested container) {
      EObject eContainer = container.eContainer();
      if (eContainer instanceof Nested) {
         return unnestContainer((Nested) eContainer);
      }
      Term term = null;
      if (eContainer != null && eContainer instanceof Term) {
         term = (Term) eContainer;
      }
      return term;
   }




}
