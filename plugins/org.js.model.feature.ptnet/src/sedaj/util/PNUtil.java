/**
 * 
 */
package sedaj.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import hub.top.editor.ptnetLoLA.PtNet;
import hub.top.editor.ptnetLoLA.Transition;

/**
 * Utility class for a {@link PtNet}
 * @author Tim Winkelmann
 *
 */
public class PNUtil {
	
	/**
	 * Creates a  {@link PtNet} from a {@link URI}.
	 * If the {@link URI} contains a {@link PtNet} it returns it
	 * @param uri can be a file
	 * @return a {@link PtNet} if the {@link URI} contains one.
	 */
	public static PtNet loadPtNet(URI uri){
		//load target meta model
		hub.top.editor.ptnetLoLA.PtnetLoLAPackage pck = hub.top.editor.ptnetLoLA.PtnetLoLAPackage.eINSTANCE;
		System.out.println(pck.getNsURI());
		// Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();
	    
	    resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
	    		Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
	    // Get the resource
	    Resource resource = resSet.getResource(uri, true);
	    // Get the first model element and cast it to the right type, in my
	    // example everything is hierarchical included in this first node
	    EList<EObject> contents = resource.getContents();
	    for (EObject eObject : contents) {
			if (eObject instanceof PtNet) {
				PtNet net = (PtNet) eObject;
				return net;
			}
		}
	    return null;
	}
	
	/**
	 * finds the {@link Transition} by its name.
	 * @param net the net with the {@link Transition}
	 * @param t the name of the {@link Transition}
	 * @return null if no {@link Transition} could be found
	 */
	public static Transition findTransition(PtNet net, String name){
		EList<Transition> transitions = net.getTransitions();
		for (Transition transition : transitions) {
			if (transition.getName().equals(name)) {
				return transition;
			}
		}
		return null;
	}
}
