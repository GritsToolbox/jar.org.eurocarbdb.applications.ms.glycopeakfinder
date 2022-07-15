import java.util.ArrayList;
import java.util.Iterator;

import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.GlycoPeakfinder;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.io.CalcParameterXml;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.CalculationDerivatisation;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.CalculationFragment;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.CalculationIon;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.CalculationMolecule;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.CalculationParameter;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.CalculationPeak;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.PeakAnnotation;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.Persubstitution;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.Scan;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.SpectraType;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.util.DefaultMasses;

/**
 *
 */

/**
 * @author rene
 *
 */
public class GPLibTest
{

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        CalculationParameter t_objParameter = new CalculationParameter();
        DefaultMasses t_objDefaultMasses = new DefaultMasses();
        /*************************************************************
         * Global settings.
         *************************************************************/
        // Monoisotopic
        boolean t_bMonoisotopic = true;
        // no persubstitution
        Persubstitution t_objPerSubst = Persubstitution.None;
        /*************************************************************
         * Set parameter for calculation.
         *************************************************************/
        // type
        t_objParameter.setSpectraType(SpectraType.Fragmented);
        // accuracy
        t_objParameter.setAccuracy(1000.0);
        t_objParameter.setAccuracyPpm(true);
        // mass shift
        t_objParameter.setMassShift(0);
        // spectra/scan
        Scan t_objScan = new Scan();
        t_objScan.setId(1);
        t_objScan.setPrecursorMass(null);
        ArrayList<CalculationPeak> t_aPeaks = new ArrayList<>();
        t_aPeaks.add(new CalculationPeak(663.222, 0));
        t_aPeaks.add(new CalculationPeak(527.158, 0));
        t_objScan.setPeaks(t_aPeaks);
        t_objParameter.setScan(t_objScan);
        // subscan
        Scan t_objSubScan = new Scan();
        t_objSubScan.setId(2);
        t_objSubScan.setPrecursorMass(527.158);
        t_aPeaks = new ArrayList<>();
        t_aPeaks.add(new CalculationPeak(365.105, 0, 2));
        t_aPeaks.add(new CalculationPeak(481.15, 0));
        t_aPeaks.add(new CalculationPeak(527.158, 0));
        t_objSubScan.setPeaks(t_aPeaks);
        t_objScan.addSubScan(t_objSubScan);
        // residues
        ArrayList<CalculationMolecule> t_aResidues = new ArrayList<>();
        t_aResidues.add(new CalculationMolecule("Hex",
                t_objDefaultMasses.getResidueMass("hex", t_objPerSubst, t_bMonoisotopic), 0, 10));
        t_objParameter.setResidues(t_aResidues);
        // ions
        ArrayList<CalculationIon> t_aIons = new ArrayList<>();
        t_aIons.add(new CalculationIon("Na+", t_objDefaultMasses.getIonMass("na+", t_bMonoisotopic), 1));
        t_objParameter.setIons(t_aIons);
        // charges
        ArrayList<Integer> t_aCharges = new ArrayList<>();
        t_aCharges.add(1);
        t_aCharges.add(2);
        t_objParameter.setCharges(t_aCharges);
        // ion exchange
        ArrayList<CalculationIon> t_aIonExchange = new ArrayList<>();
        t_aIonExchange.add(new CalculationIon("Na+", t_objDefaultMasses.getIonMass("na+", t_bMonoisotopic), 1));
        t_objParameter.setIonExchangeIon(t_aIonExchange);
        // number of exchanges
        ArrayList<Integer> t_aExchangeNumbers = new ArrayList<>();
        t_aExchangeNumbers.add(1);
        t_objParameter.setIonExchangeCount(t_aExchangeNumbers);
        // reducing fragments
        ArrayList<CalculationFragment> t_aFragmentsRed = new ArrayList<>();
        t_aFragmentsRed.add(
                new CalculationFragment("C", null, t_objDefaultMasses.getGlycosidicFragmentMass("c", t_bMonoisotopic)));
        t_aFragmentsRed.add(new CalculationFragment("a-hex-1-4", "Hex",
                t_objDefaultMasses.getCrossringFragmentMass("A", t_objPerSubst, t_bMonoisotopic, "hex", 1, 4)));
        t_objParameter.setFragmentsRed(t_aFragmentsRed);
        // non reducing fragments
        ArrayList<CalculationFragment> t_aFragmentsNonRed = new ArrayList<>();
        t_aFragmentsNonRed.add(
                new CalculationFragment("Y", null, t_objDefaultMasses.getGlycosidicFragmentMass("y", t_bMonoisotopic)));
        t_aFragmentsNonRed.add(new CalculationFragment("x-hex-2-5", "Hex",
                t_objDefaultMasses.getCrossringFragmentMass("X", t_objPerSubst, t_bMonoisotopic, "hex", 2, 5)));
        t_objParameter.setFragmentsNonRed(t_aFragmentsNonRed);
        // number of fragmentation
        ArrayList<Integer> t_aMultiFragments = new ArrayList<>();
        t_aMultiFragments.add(1);
        t_objParameter.setMultiFragments(t_aMultiFragments);
        // derivatisation = Modification at the reducing end ... also none must
        // be set
        ArrayList<CalculationDerivatisation> t_aDerivates = new ArrayList<>();
        t_aDerivates.add(new CalculationDerivatisation("PA",
                t_objDefaultMasses.getDerivatisationMass("pa", t_objPerSubst, t_bMonoisotopic)));
        t_objParameter.setDerivatisation(t_aDerivates);
        // gain
        ArrayList<CalculationMolecule> t_aGain = new ArrayList<>();
        t_aGain.add(new CalculationMolecule("H2O", t_objDefaultMasses.getMoleculeMass("h2o", t_bMonoisotopic), 0, 2));
        t_objParameter.setGainMolecules(t_aGain);
        // loss
        ArrayList<CalculationMolecule> t_aLoss = new ArrayList<>();
        t_aLoss.add(new CalculationMolecule("H2O", t_objDefaultMasses.getMoleculeMass("h2o", t_bMonoisotopic), 0, 1));
        t_objParameter.setLossMolecules(t_aLoss);
        // completion
        t_objParameter.setCompletionNonRed(t_objDefaultMasses.getCompletionMass("red", t_objPerSubst, t_bMonoisotopic));
        t_objParameter.setCompletionRed(t_objDefaultMasses.getCompletionMass("nonred", t_objPerSubst, t_bMonoisotopic));
        t_objParameter
                .setNonReducingDifference(t_objDefaultMasses.getNonReducingDifference(t_objPerSubst, t_bMonoisotopic));
        t_objParameter.setExchangeIonMass(t_objDefaultMasses.getExchangeIonMass(t_bMonoisotopic));
        /*************************************************************
         * Serialize parameter to XML
         *************************************************************/
        CalcParameterXml t_objXML = new CalcParameterXml();
        String t_strXML = t_objXML.exportParameter(t_objParameter);
        /*************************************************************
         * Load parameter from XML
         *************************************************************/
        // t_objParameter = t_objXML.importParameter(t_strXML);
        // t_strXML = t_objXML.exportParameter(t_objParameter);
        /*************************************************************
         * Start calculation
         *************************************************************/
        GlycoPeakfinder t_objCalculator = new GlycoPeakfinder();
        t_objParameter = t_objCalculator.calculate(t_objParameter);
        /*************************************************************
         * Serialize result to XML
         *************************************************************/
        t_strXML = t_objXML.exportParameter(t_objParameter);
        System.out.println(t_strXML);

        /*****************************
         * Cycle through the results
         *
         */

        Scan t_Scan = t_objParameter.getScan();
        for (Iterator iter = t_Scan.getPeaks().iterator(); iter.hasNext();)
        {
            // get each peak
            CalculationPeak peak = (CalculationPeak) iter.next();
            for (Iterator iter2 = peak.getAnnotation().iterator(); iter2.hasNext();)
            {
                // get all annotations for the peak
                PeakAnnotation anno = (PeakAnnotation) iter2.next();
                // get list of residues (composition)
                anno.getResidues();
                // gives you a list of AnnotationEntities (AE)
                // each has a getId() and getNumber()
                // id corespond with the id of the settings (id of the residue,
                // id of the ion, id of the fragment ....)
                // number is the occurency
            }
        }
    }
}
