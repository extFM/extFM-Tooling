package org.feature.model.utilities;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * compare to models
 * 
 * 
 * @author Ingo Reimund
 * 
 */
public class ModelComparator {

	/**
	 * use MatchService and DiffModel to compare to model
	 * 
	 * @param object1
	 *            first object to compare
	 * @param object2
	 *            second object to compare
	 * @return true if both object equals else false
	 * @throws InterruptedException
	 */
	public boolean diff(EObject object1, EObject object2) throws InterruptedException {
//		MatchModel match = MatchService.doMatch(object1, object2, new HashMap<String, Object>());
//		DiffModel diff = DiffService.doDiff(match);
//		return diff.getDifferences().isEmpty();
		return EcoreUtil.equals(object1, object2);
	}
	
	/**
	 * use MatchService and DiffModel to compare to model
	 * 
	 * @param object1
	 *            first object to compare
	 * @param object2
	 *            second object to compare
	 * @return true if both object equals else false
	 * @throws InterruptedException
	 */
	public boolean unorderdDiff(EObject object1, EObject object2) throws InterruptedException {
//		MatchModel match = MatchService.doMatch(object1, object2, new HashMap<String, Object>());
//		List<UnmatchElement> remaining = new ArrayList<>(match.getUnmatchedElements());
//		while (!remaining.isEmpty() && remaining.size() % 2 == 0) {
//			UnmatchElement toFind = remaining.remove(0);
//			for (UnmatchElement element : remaining) {
//				if (element.getElement().toString().equals(toFind.getElement().toString())) {
//					remaining.remove(element);
//					break;
//				}
//
//			}
//		}
//		return match.getUnmatchedElements().isEmpty();
		return diff(object1, object2);
	}
}