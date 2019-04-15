package model.interfaces;

import model.StaffImpl;

public interface Student extends User {

	public abstract void addStudentExemption(StaffImpl staffMember, String courseCode);
	
}
