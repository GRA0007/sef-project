package model;

import model.interfaces.Comment;
import model.interfaces.Student;

import java.util.HashMap;
import java.util.Map;

import model.StaffImpl;

public class StudentImpl extends AbstractUser implements Student
{

	Map<String, ExemptionImpl> studentExemptions = new HashMap<String, ExemptionImpl>();
	
	public StudentImpl(String userID, String famName, String givenName, String address, 
			String phoneNo, String email)
	{
		super(userID, famName, givenName, address, phoneNo, email);
	}
	
	@Override
	public void addStudentExemption(StaffImpl staffMember, String courseCode)
	{	
		studentExemptions.put(courseCode, new ExemptionImpl(this.userID, staffMember.userID, courseCode,
				staffMember.authorityAccess()));
	}

    @Override
    public void sendCommentEmail(Comment comment) {

    }
}
