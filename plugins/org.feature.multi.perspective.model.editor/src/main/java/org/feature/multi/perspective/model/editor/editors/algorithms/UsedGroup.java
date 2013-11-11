/**
 * 
 */
package org.feature.multi.perspective.model.editor.editors.algorithms;


import java.util.HashSet;
import java.util.Set;

import org.feature.multi.perspective.model.viewmodel.AbstractGroup;
import org.feature.multi.perspective.model.viewmodel.Group;
import org.featuremapper.models.feature.Feature;

/**
 * @author Tim Winkelmann
 *
 */
public class UsedGroup {
	private UsedGroup parentGroup;
	private AbstractGroup group;
	private Set<Feature> features = new HashSet<Feature>();
	private boolean consistent = false;
	private boolean done = false;
	
	/**
	 * @param parentGroup
	 * @param group
	 * @param features
	 */
	public UsedGroup(UsedGroup parentGroup,
	                 AbstractGroup group, Set<Feature> features) {
		super();
		this.parentGroup = parentGroup;
		this.group = group;
		this.features = features;
	}

	
	
	/**
	 * @return the parentGroup
	 */
	public UsedGroup getParentGroup() {
		return parentGroup;
	}
	/**
	 * @param parentGroup the parentGroup to set
	 */
	public void setParentGroup(UsedGroup parentGroup) {
		this.parentGroup = parentGroup;
	}
	/**
	 * @return the group
	 */
	public AbstractGroup getGroup() {
		return group;
	}
	/**
	 * @param group the group to set
	 */
	public void setGroup(AbstractGroup group) {
		this.group = group;
	}
	/**
	 * @return the done
	 */
	public boolean isDone() {
		return done;
	}
	
	/**
	 * @param done the done to set
	 */
	public void setDone() {
		this.done = true;
	}

	/**
	 * @return the consistent
	 */
	public boolean isConsistent() {
		return consistent;
	}

	/**
	 * @param consistent the consistent to set
	 */
	public void setConsistent(boolean consistent) {
		this.consistent = consistent;
	}
	
	/**
	 * @return the features
	 */
	public Set<Feature> getFeatures() {
		return features;
	}
	
	/**
	 * @param features the features to set
	 */
	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsedGroup other = (UsedGroup) obj;
		if (group == null) {
			if (other.group != null)
				return false;
		} else if (!group.equals(other.group))
			return false;
		return true;
	}
}
