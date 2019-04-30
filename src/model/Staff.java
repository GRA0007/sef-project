package model;

public class Staff extends AbstractUser
{

	private String department;
	private int authority; // Basic privacy method that enables access to certain student information

	private String staffTitle; // At the moment this serves as a label for for staff's position title
								// for example, Course Coordinator or Program Manager
<<<<<<< HEAD:src/model/StaffImpl.java

	public StaffImpl(String userID, String famName, String givenName, String address, String phoneNo, String email,
			String department, String staffTitle, int authority)
=======
	
	
	public Staff(String userID, String famName, String givenName, String address,
                 String phoneNo, String email,
                 String department, String staffTitle, boolean authority)
>>>>>>> master:src/model/Staff.java
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

<<<<<<< HEAD:src/model/StaffImpl.java
	@Override
	public int authorityAccessLevel() // retrieves if the staff member has authority to access sensitive details
=======
	public boolean authorityAccess()	//retrieves if the staff member has authority to access sensitive details
>>>>>>> master:src/model/Staff.java
	{
		return authority;
	}
	
	@Override
	public boolean hasAuthorityAccess()
	{
		return authority == 3 ? true : false;
	}

<<<<<<< HEAD:src/model/StaffImpl.java
	@Override
	public void setAuthority(int authority) // sets staff accessibility privileges
=======
	public void setAuthority(boolean enable)	//sets staff accessibility privileges
>>>>>>> master:src/model/Staff.java
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

	public void setAuthority(int authority) {

	}
}
