package sedaj;

import hub.top.editor.ptnetLoLA.PNAPI;
import hub.top.editor.ptnetLoLA.PtNet;
import hub.top.editor.ptnetLoLA.impl.PtNetImpl;
import hub.top.petrinet.PetriNet;

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.js.model.feature.FeatureModel;

import sedaj.util.PNUtil;

/**
 * 
 */

/**
 * Creates a {@link PetriNet} from a {@link FeatureModel}
 * 
 * @author Tim Winkelmann
 * 
 */
public class Main {
//	public static EList open(File file) throws IOException {
//		ResourceSet resourceSet = new ResourceSetImpl();
//	 
//		//Set OPTION_RECORD_UNKNOWN_FEATURE prior to calling getResource
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
//			"*", new EcoreResourceFactoryImpl() {
//				@Override
//				public Resource createResource(URI uri) {
//				XMIResourceImpl resource = (XMIResourceImpl) super.createResource(uri);
//				resource.getDefaultLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
//				return resource;
//			}
//		});
//	 
//		XMIResource resource = (XMIResource) resourceSet.getResource(
//		URI.createFileURI(file.toString()),true);
//	 
//		//Unknown elements will appear in this map
//		System.out.println(resource.getEObjectToExtensionMap());
//	 
//		resource.load(Collections.EMPTY_MAP);
//		return resource.getContents();
//	}
	
	
//	/**
//	 * Creates a {@link FeatureModel} with one root {@link Feature}.
//	 * 
//	 * @param name
//	 *            the name of the feature model
//	 * @return a {@link FeatureModel} with one root {@link Feature}
//	 */
//	public static FeatureModel createSimpleFM(String name) {
//		FeatureModel fm = FeatureFactoryImpl.eINSTANCE.createFeatureModel();
//		fm.setName(name);
//		Feature root = FeatureFactoryImpl.eINSTANCE.createFeature();
//		root.setName("root");
//		fm.setRoot(root);
//		root.setSelected(SelectedState.SELECTED);
//		return fm;
//	}
//
//	/**
//	 * Creates a {@link FeatureModel} with a root {@link Feature} and a
//	 * mandatory {@link Feature}.
//	 * 
//	 * @param name
//	 *            the name of the {@link FeatureModel}
//	 * @return a {@link FeatureModel} with two {@link Feature}
//	 */
//	public static FeatureModel createFMwithMandatory(String name) {
//		FeatureModel fm = createSimpleFM(name);
//		Group rootGroup = FeatureFactoryImpl.eINSTANCE.createGroup();
//		rootGroup.setParentFeature(fm.getRoot());
//		rootGroup.setMinCardinality(1);
//		rootGroup.setMaxCardinality(1);
//		Feature child = FeatureFactoryImpl.eINSTANCE.createFeature();
//		child.setName("f1");
//		child.setParentGroup(rootGroup);
//		return fm;
//	}
//
//	/**
//	 * Creates a {@link FeatureModel} with a root {@link Feature} and an
//	 * optional {@link Feature}.
//	 * 
//	 * @param name
//	 *            the name of the {@link FeatureModel}
//	 * @return a {@link FeatureModel} with two {@link Feature}
//	 */
//	public static FeatureModel createFMwithOptional(String name) {
//		FeatureModel fm = createSimpleFM(name);
//		Group rootGroup = FeatureFactoryImpl.eINSTANCE.createGroup();
//		rootGroup.setParentFeature(fm.getRoot());
//		rootGroup.setMinCardinality(0);
//		rootGroup.setMaxCardinality(1);
//		Feature child = FeatureFactoryImpl.eINSTANCE.createFeature();
//		child.setName("f1");
//		child.setParentGroup(rootGroup);
//		return fm;
//	}
//
//	/**
//	 * Creates a {@link FeatureModel} with a root {@link Feature} and a
//	 * alternative {@link Feature} group.
//	 * 
//	 * @param name
//	 *            the name of the {@link FeatureModel}
//	 * @return a {@link FeatureModel} with three {@link Feature}
//	 */
//	public static FeatureModel createFMwithAlternative(String name) {
//		FeatureModel fm = createSimpleFM(name);
//		Group rootGroup = FeatureFactoryImpl.eINSTANCE.createGroup();
//		rootGroup.setParentFeature(fm.getRoot());
//		rootGroup.setMinCardinality(1);
//		rootGroup.setMaxCardinality(1);
//		Feature child = FeatureFactoryImpl.eINSTANCE.createFeature();
//		child.setName("f1");
//		child.setParentGroup(rootGroup);
//		child = FeatureFactoryImpl.eINSTANCE.createFeature();
//		child.setName("f2");
//		child.setParentGroup(rootGroup);
//		return fm;
//	}
//
//	/**
//	 * Creates a {@link FeatureModel} with a root {@link Feature} and a
//	 * inclusive or {@link Feature} group.
//	 * 
//	 * @param name
//	 *            the name of the {@link FeatureModel}
//	 * @return a {@link FeatureModel} with three {@link Feature}
//	 */
//	public static FeatureModel createFMwithInclusiveOr(String name) {
//		FeatureModel fm = createSimpleFM(name);
//		Group rootGroup = FeatureFactoryImpl.eINSTANCE.createGroup();
//		rootGroup.setParentFeature(fm.getRoot());
//		rootGroup.setMinCardinality(1);
//		rootGroup.setMaxCardinality(2);
//		Feature child = FeatureFactoryImpl.eINSTANCE.createFeature();
//		child.setName("f1");
//		child.setParentGroup(rootGroup);
//		child = FeatureFactoryImpl.eINSTANCE.createFeature();
//		child.setName("f2");
//		child.setParentGroup(rootGroup);
//		return fm;
//	}
//
//	/**
//	 * Creates a {@link FeatureModel} with a root {@link Feature} and a
//	 * exclusive or {@link Feature} group.
//	 * 
//	 * @param name
//	 *            the name of the {@link FeatureModel}
//	 * @return a {@link FeatureModel} with three {@link Feature}
//	 */
//	public static FeatureModel createFMwithExclusiveOptional(String name) {
//		FeatureModel fm = createSimpleFM(name);
//		Group rootGroup = FeatureFactoryImpl.eINSTANCE.createGroup();
//		rootGroup.setParentFeature(fm.getRoot());
//		rootGroup.setMinCardinality(0);
//		rootGroup.setMaxCardinality(1);
//		Feature child = FeatureFactoryImpl.eINSTANCE.createFeature();
//		child.setName("f1");
//		child.setParentGroup(rootGroup);
//		child = FeatureFactoryImpl.eINSTANCE.createFeature();
//		child.setName("f2");
//		child.setParentGroup(rootGroup);
//		return fm;
//	}
//
//	public static PetriNet createBasePetriNet(FeatureModel featureModel) {
//		PetriNet net = new PetriNet();
//		Place start = net.addPlace("i");
//		if (featureModel.getRoot() != null) {
//			Transition root = net.addTransition("+"
//					+ featureModel.getRoot().getName());
//			net.addArc(start, root);
//		}
//		Transition end = net.addTransition("end");
//		Place o = net.addPlace("o");
//		net.addArc(end, o);
//		return net;
//	}
//
//	/**
//	 * finds the {@link Transition} by its name-
//	 * 
//	 * @param net
//	 *            the net with the {@link Transition}
//	 * @param t
//	 *            the name of the {@link Transition}
//	 * @return null if no {@link Transition} could be found
//	 */
//	public static Transition findTransition(PetriNet net, String t) {
//		Set<Transition> transitions = net.getTransitions();
//		for (Transition transition : transitions) {
//			if (transition.getName().equals(t)) {
//				return transition;
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * extends the net with sub groups of the root {@link Feature}.
//	 * 
//	 * @param net
//	 *            the {@link PetriNet}
//	 * @param fm
//	 *            the {@link FeatureModel} with its sub groups
//	 * @return
//	 */
//	public static void createOPforRootChildren(PetriNet net, FeatureModel fm) {
//		EList<Group> rootGroups = fm.getRoot().getGroups();
//		for (Group rootGroup : rootGroups) {
//			EList<Feature> features = rootGroup.getChildFeatures();
//			Transition start = findTransition(net, "+" + fm.getRoot().getName());
//			Transition end = findTransition(net, "end");
//			// Alternative
//			if (rootGroup.getMinCardinality() == 1
//					&& rootGroup.getMaxCardinality() == 1
//					&& rootGroup.getChildFeatures().size() == 2) {
//				createPNAlternativeGroup(net, features, start, end);
//			} else if (rootGroup.getMinCardinality() == 1
//					&& rootGroup.getMaxCardinality() == rootGroup
//							.getChildFeatures().size()) { // inclusive or
//				createPNInclusiveOrGroup(net, features, start, end);
//			} else if (rootGroup.getMinCardinality() == 0
//					&& rootGroup.getMaxCardinality() == 1
//					&& rootGroup.getChildFeatures().size() > 1) { // exclusive
//																	// optional
//				createPNExclusiceOptional(net, features, start, end);
//			} else {// Mandatory or Optional
//				for (Feature feature : features) {
//					String fName = feature.getName();
//					Place i = net.addPlace("i " + fName);
//					Place o = net.addPlace("o " + fName);
//					// Mandatory Features
//					if (rootGroup.getMinCardinality() == rootGroup
//							.getMaxCardinality()
//							&& rootGroup.getMinCardinality() == rootGroup
//									.getChildFeatures().size()) {
//						Transition f = net.addTransition("+" + fName);
//						net.addArc(i, f);
//						net.addArc(f, o);
//					} else // Optional
//							// if (rootGroup.getMinCardinality() == 0
//							// && rootGroup.getMaxCardinality() ==
//							// rootGroup.getChildFeatures().size())
//					{
//
//						Transition f = net.addTransition("+" + fName);
//						net.addArc(i, f);
//						net.addArc(f, o);
//						f = net.addTransition("-" + fName);
//						net.addArc(i, f);
//						net.addArc(f, o);
//					}
//
//					// Connection to the net
//					net.addArc(start, i);
//					net.addArc(o, end);
//				}
//			}
//		}
//	}
//
//	/**
//	 * extends the {@link PetriNet} with an alternative group of {@link Feature}
//	 * .
//	 * 
//	 * @param net
//	 *            the {@link PetriNet}
//	 * @param features
//	 *            the list with {@link Feature}
//	 * @param start
//	 *            a start {@link Transition}
//	 * @param end
//	 *            an end {@link Transition}
//	 */
//	private static void createPNAlternativeGroup(PetriNet net,
//			EList<Feature> features, Transition start, Transition end) {
//		List<Place> prePlaces = new LinkedList<Place>();
//		for (Feature feature : features) {
//			for (Feature otherFeature : features) {
//				if (feature != otherFeature) {
//					prePlaces.add(net.addPlace("" + feature.getName() + ":+"
//							+ otherFeature.getName()));
//					prePlaces.add(net.addPlace("" + feature.getName() + ":-"
//							+ otherFeature.getName()));
//				}
//			}
//		}
//		for (Feature feature : features) {
//			Place i = net.addPlace("i " + feature.getName());
//			Place o = net.addPlace("o " + feature.getName());
//
//			Transition f = net.addTransition("+" + feature.getName());
//			net.addArc(i, f);
//			net.addArc(f, o);
//			for (Place place : prePlaces) {
//				if (place.getName().contains("-" + feature.getName())) {
//					net.addArc(place, f);
//				} else if (place.getName().contains(feature.getName() + ":+")) {
//					net.addArc(f, place);
//				}
//			}
//			f = net.addTransition("+" + feature.getName());
//			net.addArc(i, f);
//			net.addArc(f, o);
//			for (Place place : prePlaces) {
//				if (place.getName().contains(feature.getName() + ":-")) {
//					net.addArc(f, place);
//				} else if (place.getName().contains("+" + feature.getName())) {
//					net.addArc(place, f);
//				}
//			}
//			net.addArc(start, i);
//			net.addArc(o, end);
//		}
//	}
//
//	/**
//	 * extends the {@link PetriNet} with an inclusive or group of
//	 * {@link Feature}.
//	 * 
//	 * @param net
//	 *            the {@link PetriNet}
//	 * @param features
//	 *            the list with {@link Feature}
//	 * @param start
//	 *            a start {@link Transition}
//	 * @param end
//	 *            an end {@link Transition}
//	 */
//	private static void createPNInclusiveOrGroup(PetriNet net,
//			EList<Feature> features, Transition start, Transition end) {
//		List<Place> prePlaces = new LinkedList<Place>();
//		for (Feature feature : features) {
//			for (Feature otherFeature : features) {
//				if (feature != otherFeature) {
//					prePlaces.add(net.addPlace("" + feature.getName() + ":+"
//							+ otherFeature.getName()));
//				}
//			}
//		}
//		for (Feature feature : features) {
//			Place i = net.addPlace("i " + feature.getName());
//			Place o = net.addPlace("o " + feature.getName());
//
//			Transition f = net.addTransition("+" + feature.getName());
//			net.addArc(i, f);
//			net.addArc(f, o);
//			for (Place place : prePlaces) {
//				if (place.getName().contains(feature.getName() + ":")) {
//					net.addArc(f, place);
//				}
//			}
//			f = net.addTransition("-" + feature.getName());
//			net.addArc(i, f);
//			net.addArc(f, o);
//			for (Place place : prePlaces) {
//				if (place.getName().contains("+" + feature.getName())) {
//					net.addArc(place, f);
//				}
//			}
//			net.addArc(start, i);
//			net.addArc(o, end);
//		}
//	}
//
//	/**
//	 * extends the {@link PetriNet} with an exclusive optional group of
//	 * {@link Feature}.
//	 * 
//	 * @param net
//	 *            the {@link PetriNet}
//	 * @param features
//	 *            the list with {@link Feature}
//	 * @param start
//	 *            a start {@link Transition}
//	 * @param end
//	 *            an end {@link Transition}
//	 */
//	private static void createPNExclusiceOptional(PetriNet net,
//			EList<Feature> features, Transition start, Transition end) {
//		List<Place> prePlaces = new LinkedList<Place>();
//		for (Feature feature : features) {
//			for (Feature otherFeature : features) {
//				if (feature != otherFeature) {
//					prePlaces.add(net.addPlace("" + feature.getName() + ":-"
//							+ otherFeature.getName()));
//				}
//			}
//		}
//		for (Feature feature : features) {
//			Place i = net.addPlace("i " + feature.getName());
//			Place o = net.addPlace("o " + feature.getName());
//
//			Transition f = net.addTransition("+" + feature.getName());
//			net.addArc(i, f);
//			net.addArc(f, o);
//			for (Place place : prePlaces) {
//				if (place.getName().contains("-" + feature.getName())) {
//					net.addArc(place, f);
//				}
//			}
//			f = net.addTransition("-" + feature.getName());
//			net.addArc(i, f);
//			net.addArc(f, o);
//			for (Place place : prePlaces) {
//				if (place.getName().contains(feature.getName() + ":")) {
//					net.addArc(f, place);
//				}
//			}
//			net.addArc(start, i);
//			net.addArc(o, end);
//		}
//	}

