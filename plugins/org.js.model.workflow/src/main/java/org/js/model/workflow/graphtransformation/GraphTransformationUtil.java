package org.js.model.workflow.graphtransformation;

import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.jwt.meta.model.core.Model;
import org.eclipse.jwt.meta.model.events.impl.EventImpl;
import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.meta.model.processes.ActivityEdge;
import org.eclipse.jwt.meta.model.processes.ActivityNode;
import org.eclipse.jwt.meta.model.processes.impl.ActionImpl;
import org.eclipse.jwt.meta.model.processes.impl.ActivityEdgeImpl;
import org.eclipse.jwt.meta.model.processes.impl.FinalNodeImpl;
import org.eclipse.jwt.meta.model.processes.impl.ForkNodeImpl;
import org.eclipse.jwt.meta.model.processes.impl.InitialNodeImpl;
import org.eclipse.jwt.we.model.view.Diagram;
import org.js.graph.transformation.ActivityFinal;
import org.js.graph.transformation.ArrivingRole;
import org.js.graph.transformation.BelongsTo;
import org.js.graph.transformation.Condition;
import org.js.graph.transformation.Edge;
import org.js.graph.transformation.ExistingRole;
import org.js.graph.transformation.FlowFinal;
import org.js.graph.transformation.Fork;
import org.js.graph.transformation.GraphTransformation;
import org.js.graph.transformation.IdleAction;
import org.js.graph.transformation.InheritsFrom;
import org.js.graph.transformation.Initial;
import org.js.graph.transformation.LeftSide;
import org.js.graph.transformation.Node;
import org.js.graph.transformation.Rule;
import org.js.graph.transformation.SpecializationAction;
import org.js.graph.transformation.VariableRole;
import org.js.model.rbac.RBACService;
import org.js.model.workflow.RoleConnector;
import org.js.model.workflow.util.ChangePrimitive;
import org.js.model.workflow.util.StakeholderInput;
import org.js.model.workflow.util.WorkflowConfUtil;
import org.js.model.workflow.util.WorkflowModelUtil;

/**
 * This class is used as help methods for graph transformation.
 * 
 * @author Xi
 * 
 * 
 */
