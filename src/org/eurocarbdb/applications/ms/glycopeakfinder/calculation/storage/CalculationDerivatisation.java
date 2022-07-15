/**
 * 
 */
package org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage;

/**
 * Stores the settings for a derivatisation.
 * - name of the derivatisation
 * - mass
 * 
 * @author Logan
 *
 */
public class CalculationDerivatisation 
{
    private String m_strID = null;
    private double m_dMass = 0;

    /**
     * Default constructor
     */
    public CalculationDerivatisation()
    {
    	super();
    }
    
    /**
     * Constructor 
     * 
     * @param a_strId	name of the derivatisation
     * @param a_dMass	mass of the derivatisation
     */
    public CalculationDerivatisation(String a_strId, double a_dMass)
    {
    	this.m_strID = a_strId;
    	this.m_dMass = a_dMass;
    }
    
    /**
     * Sets the name of the derivatisation.
     * 
     * @param a_strId
     */
    public void setId(String a_strId)
    {
        this.m_strID = a_strId;
    }
    
    /**
     * Gives the name of the derivatisation
     * 
     * @return
     */
    public String getId()
    {
        return this.m_strID;
    }
    
    /**
     * Sets the mass of the derivatisation
     * 
     * @param a_dMass
     */
    public void setMass(double a_dMass)
    {
        this.m_dMass = a_dMass;
    }
    
    /**
     * Gives the name of the derivatisation
     * 
     * @return
     */
    public double getMass()
    {
        return this.m_dMass;
    }
}