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
		
//		String filename = "simple_optional_fm.ptnetlola";
//		URI uri = URI.createFileURI(filename);
//		PtNet net = PNUtil.loadPtNet(uri);
//		if (net != null) {
//			System.out.println(net);
//		}else{
//			System.out.println("No PtNet found!");
//		}
//		String dot = PNAPI.toDot(net);
//		System.out.println(dot);
//		System.out.println("-----------------------");
//		String lola = PNAPI.toLoLA_ident(dot);
//		System.out.println(lola);
//		persistModel(net, "test.ptnet");
		permut();
//		for (int i = 1; i < 10; i++) {
//			System.out.println(calcPossibilities(10, i));
//		}
		
		
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

	private static void permut() {
		int min = 2,
			max = 3,
			size = 5,
			count = 0;
		int [] f = new int[size];
		for (int i = 0; i < f.length; i++) {
			f[i] = i;
		}
//		int [] permut1 = new int[min];
//		for (int i = 0; i < size; i++) {
//			for (int j = i+1; j < size; j++) {
//				permut1[0] = f[i];
//				permut1[1] = f[j];
//				System.out.print(count++ + ":");
//				print(permut1);
//			}
//		}
//		int [] permut2 = new int[max];
//		int [] indi = new int[max];
//		for (indi[0] = 0; indi[0] < size; indi[0]++) {
//			for (indi[1] = indi[0]+1; indi[1] < size; indi[1]++) {
//				for (indi[2] = indi[1]+1; indi[2] < size; indi[2]++) {
//					permut2[0] = f[indi[0]];
//					permut2[1] = f[indi[1]];
//					permut2[2] = f[indi[2]];
//					System.out.print(count++ + ":");
//					print(permut2);
//				}
//			}
//		}
		int[][][] x = new int[(max-min) + 1][][];
		for (int i = min; i <= max; i++) {
			x[i-min] = new int[calcPossibilities(size,i)][i];
		}
		p (f,x);
		print(x);
	}
	
	private static void print(int[][][] x) {
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				System.out.print("[");
				for (int k = 0; k < x[i][j].length; k++) {
					System.out.print(x[i][j][k]);
					if (k+1 < x[i][j].length) {
						System.out.print(",");
					}
				}
				System.out.println("]");
			}
		}
		
	}

	private static int calcPossibilities(int size, int i) {
		int result = size;
		for (int j = 1; j < i; j++) {
			result *= size - j;
		}
		int teiler = i;
		for (int j = 1; j < i; j++) {
			teiler *= i - j;
		}
		return result/teiler;
	}

	private static int j = 0;
	private static void p (int[] a, int[][][] x){
		for (int i = 0; i < x.length; i++) {
			int[] indizies = new int[x[i][0].length];
			j=0;
			f(x,a,i,0,indizies);
		}
	}
	
	private static void f(int[][][] x,int[] a, int i, int k,int[] indi) {
		if (k == 0) {
			for (indi[k] = 0; indi[k] < a.length; indi[k]++) {
				if (k+1 == indi.length) {
					x[i][j][k] = a[indi[k]];
					j++;
				}else {
					f(x, a, i, k+1, indi);
				}
			}
		}else{
			for (indi[k] = indi[k-1]+1; indi[k] < a.length; indi[k]++) {
				if (k+1 == indi.length) {
					for (int l = 0; l <= k; l++) {
						x[i][j][l] = a[indi[l]];
					}
					j++;
				}else {
					f(x, a, i, k+1, indi);
				}
			}
		}
	}
}
