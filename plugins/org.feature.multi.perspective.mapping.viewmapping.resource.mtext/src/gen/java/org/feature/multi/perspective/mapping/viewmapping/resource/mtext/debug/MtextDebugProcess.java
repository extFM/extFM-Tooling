/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug;

public class MtextDebugProcess extends org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.MtextDebugElement implements org.eclipse.debug.core.model.IProcess, org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.IMtextDebugEventListener {
	
	private org.eclipse.debug.core.ILaunch launch;
	
	private boolean terminated = false;
	
	public MtextDebugProcess(org.eclipse.debug.core.ILaunch launch) {
		super(launch.getDebugTarget());
		this.launch = launch;
	}
	
	public boolean canTerminate() {
		return !terminated;
	}
	
	public boolean isTerminated() {
		return terminated;
	}
	
	public void terminate() throws org.eclipse.debug.core.DebugException {
		terminated = true;
	}
	
	public String getLabel() {
		return null;
	}
	
	public org.eclipse.debug.core.ILaunch getLaunch() {
		return launch;
	}
	
	public org.eclipse.debug.core.model.IStreamsProxy getStreamsProxy() {
		return null;
	}
	
	public void setAttribute(String key, String value) {
	}
	
	public String getAttribute(String key) {
		return null;
	}
	
	public int getExitValue() throws org.eclipse.debug.core.DebugException {
		return 0;
	}
	
	public void handleMessage(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.MtextDebugMessage message) {
		if (message.hasType(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.EMtextDebugMessageTypes.TERMINATED)) {
			terminated = true;
		} else {
			// ignore other events
		}
	}
	
}
