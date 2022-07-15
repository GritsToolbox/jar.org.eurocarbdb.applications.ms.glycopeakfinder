/**
 * 
 */
package org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage;

/**
 * Stores the settings for an ion.
 * - id(name) of the ion
 * - mass of the ion
 * - charge of the ion
 * 
 * @author Logan
 */
public class CalculationIon 
{
    private String m_strID = null;
    private double m_dMass = 0;
    private Integer m_iCharge = 1;
    
    /**
     * Default constructor
     */
    public CalculationIon()
    {
    	super();
    }
    
    /**
     * Constructor
     * 
     * @param a_strID name of the ion
     * @param a_dMass mass of the ion
     * @param a_iCharge charge of the ion
     */
    public CalculationIon(String a_strID,double a_dMass, int a_iCharge )
    {
    	this.m_strID = a_strID;
    	this.m_dMass = a_dMass;
    	this.m_iCharge = a_iCharge;
    }
    
    /**
     * Sets charge of the ion
     * 
     * @param a_iCharge
     */
    public void setCharge(Integer a_iCharge)
    {
    	this.m_iCharge = a_iCharge;
    }
    
    /**
     * Gives charge of the ion
     * 
     * @return
     */
    public Integer getCharge()
    {
    	return this.m_iCharge;
    }
    
    /**
     * Sets id(name) of the ion
     * 
     * @param a_strId
     */
    public void setId(String a_strId)
    {
        this.m_strID = a_strId;
    }
    
    /**
     * Gives id(name) of the ion
     * 
     * @return
     */
    public String getId()
    {
        return this.m_strID;
    }
    
    /** 
     * Sets mass of the ion
     * 
     * @param a_dMass
     */
    public void setMass(double a_dMass)
    {
        this.m_dMass = a_dMass;
    }
    
    /**
     * Gives mass of the ion
     * 
     * @return
     */
    public double getMass()
    {
        return this.m_dMass;
    }
}