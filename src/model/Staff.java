package model;

public class Staff extends AbstractUser implements model.interfaces.Staff
{

	private String department;
	private boolean authority; // Basic privacy method that enables access to certain student information

	private String staffTitle; // At the moment this serves as a label for for staff's position title
								// for example, Course Coordinator or Program Manager

	public Staff(String userID, String famName, String givenName, String address, String phoneNo, String email,
			String department, String staffTitle, boolean authority)

	{
		super(userID, famName, givenName, address, phoneNo, email);

		this.department = getFormattedString(department);
		this.staffTitle = getFormattedString(staffTitle);
		this.authority = authority;
	}

	
	@Override
	public boolean hasAuthorityAccess()
	{
		return authority;
	}

	@Override
	public void setAuthority(boolean authority) // sets staff accessibility privileges

	{
		this.authority = authority;
	}

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
