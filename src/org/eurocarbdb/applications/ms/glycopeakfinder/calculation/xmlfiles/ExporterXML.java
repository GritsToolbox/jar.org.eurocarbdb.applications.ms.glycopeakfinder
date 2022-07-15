/**
 * 
 */
package org.eurocarbdb.applications.ms.glycopeakfinder.calculation.xmlfiles;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Logan
 *
 */
public class ExporterXML 
{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException 
	{
		DBInterface t_objDB = new DBInterface();
		GeneratorFragment t_objFragments = new GeneratorFragment();
//		t_objFragments.export(t_objDB,args[0]);
		t_objFragments.export(t_objDB,"c:/residue_fragments.xml");
		GeneratorDefault t_objDefault = new GeneratorDefault();
//		t_objDefault.export(t_objDB,args[1]);
		t_objDefault.export(t_objDB,"c:/default_masses.xml");
	}

}
