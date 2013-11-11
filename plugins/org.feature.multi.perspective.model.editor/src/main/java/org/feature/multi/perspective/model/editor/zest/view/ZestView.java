/**
 * 
 */
package org.feature.multi.perspective.model.editor.zest.view;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.ui.ViewerPane;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.zest.core.viewers.AbstractZoomableViewer;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.viewers.IZoomableWorkbenchPart;
import org.eclipse.zest.core.widgets.Graph;
import org.eclipse.zest.core.widgets.GraphConnection;
import org.eclipse.zest.core.widgets.GraphNode;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.GridLayoutAlgorithm;
import org.feature.multi.perspective.mapping.viewmapping.MappingModel;
import org.feature.multi.perspective.model.viewmodel.GroupModel;
import org.feature.multi.perspective.model.editor.editors.ViewmodelMultiPageEditor;
import org.feature.multi.perspective.model.editor.editors.listeners.ViewPointNodeMouseListener;
import org.feature.multi.perspective.model.editor.util.Util;
import org.feature.multi.perspective.model.editor.zest.model.Node;
import org.feature.multi.perspective.model.editor.zest.model.NodeModelContentProvider;
import org.feature.multi.perspective.model.editor.zest.zestviewer.ZestLabelProvider;
import org.feature.multi.perspective.model.editor.zest.zestviewer.ZestNodeContentProvider;

/**
 * @author winkelti
 *
 */
public class ZestView  extends ViewerPane implements IZoomableWorkbenchPart {
	Logger log = Logger.getLogger(ZestView.class);
	private GraphViewer viewer;
	private ViewmodelMultiPageEditor multiPageEditor;
	private NodeModelContentProvider nodeModelContentProvider;
	
	/**
	 * 
	 * @param model
	 */
	public ZestView(IWorkbenchPage page, IWorkbenchPart part, Composite parent, ViewmodelMultiPageEditor multiPageEditor) {
		super(page, part);
		this.multiPageEditor = multiPageEditor;
	}

	@Override
	public Viewer createViewer(Composite composite) {
		viewer = new GraphViewer(composite, SWT.BORDER);
		viewer.setContentProvider(new ZestNodeContentProvider());
		viewer.setLabelProvider(new ZestLabelProvider(this));
		LayoutAlgorithm layout = setLayout();
		viewer.setLayoutAlgorithm(layout, true);
		viewer.applyLayout();
		viewer.addDoubleClickListener(new ViewPointNodeMouseListener(multiPageEditor));
		return viewer;
	}
	
	@Override
	public void requestActivation() {
		super.requestActivation();
		multiPageEditor.setCurrentViewerPane(this);
	}
	
	private LayoutAlgorithm setLayout() {
		LayoutAlgorithm layout;
		// layout = new
//		layout = new SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
//		layout = new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		 layout = new
		 GridLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
//		 layout = new
//		 HorizontalTreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
//		 layout = new
//		 RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		return layout;
	}
	
	/** 
	 * Passing the focus request to the viewer's control. 
	 */
	public void setFocus() {
		
	}

	@Override
	public AbstractZoomableViewer getZoomableViewer() {
		return viewer;
	}
	
	/**
	 * 
	 * @param res
	 */
	public void init(Resource res){
		EList<EObject> contents = res.getContents();
		MappingModel featureMappingModel = null;
		for (EObject eObject : contents) {
			if (eObject instanceof MappingModel) {
			   featureMappingModel = (MappingModel) eObject;
				break;
			}
		}
		if (featureMappingModel == null) {
			log.error("Could not find a mapping.");
			return;
		}
		GroupModel groupModel = featureMappingModel.getViewModel();
		if (groupModel == null) {
			log.error("Could not find a Groupmodel in the mapping.");
			return;
		}
		if (featureMappingModel != null && groupModel != null) {
			nodeModelContentProvider = new NodeModelContentProvider(featureMappingModel,groupModel);
			this.getViewer().setInput(nodeModelContentProvider.getNodes());
		}
	}
	
	/**
	 * highlight the nodes after reversing the highlighting the old ones.
	 * @param nodesForHighlighting nodes for highlighting
	 * @param connectionsForHighting 
	 */
	public void highlightNodes(List<Node> nodesForHighlighting) {
		clearHighlighting();
		Control control = this.getViewer().getControl();
		if (control instanceof Graph) {
			Graph graph = (Graph) control;
			@SuppressWarnings("rawtypes")
			List nodes = graph.getNodes();
			for (Object object : nodes) {
				if (object instanceof GraphNode) {
					GraphNode graphNode = (GraphNode) object;
					if (nodesForHighlighting.contains(graphNode.getData())) {
						Util.attachedGraphNodes.add(graphNode);
					}
				}
			}
			for (GraphNode graphNode : Util.attachedGraphNodes) {
				graphNode.setBackgroundColor(Util.attachedGraphNodeBackgroundColor);
			}
			@SuppressWarnings("rawtypes")
			List connections = graph.getConnections();
			for (Object object : connections) {
				if (object instanceof GraphConnection) {
					GraphConnection graphConnection = (GraphConnection) object;
					GraphNode source = graphConnection.getSource();
					GraphNode destination = graphConnection.getDestination();
					if (source.getBackgroundColor().equals(Util.attachedGraphNodeBackgroundColor) && 
							destination.getBackgroundColor().equals(Util.attachedGraphNodeBackgroundColor)) {
						Util.highlightedGraphConnections.add(graphConnection);
						graphConnection.setLineColor(Util.attachedGraphConnectionLineColor);
						graphConnection.setLineWidth(2);
					}
				}
			}
		}
	}
	
	/**
	 * clears the highlighting.
	 */
	public void clearHighlighting() {
		//check for disposed widgets
		if ((Util.highlightedGraphConnections.size() > 0 && Util.highlightedGraphConnections.get(0).isDisposed()) ||
			(Util.attachedGraphNodes.size() > 0 && Util.attachedGraphNodes.get(0).isDisposed())) {
			Util.highlightedGraphConnections.clear();
			Util.attachedGraphNodes.clear();
			return;
		}
		for (GraphConnection graphConnection : Util.highlightedGraphConnections) {
			graphConnection.setLineWidth(1);
			graphConnection.setLineColor(Util.unattachedGraphConnectionLineColor);
		}
		for (GraphNode graphNode : Util.attachedGraphNodes) {
			graphNode.setBackgroundColor(Util.unattachedGraphNodeBackgroundColor);
		}
		Util.highlightedGraphConnections.clear();
		Util.attachedGraphNodes.clear();
	}
}
