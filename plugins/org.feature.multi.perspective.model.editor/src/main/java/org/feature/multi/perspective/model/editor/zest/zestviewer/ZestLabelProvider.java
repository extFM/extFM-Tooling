/**
 * 
 */
package org.feature.multi.perspective.model.editor.zest.zestviewer;


import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.feature.multi.perspective.model.viewmodel.provider.ViewmodelEditPlugin;
import org.feature.multi.perspective.model.editor.zest.model.Connection;
import org.feature.multi.perspective.model.editor.zest.model.CoreGroupNode;
import org.feature.multi.perspective.model.editor.zest.model.FeatureNode;
import org.feature.multi.perspective.model.editor.zest.model.GroupNode;
import org.feature.multi.perspective.model.editor.zest.model.Node;
import org.feature.multi.perspective.model.editor.zest.model.ViewPointNode;
import org.feature.multi.perspective.model.editor.zest.view.ZestView;

/**
 * @author winkelti
 *
 */
public class ZestLabelProvider  extends LabelProvider {
	ZestView zestView;
	ExtendedImageRegistry extendedImageRegistry;
	
	public ZestLabelProvider(ZestView zestView) {
		this.zestView = zestView;
		extendedImageRegistry = new ExtendedImageRegistry(zestView.getControl().getDisplay());
	}
	
	@Override
	public String getText(Object element) {
		if (element instanceof Node) {
			Node node = (Node) element;
			return node.getName();
		}
//		// Not called with the IGraphEntityContentProvider
		if (element instanceof Connection) {
			Connection myConnection = (Connection) element;
			return myConnection.getLabel();
		}
		if (element instanceof EntityConnectionData) {
			EntityConnectionData test = (EntityConnectionData) element;
			return "";
		}
		throw new RuntimeException("Wrong type: "
				+ element.getClass().toString());
	}
	
	/**
	 * This returns DefaultGroup.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Image getImage(Object object) {
		if (object instanceof CoreGroupNode) {
			Object obj = getResourceLocator().getImage("full/obj16/CoreGroup");
			Image image = extendedImageRegistry.getImage(obj);
			return image;
		}
		if (object instanceof GroupNode) {
			Object obj = getResourceLocator().getImage("full/obj16/Group");
			Image image = extendedImageRegistry.getImage(obj);
			return (Image) image;
		}
		if (object instanceof ViewPointNode) {
			Object obj = getResourceLocator().getImage("full/obj16/ViewPoint");
			Image image = extendedImageRegistry.getImage(obj);
			return (Image) image;
		}
		if (object instanceof FeatureNode) {
			Object obj = getResourceLocator().getImage("full/obj16/Feature");
			Image image = extendedImageRegistry.getImage(obj);
			return (Image) image;
		}
		return super.getImage(object);
	}
	
	public ResourceLocator getResourceLocator() {
		return ViewmodelEditPlugin.INSTANCE;
	}
}
