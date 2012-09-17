/**
 * 
 */
package sedaj;

import hub.top.editor.ptnetLoLA.PtNet;

import org.js.model.feature.FeatureModel;

/**
 * 
 * Interface for the transformation of {@link FeatureModel} to {@link PtNet}.
 * Also provides a method to check the soundness.
 * @author Tim Winkelmann
 *
 */
public interface FMtoPtNet {
	
	/**
	 * creates a {@link PtNet} from the given {@link FeatureModel}.
	 * @param fm the {@link FeatureModel} which will be transformed.
	 * @return a {@link PtNet}
	 */
	public PtNet createPtNet(FeatureModel fm);
	
	/**
	 * checks is the given {@link PtNet} is sound.
	 * @param net the {@link PtNet} which will be checked.
	 */
	public void checkPtNet(PtNet net);
}
