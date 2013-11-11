/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.feature.multi.perspective.mapping.viewmapping.resource.mtext;

/**
 * A simple interface for generic functions with one argument.
 */
public interface IMtextFunction1<ReturnType, ArgumentType1> {
	
	public ReturnType execute(ArgumentType1 argument1);
}
