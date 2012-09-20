package org.js.model.feature.ptnet.m2m.atl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

public class ATLTransform {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String inputMetaModelFileName = "src/main/metamodel/feature.ecore";
		String inputModelFileName = "src/main/model/alternative_fm.feature";
		String outputMetaModelFileName = "src/main/metamodel/ptnetLoLA.ecore";
		String outputModelFileName = "src/main/model/alternative_fm.ptnetlola";
		String asmFileName = "src/main/atl/feature2ptnet.asm";
		try {
			/*
			* Initializations
			*/
			ILauncher transformationLauncher = new EMFVMLauncher();
			ModelFactory modelFactory = new EMFModelFactory();
			IInjector injector = new EMFInjector();
			IExtractor extractor = new EMFExtractor();

			/*
			* Load metamodels
			*/
			IReferenceModel inputMetaModel = modelFactory.newReferenceModel();
			injector.inject(inputMetaModel, inputMetaModelFileName);
			IReferenceModel outputMetaModel = modelFactory.newReferenceModel();
			injector.inject(outputMetaModel, outputMetaModelFileName);

			/*
			* Run "Cut" transformation
			*/
			IModel inputModel = modelFactory.newModel(inputMetaModel);
			injector.inject(inputModel,inputModelFileName);
//
//			transformationLauncher.initialize(new HashMap<String,Object>());
//			transformationLauncher.addInOutModel(featureModel, "IN", "fm");
//			IReferenceModel refiningTraceMetamodel = modelFactory.getBuiltInResource("RefiningTrace.ecore");
//			IModel refiningTraceModel = modelFactory.newModel(refiningTraceMetamodel);
//			transformationLauncher.addOutModel(refiningTraceModel, "refiningTrace", "RefiningTrace");
//			transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), new HashMap<String,Object>(),
//			new FileInputStream("src/main/atl/feature2ptnet.asm"));
//
//			IModel companyModel_Cut = featureModel;
//			String outputFileName = "C:/git/extFM-Tooling/plugins/org.js.model.feature.ptnet.test/src/main/model/alternative_fm.ptnetlola";
//			extractor.extract(companyModel_Cut, outputFileName);

			/*
			* Run "ComputeTotal" transformation
			*/
			IModel outputModel = modelFactory.newModel(outputMetaModel);

			transformationLauncher.initialize(new HashMap<String,Object>());
			transformationLauncher.addInModel(inputModel, "IN", "fm");
			transformationLauncher.addOutModel(outputModel, "OUT", "ptnet");
			transformationLauncher.launch(ILauncher.RUN_MODE, new NullProgressMonitor(), new HashMap<String,Object>(),
			new FileInputStream(asmFileName));
			
			extractor.extract(outputModel, outputModelFileName);

			/*
			* Unload all models and metamodels (EMF-specific)
			*/
			EMFModelFactory emfModelFactory = (EMFModelFactory) modelFactory;
			emfModelFactory.unload((EMFModel) inputModel);
			emfModelFactory.unload((EMFModel) outputModel);
			emfModelFactory.unload((EMFReferenceModel) inputMetaModel);
			emfModelFactory.unload((EMFReferenceModel) outputMetaModel);

			} catch (ATLCoreException e) {
			e.printStackTrace();
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			}
	}

}
