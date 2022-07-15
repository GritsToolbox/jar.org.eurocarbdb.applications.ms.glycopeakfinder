/**
 * 
 */
package org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage;

/**
 * Stores the settings of a residue.
 * Only used intern for calculation 
 * 
 * @author Logan
 */
public class ResidueSpecial extends CalculationMolecule
{
	/** 
	 * Current number of this residue
	 */
	public int m_iCurrent = 0;
	
	/**
	 * Number of this residue comming from fragments 
	 */
	public int m_iFragment = 0;

	/**
	 * Default constructor
	 */
	public ResidueSpecial()
    {
        super();        
    }
    
	/**
	 * Constructor
	 * 
	 * @param a_strID id(name) of the residue
	 * @param a_dMass mass of the residue
	 * @param a_iMin min occurrence of the residue
	 * @param a_iMax max occurrence of the residue
	 */
    public ResidueSpecial( String a_strID , double a_dMass, int a_iMin, int a_iMax)
    {
        super(a_strID,a_dMass,a_iMin,a_iMax);
    }
    
    /**
     * Constructor
     * 
     * @param a_objMol
     */
    public ResidueSpecial(CalculationMolecule a_objMol)
    {
    	super(a_objMol.getId(),a_objMol.getMass(),a_objMol.getMin(),a_objMol.getMax());
    }
    
}