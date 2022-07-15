package org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage;

import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.ParameterException;

/**
 * Object for the persubstitution type
 * 
 * @author Logan
 */
public enum Persubstitution
{
    None("none","none"),
    Me("pm","per-methylation"),
    DMe("pdm","per-deutero-methylation"),
    Ac("pac","per-acetylation"),
    DAc("pdac","per-deutero-acetylation");
    
    private String m_strFullname;
    private String m_strSymbol;

    /** 
     * Private constructor, see the forName methods for external use. 
     */
    private Persubstitution( String symbol,String fullname)
    {
        this.m_strFullname = fullname;
        this.m_strSymbol = symbol;
    }

    /**
     * Gives name of the persubstitution
     * 
     * @return
     */
    public String getName() 
    {  
        return this.m_strFullname;  
    }
    
    /** 
     * Gives the abbr. of the  
     * @return
     */
    public String getAbbr()
    {
    	return this.m_strSymbol;
    }

    /**
     * Gives a persubstitution object for an abbr.
     * 
     * @param type
     * @return
     * @throws ParameterException
     */
    public static Persubstitution forAbbr( String type ) throws ParameterException 
    {
        for ( Persubstitution a : Persubstitution.values() )
        {
            if ( type.equalsIgnoreCase(a.m_strSymbol) )
            {
                return a;
            }
        }
        throw new ParameterException("Invalid value for persubstitution.");
    }
}
