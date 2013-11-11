/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug;

public abstract class MtextDebugElement extends org.eclipse.debug.core.model.DebugElement {
	
	/**
	 * Constructs a new debug element in the given target.
	 */
	public MtextDebugElement(org.eclipse.debug.core.model.IDebugTarget target) {
		super(target);
	}
	
	public String getModelIdentifier() {
		return org.feature.multi.perspective.mapping.viewmapping.resource.mtext.mopp.MtextPlugin.DEBUG_MODEL_ID;
	}
	
	/**
	 * Returns the breakpoint manager.
	 * 
	 * @return the breakpoint manager
	 */
	protected org.eclipse.debug.core.IBreakpointManager getBreakpointManager() {
		return org.eclipse.debug.core.DebugPlugin.getDefault().getBreakpointManager();
	}
	
}
