package org.js.model.workflow.actions;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.EditDomain;
import org.eclipse.jwt.meta.model.core.ModelElement;
import org.eclipse.jwt.meta.model.events.Event;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.we.parts.core.doubleClick.*;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.js.model.feature.FeatureModel;
import org.js.model.workflow.EFMContainer;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;
import org.js.model.workflow.ui.IdleUI;
import org.js.model.workflow.ui.StakeholderConfigUIShell;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;
import org.js.model.workflow.util.WorkflowUtil;

public class ConfigHandler extends MyAction implements DoubleClickHandler {

	public ConfigHandler() {

	}

	@Override
	public boolean appliesTo(ModelElement modelElement) {
		initialRes();
		if (modelElement instanceof Action) {// specialization action or idle
												// action
			return true;
		} else if (modelElement instanceof Event) { // flow final node
			return true;
		}
		return false;
	}

	@Override
	public void processDoubleClick(ModelElement modelElement,
			EditDomain editDomain) {
		if (modelElement instanceof Action) {
			if (WorkflowModelUtil.getActionName((Action) modelElement).equals(
					WorkflowModelUtil.SPECIALIZATION_ACTION)) {
				handleSpecializationAction((Action) modelElement);
			} else {
				handleIdleAction((Action) modelElement);
			}
		} else if (modelElement instanceof Event) {
			handleFlowFinal((Event) modelElement);
		}
		save();
		refresh();
	}

	public void handleSpecializationAction(Action action) {
		State state = (State) WorkflowConfUtil.getAspectInstance(action,
				WorkflowConfUtil.STATE_ASPECT);
		org.js.model.rbac.Role role = ((RoleConnector) WorkflowConfUtil
				.getAspectInstance(((Action) action).getPerformedBy(),
						WorkflowConfUtil.ROLE_ASPECT)).getRoleref();
		// according to the state value the ui is different
		if (StateEnum.ENABLED.equals(state.getState())
				|| StateEnum.COMPLETED.equals(state.getState())) {
			try {
				Display display = Display.getDefault();
				StakeholderConfigUIShell shell = new StakeholderConfigUIShell(
						workflowModel, display, role, (Action) action, state);
				shell.open();
				shell.layout();
				while (!shell.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
				WorkflowModelUtil.setActionState(action, shell.getState()
						.getState());
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (StateEnum.COMPLETED.equals(state.getState())) {
				for (Action nextAction : WorkflowModelUtil
						.getNextSpecializationActions(action)) {
					WorkflowModelUtil.setActionState(nextAction);
				}
			}
		}
	}

	public void handleIdleAction(Action action) {
		State state = (State) WorkflowConfUtil.getAspectInstance(action,
				WorkflowConfUtil.STATE_ASPECT);
		if (state.getState().getValue() == 1) {
			WorkflowModelUtil.setActionState(action, StateEnum.RUNNING);
			try {
				Display display = Display.getDefault();
				IdleUI shell = new IdleUI(display, activity, state);
				shell.open();
				shell.layout();
				while (!shell.isDisposed()) {
					if (!display.readAndDispatch()) {
						display.sleep();
					}
				}
				WorkflowModelUtil.setActionState(action, shell.getState()
						.getState());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void handleFlowFinal(Event flowFinal) {
		Action preAction = WorkflowModelUtil.getPrecedeAction(flowFinal);
		State state = (State) WorkflowConfUtil.getAspectInstance(preAction,
				WorkflowConfUtil.STATE_ASPECT);
		if (state.getState().getValue() == 3) {
			// open the configuration file
			EFMContainer efmContainer = (EFMContainer) WorkflowConfUtil
					.getAspectInstance(preAction, WorkflowConfUtil.EFM_ASPECT);
			FeatureModel fm = efmContainer.getEfmref();
			if (fm != null) {
				URI fmURI = CommonPlugin.resolve(fm.eResource().getURI());
				IFile iFile = ResourcesPlugin.getWorkspace().getRoot()
						.getFile(new Path(fmURI.toFileString()));
				File file = new File(iFile.getFullPath().toString());
				final IFile inputFile = ResourcesPlugin
						.getWorkspace()
						.getRoot()
						.getFileForLocation(
								Path.fromOSString(file.getAbsolutePath()));
				if (inputFile != null) {
					IWorkbenchPage page = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage();
					try {
						IDE.openEditor(page, inputFile);
					} catch (PartInitException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
