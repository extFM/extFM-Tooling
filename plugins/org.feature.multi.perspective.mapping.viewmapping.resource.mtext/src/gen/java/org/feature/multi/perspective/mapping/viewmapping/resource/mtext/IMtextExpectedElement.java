/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IMtextExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.grammar.MtextSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement follower, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextPair<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[]>> getFollowers();
	
}
