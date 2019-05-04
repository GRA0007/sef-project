package model.UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.AtRiskStudent;
import model.Student;

public class AtRiskStudentTest
{
	AtRiskStudent ar1;
	
	Student s1 = new Student("s3127736", "Paul", "Ryan",
			"51/67 Curby Lane Carlton Vic", "0478534522", "s3127736@student.rmit.edu.au");

	@Before
	public void setUp() throws Exception
	{
		ar1 = new AtRiskStudent(s1, 2, "Mental Health Issues", "Seek professional advice");
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test
	public void test()
	{
		System.out.println(ar1.toString());
		fail("Not yet implemented");
	}

}
