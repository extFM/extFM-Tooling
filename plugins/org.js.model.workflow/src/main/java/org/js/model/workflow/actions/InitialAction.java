package org.js.model.workflow.actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.FinalNode;
import org.eclipse.jwt.meta.model.processes.ForkNode;
import org.eclipse.jwt.meta.model.processes.InitialNode;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.WorkflowModelUtil;

public class InitialAction extends MyAction {
	public InitialAction() {
	}

	@Override
	public void run() {

		initialRes();
		initialWorkflow();
		save();
		refresh();
	}

	/**
	 * initial the workflow.
	 */
	public void initialWorkflow() {
		InitialNode initNode = ChangePrimitive.addInitialNode(activity,
				diagram, WorkflowModelUtil.INITIAL_NODE, 100, 200);
		ForkNode forkNode = ChangePrimitive.addForkNode(activity, diagram, 200,
				200);
		Action action = ChangePrimitive.addAction(workflowModel, activity,
				diagram, WorkflowModelUtil.IDLE_ACTION, 300, 200);
		FinalNode finaNode = ChangePrimitive.addActivityFinalNode(activity,
				diagram, WorkflowModelUtil.ACTIVITY_FINAL_NODE, 400, 200);
		ChangePrimitive.addEdge(activity, initNode, forkNode);
		ChangePrimitive.addEdge(activity, forkNode, action);
		ChangePrimitive.addEdge(activity, action, finaNode);
	}
}
