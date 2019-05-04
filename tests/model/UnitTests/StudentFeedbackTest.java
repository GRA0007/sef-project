package model.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Student;
import model.StudentFeedback;

class StudentFeedbackTest
{
	StudentFeedback sf;

	Student s4 = new Student("s2156883", "Boyer", "Billie-Jo",
			"86 Charles Street Collingwood VIC", "0443389756", "s2156883@student.rmit.edu.au");
	
	@BeforeEach
	void setUp() throws Exception
	{
		sf = new StudentFeedback(s4, "Database Concepts", "Grade issue", "Investigating");
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void test()
	{
		System.out.println(sf.toString());
	}

}
