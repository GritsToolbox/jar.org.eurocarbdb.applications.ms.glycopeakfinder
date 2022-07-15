/**
 * 
 */
package org.eurocarbdb.applications.ms.glycopeakfinder.calculation.util;

import java.util.Comparator;

import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.CalculationPeak;

/**
 * Comparator for the sorting of peaks
 * 
 * @author Logan
 */
public class ComparatorCalculationPeak implements Comparator<CalculationPeak>
{
	public int compare(CalculationPeak a_objPeakOne, CalculationPeak a_objPeakTwo) 
	{
		double t_dDelta = a_objPeakOne.getMz() - a_objPeakTwo.getMz(); 
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
