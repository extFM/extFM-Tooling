package org.feature.model.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.js.model.feature.Feature;
import org.js.model.feature.FeatureModel;
import org.js.model.feature.FeaturePackage;
import org.js.model.feature.edit.FeatureModelHelper;

/**
 * provide some function to load feature model
 * 
 * @author Ingo Reimund
 * 
 */
public class FeatureModelLoader {

	public FeatureModelLoader() {
		PropertyConfigurator.configure("conf/log4j.properties");
		BasicConfigurator.configure();

		// Add XMI factory to registry
		FeaturePackage.eINSTANCE.getName();
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("*", new XMIResourceFactoryImpl());
	}

	/**
	 * load feature model from file
	 * 
	 * @param pathToModel
	 *            path to file
	 * @return feature model
	 */
	public FeatureModel load(String pathToModel) {
		// convert model path to uri
		URI uriToModel = URI.createFileURI(new File(pathToModel).getAbsolutePath());

		// load feature model from uri with a new resource set
		return FeatureModel.class.cast(load(uriToModel, new ResourceSetImpl()));
	}

	/**
	 * load EObject from uri
	 * 
	 * @param uri
	 *            to model
	 * @param resourceSet
	 *            set of resources
	 * @return feature model
	 */
	public static EObject load(URI uri, ResourceSet resourceSet) {
		// Get the resource
		Resource resource = resourceSet.getResource(uri, true);

		// Add adapter for reverse navigation along unidirectional links
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
		if (adapter == null)
			resourceSet.eAdapters().add(new ECrossReferenceAdapter());

		// Return root model element
		return resource.getContents().get(0);
	}

	/**
	 * save an eobject to file
	 * 
	 * @param root
	 *            object to save
	 * @param path
	 *            to file
	 * @throws IOException
	 */
	public void save(EObject root, String path) throws IOException {
		ResourceUtil.persistModel(root, path);
	}

	/**
	 * search a feature with the given name
	 * 
	 * @param model
	 *            model with features
	 * @param featureName
	 *            name of wanted feature
	 * @return wanted feature or null
	 */
	public Feature findFeature(FeatureModel model, String featureName) {
	   FeatureModelHelper helper = new FeatureModelHelper(model);
		for (Feature feature : helper.getAllFeatures()) {
			if (feature.getName().contentEquals(featureName)) {
				return feature;
			}
		}
		return null;
	}
}