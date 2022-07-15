/**
 * 
 */
package org.eurocarbdb.applications.ms.glycopeakfinder.calculation.util;

import java.util.Comparator;

import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.CalculationMolecule;


/**
 * @author Logan
 *
 */
public class ComparatorMolecule implements Comparator<CalculationMolecule>
{
	/**
	 * @see java.util.Comparator#compare(T, T)
	 */
	public int compare(CalculationMolecule a_objPeakOne, CalculationMolecule a_objPeakTwo) 
	{
		double t_dDelta = a_objPeakOne.getMass() - a_objPeakTwo.getMass(); 
		if ( t_dDelta < 0 )
		{
			return -1;
		}
		if ( t_dDelta > 0 )
		{
			return 1;
		}		
		return 0;
	}
	
}
