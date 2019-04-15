package model.interfaces;

/**
 * @author andy
 * This is the overall template for members of the student crm, including staff, students and possible 
 * external users in future versions.
 * 
 * Bellow are basic accessor methods.
 */
public interface User {
	
	String getID();
	
	String getName();
	
	String getPhoneNO();
	
	String getAddress();
	
	@Override
	String toString();
}
