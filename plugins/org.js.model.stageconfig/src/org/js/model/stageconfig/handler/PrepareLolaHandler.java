/**
 * 
 */
package org.js.model.stageconfig.handler;

import hub.top.editor.ptnetLoLA.Arc;
import hub.top.editor.ptnetLoLA.Place;
import hub.top.editor.ptnetLoLA.PtNet;
import hub.top.editor.ptnetLoLA.PtnetLoLAPackage;
import hub.top.editor.ptnetLoLA.Transition;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Handler for creating Lola Files
 * @author Tim Winkelmann
 * 
 */
public class PrepareLolaHandler extends AbstractHandler {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.
	 * ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	    ISelection sel = HandlerUtil.getActiveMenuSelection(event);
	    IStructuredSelection selection = (IStructuredSelection) sel;
	    Object firstElement = selection.getFirstElement();
	    if (firstElement instanceof IFile) {
			IFile file = (IFile) firstElement;
			System.out.println(file.getProject().getLocation().toString());
			PtnetLoLAPackage einstance = PtnetLoLAPackage.eINSTANCE;
			ResourceSet resourceSet = new ResourceSetImpl();

			String path = file.getFullPath().toString();
			URI uri = URI.createPlatformResourceURI(path, true);
			Resource resource = resourceSet.getResource(uri,true);
			
			if (resource != null) {
				if (!resource.getContents().isEmpty()) {
					EObject eObject = resource.getContents().get(0);
					eObject.eContainer();
					if (eObject instanceof PtNet) {
						PtNet ptnet = (PtNet) eObject;
						String lolaFilePath = file.getProject().getLocation().toString() + "/" + file.getName();
						lolaFilePath = lolaFilePath.replace(".ptnet", ".lola");
						File lolaFile = new File(lolaFilePath);
						createLolaFile(lolaFile,ptnet);
						EList<Transition> transitions = ptnet.getTransitions();
						for (Transition transition : transitions) {
							String taskFilePath = file.getProject().getLocation().toString() + "/" + file.getName() + "." +  transition.getName() + ".task";
							taskFilePath = taskFilePath.replace(".ptnet", ".lola");
							File taskFile = new File(taskFilePath);
							try {
								System.out.println(taskFile.getAbsolutePath());
								taskFile.createNewFile();
								FileWriter fileWriter = new FileWriter(taskFile);
								String formulaForTransaction = createFormulaForTransaction(transition);
								System.out.println(formulaForTransaction);
								fileWriter.write(formulaForTransaction);
								fileWriter.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						String taskFilePath = file.getProject().getLocation().toString() + "/" + file.getName() + "." +  "t_star" + ".task";
						taskFilePath = taskFilePath.replace(".ptnet", ".lola");
						File taskFile = new File(taskFilePath);
						try {
							System.out.println(taskFile.getAbsolutePath());
							taskFile.createNewFile();
							FileWriter fileWriter = new FileWriter(taskFile);
							String formula = "FORMULA ( o >= 1 )";
							System.out.println(formula);
							fileWriter.write(formula);
							fileWriter.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Creates lola file
	 * @param lolaFile
	 * @param ptnet
	 */
	private void createLolaFile(File lolaFile, PtNet ptnet) {
		//create file
		try {
			lolaFile.createNewFile();
			//create places
			FileWriter fileWriter = new FileWriter(lolaFile);
			fileWriter.write("PLACE\n\r");
			EList<Place> places = ptnet.getPlaces();
			for (Iterator iterator = places.iterator(); iterator.hasNext();) {
				Place place = (Place) iterator.next();
				fileWriter.write(place.getName());
				if (iterator.hasNext()) {
					fileWriter.write(", ");
				} else {
					fileWriter.write(";\n\r");
				}
			}
			//create marking
			fileWriter.write("MARKING\n\r");
			fileWriter.write("i:1;\n\r");
			//create t*
			fileWriter.write("TRANSITION t_star\n\r");
			fileWriter.write("CONSUME\n\r");
			fileWriter.write("o:1;\n\r");
			fileWriter.write("PRODUCE\n\r");
			fileWriter.write("i:1;\n\r");
			//create transitions
			EList<Transition> transitions = ptnet.getTransitions();
			for (Transition transition : transitions) {
				fileWriter.write("TRANSITION " + transition.getName() + "\n\r");
				fileWriter.write("CONSUME\n\r");
				EList<Arc> incoming = transition.getIncoming();
				for (Iterator iterator = incoming.iterator(); iterator.hasNext();) {
					Arc arc = (Arc) iterator.next();
					fileWriter.write(arc.getSource().getName());
					if (iterator.hasNext()) {
						fileWriter.write(":1,\n\r");
					} else {
						fileWriter.write(":1;\n\r");
					}
				}
				fileWriter.write("PRODUCE\n\r");
				EList<Arc> outgoing = transition.getOutgoing();
				for (Iterator iterator = outgoing.iterator(); iterator.hasNext();) {
					Arc arc = (Arc) iterator.next();
					fileWriter.write(arc.getTarget().getName());
					if (iterator.hasNext()) {
						fileWriter.write(":1,\n\r");
					} else {
						fileWriter.write(":1;\n\r");
					}
				}
			}
			
			fileWriter.close();
		} catch (IOException e) {
			System.err.println("Could not create a new lola file!");
			e.printStackTrace();
			return;
		}
		
	}

	/**
	 * Creates the liveness formula for the task file
	 * @param transition the transition for the liveness check
	 * @return the formula
	 */
	private String createFormulaForTransaction(Transition transition){
		EList<Arc> incoming = transition.getIncoming();
		String formula = "FORMULA ( ";
		for (Arc arc : incoming) {
			formula = formula + arc.getSource().getName();
			formula = formula + " >= 1 AND ";
		}
		//remove last AND
		formula = formula.substring(0, formula.length()-5);
		formula = formula + ")";
		return formula;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow activeWorkbenchWindow = wb.getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null) {
			return false;
		}
		ISelectionService selectionService = activeWorkbenchWindow.getSelectionService();
		if (selectionService == null) {
			return false;
		}
		ISelection selection = selectionService.getSelection();
		if (selection == null) {
			return false;
		}
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structSelection = (IStructuredSelection) selection;
			List<?> selected = structSelection.toList();
			for (Object object : selected) {
				if (object instanceof IFile) {
					IFile file = (IFile) object;
					String fileExtension = file.getFileExtension();
					if (fileExtension.equals("ptnet")) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
