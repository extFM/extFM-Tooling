/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors.listeners;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphNode;
import org.feature.multi.perspective.model.viewmodel.Group;
import org.feature.multi.perspective.model.editor.editors.ViewmodelMultiPageEditor;
import org.feature.multi.perspective.model.editor.util.Util;
import org.feature.multi.perspective.model.editor.zest.model.CoreGroupNode;
import org.feature.multi.perspective.model.editor.zest.model.FeatureNode;
import org.feature.multi.perspective.model.editor.zest.model.GroupNode;
import org.feature.multi.perspective.model.editor.zest.model.Node;
import org.feature.multi.perspective.model.editor.zest.model.ViewPointNode;

/**
 * @author winkelti
 *
 */
public class ViewPointNodeMouseListener implements IDoubleClickListener {
	private ViewmodelMultiPageEditor multiPageEditor;
	private List<Node> nodesForHighlighting;
	
	public ViewPointNodeMouseListener(ViewmodelMultiPageEditor multiPageEditor) {
		this.multiPageEditor = multiPageEditor;
	}

	@Override
	public void doubleClick(DoubleClickEvent event) {
		ISelection selection = event.getSelection();
		Viewer viewer = event.getViewer();
		List selectedNodes = null;
		if (viewer instanceof GraphViewer) {
			GraphViewer graphViewer = (GraphViewer) viewer;
			Graph graph = graphViewer.getGraphControl();
			selectedNodes = graph.getSelection();
		}
		if (!selection.isEmpty()) {
			if (selection instanceof StructuredSelection) {
				StructuredSelection ss = (StructuredSelection) selection;
				if (ss.size() == 1) {
					Object firstElement = ss.getFirstElement();
					if (firstElement instanceof Node) {
						Node node = (Node) firstElement;
						for (Object object : selectedNodes) {
							if (object instanceof GraphNode) {
								GraphNode selectedNode = (GraphNode) object;
								if (selectedNode.getBackgroundColor().equals(Util.attachedGraphNodeBackgroundColor) && 
										selectedNode.getData().equals(node)) {
									multiPageEditor.clearHighlighting();
									return;
								}
							}
						}
					}
					if (firstElement instanceof ViewPointNode) {
						ViewPointNode viewPointNode = (ViewPointNode) firstElement;
						List<Node> connectedTo = viewPointNode.getConnectedTo();
						nodesForHighlighting = collectAllImportantNodes(connectedTo);
						nodesForHighlighting.add(viewPointNode);
						multiPageEditor.highlightNodes(nodesForHighlighting);
					}else if (firstElement instanceof GroupNode) {
						GroupNode groupNode = (GroupNode) firstElement;
						nodesForHighlighting = collectAllImportantNodes(fetchAllImportantNodes(groupNode));
						nodesForHighlighting.add(groupNode);
						multiPageEditor.highlightNodes(nodesForHighlighting);
					}else if (firstElement instanceof CoreGroupNode) {
						CoreGroupNode groupNode = (CoreGroupNode) firstElement;
						List<Node> connectedTo2 = groupNode.getConnectedTo();
						nodesForHighlighting = new LinkedList<Node>();
						for (Node node2 : connectedTo2) {
							if (node2 instanceof FeatureNode) {
								FeatureNode featureNode = (FeatureNode) node2;
								nodesForHighlighting.add(featureNode);
							}
						}
						nodesForHighlighting.add(groupNode);
						multiPageEditor.highlightNodes(nodesForHighlighting);
					}else{
						multiPageEditor.clearHighlighting();
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @param connectedTo
	 * @return
	 */
	private List<Node> collectAllImportantNodes(List<Node> connectedTo) {
		List<Node> nodesForHighlighting = new LinkedList<Node>();
		for (Node node : connectedTo) {
			if (node instanceof GroupNode) {
				GroupNode groupNode = (GroupNode) node;
				nodesForHighlighting.addAll(fetchAllImportantNodes(groupNode));
			}
			if (node instanceof CoreGroupNode) {
				List<Node> connectedTo2 = node.getConnectedTo();
				for (Node node2 : connectedTo2) {
					if (node2 instanceof FeatureNode) {
						FeatureNode featureNode = (FeatureNode) node2;
						nodesForHighlighting.add(featureNode);
					}
				}
			}
			nodesForHighlighting.add(node);
		}
		return nodesForHighlighting;
	}
	
	/**
	 * 
	 * @param groupNode
	 * @return
	 */
	private List<Node> fetchAllImportantNodes(GroupNode groupNode) {
		List<Node> nodesForHighlighting = new LinkedList<Node>();
		List<Node> connectedTo2 = groupNode.getConnectedTo();
		for (Node node2 : connectedTo2) {
			if (node2 instanceof FeatureNode) {
				FeatureNode featureNode = (FeatureNode) node2;
				nodesForHighlighting.add(featureNode);
			}
			if (node2 instanceof GroupNode) {
				GroupNode connectedGroupNode = (GroupNode) node2;
				if (isParent(groupNode,connectedGroupNode)) {
					nodesForHighlighting.add(connectedGroupNode);
					nodesForHighlighting.addAll(fetchAllImportantNodes(connectedGroupNode));
				}
			}
		}
		return nodesForHighlighting;
	}
	
	/**
	 * 
	 * @param groupNode
	 * @param connectedGroupNode
	 * @return
	 */
	private boolean isParent(GroupNode groupNode, GroupNode connectedGroupNode) {
		String name = connectedGroupNode.getName();
		EObject eContainer = groupNode.getGroup().eContainer();
		if (eContainer instanceof Group) {
			Group gn = (Group) eContainer;
			if (gn.getName().equals(name)) {
				return true;
			} 
		}
		return false;
	}
}
