/**
 * 
 */
package sedaj.util;

import org.js.model.feature.FeatureModel;

/**
 * Describes the different group relations of a {@link FeatureModel}.
 * @author Tim Winkelmann
 *
 */
public enum GroupDefinition {
	mandatory, optional, alternativ, inclusivOr, exclusivOptional, general;
}
