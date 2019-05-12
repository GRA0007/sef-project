package model.UnitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Student;
import model.Substitution;

import java.util.Date;

class SubstitutionTest
{
	Substitution st;
	
	Student s1 = new Student("s3127736", "Paul", "Ryan",
			"51/67 Curby Lane Carlton Vic", "0478534522", "s3127736@student.rmit.edu.au");

	@BeforeEach
	void setUp() throws Exception
	{
		st = new Substitution(s1, "Programming Techniques", "Further Programming", "Has shown adequate ability", new Date());
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
