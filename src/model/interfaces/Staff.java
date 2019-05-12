package model.interfaces;



/**
 * @author andy
 *	This interface is for staff specifics only, it allows more incorporation of access privileges when staff 
 *	interacts with course exemption status and program structure 
 */
public interface Staff {

	boolean hasAuthorityAccess();

	void setAuthority(boolean authority);

	String getDepartment();
}
