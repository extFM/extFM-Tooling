/**
 * 
 */
package org.feature.multi.perspective.model.editor.zest.model;

import org.featuremapper.models.feature.Feature;

/**
 * @author winkelti
 *
 */
public class FeatureNode extends Node{
	private Feature feature;
	
	/**
	 * @param feature
	 */
	public FeatureNode(Feature feature) {
		super();
		this.feature = feature;
	}

	@Override
	public String getName() {
		return feature.getName();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((feature == null) ? 0 : feature.hashCode());
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
		FeatureNode other = (FeatureNode) obj;
		if (feature == null) {
			if (other.feature != null)
				return false;
		} else if (!feature.equals(other.feature))
			return false;
		return true;
	}

	/**
	 * @return the feature
	 */
	public Feature getFeature() {
		return feature;
	}
}