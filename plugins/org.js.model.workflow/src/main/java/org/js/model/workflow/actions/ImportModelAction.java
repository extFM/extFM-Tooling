package org.js.model.workflow.actions;

import java.io.IOException;
import java.util.Collections;
import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.js.graph.transformation.GraphTransformation;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.impl.AccessControlModelImpl;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.GraphTransConnector;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowUtil;

public class ImportModelAction extends MyAction {

	private final int OK = 0;
	private final int CANCEL = 1;
	private Shell shell;
	private ResourceSet resourceSet;
	private Resource rbacRes;
	private Resource graphTransRes;

	public ImportModelAction() {
	}

	@Override
	public ImageDescriptor getImage() {
		return null;
	}

	@Override
	public void run() {
		initialRes();
		loadModel();
		setSHTypes();
		save();
		refresh();

	}

	/**
	 * select the model file and import it if it is a rbac model file.
	 */
	public void loadModel() {
		shell = workflowEditor.getSite().getShell();
		resourceSet = new ResourceSetImpl();
		ResourceDialog resourceDiaglog = new ResourceDialog(shell,
				"Load Model", SWT.OPEN);
		int state = resourceDiaglog.open();
		// acm model and contained elements
		if (state != CANCEL) {
			if (resourceDiaglog.getURIText() != "") {
				URI uri = resourceDiaglog.getURIs().get(0);
				if (uri.fileExtension().equals(
						WorkflowConfUtil.ACM_FILE_EXTENSION_1)
						|| uri.fileExtension().equals(
								WorkflowConfUtil.ACM_FILE_EXTENSION_2)) {
					rbacRes = resourceSet.getResource(resourceDiaglog.getURIs()
							.get(0), true);
					try {
						rbacRes.load(Collections.EMPTY_MAP);
					} catch (IOException e) {
						e.printStackTrace();
					}
					loadACModel();
				} else if (uri.fileExtension().equals(
						WorkflowConfUtil.GT_FILE_EXTENSION_1)) {
					graphTransRes = resourceSet.getResource(resourceDiaglog
							.getURIs().get(0), true);
					try {
						graphTransRes.load(Collections.EMPTY_MAP);
					} catch (IOException e) {
						e.printStackTrace();
					}
					loadGTmodel();
				} else {
					String info = "Please selected rbac model file with the file extension "
							+ WorkflowConfUtil.ACM_FILE_EXTENSION_1
							+ ", "
							+ WorkflowConfUtil.ACM_FILE_EXTENSION_2
							+ " or "
							+ WorkflowConfUtil.GT_FILE_EXTENSION_1 + ".";

					MessageDialog.openInformation(getActiveShell(), "Warning",
							info);
				}
			}
		}
	}

	/**
	 * connect access control model to jwt model.
	 */
	public void loadACModel() {
		TreeIterator<EObject> rbacIt = rbacRes.getAllContents();
		AccessControlModel acm = null;

		while (rbacIt.hasNext()) {
			EObject object = rbacIt.next();
			if (object instanceof AccessControlModel) {
				acm = (AccessControlModelImpl) object;
			}
		}
		if (!WorkflowConfUtil.hasAspectInstance(workflowModel,
				WorkflowConfUtil.ACM_ASPECT)) {
			ACMConnector acmconnector = (ACMConnector) WorkflowConfUtil
					.addAspectInstance(workflowModel,
							WorkflowConfUtil.ACM_ASPECT);
			WorkflowConfUtil.setACMRef(acmconnector, acm);
		} else {
			ACMConnector acmconnector = (ACMConnector) WorkflowConfUtil
					.getAspectInstance(workflowModel,
							WorkflowConfUtil.ACM_ASPECT);
			WorkflowConfUtil.setACMRef(acmconnector, acm);
		}
	}
	
	/**
	 * connect graph transformation model to jwt model.
	 */
	public void loadGTmodel(){
		TreeIterator<EObject> graphTransIt = graphTransRes.getAllContents();
		GraphTransformation graphTrans = null;

		while (graphTransIt.hasNext()) {
			EObject object = graphTransIt.next();
			if (object instanceof GraphTransformation) {
				graphTrans = (GraphTransformation) object;
			}
		}
		if (!WorkflowConfUtil.hasAspectInstance(workflowModel,
				WorkflowConfUtil.GT_ASPECT)) {
			GraphTransConnector gtConnector = (GraphTransConnector) WorkflowConfUtil
					.addAspectInstance(workflowModel,
							WorkflowConfUtil.GT_ASPECT);
			WorkflowConfUtil.setGraphTrans(gtConnector, graphTrans);
		} else {
			GraphTransConnector gtConnector = (GraphTransConnector) WorkflowConfUtil
					.getAspectInstance(workflowModel,
							WorkflowConfUtil.GT_ASPECT);
			WorkflowConfUtil.setGraphTrans(gtConnector, graphTrans);
		}
		
	}
	
	public void setSHTypes(){
		SetStakeholerTypes sSHTypes = new SetStakeholerTypes();
		sSHTypes.run();
	}
}
