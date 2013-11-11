/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class MtextDebugMessage {
	
	private static final char DELIMITER = ':';
	private org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.EMtextDebugMessageTypes messageType;
	private String[] arguments;
	
	public MtextDebugMessage(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.EMtextDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public MtextDebugMessage(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.EMtextDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.EMtextDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextStringUtil.encode(DELIMITER, parts);
	}
	
	public static MtextDebugMessage deserialize(String response) {
		java.util.List<String> parts = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.EMtextDebugMessageTypes type = org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.EMtextDebugMessageTypes.valueOf(messageType);
		MtextDebugMessage message = new MtextDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(org.feature.multi.perspective.mapping.viewmapping.resource.mtext.debug.EMtextDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + org.feature.multi.perspective.mapping.viewmapping.resource.mtext.util.MtextStringUtil.explode(arguments, ", ") + "]";
	}
	
}
