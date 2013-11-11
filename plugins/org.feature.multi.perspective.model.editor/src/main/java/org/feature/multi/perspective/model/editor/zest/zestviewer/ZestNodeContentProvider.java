/**
 * 
 */
package org.feature.multi.perspective.model.editor.zest.zestviewer;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;
import org.feature.multi.perspective.model.editor.zest.model.FeatureNode;
import org.feature.multi.perspective.model.editor.zest.model.Node;

/**
 * @author winkelti
 *
 */
public class ZestNodeContentProvider  extends ArrayContentProvider  implements IGraphEntityContentProvider {

	@Override
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof Node && ! (entity instanceof FeatureNode)) {
			Node node = (Node) entity;
			return node.getConnectedTo().toArray();
		}
		if (entity instanceof FeatureNode) {
			return new Object[0];
		}
		throw new RuntimeException("Type not supported");
	}
}
