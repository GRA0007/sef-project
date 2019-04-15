package model.interfaces;

import model.StaffImpl;

public interface Student extends User {

	void addStudentExemption(StaffImpl staffMember, String courseCode);
	
}