	/**
	 * save the feature model in the file system.
	 * 
	 * @param model
	 * @param fileName
	 */
	public static void persistModel(EObject model, String fileName) {
		ResourceSet set = new ResourceSetImpl();
		URI modelURI = URI.createFileURI(fileName);
		Resource modelResource = set.createResource(modelURI);
		modelResource.getContents().add(model);
		try {
			modelResource.save(null);
			System.out.println("Model saved to " + fileName);
			refreshModelResource(modelResource);
		} catch (IOException e) {
			System.out.println("Could not save model to path " + fileName);
			System.out.println(e.getMessage());
		}
	}

	/**
	 * refresh the resource file locally in the workspace.
	 * 
	 * @param modelResource
	 */
	public static void refreshModelResource(Resource modelResource) {
		IFile file = getFile(modelResource);
		try {
			if (file != null) {
				file.refreshLocal(IResource.DEPTH_ZERO, null);
			}
		} catch (CoreException e) {
			System.err.println("Could not refresh featuremodel at path " + file.getName());
		}
	}

	/**
	 * get the ifile representation of a resource.
	 * 
	 * @param modelResource
	 * @return
	 */
	public static IFile getFile(Resource modelResource) {
		IFile file = WorkspaceSynchronizer.getFile(modelResource);
		return file;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String filename = "simple_optional_fm.ptnetlola";
		URI uri = URI.createFileURI(filename);
		PtNet net = PNUtil.loadPtNet(uri);
		if (net != null) {
			System.out.println(net);
		}else{
			System.out.println("No PtNet found!");
		}
		String dot = PNAPI.toDot(net);
		System.out.println(dot);
		System.out.println("-----------------------");
		String lola = PNAPI.toLoLA_ident(dot);
		System.out.println(lola);
		persistModel(net, "test.lola");
//		FeatureModel fm = createSimpleFM("OnlyRoot");
//		PetriNet net = createBasePetriNet(fm);
//
//		fm = createFMwithMandatory("Mandatory");
//		net = createBasePetriNet(fm);
//		createOPforRootChildren(net, fm);
////		try {
////			PetriNetIO_Out.writeToFile(net, "netMandatory", PetriNetIO_Out.FORMAT_LOLA, 0);
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//		fm = createFMwithOptional("Optional");
//		net = createBasePetriNet(fm);
//		createOPforRootChildren(net, fm);
////		try {
////			PetriNetIO_Out.writeToFile(net, "netOptional", PetriNetIO_Out.FORMAT_LOLA, 0);
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//		fm = createFMwithAlternative("Alternative");
//		net = createBasePetriNet(fm);
//		createOPforRootChildren(net, fm);
////		try {
////			PetriNetIO_Out.writeToFile(net, "netAlternative", PetriNetIO_Out.FORMAT_LOLA, 0);
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//		fm = createFMwithInclusiveOr("IncOr");
//		net = createBasePetriNet(fm);
//		createOPforRootChildren(net, fm);
////		try {
////			PetriNetIO_Out.writeToFile(net, "netIncOr", PetriNetIO_Out.FORMAT_LOLA, 0);
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//		fm = createFMwithExclusiveOptional("ExOpt");
//		net = createBasePetriNet(fm);
//		createOPforRootChildren(net, fm);
////		try {
////			PetriNetIO_Out.writeToFile(net, "netExOpt", PetriNetIO_Out.FORMAT_LOLA, 0);
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//		
//		String loLA_ident = PetriNet.toLoLA_ident(net.toDot());
//		
//		final PtNet net2 = ModelEditor.getModel(loLA_ident);
//		
//		ConvertFileAction_LOLAtoPT c = new ConvertFileAction_LOLAtoPT();
//		
//		URI modelURI = URI.createFileURI("netExOpt");
//		PtnetLoLAAdapterFactory af = new PtnetLoLAAdapterFactory();
//		TransactionalEditingDomain t = TransactionUtil.getEditingDomain(net2);
//		ConvertFileWizard conFileWizard = c.createConvertFileWizard(modelURI, net2, t);
//		System.out.println();
	}
}
