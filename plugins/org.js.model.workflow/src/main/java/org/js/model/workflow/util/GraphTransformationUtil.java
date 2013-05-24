package org.js.model.workflow.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.we.model.view.Diagram;
import org.js.graph.transformation.*;
import org.js.model.rbac.AccessControlModel;
import org.js.model.rbac.Group;
import org.js.model.rbac.Role;
import org.js.model.workflow.State;
import org.js.model.workflow.StateEnum;

/**
 * This class is used as help methods.
 * 
 * @author Xi
 * 
 * 
 */
public class GraphTransformationUtil {


	/**
	 * apply the graph transformation.
	 * 
	 * @param shInput
	 * @param gt
	 * @param workflowModel
	 * @param activity
	 * @param diagram
	 */
	public static void graphTransformation(StakeholderInput shInput,
			GraphTransformation gt, Model workflowModel, Activity activity,
			Diagram diagram) {
		boolean handleShInput = false;
		List<ActivityNode> leftSideRoots = null;

		for (Rule rule : gt.getRules()) {
			leftSideRoots = searchLeftSide(rule, activity);
			if (leftSideRoots.size() != 0) {
				if (!handleShInput) {
					// handleShInput=handleShInput(shInput);
				}
				applyChangePrimitives(rule, workflowModel, activity, diagram);
			}

		}
	}

	/**
	 * search the left side of a given rule.
	 * 
	 * @param rule
	 * @param activity
	 * @return
	 */
	public static List<ActivityNode> searchLeftSide(Rule rule, Activity activity) {
		// the start node of the left side of the rule
		List<ActivityNode> leftSideRoots = new ArrayList<ActivityNode>();
		for (ActivityNode node : activity.getNodes()) {
			if (hasStructure(node, rule.getLeftside())) {
				leftSideRoots.add(node);
			}
		}
		return leftSideRoots;
	}

	public static boolean hasStructure(ActivityNode node, LeftSide leftSide) {
		Node root = getLeftSideRoot(leftSide);
		System.out.println(root.getClass());
		// if(root.getClass())
		if (root.getOut().size() == node.getOut().size()) {
			for (Edge edge : root.getOut()) {

			}
		}

		// ActivityNode actiNode
		return false;
	}

	// public static boolean handleShInput(StakeholderInput shInput) {
	//
	// }
	public static Node getLeftSideRoot(LeftSide leftSide) {
		for (Node node : leftSide.getNodes()) {
			if (node.getIn().size() == 0) {
				return node;
			}
		}
		return null;
	}

	public static void applyChangePrimitives(Rule rule, Model workflowModel,
			Activity activity, Diagram diagram) {

	}

}
