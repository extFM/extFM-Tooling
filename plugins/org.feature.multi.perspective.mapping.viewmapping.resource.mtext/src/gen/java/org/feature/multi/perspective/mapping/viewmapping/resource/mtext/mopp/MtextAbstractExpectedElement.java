/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class MtextAbstractExpectedElement implements org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextPair<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[]>> followers = new java.util.LinkedHashSet<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextPair<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[]>>();
	
	public MtextAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement follower, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[] path) {
		followers.add(new org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextPair<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextPair<org.feature.multi.perspective.mapping.viewmapping.resource.mtext.IMtextExpectedElement, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
