package model;

import java.util.HashMap;
import java.util.Map;

public class Student extends AbstractUser
{
	Map<String, Exemption> studentExemptions = new HashMap<String, Exemption>();
	
	public Student(String userID, String famName, String givenName, String address,
				   String phoneNo, String email)
	{
		super(userID, famName, givenName, address, phoneNo, email);
	}
}
