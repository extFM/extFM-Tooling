package org.js.model.workflow.util;

import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jwt.meta.model.core.GraphicalElement;
import org.eclipse.jwt.meta.model.core.ReferenceableElement;
import org.eclipse.jwt.meta.model.organisations.Role;
import org.eclipse.jwt.meta.model.processes.Action;
import org.eclipse.jwt.meta.model.processes.Activity;
import org.eclipse.jwt.we.model.view.Diagram;
import org.eclipse.jwt.we.model.view.LayoutData;
import org.eclipse.jwt.we.model.view.Reference;
import org.eclipse.jwt.we.model.view.ReferenceEdge;
import org.eclipse.jwt.we.model.view.ViewFactory;

/**
 * 
 * This class gives some help methods for workflow view model. Attention:jwt
 * editor enable user to set multiple references for one role. In our extension
 * we set only one reference for one role!
 * 
 * @author Xi
 * 
 */
public class WorkflowViewUtil {

	public static final String CONF_WORKFLOW_VIEW = "ConfWorkflow";
	public static ViewFactory viewFactory = ViewFactory.eINSTANCE;

	/**
	 * get the layout data for the given graphical element
	 * 
	 * @param diagram
	 *            view model of editor
	 * @param gEle
	 * @return layout data
	 */
	public static LayoutData getNodeLayout(Diagram diagram,
			GraphicalElement gEle) {
		EList<LayoutData> lodatalist = diagram.getLayoutData();
		Iterator<LayoutData> it = lodatalist.iterator();
		LayoutData layoutdata = null;
		while (it.hasNext()) {
			layoutdata = it.next();
			GraphicalElement desEle = layoutdata.getDescribesElement();
			if (desEle.equals(gEle)) {
				return layoutdata;
			}
		}
		return null;
	}

	/**
	 * get the reference for the given role. 
	 * 
	 * @param diagram
	 * @param role
	 * @return
	 */
	public static Reference getReference(Diagram diagram, Role role) {
		EList<Reference> refList = diagram.getReferences();
		ReferenceableElement refELe = null;
		for (Reference ref : refList) {
			refELe = ref.getReference();
			if (refELe instanceof Role
					&& WorkflowModelUtil.comparatorForRole(role, (Role) refELe)) {
				return ref;
			}
		}
		return null;
	}

	/**
	 * get the layout data for the given role
	 * 
	 * @param diagram
	 *            view model of editor
	 * @param role
	 *            role
	 * @return layout data
	 */
	public static LayoutData getRoleLayout(Diagram diagram, Role role) {
		Reference ref = getReference(diagram, role);
		EList<LayoutData> layoutDataList = diagram.getLayoutData();
		for (LayoutData layoutData : layoutDataList) {
			GraphicalElement graphEle = layoutData.getDescribesElement();
			if (graphEle instanceof Reference && graphEle.equals(ref)) {
				return layoutData;
			}
		}
		return null;
		// Iterator<LayoutData> it = layoutDataList.iterator();
		// LayoutData layoutdata = null;
		// while (it.hasNext()) {
		// layoutdata = it.next();
		// GraphicalElement graphEle = layoutdata.getDescribesElement();
		// if (graphEle instanceof Reference) {
		// ReferenceableElement re = ((Reference) graphEle).getReference();
		// if (re instanceof Role
		// && WorkflowModelUtil.comparatorForRole((Role) re, role)) {
		// return layoutdata;
		// }
		// }
		// }
		// return null;
	}

	public static void setNodeLayout(Diagram diagram, GraphicalElement gEle,
			int coorX, int coorY, String viewid) {
		LayoutData layoutdata = getNodeLayout(diagram, gEle);
		if (viewid != null && !viewid.equals("")) {
			layoutdata.setViewid(viewid);
		}
		layoutdata.setX(coorX);
		layoutdata.setY(coorY);
	}

	public static void setNodeLayout(Diagram diagram, GraphicalElement gEle,
			int coorX, int coorY) {
		LayoutData layoutdata = getNodeLayout(diagram, gEle);
		layoutdata.setX(coorX);
		layoutdata.setY(coorY);
	}

	/**
	 * set the layout the role.
	 * 
	 * @param diagram
	 * @param activity
	 * @param role
	 * @param coorX
	 * @param coorY
	 * @return
	 */
	public static Reference setRoleLayout(Diagram diagram, Activity activity,
			Role role, int coorX, int coorY) {

		Reference reference = viewFactory.createReference();
		reference.setContainedIn(activity);
		reference.setReference(role);
		diagram.getReferences().add(reference);

		LayoutData layoutdata = getRoleLayout(diagram, role);
		if (layoutdata == null) {
			layoutdata = viewFactory.createLayoutData();
			layoutdata.setDescribesElement(reference);
			layoutdata.setViewid(CONF_WORKFLOW_VIEW);
			layoutdata.setInitialized(true);
			diagram.getLayoutData().add(layoutdata);
		}
		layoutdata.setInitialized(true);
		layoutdata.setX(coorX);
		layoutdata.setY(coorY);
		return reference;
	}

	/**
	 * 
	 * remove the reference edge for the given action
	 * 
	 * @param diagram
	 * @param role
	 * @param action
	 * @return
	 */
	public static ReferenceEdge removeReferenceEdge(Diagram diagram, Role role,
			Action action) {
		EList<ReferenceEdge> refEdgeList = getReference(diagram, role)
				.getReferenceEdges();
		ReferenceEdge edgeToRemove = null;
		for (ReferenceEdge refdge : refEdgeList) {
			if (refdge.getAction().equals(action)) {
				edgeToRemove = refdge;
			}
		}
		diagram.getReferenceEdges().remove(edgeToRemove);
		refEdgeList.remove(edgeToRemove);
		action.setPerformedBy(null);
		return edgeToRemove;
	}

	public static void removeRoleLayout(Diagram diagram, Role role) {
		LayoutData layoutdata = getRoleLayout(diagram, role);
		if (layoutdata != null) {
			GraphicalElement graphELe = layoutdata.getDescribesElement();
			EList<ReferenceEdge> refEdgeList = ((Reference) graphELe)
					.getReferenceEdges();
			diagram.getReferenceEdges().removeAll(refEdgeList);
			diagram.getReferences().remove(graphELe);
			diagram.getLayoutData().remove(layoutdata);
		}
	}

	public static void removeNodeLayout(Diagram diagram, GraphicalElement gEle) {
		LayoutData layoutdata = getNodeLayout(diagram, gEle);
		if (layoutdata != null) {
			diagram.getLayoutData().remove(layoutdata);
		}
	}

	/**
	 * set the reference edge between role and action
	 * 
	 * @param diagram
	 * @param activity
	 * @param role
	 * @param action
	 * @return
	 */
	public static ReferenceEdge setReferenceEdge(Diagram diagram,
			Activity activity, Role role, Action action) {
		Reference reference = getReference(diagram, role);
		ReferenceEdge referenceEdge = viewFactory.createReferenceEdge();
		referenceEdge.setReference(reference);
		referenceEdge.setContainedIn(activity);
		referenceEdge.setAction(action);
		action.setPerformedBy(role);
		diagram.getReferenceEdges().add(referenceEdge);
		reference.getReferenceEdges().add(referenceEdge);
		referenceEdge.setReference(reference);
		return referenceEdge;
	}
}
