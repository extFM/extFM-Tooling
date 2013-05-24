package org.js.model.workflow.actions;

import org.js.model.workflow.util.WorkflowConfUtil;

public class CleanAction extends MyAction {

	public CleanAction() {
	}


	@Override
	public void run() {

		initialRes();
		clean();
		save();
		refresh();
	}

	/**
	 * clean the worklfow.
	 */
	public void clean() {
		// remove all aspects
		
		WorkflowConfUtil.removeAspectInstances(activity);
//		for(AspectInstance aspectInstance:confModel.getAspectInstances()){
//			aspectInstance.setTargetModelElement(null);
//			confModel.getAspectInstances().remove(aspectInstance);
//		}
//		confModel.getAspectInstances().clear();
		
		
		save();
		// remove the activity element
		activity.getNodes().clear();
		activity.getEdges().clear();
//		// remove the roles
		workflowModel.getElements().removeAll(
				workflowModel.getElements().subList(1,
						workflowModel.getElements().size()));
//		// remove the layout data
		diagram.getReferenceEdges().clear();
		diagram.getReferences().clear();
		diagram.getLayoutData().clear();

		// confModel.getProfiles().clear();
	}

}
