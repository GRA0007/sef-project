package model;

import model.interfaces.Staff;

public class StaffImpl extends AbstractUser implements Staff
{

	private String department;
	private int authority; // Basic privacy method that enables access to certain student information

	private String staffTitle; // At the moment this serves as a label for for staff's position title
								// for example, Course Coordinator or Program Manager

	public StaffImpl(String userID, String famName, String givenName, String address, String phoneNo, String email,
			String department, String staffTitle, int authority)
	{
		super(userID, famName, givenName, address, phoneNo, email);

		this.department = getFormattedString(department);
		this.staffTitle = getFormattedString(staffTitle);
		this.authority = authority;
	}

	@Override
	public String getID()
	{
		return this.userID;
	}

	@Override
	public int authorityAccessLevel() // retrieves if the staff member has authority to access sensitive details
	{
		return authority;
	}
	
	@Override
	public boolean hasAuthorityAccess()
	{
		return authority == 3 ? true : false;
	}

	@Override
	public void setAuthority(int authority) // sets staff accessibility privileges
	{
		this.authority = authority;
	}

	@Override
	public String getDepartment()
	{
		return department;
	}

	@Override
	public String toString()
	{
		return super.toString()
				+ String.format(":%s:%s:%s", this.department, this.staffTitle, this.authority).toUpperCase();
	}

}
