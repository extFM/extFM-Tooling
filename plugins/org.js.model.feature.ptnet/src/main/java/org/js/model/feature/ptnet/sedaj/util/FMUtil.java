/**
 * 
 */
package org.js.model.feature.ptnet.sedaj.util;

import hub.top.editor.ptnetLoLA.PtNet;

import org.js.model.feature.FeatureModel;
import org.js.model.feature.Group;

/**
 * Utility class for {@link FeatureModel}.
 * Used by the transformation from {@link FeatureModel} to {@link PtNet}.
 * @author Tim Winkelmann
 *
 */
public class FMUtil {
	
	/**
	 * Checks the for different group relations and returns the {@link GroupDefinition} of the {@link Group}.
	 * @param group the {@link Group} which group relation will be checked
	 * @return the {@link GroupDefinition} of the {@link Group}
	 */
	public static GroupDefinition getGroupDefinition(Group group){
		if (group.getMinCardinality() == group.getMaxCardinality() && group.getChildFeatures().size() == group.getMaxCardinality()) {
			return GroupDefinition.mandatory;
		}
		if (group.getMinCardinality() == 0 && group.getChildFeatures().size() == group.getMaxCardinality()) {
			return GroupDefinition.optional;
		}
		if (group.getMinCardinality() == 1 && group.getMaxCardinality() == 1) {
			return GroupDefinition.alternativ;
		}
		if (group.getMinCardinality() == 1 && group.getChildFeatures().size() == group.getMaxCardinality()) {
			return GroupDefinition.inclusivOr;
		}
		if (group.getMinCardinality() == 0 && group.getMaxCardinality() == 1) {
			return GroupDefinition.exclusivOptional;
		}
		return GroupDefinition.general;
	}
}
