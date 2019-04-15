package model.interfaces;

/**
 * @author andy
 * This is the overall template for members of the student crm, including staff, students and possible 
 * external users in future versions.
 * 
 * Bellow are basic accessor methods.
 */
public interface User {
	
	public abstract String getID();
	
	public abstract String getName();
	
	public abstract String getPhoneNO();
	
	public abstract String getAddress();
	
	@Override
	public abstract String toString();
}
