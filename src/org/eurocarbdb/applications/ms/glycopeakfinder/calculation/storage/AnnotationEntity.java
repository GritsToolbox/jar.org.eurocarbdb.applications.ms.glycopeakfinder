/**
 * 
 */
package org.eurocarbdb.applications.ms.glycopeakfinder.calculation.storage;

/**
 * Stores the settings for an annotations.
 * The object stores the number of occurrence of this annotation and the id of the annotation.
 * Id of the annotation can be the name of the residue, name of the fragment etc. 
 *  
 * @author Logan
 */
public class AnnotationEntity 
{
    private String m_strID = null;
    private int m_iNumber = 0;
    
    /**
     * Sets number of occurrence of this annotation. 
     * @param a_iNumber	
     */
    public void setNumber(int a_iNumber)
    {
        this.m_iNumber = a_iNumber;
    }
    
    /**
     * Give the number of occurrence of this annotation.
     * @return
     */
    public int getNumber()
    {
        return this.m_iNumber;
    }
    
    /**
     * Sets the id of this annotation. 
     * @param a_strId
     */
    public void setId(String a_strId)
    {
        this.m_strID = a_strId;
    }
    
    /**
     * Give the id of this annotation.
     * @return
     */
    public String getId()
    {
        return this.m_strID;
    }
    
    /**
     * Creates a copy of this annotation object.
     * @return
     */
    public AnnotationEntity copy()
    {
    	AnnotationEntity t_objAnnotation = new AnnotationEntity();
    	t_objAnnotation.setNumber(this.m_iNumber);
    	t_objAnnotation.setId(new String(this.m_strID));
    	return t_objAnnotation;
    }
}