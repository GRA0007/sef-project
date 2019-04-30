package model;

<<<<<<< HEAD:src/model/StudentImpl.java
import model.interfaces.Comment;
import model.interfaces.Student;
=======
import model.interfaces.CommentInt;
>>>>>>> master:src/model/Student.java

import java.util.HashMap;
import java.util.Map;

public class Student extends AbstractUser
{

<<<<<<< HEAD:src/model/StudentImpl.java
	Map<String, ExemptionImpl> studentExemptions = new HashMap<String, ExemptionImpl>();

	public StudentImpl(String userID, String famName, String givenName, String address, String phoneNo, String email)
	{
		super(userID, famName, givenName, address, phoneNo, email);
	}

	@Override
	public void addStudentExemption(StaffImpl staffMember, String courseCode)
	{
		studentExemptions.put(courseCode, new ExemptionImpl(this.userID, staffMember.userID, courseCode,
				staffMember.hasAuthorityAccess()));
	}

	@Override
	public void sendCommentEmail(Comment comment)
	{
		// TODO Auto-generated method stub

=======
	Map<String, Exemption> studentExemptions = new HashMap<String, Exemption>();
	
	public Student(String userID, String famName, String givenName, String address,
				   String phoneNo, String email)
	{
		super(userID, famName, givenName, address, phoneNo, email);
	}
	
	public void addStudentExemption(Staff staffMember, String courseCode)
	{	
		studentExemptions.put(courseCode, new Exemption(this.userID, staffMember.userID, courseCode,
				staffMember.authorityAccess()));
>>>>>>> master:src/model/Student.java
	}

    public void sendCommentEmail(CommentInt comment) {

    }
}
