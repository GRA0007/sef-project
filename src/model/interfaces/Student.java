package model.interfaces;

import model.StaffImpl;

public interface Student extends User {

	void sendCommentEmail(Comment comment);

	void addStudentExemption(StaffImpl staffMember, String courseCode);
	
}
