package model.UnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Student;
import model.Substitutions;

class SubstitutionsTest
{
	Substitutions st;
	
	Student s1 = new Student("s3127736", "Paul", "Ryan",
			"51/67 Curby Lane Carlton Vic", "0478534522", "s3127736@student.rmit.edu.au");

	@BeforeEach
	void setUp() throws Exception
	{
		st = new Substitutions(s1, "Programming Techniques", "Further Programming", "Has shown adequate ability");		
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void test()
	{
		System.out.println(st.toString());	
	}

}
