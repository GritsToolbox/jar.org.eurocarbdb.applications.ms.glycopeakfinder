/**
 * 
 */
package org.eurocarbdb.applications.ms.glycopeakfinder.calculation.xmlfiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Logan
 *
 */
public class DBInterface
{
	private Connection m_objDB;
	private String m_strSchema = "glycopeakfinder";

	public DBInterface() throws ClassNotFoundException, SQLException 
	{
		String t_database_ip = "193.174.61.146";
		String t_database_driver = "jdbc:postgresql";
		String t_database_user = "postgres";
		String t_database_pw = "postgres";
		String t_database_name = "glycopeakfinder";
		String t_database_port = "5432";
		
		t_database_ip = "127.0.0.1";
		
        this.m_strSchema = "glycopeakfinder";
        
		Class.forName("org.postgresql.Driver");
		
		String t_strURL = t_database_driver + "://" + t_database_ip + ":"
		+ t_database_port + "/" + t_database_name;
		// open database connection
		this.m_objDB = DriverManager.getConnection(t_strURL, t_database_user,
				t_database_pw);
	}

	/**
	 * @return
	 */
	public ResultSet getFragmentsAX() throws SQLException 
	{
		String t_strQuery = "SELECT gf.* , gr.abbr FROM " + this.m_strSchema + ".fragment_ax as gf LEFT JOIN " 
				+ this.m_strSchema + ".residue as gr ON gf.residue_id=gr.residue_id ORDER BY fragment_ax_id";
		PreparedStatement t_objStatement = this.m_objDB.prepareStatement( t_strQuery) ;
		return t_objStatement.executeQuery();
	}

	/**
	 * @return
	 */
	public ResultSet getFragmentsOther() throws SQLException
	{
		String t_strQuery = "SELECT gf.* , gr.abbr FROM " + this.m_strSchema + ".fragment_other as gf LEFT JOIN " 
				+ this.m_strSchema + ".residue as gr ON gf.residue_id=gr.residue_id ORDER BY fragment_other_id";
		PreparedStatement t_objStatement = this.m_objDB.prepareStatement( t_strQuery) ;
		return t_objStatement.executeQuery();
	}

	/**
	 * @return
	 */
	public ResultSet getResidues() throws SQLException
	{
		String t_strQuery = "SELECT * FROM " + this.m_strSchema + ".residue ORDER BY residue_id";
		PreparedStatement t_objStatement = this.m_objDB.prepareStatement( t_strQuery) ;
		return t_objStatement.executeQuery();
	}

	/**
	 * @return
	 */
	public ResultSet getPersubstitution() throws SQLException 
	{
		String t_strQuery = "SELECT * FROM " + this.m_strSchema + ".persubstitution ORDER BY persubstitution_id";
		PreparedStatement t_objStatement = this.m_objDB.prepareStatement( t_strQuery) ;
		return t_objStatement.executeQuery();
	}

	/**
	 * @return
	 */
	public ResultSet getIons() throws SQLException 
	{
		String t_strQuery = "SELECT * FROM " + this.m_strSchema + ".ions ORDER BY \"order\"";
		PreparedStatement t_objStatement = this.m_objDB.prepareStatement( t_strQuery) ;
		return t_objStatement.executeQuery();
	}

	/**
	 * @return
	 */
	public ResultSet getDerivatisations() throws SQLException
	{
		String t_strQuery = "SELECT * FROM " + this.m_strSchema + ".derivates ORDER BY derivates_id";
		PreparedStatement t_objStatement = this.m_objDB.prepareStatement( t_strQuery) ;
		return t_objStatement.executeQuery();
	}

	/**
	 * @return
	 */
	public ResultSet getMolecules() throws SQLException
	{
		String t_strQuery = "SELECT * FROM " + this.m_strSchema + ".small_molecules ORDER BY \"order\"";
		PreparedStatement t_objStatement = this.m_objDB.prepareStatement( t_strQuery) ;
		return t_objStatement.executeQuery();
	}
}
