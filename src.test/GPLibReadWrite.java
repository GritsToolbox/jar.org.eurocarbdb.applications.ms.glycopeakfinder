import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.GlycoPeakfinder;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.ParameterException;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.ParameterParsingException;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.io.CalcParameterXml;
import org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage.CalculationParameter;
import org.jdom.JDOMException;

/**
 *
 */

/**
 * @author Logan
 *
 */
public class GPLibReadWrite
{

    /**
     * @param args
     * @throws IOException
     * @throws ParameterParsingException
     * @throws ParameterException
     * @throws JDOMException
     */
    public static void main(String[] args)
            throws IOException, JDOMException, ParameterException, ParameterParsingException
    {
        // load paramter
        File m_fInput = new File("c:\\workspace\\GPLib\\documentation\\Example.xml");
        CalcParameterXml t_objReader = new CalcParameterXml();
        CalculationParameter t_objParameter = t_objReader.importParameter(m_fInput);
        // calculation
        GlycoPeakfinder t_objCalculator = new GlycoPeakfinder();
        t_objParameter = t_objCalculator.calculate(t_objParameter);
        // export to file
        String t_strResult = t_objReader.exportParameter(t_objParameter);
        FileOutputStream m_fOutput = new FileOutputStream("c:\\workspace\\GPLib\\documentation\\Output.xml");
        m_fOutput.write(t_strResult.getBytes());
        m_fOutput.close();
    }

}
