package org.js.model.adaptation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.we.editors.WEEditor;
import org.eclipse.jwt.we.model.view.Diagram;
import org.eclipse.ui.IEditorPart;
import org.feature.model.utilities.WorkbenchUtil;

public abstract class AbstractWorkflowRewriteRule implements IRewriteRule {

   protected int coordinate = 10;

   protected Model workflow;

   protected Activity activity;
   protected Diagram diagram;
   private WEEditor workflowEditor;

   public AbstractWorkflowRewriteRule(Model workflow) {
      Assert.isNotNull(workflow);
      this.workflow = workflow;
      init();
   }

   @Override
   public int execute() {
      int returnCode = executeInternal();
      save();
      refresh();
      return returnCode;
   }

   protected abstract int executeInternal();

   private void save() {
      final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
      saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
      try {
         workflow.eResource().save(saveOptions);
         diagram.eResource().save(saveOptions);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   private void refresh() {
      workflowEditor.refreshOutline();
      workflowEditor.refreshPages();
      workflowEditor.refreshProperties();
      workflowEditor.refreshZoom();
   }

   private void init() {
      workflowEditor = getActiveWorkflowEditor();
      activity = workflowEditor.getDisplayedActivityModel();
      diagram = workflowEditor.getDiagramData();
   }

   private WEEditor getActiveWorkflowEditor() {
      WEEditor workflowEditor = null;
      IEditorPart editor = WorkbenchUtil.getActiveEditor();
      if (editor instanceof WEEditor) {
         workflowEditor = (WEEditor) editor;
      }
      return workflowEditor;
   }

   public Activity getActivity() {
      return activity;
   }

   public Diagram getDiagram() {
      return diagram;
   }

}
