package model;

public class Staff extends AbstractUser
{

	private String department;
	private boolean authority;	//Basic privacy method that enables access to certain student information
	
	private String staffTitle; 	// At the moment this serves as a label for for staff's position title
								// for example, Course Coordinator or Program Manager
	
	
	public Staff(String userID, String famName, String givenName, String address,
                 String phoneNo, String email,
                 String department, String staffTitle, boolean authority)
	{
		super(userID, famName, givenName, address, phoneNo, email);
		
		this.department = getFormattedString(department);
		this.staffTitle = getFormattedString(staffTitle);
		this.authority = authority;	
	}

	public boolean authorityAccess()	//retrieves if the staff member has authority to access sensitive details
	{
		return authority;
	}

	public void setAuthority(boolean enable)	//sets staff accessibility privileges
	{
		this.authority = enable;
	}

	public String getDepartment()
	{
		return department;
	}

	@Override
	public String toString()
	{
		return super.toString() + String.format(":%s:%s:%s", this.department, 
				this.staffTitle, this.authority ? "Approved" : "Not_Approved").toUpperCase();
	}

	public void setAuthority(int authority) {

	}
}
