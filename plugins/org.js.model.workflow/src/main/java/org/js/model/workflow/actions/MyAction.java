package org.js.model.workflow.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.events.EventsFactory;
import org.eclipse.jwt.meta.model.organisations.OrganisationsFactory;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.meta.model.processes.ProcessesFactory;
import org.eclipse.jwt.we.conf.model.ConfModel;
import org.eclipse.jwt.we.editors.WEEditor;
import org.eclipse.jwt.we.editors.actions.external.WEExternalAction;
import org.eclipse.jwt.we.model.view.Diagram;
import org.eclipse.jwt.we.model.view.ViewFactory;
import org.js.model.workflow.util.WorkflowUtil;

/**
 * this class is used as a template of customized jwt action.
 * 
 * @author Xi
 * 
 */
public class MyAction extends WEExternalAction {

   protected WEEditor workflowEditor;
   protected Model workflowModel;
   protected Activity activity;
   protected Diagram diagram;
   protected ConfModel confModel;
   protected Resource workflowResource;
   protected Resource workflowViewResource;
   protected Resource workflowConfResource;

   protected ProcessesFactory processFactory = ProcessesFactory.eINSTANCE;
   protected ViewFactory viewFactory = ViewFactory.eINSTANCE;
   protected EventsFactory eventsFactory = EventsFactory.eINSTANCE;
   protected OrganisationsFactory orgFactory = OrganisationsFactory.eINSTANCE;

   public MyAction() {

   }

   @Override
   public ImageDescriptor getImage() {
      return null;
   }

   @Override
   public void run() {
      initialRes();
      save();
      refresh();
   }

   /**
    * initial all resources.
    */
   public void initialRes() {
      workflowEditor = getActiveWEEditor();
      workflowResource = workflowEditor.getMainModelResource();
      workflowModel = (Model) workflowEditor.getModel();
      activity = workflowEditor.getDisplayedActivityModel();
      diagram = workflowEditor.getDiagramData();
      // activity = getActiveActivitySheet().getActivityModel();
      // EditingDomain editingDomain = workflowEditor.getEmfEditingDomain();

      workflowViewResource = WorkflowUtil.getWorkflowViewReousrce(workflowResource);
      workflowConfResource = WorkflowUtil.getWorkflowConfReousrce(workflowResource);
      confModel = (ConfModel) workflowConfResource.getContents().get(0);
   }

   /**
    * save the workflow models.
    */
   public void save() {
      // Map<String, String> saveOptions = new HashMap<String, String>();
      // saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");

      final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
      saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);

      try {
         workflowModel.eResource().save(saveOptions);
         // workflowModel.eResource().save(null);
         diagram.eResource().save(saveOptions);
         // confModel.eResource().save(saveOptions);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   /**
    * refresh the jwt editor.
    */
   public void refresh() {
      workflowEditor.refreshOutline();
      workflowEditor.refreshPages();
      workflowEditor.refreshProperties();
      workflowEditor.refreshZoom();
   }

   public WEEditor getWorkflowEditor() {
      return workflowEditor;
   }

   public void setWorkflowEditor(WEEditor workflowEditor) {
      this.workflowEditor = workflowEditor;
   }

   public Model getWorkflowModel() {
      return workflowModel;
   }

   public void setWorkflowModel(Model workflowModel) {
      this.workflowModel = workflowModel;
   }

   public Activity getActivity() {
      return activity;
   }

   public void setActivity(Activity activity) {
      this.activity = activity;
   }

   public Diagram getDiagram() {
      return diagram;
   }

   public void setDiagram(Diagram diagram) {
      this.diagram = diagram;
   }

   public ConfModel getConfModel() {
      return confModel;
   }

   public void setConfModel(ConfModel confModel) {
      this.confModel = confModel;
   }

   public Resource getWorkflowResource() {
      return workflowResource;
   }

   public void setWorkflowResource(Resource workflowResource) {
      this.workflowResource = workflowResource;
   }

   public Resource getWorkflowViewResource() {
      return workflowViewResource;
   }

   public void setWorkflowViewResource(Resource workflowViewResource) {
      this.workflowViewResource = workflowViewResource;
   }

   public Resource getWorkflowConfResource() {
      return workflowConfResource;
   }

   public void setWorkflowConfResource(Resource workflowConfResource) {
      this.workflowConfResource = workflowConfResource;
   }

   public ProcessesFactory getProcessFactory() {
      return processFactory;
   }

   public void setProcessFactory(ProcessesFactory processFactory) {
      this.processFactory = processFactory;
   }

   public ViewFactory getViewFactory() {
      return viewFactory;
   }

   public void setViewFactory(ViewFactory viewFactory) {
      this.viewFactory = viewFactory;
   }

   public EventsFactory getEventsFactory() {
      return eventsFactory;
   }

   public void setEventsFactory(EventsFactory eventsFactory) {
      this.eventsFactory = eventsFactory;
   }

   public OrganisationsFactory getOrgFactory() {
      return orgFactory;
   }

   public void setOrgFactory(OrganisationsFactory orgFactory) {
      this.orgFactory = orgFactory;
   }
}
