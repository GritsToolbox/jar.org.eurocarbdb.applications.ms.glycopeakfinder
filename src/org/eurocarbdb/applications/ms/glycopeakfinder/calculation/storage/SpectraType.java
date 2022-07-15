package org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage;

import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.ParameterException;

/**
 * Stores the type of the spectra.
 * 
 * @author Logan
 *
 */
public enum SpectraType
{
    Profile("profile"),         // ms^1     nur profile ionen
    MS2("ms2"),                 // ms^2     precursor is profile, rest fragmented
    Fragmented("fragmented"),   // ms^>2    all ions are fragmented
    MSxMS("msxms");             //          completter run von ms^1 bis ms^x
    
    private String m_strFullname;

    /** Private constructor, see the forName methods for external use. */
    private SpectraType( String fullname)
    {
        this.m_strFullname = fullname;
    }

    /**
     * Gives the type of spectra
     * @return
     */
    public String getName() 
    {  
        return this.m_strFullname;  
    }

    /**
     * Gives a spetra type object for a name
     * 
     * @param type
     * @return
     * @throws ParameterException
     */
    public static SpectraType forName( String type ) throws ParameterException 
    {
        for ( SpectraType a : SpectraType.values() )
        {
            if ( type.equals(a.m_strFullname) )
            {
                return a;
            }
        }
        throw new ParameterException("Invalid value for spectra type.");
    }
}
