package org.js.model.workflow.actions;

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
	 * initial the workflow with an initial node -> fork -> idle action -> final node.
	 */
	public void initialWorkflow() {
		if(WorkflowModelUtil.getIdleAction(activity)==null){
		InitialNode initNode = ChangePrimitive.addInitialNode(activity,
				diagram, WorkflowModelUtil.INITIAL_NODE, 100, 100);
		ForkNode fork = ChangePrimitive.addForkNode(activity, diagram, 150, 100);
		Action action = ChangePrimitive.addAction(workflowModel, activity,
				diagram, WorkflowModelUtil.IDLE_ACTION, 200, 100);
		FinalNode finalNode = ChangePrimitive.addActivityFinalNode(activity,
				diagram, WorkflowModelUtil.ACTIVITY_FINAL_NODE, 350, 100);
		
		ChangePrimitive.addEdge(activity, initNode, fork);
		ChangePrimitive.addEdge(activity, fork, action);
		ChangePrimitive.addEdge(activity, action, finalNode);
		ChangePrimitive.updateActionState(action);
		}
	}
}
