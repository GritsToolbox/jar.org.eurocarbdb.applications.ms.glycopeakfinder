/**
 * 
 */
package org.eurocarbdb.applications.ms.glycopeakfinder.calculation;

/**
 * Exception for errors in parameter parsing.
 * 
 * @author rene
 */
public class ParameterParsingException extends Exception
{
    private static final long serialVersionUID = 1L;

    public ParameterParsingException(String a_strMessage)
    {
        super(a_strMessage);
    }

    public ParameterParsingException()
    {
        super();
    }
}
