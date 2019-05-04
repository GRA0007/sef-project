package model;

public class Student extends AbstractUser
{
	private ProgramStructure structure;

	Student(String userID, String famName, String givenName, String address,
				   String phoneNo, String email) {
		super(userID, famName, givenName, address, phoneNo, email);
	}

	public ProgramStructure getProgramStructure() {
		return structure;
	}

    public void sendCommentEmail(Comment comment) {
		System.out.println("Sending email...");
    }
}
