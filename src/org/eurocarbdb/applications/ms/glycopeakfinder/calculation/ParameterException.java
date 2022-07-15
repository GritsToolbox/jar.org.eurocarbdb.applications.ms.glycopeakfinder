/**
 * 
 */
package org.eurocarbdb.applications.ms.glycopeakfinder.calculation;

/**
 * Exception for errors in parameter object
 * 
 * @author Logan
 */
public class ParameterException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public ParameterException(String string) 
	{
		super(string);
	}
}
