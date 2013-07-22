package org.js.model.feature.csp;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
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
		FeatureModel featureModel = FeatureModelHelper.getFeatureModel(file,
				new ResourceSetImpl());
		if (featureModel != null) {
			FeatureModelAnalyzer analyzer = new FeatureModelAnalyzer(
					featureModel);
			analyzer.isSatisfiable();
		}
	}

	/**
	 * check whether the given file is satisfiable.
	 * 
	 * @param file
	 * @return
	 */
	public static boolean isSatisfiable(IFile file) {
		boolean isSatisfiable = false;
		FeatureModelAnalyzer analyzer = getAnalyzer(file);
		if (analyzer != null) {
			isSatisfiable = analyzer.isSatisfiable();
		}
		return isSatisfiable;
	}

	private static FeatureModelAnalyzer getAnalyzer(IFile file) {
		log.debug("Analyzer for file '" + file.getName() + "'.");
		FeatureModelAnalyzer analyzer = null;
		Assert.isNotNull(file);
		FeatureModel featureModel = FeatureModelHelper.getFeatureModel(file);
		if (featureModel != null) {
			analyzer = new FeatureModelAnalyzer(featureModel);
		}
		if (analyzer == null) {
			log.info("The file" + file.getName()
					+ " does not represent a feature model");
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
			log.info("Number of attributes           : "
					+ numberOfAllAttributes);
			// int numberOfMandatoryFeatures =
			// analyzer.getNumberOfMandatoryFeatures();
			// log.info("Number of mandatory features     : " +
			// numberOfMandatoryFeatures);

			// int numberOfCoreFeature = analyzer.getNumberOfCoreFeatures();
			// String core = analyzer.getCoreFeaturesAsString();
			// log.info("Number of core features          : " +
			// numberOfCoreFeature + " " + core);
			//
			// int numberOfVariableFeature =
			// analyzer.getNumberOfVariableFeatures();
			// log.info("Number of variable features      : " +
			// numberOfVariableFeature);

			int numberOfAllCSPConstraints = analyzer
					.getNumberOfAllCSPConstraints();
			log.info("Number of cross-tree constraints : "
					+ numberOfAllCSPConstraints);

			int constraintFeatureCoverage = analyzer
					.getFeatureConstraintCoverage();
			log.info("Constraint feature coverage      : "
					+ constraintFeatureCoverage + "%");

			int constraintAttributeCoverage = analyzer
					.getAttributeConstraintCoverage();
			log.info("Constraint attribute coverage    : "
					+ constraintAttributeCoverage + "%");

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
