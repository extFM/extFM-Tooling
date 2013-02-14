/**
 * 
 */
package org.js.model.stageconfig.handler;

import hub.top.editor.ptnetLoLA.PtNet;
import hub.top.editor.ptnetLoLA.PtnetLoLAPackage;
import hub.top.editor.ptnetLoLA.Transition;
import hub.top.editor.ptnetLoLA.impl.PtNetImpl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.EMFPlugin.EclipsePlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.util.EclipseModelUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * @author winkelti
 * 
 */
public class PrepareLolaHandler implements IHandler {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#addHandlerListener(org.eclipse.core
	 * .commands.IHandlerListener)
	 */
	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#dispose()
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

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
						EList<Transition> transitions = ptnet.getTransitions();
						for (Transition transition : transitions) {
							File taskFile = new File(file.getProject().getLocation().toString() + "/" + transition.getName() + ".task");
							try {
								System.out.println(taskFile.getAbsolutePath());
								taskFile.createNewFile();
								FileWriter fileWriter = new FileWriter(taskFile);
								fileWriter.write("FORMULA");
								fileWriter.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					System.out.println(eObject);
				}
			}
		}
		return null;
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
//		 List<IFile> files = ResourceUtil.getSelectedWorkbenchFiles();
//		IWorkbench workbench = StageconfigEditorPlugin.getDefault().getWorkbench();
//		List<IFile> files = new ArrayList<IFile>(5);
//		if (workbench != null) {
//			IWorkbenchWindow wbWindow = workbench.getActiveWorkbenchWindow();
//			if (wbWindow != null) {
//				ISelectionService selectService = wbWindow
//						.getSelectionService();
//				if (selectService != null) {
//					ISelection selection = selectService.getSelection();
//					if (selection instanceof IStructuredSelection) {
//						IStructuredSelection structSelection = (IStructuredSelection) selection;
//						List<?> selected = structSelection.toList();
//						for (Iterator<?> iterator = selected.iterator(); iterator
//								.hasNext();) {
//							Object element = (Object) iterator.next();
//							if (element instanceof IAdaptable) {
//								IAdaptable adaptable = (IAdaptable) element;
//								IResource resource = (IResource) adaptable
//										.getAdapter(IResource.class);
//								try {
//									files.addAll(getFiles(resource));
//								} catch (CoreException e) {
//									e.printStackTrace();
//								}
//							}
//						}
//					}
//				}
//			}
//		}
		// TODO Auto-generated method stub
		return false;
	}

	private List<IFile> getFiles(IResource resource) throws CoreException {
		List<IFile> files = new ArrayList<IFile>(2);
		if (resource != null) {
			if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				files.add(file);
			} else if (resource instanceof IFolder) {
				IFolder folder = (IFolder) resource;
				IResource[] folderMember = folder.members();
				for (IResource iResource : folderMember) {
					files.addAll(getFiles(iResource));
				}
			} else if (resource instanceof IProject) {
				IProject project = (IProject) resource;
				IResource[] members = project.members();
				for (IResource iResource : members) {
					files.addAll(getFiles(iResource));
				}
			}
		}
		return files;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.commands.IHandler#isHandled()
	 */
	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.commands.IHandler#removeHandlerListener(org.eclipse.
	 * core.commands.IHandlerListener)
	 */
	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
