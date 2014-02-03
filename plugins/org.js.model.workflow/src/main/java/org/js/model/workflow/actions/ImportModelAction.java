package org.js.model.workflow.actions;

import org.eclipse.emf.common.ui.dialogs.ResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.feature.model.utilities.FeatureModelLoader;
import org.js.graph.transform.stagemodel.StageModel;
import org.js.graph.transformation.GraphTransformation;
import org.js.model.rbac.AccessControlModel;
import org.js.model.workflow.ACMConnector;
import org.js.model.workflow.GraphTransConnector;
import org.js.model.workflow.StagingConnector;
import org.js.model.workflow.util.WorkflowConfUtil;

public class ImportModelAction extends MyAction {

   private final int CANCEL = 1;
   private Shell shell;
   private ResourceSet resourceSet;

   public ImportModelAction() {}

   @Override
   public ImageDescriptor getImage() {
      return null;
   }

   @Override
   public void run() {
      initialRes();
      loadModel();
      // setSHTypes();
      save();
      refresh();

   }

   /**
    * select the model file and import it if it is a rbac model file.
    */
   public void loadModel() {
      shell = workflowEditor.getSite().getShell();
      resourceSet = new ResourceSetImpl();
      ResourceDialog resourceDiaglog = new ResourceDialog(shell, "Load Model", SWT.OPEN);
      int state = resourceDiaglog.open();
      // acm model and contained elements
      if (state != CANCEL) {
         if (resourceDiaglog.getURIText() != "") {
            URI uri = resourceDiaglog.getURIs().get(0);
            if (isAccessControlModelUri(uri)) {
               loadACModel(uri);
            } else if (isGraphTransformationUri(uri)) {
               loadGTmodel(uri);
            } else if (isStageModelUri(uri)) {
               loadStageModel(uri);
            } else {
               String info =
                  "Please select an access control model file with the file extension " + WorkflowConfUtil.ACM_FILE_EXTENSION_1 + ", "
                        + WorkflowConfUtil.ACM_FILE_EXTENSION_2 + " or a stage model file with extension"
                        + WorkflowConfUtil.STAGEMODEL_FILE_EXTENSION + ".";

               MessageDialog.openInformation(getActiveShell(), "Warning", info);
            }
         }
      }
   }

   private boolean isAccessControlModelUri(URI uri) {
      String extension = uri.fileExtension();
      boolean result = WorkflowConfUtil.ACM_FILE_EXTENSION_1.equals(extension) || WorkflowConfUtil.ACM_FILE_EXTENSION_2.equals(extension);
      return result;
   }

   private boolean isGraphTransformationUri(URI uri) {
      String extension = uri.fileExtension();
      boolean result = WorkflowConfUtil.GT_FILE_EXTENSION_1.equals(extension);
      return result;
   }

   private boolean isStageModelUri(URI uri) {
      String extension = uri.fileExtension();
      boolean result = WorkflowConfUtil.STAGEMODEL_FILE_EXTENSION.equals(extension);
      return result;
   }

   /**
    * connect access control model to jwt model.
    */
   public void loadACModel(URI uri) {
      AccessControlModel accessControlModel = (AccessControlModel) FeatureModelLoader.load(uri, resourceSet);
      ACMConnector acmconnector = null;
      String aspect = WorkflowConfUtil.ACM_ASPECT;

      if (!WorkflowConfUtil.hasAspectInstance(workflowModel, aspect)) {
         acmconnector = (ACMConnector) WorkflowConfUtil.addAspectInstance(workflowModel, aspect);
      } else {
         acmconnector = (ACMConnector) WorkflowConfUtil.getAspectInstance(workflowModel, aspect);
      }
      WorkflowConfUtil.setACMRef(acmconnector, accessControlModel);
   }

   private void loadStageModel(URI uri) {
      StageModel stageModel = (StageModel) FeatureModelLoader.load(uri, resourceSet);
      StagingConnector smconnector = null;
      String aspect = WorkflowConfUtil.STAGEMODEL_ASPECT;

      if (!WorkflowConfUtil.hasAspectInstance(workflowModel, aspect)) {
         smconnector = (StagingConnector) WorkflowConfUtil.addAspectInstance(workflowModel, aspect);
      } else {
         smconnector = (StagingConnector) WorkflowConfUtil.getAspectInstance(workflowModel, aspect);
      }
      WorkflowConfUtil.setStageModelRef(smconnector, stageModel);
   }

   /**
    * connect graph transformation model to jwt model.
    */
   public void loadGTmodel(URI uri) {
      GraphTransformation graphTransformationModel = (GraphTransformation) FeatureModelLoader.load(uri, resourceSet);

      if (!WorkflowConfUtil.hasAspectInstance(workflowModel, WorkflowConfUtil.GT_ASPECT)) {
         GraphTransConnector gtConnector =
            (GraphTransConnector) WorkflowConfUtil.addAspectInstance(workflowModel, WorkflowConfUtil.GT_ASPECT);
         WorkflowConfUtil.setGraphTrans(gtConnector, graphTransformationModel);
      } else {
         GraphTransConnector gtConnector =
            (GraphTransConnector) WorkflowConfUtil.getAspectInstance(workflowModel, WorkflowConfUtil.GT_ASPECT);
         WorkflowConfUtil.setGraphTrans(gtConnector, graphTransformationModel);
      }

   }
   //
   // public void setSHTypes(){
   // SetStakeholerTypes sSHTypes = new SetStakeholerTypes();
   // sSHTypes.run();
   // }
   //
   // public void importGT(){
   //
   // }
}
