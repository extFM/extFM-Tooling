/**
 * 
 */
package org.feature.multi.perspective.model.editor.zest.model;

import org.feature.multi.perspective.model.viewmodel.Group;


/**
 * @author winkelti
 *
 */
public class GroupNode extends Node{
	private Group group;
	
	public GroupNode(Group group) {
		super();
		this.group = group;
	}
	
	@Override
	public String getName() {
		return group.getName();
	}

	/**
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}
}
