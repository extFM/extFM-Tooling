package org.js.model.feature.csp;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.js.model.feature.FeatureModel;

public class CSPAnalyzer {

   private static Logger log = Logger.getLogger(CSPAnalyzer.class);

   /**
    * analyzes multiple files and creates statistics for them.
    * 
    * @param files
    */
   public static void analyze(List<IFile> files, boolean persistAllVariants) {
      for (IFile file : files) {
         analyze(file, persistAllVariants);
      }
   }

   /**
    * analyzes multiple files and creates statistics for them.
    * 
    * @param files
    */
   public static void analyze(List<IFile> files, int numberVariants) {
      for (IFile file : files) {
         analyze(file, numberVariants);
      }
   }

   public static void satPerformanceMeasure(IFile file) {
      FeatureModel featureModel = getFeatureModel(file, new ResourceSetImpl());
      if (featureModel != null) {
         FeatureModelAnalyzer analyzer = new FeatureModelAnalyzer(featureModel);
         analyzer.isSatisfiable();
      }
   }

   /**
    * check whether the given file is satisfiable.
    * @param file
    * @return
    */
   public static boolean isSatisfiable(IFile file){
	   boolean isSatisfiable = false;
	   FeatureModelAnalyzer analyzer = getAnalyzer(file);
	      if (analyzer != null) {
	    	isSatisfiable = analyzer.isSatisfiable();
	      }
	   return isSatisfiable;
   }
   
   /**
    * initialize a featuremodel from an Ifile.
    * 
    * @param file
    * @return
    */
   public static FeatureModel getFeatureModel(IFile file, ResourceSet resourceSet) {
      FeatureModel featuremodel = null;
      EObject object = getModel(file, resourceSet);
      if (object instanceof FeatureModel) {
         featuremodel = (FeatureModel) object;
      }
      return featuremodel;
   }

   /**
    * Generic method to load a model from a file.
    * 
    * @param file
    * @return
    */
   public static EObject getModel(IFile file, ResourceSet resourceSet) {
      EObject result = null;
      Resource modelResource = getModelResource(file, resourceSet);
      if (modelResource == null) {
         log.warn("The selected resource is not an EMF model,");
      } else {
         try {
            modelResource.load(Collections.EMPTY_MAP);
         } catch (IOException e) {
            log.debug(e.getMessage());
         }
         if (modelResource.isLoaded()) {
            EList<EObject> contents = modelResource.getContents();
            if (contents != null && !contents.isEmpty()) {
               result = contents.get(0);
            }
         }
      }
      return result;
   }

   /**
    * get the according resource for a file.
    * 
    * @param file
    * @return
    */
   public static Resource getModelResource(IFile file, ResourceSet resourceSet) {
      Resource resource = null;
      if (file != null && file.exists()) {
         String locationUri = file.getLocationURI().normalize().getPath();
         URI uri = URI.createFileURI(locationUri);
         resource = resourceSet.createResource(uri);
      }
      return resource;
   }

   private static FeatureModelAnalyzer getAnalyzer(IFile file) {
      log.info("Analyzing file '" + file.getName() + "'.");
      FeatureModelAnalyzer analyzer = null;
      Assert.isNotNull(file);
      FeatureModel featureModel = getFeatureModel(file, new ResourceSetImpl());
      if (featureModel != null) {
         analyzer = new FeatureModelAnalyzer(featureModel);
      }
      if (analyzer == null) {
         log.info("The file" + file.getName() + " does not represent a feature model");
      }
      return analyzer;
   }

   /**
    * analyze method to create a statistic for the given featuremodel.
    * 
    * @param file
    */
   public static void analyze(FeatureModelAnalyzer analyzer) {
      log.info("--------------------------------------");
      log.info("--------------------------------------");
      if (analyzer != null) {
         log.info("--------------------------------------");
         log.info("Featuremodel " + analyzer.getFeatureModelName());
         log.info("--------------------------------------");
         int numberOfAllFeatures = analyzer.getNumberOfAllFeatures();
         log.info("Number of features             : " + numberOfAllFeatures);

         int numberOfAllAttributes = analyzer.getNumberOfAllAttributes();
         log.info("Number of attributes           : " + numberOfAllAttributes);
         // int numberOfMandatoryFeatures = analyzer.getNumberOfMandatoryFeatures();
         // log.info("Number of mandatory features     : " + numberOfMandatoryFeatures);

         // int numberOfCoreFeature = analyzer.getNumberOfCoreFeatures();
         // String core = analyzer.getCoreFeaturesAsString();
         // log.info("Number of core features          : " + numberOfCoreFeature + " " + core);
         //
         // int numberOfVariableFeature = analyzer.getNumberOfVariableFeatures();
         // log.info("Number of variable features      : " + numberOfVariableFeature);

         int numberOfAllCSPConstraints = analyzer.getNumberOfAllCSPConstraints();
         log.info("Number of cross-tree constraints : " + numberOfAllCSPConstraints);

         int constraintFeatureCoverage = analyzer.getFeatureConstraintCoverage();
         log.info("Constraint feature coverage      : " + constraintFeatureCoverage + "%");

         int constraintAttributeCoverage = analyzer.getAttributeConstraintCoverage();
         log.info("Constraint attribute coverage    : " + constraintAttributeCoverage + "%");

         boolean isConsistent = analyzer.isSatisfiable();
         log.info("Is feature model satisfiable     : " + isConsistent);

         int derivableVariants = analyzer.getNumberOfDerivableVariants();
         log.info("Number of derivable variants     : " + derivableVariants);
      }
   }

   public static void analyze(IFile file, boolean persistAllVariants) {
      FeatureModelAnalyzer analyzer = getAnalyzer(file);
      if (analyzer != null) {
         analyzer.setPersistVariants(persistAllVariants);
         analyze(analyzer);
      }
   }

   public static void analyze(IFile file, int numberOfVariants) {
      FeatureModelAnalyzer analyzer = getAnalyzer(file);
      if (analyzer != null) {
         analyzer.setNumberOfVariantsToDerive(numberOfVariants);
         analyze(analyzer);
      }

   }

}
