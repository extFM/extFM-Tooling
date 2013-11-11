/**
 * 
 */
package org.feature.multi.perspective.model.edit.log4J;

import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;

/**
 * Log4JAppender for the eclipse runtime console.
 * @author Tim Winkelmann
 *
 */
public class Log4JAppender extends WriterAppender {
	/**
	 * name of the console.
	 */
	public static final String consoleName = "Cluster";
	
	/**
	 * creates the Log4JAppender.
	 */
	public Log4JAppender() {
		super(new SimpleLayout(), findConsole(consoleName).newMessageStream());
	}
	
	
	/**
	 * fins a console by a name.
	 * 
	 * @param name use the {@link Util}.consoleName
	 * @return a Console
	 */
	public static MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}
}