public class GraphTransformationUtil {
	public static RBACService rbacService = new RBACService();

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
		ArrayList<LeftSideRef> leftSides = null;
		for (Rule rule : gt.getRules()) {
			leftSides = searchLeftSide(rule, activity);
			for (LeftSideRef leftSideRef : leftSides) {
				if (isApplicable(rule, leftSideRef, shInput)) {
					applyChangePrimitives(workflowModel, activity, diagram,
							rule, leftSideRef, shInput);
				}
			}
		}
	}

	/**
	 * search the left side of a given rule in the given workflow.
	 * 
	 * @param rule
	 * @param activity
	 * @return
	 */
	public static ArrayList<LeftSideRef> searchLeftSide(Rule rule,
			Activity activity) {
		ArrayList<LeftSideRef> leftSides = new ArrayList<LeftSideRef>();
		for (ActivityNode node : activity.getNodes()) {
			leftSides.addAll(getLeftSideRef(node, rule.getLeftside()));
		}
		return leftSides;
	}

	/**
	 * according to the given activity node we search the left side of the rule.
	 * 
	 * @param actNode
	 * @param leftSide
	 * @return
	 */
	public static ArrayList<LeftSideRef> getLeftSideRef(ActivityNode actNode,
			LeftSide leftSide) {
		ArrayList<LeftSideRef> leftSideRefs = new ArrayList<LeftSideRef>();
		LeftSideRef leftSideRef = new LeftSideRef();
		Node root = getLeftSideRoot(leftSide);
		checkStructure(actNode, root, leftSideRefs, leftSideRef, leftSide);
		return leftSideRefs;
	}

	/**
	 * check whether the given two elements have the type.
	 * 
	 * @param actNode
	 *            activity node from workflow
	 * @param node
	 *            node from rule
	 * @param leftSideRefs
	 * @param leftSideRef
	 * @param leftSide
	 * @return
	 */
	public static boolean checkStructure(ActivityNode actNode, Node node,
			ArrayList<LeftSideRef> leftSideRefs, LeftSideRef leftSideRef,
			LeftSide leftSide) {
		if (parseRuleElement(node).equals(actNode.getClass())) {
//			if ((node instanceof SpecializationAction && !WorkflowModelUtil.getActionName((Action) actNode).equals(WorkflowModelUtil.SPECIALIZATION_ACTION))
//					|| (node instanceof IdleAction && !WorkflowModelUtil.getActionName((Action) actNode).equals(WorkflowModelUtil.IDLE_ACTION))) {
//				return false;
//			}
			leftSideRef.getNodes().add(actNode);
			leftSideRef.getActivityNodesMap().put(node, actNode);
			// beware if fork is included in left side without outgoing edges, but where an outgoing edge will be added in the transformation operation,
			// the outgoing edge is already assigned due to the bidirectional references!!
			if (node.getOut().size() != 0) {
				for (Edge edge : node.getOut()) {
					if (leftSide.getEdges().contains(edge)) {
						for (ActivityEdge actEdge : actNode.getOut()) {
							if (parseRuleElement(edge.getTarget()).equals(
									actEdge.getTarget().getClass())) {
								LeftSideRef newLeftSideRef = LeftSideRef
										.createLeftSideRef(leftSideRef);
								checkStructure(actEdge, edge, leftSideRefs,
										newLeftSideRef, leftSide);
							}
						}
					} else {
					   leftSideRefs.add(leftSideRef);
					}
				}
			} else {
				leftSideRefs.add(leftSideRef);
			}
		}
		return false;
	}

	/**
	 * check whether the given two elements have the type.
	 * 
	 * @param actedge
	 *            edge from workflow
	 * @param edge
	 *            edge from rule
	 * @param leftSideRefs
	 * @param leftSideRef
	 * @param leftSide
	 * @return
	 */
	public static boolean checkStructure(ActivityEdge actedge, Edge edge,
			ArrayList<LeftSideRef> leftSideRefs, LeftSideRef leftSideRef,
			LeftSide leftSide) {
		if (parseRuleElement(edge).equals(actedge.getClass())) {
			leftSideRef.getEdges().add(actedge);
			leftSideRef.getActivityEdgesMap().put(edge, actedge);
			if (edge.getTarget() != null
					&& leftSide.getNodes().contains(edge.getTarget())) {
				checkStructure(actedge.getTarget(), edge.getTarget(),
						leftSideRefs, leftSideRef, leftSide);
			} else {
				leftSideRefs.add(leftSideRef);
			}
		}
		return false;
	}

	/**
	 * get the root nodes of the given left side.
	 * 
	 * @param leftSide
	 * @return
	 */
	public static Node getLeftSideRoot(LeftSide leftSide) {
		for (Node node : leftSide.getNodes()) {
			if (node.getIn().size() == 0) {
				return node;
			}
		}
		return null;
	}

	/**
	 * get the tail node of the given left side.
	 * 
	 * @param leftSide
	 * @return
	 */
	public static Node getLeftSideTail(LeftSide leftSide) {
		for (Node node : leftSide.getNodes()) {
			if (node.getOut().size() == 0) {
				return node;
			}
		}
		return null;
	}

	public static void applyChangePrimitives(Model workflowModel,
			Activity activity, Diagram diagram, Rule rule,
			LeftSideRef leftSideRef, StakeholderInput shInput) {
		// handle the role and the group
		// TODO: set layout
		Role role = ChangePrimitive.addRole(workflowModel, activity, diagram,
				shInput.getStakeholderType(), shInput.getStakeholderName(),
				100, 100);
		org.js.model.rbac.Role rbacRole = ((RoleConnector) WorkflowConfUtil
				.getAspectInstance(role, WorkflowConfUtil.ROLE_ASPECT))
				.getRoleref();
		if (shInput.getStakeholderGroup() != null) {
			ChangePrimitive.addGroup(workflowModel,
					shInput.getStakeholderGroup(), rbacRole);
		}

		HashMap<Node, ActivityNode> addedNodes = new HashMap<Node, ActivityNode>();
		HashMap<Edge, ActivityEdge> addedEdges = new HashMap<Edge, ActivityEdge>();
		// handle the change primitives
		if (rule.getOperations().getRemoveEdges() != null) {
			for (Edge edge : rule.getOperations().getRemoveEdges().getEdge()) {
				ActivityEdge actEdge = leftSideRef.getActivityEdgesMap().get(
						edge);
				ChangePrimitive.removeEdge(activity, actEdge.getSource(),
						actEdge.getTarget());
			}
		}
		if (rule.getOperations().getRemoveNodes() != null) {
			for (Node node : rule.getOperations().getRemoveNodes().getNode()) {
				ActivityNode actNode = leftSideRef.getActivityNodesMap().get(
						node);
				ChangePrimitive.removeActivityNode(workflowModel, activity,
						diagram, actNode.getName());
			}
		}
		if (rule.getOperations().getAddNodes() != null) {
			for (Node node : rule.getOperations().getAddNodes().getNode()) {
				ActivityNode addedNode = null;
				if (node instanceof Initial) {
					addedNode = ChangePrimitive.addInitialNode(activity,
							diagram, WorkflowModelUtil.INITIAL_NODE, 100, 100);
				} else if (node instanceof ActivityFinal) {
					addedNode = ChangePrimitive.addActivityFinalNode(activity,
							diagram, WorkflowModelUtil.ACTIVITY_FINAL_NODE,
							100, 100);
				} else if (node instanceof FlowFinal) {
					addedNode = ChangePrimitive.addFlowFinalNode(activity,
							diagram, "", 100, 100);
				} else if (node instanceof Fork) {
					addedNode = ChangePrimitive.addForkNode(activity, diagram,
							100, 100);
				} else if (node instanceof SpecializationAction) {
					addedNode = ChangePrimitive.addAction(workflowModel,
							activity, diagram,
							WorkflowModelUtil.SPECIALIZATION_ACTION, 100, 100);
				} else if (node instanceof IdleAction) {
					addedNode = ChangePrimitive.addAction(workflowModel,
							activity, diagram, WorkflowModelUtil.IDLE_ACTION,
							100, 100);
				}
				addedNodes.put(node, addedNode);
			}
		}
		if (rule.getOperations().getAddEdges() != null) {
			for (Edge edge : rule.getOperations().getAddEdges().getEdge()) {
				ActivityNode source = addedNodes.get(edge.getSource());
				ActivityNode target = addedNodes.get(edge.getTarget());
				if (source == null) {
					source = leftSideRef.getActivityNodesMap().get(
							edge.getSource());
				}
				if (target == null) {
					target = leftSideRef.getActivityNodesMap().get(
							edge.getTarget());

				}
				ActivityEdge addedEdge = ChangePrimitive.addEdge(activity,
						source, target);
				addedEdges.put(edge, addedEdge);
			}
		}
		// add role reference between action and role
		Action newAction = (Action) addedNodes.get(rule.getRoles()
				.getArrivingRole().getAction());
		ChangePrimitive.addRoleActionRef(workflowModel, activity, diagram,
				role, newAction);
		ChangePrimitive.updateActionState(newAction);
	}

	/**
	 * check whether the give rule is applicable.
	 * 
	 * @param rule
	 * @param leftSideRef
	 * @param shInput
	 * @return
	 */
	public static boolean isApplicable(Rule rule, LeftSideRef leftSideRef,
			StakeholderInput shInput) {
		for (Condition condition : rule.getApplicationConditions()
				.getConditions()) {
			// check inherits condition
			if (condition instanceof InheritsFrom) {
				org.js.model.rbac.Role parent = ((InheritsFrom) condition)
						.getParent();
				VariableRole child = ((InheritsFrom) condition).getChild();
				if (child instanceof ExistingRole) {
					Action action = (Action) leftSideRef.getNodeRef(child
							.getAction());
					org.js.model.rbac.Role childRef = ((RoleConnector) WorkflowConfUtil
							.getAspectInstance(action.getPerformedBy(),
									WorkflowConfUtil.ROLE_ASPECT)).getRoleref();
					boolean containsParent = false;
					for (org.js.model.rbac.Role tempParent : rbacService
							.getParentRoles(childRef)) {
						if (tempParent.getId().equals(parent.getId())) {
							containsParent = true;
						}
					}
					if (!containsParent) {
						return false;
					}
				} else {
					if (!shInput.getStakeholderType().getId()
							.equals(parent.getId())) {
						return false;
					}
				}
			}
			// check belongs to condition
			else {
				VariableRole leader = ((BelongsTo) condition).getLeader();
				VariableRole member = ((BelongsTo) condition).getMember();
				if (member instanceof ArrivingRole
						&& leader instanceof ExistingRole) {
					Action action = (Action) leftSideRef.getNodeRef(leader
							.getAction());
					org.js.model.rbac.Role leaderRef = ((RoleConnector) WorkflowConfUtil
							.getAspectInstance(action.getPerformedBy(),
									WorkflowConfUtil.ROLE_ASPECT)).getRoleref();
					if (shInput.getStakeholderGroup() == null
							|| !shInput.getStakeholderGroup().getId()
									.equals(leaderRef.getId())) {
						return false;
					}
				} else {
					// we do not need this case
				}
			}
		}
		return true;
	}

	/**
	 * get the jwt meta model element from the given rule element.
	 * 
	 * @param element
	 * @return
	 */
	public static Class parseRuleElement(Object element) {
		if (element instanceof Initial) {
			return InitialNodeImpl.class;
		} else if (element instanceof ActivityFinal) {
			return FinalNodeImpl.class;
		} else if (element instanceof FlowFinal) {
			return EventImpl.class;
		} else if (element instanceof Fork) {
			return ForkNodeImpl.class;
		} else if (element instanceof SpecializationAction
				|| element instanceof IdleAction) {
			return ActionImpl.class;
		} else if (element instanceof Edge) {
			return ActivityEdgeImpl.class;
		}
		return null;
	}

}
